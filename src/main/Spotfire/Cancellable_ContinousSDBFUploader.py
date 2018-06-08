import time
from System.IO import StreamReader
from System.Net import HttpWebRequest
from Spotfire.Dxp.Framework.Library import LibraryManager, LibraryItemType, LibraryItemRetrievalOption
from Spotfire.Dxp.Framework.ApplicationModel import ProgressService

ps = Application.GetService[ProgressService]()

# Spotfire Server path for upload : "/Users/4c73owwy_USER_ID_benrwd39sfz/Public/fr-rcq-test/"
folder = Document.Properties["SpotfireServerFolder"]
# "http://localhost:8090/sbdf-generator/1.0/"
rcqBackendURI = Document.Properties["SDBFGeneratorURL"]
# Sleep time in seconds (decimal accepted)
sleep_time = Document.Properties["SleepTime"]

ps.CurrentProgress.ExecuteSubtask("folder        =" + folder)
ps.CurrentProgress.ExecuteSubtask("rcqBackendURI =" + rcqBackendURI)
ps.CurrentProgress.ExecuteSubtask("sleep_time    =" + str(sleep_time))
ps.CurrentProgress.ExecuteSubtask("Configuration Retrieved")


def upload_one_file(data_table):
    file_name = data_table.Name
    lm = Application.GetService(LibraryManager)
    ps.CurrentProgress.ExecuteSubtask(file_name + " - start")

    web_request = HttpWebRequest.Create(rcqBackendURI+file_name)
    response = web_request.GetResponse()
    stream_reader = StreamReader(response.GetResponseStream())
    json_data = stream_reader.ReadToEnd()
    ps.CurrentProgress.CheckCancel()

    ps.CurrentProgress.ExecuteSubtask(file_name + ": " + str(json_data))
    ps.CurrentProgress.ExecuteSubtask(file_name + " - SDBF file re-generated")
    data_table.Refresh()
    ps.CurrentProgress.CheckCancel()
    ps.CurrentProgress.ExecuteSubtask(file_name + " - Analysis DataTable Refreshed")

    try:
        (found, item) = lm.TryGetItem(folder+file_name, LibraryItemType.SbdfDataFile, LibraryItemRetrievalOption.IncludeProperties)
        if found:
            data_table.ExportDataToLibrary(item, file_name)
            ps.CurrentProgress.ExecuteSubtask(file_name+" - exported (ow)")
        else:
            (found2, item2) = lm.TryGetItem(folder, LibraryItemType.Folder, LibraryItemRetrievalOption.IncludeProperties)
            if found2:
                data_table.ExportDataToLibrary(item2, file_name)
                ps.CurrentProgress.ExecuteSubtask(file_name+" - exported (1st)")
    except Exception as e:
        ps.CurrentProgress.ExecuteSubtask("Exception occurred on " + file_name + " - " + str(e))


#
# Spotfire Access : updated every 15seconds in production. The Analysis has only spotfire_access loaded.
# Other tables (spotfire_access not loaded)
#  * Sleep time set to 60 seconds.
#  * Every iteration, tronc_queteur, queteur, named_donation are updated
#  * Every 5 iteration (5minutes):  the rest is updated  (i % 5 == 0)
#
#
def execute():
    try:
        i = 0
        while True:
            for one_table in Document.Data.Tables:

                ps.CurrentProgress.CheckCancel()
                table_name = one_table.Name

                if table_name == "spotfire_access" \
                        or table_name == "tronc_queteur" \
                        or table_name == "queteur" \
                        or table_name == "named_donation" \
                        or i % 5 == 0:
                    upload_one_file(one_table)

                ps.CurrentProgress.CheckCancel()

            i += 1

            ps.CurrentProgress.ExecuteSubtask("All tables refreshed, sleeping " + str(sleep_time) + "s")
            j = 0
            while j < sleep_time:
                time.sleep(1)
                ps.CurrentProgress.CheckCancel()
                j += 1

            ps.CurrentProgress.ExecuteSubtask("waking up after " + str(sleep_time) + "s")

    except BaseException as e:  # user canceled
        print("Cancellation, exception: " + str(e))
        ps.CurrentProgress.ExecuteSubtask("Export Stopped")
        print("end of exec")


# Launch the cancellable execution
ps.ExecuteWithProgress("Continuous SDBF Uploader", "SDBF Upload in progress", execute)

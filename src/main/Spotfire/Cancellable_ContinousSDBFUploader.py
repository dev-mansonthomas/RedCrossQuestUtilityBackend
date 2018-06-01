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
# "C:/RedCrossQuest/SpotfireUpdate-test.html"
outputFilePath = Document.Properties["outputFilePath"]

sleep_time = Document.Properties["SleepTime"]

lm = Application.GetService(LibraryManager)
table = Document.ActiveDataTableReference

ps.CurrentProgress.ExecuteSubtask("folder        =" + folder)
ps.CurrentProgress.ExecuteSubtask("rcqBackendURI =" + rcqBackendURI)
ps.CurrentProgress.ExecuteSubtask("outputFilePath=" + outputFilePath)
ps.CurrentProgress.ExecuteSubtask("sleep_time    =" + str(sleep_time))
ps.CurrentProgress.ExecuteSubtask("Configuration Retrieved")


def upload_one_file(data_table):
    file_name = data_table.Name
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
            table.ExportDataToLibrary(item, file_name)
            ps.CurrentProgress.ExecuteSubtask(file_name+" - exported (ow)")
        else:
            (found2, item2) = lm.TryGetItem(folder, LibraryItemType.Folder, LibraryItemRetrievalOption.IncludeProperties)
            if found2:
                table.ExportDataToLibrary(item2, file_name)
                ps.CurrentProgress.ExecuteSubtask(file_name+" - exported (1st)")
    except Exception as e:
        ps.CurrentProgress.ExecuteSubtask("Exception Occured:" + str(e))


def execute():
    try:
        while True:
            for one_table in Document.Data.Tables:
                ps.CurrentProgress.CheckCancel()
                upload_one_file(one_table)
                ps.CurrentProgress.CheckCancel()

            ps.CurrentProgress.ExecuteSubtask("All tables refreshed, sleeping " + str(sleep_time) + "s")
            time.sleep(sleep_time)
            ps.CurrentProgress.ExecuteSubtask("waking up after " + str(sleep_time) + "s")

    except BaseException as e:  # user canceled
        print("Cancellation, exception: " + str(e))
        ps.CurrentProgress.ExecuteSubtask("Export Stopped")
        print("end of exec")


# Launch the cancellable execution
ps.ExecuteWithProgress("Continuous SDBF Uploader", "SDBF Upload in progress", execute)

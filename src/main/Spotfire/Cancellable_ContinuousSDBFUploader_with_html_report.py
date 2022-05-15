import sys, datetime, time
from System.IO                                import StreamWriter, StreamReader
from System.Net                               import HttpWebRequest
from Spotfire.Dxp.Framework.Library           import LibraryManager, LibraryItemType, LibraryItem, LibraryItemRetrievalOption
from Spotfire.Dxp.Application.Visuals         import HtmlTextArea
from Spotfire.Dxp.Framework.ApplicationModel  import *

print "Starting"
ps = Application.GetService[ProgressService]()

# Spotfire Server path for upload : "/Users/3c74owwyq2yp63mlspdhjaenrwb34sfa/Public/fr-rcq-test/"
folder         = Document.Properties["SpotfireServerFolder"]
# "http://localhost:8090/sbdf-generator/1.0/"
rcqBackendURI  = Document.Properties["SBDFGeneratorURL"]
# "C:/RedCrossQuest/SpotfireUpdate-test.html"
outputFilePath = Document.Properties["outputFilePath"]
lm    = Application.GetService(LibraryManager)

def uploadOneFile(dataTable):
  outputFile = StreamWriter(outputFilePath,"a")
  fileName   = dataTable.Name
  outputFile.Write("<p>" + str(datetime.datetime.now())+" - " + fileName +" - start <br/>\n")
  
  webRequest = HttpWebRequest.Create(rcqBackendURI+fileName)
  response = webRequest.GetResponse()
  streamReader = StreamReader(response.GetResponseStream())
  jsonData = streamReader.ReadToEnd()
  ps.CurrentProgress.CheckCancel()
  
  outputFile.Write( str(datetime.datetime.now())+" - " + fileName+" "+ str(jsonData)+"<br/>\n")
  
  outputFile.Write( str(datetime.datetime.now())+" - " + fileName+" - SBDF file re-generated <br/>\n")
  dataTable.Refresh()
  ps.CurrentProgress.CheckCancel()
  outputFile.Write( str(datetime.datetime.now())+" - " + fileName+" - Analysis Refreshed <br/>\n")
  
  
  try:
    (found, item) = lm.TryGetItem(folder+fileName, LibraryItemType.SbdfDataFile, LibraryItemRetrievalOption.IncludeProperties)
    if found:
      table.ExportDataToLibrary(item, fileName)
      outputFile.Write( str(datetime.datetime.now())+" - " + fileName+" - exported (ow) <br/>\n")
    else:
      (found2, item2) = lm.TryGetItem(folder, LibraryItemType.Folder, LibraryItemRetrievalOption.IncludeProperties)
      if found2:
        table.ExportDataToLibrary(item2, fileName)
        outputFile.Write(str(datetime.datetime.now())+" - " +  fileName+" - exported (1st) <br/>\n")
  except Exception as e:
    outputFile.Write( str(datetime.datetime.now())+" - " + "Exception Occured:"+ str(e) +" <br/>\n")
    
  outputFile.Write("</p>\n")
  outputFile.Close()
 
 


def execute():
  try:
    table = Document.ActiveDataTableReference

    outputFile     = StreamWriter(outputFilePath,"w+")
    outputFile.Write("<html><head><title>Spotfire SBDF Uploader</title></head><body><script>setTimeout(function(){window.location.reload(true);}, 5000);</script><div style='font-size:16px;padding:12px;'>\n")
    outputFile.Write("<p>Export Folder is '"+folder+"'</p>\n")
    outputFile.Close()
    
    print "start infinite loop"
    while True:
      print "START refreshing all tables"
      for table in Document.Data.Tables:
        print "Processing - "+table.Name+""
        ps.CurrentProgress.ExecuteSubtask("Processing - "+table.Name+"");
        uploadOneFile(table)
        print "Processing - "+table.Name+" - DONE"
        ps.CurrentProgress.CheckCancel()
        print "Processing - "+table.Name+" - DONE CheckCancel"
      print "END refreshing all tables"
    
      ps.CurrentProgress.CheckCancel()
      print "CheckCancel Done, sleeping 10ms"
      time.sleep(10)
      print "waking up"
    
  except BaseException as e: # user canceled
    print "Cancelation, excpetion: "+ str(e)
    outputFile     = StreamWriter(Document.Properties["outputFilePath"],"a")
    outputFile.Write( str(e)+" - Export Stopped")
    outputFile.Write( str(datetime.datetime.now())+" - Export Stopped") 
    outputFile.Write( "</div></body></html>")
    outputFile.Close()
    print "end of exec"
    pass

#Launch the cancellable execution     
ps.ExecuteWithProgress("Continuous SBDF Uploader", "SBDF Upload in progress", execute) 

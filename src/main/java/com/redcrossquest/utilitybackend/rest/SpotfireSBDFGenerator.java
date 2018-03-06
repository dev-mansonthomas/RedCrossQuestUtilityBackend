package com.redcrossquest.utilitybackend.rest;


import com.redcrossquest.utilitybackend.model.rowMapper.*;
import com.redcrossquest.utilitybackend.services.ExportDataService;
import com.spotfire.sbdf.BinaryWriter;
import com.spotfire.sbdf.FileHeader;
import com.spotfire.sbdf.TableMetadata;
import com.spotfire.sbdf.TableWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/sbdf-generator/1.0")
public class SpotfireSBDFGenerator implements InitializingBean
{
  private static final Logger LOGGER = LoggerFactory.getLogger(SpotfireSBDFGenerator.class);

  @Autowired
  private ExportDataService exportDataService;

  @Value("${utilitybackend.files.folder}")
  private String temporaryFolder;

  @Value("${utilitybackend.files.folder}/${utilitybackend.files.spotfire_access}")
  private String spotfireAccessOutputFile;

  @Value("${utilitybackend.files.folder}/${utilitybackend.files.tronc_queteur}")
  private String troncQueteurOutputFile;

  @Value("${utilitybackend.files.folder}/${utilitybackend.files.tronc}")
  private String troncOutputFile;

  @Value("${utilitybackend.files.folder}/${utilitybackend.files.queteur}")
  private String queteurOutputFile;

  @Value("${utilitybackend.files.folder}/${utilitybackend.files.point_quete}")
  private String pointQueteOutputFile;

  @Value("${utilitybackend.files.folder}/${utilitybackend.files.ul}")
  private String ulOutputFile;

  @Value("${utilitybackend.files.folder}/${utilitybackend.files.named_donation}")
  private String namedDonationOutputFile;

  @Value("${utilitybackend.files.folder}/${utilitybackend.files.daily_stats_before_rcq}")
  private String dailyStatsBeforeRCQOutputFile;

  @Value("${utilitybackend.files.folder}/${utilitybackend.files.yearly_goal}")
  private String yearlyGoalOutputFile;





  @Value("${utilitybackend.version}")
  private String version;


  @RequestMapping(value = "/spotfire_access", method = RequestMethod.GET, produces = "application/json")
  public String generateSpotfireAccess()
  {
    long         startDate    = System.currentTimeMillis();
    StringBuffer response     = new StringBuffer();

    OutputStream outputStream = null;
    BinaryWriter writer = null;
    try
    {
      outputStream  = new FileOutputStream(spotfireAccessOutputFile);
      writer        = new BinaryWriter(outputStream);

      FileHeader.writeCurrentVersion(writer);

      TableMetadata tableMetadata = SpotfireAccessRowMapper.generateTableMetadata(version);
      tableMetadata.write(writer);

      TableWriter tableWriter = new TableWriter(writer, tableMetadata);

      this.exportDataService.exportSpotfireAccess(tableWriter);

      tableWriter.writeEndOfTable();
    }
    catch(Exception e)
    {
      LOGGER.error("Error while generating spotfire_access SDBF File",  e);
      startDate = buildErrorResponse(startDate, "spotfire_access", spotfireAccessOutputFile, e, response);
    }
    finally
    {
      closeResources(outputStream, writer);
    }

    buildResponse(startDate, "spotfire_access", spotfireAccessOutputFile, response);
    return response.toString();
  }




  @RequestMapping(value = "/tronc_queteur", method = RequestMethod.GET, produces = "application/json")
  public String generateTroncQueteur()
  {
    long         startDate    = System.currentTimeMillis();
    StringBuffer response     = new StringBuffer("{[");
    OutputStream outputStream = null;
    BinaryWriter writer       = null;


    try
    {
      outputStream  = new FileOutputStream(troncOutputFile);
      writer        = new BinaryWriter    (outputStream);

      FileHeader.writeCurrentVersion(writer);

      TableMetadata tableMetadata = TroncRowMapper.generateTableMetadata(version);
      tableMetadata.write(writer);

      TableWriter tableWriter = new TableWriter(writer, tableMetadata);

      this.exportDataService.exportTronc(tableWriter);

      tableWriter.writeEndOfTable();
    }
    catch(Exception e)
    {
      LOGGER.error("Error while generating Tronc SDBF File",  e);
      startDate = buildErrorResponse(startDate, "tronc", troncOutputFile, e, response);
    }
    finally
    {
      closeResources(outputStream, writer);
    }

    startDate = buildResponse(startDate, "tronc", troncOutputFile, response);

    try
    {
      outputStream  = new FileOutputStream(queteurOutputFile);
      writer        = new BinaryWriter    (outputStream);

      FileHeader.writeCurrentVersion(writer);

      TableMetadata tableMetadata = QueteurRowMapper.generateTableMetadata(version);
      tableMetadata.write(writer);

      TableWriter tableWriter = new TableWriter(writer, tableMetadata);

      this.exportDataService.exportQueteur(tableWriter);

      tableWriter.writeEndOfTable();
    }
    catch(Exception e)
    {
      LOGGER.error("Error while generating Queteur SDBF File",  e);
      startDate = buildErrorResponse(startDate, "queteur", queteurOutputFile, e, response);
    }
    finally
    {
      closeResources(outputStream, writer);
    }
    startDate = buildResponse(startDate, "queteur", queteurOutputFile, response);
    try
    {
      outputStream  = new FileOutputStream(pointQueteOutputFile);
      writer        = new BinaryWriter    (outputStream);

      FileHeader.writeCurrentVersion(writer);

      TableMetadata tableMetadata = PointQueteRowMapper.generateTableMetadata(version);
      tableMetadata.write(writer);

      TableWriter tableWriter = new TableWriter(writer, tableMetadata);

      this.exportDataService.exportPointQuete(tableWriter);

      tableWriter.writeEndOfTable();
    }
    catch(Exception e)
    {
      LOGGER.error("Error while generating PointQuete SDBF File",  e);
      startDate = buildErrorResponse(startDate, "pointQuete", pointQueteOutputFile, e, response);

    }
    finally
    {
      closeResources(outputStream, writer);
    }
    startDate = buildResponse(startDate, "pointQuete", pointQueteOutputFile, response);

    try
    {
      outputStream  = new FileOutputStream(troncQueteurOutputFile);
      writer        = new BinaryWriter    (outputStream);

      FileHeader.writeCurrentVersion(writer);

      TableMetadata tableMetadata = TroncQueteurRowMapper.generateTableMetadata(version);
      tableMetadata.write(writer);

      TableWriter tableWriter = new TableWriter(writer, tableMetadata);

      this.exportDataService.exportTroncQueteur(tableWriter);

      tableWriter.writeEndOfTable();
    }
    catch(Exception e)
    {
      LOGGER.error("Error while generating troncQueteur SDBF File",  e);
      startDate = buildErrorResponse(startDate, "troncQueteur", troncQueteurOutputFile, e, response);

    }
    finally
    {
      closeResources(outputStream, writer);
    }

    buildResponse(startDate, "troncQueteur", troncQueteurOutputFile, response);

    return response.append("]}").toString();
  }

  @RequestMapping(value = "/named_donation", method = RequestMethod.GET, produces = "application/json")
  public String generateNamedDonation()
  {
    long         startDate    = System.currentTimeMillis();
    StringBuffer response     = new StringBuffer();


    OutputStream outputStream = null;
    BinaryWriter writer       = null;
    try
    {
      outputStream  = new FileOutputStream  (namedDonationOutputFile);
      writer        = new BinaryWriter      (outputStream);

      FileHeader.writeCurrentVersion(writer);

      TableMetadata tableMetadata = NamedDonationRowMapper.generateTableMetadata(version);
      tableMetadata.write(writer);

      TableWriter tableWriter = new TableWriter(writer, tableMetadata);

      this.exportDataService.exportNamedDonation(tableWriter);

      tableWriter.writeEndOfTable();
    }
    catch(Exception e)
    {
      LOGGER.error("Error while generating NamedDonation SDBF File",  e);
      startDate = buildErrorResponse(startDate, "namedDonation", namedDonationOutputFile, e, response);
    }
    finally
    {
      closeResources(outputStream, writer);
    }

    buildResponse(startDate, "namedDonation", namedDonationOutputFile, response);
    return response.toString();
  }


  @RequestMapping(value = "/yearly_goal", method = RequestMethod.GET, produces = "application/json")
  public String generateYearlyGoal()
  {
    long         startDate    = System.currentTimeMillis();
    StringBuffer response     = new StringBuffer();

    OutputStream outputStream = null;
    BinaryWriter writer       = null;
    try
    {
      outputStream  = new FileOutputStream  (yearlyGoalOutputFile);
      writer        = new BinaryWriter      (outputStream);

      FileHeader.writeCurrentVersion(writer);

      TableMetadata tableMetadata = YearlyGoalRowMapper.generateTableMetadata(version);
      tableMetadata.write(writer);

      TableWriter tableWriter = new TableWriter(writer, tableMetadata);

      this.exportDataService.exportYearlyGoal(tableWriter);

      tableWriter.writeEndOfTable();
    }
    catch(Exception e)
    {
      LOGGER.error("Error while generating YearlyGoal SDBF File",  e);
      startDate = buildErrorResponse(startDate, "yearlyGoal", yearlyGoalOutputFile, e, response);
    }
    finally
    {
      closeResources(outputStream, writer);
    }

    buildResponse(startDate, "yearlyGoal", yearlyGoalOutputFile, response);
    return response.toString();
  }


  @RequestMapping(value = "/daily_stats_before_rcq", method = RequestMethod.GET, produces = "application/json")
  public String generateDailyStatsBeforeRCQ()
  {
    long         startDate    = System.currentTimeMillis();
    StringBuffer response     = new StringBuffer();


    OutputStream outputStream = null;
    BinaryWriter writer       = null;
    try
    {
      outputStream  = new FileOutputStream  (dailyStatsBeforeRCQOutputFile);
      writer        = new BinaryWriter      (outputStream);

      FileHeader.writeCurrentVersion(writer);

      TableMetadata tableMetadata = DailyStatsBeforeRCQRowMapper.generateTableMetadata(version);
      tableMetadata.write(writer);

      TableWriter tableWriter = new TableWriter(writer, tableMetadata);

      this.exportDataService.exportDailyStatsBeforeRCQ(tableWriter);

      tableWriter.writeEndOfTable();
    }
    catch(Exception e)
    {
      LOGGER.error("Error while generating dailyStatsBeforeRCQ SDBF File",  e);
      startDate = buildErrorResponse(startDate, "dailyStatsBeforeRCQ", dailyStatsBeforeRCQOutputFile, e, response);
    }
    finally
    {
      closeResources(outputStream, writer);
    }

    buildResponse(startDate, "dailyStatsBeforeRCQ", dailyStatsBeforeRCQOutputFile, response);
    return response.toString();
  }


  @RequestMapping(value = "/ul", method = RequestMethod.GET, produces = "application/json")
  public String generateUL()
  {
    long         startDate    = System.currentTimeMillis();
    StringBuffer response     = new StringBuffer();


    OutputStream outputStream = null;
    BinaryWriter writer       = null;
    try
    {
      outputStream  = new FileOutputStream  (ulOutputFile);
      writer        = new BinaryWriter      (outputStream);

      FileHeader.writeCurrentVersion(writer);

      TableMetadata tableMetadata = ULRowMapper.generateTableMetadata(version);
      tableMetadata.write(writer);

      TableWriter tableWriter = new TableWriter(writer, tableMetadata);

      this.exportDataService.exportUL(tableWriter);

      tableWriter.writeEndOfTable();
    }
    catch(Exception e)
    {
      LOGGER.error("Error while generating UL SDBF File",  e);
      startDate = buildErrorResponse(startDate, "ul", ulOutputFile, e, response);
    }
    finally
    {
      closeResources(outputStream, writer);
    }

    buildResponse(startDate, "ul", ulOutputFile, response);
    return response.toString();
  }


  private static void closeResources(OutputStream outputStream, BinaryWriter writer)
  {
    try
    {
      if(writer != null)
      {
        writer.close();
      }
      if(outputStream!=null)
      {
        outputStream.close();
      }
    }
    catch(Exception ee)
    {
      LOGGER.error("Error while closing writer or outputstream",ee);
    }
  }

  private static long buildResponse(long startDate, String tableName,  String outputFile, StringBuffer response)
  {

    int nbOfMilliSeconds      = (int)(System.currentTimeMillis()-startDate);
    long size = (new File(outputFile)).length();

    response.append("{'status':'OK', 'table':'");
    response.append(tableName);
    response.append("', 'file':'");
    response.append(outputFile);
    response.append("', 'size':");
    response.append(size);
    response.append(", 'executionTimeInMs':");
    response.append(nbOfMilliSeconds);
    response.append("}");

    return System.currentTimeMillis();
  }

  private static long buildErrorResponse(long startDate, String tableName,  String outputFile, Exception e, StringBuffer response)
  {
    int nbOfMilliSeconds      = (int)(System.currentTimeMillis()-startDate);

    response.append("{'status':'ERROR', 'table':'");
    response.append(tableName);
    response.append("', 'file':'");
    response.append(outputFile);
    response.append(", 'executionTimeInMs':");
    response.append(nbOfMilliSeconds);
    response.append("', 'message':'");
    response.append(e.getMessage());
    response.append("'}");

    return System.currentTimeMillis();
  }


  @Override
  public void afterPropertiesSet() throws Exception
  {
    File folder = new File(this.temporaryFolder);

    if(!folder.exists())
    {
      folder.mkdirs();
    }
  }
}

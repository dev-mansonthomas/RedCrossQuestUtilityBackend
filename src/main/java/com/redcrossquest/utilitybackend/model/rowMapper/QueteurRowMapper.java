package com.redcrossquest.utilitybackend.model.rowMapper;

import com.redcrossquest.utilitybackend.model.NullDTO;
import com.redcrossquest.utilitybackend.services.impl.ExportDataImpl;
import com.spotfire.sbdf.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueteurRowMapper extends RowMapperHelper implements RowMapper<NullDTO>
{
  private TableWriter tableWriter;


  public QueteurRowMapper(final TableWriter tableWriter)
  {
    this.tableWriter = tableWriter;
  }

  public NullDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    this.tableWriter.addValue(getValue(rs.getInt       ("id"                ), ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getString    ("first_name"        ), ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("last_name"         ), ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("email"             ), ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getInt       ("secteur"           ), ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getString    ("nivol"             ), ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("mobile"            ), ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("created"           ), ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("updated"           ), ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getString    ("notes"             ), ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getInt       ("ul_id"             ), ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getDate      ("birthdate"         ), ValueType.DATE    ));
    this.tableWriter.addValue(getValue(rs.getBoolean   ("man"               ), ValueType.BOOL    ));
    this.tableWriter.addValue(getValue(rs.getBoolean   ("active"            ), ValueType.BOOL    ));
    this.tableWriter.addValue(getValue(rs.getBoolean   ("qr_code_printed"   ), ValueType.BOOL    ));
    this.tableWriter.addValue(getValue(rs.getInt       ("referent_volunteer"), ValueType.INT     ));


    return null;
  }


  public static TableMetadata generateTableMetadata(final String version)
  {
    TableMetadataBuilder tableMetadataBuilder = new TableMetadataBuilder();

    tableMetadataBuilder.addProperty("GeneratedBy", "RCQUtilityBackend Version '"+version+"'");
    tableMetadataBuilder.addProperty(new MetadataProperty("SQLQuery", ValueType.STRING, ExportDataImpl.QUERY_FOR_GET_QUETEUR));

    tableMetadataBuilder.addColumn(new ColumnMetadata("id"                , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("first_name"        , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("last_name"         , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("email"             , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("secteur"           , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("nivol"             , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("mobile"            , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("created"           , ValueType.DATETIME));
    tableMetadataBuilder.addColumn(new ColumnMetadata("updated"           , ValueType.DATETIME));
    tableMetadataBuilder.addColumn(new ColumnMetadata("notes"             , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("ul_id"             , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("birthdate"         , ValueType.DATE    ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("man"               , ValueType.BOOL    ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("active"            , ValueType.BOOL    ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("qr_code_printed"   , ValueType.BOOL    ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("referent_volunteer", ValueType.INT     ));

    return tableMetadataBuilder.build();
  }
}

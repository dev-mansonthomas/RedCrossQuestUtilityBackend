package com.redcrossquest.utilitybackend.model.rowMapper;

import com.redcrossquest.utilitybackend.model.NullDTO;
import com.redcrossquest.utilitybackend.services.impl.ExportDataImpl;
import com.spotfire.sbdf.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TroncRowMapper extends RowMapperHelper implements RowMapper<NullDTO>
{
  private TableWriter tableWriter;


  public TroncRowMapper(final TableWriter tableWriter)
  {
    this.tableWriter = tableWriter;
  }

  public NullDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    this.tableWriter.addValue(getValue(rs.getInt       ("id"             ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("ul_id"          ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("created"        ),ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getBoolean   ("enabled"        ),ValueType.BOOL    ));
    this.tableWriter.addValue(getValue(rs.getString    ("notes"          ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getInt       ("type"           ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getBoolean   ("qr_code_printed"),ValueType.BOOL    ));


    return null;
  }


  public static TableMetadata generateTableMetadata(final String version)
  {
    TableMetadataBuilder tableMetadataBuilder = new TableMetadataBuilder();

    tableMetadataBuilder.addProperty("GeneratedBy", "RCQUtilityBackend Version '"+version+"'");
    tableMetadataBuilder.addProperty(new MetadataProperty("SQLQuery", ValueType.STRING, ExportDataImpl.QUERY_FOR_GET_TRONC));

    tableMetadataBuilder.addColumn(new ColumnMetadata("id"                     , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("ul_id"                  , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("created"                , ValueType.DATETIME ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("enabled"                , ValueType.BOOL     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("notes"                  , ValueType.STRING   ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("type"                   , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("qr_code_printed"        , ValueType.BOOL     ));


    return tableMetadataBuilder.build();
  }
}

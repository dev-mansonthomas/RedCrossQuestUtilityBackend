package com.redcrossquest.utilitybackend.model.rowMapper;

import com.redcrossquest.utilitybackend.model.NullDTO;
import com.redcrossquest.utilitybackend.services.impl.ExportDataImpl;
import com.spotfire.sbdf.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QueteurMailingStatusRowMapper extends RowMapperHelper implements RowMapper<NullDTO>
{
  private TableWriter tableWriter;


  public QueteurMailingStatusRowMapper(final TableWriter tableWriter)
  {
    this.tableWriter = tableWriter;
  }

  public NullDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    this.tableWriter.addValue(getValue(rs.getInt       ("id"                 ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("queteur_id"         ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("year"               ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getString    ("status_code"        ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getInt       ("spotfire_opened"    ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("email_send_date"    ),ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("spotfire_open_date" ),ValueType.DATETIME));

    return null;
  }


  public static TableMetadata generateTableMetadata(final String version)
  {
    TableMetadataBuilder tableMetadataBuilder = new TableMetadataBuilder();

    tableMetadataBuilder.addProperty("GeneratedBy", "RCQUtilityBackend Version '"+version+"'");
    tableMetadataBuilder.addProperty(new MetadataProperty("SQLQuery", ValueType.STRING, ExportDataImpl.QUERY_FOR_GET_QUETEUR_MAILING_STATUS));

    tableMetadataBuilder.addColumn(new ColumnMetadata("id"                          , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("queteur_id"                  , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("year"                        , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("status_code"                 , ValueType.STRING   ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("spotfire_opened"             , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("email_send_date"             , ValueType.DATETIME ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("spotfire_open_date"          , ValueType.DATETIME ));

    return tableMetadataBuilder.build();
  }
}

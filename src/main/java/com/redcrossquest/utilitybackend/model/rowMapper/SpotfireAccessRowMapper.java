package com.redcrossquest.utilitybackend.model.rowMapper;

import com.redcrossquest.utilitybackend.model.NullDTO;
import com.redcrossquest.utilitybackend.services.impl.ExportDataImpl;
import com.spotfire.sbdf.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SpotfireAccessRowMapper extends RowMapperHelper implements RowMapper<NullDTO>
{
  private TableWriter tableWriter;


  public SpotfireAccessRowMapper(final TableWriter tableWriter)
  {
    this.tableWriter = tableWriter;
  }

  public NullDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    this.tableWriter.addValue(getValue(rs.getInt       ("id"                ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getString    ("token"             ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("token_expiration"  ),ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getInt       ("ul_id"             ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("user_id"           ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getString    ("nivol"             ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getInt       ("queteur_id"        ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("role"              ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getBoolean   ("active"            ),ValueType.BOOL    ));


    return null;
  }


  public static TableMetadata generateTableMetadata(final String version)
  {
    TableMetadataBuilder tableMetadataBuilder = new TableMetadataBuilder();

    tableMetadataBuilder.addProperty("GeneratedBy", "RCQUtilityBackend Version '"+version+"'");
    tableMetadataBuilder.addProperty(new MetadataProperty("SQLQuery", ValueType.STRING, ExportDataImpl.QUERY_FOR_GET_SPOTFIRE_ACCESS));

    tableMetadataBuilder.addColumn(new ColumnMetadata("id"              , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("token"           , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("token_expiration", ValueType.DATETIME));
    tableMetadataBuilder.addColumn(new ColumnMetadata("ul_id"           , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("user_id"         , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("nivol"           , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("queteur_id"      , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("role"            , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("active"          , ValueType.BOOL    ));

    return tableMetadataBuilder.build();
  }
}

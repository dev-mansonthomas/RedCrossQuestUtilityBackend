package com.redcrossquest.utilitybackend.model.rowMapper;

import com.redcrossquest.utilitybackend.model.NullDTO;
import com.redcrossquest.utilitybackend.services.impl.ExportDataImpl;
import com.spotfire.sbdf.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PointQueteRowMapper extends RowMapperHelper implements RowMapper<NullDTO>
{
  private TableWriter tableWriter;


  public PointQueteRowMapper(final TableWriter tableWriter)
  {
    this.tableWriter = tableWriter;
  }

  public NullDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    this.tableWriter.addValue(getValue(rs.getInt       ("id"                ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("ul_id"             ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getString    ("code"              ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("name"              ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getBigDecimal("latitude"          ),ValueType.DECIMAL ));
    this.tableWriter.addValue(getValue(rs.getBigDecimal("longitude"         ),ValueType.DECIMAL ));
    this.tableWriter.addValue(getValue(rs.getString    ("address"           ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("postal_code"       ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("city"              ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getInt       ("max_people"        ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getString    ("advice"            ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("localization"      ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getBoolean   ("minor_allowed"     ),ValueType.BOOL    ));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("created"           ),ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getBoolean   ("enabled"           ),ValueType.BOOL    ));
    this.tableWriter.addValue(getValue(rs.getInt       ("type"              ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("time_to_reach"     ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("transport_to_reach"),ValueType.INT     ));

    return null;
  }


  public static TableMetadata generateTableMetadata(final String version)
  {
    TableMetadataBuilder tableMetadataBuilder = new TableMetadataBuilder();

    tableMetadataBuilder.addProperty("GeneratedBy", "RCQUtilityBackend Version '"+version+"'");
    tableMetadataBuilder.addProperty(new MetadataProperty("SQLQuery", ValueType.STRING, ExportDataImpl.QUERY_FOR_GET_POINT_QUETE));

    tableMetadataBuilder.addColumn(new ColumnMetadata("id"                , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("ul_id"             , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("code"              , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("name"              , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("latitude"          , ValueType.DECIMAL ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("longitude"         , ValueType.DECIMAL ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("address"           , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("postal_code"       , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("city"              , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("max_people"        , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("advice"            , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("localization"      , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("minor_allowed"     , ValueType.BOOL    ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("created"           , ValueType.DATETIME));
    tableMetadataBuilder.addColumn(new ColumnMetadata("enabled"           , ValueType.BOOL    ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("type"              , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("time_to_reach"     , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("transport_to_reach", ValueType.INT     ));

    return tableMetadataBuilder.build();
  }
}

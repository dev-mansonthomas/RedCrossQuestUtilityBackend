package com.redcrossquest.utilitybackend.model.rowMapper;

import com.redcrossquest.utilitybackend.model.NullDTO;
import com.redcrossquest.utilitybackend.services.impl.ExportDataImpl;
import com.spotfire.sbdf.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DailyStatsBeforeRCQRowMapper extends RowMapperHelper implements RowMapper<NullDTO>
{
  private TableWriter tableWriter;


  public DailyStatsBeforeRCQRowMapper(final TableWriter tableWriter)
  {
    this.tableWriter = tableWriter;
  }

  public NullDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    this.tableWriter.addValue(getValue(rs.getInt       ("id"            ), ValueType.INT      ));
    this.tableWriter.addValue(getValue(rs.getInt       ("ul_id"         ), ValueType.INT      ));
    this.tableWriter.addValue(getValue(rs.getDate      ("date"          ), ValueType.DATE     ));
    this.tableWriter.addValue(getValue(rs.getBigDecimal("amount"        ), ValueType.DECIMAL  ));
    this.tableWriter.addValue(getValue(rs.getInt       ("nb_benevole"   ), ValueType.INT      ));
    this.tableWriter.addValue(getValue(rs.getInt       ("nb_benevole_1j"), ValueType.INT      ));
    this.tableWriter.addValue(getValue(rs.getInt       ("nb_heure"      ), ValueType.INT      ));

    return null;
  }


  public static TableMetadata generateTableMetadata(final String version)
  {
    TableMetadataBuilder tableMetadataBuilder = new TableMetadataBuilder();

    tableMetadataBuilder.addProperty("GeneratedBy", "RCQUtilityBackend Version '"+version+"'");
    tableMetadataBuilder.addProperty(new MetadataProperty("SQLQuery", ValueType.STRING, ExportDataImpl.QUERY_FOR_GET_YEARLY_GOAL));

    tableMetadataBuilder.addColumn(new ColumnMetadata("id"              , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("ul_id"           , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("year"            , ValueType.DATE    ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("amount"          , ValueType.DECIMAL ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("nb_benevole"     , ValueType.INT));
    tableMetadataBuilder.addColumn(new ColumnMetadata("nb_benevole_1j"  , ValueType.INT));
    tableMetadataBuilder.addColumn(new ColumnMetadata("nb_heure"        , ValueType.INT));

    return tableMetadataBuilder.build();
  }
}

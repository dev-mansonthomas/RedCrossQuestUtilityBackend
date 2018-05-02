package com.redcrossquest.utilitybackend.model.rowMapper;

import com.redcrossquest.utilitybackend.model.NullDTO;
import com.redcrossquest.utilitybackend.services.impl.ExportDataImpl;
import com.spotfire.sbdf.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class YearlyGoalRowMapper extends RowMapperHelper implements RowMapper<NullDTO>
{
  private TableWriter tableWriter;


  public YearlyGoalRowMapper(final TableWriter tableWriter)
  {
    this.tableWriter = tableWriter;
  }

  public NullDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    this.tableWriter.addValue(getValue(rs.getInt        ("id"                ), ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getInt        ("ul_id"             ), ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getInt        ("year"              ), ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getBigDecimal ("amount"            ), ValueType.DECIMAL));
    this.tableWriter.addValue(getValue(rs.getInt        ("day_1_percentage"  ), ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getInt        ("day_2_percentage"  ), ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getInt        ("day_3_percentage"  ), ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getInt        ("day_4_percentage"  ), ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getInt        ("day_5_percentage"  ), ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getInt        ("day_6_percentage"  ), ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getInt        ("day_7_percentage"  ), ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getInt        ("day_8_percentage"  ), ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getInt        ("day_9_percentage"  ), ValueType.INT    ));

    return null;
  }


  public static TableMetadata generateTableMetadata(final String version)
  {
    TableMetadataBuilder tableMetadataBuilder = new TableMetadataBuilder();

    tableMetadataBuilder.addProperty("GeneratedBy", "RCQUtilityBackend Version '"+version+"'");
    tableMetadataBuilder.addProperty(new MetadataProperty("SQLQuery", ValueType.STRING, ExportDataImpl.QUERY_FOR_GET_YEARLY_GOAL));

    tableMetadataBuilder.addColumn(new ColumnMetadata("id"                , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("ul_id"             , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("year"              , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("amount"            , ValueType.DECIMAL ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("day_1_percentage"  , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("day_2_percentage"  , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("day_3_percentage"  , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("day_4_percentage"  , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("day_5_percentage"  , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("day_6_percentage"  , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("day_7_percentage"  , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("day_8_percentage"  , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("day_9_percentage"  , ValueType.INT     ));

    return tableMetadataBuilder.build();
  }
}

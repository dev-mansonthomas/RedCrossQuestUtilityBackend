package com.redcrossquest.utilitybackend.model.rowMapper;

import com.redcrossquest.utilitybackend.model.NullDTO;
import com.redcrossquest.utilitybackend.services.impl.ExportDataImpl;
import com.spotfire.sbdf.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditCardRowMapper extends RowMapperHelper implements RowMapper<NullDTO>
{
  private TableWriter tableWriter;


  public CreditCardRowMapper(final TableWriter tableWriter)
  {
    this.tableWriter = tableWriter;
  }

  public NullDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    this.tableWriter.addValue(getValue(rs.getInt       ("id"              ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("tronc_queteur_id"),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("ul_id"           ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("quantity"        ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getBigDecimal("amount"          ),ValueType.DECIMAL ));
    return null;
  }


  public static TableMetadata generateTableMetadata(final String version)
  {
    TableMetadataBuilder tableMetadataBuilder = new TableMetadataBuilder();

    tableMetadataBuilder.addProperty("GeneratedBy", "RCQUtilityBackend Version '"+version+"'");
    tableMetadataBuilder.addProperty(new MetadataProperty("SQLQuery", ValueType.STRING, ExportDataImpl.QUERY_FOR_GET_CREDIT_CARD));

    tableMetadataBuilder.addColumn(new ColumnMetadata("id"              , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("tronc_queteur_id", ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("ul_id"           , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("quantity"        , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("amount"          , ValueType.DECIMAL  ));

    return tableMetadataBuilder.build();
  }
}

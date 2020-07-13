package com.redcrossquest.utilitybackend.model.rowMapper;

import com.redcrossquest.utilitybackend.model.NullDTO;
import com.redcrossquest.utilitybackend.services.impl.ExportDataImpl;
import com.spotfire.sbdf.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ULRowMapper extends RowMapperHelper implements RowMapper<NullDTO>
{
  private TableWriter tableWriter;


  public ULRowMapper(final TableWriter tableWriter)
  {
    this.tableWriter = tableWriter;
  }

  public NullDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    this.tableWriter.addValue(getValue(rs.getInt       ("id"                        ),ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getString    ("name"                      ),ValueType.STRING ));
    this.tableWriter.addValue(getValue(rs.getString    ("phone"                     ),ValueType.STRING ));
    this.tableWriter.addValue(getValue(rs.getBigDecimal("latitude"                  ),ValueType.DECIMAL));
    this.tableWriter.addValue(getValue(rs.getBigDecimal("longitude"                 ),ValueType.DECIMAL));
    this.tableWriter.addValue(getValue(rs.getString    ("address"                   ),ValueType.STRING ));
    this.tableWriter.addValue(getValue(rs.getString    ("postal_code"               ),ValueType.STRING ));
    this.tableWriter.addValue(getValue(rs.getString    ("city"                      ),ValueType.STRING ));
    this.tableWriter.addValue(getValue(rs.getInt       ("external_id"               ),ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getString    ("email"                     ),ValueType.STRING ));
    this.tableWriter.addValue(getValue(rs.getInt       ("id_structure_rattachement" ),ValueType.INT    ));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("date_demarrage_activite"   ),ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("date_demarrage_rcq"        ),ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getString    ("thanks_mail_benevole"      ),ValueType.STRING ));
    this.tableWriter.addValue(getValue(rs.getString    ("thanks_mail_benevole1j"    ),ValueType.STRING ));

    return null;
  }


  public static TableMetadata generateTableMetadata(final String version)
  {
    TableMetadataBuilder tableMetadataBuilder = new TableMetadataBuilder();

    tableMetadataBuilder.addProperty("GeneratedBy", "RCQUtilityBackend Version '"+version+"'");
    tableMetadataBuilder.addProperty(new MetadataProperty("SQLQuery", ValueType.STRING, ExportDataImpl.QUERY_FOR_GET_UL));

    tableMetadataBuilder.addColumn(new ColumnMetadata("id"                       , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("name"                     , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("phone"                    , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("latitude"                 , ValueType.DECIMAL ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("longitude"                , ValueType.DECIMAL ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("address"                  , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("postal_code"              , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("city"                     , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("external_id"              , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("email"                    , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("id_structure_rattachement", ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("date_demarrage_activite"  , ValueType.DATETIME));
    tableMetadataBuilder.addColumn(new ColumnMetadata("date_demarrage_rcq"       , ValueType.DATETIME));
    tableMetadataBuilder.addColumn(new ColumnMetadata("thanks_mail_benevole"     , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("thanks_mail_benevole1j"   , ValueType.STRING  ));

    return tableMetadataBuilder.build();
  }
}

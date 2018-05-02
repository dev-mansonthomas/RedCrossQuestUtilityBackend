package com.redcrossquest.utilitybackend.model.rowMapper;

import com.redcrossquest.utilitybackend.model.NullDTO;
import com.redcrossquest.utilitybackend.services.impl.ExportDataImpl;
import com.spotfire.sbdf.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NamedDonationRowMapper extends RowMapperHelper implements RowMapper<NullDTO>
{
  private TableWriter tableWriter;


  public NamedDonationRowMapper(final TableWriter tableWriter)
  {
    this.tableWriter = tableWriter;
  }

  public NullDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    this.tableWriter.addValue(getValue(rs.getInt       ("id"                          ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("ul_id"                       ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getString    ("ref_recu_fiscal"             ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("first_name"                  ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("last_name"                   ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getDate      ("date"                        ),ValueType.DATE    ));
    this.tableWriter.addValue(getValue(rs.getString    ("address"                     ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("postal_code"                 ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("city"                        ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("phone"                       ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("email"                       ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getInt       ("euro500"                     ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("euro200"                     ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("euro100"                     ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("euro50"                      ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("euro20"                      ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("euro10"                      ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("euro5"                       ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("euro2"                       ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("euro1"                       ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("cents50"                     ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("cents20"                     ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("cents10"                     ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("cents5"                      ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("cents2"                      ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("cent1"                       ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getString    ("notes"                       ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getInt       ("type"                        ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("forme"                       ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getBigDecimal("don_creditcard"              ),ValueType.DECIMAL ));
    this.tableWriter.addValue(getValue(rs.getBigDecimal("don_cheque"                  ),ValueType.DECIMAL ));
    this.tableWriter.addValue(getValue(rs.getBoolean   ("deleted"                     ),ValueType.BOOL    ));
    this.tableWriter.addValue(getValue(rs.getString    ("coins_money_bag_id"          ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("bills_money_bag_id"          ),ValueType.STRING  ));



    return null;
  }


  public static TableMetadata generateTableMetadata(final String version)
  {
    TableMetadataBuilder tableMetadataBuilder = new TableMetadataBuilder();

    tableMetadataBuilder.addProperty("GeneratedBy", "RCQUtilityBackend Version '"+version+"'");
    tableMetadataBuilder.addProperty(new MetadataProperty("SQLQuery", ValueType.STRING, ExportDataImpl.QUERY_FOR_GET_NAMED_DONATION));

    tableMetadataBuilder.addColumn(new ColumnMetadata("id"                          , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("ul_id"                       , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("ref_recu_fiscal"             , ValueType.STRING   ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("first_name"                  , ValueType.STRING   ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("last_name"                   , ValueType.STRING   ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("date"                        , ValueType.DATE     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("address"                     , ValueType.STRING   ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("postal_code"                 , ValueType.STRING   ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("city"                        , ValueType.STRING   ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("phone"                       , ValueType.STRING   ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("email"                       , ValueType.STRING   ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro500"                     , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro200"                     , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro100"                     , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro50"                      , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro20"                      , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro10"                      , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro5"                       , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro2"                       , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro1"                       , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("cents50"                     , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("cents20"                     , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("cents10"                     , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("cents5"                      , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("cents2"                      , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("cent1"                       , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("notes"                       , ValueType.STRING   ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("type"                        , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("forme"                       , ValueType.INT      ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("don_creditcard"              , ValueType.DECIMAL  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("don_cheque"                  , ValueType.DECIMAL  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("deleted"                     , ValueType.BOOL     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("coins_money_bag_id"          , ValueType.STRING   ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("bills_money_bag_id"          , ValueType.STRING   ));


    return tableMetadataBuilder.build();
  }
}

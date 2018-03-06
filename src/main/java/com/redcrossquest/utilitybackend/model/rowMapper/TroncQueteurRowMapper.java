package com.redcrossquest.utilitybackend.model.rowMapper;

import com.redcrossquest.utilitybackend.model.NullDTO;
import com.redcrossquest.utilitybackend.services.impl.ExportDataImpl;
import com.spotfire.sbdf.*;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TroncQueteurRowMapper extends RowMapperHelper implements RowMapper<NullDTO>
{
  private TableWriter tableWriter;


  public TroncQueteurRowMapper(final TableWriter tableWriter)
  {
    this.tableWriter = tableWriter;
  }

  public NullDTO mapRow(ResultSet rs, int rowNum) throws SQLException
  {
    this.tableWriter.addValue(getValue(rs.getInt       ("id"                          ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("queteur_id"                  ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("point_quete_id"              ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("tronc_id"                    ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("depart_theorique"            ),ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("depart"                      ),ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("retour"                      ),ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("comptage"                    ),ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getTimestamp ("last_update"                 ),ValueType.DATETIME));
    this.tableWriter.addValue(getValue(rs.getInt       ("last_update_user_id"         ),ValueType.INT     ));
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
    this.tableWriter.addValue(getValue(rs.getInt       ("foreign_coins"               ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getInt       ("foreign_banknote"            ),ValueType.INT     ));
    this.tableWriter.addValue(getValue(rs.getString    ("notes_depart_theorique"      ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("notes_retour"                ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("notes_retour_comptage_pieces"),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getString    ("notes_update"                ),ValueType.STRING  ));
    this.tableWriter.addValue(getValue(rs.getBoolean   ("deleted"                     ),ValueType.BOOL    ));
    this.tableWriter.addValue(getValue(rs.getBigDecimal("don_creditcard"              ),ValueType.DECIMAL ));
    this.tableWriter.addValue(getValue(rs.getBigDecimal("don_cheque"                  ),ValueType.DECIMAL ));



    return null;
  }


  public static TableMetadata generateTableMetadata(final String version)
  {
    TableMetadataBuilder tableMetadataBuilder = new TableMetadataBuilder();

    tableMetadataBuilder.addProperty("GeneratedBy", "RCQUtilityBackend Version '"+version+"'");
    tableMetadataBuilder.addProperty(new MetadataProperty("SQLQuery", ValueType.STRING, ExportDataImpl.QUERY_FOR_GET_TRONC_QUETEUR));

    tableMetadataBuilder.addColumn(new ColumnMetadata("id"                          , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("queteur_id"                  , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("point_quete_id"              , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("tronc_id"                    , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("depart_theorique"            , ValueType.DATETIME));
    tableMetadataBuilder.addColumn(new ColumnMetadata("depart"                      , ValueType.DATETIME));
    tableMetadataBuilder.addColumn(new ColumnMetadata("retour"                      , ValueType.DATETIME));
    tableMetadataBuilder.addColumn(new ColumnMetadata("comptage"                    , ValueType.DATETIME));
    tableMetadataBuilder.addColumn(new ColumnMetadata("last_update"                 , ValueType.DATETIME));
    tableMetadataBuilder.addColumn(new ColumnMetadata("last_update_user_id"         , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro500"                     , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro200"                     , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro100"                     , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro50"                      , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro20"                      , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro10"                      , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro5"                       , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro2"                       , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("euro1"                       , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("cents50"                     , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("cents20"                     , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("cents10"                     , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("cents5"                      , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("cents2"                      , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("cent1"                       , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("foreign_coins"               , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("foreign_banknote"            , ValueType.INT     ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("notes_depart_theorique"      , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("notes_retour"                , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("notes_retour_comptage_pieces", ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("notes_update"                , ValueType.STRING  ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("deleted"                     , ValueType.BOOL    ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("don_creditcard"              , ValueType.DECIMAL ));
    tableMetadataBuilder.addColumn(new ColumnMetadata("don_cheque"                  , ValueType.DECIMAL ));

    return tableMetadataBuilder.build();
  }
}

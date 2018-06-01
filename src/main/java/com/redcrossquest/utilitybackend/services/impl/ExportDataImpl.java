package com.redcrossquest.utilitybackend.services.impl;

import com.redcrossquest.utilitybackend.model.rowMapper.*;
import com.redcrossquest.utilitybackend.services.ExportDataService;
import com.spotfire.sbdf.TableWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


public class ExportDataImpl implements ExportDataService
{
  @Autowired
  private JdbcTemplate jdbcTemplate;


  public static final String QUERY_FOR_GET_SPOTFIRE_ACCESS =
    "SELECT sa.id, sa.token, sa.token_expiration, sa.ul_id, \n" +
    "       u.id as user_id, u.nivol, u.queteur_id, u.role, cast(u.active as unsigned) as active \n" +
    "FROM  spotfire_access sa, users u \n" +
    "WHERE sa.user_id = u.id ";

  public void exportSpotfireAccess(final TableWriter tableWriter)
  {
    Object [] os    = {};
    int    [] types = {};


    jdbcTemplate.query(QUERY_FOR_GET_SPOTFIRE_ACCESS,
                       os    ,
                       types ,
                       new SpotfireAccessRowMapper(tableWriter));
  }


  public static final String QUERY_FOR_GET_TRONC_QUETEUR =
    "SELECT                           \n" +
    "id                              ,\n" +
    "queteur_id                      ,\n" +
    "point_quete_id                  ,\n" +
    "tronc_id                        ,\n" +
    "depart_theorique                ,\n" +
    "depart                          ,\n" +
    "retour                          ,\n" +
    "comptage                        ,\n" +
    "last_update                     ,\n" +
    "last_update_user_id             ,\n" +
    "euro500                         ,\n" +
    "euro200                         ,\n" +
    "euro100                         ,\n" +
    "euro50                          ,\n" +
    "euro20                          ,\n" +
    "euro10                          ,\n" +
    "euro5                           ,\n" +
    "euro2                           ,\n" +
    "euro1                           ,\n" +
    "cents50                         ,\n" +
    "cents20                         ,\n" +
    "cents10                         ,\n" +
    "cents5                          ,\n" +
    "cents2                          ,\n" +
    "cent1                           ,\n" +
    "foreign_coins                   ,\n" +
    "foreign_banknote                ,\n" +
    "notes_depart_theorique          ,\n" +
    "notes_retour                    ,\n" +
    "notes_retour_comptage_pieces    ,\n" +
    "notes_update                    ,\n" +
    "deleted                         ,\n" +
    "don_creditcard                  ,\n" +
    "don_cheque                      ,\n" +
    "coins_money_bag_id              ,\n" +
    "bills_money_bag_id              ,\n" +
    "don_cb_sans_contact_amount      ,\n" +
    "don_cb_sans_contact_number      ,\n" +
    "don_cb_total_number             ,\n" +
    "don_cheque_number                \n" +
    "FROM tronc_queteur               \n" ;

  public void exportTroncQueteur(final TableWriter tableWriter)
  {
    Object [] os    = {};
    int    [] types = {};


    jdbcTemplate.query(QUERY_FOR_GET_TRONC_QUETEUR,
                       os    ,
                       types ,
                       new TroncQueteurRowMapper(tableWriter));
  }


  public static final String QUERY_FOR_GET_POINT_QUETE =
      "SELECT              \n" +
      "id                 ,\n" +
      "ul_id              ,\n" +
      "code               ,\n" +
      "name               ,\n" +
      "latitude           ,\n" +
      "longitude          ,\n" +
      "address            ,\n" +
      "postal_code        ,\n" +
      "city               ,\n" +
      "max_people         ,\n" +
      "advice             ,\n" +
      "localization       ,\n" +
      "minor_allowed      ,\n" +
      "created            ,\n" +
      "enabled            ,\n" +
      "type               ,\n" +
      "time_to_reach      ,\n" +
      "transport_to_reach  \n" +
      "FROM point_quete    \n" ;

  public void exportPointQuete(final TableWriter tableWriter)
  {
    Object [] os    = {};
    int    [] types = {};


    jdbcTemplate.query(QUERY_FOR_GET_POINT_QUETE,
                       os    ,
                       types ,
                       new PointQueteRowMapper(tableWriter));
  }


  public static final String QUERY_FOR_GET_QUETEUR =
    "SELECT              \n" +
    "id                        ,\n" +
    "first_name                ,\n" +
    "last_name                 ,\n" +
    "email                     ,\n" +
    "secteur                   ,\n" +
    "nivol                     ,\n" +
    "mobile                    ,\n" +
    "created                   ,\n" +
    "updated                   ,\n" +
    "parent_authorization      ,\n" +
    "temporary_volunteer_form  ,\n" +
    "notes                     ,\n" +
    "ul_id                     ,\n" +
    "birthdate                 ,\n" +
    "man                       ,\n" +
    "active                    ,\n" +
    "qr_code_printed           ,\n" +
    "referent_volunteer        ,\n" +
    "anonymization_token       ,\n" +
    "anonymization_date        ,\n" +
    "anonymization_user_id      \n"+
    "FROM queteur               \n" ;

  public void exportQueteur(final TableWriter tableWriter)
  {
    Object [] os    = {};
    int    [] types = {};


    jdbcTemplate.query(QUERY_FOR_GET_QUETEUR,
                       os    ,
                       types ,
                       new QueteurRowMapper(tableWriter));
  }


  public static final String QUERY_FOR_GET_TRONC =
    "SELECT           \n" +
    "id              ,\n" +
    "ul_id           ,\n" +
    "created         ,\n" +
    "enabled         ,\n" +
    "notes           ,\n" +
    "type            ,\n" +
    "qr_code_printed  \n" +
    "FROM tronc       \n" ;

  public void exportTronc(final TableWriter tableWriter)
  {
    Object [] os    = {};
    int    [] types = {};


    jdbcTemplate.query(QUERY_FOR_GET_TRONC,
                       os    ,
                       types ,
                       new TroncRowMapper(tableWriter));
  }


  public static final String QUERY_FOR_GET_UL =
    "SELECT                     \n" +
    "id                        ,\n" +
    "name                      ,\n" +
    "phone                     ,\n" +
    "latitude                  ,\n" +
    "longitude                 ,\n" +
    "address                   ,\n" +
    "postal_code               ,\n" +
    "city                      ,\n" +
    "external_id               ,\n" +
    "email                     ,\n" +
    "id_structure_rattachement ,\n" +
    "date_demarrage_activite   ,\n" +
    "date_demarrage_rcq         \n" +
    "FROM ul                    \n" ;

  public void exportUL(final TableWriter tableWriter)
  {
    Object [] os    = {};
    int    [] types = {};


    jdbcTemplate.query(QUERY_FOR_GET_UL,
                       os    ,
                       types ,
                       new ULRowMapper(tableWriter));
  }


  public static final String QUERY_FOR_GET_YEARLY_GOAL =
    "SELECT             \n" +
    "id                ,\n" +
    "ul_id             ,\n" +
    "year              ,\n" +
    "amount            ,\n" +
    "day_1_percentage  ,\n" +
    "day_2_percentage  ,\n" +
    "day_3_percentage  ,\n" +
    "day_4_percentage  ,\n" +
    "day_5_percentage  ,\n" +
    "day_6_percentage  ,\n" +
    "day_7_percentage  ,\n" +
    "day_8_percentage  ,\n" +
    "day_9_percentage  \n" +

    "FROM yearly_goal   \n" ;

  public void exportYearlyGoal(final TableWriter tableWriter)
  {
    Object [] os    = {};
    int    [] types = {};


    jdbcTemplate.query(QUERY_FOR_GET_YEARLY_GOAL,
                       os    ,
                       types ,
                       new YearlyGoalRowMapper(tableWriter));
  }


  public static final String QUERY_FOR_GET_DAILY_STATS_BEFORE_RCQ =
    "SELECT    \n" +
    "id       ,\n" +
    "ul_id    ,\n" +
    "date     ,\n" +
    "amount    \n" +
    "FROM daily_stats_before_rcq \n" ;

  public void exportDailyStatsBeforeRCQ(final TableWriter tableWriter)
  {
    Object [] os    = {};
    int    [] types = {};


    jdbcTemplate.query(QUERY_FOR_GET_DAILY_STATS_BEFORE_RCQ,
                       os    ,
                       types ,
                       new DailyStatsBeforeRCQRowMapper(tableWriter));
  }

  public static final String QUERY_FOR_GET_NAMED_DONATION=
    "SELECT            \n" +
    "id                  ,\n" +
    "ul_id               ,\n" +
    "ref_recu_fiscal     ,\n" +
    "first_name          ,\n" +
    "last_name           ,\n" +
    "donation_date       ,\n" +
    "don_cheque          ,\n" +
    "address             ,\n" +
    "postal_code         ,\n" +
    "city                ,\n" +
    "phone               ,\n" +
    "email               ,\n" +
    "euro500             ,\n" +
    "euro200             ,\n" +
    "euro100             ,\n" +
    "euro50              ,\n" +
    "euro20              ,\n" +
    "euro10              ,\n" +
    "euro5               ,\n" +
    "euro2               ,\n" +
    "euro1               ,\n" +
    "cents50             ,\n" +
    "cents20             ,\n" +
    "cents10             ,\n" +
    "cents5              ,\n" +
    "cents2              ,\n" +
    "cent1               ,\n" +
    "notes               ,\n" +
    "type                ,\n" +
    "forme               ,\n" +
    "don_creditcard      ,\n" +
    "deleted             ,\n" +
    "coins_money_bag_id  ,\n" +
    "bills_money_bag_id  ,\n" +
    "last_update         ,\n" +
    "last_update_user_id  \n"  +


      "FROM named_donation \n" ;

  public void exportNamedDonation(final TableWriter tableWriter)
  {
    Object [] os    = {};
    int    [] types = {};


    jdbcTemplate.query(QUERY_FOR_GET_NAMED_DONATION,
                       os    ,
                       types ,
                       new NamedDonationRowMapper(tableWriter));
  }



}

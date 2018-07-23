package com.redcrossquest.utilitybackend.services;

import com.spotfire.sbdf.TableWriter;

public interface ExportDataService
{
  void exportSpotfireAccess       (final TableWriter tableWriter);
  void exportTroncQueteur         (final TableWriter tableWriter);
  void exportPointQuete           (final TableWriter tableWriter);
  void exportQueteur              (final TableWriter tableWriter);
  void exportTronc                (final TableWriter tableWriter);
  void exportUL                   (final TableWriter tableWriter);
  void exportYearlyGoal           (final TableWriter tableWriter);
  void exportDailyStatsBeforeRCQ  (final TableWriter tableWriter);
  void exportNamedDonation        (final TableWriter tableWriter);
  void exportQueteurMailingStatus (final TableWriter tableWriter);
}

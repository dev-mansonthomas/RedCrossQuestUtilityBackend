package com.redcrossquest.utilitybackend;


import com.redcrossquest.utilitybackend.services.ExportDataService;
import com.redcrossquest.utilitybackend.services.impl.ExportDataImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class UtilityBackendConfiguration
{

  @Bean
  public ExportDataService spotfireAccessService()
  {
    return new ExportDataImpl();
  }
}

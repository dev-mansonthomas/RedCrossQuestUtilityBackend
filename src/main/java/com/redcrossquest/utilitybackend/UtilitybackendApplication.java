package com.redcrossquest.utilitybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UtilitybackendApplication
{

  public static final String dateSDF        = "dd/MM/yyyy";
  public static final String hourSDF        = "HH:mm:ss";
  public static final String dateTimeSDF    = "dd/MM/yyyy HH:ss";
  public static final String dateTimeMSSDF  = "dd/MM/yyyy HH:mm:ss.SSS";



	public static void main(String[] args)
  {
		SpringApplication.run(UtilitybackendApplication.class, args);
	}
}

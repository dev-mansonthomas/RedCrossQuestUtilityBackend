package com.redcrossquest.utilitybackend.model.rowMapper;

import com.redcrossquest.utilitybackend.UtilitybackendApplication;
import com.spotfire.sbdf.ValueType;

import java.text.SimpleDateFormat;


public class RowMapperHelper
{
  protected SimpleDateFormat dateFormat = new SimpleDateFormat(UtilitybackendApplication.dateTimeSDF);

  public static Object getValue(Object o, ValueType valueType)
  {
    if(o!=null)
    {
      return o;
    }

    return valueType.getDefaultValue();
  }
  public static String getString(String string)
  {
    if (string == null)
      return "";
    return string;
  }
}

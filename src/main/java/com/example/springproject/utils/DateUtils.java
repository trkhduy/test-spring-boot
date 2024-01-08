package com.example.springproject.utils;

import java.time.LocalDate;

public class DateUtils {
  public static String getCurrentDateString() {
    return LocalDate.now().toString();
  }

  public static Long getCurrentTimeMillis() {
    return System.currentTimeMillis();
  }
}
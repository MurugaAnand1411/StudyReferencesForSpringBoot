package com.rubix.timesheet.Util;


import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.time.temporal.*;
import java.util.ArrayList;
public class DateUtil {

  public static Date asDate(LocalDate localDate) {
    return  Date.from(localDate.atStartOfDay(ZoneId.of("UTC")).toInstant());
    
   
  }

  public static Date asDate(LocalDateTime localDateTime) {
    return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
  }

  public static LocalDate asLocalDate(Date date) {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    
  }

  public static LocalDateTime asLocalDateTime(Date date) {
    return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
  }
  public static List<Date> listofDatesBetweenTwoDate(Date startDate,Date endDate){
	  LocalDate start=asLocalDate(startDate);
	  LocalDate end=asLocalDate(endDate);
	  long numOfDays = ChronoUnit.DAYS.between(start, end)+1;
      
	  List<LocalDate> listOfDates = Stream.iterate(start, date -> date.plusDays(1))
	                                      .limit(numOfDays)
	                                      .collect(Collectors.toList());
	  List<Date> newListofDates=new ArrayList<>();
	  for(LocalDate locDate:listOfDates) {
		  newListofDates.add(asDate(locDate));
	  }
	  
	  return newListofDates;
  }
}
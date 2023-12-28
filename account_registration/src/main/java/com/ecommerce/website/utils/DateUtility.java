package com.ecommerce.website.utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public  class DateUtility {

	public static Timestamp localToTimeStamp() {
		LocalDate localDate = LocalDate.now();
		LocalDateTime localDateTime = localDate.atStartOfDay();
        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        return timestamp;
	}
}

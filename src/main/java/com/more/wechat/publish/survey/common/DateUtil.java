package com.more.wechat.publish.survey.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {

	private static ThreadLocal<DateFormat> dateTimeFormat = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	};

	private static ThreadLocal<DateFormat> dateFormat = new ThreadLocal<DateFormat>() {
		@Override
		protected DateFormat initialValue() {
			return new SimpleDateFormat("yyyy-MM-dd");
		}
	};

	public static Date parseDateTime(String dateStr) throws ParseException {
		return dateTimeFormat.get().parse(dateStr);
	}

	public static String formatDateTime(Date date) {
		return dateTimeFormat.get().format(date);
	}

	public static Date parseDate(String dateStr) throws ParseException {
		return dateFormat.get().parse(dateStr);
	}

	public static String formatDate(Date date) {
		return dateFormat.get().format(date);
	}

	public static int getCoverageYear(Date inceptionDate, Date expiryDate) {
		int coverageYear = 0;
		Calendar inceptionCal = Calendar.getInstance();
		Calendar expiryCal = Calendar.getInstance();
		inceptionCal.setTime(inceptionDate);
		expiryCal.setTime(expiryDate);
		expiryCal.add(Calendar.SECOND, 1);

		int inceptionYear = inceptionCal.get(Calendar.YEAR);
		int inceptionMonth = inceptionCal.get(Calendar.MONTH);
		int inceptionDay = inceptionCal.get(Calendar.DATE);

		int expiryYear = expiryCal.get(Calendar.YEAR);
		int expiryMonth = expiryCal.get(Calendar.MONTH);
		int expiryDay = expiryCal.get(Calendar.DATE);

		if (expiryYear == inceptionYear) {
			coverageYear = 0;
		} else {
			int ageDiff = expiryYear - inceptionYear;
			if (ageDiff > 0) {
				if (expiryMonth == inceptionMonth) {
					int dayDiff = expiryDay - inceptionDay;
					if (dayDiff < 0) {
						coverageYear = ageDiff - 1;
					} else {
						coverageYear = ageDiff;
					}
				} else {
					int mothDiff = expiryMonth - inceptionMonth;
					if (mothDiff < 0) {
						coverageYear = ageDiff - 1;
					} else {
						coverageYear = ageDiff;
					}
				}
			} else {
				return coverageYear = -1;
			}

		}
		return coverageYear;
	}
}

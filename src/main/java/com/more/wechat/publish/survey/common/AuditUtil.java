package com.more.wechat.publish.survey.common;

import java.text.ParseException;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class AuditUtil {

	public static String getDefaultUser() {
		return "admin";
	}

	public static String getDefaultDate() {
		return DateUtil.formatDate(new Date());
	}

	public static Date getDefaultDateTime() throws ParseException {
		return DateUtil.parseDateTime(DateUtil.formatDateTime(new Date()));
	}
}

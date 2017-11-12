package com.more.wechat.publish.survey.common;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public  class UUIDGenerator {
	public static String getUUIDWhthoutLine() {

		String uuid = UUID.randomUUID().toString();
		// 去掉"-"符号
		String messageId = uuid.substring(0, 8) + uuid.substring(9, 13)
				+ uuid.substring(14, 18) + uuid.substring(19, 23)
				+ uuid.substring(24);
		return messageId;
	}
}

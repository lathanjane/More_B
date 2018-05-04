package com.more.wechat.publish.common;


import com.alibaba.fastjson.JSON;

public class CommonUtil {

	public static String objToJson(Object o) {
		return JSON.toJSONString(o);
	}
}

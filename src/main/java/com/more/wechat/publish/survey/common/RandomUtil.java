package com.more.wechat.publish.survey.common;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomUtil {

	/**
	 * 生成固定长度数字随机码
	 * 
	 * @param startWith
	 *            拼接开始字符串
	 * @param length
	 *            随机码长度
	 * @return
	 */
	public static String getRandomKeyCode(String startWith, int length) {
		return getRandomKeyCode(startWith, length, new BigDecimal(0), new BigDecimal(0));
	}

	/**
	 * 生成固定长度和范围的数字随机码
	 * 
	 * @param startWith
	 *            拼接开始字符串
	 * @param length
	 *            随机码长度
	 * @param min
	 *            随机码最小值
	 * @param max
	 *            随机码最大值[max=0 不作值范围限制]
	 * @return
	 */
	public static String getRandomKeyCode(String startWith, int length, BigDecimal min, BigDecimal max) {

		BigDecimal randomNumber = new BigDecimal(0);
		for (int i = 0; i < length; i++) {
			int tr = (int) (10 * (Math.random()));
			BigDecimal t = new BigDecimal(tr * Math.pow(10, i));
			randomNumber = randomNumber.add(t);
		}

		String tRandomKeyCode = startWith + randomNumber;
		// max=0 不作值范围限制
		if (max.compareTo(new BigDecimal(0)) != 0) {
			if (randomNumber.compareTo(min) < 0 || randomNumber.compareTo(max) > 0) {
				tRandomKeyCode = getRandomKeyCode(startWith, length, min, max);
			}
		}
		return tRandomKeyCode;
	}

	public static int randomNumber(int min, int max) {
		return new Random().nextInt(max - min) + min;
	}

}

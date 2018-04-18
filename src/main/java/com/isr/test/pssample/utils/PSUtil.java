package com.isr.test.pssample.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class PSUtil {

	/**
	 * This method generates an Random attribute for DB
	 * 
	 * @return
	 */
	public static String getRandomAttribute(String attribute) {
		Random rand = new Random();
		int n = rand.nextInt(4) + 1;
		return attribute + n;
	}

	/**
	 * This method generates an Random attribute for DB
	 * 
	 * @return
	 */
	public static String getRandomAttribute(String attribute, int maxValue) {
		Random rand = new Random();
		int n = rand.nextInt(maxValue) + 1;
		return attribute + String.format("%03d", n);
	}

	/**
	 * Get Random Date future and past dates included
	 * 
	 * @return
	 */
	public static Timestamp getRandomLoginDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, generatRandomPositiveNegitiveValue(30, 30));
		return new Timestamp(calendar.getTimeInMillis());

	}

	private static int generatRandomPositiveNegitiveValue(int max, int min) {
		int ii = -min + (int) (Math.random() * ((max - (-min)) + 1));
		return ii;
	}

	public static Date getDateFromString(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(PSSampleConst.DATE_FORMAT);
		Date returnDate = dateFormat.parse(date);
		// System.out.println(returnDate);
		return returnDate;
	}

}

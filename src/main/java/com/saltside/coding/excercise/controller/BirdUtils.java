package com.saltside.coding.excercise.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.saltside.coding.excercise.db.Bird;

/**
 * Used to validate request object and create default value for a
 *  field of class {@link com.saltside.coding.excercise.db.Bird}.
 * @author amarnath
 *
 */
public class BirdUtils {

	public static boolean isBadRequest(final Bird bird) {

		return bird.getName() == null || bird.getFamily() == null
				|| bird.getContinents() == null
				|| bird.getContinents().size() == 0
				|| isValidDate(bird);

	}

	public static Bird getBird(final Bird bird) {

		if (bird.getAdded() == null) {
			bird.setAdded(getTodayStringDate());
		}
		return bird;
	}

	private static boolean isValidDate(final Bird bird) {
		
		return bird.getAdded() != null && 
				!getTodayStringDate().equals(bird.getAdded());
	}

	private static String getTodayStringDate() {

		final SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD");
		final Date date = new Date();
		return df.format(date);
	}

}

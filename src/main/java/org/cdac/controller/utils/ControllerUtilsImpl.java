package org.cdac.controller.utils;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class ControllerUtilsImpl implements ControllerUtils {

	public String createPrimaryKey() {
		LocalDate currentDate = LocalDate.now();
		LocalTime localTime = LocalTime.now();
		String Tkey = currentDate.toString() + localTime.toString();
		String key = Tkey.replaceAll("[-:,.]", "");
		return key;
	}

}

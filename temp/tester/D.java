package common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class D {

	public static Date date(String yyyyMMddHHmm) {
		try {
			return new SimpleDateFormat("yyyyMMddHHmm").parse(yyyyMMddHHmm);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}

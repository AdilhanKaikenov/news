package com.epam.adk.web.news.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * TODO: Comment
 * <p>
 * Created on 5/17/2017.
 *
 * @author Kaikenov Adilkhan
 */
public class DateUtil {

    private static final String DATE_PATTERN = "yyyy/MM/dd";
    private static SimpleDateFormat simpleDateFormat;

    public static String parseDateToString(Date date, Locale locale) {
        simpleDateFormat = new SimpleDateFormat(DATE_PATTERN, locale);
        return simpleDateFormat.format(date);
    }
}

package com.epam.adk.web.news.util;

import com.epam.adk.web.news.exception.DateParsingException;

import java.text.ParseException;
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

    public static Date parseStringToDate(String source) throws DateParsingException {
        Date date;
        simpleDateFormat = new SimpleDateFormat(DATE_PATTERN);
        try {
            date = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            throw new DateParsingException(e);
        }
        return date;
    }
}

package com.yss.sqlWord.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  <p> 时间工具类 </p>
 *
 * @description:
 * @author: yss
 */
public class DateTimeUtils {

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String[] PARSE_PATTERNS = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM",
            "yyyyMMddHHmm"
    };


    /**
     * 时间格式化成字符串
     * @param date Date
     * @param pattern StringUtils.DATE_TIME_PATTERN || StringUtils.DATE_PATTERN， 如果为空，则为yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static String dateFormat(Date date, String pattern) throws ParseException{
        if(StringUtils.isBlank(pattern)){
            pattern = DateTimeUtils.DATE_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

}

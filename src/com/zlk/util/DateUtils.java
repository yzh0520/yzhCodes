package com.zlk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @ClassName： DateUtils
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/22 17:43
 */

public class DateUtils {

    public static Date stringToDate(String str) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.parse(str);
    }

}

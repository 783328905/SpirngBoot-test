package com.ctillnow.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by caiping on 2019/10/12.
 */
public class TimeUtil {

    public static String getDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        return simpleDateFormat.format(new Date());
    }
}

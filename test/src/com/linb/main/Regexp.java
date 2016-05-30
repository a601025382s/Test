package com.linb.main;

import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Regexp
 * @Description 正则
 * @author linb
 * @date 2016年4月1日 上午10:36:43
 */
public class Regexp {
    public static void main(String[] args) {
        String str = "<p>你好</p><p>不好</p>";
        Pattern pattern = Pattern.compile("</?[a-zA-Z]*?>");
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            matcher.appendReplacement(
                    sb,
                    "");
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }
}

package com.linb.main;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
class Num {
    Integer num;
    Num() {
        num = 1;
    }
}
class Student {
    public String name;
    public int age;

    public Student() {
        this.name = "linb";
        this.age = 20;
    }

    public String toString() {
        return this.name + "," + this.age;
    }
}
public class Test {
    

    public static void main(String[] args) throws UnsupportedEncodingException{
        System.out.println("测试");
    }
    
    public static void test7() {
        Class<Student> c = Student.class;
        try {
            System.out.println(c.getDeclaredField("age").getInt(new Student()));
            Method method = c.getDeclaredMethod("toString");
            Student student = c.newInstance();
            System.out.println(method.invoke(student));
        } catch(Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void test6() {
        Map<Integer, String> map = new HashMap<Integer, String>(); 
        map.put(1, "a");
        map.put(2, "b");
        for(Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "," + entry.getValue());
        }
        
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
    
    public static void test5(Num a) {
        a.num++;
    }
    
    public static void test4(Integer num) {
        num++;
    }
    
    public static void test3(int[] nums) {
        if (null != nums) {
            for (int i = 0; i < nums.length; i++) {
                nums[i]++;
            }
        }
    }
    
    public static void test2() {
        String a = "abc";
        String b = "abc";
        String c = new String("abc");
        System.out.println(a == b);
        System.out.println(b == c);
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
    }

    /**
     * @Description 引用测试
     */
    public static void quote(Student stu) {
        stu.name = "yao";
        stu.age = 21;
    }

    public static void regex() throws UnsupportedEncodingException {
        String str = "abcabcabc";
        Pattern pattern = Pattern.compile("(a)");
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            matcher.appendReplacement(
                    sb,
                    "[[EMOJI:"
                            + URLEncoder.encode(matcher.group(1), "UTF-8")
                            + "]]");
        }
        matcher.appendTail(sb);
        System.out.println(sb.toString());
    }

    public static void findOS() {
        Properties prop = System.getProperties();
        String os = prop.getProperty("os.name");
        System.out.println(os);
    }

    public static void deci() throws ParseException {
        DecimalFormat df = new DecimalFormat("#.##");
        Double d = -12123.55;
        Double f = +12.0;
        Double g = 0.0;
        String str = "12.3";
        System.out.println(df.format(d));
        System.out.println(df.format(f));
        System.out.println(df.format(g));
        System.out.println(df.parse(str));

        Double num = 0.0;
        System.out.println(num.equals(0.0));
    }

    public static void test1() {
        Integer[] num = new Integer[1000];
        Integer len = init(num);
        System.out.println(len);
        int sum = 0;
        int max = 100000;
        for(int k = 0; k < max; k++) {
            int count = 0;
            Integer[] res = { 0, 0, 0, 0, 0, 0, 0, 0 };
            while(true) {
                Random rand = new Random();
                int a = Math.abs(rand.nextInt()) % len;
                // System.out.println("num[" + a + "]=" + num[a]);
                res[num[a]] = 1;
                count++;

                boolean flag = check(res);
                // System.out.println("flag:" + flag);
                if(flag) {
                    // System.out.println(count);
                    sum += count;
                    break;
                }
            }
        }
        System.out.println(sum);
        System.out.println(1.0 * sum / max);
    }

    public static boolean check(Integer[] res) {
        boolean flag = false;
        int i;
        // 1
        for(i = 0; i < 4; i++) {
            // System.out.println("res[" + i + "]:" + res[i]);
            if(res[i] == 0) {
                break;
            }
        }
        if(i >= 4) {
            flag = true;
        }
        // 2
        for(i = 4; i < 8; i++) {
            // System.out.println("res[" + i + "]:" + res[i]);
            if(res[i] == 0) {
                break;
            }
        }
        if(i >= 8) {
            flag = true;
        }
        // 3
        // for (i = 0; i < 8; i++) {
        // // System.out.println("res[" + i + "]:" + res[i]);
        // if (res[i] == 0) {
        // break;
        // }
        // }
        if(i >= 8) {
            flag = true;
        }
        return flag;
    }

    public static int init(Integer[] num) {
        int[] a = { 93, 1, 1, 1, 1, 1, 1, 1 };
        int k = 0;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < a[i]; j++) {
                num[k++] = i;
            }
        }
        return k;
    }

    public static void time() {
        Long time = System.currentTimeMillis();
        Long day = 1000L * 60 * 60 * 24;
        System.out.println(day);
        System.out.println(new Date(0));
        System.out.println(time % day);
        System.out.println(time - time / day * day);
        time = time / day * day;
        SimpleDateFormat format = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        System.out.println(new Date(time));
        System.out.println(format.format(date));
    }

    public static int dfs(String str, int num) {
        if(num == 0) {
            if(str.contains("1234") || str.contains("5678")) {
                // System.out.println(str);
                return 1;
            } else {
                return 0;
            }
        }
        int sum = 0;
        for(int i = 1; i <= 8; i++) {
            sum += dfs(str + String.valueOf(i), num - 1);
        }
        return sum;
    }

    public void test() {

    }
}

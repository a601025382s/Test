package com.linb.algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class JuneActivity2 {
    public static final Integer c[] = {-3, -1, 1, 3};
    
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>(); // 移动次数
        Map<String, String> pre = new HashMap<String, String>(); // 来源 
        String a = "123456789";
        Queue<String> q = new LinkedList<String>();
        q.add(a);
        while(!q.isEmpty()) {
            String p = q.poll();
            int pos = p.indexOf("9");
            for (int i = 0 ; i < 4; i++) {
                int k = pos + c[i];
                if (k < 0 || k >=9 || (c[i] == 1 && k == 3) || (c[i] == 1 && k == 6) || (c[i] == -1 && k == 2) || (c[i] == -1 && k == 5)) {
                    continue;
                }
                String u = change(new StringBuffer(p), pos, k);
                if (null == map.get(u)) {
                    q.add(u);
                }
                check(p, u, map, pre);
            }
//            if (null != map.get("123456789")) {
//                System.out.println(map.get("123456789"));
//                String last = "123456789";
//                while (!"723486159".equals(last)) {
//                    System.out.println(last);
//                    last = pre.get(last);
//                }
//                // break;
//            }
        }
    }
    
    private static void check(String a, String b, Map<String, Integer> map,
            Map<String, String> pre) {
        int num = (null == map.get(a) ? 0 : map.get(a)) + 1;
        if (null == map.get(b) || num < map.get(b)) {
            map.put(b, num);
            pre.put(b, a);
        }
        System.out.println(a + "-" + b + "-" + num);
    }

    public static String change(StringBuffer str, int st, int en) {
        char t = str.charAt(st);
        str.setCharAt(st, str.charAt(en));
        str.setCharAt(en, t);
        return str.toString();
    }
}

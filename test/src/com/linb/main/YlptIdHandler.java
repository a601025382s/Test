package com.linb.main;

import com.linb.util.IdHandler;

public class YlptIdHandler {
    private static String[] ids = {"oKOapyb3wOejxcf4uGdEeA","gQwBCOU-etQx9hLRS_1pTQ"};
    private static Integer[] ids2 = {19, 20, 21, 27, 28, 31, 42, 43, 44, 45, 46};
    public static void main(String[] args) {
        // 加密
//        for (int i = 0; i < 17; i++) {
//            String res = IdHandler.idEncrypt(i);
//            // System.out.println(i + " : " + res);
//            System.out.print(", '" + res + "'");            
//        }
//        System.out.println();
        encrypt();
        // 解密
        decrypt();
        // 多个加密
        //encrypt2();
    }
    
    /**
     * @Description 加密
     */
    public static void encrypt() {
        String res = IdHandler.idEncrypt(43);
        System.out.println(res);
    }
    
    public static void encrypt2() {
        for (int i = 0; i < ids2.length; i++) {
            System.out.println(ids2[i] + ":" + IdHandler.idEncrypt(ids2[i]));
        }
    }
    
    /**
     * @Description 解密
     */
    public static void decrypt() {
        System.out.print("(");
        for (int i = 0; i < ids.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(IdHandler.idDecrypt(ids[i]));
        }
        System.out.println(")");
        // System.out.println(IdHandler.idDecrypt("4brZM-p8U9icHj_c60QtcQ"));
        for (int i = 0; i < ids.length; i++) {
            System.out.println(IdHandler.idDecrypt(ids[i]) + ":" + ids[i]);
        }
    }
}

package com.linb.algorithm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SimpleProblem {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();
        
        sort();
        
        Long endTime = System.currentTimeMillis();
        System.out.println("total time : " + (endTime - startTime));
    }
    
    // 算法计数
    private static Integer count = 0;
    
    // 打印数组-object
    public static void print(Object[] objects) {
        int i = 0;
        for (Object object : objects) {
            System.out.println("第" + i + "个：" + object);
            i++;
        }
    }
    // 打印数组-int
    public static void print(int[] objects) {
        int i = 0;
        for (Object object : objects) {
            System.out.println("第" + i + "个：" + object);
            i++;
        }
    }
    
    // 交换
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    // 1 素数
    // 1.1 判断素数
    public static boolean isPrime(Integer num) {
        if (null == num || num <= 1) {
            return false;
        }
        int temp = (int) Math.sqrt(num + 0.0001);
        for (int i = 2; i <= temp; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // 1.2 筛选范围内的素数
    public static void initPrimes() {
        int maxNum = 1000;
        Boolean[] primes = new Boolean[maxNum];
        for (int i = 0; i < maxNum; i++) {
            primes[i] = true;
        }
        primes[0] = primes[1] = false;
        int m = (int) Math.sqrt(maxNum) + 1;
        
        count = 0;
        for (int i = 2; i <= m; i++) {
            for (int j = i * i; j < maxNum; j += i) {
                primes[j] = false;
                count++;
            }
        }
        print(primes);
        System.out.println(count);
    }
    
    // 2. 回文数
    public static void palindrome() {
        
        int maxNum = 1000000;
        for (int i = 0; i < maxNum; i++) {
            if (isPalindrome2(i)) {
                System.out.println(i);
            }
        }
    }
    
    // 2.1 判断回文数
    public static boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        List<Integer> nums = new ArrayList<Integer>();
        while(num != 0) {
            nums.add(num % 10);
            num = num / 10;
        }
        int len = nums.size();
        for (int i = 0 ; i < len / 2; i++) {
            if (!nums.get(i).equals(nums.get(len - i - 1))) {
                return false;
            }
        }
        return true;
    }
    
    // 2.2 判断回文数2
    public static boolean isPalindrome2(int num) {
        if (num < 0) {
            return false;
        }
        String str = String.valueOf(num);
        int len = str.length();
        for (int i = 0 ; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    // 3 时间
    // 3.1 下一天
    public static void nextDay(String dateStr) {
        try {
            System.out.println("currentTime：" + dateStr);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // H为24小时制，h为12小时制
            Date date = format.parse(dateStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, -1);
            Date beforeDate = cal.getTime();
            System.out.println("beforeTime：" + format.format(beforeDate));
        } catch(ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    // 4 递归
    public static void dfs() {
        int n = 50;
        int m = 3;
        int[] f = new int[n + 1];
        f[1] = 1;
        for (int i = 2; i <= n; i++){
            f[i] = (f[i] - m + i) % i;
        }
        System.out.println(f[50]);
    }
    
    // 5 排序
    public static void sort() {
        int[] nums = {1, 3, 9, 4, 2, 8, 5, 6, 7, 0};
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        print(nums);
        
    }
    
    // 5.1 冒泡排序
    public static void maoPaoSort() {
        Integer[] nums = {1, 3, 9, 4, 2, 8, 5, 6, 7, 0};
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j-- ) {
                if (nums[j] > nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                }
            }
        }
        print(nums);
    }
    
    // 5.2 直接插入排序
    public static void insertSort() {
        Integer[] nums = {1, 3, 9, 4, 2, 8, 5, 6, 7, 0};
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if(nums[j] >= temp) {
                    nums[j + 1] = temp;
                    break;
                }
                nums[j + 1] = nums[j];
                if (j == 0) {
                    nums[j] = temp;
                }
            }
        }
        print(nums);
    }
    
    // 5.3 选择排序
    public static void selectSort() {
        Integer[] nums = {1, 3, 9, 4, 2, 8, 5, 6, 7, 0};
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int k = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[k] < nums[j]) {
                    k = j;
                }
            }
            int temp = nums[k];
            nums[k] = nums[i];
            nums[i] = temp;
        }
        print(nums);
    }
    
    // 5.4 快速排序
    public static void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        if (high - low == 1) { // 两个数字
            if (a[0] > a[1]) {
                swap(a, 0, 1);
            }
            return ;
        }
        int p = a[low]; // 中间数
        int left = low + 1;
        int right = high;
        while (left < right) {
            // 从左开始
            while (left < right && left <= high) {
                if (a[left] > p) {
                    break;
                }
                left++;
            }
            // 从右开始
            while (left <= right && right > low) {
                if (a[right] < p) {
                    break;
                }
                right--;
            }
            // 未结束
            if (left < right) {
                swap(a, left, right);
            }
        }
        swap(a, low, right); // 交换中间数
        quickSort(a, low, right); // 快排前部分
        quickSort(a, right + 1, high); // 快排后部分 
    }
}

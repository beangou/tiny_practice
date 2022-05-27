package com.beangou.year2021.month12.day25;

import java.util.Scanner;

public class Main {

    // aaa_password_"a12_45678"_timeout__100_""_
    // aaa_password_******_timeout_100_""
    // aaa_password_******_45678"_timeout_100_""_


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int idx = sc.nextInt();
        String str = sc.next();

        if (str == null || str == "") {
            System.out.println("ERROR");
            return;
        }

        // 处理掉 字符串前后多余的 _
        while (str.indexOf("_") == 0) {
            str = str.substring(1);
        }
        while (str.lastIndexOf("_") == str.length()-1) {
            str = str.substring(0, str.length()-1);
        }

        // 先找到需要替换的完整字符串
        int meaningfulIdx = 0;
        String[] allStr = str.split("");
        boolean lastIsUnderLine = false;
        boolean containsDouble = false;
        int startIdx = 0;
        int endIdx = 0;
        boolean startSet = false;

        // aaa_password_"a12_45678"_timeout__100_""_
        for (int i = 0; i < allStr.length; i++) {
            if ("_".equals(allStr[i])) {
                if (lastIsUnderLine) {
                    continue;
                }
                if (meaningfulIdx != idx) {
                    meaningfulIdx++;
                }
                if (startSet && !containsDouble) {
                    endIdx = i;
                    break;
                }
            } else {
                lastIsUnderLine = false;
                if (meaningfulIdx == idx) {
                    if (!containsDouble && !startSet) {
                        startIdx = i;
                        startSet = true;
                        if ("\"".equals(allStr[i])) {
                            containsDouble = true;
                        }
                    } else {
                        if (containsDouble && "\"".equals(allStr[i])) {
                            endIdx = i;
                            break;
                        }

                    }
                }
            }
        }

        int trueIdx = containsDouble ? endIdx+1 : endIdx;

        String backStr = str.substring(0, startIdx) + "******" + str.substring(trueIdx);

//        // 将所有多个 _ 连在一起的字符替换为单个 _
        while (backStr.indexOf("__") > -1) {
            backStr = backStr.replaceAll("__", "_");
        }

        System.out.println(backStr);
    }

    /// 1
    //password__a12345678_timeout_100
    public static void main2(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int idx = sc.nextInt();
        String str = sc.next();

        System.out.println("idx=" + idx + "; str=" + str);
        if (str == null || str == "") {
            System.out.println("ERROR");
            return;
        }

        // 处理掉 字符串前后多余的 _
        while (str.indexOf("_") == 0) {
            str = str.substring(1);
        }
        while (str.lastIndexOf("_") == str.length()-1) {
            str = str.substring(0, str.length()-1);
        }
        System.out.println("remove first and last str===" + str);

        // 先找到需要替换的完整字符串
        int meaningfulIdx = 0;
        String[] allStr = str.split("");
        boolean lastIsUnderLine = false;
        boolean containsDouble = false;
        int startIdx = 0;
        int endIdx = 0;
        boolean startSet = false;

        // aaa_password_"a12_45678"_timeout__100_""_
        for (int i = 0; i < allStr.length; i++) {
            if ("_".equals(allStr[i])) {
                if (lastIsUnderLine) {
                    continue;
                }
                if (meaningfulIdx != idx) {
                    meaningfulIdx++;
                }
                if (startSet && !containsDouble) {
                    endIdx = i;
                    break;
                }
            } else {
                lastIsUnderLine = false;
                if (meaningfulIdx == idx) {
                    if (!containsDouble && !startSet) {
                        startIdx = i;
                        startSet = true;
                        if ("\"".equals(allStr[i])) {
                            containsDouble = true;
                        }
                    } else {
                        if (containsDouble && "\"".equals(allStr[i])) {
                            endIdx = i;
                            break;
                        }

                    }
                }
            }
        }

        int trueIdx = containsDouble ? endIdx+1 : endIdx;
        System.out.println("startIdx="+startIdx + "; endIdx=" + trueIdx);

        String subStr = str.substring(startIdx, trueIdx);
        System.out.println("subStr=" + subStr);

        String backStr = str.substring(0, startIdx) + "******" + str.substring(trueIdx);
        System.out.println("backStr=" + backStr);

//        // 将所有多个 _ 连在一起的字符替换为单个 _
        while (backStr.indexOf("__") > -1) {
            backStr = backStr.replaceAll("__", "_");
        }

        System.out.println("backStr===="+backStr);
//
//        // 如果需要替换的正好有 "" 包含，则需要将
//
//        // 找出第 idx 个元素
//        String[] arr = str.split("_");
//        if (idx > arr.length) {
//            System.out.println("ERROR");
//            return;
//        }
//
//        if (arr[idx].indexOf("\"") > -1) {
//
//            return;
//        }
//
//        arr[idx] = "******";
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < arr.length; i++) {
//            sb.append(arr[i]).append("_");
//        }
//
//        System.out.println(sb);
    }
}

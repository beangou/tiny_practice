package com.beangou.year2021.month12;// 实现两个字符串表示的正整数想加

import org.junit.Test;

public class Sum {

  @Test
  public void see() throws Exception {
      System.out.println(bigSum("152132", "991299"));
  }

  public String bigSum(String str1, String str2) throws Exception {
      if (str1 == null || str2 == null) {
         // 判断参数是否合法
         throw new Exception("参数不合法"); 
      }
      
    
      String[] str1Arr = str1.split("");
      String[] str2Arr = str2.split("");
      
      
      // 位数不等，用0补足
      if (str1Arr.length > str2Arr.length) {
         for (int i=0; i< (str1Arr.length-str2Arr.length); i++) {
            str2 = "0"+str2;
         }
      }
      if (str2Arr.length > str1Arr.length) {
         for (int i=0; i< (str2Arr.length-str1Arr.length); i++) {
            str1 = "0"+str1;
         }
      }
    
      
      str1Arr = str1.split("");
      str2Arr = str2.split("");
    
      int arrLen = str2Arr.length;
      String[] result = new String[arrLen];
      
      // 是否需要进一位
      boolean needAndOne = false;
      for(int i=arrLen-1; i>=0; i--) {
          int everySum = Integer.parseInt(str1Arr[i]) + Integer.parseInt(str2Arr[i]);
          if (needAndOne) {
             everySum += 1;
          } 
          if (everySum >= 10) {
            needAndOne = true;
            result[i] = String.valueOf(everySum-10);
          } else {
            needAndOne = false;
            result[i] = String.valueOf(everySum);
          }
      }
    
      StringBuffer sb = new StringBuffer();
      if (needAndOne) {
          sb.append("1");
      }
      for (int i=0; i<result.length; i++) {
          sb.append(result[i]);
      }
      return sb.toString();
  }
  
  /**
  * 123
  */
//  private int str2Int(String str) {
//      String[] str1Arr = str.split("");
//      int len = str1Arr.length();
//      int result = 0;
//      for (int i=0; i<len; i++) {
//         char strInt = (char)str1Arr[i]; // TODO
//
//      }
//      return result;
//  }
  
}
package com.beangou.year2021.month11.day21;

import org.junit.Test;

public class Solution2 {

    @Test
    public void test() {
//        int arr[] = new int[]{-1, 3, 9};
//        tranArr(arr, 6);
//        int arr[] = new int[]{1, 8};
//        tranArr(arr, 3);

        int arr[] = new int[]{2};
        tranArr(arr, 0);
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param arrA int整型一维数组
     * @param K int整型
     * @return int整型一维数组
     */
    public int[] tranArr (int[] arrA, int K) {
        // write code here
        // 找出数组最大值、最小值
        int max = arrA[0];
        int min = arrA[0];

        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] < min) {
                min = arrA[i];
            }
            if (arrA[i] > max) {
                max = arrA[i];
            }
        }

        // 算出 最大-最小 只差
        int maxSubResult = max-min;
        System.out.println("maxSubResult=" + maxSubResult);

        // 理想中的K值
        int hopeK = maxSubResult/2;

        // 数组最终偏向的值
        int hopeVal = 0;
        if (K < hopeK) {
            hopeVal = min + K;
        } else {
            hopeVal = min + hopeK;
        }
        System.out.println("hopeVal==" + hopeVal);

        int[] arrNew = new int[arrA.length];

        // 生成新的数组
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] < hopeVal) {
                arrNew[i] = (arrA[i]+K>hopeVal) ? hopeVal : arrA[i]+K;
            } if (arrA[i] > hopeVal) {
                arrNew[i] = (arrA[i]-K<hopeVal) ? hopeVal : arrA[i]-K;
            } else {
                arrNew[i] = hopeVal;
            }
        }

        int newMin = arrNew[0];
        int newMax = arrNew[0];
        // 遍历新的数组，返回最小、最大值
        for (int i = 0; i < arrNew.length; i++) {
            if (arrNew[i] < newMin) {
                newMin = arrNew[i];
            }
            if (arrNew[i] > newMax) {
                newMax = arrNew[i];
            }
        }

        System.out.println(newMin + ";" + newMax);
        return new int[]{newMin, newMax};
    }

}

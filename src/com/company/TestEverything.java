package com.company;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

public class TestEverything {

    public static void main(String[] args) {
//        String patternStr = "^([1]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
//                "([1]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
//                "([1]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
//                "([1]?\\d\\d?|2[0-4]\\d|25[0-5])\\$";
//
//        Pattern pattern = Pattern.compile(patternStr);

//        List<Object> list = new ArrayList<>();

//        while (true){
//            Object object = new Object();
//            object.hashCode();
//        }

//        movBit(-1);
//        movBit(0);
//        movBit(1);
//        movBit(3);
//
        TestEverything everything = new TestEverything();
        for(int i : everything.twoSum(new int[]{7,3,4,3},6)){
            System.out.println(i);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        final int il = nums.length;
        int il2 = (il >> 2) - 1;

        int pot = 2;
        while((il2 >>= 1) > 0) pot <<= 1;
        final int bitMod = pot - 1;
        final int[] bucket = new int[pot];
        final int[] linked = new int[il];

        final int firstVal = nums[0];

        for (int i = 1; i < il; i++) {
            int currNum = nums[i];
            int complement = target - currNum;

            if (complement == firstVal) {
                return new int[] { 0, i };
            }

            int complementLLIndex = bucket[complement & bitMod];
            while(complementLLIndex != 0) {
                if(nums[complementLLIndex] == complement) {
                    //Found
                    return new int[] { complementLLIndex, i };
                }
                complementLLIndex = linked[complementLLIndex];
            }
            int currNumLLIndex = currNum & bitMod;
            linked[i] = bucket[currNumLLIndex];
            bucket[currNumLLIndex] = i;
        }
        return null;
    }

    private static void movBit(int i){
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i << 1));
        System.out.println(Integer.toBinaryString(i << 2));
        System.out.println(Integer.toBinaryString(i << 29));
        System.out.println("---------------------------------");
    }


}

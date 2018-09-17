package com.company.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static int firstNonRepeatingChar(String str) {
        Map<Character,Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
//            if(map.containsKey(c)){
//                map.put(c,map.get(c) + 1);
//            }else{
//                map.put(c,1);
//            }
            map.merge(c,1,(old,notUsed) -> old+1);
        }
        int len = str.length();
        for(int i = 0;i < len;i++){
            if(map.get(str.charAt(i)) == 1) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        String string = "aabbcdef";
        System.out.println(firstNonRepeatingChar(string));
    }
}

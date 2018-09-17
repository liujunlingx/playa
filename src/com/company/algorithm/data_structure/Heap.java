package com.company.algorithm.data_structure;

import java.util.*;

public class Heap {

    //top K problem
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        Comparator<String> c = (s1, s2)->{
            if(map.get(s1) > map.get(s2)){
                return -1;
            }
            if(map.get(s1) == map.get(s2)){
                return s1.compareTo(s2);
            }
            return 1;
        };
        PriorityQueue<String> heap = new PriorityQueue<>(k,c);
        for(String str : words){
            map.merge(str, 1, (oldValue, newValue) -> oldValue + newValue);
        }

        heap.addAll(map.keySet());

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(heap.poll());
        }

        return result;
    }
}

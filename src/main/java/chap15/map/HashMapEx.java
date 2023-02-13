package chap15.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("John", 20);
        map.put("Jane", 21);
        map.put("Emily", 22);
        map.put("Gzero",23);
        map.put("Zoe", 24);
        map.put("Emily", 24); //키값이 중복되서 새로운 애로 바뀜

        System.out.println(map.get("Emily"));

        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Integer value = map.get(key);
            System.out.println(key +"     "+value);
        }

        System.out.println(map.remove("Gzero") + "이 지워졌습니다");
        System.out.println(map.size());


        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entries.iterator();

        while (entryIterator.hasNext()){
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key +"  "+ value);

        }







    }
}

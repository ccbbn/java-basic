package chap15.check.q9;

import java.util.*;


public class MapEx {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("blue", 96);
        map.put("hong", 86);
        map.put("white", 92);

        String name = null;
        int maxScore = 0;
        int totalScore = 0;

        Set<String> keys = map.keySet();  // map의 모든 키를 Set으로 얻음
        Iterator<String> iterator = keys.iterator(); // iterator(): iterator인터페이스를 구현한 객체


        while (iterator.hasNext()){  //iterator에 가져올 개쳬가 있으면 true

            String key = iterator.next(); // 키 값 하나를 가져옴
            Integer value = map.get(key); // 키 값을 넣으면 해당하는 값이 나옴

            totalScore += map.get(key);

            if ( maxScore < map.get(key)){
                maxScore = map.get(key);
            }

            if ( map.get(key) == maxScore){
                name = key;
            }

        }


        System.out.println("최고점수를 받은 아이디" +  name);
        System.out.println("최고점수" + " : " + maxScore);
        System.out.println("평균 점수" + " : " + totalScore/(map.size()));

    }
}

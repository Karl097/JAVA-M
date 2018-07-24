package set;

import java.util.*;

public class CollectionExercise4 {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>();
        HashMap<String,String> temp = new HashMap<>();
        map.put("adc", "物理英雄");
        map.put("apc", "魔法英雄");
        map.put("t", "坦克");

        System.out.println("初始化后的Map:");
        System.out.println(map);
        Set<String> keys = map.keySet();

        for (String key : keys) {
            String value = map.get(key);
            temp.put(value, key);
        }
        map.clear();
        map.putAll(temp);

        System.out.println("反转后的Map:");
        System.out.println(map);
    }
}

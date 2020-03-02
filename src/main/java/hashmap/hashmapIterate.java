package hashmap;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class hashmapIterate {

    public static void main(String[] args) {

        Map<Integer,String> map = new HashMap();
        map.put(1,"v1");
        map.put(2,"v2");
        map.put(3,"v3");
        map.put(4,"v4");
        map.put(5,"v5");
        map.put(6,"v6");

        // 1.forEach
//        useForEach(map);

        // 2. forEach key or val
//        useForEachKeyOrValue(map);

        // 3. Iterator
//        useIterator(map);

        // 4. Lambda
        useLambda(map);
    }

    private static void useForEach(Map<Integer,String> map){
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    private static void useForEachKeyOrValue(Map<Integer,String> map){
        for(Integer key : map.keySet()){
            System.out.println("Key = " + key);
        }

        for (String val : map.values()){
            System.out.println("Value = "+ val);
        }
    }

    private static void useIterator(Map<Integer,String> map){
        Iterator<Map.Entry<Integer,String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
    }

    private static void useLambda(Map<Integer,String> map){
        map.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));
    }
}

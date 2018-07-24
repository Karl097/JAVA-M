package set;

import java.util.HashSet;

public class Hashset {
    public static void main(String[] args) {
        HashSet<String> names=new HashSet<>();

        names.add("garen");
        System.out.println(names);

        names.add("garen");
        names.add("teemo");
        System.out.println(names);

        // Set中的元素排列，不是按照插入顺序
        HashSet<Integer> numbers=new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(4);
        numbers.add(3);

        System.out.println(numbers);
    }
}

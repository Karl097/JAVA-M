package set;

import java.util.HashSet;
import java.util.Iterator;

//Set不提供get()来获取指定位置的元素
//        所以遍历需要用到迭代器，或者增强型for循环
public class Hashset2 {
    public static void main(String[] args) {
        HashSet<Integer> numbers=new HashSet<>();

        for (int i=0;i<20;i++){
            numbers.add(i);
        }

        //迭代器
        for (Iterator<Integer> iterator=numbers.iterator();iterator.hasNext();){
            Integer i=iterator.next();
            System.out.print(i+"\t");
        }

        System.out.println();


        //增强型for循环
        for (Integer i:numbers){
            System.out.print(i+"\t");
        }
    }
}

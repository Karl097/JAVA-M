package set;

import java.util.HashSet;

//生成50个 0-9999之间的随机数，要求不能有重复的
public class RandomNumbers {
    public static void main(String[] args) {
        HashSet<Integer> HashNumbers=new HashSet<>();

        for (int i=0;i<50;i++){
            HashNumbers.add((int)(Math.random()*9999));
        }

        System.out.println(HashNumbers);
    }
}

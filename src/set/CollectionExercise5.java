package set;

import java.util.LinkedHashSet;

//利用LinkedHashSet的既不重复，又有顺序的特性，把Math.PI中的数字，按照出现顺序打印出来，相同数字，只出现一次
public class CollectionExercise5 {
    public static void main(String[] args) {
        LinkedHashSet<Integer> PI=new LinkedHashSet<>();

        String str=String.valueOf(Math.PI);
        str=str.replace(".","");
        char ch[]=str.toCharArray();
        for (char c:ch){
            int i=Integer.parseInt(String.valueOf(c));
            PI.add(i);
        }
        System.out.println(PI);
    }
}

package set;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestCollection {
    public static void insertNum(List<Integer> l,String type){
        final int number=5;
        long start=System.currentTimeMillis();
        for (int i=0;i<1000*100;i++){
            l.add(0,number);
        }
        long end=System.currentTimeMillis();

        System.out.printf("在%s最前面插入100000条数据，总共耗时%d毫秒\n",type,end-start);
    }

    public static void main(String[] args) {
        List<Integer> l;
        l=new ArrayList<>();
        insertNum(l,"arraylist");

        l=new LinkedList<>();
        insertNum(l,"linkedlist");
    }
}

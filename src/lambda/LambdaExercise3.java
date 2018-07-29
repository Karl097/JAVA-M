package lambda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class LambdaExercise3 {
    public static void insertFirst(Supplier<List> s, String type){
        int total=1000*100;
        final int number=5;
        long start=System.currentTimeMillis();
        List l=s.get();
        for (int i=0;i<total;i++){
            l.add(0,number);
        }
        long end=System.currentTimeMillis();
        System.out.printf("在%s前面插入%d条数据总共耗时%d毫秒\n",type,total,end-start);
    }

    public static void main(String[] args) {
        insertFirst(ArrayList::new,"ArrayList");
        insertFirst(LinkedList::new,"LinkedList");
    }
}

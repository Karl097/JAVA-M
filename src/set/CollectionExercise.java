package set;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//首先初始化一个List,长度是10，值是0-9。
//        然后不断的shuffle，直到前3位出现
//        3 1 4
//
//        shuffle 1000,000 次，统计出现的概率
public class CollectionExercise {
    public static void main(String[] args) {
        //初始化
        List<Integer> numbers=new ArrayList<>();

        for (int i=0;i<10;i++){
            numbers.add(i);
        }

        int count=0;

        int total=1000000;
        for (int i=0;i<total;i++){
            Collections.shuffle(numbers);
            if (numbers.get(0)==3&&numbers.get(1)==1&& numbers.get(2)==4){
                count++;
            }
        }

        System.out.println("一共出现了"+count+"次，概率为："+(double)count/total*100+"%");
    }
}

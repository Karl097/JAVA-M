package set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCollection1 {
    public static void main(String[] args) {
        List<Integer> numbers=new ArrayList<>();

        for (int i=0;i<10;i++){
            numbers.add(i);
        }

        System.out.println("反转之前的数据：");
        System.out.println(numbers);

        //reverse使List中的数据反转
        Collections.reverse(numbers);

        System.out.println("反转之后的数据：");
        System.out.println(numbers);

        //shuffle 混淆List中数据的顺序
        Collections.shuffle(numbers);

        System.out.println("混淆之后的的数据：");
        System.out.println(numbers);

        // sort 对List中的数据进行排序
        Collections.sort(numbers);

        System.out.println("排序之后的数据：");
        System.out.println(numbers);

        //swap 交换两个数据的位置
        Collections.swap(numbers,0,5);

        System.out.println("交换之后的数据：");
        System.out.println(numbers);

        //rotate 把List中的数据，向右滚动指定单位的长度
        Collections.rotate(numbers,2);

        System.out.println("滚动之后的数据：");
        System.out.println(numbers);

        //synchronizedList 把非线程安全的List转换为线程安全的List。
        System.out.println("把非线程安全的List转换为线程安全的List");
        List<Integer> synchronizedNumbers = (List<Integer>) Collections.synchronizedList(numbers);


    }
}

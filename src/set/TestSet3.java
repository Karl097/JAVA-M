package set;

import java.util.ArrayList;

//通过get获取指定位置的对象，如果输入的下标越界，一样会报错
public class TestSet3 {
    public static void main(String[] args) {
        ArrayList heroes=new ArrayList();

        for (int i=0;i<5;i++){
            heroes.add(new Hero("hero"+i));
        }
        System.out.println(heroes.get(4));
        //下标越界同样报错
        System.out.println(heroes.get(5));
    }
}

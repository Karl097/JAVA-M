package set;

import java.util.ArrayList;

public class TestSet1 {
    public static void main(String[] args) {
        ArrayList heroes=new ArrayList();

//        heroes.add(new Hero("garen"));
//        System.out.println(heroes.size());
//
//        //容器的容量"capacity"会随着对象的增加，自动增长
//        //只需要不断往容器里增加英雄即可，不用担心会出现数组的边界问题
//        heroes.add(new Hero("teemo"));
//        System.out.println(heroes.size());
        //第一种方式添加对象
        for (int i=0;i<5;i++){
            heroes.add(new Hero("hero"+i));
        }
        System.out.println(heroes);

        //第二种方式在指定位置添加对象
        heroes.add(3,"garen");
        System.out.println(heroes);
    }
}

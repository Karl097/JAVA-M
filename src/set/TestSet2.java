package set;

import java.util.ArrayList;

//通过方法contains 判断一个对象是否在容器中
//        判断标准： 是否是同一个对象，而不是name是否相同

//indexOf用于判断一个对象在ArrayList中所处的位置
//        与contains一样，判断标准是对象是否相同，而非对象的name值是否相等
public class TestSet2 {
    public static void main(String[] args) {
        ArrayList heroes=new ArrayList();

        for (int i=0;i<5;i++){
            heroes.add(new Hero("hero"+i));
        }
        Hero specialhero=new Hero("specialhero");
        heroes.add(specialhero);
        System.out.println(heroes);

        System.out.println(heroes.contains(new Hero("hero"+1)));
        System.out.println("虽然name都是hero1，但是不是指向同一个对象");

        System.out.println(heroes.contains(specialhero));
        System.out.println("判断的标准是是否为同一个对象，而不是name相同");

        System.out.println(heroes.indexOf(specialhero));
        //新英雄hero1虽然名字相同，但不是同一个对象
        System.out.println(heroes.indexOf(new Hero("hero1")));

    }
}

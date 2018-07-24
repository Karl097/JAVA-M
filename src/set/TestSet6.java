package set;

import java.util.ArrayList;
import java.util.List;

//ArrayList实现了接口List
//        常见的写法会把引用声明为接口List类型
//        注意：是java.util.List,而不是java.awt.List
//        因为ArrayList实现了List接口，所以List接口的方法ArrayList都实现了
public class TestSet6 {
    public static void main(String[] args) {
        List heroes=new ArrayList();

        //接口引用指向子类对象（多态）
        heroes.add(new Hero("盖伦"));
        System.out.println(heroes);
        System.out.println(heroes.size());


//        不指定泛型的容器，可以存放任何类型的元素
//        指定了泛型的容器，只能存放指定类型的元素以及其子类
//对于不使用泛型的容器，可以往里面放英雄，也可以往里面放物品
        heroes.add(new Item("冰仗"));
        //对象转型会出现问题
        Hero h1=(Hero)heroes.get(0);
        //尤其是在容器里放的对象太多的时候，就记不清楚哪个位置放的是哪种类型的对象了
        //Hero h2=(Hero)heroes.get(1);

        //引入泛型Generic
        //声明容器的时候，就指定了这种容器，只能放Hero，放其他的就会出错

        List<Hero> genericheroes=new ArrayList<Hero>();
        //简写
        List<Hero> genericheroes2=new ArrayList<>();

        genericheroes.add(new Hero("盖伦"));
        //genericheroes.add(new Item("冰仗"));不能放入除hero类外的其他类
        //但是能放入hero的子类

        Hero h=genericheroes.get(0);
    }
}

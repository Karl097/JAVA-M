package lambda;

import set.Hero;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

//遍历数据的传统方式就是使用for循环，然后条件判断，最后打印出满足条件的数据
//        for (Hero h : heros) {
//        if (h.hp > 100 && h.damage < 50)
//        System.out.println(h.name);
//        }
//        使用聚合操作方式，画风就发生了变化：
//        heros
//        .stream()
//        .filter(h -> h.hp > 100 && h.damage < 50)
//        .forEach(h -> System.out.println(h.name));
public class Lambda7 {
    public static void main(String[] args) {
        Random r=new Random();
        List<Hero> heroes=new ArrayList<>();

        //初始化
        for (int i=0;i<10;i++){
            heroes.add(new Hero("hero"+i,r.nextInt(1000),r.nextInt(100)));
        }
        System.out.println("初始化完成");
        System.out.println(heroes);

        System.out.println("使用传统的for循环遍历查找");
        for (int i=0;i<heroes.size();i++){
            if (heroes.get(i).hp>100&&heroes.get(i).damage<50)
                System.out.println(heroes.get(i).name);
        }

        System.out.println("使用聚合操作进行遍历查找");
        heroes
        .stream()
        .filter(h -> h.hp > 100 && h.damage < 50)
        .forEach(h -> System.out.println(h.name));

        //管道源是数组
        System.out.println("使用数组");
        Hero hs[]=heroes.toArray(new Hero[heroes.size()]);
        Arrays.stream(hs)
                .forEach(h -> System.out.println(h.name));
    }
}

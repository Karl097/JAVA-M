package lambda;

import set.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Filter;

//引用容器中的对象的方法 顶 折 纠 问
//        首先为Hero添加一个方法
//public boolean matched(){
//        return this.hp>100 && this.damage<50;
//        }
//        使用Lambda表达式
//        filter(heroes,h-> h.hp>100 && h.damage<50 );
//        在Lambda表达式中调用容器中的对象Hero的方法matched
//        filter(heroes,h-> h.matched() );
//        matched恰好就是容器中的对象Hero的方法，那就可以进一步改写为
//        filter(heroes, Hero::matched);
//        这种方式就叫做引用容器中的对象的方法
public class Lambda5 {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heroes = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heroes.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heroes);
        System.out.println("使用lambda表达式");
        filter(heroes,h-> h.hp>100 && h.damage<50 );
        System.out.println("在Lambda表达式中调用容器中的对象Hero的方法matched");
        filter(heroes,h->h.matched());
        System.out.println("进一步改写");
        filter(heroes,Hero::matched);
    }
    public static void filter(List<Hero> heroes,HeroChecker c){
        for (Hero h:heroes){
            if (c.test(h))
                System.out.println(h);
        }
    }

}

package lambda;
//使用一个普通方法，在for循环遍历中进行条件判断，筛选出满足条件的数据
import set.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lambda1 {
    public static void main(String[] args) {
        List<Hero> heroes=new ArrayList<>();
        Random r=new Random();

        for (int i=0;i<10;i++){
            heroes.add(new Hero("hero"+i,r.nextInt(1000),r.nextInt(100)));
        }

        System.out.println("初始化完成的heroes");
        System.out.println(heroes);
        System.out.println("使用一般方法筛选出hp>100&&damage<50的英雄");
        filter(heroes);
    }

    public static void filter(List<Hero> heroes){
        for (Hero h:heroes){
            if (h.hp>100&&h.damage<50)
                System.out.println(h);
        }
    }
}

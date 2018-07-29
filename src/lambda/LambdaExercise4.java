package lambda;

import set.Hero;

import java.util.*;

//首选准备10个Hero对象，hp和damage都是随机数。
//        分别用传统方式和聚合操作的方式，把hp第三高的英雄名称打印出来
public class LambdaExercise4 {
    public static void main(String[] args) {
        Random r=new Random();
        List<Hero> heroes=new ArrayList<>();

        for (int i=0;i<10;i++){
            heroes.add(new Hero("hero"+i,r.nextInt(1000),r.nextInt(100)));
        }

        System.out.println("初始化完成");
        System.out.println(heroes);

        System.out.println("使用传统方式打印");
        Collections.sort(heroes,Hero::compareHero);
        System.out.println(heroes.get(2).name);


        System.out.println("使用聚合操作打印");
        Hero thirdHero=heroes
                .stream()
                .sorted(Hero::compareHero)
                .skip(2)
                .findFirst()
                .get();
        System.out.println(thirdHero.name);
    }
}

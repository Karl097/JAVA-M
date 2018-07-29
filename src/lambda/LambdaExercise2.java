package lambda;

import set.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//把比较器-Comparator 章节中的代码，使用 引用容器中的对象的方法 的方式来实现
public class LambdaExercise2 {
    public static void main(String[] args) {
        Random r=new Random();
        List<Hero> heroes=new ArrayList<>();

        //随机实例化
        for(int i=0;i<10;i++){
            heroes.add(new Hero("hero"+i,r.nextInt(100),r.nextInt(100)));
        }
        System.out.println("排序前的heroes");
        System.out.println(heroes);
        //按照血量排序
        //使用引用容器中的对象的方法
        Collections.sort(heroes,Hero::compareHero);

        System.out.println("排序后的heroes");
        System.out.println(heroes);

    }
}

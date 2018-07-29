package lambda;

import set.Hero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

//把比较器-Comparator 章节中的代码，使用引用静态方法的方式来实现
public class LambdaExercise1 {
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
        //静态方法实现
        Collections.sort(heroes,LambdaExercise1::compare);
        System.out.println("排序后的heroes");
        System.out.println(heroes);

    }

    public static int compare(Hero h1,Hero h2){
        return h1.hp>=h2.hp?1:-1;
    }
}

package lambda;
import set.Hero;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;
//首先为TestLambda添加一个静态方法：import java.util.ArrayList;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//public static boolean testHero(Hero h) {
//        return h.hp>100 && h.damage<50;
//        }
//        Lambda表达式：
//        filter(heros, h->h.hp>100 && h.damage<50);
//        在Lambda表达式中调用这个静态方法：
//        filter(heros, h -> TestLambda.testHero(h) );
//        调用静态方法还可以改写为：
//        filter(heros, TestLambda::testHero);
//        这种方式就叫做引用静态方法


//与引用静态方法很类似，只是传递方法的时候，需要一个对象的存在
//        TestLambda testLambda = new TestLambda();
//        filter(heros, testLambda::testHero);
//        这种方式叫做引用对象方法
public class Lambda4 {
    public static void main(String[] args) {
        Random r = new Random();
        List<Hero> heroes = new ArrayList<Hero>();
        for (int i = 0; i < 5; i++) {
            heroes.add(new Hero("hero " + i, r.nextInt(1000), r.nextInt(100)));
        }
        System.out.println("初始化后的集合：");
        System.out.println(heroes);

        HeroChecker c = new HeroChecker() {
            public boolean test(Hero h) {
                return h.hp>100 && h.damage<50;
            }
        };

        System.out.println("使用匿名类过滤");
        filter(heroes, c);
        System.out.println("直接使用Lambda表达式过滤");
        filter(heroes,h->h.hp>100&&h.damage<50);
        System.out.println("在Lambda表达式中使用静态方法");
        filter(heroes,h->Lambda4.TestHero(h));
        System.out.println("直接引用静态方法");
        filter(heroes, Lambda4::TestHero);
        System.out.println("引用对象方法");
        Lambda4 lambda4=new Lambda4();
        filter(heroes,lambda4::testHero);

}
    public boolean testHero(Hero h){
        return h.hp>100&&h.damage<50;
    }


    public static boolean TestHero(Hero h){
        return h.hp>100&&h.damage<50;
}

    public static void filter(List<Hero> heroes,HeroChecker c){
        for (Hero h:heroes){
            if (c.test(h))
                System.out.println(h);
        }
}

}

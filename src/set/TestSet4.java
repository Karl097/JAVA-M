package set;

import java.util.ArrayList;

//remove用于把对象从ArrayList中删除
//        remove可以根据下标删除ArrayList的元素
//        heros.remove(2);
//        也可以根据对象删除
//        heros.remove(specialHero);

//set用于替换指定位置的元素

//size 用于获取ArrayList的大小
public class TestSet4 {
    public static void main(String[] args) {
        ArrayList heroes=new ArrayList();

        for (int i=0;i<5;i++){
            heroes.add(new Hero("hero"+i));
        }
        Hero specialhero=new Hero("specialhero");
        heroes.add(specialhero);
        System.out.println(heroes);

        heroes.remove(3);
        System.out.println(heroes);

        heroes.remove(specialhero);
        System.out.println(heroes);


        System.out.println("下标为1的对象替换为newhero");
        heroes.set(1,new Hero("newhero"));
        System.out.println(heroes);

        System.out.println("size()可以获取大小");
        System.out.println(heroes.size());
    }
}

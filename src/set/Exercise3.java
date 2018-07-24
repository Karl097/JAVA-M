package set;

import java.util.ArrayList;
import java.util.List;

//首先初始化一个Hero集合，里面放100个Hero对象，名称分别是从
//        hero 0
//        hero 1
//        hero 2
//        ...
//        hero 99.
//        通过遍历的手段，删除掉名字编号是8的倍数的对象
public class Exercise3 {
    public static void main(String[] args) {
        //初始化
        List<Hero> heroes=new ArrayList<>();
        for (int i=0;i<100;i++){
            heroes.add(new Hero("hero name:"+i));
            System.out.print(heroes.get(i)+"  ");
        }
        System.out.println();

        //删除
        int cnt=0;
        for (int i=0;i<heroes.size();i++){
            if ((i+cnt)%8==0&&i!=0){
                heroes.remove(i);
                cnt++;
            }
            System.out.print(heroes.get(i)+"  ");
        }
        System.out.println();




        //准备一个容器，专门用来装要删除的对象
        List<Hero> deletingHeros = new ArrayList<>();

        for (Hero h : heroes) {
            int id = Integer.parseInt(h.name.substring(10));
            if (0 == id % 8&&id!=0)
                deletingHeros.add(h);
        }
        for (Hero h : deletingHeros) {
            heroes.remove(h);
        }
//      heroes.removeAll(deletingHeroes); //直接通过removeAll删除多个Hero对象
        for (Hero h:heroes){
            System.out.print(h+"  ");
        }
    }
}

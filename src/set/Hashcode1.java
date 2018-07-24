package set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hashcode1 {
    public static void main(String[] args) {
        List<Hero> heroes=new ArrayList<>();

        for (int i=0;i<1000*2000;i++){
            heroes.add(new Hero("hero"+i));
        }

        for (int i=0;i<10;i++){
            Collections.shuffle(heroes);

            String target="hero1000000";

            long start=System.currentTimeMillis();
            for (Hero h:heroes){
                if (h.name.equals(target)){
                    System.out.println("找到了hero!");
                    break;
                }
            }
            long end=System.currentTimeMillis();
            System.out.printf("本次查找总共耗时：%d毫秒\n",end-start);
        }
    }
}

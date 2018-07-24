package set;

import java.util.HashMap;

public class Hashcode2 {
    public static void main(String[] args) {
        HashMap<String,Hero> heromap=new HashMap<>();

        for (int i=0;i<1000*2000;i++){
            Hero h=new Hero("hero"+i);
            heromap.put(h.name,h);
        }

        for (int i=0;i<10;i++){
            long start=System.currentTimeMillis();
            Hero target=heromap.get("hero1000000");
            System.out.println("找到了hero!"+target.name);
            long end=System.currentTimeMillis();
            System.out.printf("本次查找总共耗时：%d毫秒\n",end-start);
        }
    }
}

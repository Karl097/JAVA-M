package set;

import java.util.ArrayList;

//如果就是要判断集合里是否存在一个 name等于 "hero 1"的对象，应该怎么做？
public class Exercise1 {
    public static void main(String[] args) {
        ArrayList heroes=new ArrayList();

        for (int i=0;i<5;i++){
            heroes.add(new Hero("hero"+i));
        }
        System.out.println(heroes);

        String name="hero1";
        for (int i=0;i<heroes.size();i++){
            Hero h=(Hero)heroes.get(i);
            if (name.equals(h.name)){
                System.out.println("找到name是hero1的对象");
                break;
            }
        }
    }
}

package set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//遍历ArrayList的三种方法
public class TestSet7 {
    public static void main(String[] args) {
        List<Hero> heroes=new ArrayList<>();
        //放入元素
        for (int i=0;i<5;i++){
            heroes.add(new Hero("hero name:"+i));
        }
//        通过前面的学习，知道了可以用size()和get()分别得到大小，和获取指定位置的元素，结合for循环就可以遍历出ArrayList的内容
        System.out.println("第一种使用for循环:");
        for (int i=0;i<heroes.size();i++){
            Hero h=heroes.get(i);
            System.out.println(h);
        }
//使用迭代器Iterator遍历集合中的元素
        System.out.println("第二种使用迭代器的while写法：");
        Iterator<Hero> i=heroes.iterator();
        while (i.hasNext()){
            Hero h=i.next();
            System.out.println(h);
        }

        System.out.println("第二种使用迭代器的for写法");
        for (Iterator<Hero> it=heroes.iterator();it.hasNext();){
            Hero h=it.next();
            System.out.println(h);
        }

//        使用增强型for循环可以非常方便的遍历ArrayList中的元素，这是很多开发人员的首选。
//        不过增强型for循环也有不足：
//        无法用来进行ArrayList的初始化
//        无法得知当前是第几个元素了，当需要只打印单数元素的时候，就做不到了。 必须再自定下标变量。

        System.out.println("第三种使用增强型for循环");
        for (Hero h:heroes){
            System.out.println(h);
        }
    }
}

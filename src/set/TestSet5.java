package set;

import java.util.ArrayList;

//toArray可以把一个ArrayList对象转换为数组。
//        需要注意的是，如果要转换为一个Hero数组，那么需要传递一个Hero数组类型的对象给toArray()，这样toArray方法才知道，你希望转换为哪种类型的数组，否则只能转换为Object数组
public class TestSet5 {
    public static void main(String[] args) {
        ArrayList heroes=new ArrayList();

        for (int i=0;i<5;i++){
            heroes.add(new Hero("hero"+i));
        }
        Hero specialhero=new Hero("specialhero");
        heroes.add(specialhero);
        System.out.println(heroes);

        Hero hs[]=(Hero [])heroes.toArray(new Hero[]{});
        System.out.println("数组："+hs);


//        addAll 把另一个容器所有对象都加进来

        ArrayList anotherHeros = new ArrayList();
        anotherHeros.add(new Hero("hero a"));
        anotherHeros.add(new Hero("hero b"));
        anotherHeros.add(new Hero("hero c"));
        System.out.println();
        System.out.println("anotherHeros heros:\t" + anotherHeros);
        heroes.addAll(anotherHeros);
        System.out.println("把另一个ArrayList的元素都加入到当前ArrayList:");
        System.out.println("ArrayList heros:\t" + heroes);


//        clear 清空一个ArrayList
        System.out.println();
        heroes.clear();
        System.out.println("清空以后："+heroes);

    }
}

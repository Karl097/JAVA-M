package set;

import java.util.LinkedList;

//除了实现了List接口外，LinkedList还实现了双向链表结构Deque，可以很方便的在头尾插入删除数据
public class TestSet8 {
    public static void main(String[] args) {
        //LinkedList是一个双向链表结构的list
        LinkedList<Hero> ll=new LinkedList<>();

        //在前面插入新的英雄
        ll.addFirst(new Hero("hero1"));
        ll.addFirst(new Hero("hero2"));
        ll.addFirst(new Hero("hero3"));
        System.out.println(ll);

        //在最后插入新的英雄
        ll.addLast(new Hero("hero4"));
        System.out.println(ll);

        //查看最前面的英雄
        System.out.println(ll.getFirst());

        //查看最后面的英雄
        System.out.println(ll.getLast());

        //查看不会导致英雄删除
        System.out.println(ll);

        //删除最前面的英雄
        System.out.println(ll.removeFirst());

        //删除最后面的英雄
        System.out.println(ll.removeLast());


        System.out.println(ll);


    }
}

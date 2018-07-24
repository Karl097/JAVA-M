package set;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//LinkedList 除了实现了List和Deque外，还实现了Queue接口(队列)。
//        Queue是先进先出队列 FIFO，常用方法：
//        offer 在最后添加元素
//        poll 取出第一个元素
//        peek 查看第一个元素
public class TestSet9 {
    public static void main(String[] args) {
        List ll=new LinkedList<Hero>();

        //Queue代表先进先出的队列 FIFO
        Queue<Hero> q=new LinkedList<>();

        //加载队列的最后面
        q.offer(new Hero("hero1"));
        q.offer(new Hero("hero2"));
        q.offer(new Hero("hero3"));
        q.offer(new Hero("hero4"));

        System.out.println(q);

        //取出第一个元素
        Hero h=q.poll();
        System.out.println(h);
        System.out.println("取出第一个元素后的队列");
        System.out.println(q);

        //查看第一个元素
        h=q.peek();
        System.out.println(h);
        System.out.println("查看不会导致元素删除");
        System.out.println(q);
    }
}

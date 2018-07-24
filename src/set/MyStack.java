package set;

import java.util.LinkedList;

public class MyStack implements Stack {

    LinkedList<Hero> ll=new LinkedList<>();

    public void push(Hero h){
        ll.addLast(h);
    }

    public Hero pull(){
        return ll.removeLast();
    }

    public Hero  peek(){
        return ll.getLast();
    }
    public static void main(String[] args) {

        MyStack heroStack=new MyStack();
        System.out.println("压入英雄");
        for (int i=0;i<5;i++){
            Hero h=new Hero("hero"+i);
            heroStack.push(h);
            System.out.println(h);
        }

        System.out.println("推出英雄");
        for (int i=0;i<5;i++){
            Hero h=heroStack.pull();
            System.out.println(h);
        }

    }
}

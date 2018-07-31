package thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyStack<T> {
    LinkedList<T> values=new LinkedList<T>();
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();

    public synchronized void push(T t){
        try{
        lock.lock();
        while (values.size()>=200){
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        condition.signalAll();
        values.addLast(t);
    }finally {
            lock.unlock();
        }
        }
    public synchronized T pull() {
        T t=null;
        try{
            lock.lock();
        while(values.isEmpty()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        condition.signalAll();
        t= values.removeLast();
    }finally {
            lock.unlock();
        }
        return t;
    }

    public T peek() {
        return values.getLast();
    }
}

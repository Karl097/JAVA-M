package thread;

public class ThreadExercise6 {
    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();
        new Producer(stack, "Producer1").start();
        new Producer(stack, "Producer2").start();
        new Consumer(stack, "Consumer1").start();
        new Consumer(stack, "Consumer2").start();
        new Consumer(stack, "Consumer3").start();
    }
}

package thread;

public class Producer extends Thread{
    private MyStack<Character> stack;

    public Producer(MyStack<Character> stack,String name){
        super(name);
        this.stack =stack;
    }
    public void run(){
        while (true){
        String pool="";
        for (char c='A';c<='Z';c++){
            pool+=c;
        }
        char c=pool.charAt((int)(Math.random()*pool.length()));

        System.out.println(this.getName()+" 压入: " + c);
        stack.push(c);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    }

}

package thread;
//在 练习-同步查找文件内容 ，如果文件特别多，就会创建很多的线程。 改写这个练习，使用线程池的方式来完成。
//
//        初始化一个大小是10的线程池
//
//        遍历所有文件，当遍历到文件是.java的时候，创建一个查找文件的任务，把这个任务扔进线程池去执行，继续遍历下一个文件
import java.io.File;

public class ThreadExercise7 {
    public static void main(String[] args) {
        File folder=new File("d:/JAVA/JAVA-M/src");
        search(folder,"Thread");
    }
    static ThreadPool pool= new ThreadPool();
    public static void search(File file ,String search){
        if (file.isFile()) {
            if(file.getName().toLowerCase().endsWith(".java")){
                SearchFile task = new SearchFile(file, search);
                pool.add(task);
            }
        }
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(f, search);
            }
        }
    }

    }


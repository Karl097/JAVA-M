package networkprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//首先获取 获取本机IP地址，比如说是192.168.2.100。 那么本网段的ip地址就是从 192.168.2.1 到 192.168.2.255
//        再通过使用java 执行ping命令 判断这些ip地址能否使用，把能够使用的ip打印出来
public class GetAvailablePing {
    public static void main(String[] args) throws InterruptedException{
        String address="ping 192.168.4.";

        //储存可用的ip
        List<String> ips=Collections.synchronizedList(new ArrayList<>());
        //使用java自带线程池，最大15个线程
        ThreadPoolExecutor threadpool=new ThreadPoolExecutor(10,15,60,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
        AtomicInteger number=new AtomicInteger();
        for (int i=1;i<=255;i++){
            String ip=address+i;
            threadpool.execute(new Runnable() {
                @Override
                public void run() {
                    if (isReachable(ip))
                        ips.add(ip);

                    //为了打印出来的数据按照先后顺序来，不然 即便是取数据那一下是线程安全的，打印语句不是线程安全的
                    synchronized (number){
                        System.out.println("已经完成"+number.incrementAndGet()+"个ip测试");
                    }
                }
            });
        }
        //线程结束，关闭线程池
        threadpool.shutdown();

        //等待线程池关闭，最多等一个小时
        if (threadpool.awaitTermination(1,TimeUnit.HOURS)) {
            System.out.println("有如下ip可以使用");
            for (String s : ips) {
                System.out.println(s);
            }
            System.out.printf("总共有%d个ip可用", ips.size());
        }
    }

    //判断是否可用
    private static boolean isReachable(String ip){
        try {
            boolean reachable=false;

            Process p=Runtime.getRuntime().exec(ip);
            BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream(),("GBK")));
            String line=null;
            StringBuilder sb=new StringBuilder();
            while ((line=br.readLine())!=null){
                if (line.length()!=0)
                    sb.append(line+"\t\n");
            }
            if (sb.toString().contains("TTL"))//表示可用
                reachable=true;
                br.close();
                return reachable;
        }catch (IOException e){
            e.printStackTrace();
            return false;
        }
    }
}

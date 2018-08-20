package networkprogramming;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class GetIPDemo {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机ip
        InetAddress host=InetAddress.getLocalHost();
        String ip=host.getHostAddress();
        System.out.println("本机ip是："+ip);
    }
}

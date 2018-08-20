package networkprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//使用java执行ping命令
public class PingDemo {
    public static void main(String[] args) throws IOException {
        Process p=Runtime.getRuntime().exec("ping 192.168.168.168");
        BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream(),("GBK")));
        String line=null;
        StringBuilder sb=new StringBuilder();
        while ((line=br.readLine())!=null){
            if (line.length()!=0)
                sb.append(line+"\t\n");
        }
        System.out.println(sb.toString());
    }
}

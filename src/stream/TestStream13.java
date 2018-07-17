package stream;

import java.io.UnsupportedEncodingException;

//找出 E5 B1 8C 这3个十六进制对应UTF-8编码的汉字
public class TestStream13 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte data[]={(byte)0xE5,(byte)0xB1,(byte)0x8C};

        String str=new String(data,"UTF-8");
        System.out.println("E5 B1 8C对应UTF-8编码的汉字是："+str);
    }
}

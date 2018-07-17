package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//为了能够正确的读取中文内容
//        1. 必须了解文本是以哪种编码方式保存字符的
//        2. 使用字节流读取了文本后，再使用对应的编码方式去识别这些数字，得到正确的字符
//        如本例，一个文件中的内容是字符中，编码方式是GBK，那么读出来的数据一定是D6D0。
//        再使用GBK编码方式识别D6D0，就能正确的得到字符中
//
//        注： 在GBK的棋盘上找到的中字后，JVM会自动找到中在UNICODE这个棋盘上对应的数字，并且以UNICODE上的数字保存在内存中。
public class TestStream11 {
    public static void main(String[] args) {
        File f=new File("e:/Test/Test2.txt");
        try (FileInputStream fis=new FileInputStream(f)){
            byte all[]=new byte[(int)f.length()];
            fis.read(all);

            System.out.println("文件中读出来的数据是：");
            for (byte b:all){
                int i=b&0x000000ff;
                System.out.println(Integer.toHexString(i));
            }
            System.out.println("把这个数字放到UTF-8棋盘上去：");
            String str=new String(all,"UTF-8");
            System.out.println(str);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package stream;

import javax.sound.sampled.DataLine;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

//如果用记事本根据UTF-8编码保存汉字就会在最前面生成一段标示符，这个标示符用于表示该文件是使用UTF-8编码的。
//        找出这段标示符对应的十六进制，并且开发一个方法，自动去除这段标示符
public class TestStream14 {
    public static void main(String[] args) {
        File f=new File("e:/Test/Test2.txt");

        try (FileInputStream fis=new FileInputStream(f)){
            byte data[]=new byte[(int) f.length()];
            fis.read(data);
            String str=new String(data,"UTF-8");
            System.out.println("去除标识符前："+str);
            for (byte b:data){
                int i=b&0x000000ff;
                System.out.println(Integer.toHexString(i));
            }
            byte newdata[];
            newdata=Arrays.copyOfRange(data,data.length/2,data.length);


            String str2=new String(newdata,"UTF-8");
            System.out.println("去除标识符后："+str2);
            for (byte b2:newdata){
                int i=0x000000ff;
                System.out.println(Integer.toHexString(i));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}


//package stream;
//
//        import java.io.File;
//        import java.io.FileInputStream;
//        import java.io.IOException;
//        import java.util.Arrays;
//
//public class TestStream {
//
//    public static void main(String[] args) {
//        File f = new File("E:\\project\\j2se\\src\\test.txt");
//        try (FileInputStream fis = new FileInputStream(f);) {
//            byte[] all = new byte[(int) f.length()];
//            fis.read(all);
//            System.out.println("首先确认按照UTF-8识别出来有？");
//            String str = new String(all,"UTF-8");
//            System.out.println(str);
//            System.out.println("根据前面的所学，知道'中'字对应的UTF-8编码是：e4 b8 ad");
//            System.out.println("打印出文件里所有的数据的16进制是：");
//            for (byte b : all) {
//                int i = b&0xff;
//                System.out.print(Integer.toHexString(i)+ " ");
//            }
//            System.out.println();
//            System.out.println("通过观察法得出 UTF-8的 BOM 是 ef bb bf");
//            byte[] bom = new byte[3];
//            bom[0] = (byte) 0xef;
//            bom[1] = (byte) 0xbb;
//            bom[2] = (byte) 0xbf;
//            byte[] fileContentWithoutBOM= removeBom(all,bom);
//            System.out.println("去掉了BOM之后的数据的16进制是：");
//            for (byte b : fileContentWithoutBOM) {
//                int i = b&0xff;
//                System.out.print(Integer.toHexString(i)+ " ");
//            }
//            System.out.println();
//            System.out.println("对应的字符串就没有问号了：");
//            String strWithoutBOM=new String(fileContentWithoutBOM,"UTF-8");
//            System.out.println(strWithoutBOM);
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//
//    private static byte[] removeBom(byte[] all, byte[] bom) {
//        return Arrays.copyOfRange(all, bom.length, all.length);
//    }
//}
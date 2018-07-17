package stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//解密在文件加密中生成的文件。
//        设计一个方法
//
//public static void decodeFile(File decodingFile, File decodedFile);
//
//
//        在这个方法中把decodingFile的内容进行解密，然后保存到decodedFile文件中。
//        解密算法：
//        数字：
//        如果不是0的数字，在原来的基础上减1，比如6变成5, 4变成3
//        如果是0的数字，变成9
//        字母字符：
//        如果是非a字符，向左移动一个，比如e变成d, H变成G
//        如果是a，a->z, A-Z。
//        字符需要保留大小写
//        非字母字符：
//        比如',&^ 保留不变，中文也保留不变
public class TestStream9 {
    public static void decodeFile(File decodingFile, File decodedFile){
        //第一步：读取文件内容
        char fileContent[]=new char[(int)decodingFile.length()];
        try(FileReader fr=new FileReader(decodingFile)){
            fr.read(fileContent);
            System.out.println("解密前的内容："+new String(fileContent));
        }catch (IOException e){
            e.printStackTrace();
        }
        //第二步：解密
        for (int i=0;i<fileContent.length;i++){
            if ((fileContent[i]>48&&fileContent[i]<=57)||(fileContent[i]>65&&fileContent[i]<=90)||(fileContent[i]>97&&fileContent[i]<=122)){
                fileContent[i]--;
            }
            else if (fileContent[i]==48){
                fileContent[i]=(char)57;
            }
            else if (fileContent[i]==65){
                fileContent[i]=(char)90;
            }
            else if (fileContent[i]==97){
                fileContent[i]=(char)122;
            }
        }
        //第三步：写入到解密文件中
        try (FileWriter fw=new FileWriter(decodedFile)){
            fw.write(fileContent);
            fw.flush();
            System.out.println("解密后的内容："+new String(fileContent));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File decodingFile=new File("e:/Test/decodingFile.txt");
        File decodedFile=new File("e:/Test/decodedFile.txt");
        decodeFile(decodingFile,decodedFile);
    }

}
/*
* package stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestStream {
//     *
//     * @param decodingFile
//     *            被解密的文件
//     * @param decodedFile
//     *            解密后保存的位置

public static void decodeFile(File decodingFile, File decodedFile) {

    try (FileReader fr = new FileReader(decodingFile); FileWriter fw = new FileWriter(decodedFile)) {
        // 读取源文件
        char[] fileContent = new char[(int) decodingFile.length()];
        fr.read(fileContent);
        System.out.println("源文件的内容:");
        System.out.println(new String(fileContent));
        // 进行解密
        decode(fileContent);
        System.out.println("解密后的内容:");
        System.out.println(new String(fileContent));
        // 把解密后的内容保存到目标文件
        fw.write(fileContent);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

    private static void decode(char[] fileContent) {
        for (int i = 0; i < fileContent.length; i++) {
            char c = fileContent[i];
            if (isLetterOrDigit(c)) {
                switch (c) {
                    case '0':
                        c = '9';
                        break;
                    case 'a':
                        c = 'z';
                        break;
                    case 'A':
                        c = 'Z';
                        break;
                    default:
                        c--;
                        break;
                }
            }
            fileContent[i] = c;
        }
    }

    public static boolean isLetterOrDigit(char c) {
        // 不使用Character类的isLetterOrDigit方法是因为，中文也会被判断为字母
        String letterOrDigital ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        return -1 == letterOrDigital.indexOf(c) ? false : true;
    }

    public static void main(String[] args) {
        File decodingFile = new File("E:/project/j2se/src/Test2.txt");
        File decodedFile = new File("E:/project/j2se/src/Test1.txt");

        decodeFile(decodingFile, decodedFile);

    }
}*/

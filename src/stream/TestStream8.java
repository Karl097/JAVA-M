package stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//准备一个文本文件(非二进制)，其中包含ASCII码的字符和中文字符。
//        设计一个方法
//
//public static void encodeFile(File encodingFile, File encodedFile);
//
//
//        在这个方法中把encodingFile的内容进行加密，然后保存到encodedFile文件中。
//        加密算法：
//        数字：
//        如果不是9的数字，在原来的基础上加1，比如5变成6, 3变成4
//        如果是9的数字，变成0
//        字母字符：
//        如果是非z字符，向右移动一个，比如d变成e, G变成H
//        如果是z，z->a, Z-A。
//        字符需要保留大小写
//        非字母字符
//        比如',&^ 保留不变，中文也保留不变
public class TestStream8 {
    public static void main(String[] args) {
        File encodingFile=new File("e:/Test/encodingFile.txt");
        File encodedFile=new File("e:/Test/encodedFile.txt");
        encodeFile(encodingFile,encodedFile);
    }
    public static void encodeFile(File encodingFile, File encodedFile){
        //第一步：读取文件内容
        char fileContent[]=new char[(int)encodingFile.length()];
        try(FileReader fr=new FileReader(encodingFile)){
            fr.read(fileContent);
            System.out.println("加密前的内容："+new String(fileContent));
        }catch (IOException e){
            e.printStackTrace();
        }
        //第二步：加密
        for (int i=0;i<fileContent.length;i++){
            if ((fileContent[i]>=48&&fileContent[i]<57)||(fileContent[i]>=65&&fileContent[i]<90)||(fileContent[i]>=97&&fileContent[i]<122)){
                fileContent[i]++;
            }
            else if (fileContent[i]==57){
                fileContent[i]=(char)48;
            }
            else if (fileContent[i]==90){
                fileContent[i]=(char)65;
            }
            else if (fileContent[i]==122){
                fileContent[i]=(char)97;
            }
        }
        //第三步：写入到加密文件中
        try (FileWriter fw=new FileWriter(encodedFile)){
            fw.write(fileContent);
            fw.flush();
            System.out.println("加密后的内容："+new String(fileContent));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
/*
* package stream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestStream {
     *
     * @param encodingFile
     *            被加密的文件
     * @param encodedFile
     *            加密后保存的位置

public static void encodeFile(File encodingFile, File encodedFile) {

    try (FileReader fr = new FileReader(encodingFile); FileWriter fw = new FileWriter(encodedFile)) {
        // 读取源文件
        char[] fileContent = new char[(int) encodingFile.length()];
        fr.read(fileContent);
        System.out.println("加密前的内容：");
        System.out.println(new String(fileContent));

        // 进行加密
        encode(fileContent);
        // 把加密后的内容保存到目标文件
        System.out.println("加密后的内容：");
        System.out.println(new String(fileContent));

        fw.write(fileContent);
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

    private static void encode(char[] fileContent) {
        for (int i = 0; i < fileContent.length; i++) {
            char c = fileContent[i];
            if (isLetterOrDigit(c)) {
                switch (c) {
                    case '9':
                        c = '0';
                        break;
                    case 'z':
                        c = 'a';
                        break;
                    case 'Z':
                        c = 'A';
                        break;
                    default:
                        c++;
                        break;
                }
            }
            fileContent[i] = c;
        }
    }

    public static boolean isLetterOrDigit(char c) {
        // 不使用Character类的isLetterOrDigit方法是因为，中文也会被判断为字母
        String letterOrDigital = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        return -1 == letterOrDigital.indexOf(c) ? false : true;
    }

    public static void main(String[] args) {
        File encodingFile = new File("E:/project/j2se/src/Test1.txt");
        File encodedFile = new File("E:/project/j2se/src/Test2.txt");
        encodeFile(encodingFile, encodedFile);
    }
}
*/

import com.sun.javafx.tools.packager.PackagerException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        File f = new File("d:/IDEA.txt");
        try {
            System.out.println("试图打打开d:/IDEA.txt");
            new FileInputStream(f);
            System.out.println("成功打开");

            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date d=sdf.parse("2018-07-15");
        }catch(FileNotFoundException e) {
            System.out.println("文件不存在");
            e.printStackTrace();
        }catch (ParseException e){
            System.out.println("日期格式解析错误");
            e.printStackTrace();
        }finally {
            System.out.println("无论是否异常，都会被执行");
        }

    }
}

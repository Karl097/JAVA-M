package stream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/*以字节流的形式向文件写入数据 中的例子，当lol2.txt不存在的时候，是会自动创建lol2.txt文件的。
        但是，如果是写入数据到d:/xyz/lol2.txt，而目录xyz又不存在的话，就会抛出异常。
        那么怎么自动创建xyz目录？
        如果是多层目录 d:/xyz/abc/def/lol2.txt 呢？*/
public class TestStream2 {
    public static void main(String[] args) {
        try {
            File f = new File("e:/Test/nexit/haha/ix.txt");

            File dir=f.getParentFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(f);

            byte data[]={45,55,16,48,45,123,111,56,89};
            fos.write(data);
            fos.close();
        }catch (IOException  e){
            e.printStackTrace();
        }
    }
}

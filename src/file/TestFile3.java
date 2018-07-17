package file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TestFile3 {
    public static void main(String[] args) throws IOException {
        File f=new File("e:/Test");

        System.out.println(f.exists());
        //以字符串数组的形式返回当前文件夹下的所有文件（不包括子文件及子文件夹）
        String fst[]=f.list();
        System.out.println(Arrays.toString(fst));

        //以文件数组的形式返回当前文件夹下的所有文件（不包括子文件及子文件夹）
        File fs[]=f.listFiles();
        System.out.println(Arrays.toString(fs));

        //以字符串形式返回获取所在文件夹
        f.getParent();
        System.out.println(f.getParent());
        //以文件形式返回获取所在文件夹
        f.getParentFile();

        // 创建文件夹，如果父文件夹skin不存在，创建就无效
        f.mkdir();

        // 创建文件夹，如果父文件夹skin不存在，就会创建父文件夹
        f.mkdirs();

        // 创建一个空文件,如果父文件夹skin不存在，就会抛出异常
        f.createNewFile();

        // 所以创建一个空文件之前，通常都会创建父目录
        f.getParentFile().mkdirs();

        // 列出所有的盘符c: d: e: 等等
        f.listRoots();

        //删除文件
        f.delete();

        // JVM结束的时候，刪除文件，常用于临时文件的删除
        f.deleteOnExit();

    }
}

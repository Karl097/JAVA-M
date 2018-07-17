package stream;

import java.io.*;
import java.util.Arrays;

/*把TestStream3拆分出来的文件，合并成一个原文件。

        是否能正常运行，验证合并是否正确*/
public class TestStream4 {

    public static void main(String[] args) {
        mergeFile("e:/Test","xxx.ppt");
    }
/*    与拆分文件不同(先把所有数据读取到内存中)，合并文件采用另一种思路。

    这种思路，不需要把所有的子文件都先读取到内存中，而是一边读取子文件的内容，一边写出到目标文件

    即从eclipse.exe-0开始，读取到一个文件，就开始写出到 eclipse.exe中，然后处理eclipse.exe-1eclipse.exe-2 eclipse.exe-3 ... 直到没有文件可以读*/
    public static void mergeFile(String folder, String fileName) {
        File merFile = new File(folder, fileName);
        try (FileOutputStream fos = new FileOutputStream(merFile)){
            int index = 0;
            while (true) {
                File eachFile = new File(folder, fileName + "-" + index++);

                if (!eachFile.exists())
                    break;

                //读取子文件内容
                try(FileInputStream fis = new FileInputStream(eachFile)) {
                    byte eachContent[] = new byte[(int) eachFile.length()];
                    fis.read(eachContent);

                    //写出子文件内容
                    fos.write(eachContent);
                    fos.flush();
                }
                System.out.printf("把子文件 %s写出到目标文件中%n", eachFile);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("最后目标文件的大小：%,d字节", merFile.length());
    }
}



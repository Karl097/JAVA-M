package stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*找到一个大于100k的文件，按照100k为单位，拆分成多个子文件，并且以编号作为文件名结束。
        比如文件 eclipse.exe，大小是309k。
        拆分之后，成为
        eclipse.exe-0
        eclipse.exe-1
        eclipse.exe-2
        eclipse.exe-3*/
public class TestStream3 {
    public static void main(String[] args) {

        File srcFile=new File("e:/Test/xxx.ppt");
        int eachSize=100*1024;//100k
        splitFile(srcFile,eachSize);
    }
    /**
     * 拆分的思路，先把源文件的所有内容读取到内存中，然后从内存中挨个分到子文件里
     * @param srcFile 要拆分的源文件
     * @param eachSize 按照这个大小，拆分
     */
    public static void splitFile(File srcFile,int eachSize){
        if (srcFile.length()==0)
            throw new RuntimeException("文件长度为0，不可拆分");

        //先把文件读取到数组中
        byte fileContent[]=new byte[(int)srcFile.length()];

        FileInputStream fis=null;
        try {
            fis=new FileInputStream(srcFile);
            fis.read(fileContent);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fis!=null)
                try {
                    fis.close();
                }catch (IOException e){
                e.printStackTrace();
                }
        }

        //计算需要分成多少个子文件
        int fileNumber;

        if (srcFile.length()%eachSize==0)
            fileNumber=(int)(srcFile.length()/eachSize);
        else
            fileNumber=(int)(srcFile.length()/eachSize)+1;

        for (int i=0;i<fileNumber;i++){
            String eachFileName=srcFile.getName()+"-"+i;
            File eachFile=new File(srcFile.getParent(),eachFileName);
            byte eachContent [];

            // 从源文件的内容里，复制部分数据到子文件
            // 除开最后一个文件，其他文件大小都是100k
            // 最后一个文件的大小是剩余的

            if (i!=fileNumber-1)
                eachContent= Arrays.copyOfRange(fileContent,eachSize*i,eachSize*(i+1));
            else
                eachContent=Arrays.copyOfRange(fileContent,eachSize*(fileNumber-1),fileContent.length);

            //写
            FileOutputStream fos=null;
            try {
                fos=new FileOutputStream(eachFile);
                fos.write(eachContent);

                System.out.printf("输出子文件：%s,文件大小是：%d字节%n",eachFile.getAbsolutePath(),eachFile.length());
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                if (fos!=null)
                    try {
                    fos.close();
                    }catch (IOException e){
                    e.printStackTrace();
                    }
            }
        }
    }
}

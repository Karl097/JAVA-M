package set;

import java.util.Arrays;

//创建4万个随机数，然后用分别用冒泡法，选择法，二叉树3种排序算法进行排序，比较哪种更快
public class Comparison {
    //冒泡排序
    public static void bubble(int numbers[]){
        for (int i=0;i<numbers.length;i++){
            for (int j=0;j<numbers.length-i-1;j++){
                if (numbers[j]>numbers[j+1]){
                    int temp=numbers[j];
                    numbers[j]=numbers[j+1];
                    numbers[j+1]=temp;
                }
            }
        }
    }

    //选择排序
    public static void select(int numbers[]){
        for (int i=0;i<numbers.length-1;i++){
            for (int j=i+1;j<numbers.length;j++){
                if (numbers[i]>numbers[j]){
                    int temp=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=temp;
                }
            }
        }
    }

    //二叉树排序
//调用Node

    public static void main(String[] args) {
        Node number=new Node();
        int numbers[]=new int[40000];
        for (int i=0;i<numbers.length;i++){
            numbers[i]=(int)(Math.random()*40000);
            number.add(numbers[i]);
        }
        int copyarray1[]=Arrays.copyOf(numbers,numbers.length);
        int copyarray2[]=Arrays.copyOf(numbers,numbers.length);

        System.out.println("第一种使用冒泡排序：");
        long start=System.currentTimeMillis();
        bubble(copyarray1);
        long end=System.currentTimeMillis();
        System.out.printf("使用冒跑排序耗时:%d毫秒",end-start);
        System.out.println();

        System.out.println("第二种使用选择排序：");
        start=System.currentTimeMillis();
        select(copyarray2);
        end=System.currentTimeMillis();
        System.out.printf("使用选择排序耗时：%d毫秒",end-start);
        System.out.println();


        System.out.println("第三种使用二叉树排序：");
        start=System.currentTimeMillis();
        number.values();
        end=System.currentTimeMillis();
        System.out.printf("使用二叉树排序耗时：%d毫秒",end-start);
    }
}
/*参考答案
* import java.util.Arrays;
import java.util.List;

public class SortCompare {

    public static void main(String[] args) {
        //初始化随机数
        int total = 40000;
        System.out.println("初始化一个长度是"+total+"的随机数字的数组");
        int[] originalNumbers = new int[total];
        for (int i = 0; i < originalNumbers.length; i++) {
            originalNumbers[i] = (int)(Math.random()*total);
        }
        System.out.println("初始化完毕");
        System.out.println("接下来分别用3种算法进行排序");

        //从初始化了的随机数组复制过来，以保证，每一种排序算法的目标数组，都是一样的
        int[] use4sort;

        use4sort= Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersBySelection= performance(new SelectionSort(use4sort),"选择法");

        use4sort= Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByBubbling=performance(new BubblingSort(use4sort),"冒泡法");

        use4sort= Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByTree=performance(new TreeSort(use4sort),"二叉树");

        System.out.println("查看排序结果，是否是不同的数组对象");
        System.out.println(sortedNumbersBySelection);
        System.out.println(sortedNumbersByBubbling);
        System.out.println(sortedNumbersByTree);

        System.out.println("查看排序结果，内容是否相同");
        System.out.println("比较 选择法 和 冒泡法  排序结果：");
        System.out.println(Arrays.equals(sortedNumbersBySelection, sortedNumbersByBubbling));
        System.out.println("比较 选择法 和 二叉树  排序结果：");
        System.out.println(Arrays.equals(sortedNumbersBySelection, sortedNumbersByTree));

    }

    interface Sort{
        void sort();
        int[] values();
    }

    static class SelectionSort implements Sort{

        int numbers[];
        SelectionSort(int [] numbers){
            this.numbers = numbers;
        }

        @Override
        public void sort() {
            for (int j = 0; j < numbers.length-1; j++) {
                for (int i = j+1; i < numbers.length; i++) {
                    if(numbers[i]<numbers[j]){
                        int temp = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = temp;
                    }
                }
            }
        }

        @Override
        public int[] values() {
            // TODO Auto-generated method stub
            return numbers;
        }

    }

    static class BubblingSort implements Sort{
        int numbers[];
        BubblingSort(int [] numbers){
            this.numbers = numbers;
        }
        @Override
        public void sort() {
            for (int j = 0; j < numbers.length; j++) {
                for (int i = 0; i < numbers.length-j-1; i++) {
                    if(numbers[i]>numbers[i+1]){
                        int temp = numbers[i];
                        numbers[i] = numbers[i+1];
                        numbers[i+1] = temp;
                    }
                }
            }
        }
        @Override
        public int[] values() {
            // TODO Auto-generated method stub
            return numbers;
        }

    }

    static class TreeSort implements Sort{
        int numbers[];
        Node n;

        TreeSort(int [] numbers){
            n =new Node();
            this.numbers = numbers;
        }
        @Override
        public void sort() {

            for (int i : numbers) {
                n.add(i);
            }
        }
        @Override
        public int[] values() {
            List<Object> list = n.values();
            int sortedNumbers[] = new int[list.size()];
            for (int i = 0; i < sortedNumbers.length; i++) {
                sortedNumbers[i] = Integer.parseInt(list.get(i).toString());
            }
            return sortedNumbers;
        }
    }

    private static int[] performance(Sort algorithm, String type) {
        long start = System.currentTimeMillis();
        algorithm.sort();
        int sortedNumbers[] = algorithm.values();
        long end = System.currentTimeMillis();
        System.out.printf("%s排序，一共耗时 %d 毫秒%n",type,end-start);
        return sortedNumbers;
    }
}
*/

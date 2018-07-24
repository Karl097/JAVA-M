package set;
//如下是Java API提供的String的hashcode生成办法；
//        s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
//        s[0] 表示第一位字符
//        n表示字符串的长度
//        本练习并不是要求去理解这个算法，而是自定义一个简单的hashcode算法，计算任意字符串的hashcode
//        因为String类不能被重写，所以我们通过一个静态方法来返回一个String的hashcode
//public static int hashcode(String)
//        如果字符串长度是0，则返回0。
//        否则： 获取每一位字符，转换成数字后，相加，最后乘以23
//        (s[0]+ s[1] + s[2] + s[3]+ s[n-1])*23.
//        如果值超过了1999，则取2000的余数，保证落在0-1999之间。
//        如果是负数，则取绝对值。
//        随机生成长度是2-10的不等的100个字符串，打印用本hashcode获取的值分别是多少
public class HashcodeExercise1 {
    public static int hashcode(String str){
        if (str==null)
            return 0;
        else{
            char s[]=str.toCharArray();
            int result=0;
            for (char c:s){
                result+=c;
            }
            result=result*23;
           result=result<0?0-result:result;
           result%=2000;

            return result;
        }
    }

    public static String randomString(int length){
        String pool="";
        for (int i='0';i<'9';i++){
            pool+=(char)i;
        }
        for (int i='a';i<'z';i++){
            pool+=(char)i;
        }
        for (int i='A';i<'Z';i++){
            pool+=(char)i;
        }
        char ch[]=new char[length];
        for (int i=0;i<ch.length;i++){
            int index=(int)(Math.random()*pool.length());
            ch[i]=pool.charAt(index);
        }
        String string=new String(ch);
        return string;
    }

    public static void main(String[] args) {
        for (int i=0;i<100;i++) {
            int length=(int)(Math.random()*8+2);
            String str=randomString(length);
            System.out.println(str);
            int result=hashcode(str);
            System.out.printf("该字符串的hashcode值是：%d\n",result);

        }

    }
}

package set;

import java.util.ArrayList;

public class MyStringBuffer implements IStringBuffer {
    ArrayList value;
    public MyStringBuffer(){
        value=new ArrayList();
    }
    public MyStringBuffer(String str){
        this();
        if (null==str)
            return;
        char cs[]=str.toCharArray();
        for (int i=0;i<cs.length;i++){
            value.add(cs[i]);
        }
    }

    public void append(String str){
        insert(value.size(),str);
    }
    public void append(char c){
        value.add(c);
    }
    public void insert(int pos,char b){
        if (pos<0)
            return;
        if (pos>value.size())
            return;

        value.add(pos,b);
    }
    public void insert(int pos,String b){
        if (pos<0)
            return;
        if (pos>value.size())
            return;
        if (b==null)
            return;

        char[] cs = b.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            value.add(pos + i, c);
        }
    }
    public void delete(int start){
        if (start<0)
            return;
        if (start>value.size())
            return;

        for (int i=0;i<value.size()-start;i++){
            value.remove(start);
        }
    }

    public void delete(int start,int end){
        if (start<0)
            return;
        if (start>value.size())
            return;
        if (end<0)
            return;
        if (end>value.size())
            return;
        if (end<start)
            return;

        for (int i=0;i<end-start;i++){
            value.remove(start);
        }
    }

    public void reverse(){
        for (int i = 0; i < value.size() / 2; i++) {
            int length = value.size();
            char temp = (char) value.get(i);

            value.set(i, value.get(length - i - 1));

            value.set(length - i - 1, temp);
        }
    }
    public int length(){
        return value.size();
    }
    public String toString() {
        char[] charValue = new char[value.size()];
        for (int i = 0; i < value.size(); i++) {
            charValue[i] = (char) value.get(i);
        }

        return new String(charValue);

    }

    public static void main(String[] args) {
        MyStringBuffer sb = new MyStringBuffer("there light");
        System.out.println(sb);
        sb.insert(0, "let ");
        System.out.println(sb);

        sb.insert(10, "be ");
        System.out.println(sb);
        sb.insert(0, "God Say:");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.append('?');
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);

        sb.delete(0, 4);
        System.out.println(sb);
        sb.delete(4);
        System.out.println(sb);

    }
}

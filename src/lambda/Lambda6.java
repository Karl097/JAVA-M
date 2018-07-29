package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

//引用构造器
//        有的接口中的方法会返回一个对象，比如java.util.function.Supplier提供
//        了一个get方法，返回一个对象
public class Lambda6 {
    public static void main(String[] args) {
        Supplier<List> s=new Supplier<List>() {
            @Override
            public List get() {
                return new ArrayList();
            }
        };
        //匿名类
        List list1=getList(s);
        //lambda表达式
        List list2=getList(()->new ArrayList());
        //引用构造器
        List list3=getList(ArrayList::new);
    }
    public static List getList(Supplier<List> s){
        return s.get();
    }
}

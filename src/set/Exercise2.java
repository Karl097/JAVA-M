package set;

import java.util.ArrayList;
import java.util.List;

//借助泛型和前面学习的面向对象的知识，设计一个ArrayList，使得这个ArrayList里，又可以放Hero，又可以放Item,但是除了这两种对象，其他的对象都不能放
//首先创建一个接口 LOL，不需要在其中声明任何方法
//        接着让Hero和Item都实现LOL接口
//        最后，声明一个ArrayList的变量lolList,它的泛型是<LOL>
//List<LOL> lolList = new ArrayList<>();
//        这样在lolList中就即放Hero对象，又放Item对象了。
public class Exercise2 {
    public static void main(String[] args) {
        List<LOL> lolList=new ArrayList<>();
        lolList.add(new Hero("garen"));
        lolList.add(new Item("shoes"));

        //lolList.add(new Dragon());
    }

}

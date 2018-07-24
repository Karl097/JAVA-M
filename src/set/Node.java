package set;
//二叉树由各种节点组成
//        二叉树特点：
//        每个节点都可以有左子节点，右子节点
//        每一个节点都有一个值
//        假设通过二叉树对如下10个随机数进行排序
//        67,7,30,73,10,0,78,81,10,74
//        排序的第一个步骤是把数据插入到该二叉树中
//        插入基本逻辑是，小、相同的放左边，大的放右边
//        1. 67 放在根节点
//        2. 7 比 67小，放在67的左节点
//        3. 30 比67 小，找到67的左节点7，30比7大，就放在7的右节点
//        4. 73 比67大， 放在67得右节点
//        5. 10 比 67小，找到67的左节点7，10比7大，找到7的右节点30，10比30小，放在30的左节点。
//        ...
//        ...
//        9. 10比67小，找到67的左节点7，10比7大，找到7的右节点30，10比30小，找到30的左节点10，10和10一样大，放在左边


import java.util.ArrayList;
import java.util.List;

//通过上一个步骤的插入行为，实际上，数据就已经排好序了。 接下来要做的是看，把这些已经排好序的数据，遍历成我们常用的List或者数组的形式
//
//        二叉树的遍历分左序，中序，右序
//        左序即： 中间的数遍历后放在左边
//        中序即： 中间的数遍历后放在中间
//        右序即： 中间的数遍历后放在右边
public class Node {
    //左子节点
    public Node leftNode;
    //右子节点
    public Node rightNode;
    //指
    public Object value;

    public void add(Object v){
        //如果当前节点没有值，就把数据放在当前节点上
        if (value==null)
            value=v;
        //如果当前节点有值，就进行判断
        else{
            if ((Integer)v-(Integer)value<=0){
                if (leftNode==null)
                    leftNode=new Node();
                leftNode.add(v);
            }
            else{
                if (rightNode==null)
                    rightNode=new Node();
                rightNode.add(v);
            }
        }
    }
    public List<Object> values(){
        List<Object> values=new ArrayList<>();
        if (leftNode!=null)
            values.addAll(leftNode.values());

        values.add(value);

        if(rightNode!=null)
            values.addAll(rightNode.values());
        return values;
    }

    public static void main(String[] args) {
        int numbers[]=new int[]{67, 7, 30, 73, 10, 0, 78, 81, 10, 74};
        Node roots=new Node();
        for (int number:numbers){
            roots.add(number);
        }
        System.out.println(roots.values());
    }
}

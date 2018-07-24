package set;
//根据上面的学习和理解，设计一个Hero二叉树，HeroNode.
//        可以向这个英雄二叉树插入不同的Hero对象，并且按照Hero的血量倒排序。
//        随机生成10个Hero对象，每个Hero对象都有不同的血量值，插入这个HeroNode后，把排序结果打印出来。
import java.util.ArrayList;
import java.util.List;

public class HeroNode {
    public HeroNode leftNode;
    public HeroNode rightNode;
    public Hero hero;

    public void add(Hero h){
        if (hero ==null)
            hero =h;
            //如果当前节点有值，就进行判断
        else{
            if (h.hp- hero.hp<=0){
                if (leftNode==null)
                    leftNode=new HeroNode();
                leftNode.add(h);
            }
            else{
                if (rightNode==null)
                    rightNode=new HeroNode();
                rightNode.add(h);
            }
        }
    }
    public List<Hero> values(){
        List<Hero> heroes =new ArrayList<>();
        if(rightNode!=null)
            heroes.addAll(rightNode.values());

        heroes.add(hero);

        if (leftNode!=null)
            heroes.addAll(leftNode.values());

        return heroes;
    }

    public static void main(String[] args) {
        HeroNode roots=new HeroNode();
        System.out.println("初始化10个Hero:");
        List<Hero> hs=new ArrayList<>();
        for (int i=0;i<10;i++){
            Hero h=new Hero();
            h.name="hero"+i;
            h.hp=(int)(Math.random()*1000);
            hs.add(h);
        }
        System.out.println(hs);

        for (Hero h:hs){
            roots.add(h);
        }

        System.out.println("根据血量倒排序后的Hero:");
        List<Hero> herotree=roots.values();
        System.out.println(herotree);
    }
    }


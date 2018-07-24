package set;

public class Hero implements LOL{
    public String name;
    public float hp;
    protected int damage;

    public Hero(){
    }
    public Hero(String name){
        this.name=name;
    }
    public String toString(){
        return String.format("[name:%s hp:%.0f]%n", name,hp);
    }
}

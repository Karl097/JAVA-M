package set;

import java.util.HashMap;

public class Hashmap {
    public static void main(String[] args) {
        HashMap<String,Hero> heromap=new HashMap<>();

        heromap.put("garen",new Hero("garen1"));
        System.out.println(heromap);

        heromap.put("garen",new Hero("garen2"));
        System.out.println(heromap);

        heromap.clear();

        Hero h=new Hero("garen");
        heromap.put("hero1",h);
        heromap.put("hero2",h);
        System.out.println(heromap);
    }
}

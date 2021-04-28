import java.util.ArrayList;
import java.util.List;

public class ChampionsLigue {
    private String name;
    private Integer price;

    public ChampionsLigue(String name, Integer price) {
        this.name = name;
        this.price = price;
    }


    @Override
    public String toString() {
        return "ChampionsLigue{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public static List<ChampionsLigue> getChampionsLigue() {
        List<ChampionsLigue> list = new ArrayList<>();
        list.add(new ChampionsLigue("VanPerise", 28000000));
        list.add(new ChampionsLigue("Robben", 27000000));
        list.add(new ChampionsLigue("DaniAlves", 20000000));
        list.add(new ChampionsLigue("StevenG", 30000000));
        return list;
    }
}

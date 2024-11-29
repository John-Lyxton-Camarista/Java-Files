
import java.util.ArrayList;
import java.util.List;

public class GoatManager {

    private final List<Goat> goats;
    private int nextId;

    public GoatManager() {
        goats = new ArrayList<>();
        nextId = 1;
    }

    public void addGoat(String name, int age, String breed) {
        goats.add(new Goat(nextId++, name, age, breed));
    }

    public List<Goat> getGoats() {
        return goats;
    }

    public Goat getGoatById(int id) {
        for (Goat goat : goats) {
            if (goat.getId() == id) {
                return goat;
            }
        }
        return null;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayArea {
    private final String name;
    private final int capacity;
    private final List<Dog> dogs = new ArrayList<>();

    public PlayArea(String name, int capacity) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Play area name must not be empty.");
        }
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive.");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() { return name; }
    public int getCapacity() { return capacity; }

    public List<Dog> getDogs() { return Collections.unmodifiableList(dogs); }

    public boolean isFull() { return dogs.size() >= capacity; }

    public boolean addDog(Dog dog) {
        if (dog == null || isFull() || dogs.contains(dog)) {
            return false;
        }
        dogs.add(dog);
        dog.setCurrentArea(this);   // keep both sides consistent
        return true;
    }

    public boolean removeDog(Dog dog) {
        if (dogs.remove(dog)) {
            dog.setCurrentArea(null);
            return true;
        }
        return false;
    }
}

public abstract class Dog {
    private static int nextId = 1;   // source of globally unique ids

    private final int id;            // final: cannot change after registration
    private String name;
    private int age;
    private PlayArea currentArea;    // 0..1

    protected Dog(String name, int age) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
        this.id = nextId++;
        this.name = name;
        setAge(age);                 // reuse validation
    }

    public int getId() { return id; }           // no setId()
    public String getName() { return name; }
    public int getAge() { return age; }

    public final void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be strictly positive.");
        }
        this.age = age;
    }

    public PlayArea getCurrentArea() { return currentArea; }

    // Package-private: only PlayArea should call this to keep the link consistent.
    void setCurrentArea(PlayArea area) { this.currentArea = area; }

    public void feed() {
        // Implementation here
    }
}

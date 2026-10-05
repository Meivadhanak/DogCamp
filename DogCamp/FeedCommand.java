public class FeedCommand implements CampCommand {
    private final Dog dog;

    public FeedCommand(Dog dog) {
        if (dog == null) {
            throw new IllegalArgumentException("Dog must not be null.");
        }
        this.dog = dog;
    }

    @Override
    public void execute() {
        // Implementation here
    }
}

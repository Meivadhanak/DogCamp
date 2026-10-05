public class TransferCommand implements CampCommand {
    private final Dog dog;
    private final PlayArea target;

    public TransferCommand(Dog dog, PlayArea target) {
        if (dog == null || target == null) {
            throw new IllegalArgumentException("Dog and target area must not be null.");
        }
        this.dog = dog;
        this.target = target;
    }

    @Override
    public void execute() {
        // Implementation here
    }
}

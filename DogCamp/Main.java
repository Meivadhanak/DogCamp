public class Main {
    public static void main(String[] args) {
        Camp camp = new Camp("Happy Paws",
                new String[]{"Agility Park", "Quiet Zone", "Water Garden"},
                new int[]{10, 5, 8});

        Dog rex = new HerdingDog("Rex", 4);
        PlayArea quiet = camp.getPlayAreas().get(1);

        camp.executeCommand(new FeedCommand(rex));
        camp.executeCommand(new TransferCommand(rex, quiet));

        System.out.println("Camp '" + camp.getName() + "' created with "
                + camp.getPlayAreas().size() + " play areas.");
        System.out.println("Dog " + rex.getName() + " has id " + rex.getId());

        try {
            new PamperedDog("Bella", -1);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation works: " + e.getMessage());
        }
    }
}

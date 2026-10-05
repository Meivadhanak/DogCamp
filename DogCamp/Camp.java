import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Camp {
    private static final int AREA_COUNT = 3;

    private final String name;
    private final List<PlayArea> playAreas = new ArrayList<>();

    // Composition: the Camp creates its own PlayAreas, so they cannot outlive it.
    public Camp(String name, String[] areaNames, int[] capacities) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Camp name must not be empty.");
        }
        if (areaNames == null || capacities == null
                || areaNames.length != AREA_COUNT || capacities.length != AREA_COUNT) {
            throw new IllegalArgumentException("A camp must have exactly " + AREA_COUNT + " play areas.");
        }
        this.name = name;
        for (int i = 0; i < AREA_COUNT; i++) {
            playAreas.add(new PlayArea(areaNames[i], capacities[i]));
        }
    }

    public String getName() { return name; }

    public List<PlayArea> getPlayAreas() {
        return Collections.unmodifiableList(playAreas);
    }

    // Invoker: Camp does not know what the command does (OCP).
    public void executeCommand(CampCommand cmd) {
        if (cmd == null) {
            throw new IllegalArgumentException("Command must not be null.");
        }
        cmd.execute();
    }
}

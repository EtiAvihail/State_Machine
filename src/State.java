import java.io.Serializable;

public abstract class State implements Serializable {

    // Name is a unique identifier per state (each State should have a different name)
    private String name;

    public State(String name) {
        this.name = name;
    }

    // Returns the name of the next state
    public abstract String handleEvent(Event event);


    public String getName() {
        return name;
    }
}

import java.io.*;
import java.util.*;

public class Machine {

    State currentState;
    Map<String, State> possibleStates;
    String fileToPersist;

    //A constructor for an existing machine, to load its data
    public Machine(Set<State> states, String fileToPersist) throws IOException, UnknownStateException, DuplicateStateNamesExcpetion, ClassNotFoundException {
        this.currentState = loadStateFromFile(fileToPersist);
        this.fileToPersist = fileToPersist;
        buildAndValidatePossibleStates(this.currentState, states);
    }

    public Machine(State initialState, Set<State> states, String fileToPersist) throws UnknownStateException, DuplicateStateNamesExcpetion {
        this.currentState = initialState;
        this.fileToPersist = fileToPersist;
        buildAndValidatePossibleStates(initialState, states);
    }

    private void buildAndValidatePossibleStates(State initialState, Set<State> states) throws UnknownStateException, DuplicateStateNamesExcpetion {
        this.possibleStates = new HashMap<>();
        for (State state : states) {
            possibleStates.put(state.getName(), state);
        }

        if (!possibleStates.containsKey(initialState.getName())) {
            throw new UnknownStateException("Received unknown initial state");
        }
        if (possibleStates.keySet().size() != states.size()) {
            // Consider printing a warning instead of throwing exception
            throw new DuplicateStateNamesExcpetion("Received multiple states with the same name, state name must be unique");
        }
    }

    public void handleEvent(Event event) throws UnknownStateException, IOException {
        String nextState = currentState.handleEvent(event);
        this.currentState = getStateByName(nextState);
        persistState(this.currentState);
    }

    public State getCurrentState() {
        return currentState;
    }

    private State getStateByName(String stateName) throws UnknownStateException {
        State newState = possibleStates.get(stateName);
        if (newState == null) {
            throw new UnknownStateException("Received unknown state as the next state");
        } else {
            return newState;
        }
    }

    private void persistState(State state) throws IOException {
        FileOutputStream file = new FileOutputStream(this.fileToPersist);
        ObjectOutputStream out = new ObjectOutputStream(file);

        out.writeObject(state);

        out.close();
        file.close();
    }

    private State loadStateFromFile(String path) throws IOException, ClassNotFoundException {

        FileInputStream file = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(file);

        State state = (State)in.readObject();

        in.close();
        file.close();

        return state;
    }

    public class UnknownStateException extends Exception {
        public UnknownStateException(String message) {
            super(message);
        }
    }

    public class DuplicateStateNamesExcpetion extends Exception {
        public DuplicateStateNamesExcpetion(String message) {
            super(message);
        }
    }
}

/*
A class to test the first part of persistence of a machine;
You should first run the main of this class first, and then  class "PersistenceTester"
 */

import java.util.HashSet;
import java.util.Set;

public class FirstPersistenceTester {

    public static void main(String[] args) throws Exception {

        String fileToPersist = "C:\\Users\\Eti\\IdeaProjects\\StateMachine\\Machine.data";
        MyState initialState = new MyState("MyState");
        Set<State> machineStates = new HashSet<>();
        machineStates.add(initialState);

        Machine machine = new Machine(initialState, machineStates, fileToPersist);

        Event firstNumberEvent = new Event("number", null);
        Event secondNumberEvent = new Event("number", null);
        Event firstStringEvent = new Event("string", null);

        machine.handleEvent(firstNumberEvent);
        machine.handleEvent(firstStringEvent);
        machine.handleEvent(firstNumberEvent);
        machine.handleEvent(secondNumberEvent);

    }
}

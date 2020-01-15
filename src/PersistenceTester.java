/*
A class to test the persistence of a machine;
You should first run the main of class "FirsPersistenceTester"
then, this class should run to see if the machine's state was saved to a file and we can
pick it up from where it ended.
 */

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class PersistenceTester {

    public static void main(String[] args) throws ClassNotFoundException, Machine.UnknownStateException, Machine.DuplicateStateNamesExcpetion, IOException {
        String fileToPersist = "C:\\Users\\Eti\\IdeaProjects\\StateMachine\\Machine.data";
        MyState initialState = new MyState("MyState");
        Set<State> machineStates = new HashSet<>();
        machineStates.add(initialState);

        Machine machine = new Machine(machineStates, fileToPersist);

        Event thirdNumberEvent = new Event("number", null);
        machine.handleEvent(thirdNumberEvent);
    }
}

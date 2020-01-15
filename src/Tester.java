import java.util.HashSet;
import java.util.Set;

public class Tester {

    public static void main(String[] args) throws Exception {

        String fileToPersist = "C:\\Users\\Eti\\IdeaProjects\\StateMachine\\Machine.data";
        MyState initialState = new MyState("MyState");
       // MyState anotherState = new MyState("MyState");
        Set<State> machineStates = new HashSet<>();
        machineStates.add(initialState);
      //  machineStates.add(anotherState); //testing validation of unique states


        Machine machine = new Machine(initialState, machineStates, fileToPersist);

        Event firstNumberEvent = new Event("number", null);
        Event secondNumberEvent = new Event("number", null);
        Event thirdNumberEvent = new Event("number", null);
        Event firstStringEvent = new Event("string", null);

        machine.handleEvent(firstNumberEvent);
        machine.handleEvent(firstStringEvent);
        machine.handleEvent(firstNumberEvent);
        machine.handleEvent(secondNumberEvent);
        machine.handleEvent(thirdNumberEvent);


    }

}

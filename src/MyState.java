public class MyState extends State {

    private int counter;
    private Event prevEvent;

    public MyState(String name) {
        super(name);
    }

    @Override
    public String handleEvent(Event event) {
        if (prevEvent != null && event != null) {
            if (event.getType().equals(prevEvent.getType())) {
                counter++;
                if (counter == 3) {
                    System.out.println("Warning: received three consecutive events of the same type!");
                    counter = 0;
                }
            } else {
                counter = 1;
            }
        } else {
            counter = 1;
        }
        prevEvent = event;
        return this.getName(); // We always stay in the same state
    }
}

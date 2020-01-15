import org.json.JSONObject;
import java.io.Serializable;
import java.util.UUID;

public class Event implements Serializable {

    private UUID id;
    private String type;
    private JSONObject data;

    public Event(String type, JSONObject data){

        this.id = UUID.randomUUID();
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public UUID getId() {
        return id;
    }

    public String getData() {
        // Returning as String to ensure data is not altered
        if (data == null) {
            return null;
        }
        return data.toString();
    }
}

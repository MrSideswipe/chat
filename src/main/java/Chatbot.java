import org.json.JSONException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Chatbot extends Channel {

    public Chatbot() {
    	super("Chatbot");
    }

    public String generateAnswer(String command) throws IOException, JSONException {
        switch (command){
            case "time":
                return "Time: " + String.valueOf( new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) );
            case "day":
                return "Day: " + String.valueOf( new SimpleDateFormat("EEEE", Locale.US).format(new Date()));
            case "weather":
                return "Weather: " + new Weather().getWeather();
            default:
            	return "Type 'time' for time, 'day' for day of the week, 'weather' for weather in Krakow";
        }
        
    }


}

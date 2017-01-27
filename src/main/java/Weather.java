import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Weather {

    private String weather;
    private String time;
    private Double temperature;
    public Weather() throws IOException, JSONException {
        generateWeather();

    }
    private void generateWeather() throws IOException, JSONException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=Cracow&APPID=ac6159945d52f0c0a8ba3af4d536e052";
        ConnectionWeb connection = new ConnectionWeb(url);
        connection.download();
        String jsonResult = connection.getJsonResult();
        JSONObject jsonObject = new JSONObject(jsonResult);
        weather = jsonObject.getJSONArray("weather").getJSONObject(0).getString("description");
        temperature = Double.parseDouble(jsonObject.getJSONObject("main").getString("temp")) - 273.15;
        time = String.valueOf( new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()) );
    }
    public String getWeather(){
        return "Krakow: " + weather + ", temperature: " + temperature + " C, time: " + time;
    }
}

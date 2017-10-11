import connection.HttpConnection;
import groovy.json.JsonParser;
import groovy.json.internal.JsonStringDecoder;


import javax.swing.text.html.HTML;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WeatherApplication {

    public static void main(String[] args) throws Exception {
        //HttpConnection connection = new HttpConnection("http://api.openweathermap.org/data/2.5" +
        //        "/forecast?id=524901&APPID=8142ab303ab91d4449a4e5f5685de78d");

        HttpURLConnection connection = null;
        try {
            URL url = new URL("http://api.openweathermap.org/data/2.5" +
                    "/forecast?id=588409&APPID=8142ab303ab91d4449a4e5f5685de78d");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
        } catch (Exception e) {
            System.out.println(e);
        }


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        //List<String> content = new ArrayList<String>();
        StringBuffer content = new StringBuffer();
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line);
        }
        bufferedReader.close();

        connection.disconnect();
        System.out.println(content);

    }
}

package com.example.someexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class WheatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wheather);

        Thread thread;
        thread = new Thread(new Runnable() {

            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL("http://api.openweathermap.org/data/2.5/weather?q=Almaty&appid=d0e36e59b39a97d25555f97f041d2068");
                    HttpURLConnection con = null;
                    con = (HttpURLConnection) url.openConnection();
                    con.setRequestMethod("GET");
                    int status = con.getResponseCode();
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    StringBuffer content = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        content.append(inputLine);
                    }
                    in.close();

                    con.disconnect();


                    final Wheather p = new Wheather();
                    JSONObject reader = new JSONObject(content.toString());
                    p.name = reader.getString("name");
                    p.deg = reader.getJSONObject("wind").getDouble("deg");
                    p.speed = reader.getJSONObject("wind").getDouble("speed");
                    p.huminity = reader.getJSONObject("main").getDouble("humidity");
                    p.pressure = reader.getJSONObject("main").getDouble("pressure");
                    p.huminity = reader.getJSONObject("main").getDouble("humidity");
                    p.temp = reader.getJSONObject("main").getDouble("temp");
                    p.description = reader.getJSONArray("weather").getJSONObject(0).getString("description");

                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            TextView description = (TextView) findViewById(R.id.description);
                            TextView speed = (TextView) findViewById(R.id.speed);
                            TextView humidity = (TextView) findViewById(R.id.humidity);
                            TextView pressure = (TextView) findViewById(R.id.pressure);
                            TextView temp = (TextView) findViewById(R.id.temp);


                            description.setText(p.description);
                            speed.setText(Double.toString(p.speed));
                            humidity.setText(Double.toString(p.huminity));
                            temp.setText(Double.toString(p.temp));
                            pressure.setText(Double.toString(p.pressure));

                        }
                    });


                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }});
        thread.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch(id){
            case R.id.wheather:
                Intent myIntent = new Intent(this, WheatherActivity.class);
                startActivity(myIntent);
                return true;
            case R.id.currency:
                Intent myIntent2 = new Intent(this, CurrencyActivity.class);
                startActivity(myIntent2);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

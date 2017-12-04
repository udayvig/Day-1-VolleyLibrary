package rootonelabs.vicky.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String name;
    RequestQueue rq;
    TextView nameText, descriptionText, weatherText;


    String description, weather;

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rq = Volley.newRequestQueue(this);

        nameText = (TextView) findViewById(R.id.textname);
        descriptionText = (TextView) findViewById(R.id.description);
        weatherText = (TextView)findViewById(R.id.weather);
        Button button = (Button)findViewById(R.id.button);




        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText cityName = (EditText)findViewById(R.id.search);
                name = cityName.getText().toString();
                url = "http://openweathermap.org/data/2.5/weather?q="+name+"&appid=b1b15e88fa797225412429c1c50c122a1";
                sendJsonRequest();

            }
        });

    }

    public void sendJsonRequest(){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    String weatherInfo = response.getString("weather");
                    JSONArray arr = new JSONArray(weatherInfo);

                    response = arr.getJSONObject(0);

                    description = response.getString("description");
                    weather = response.getString("main");

                    Log.i("WEATHER ID:", name);
                    Log.i("WEATHER TYPE: ", weather);
                    Log.i("WEATHER DESCRIPTION: ", description);

                    nameText.setText(name);
                    descriptionText.setText(description);
                    weatherText.setText(weather);

                    sendJsonRequest();


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"ERROR!!", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"ERROR!!", Toast.LENGTH_SHORT).show();
            }

    });

        rq.add(jsonObjectRequest);
    }

}
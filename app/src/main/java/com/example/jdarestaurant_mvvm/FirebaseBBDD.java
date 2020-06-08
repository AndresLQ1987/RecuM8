package com.example.jdarestaurant_mvvm;

import android.os.AsyncTask;

import com.example.jdarestaurant_mvvm.Model.Plato;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FirebaseBBDD {

    public void getPlatosMenu() {
        HiloGetPlatosMenu thread = new HiloGetPlatosMenu();
        thread.execute("https://jdarestaurantapi.firebaseio.com/menu.json");
    }

    public class HiloGetPlatosMenu extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection connection;
            URL url;
            connection = null;
            String result;
            result = "";

            try {
                url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();

                int data = inputStream.read();

                while (data != -1) {
                    result += (char) data;
                    data = inputStream.read();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String data) {
            super.onPostExecute(data);
            List<Plato> platosmenu = new ArrayList<>();

            try {
                JSONObject jsonObject = new JSONObject(data);
                JSONArray jsonArrayKeys = jsonObject.names();
                for(int i = 0; i < jsonObject.length(); i++){
                    String key = (String) jsonArrayKeys.get(i);
                    JSONObject jsonObject_item = jsonObject.getJSONObject(key);
                    Plato persona = new Plato(jsonObject_item);
                    platosmenu.add(persona);
                }
            } catch (JSONException jsonException) {
                jsonException.printStackTrace();
            }

            //lista_personas.postValue(listaPersonas);
        }
    }
}

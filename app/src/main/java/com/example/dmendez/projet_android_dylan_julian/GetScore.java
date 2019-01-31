/*package com.example.dmendez.projet_android_dylan_julian;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class GetScore extends AsyncTask<Void, Void, Void>{
    String uneUrl = String.format("http://10.0.2.2/TestPhp/Mysql_vers_json.php");
    private String TAG = MainActivity.class.getSimpleName();
    ArrayList<HashMap<String, String>> List_score;




    @Override
    protected Void doInBackground(Void... voids)
    {
        HttpHandler sh = new HttpHandler();
        // déclenche une requête sur l'url
        String url = uneUrl;
        String jsonStr = sh.makeServiceCall(url);

        Log.e(TAG, "Response from url: " + jsonStr);
        if (jsonStr != null) {
            try {
                JSONArray contacts = new JSONArray(jsonStr);
                for (int i = 0; i < contacts.length(); i++) {
                    JSONObject c = contacts.getJSONObject(i);

                    String id = c.getString("id");
                    String score = c.getString("score");
                    String nom = c.getString("nom");
                    String niveau = c.getString("niveau");
                    HashMap<String, String> unScore  = new HashMap<>();
                    unScore.put("id", id);
                    unScore.put("score", score);
                    unScore.put("nom", nom);
                    unScore.put("niveau", niveau);
                    List_score.add(unScore);

                }
            } catch (final JSONException e) {
                Log.e(TAG, "erreur de Parse Json: " + e.getMessage());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext()," erreur de Parse Json:" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
            }

        } else {
            Log.e(TAG, "Pb récup Json sur le serveur.");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext()," Pb récup Json sur le serveur. Voir Logcat!", Toast.LENGTH_LONG).show();
                }
            });
        }

        return null;
        return null;
    }
}
*/
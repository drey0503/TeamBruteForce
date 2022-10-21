package com.example.tracknba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tracknba.utils.NetworkUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchForTeam extends AppCompatActivity implements View.OnClickListener {

    String myUrl = "https://www.balldontlie.io/api/v1/teams";
    TextView resultsTextView;
    EditText teamEt;
    ProgressDialog progressDialog;
    Button btnFetch;
    String teamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_for_team);
        resultsTextView = findViewById(R.id.results);
        teamEt = findViewById(R.id.team_et);
        btnFetch = findViewById(R.id.btn_fet);

        btnFetch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_fet) {
            teamName = teamEt.getText().toString();
            getData();
        }
    }

    public void getData() {
        Uri uri = Uri.parse(myUrl).buildUpon().build();
        URL url = null;
        try {
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        new AsyncTasks().execute(url);
    }

    class AsyncTasks extends AsyncTask<URL, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(SearchForTeam.this);
            progressDialog.setMessage("Fetching Team Information");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(URL... urls) {
            URL url = urls [0];
            String data = null;
            try {
                data = NetworkUtils.makeHTTPRequest(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return data;
        }
        @Override
        protected void onPostExecute(String s) {
            progressDialog.dismiss();
            try {
                parseJson(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        public void parseJson(String data) throws JSONException {
            JSONObject jsonObject = null;
            try {
                jsonObject = new JSONObject(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            JSONArray teamArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < teamArray.length(); i++) {
                JSONObject teamo = teamArray.getJSONObject(i);
                String teamfn = teamo.get("full_name").toString();
                String teamn = teamo.get("name").toString();
                String teamc = teamo.get("city").toString();
                String teama = teamo.get("abbreviation").toString();
                if (teamfn.equalsIgnoreCase(teamName)||teamn.equalsIgnoreCase(teamName)||teamc.equalsIgnoreCase(teamName)||teama.equalsIgnoreCase(teamName)) {
                    String result = "Name: " + teamfn + " (" + teama + ")" +"\n";
                    result += "City: " + teamc + "\n";
                    result += "Conference: " + teamo.get("conference") + "\n";
                    result += "Division: " + teamo.get("division");

                    resultsTextView.setText(result);
                    break;
                } else {
                    String nf = "Not Found";
                    resultsTextView.setText(nf);
                }
            }
        }
    }
}

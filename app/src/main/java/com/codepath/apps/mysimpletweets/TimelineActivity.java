package com.codepath.apps.mysimpletweets;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.entity.mime.Header;

import static com.codepath.apps.mysimpletweets.R.layout.activity_login;
import static com.codepath.apps.mysimpletweets.R.layout.activity_timeline;
import static com.codepath.apps.mysimpletweets.R.layout.content_timeline;

public class TimelineActivity extends ActionBarActivity {
    private TwitterClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_timeline);
        client = TwitterApplication.getRestClient(); //singleton client
        populateTimeline();

    }

    //Send API request to get the timelinejson
    //Fill the listview by creating the tweet objects form the json
    private void populateTimeline() {
        client.getHomeTimeline(new JsonHttpResponseHandler() {
            //SUCCESS
            public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
                Log.d("DEBUG", json.toString());
            }

            //FAILURE
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
            }

        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        //Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }
}



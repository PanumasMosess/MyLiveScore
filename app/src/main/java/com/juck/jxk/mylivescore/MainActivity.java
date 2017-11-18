package com.juck.jxk.mylivescore;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.juck.jxk.mylivescore.Model.Fixture;
import com.juck.jxk.mylivescore.Model.FixtureManager;
import com.juck.jxk.mylivescore.Model.Result;
import com.juck.jxk.mylivescore.api.ApiManager;
import com.juck.jxk.mylivescore.api.FixtureService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private View parentView;
    private ListView listView;
    private List<Fixture> fixture;
    private List<Result> results;
    private ScoreAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fixture =  new ArrayList<>();
        results = new ArrayList<>();
        listView = (ListView) findViewById(R.id.list_view_Score);

        final ProgressDialog dialog;
        /**
         * Progress Dialog for User Interaction
         */
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setTitle(getString(R.string.string_getting_json_title));
        dialog.setMessage(getString(R.string.string_getting_json_message));
        dialog.show();

        ApiManager api = FixtureService.getMyJSON();

        Call<FixtureManager> call = api.getMyJSON();

        call.enqueue(new Callback<FixtureManager>() {
            @Override
            public void onResponse(Call<FixtureManager> call, Response<FixtureManager> response) {
                //Dismiss Dialog
                dialog.dismiss();

                if(response.isSuccessful()) {
                    /**
                     * Got Successfully
                     */
                    fixture = response.body().getFixtures();

                    /**
                     * Binding that List to Adapter
                     */
                    adapter = new ScoreAdapter(MainActivity.this, fixture);
                    listView.setAdapter(adapter);


                } else {
                    Snackbar.make(parentView, R.string.string_some_thing_wrong, Snackbar.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<FixtureManager> call, Throwable t) {
                dialog.dismiss();
                System.out.println("Failed");
            }
        });
    }
}

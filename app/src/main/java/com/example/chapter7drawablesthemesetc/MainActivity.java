package com.example.chapter7drawablesthemesetc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mScore1;
    private int mScore2;

    private TextView mScoreText1;
    private TextView mScoreText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScoreText1 = (TextView) findViewById(R.id.teamScore1);
        mScoreText2 = (TextView) findViewById(R.id.teamScore2);
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt("teamscore1");
            mScore2 = savedInstanceState.getInt("teamscore2");

            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    public void increaseScore(View v) {
        switch (v.getId()) {
            case R.id.increaseTeam1:
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.increaseTeam2:
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    public void decreaseScore(View v) {
        switch (v.getId()) {
            case R.id.decreaseTeam1:
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;
            case R.id.decreaseTeam2:
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
// Recreate the activity for the theme change to take effect.
            recreate();
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the scores.
        outState.putInt("teamscore1", mScore1);
        outState.putInt("teamscore2", mScore2);
        super.onSaveInstanceState(outState);
    }
}
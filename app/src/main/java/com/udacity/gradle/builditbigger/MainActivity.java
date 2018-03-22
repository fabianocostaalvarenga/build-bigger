package com.udacity.gradle.builditbigger;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.tasks.JokeAsyncTask;
import com.udacity.gradle.builditbigger.tasks.JokeTaskDelegate;
import com.udacity.libjokes.Jokes;
import com.udacity.mobilelibraryjokes.JokeViewActivity;


public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        Toast.makeText(this, Jokes.getRandomJoke(), Toast.LENGTH_LONG).show();
    }

    public void tellMyJokeByLibJava(View view) {
        final Intent intent = new Intent(this, JokeViewActivity.class);
        intent.putExtra(JokeViewActivity.KEY_MESSAGE, Jokes.getRandomJoke());
        startActivity(intent);
    }

    public void tellMyJokeByGoogleCloudEndpointsAPI(final View view) {
        final Intent intent = new Intent(this, JokeViewActivity.class);
        showProgress();
        new JokeAsyncTask(new JokeTaskDelegate() {
            @Override
            public void onFinish(String joke) {
                if(joke == null) {
                    Snackbar.make(view, getString(R.string.no_data_found), Snackbar.LENGTH_LONG).show();
                } else {
                    intent.putExtra(JokeViewActivity.KEY_MESSAGE, joke);
                    startActivity(intent);
                }
                hideProgress();
            }
        }).execute();
    }

    private void showProgress() {
        if(progressDialog != null) {
            progressDialog.cancel();
        }
        progressDialog = ProgressDialog.show(this, "", getString(R.string.please_wait), true, true);
    }

    private void hideProgress() {
        if(progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
}

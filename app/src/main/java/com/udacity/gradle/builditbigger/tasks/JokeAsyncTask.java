package com.udacity.gradle.builditbigger.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

import static com.google.api.client.extensions.android.http.AndroidHttp.newCompatibleTransport;

/**
 * Created by fabiano.alvarenga on 13/03/18.
 */

public class JokeAsyncTask extends AsyncTask<Void, Long, String> {

    private static final String TAG = JokeAsyncTask.class.getSimpleName();

    private static MyApi myApiService = null;
    private JokeTaskDelegate jokeTaskDelegate;

    public JokeAsyncTask(JokeTaskDelegate jokeTaskDelegate) {
        this.jokeTaskDelegate = jokeTaskDelegate;
    }

    @Override
    protected String doInBackground(Void... voids) {
        String result = null;
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://api-6710655516841685750-162158.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            myApiService = builder.build();
        }

        try {
            result = myApiService.joke().execute().getData();
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        this.jokeTaskDelegate.onFinish(s);
    }

}

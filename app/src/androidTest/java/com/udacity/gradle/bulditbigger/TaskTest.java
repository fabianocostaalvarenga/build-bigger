package com.udacity.gradle.bulditbigger;

import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.tasks.JokeAsyncTask;
import com.udacity.gradle.builditbigger.tasks.JokeTaskDelegate;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by vinicius.rocha on 2/21/18.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TaskTest{

    @Test
    public void testEndpointsTask() throws InterruptedException,
            ExecutionException, TimeoutException {

        new JokeAsyncTask(new JokeTaskDelegate() {
            @Override
            public void onFinish(String joke) {
                assertNotNull(joke);
                assertFalse(joke.length() == 0);
            }
        }).execute().get(20, TimeUnit.SECONDS);

    }
}

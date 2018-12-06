package com.beatrice.user.fcm_test.services;

import Rest.ApiInterface;
import Rest.RestClient;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.RemoteMessage;
import model.Fcm_tokens;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    public final static String TAG = FirebaseMessagingService.class.getSimpleName();

    public FirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "FROM!!!!: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());



        }else{
            Log.d(TAG, "DELIAF!!!!!!");
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
    }

    @Override
    public void onNewToken(String s) {
        Log.d("NEWTOKEN", s);

        //save the token
        saveToken(s);

    }

    //send the token to the server
    private void saveToken(String mToken) {
        ApiInterface apiInterface = RestClient.getClient().create(ApiInterface.class);
        Call<Fcm_tokens> call = apiInterface.saveToken(mToken);
        call.enqueue(new Callback<Fcm_tokens>() {
            @Override
            public void onResponse(Call<Fcm_tokens> call, Response<Fcm_tokens> response) {
                Log.d("POSTSUCCESS", "SUCCESSFULLLL!!!!!");
            }

            @Override
            public void onFailure(Call<Fcm_tokens> call, Throwable t) {
                Log.e("FAILED!!!", t.getMessage());

            }
        });
    }
}

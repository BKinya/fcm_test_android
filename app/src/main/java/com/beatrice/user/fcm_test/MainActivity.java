package com.beatrice.user.fcm_test;

import Rest.ApiInterface;
import Rest.RestClient;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import model.Fcm_tokens;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //subscribe to a topic
        FirebaseMessaging.getInstance().subscribeToTopic("test").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (!task.isSuccessful() ){
                    Log.e(TAG, "NOT SUCCESSFUL:Message");
                }

                Log.d(TAG, "SUCCESSFUL:MESSAGE");
            }
        });

        //get token
        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                if (!task.isSuccessful()) {
                    Log.e(TAG, "NOT SUCCESSFULL: TOKEN " + task.getException());
                }

                String mToken = task.getResult().getToken();
                Log.d(TAG, "TOKENNNN!!! " + mToken);



            }
        });


    }


}





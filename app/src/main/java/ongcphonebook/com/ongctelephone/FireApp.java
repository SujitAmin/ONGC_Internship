package ongcphonebook.com.ongctelephone;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;


/**
 * Created by admin on 28-Jun-17.
 */

public class FireApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //  Firebase.setAndroidContext(this);

        // if(!com.google.firebase.FirebaseApp.getApps(this).isEmpty())
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        //
    }
}

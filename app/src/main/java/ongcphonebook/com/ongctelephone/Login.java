package ongcphonebook.com.ongctelephone;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity implements View.OnClickListener {

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String pref_cpf = "cpfKey";
    public static final String pref_password = "passwordKey";
    Button button_login;
    //  String check = "@ongc.co.in";
    EditText editText_Username, editText_Password;
    SharedPreferences sharedpreferences;//look
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        editText_Password = (EditText) findViewById(R.id.editText_Password);
        editText_Username = (EditText) findViewById(R.id.editText_Username);

        button_login = (Button) findViewById(R.id.button_login);
        button_login.setOnClickListener(this);


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User is signed in

                    Intent intent = new Intent(Login.this, Search.class);
                    startActivity(intent);
                }

                //...
            }

        };


    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void getUser() {
        ///  SharedPreferences pref = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String Cpfno = sharedpreferences.getString(pref_cpf, null);
        String password = sharedpreferences.getString(pref_password, null);
    }

    @Override
    public void onClick(View v) {

        // if(!validate()){


        startSignIn();


    }
    //  }


    private void startSignIn() {
        String email = editText_Username.getText().toString();
        String password = editText_Password.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {

            Toast.makeText(Login.this, "Fields are empty", Toast.LENGTH_LONG).show();

        } else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        Toast.makeText(Login.this, "Sign in problem", Toast.LENGTH_LONG).show();
                    }

                }
            });

        }
    }
}







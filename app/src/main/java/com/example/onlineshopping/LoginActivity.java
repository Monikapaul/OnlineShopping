package com.example.onlineshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {
    private EditText loginemail, loginpassword;
    private Button LoginButton;
    FirebaseAuth Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginButton = (Button) findViewById(R.id.login_btn);
        loginemail = (EditText) findViewById(R.id.loginemail);
        loginpassword = (EditText) findViewById(R.id.loginpassword);
        Auth=FirebaseAuth.getInstance();
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = loginemail.getText().toString();
                String password = loginpassword.getText().toString();
                if(TextUtils.isEmpty(email)){
                    loginemail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    loginpassword.setError("Password is required");
                    return;
                }
                if(password.length() <6){
                    loginpassword.setError("Password must be >= 6 characters");
                    return;
                }
                // authenticate the user
                Auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                        Toast.makeText(LoginActivity.this,"Logged in Successfully",Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(),AdminCategoryActivity.class));
                    } else {
                        Toast.makeText(LoginActivity.this, "Error" +task.getException().getMessage(),Toast.LENGTH_LONG).show();

                    }
                    }
                });
            }
        });
        }
}


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

import com.example.onlineshopping.models.Register;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {
    private Button CreateAccountButton;
    private EditText InputName, InputEmail, InputPassword;
    FirebaseAuth Auth;
    FirebaseFirestore db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        CreateAccountButton = (Button) findViewById(R.id.register_btn);
        InputName = (EditText) findViewById(R.id.username);
        InputPassword = (EditText) findViewById(R.id.password);
        InputEmail = (EditText) findViewById(R.id.email);
        db = FirebaseFirestore.getInstance();
        Auth = FirebaseAuth.getInstance();

        if(Auth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),AdminCategoryActivity.class));
            finish();


        }
        CreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = InputName.getText().toString();
                String email = InputEmail.getText().toString();
                String password = InputPassword.getText().toString();
                if(TextUtils.isEmpty(email)){
                    InputEmail.setError("Email is required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    InputPassword.setError("Password is required");
                    return;
                }
                if(password.length() <6){
                    InputPassword.setError("Password must be >= 6 characters");
                    return;
                }

                Auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            addData(name, email, password);
                            Toast.makeText(RegisterActivity.this,"User Created",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                        } else{
                            Toast.makeText(RegisterActivity.this, "Error" +task.getException().getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }
                });

            }
        });

    }
    public void addData(String InputName, String InputEmail, String InputPassword) {
        Register register = new Register(InputName, InputEmail, InputPassword);
        db.collection("users")
                .add(register)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(), "Users recorded", Toast.LENGTH_LONG).show();
                    }

                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error" + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });



    }


    }


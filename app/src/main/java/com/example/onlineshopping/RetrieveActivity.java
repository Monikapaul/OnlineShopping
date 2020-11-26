package com.example.onlineshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.onlineshopping.models.Addproducts;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class RetrieveActivity extends AppCompatActivity {
    TextView result_tv;
    Button logoutbutton;
    FirebaseFirestore db;
    FirebaseAuth Auth;
    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        result_tv = (TextView)findViewById(R.id.data_tv);
        logoutbutton = (Button)findViewById(R.id.logoutbtn);
        db = FirebaseFirestore.getInstance();
        Auth=FirebaseAuth.getInstance();

        getData();

        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
            }
        });
    }

    public void getData(){
        userID=Auth.getCurrentUser().getUid();
        db.collection("Products").document(userID).collection("Userproducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            String resultStr = "";

                            for(DocumentSnapshot document : task.getResult()){
                                Addproducts ptd = document.toObject(Addproducts.class);
                                resultStr += "Name: "+ptd.getName() + "\nDescription: "+ptd.getDescription() + "\nPrice: " +ptd.getPrice()
                                        + "\n\n";
                            }
                            result_tv.setText(resultStr);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error "+e.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

    }

}
package com.example.onlineshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.onlineshopping.models.Addproducts;
import com.example.onlineshopping.models.Register;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddNewProductActivity extends AppCompatActivity {

    private Button addproductbtn;

    private EditText name, description, price;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product);

        addproductbtn = (Button) findViewById(R.id.addnewproduct);

        name = (EditText) findViewById(R.id.product_name);
        description = (EditText) findViewById(R.id.product_description);
        price = (EditText) findViewById(R.id.product_price);


        db = FirebaseFirestore.getInstance();

        addproductbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pname = name.getText().toString();
                String pdescription = description.getText().toString();
                String pprice = price.getText().toString();
                addData(pname, pdescription, pprice);
            }
        });
    }



    public void addData(String name, String description, String price) {
        Addproducts addp = new Addproducts(name,description,price);
        db.collection("Products")
                .add(addp)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getApplicationContext(),"Product added successfully", Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Error"+e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });


    }

}


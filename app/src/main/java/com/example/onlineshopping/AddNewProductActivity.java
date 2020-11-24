package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddNewProductActivity extends AppCompatActivity {
    private String CategoryName;
    private Button addproductbtn;
    private ImageView image;
    private EditText name, description, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_product);
        CategoryName = getIntent().getExtras().get("category").toString();
        addproductbtn = (Button) findViewById(R.id.add_new_product);
        image = (ImageView) findViewById(R.id.select_product_image);
        name = (EditText) findViewById(R.id.product_name);
        description = (EditText) findViewById(R.id.product_description);
        price = (EditText) findViewById(R.id.product_price);
    }
}
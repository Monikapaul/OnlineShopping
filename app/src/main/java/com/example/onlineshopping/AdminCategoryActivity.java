package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView lboot, belly, sandal;
    private ImageView shos, sports, sleepr;
    private ImageView boot, rubber;
    Button showproduct;
    Button insertproduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);
        lboot = (ImageView) findViewById(R.id.longbootsimg);
        belly = (ImageView) findViewById(R.id.belliesimg);
        sandal = (ImageView) findViewById(R.id.sandalsimg);
        shos = (ImageView) findViewById(R.id.shoesimg);
        sports = (ImageView) findViewById(R.id.sportshoesimg);
        sleepr = (ImageView) findViewById(R.id.sleeprsimg);
        boot = (ImageView) findViewById(R.id.bootimg);
        rubber = (ImageView) findViewById(R.id.rubberbootsimg);
        showproduct = (Button)findViewById(R.id.show_btn);
        insertproduct = (Button)findViewById(R.id.insert_btn);

        lboot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "Long Boots");
                startActivity(intent);
            }
        });
        belly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "Bellies");
                startActivity(intent);
            }
        });
        sandal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "Sandals");
                startActivity(intent);
            }
        });
        shos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "Shoes");
                startActivity(intent);
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "Sport Shoes");
                startActivity(intent);
            }
        });
        sleepr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "Sleepers");
                startActivity(intent);
            }
        });

        boot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "Another Shoes");
                startActivity(intent);
            }
        });
        rubber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminCategoryActivity.this, AddNewProductActivity.class);
                intent.putExtra("category", "Rubber Boots");
                startActivity(intent);
            }
        });
        showproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, retrofitproducts.class);
                startActivity(intent);

            }
        });
        insertproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this, retrofitpostproducts.class);
                startActivity(intent);

            }
        });

    }
}



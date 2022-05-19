package com.example.shopeee.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shopeee.R;
import com.example.shopeee.adapter.PopularProductAdapter;
import com.example.shopeee.models.NewProductModel;
import com.example.shopeee.models.PopularProductModel;
import com.example.shopeee.models.ShowAllModel;
import com.google.firebase.firestore.FirebaseFirestore;

public class DetailedActivity extends AppCompatActivity {
    ImageView detailedImg, addItems, removeItems;
    TextView description, price;
    Button addToCart, buyNow;
    TextView name;

    private FirebaseFirestore firebaseFirestore = null;
    NewProductModel newProductModel;
    ShowAllModel showAllModel;
    PopularProductModel popularProductModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        firebaseFirestore = FirebaseFirestore.getInstance();
        final Object obj = getIntent().getSerializableExtra("detailed");

//        if (obj instanceof NewProductModel) {
//            newProductModel = (NewProductModel) obj;
//        } elseif(obj instanceof PopularProductModel)

        anhXa();
    }

    public void anhXa() {
         detailedImg = findViewById(R.id.detailed_img);
         addItems = findViewById(R.id.add_item);
         buyNow = findViewById(R.id.buy_now);
         removeItems = findViewById(R.id.remove_item);
         addToCart = findViewById(R.id.add_to_cart);
         description = findViewById(R.id.detailed_desc);
         price = findViewById(R.id.price_item);
         name = findViewById(R.id.detailed_name);

         if (newProductModel != null) {
             Glide.with(getApplicationContext()).load(newProductModel.getImg_url()).into(detailedImg);
             name.setText(newProductModel.getName());
             description.setText(newProductModel.getDescription());
             price.setText(newProductModel.getPrice() + "");

         }

    }
}
package com.example.shopeee.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.shopeee.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class AddAdressActivity extends AppCompatActivity {
    TextView name, address, city, postalCode, phoneNumber;
    Toolbar toolbar;
    Button btnAddaddress;

    FirebaseFirestore firestore;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_adress);
        init();

        btnAddaddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = name.getText().toString();
                String userAdress = address.getText().toString();
                String cityUser = city.getText().toString();
                String userCode = postalCode.getText().toString();
                String userPhone = phoneNumber.getText().toString();

                String final_address = "";

                if (!userName.isEmpty()) {
                    final_address += userName;
                }
                if (!userAdress.isEmpty()) {
                    final_address += userAdress;
                }
                if (!cityUser.isEmpty()) {
                    final_address += cityUser;
                }
                if (!userCode.isEmpty()) {
                    final_address += userCode;
                }
                if (!userPhone.isEmpty()) {
                    final_address += userPhone;
                }
                if (!userName.isEmpty() && !userAdress.isEmpty() && !cityUser.isEmpty()&& !userCode.isEmpty() && !userPhone.isEmpty()) {
                    Map<String, String > map = new HashMap<>();
                    map.put("userAddress", final_address);

                    firestore.collection("CurrentUser").document(auth.getCurrentUser().getUid())
                            .collection("Address").add(map).addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(AddAdressActivity.this, "Thêm địa chỉ thành công", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(AddAdressActivity.this, DetailedActivity.class));
                                        finish();
                                    } else {
                                        Toast.makeText(AddAdressActivity.this, "Bạn chưa thêm thành công", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
    }

    public void init() {

        name = findViewById(R.id.ad_name);
        address = findViewById(R.id.ad_address);
        city = findViewById(R.id.ad_city);
        postalCode = findViewById(R.id.ad_code);
        phoneNumber = findViewById(R.id.ad_phone);

        toolbar = findViewById(R.id.add_address_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        firestore = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();

        btnAddaddress = findViewById(R.id.ad_add_address);

    }
}
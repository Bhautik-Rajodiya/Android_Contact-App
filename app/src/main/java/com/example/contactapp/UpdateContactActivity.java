package com.example.contactapp;

import static com.example.contactapp.MainActivity.contactModelList;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.contactapp.adpter.ContactAdpter;
import com.example.contactapp.databinding.ActivityMainBinding;
import com.example.contactapp.databinding.ActivityUpdateContactBinding;

public class UpdateContactActivity extends AppCompatActivity {

    ActivityUpdateContactBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String name = getIntent().getStringExtra("name");
        String number = getIntent().getStringExtra("number");
        String image = getIntent().getStringExtra("image");
        String email = getIntent().getStringExtra("email");
        int index = getIntent().getIntExtra("position",0);

        binding.updateContactName.setText(name);
        binding.upadteContactNumber.setText(number);
        binding.upadteContactEmail.setText(email);

        binding.contactDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactModelList.remove(index);
                finish();
            }
        });

        binding.contactEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
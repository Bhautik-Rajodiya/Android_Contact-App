package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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

        binding.updateContactName.setText(name);
        binding.upadteContactNumber.setText(number);
        binding.upadteContactEmail.setText(email);
    }
}
package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.contactapp.adpter.ContactAdpter;
import com.example.contactapp.databinding.ActivityMainBinding;
import com.example.contactapp.model.ContactModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    static List<ContactModel> contactModelList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AddContactActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ContactAdpter adpter= new ContactAdpter(this,contactModelList);
        binding.contactRecycler.setAdapter(adpter);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        binding.contactRecycler.setLayoutManager(lm);
    }
}
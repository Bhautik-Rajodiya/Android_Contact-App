package com.example.contactapp;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.contactapp.databinding.ActivityAddContactBinding;
import com.example.contactapp.model.ContactModel;

public class AddContactActivity extends AppCompatActivity {

    ActivityAddContactBinding binding;
    Uri imageurl;

    ActivityResultLauncher<PickVisualMediaRequest> pickMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddContactBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_add_contact);
        setContentView(binding.getRoot());
        pickMedia = registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri -> {
            if (uri != null) {
                binding.contactImage.setImageURI(uri);
                imageurl = uri;
            }
        });

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.contactNameEditText.getText().toString();
                String number = binding.contactNumberEditText.getText().toString();

                ContactModel model = new ContactModel(name,number);
                MainActivity.contactModelList.add(model);
                finish();
            }
        });

        binding.contactImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickMedia.launch(new PickVisualMediaRequest.Builder()
                        .setMediaType(ActivityResultContracts.PickVisualMedia.ImageOnly.INSTANCE)
                        .build());
            }
        });
    }
}
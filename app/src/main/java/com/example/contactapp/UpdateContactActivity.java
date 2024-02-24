package com.example.contactapp;

import static com.example.contactapp.MainActivity.contactModelList;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.contactapp.adpter.ContactAdpter;
import com.example.contactapp.databinding.ActivityMainBinding;
import com.example.contactapp.databinding.ActivityUpdateContactBinding;
import com.example.contactapp.model.ContactModel;

import de.hdodenhof.circleimageview.CircleImageView;

public class UpdateContactActivity extends AppCompatActivity {

    String name,number,email;
   Uri url;
    int index;
    ActivityUpdateContactBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUpdateContactBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

         name = getIntent().getStringExtra("name");
         number = getIntent().getStringExtra("number");
         String img=getIntent().getStringExtra("image");
        assert img != null;
        if(img!=null)
         {
             url = Uri.parse(img);

         }
         email = getIntent().getStringExtra("email");
         index = getIntent().getIntExtra("position",0);

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
                    contactUpdate();
            }
        });
    }

    void contactUpdate(){
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.update_dialog);
        EditText updateName = dialog.findViewById(R.id.updateName);
        EditText updateEmail = dialog.findViewById(R.id.updateEmail);
        EditText updateNumber = dialog.findViewById(R.id.updateNumber);
        CircleImageView updateImage = dialog.findViewById(R.id.updateImage);
        Button editButton = dialog.findViewById(R.id.contactEditButton);


        updateName.setText(name);
        updateNumber.setText(number);
        updateEmail.setText(email);
//        updateImage.setImageURI(Uri.parse(url.toString()));


        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactModelList.add(index,new ContactModel(updateName.getText().toString(),updateNumber.getText().toString(),Uri.parse(" "),updateEmail.getText().toString()));

            }
        });
        dialog.show();

    }
}
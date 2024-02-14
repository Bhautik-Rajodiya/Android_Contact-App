package com.example.contactapp.model;

import android.net.Uri;

public class ContactModel {
    public String name,number,email;
    public  Uri image;

    public ContactModel(String name, String number, Uri image,String email){
        this.name = name;
        this.number = number;
        this.image = image;
        this.email = email;
    }
}

package com.example.projetoapollo.activity.Util;

import com.google.firebase.auth.FirebaseAuth;

public class Configura {

    private static FirebaseAuth auth;

    public static FirebaseAuth Firebaseautenticacao(){
        if (auth ==null){
            auth =FirebaseAuth.getInstance();
        }
        return auth;
    }
}

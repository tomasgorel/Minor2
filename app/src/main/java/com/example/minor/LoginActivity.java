package com.example.minor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity { //class start

    @Override
    protected void onCreate(Bundle savedInstanceState) { //funckijos Start
        super.onCreate(savedInstanceState); // emtpy window sukurimas
        setContentView(R.layout.activity_login); //suteik tusciam languj si vaizda (kodas sync su vaizdu

        EditText username = findViewById(R.id.username); //siejamas elementas vaizde su kintamuoju kode aclogin
        EditText password = findViewById(R.id.password);
        Button login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // on click pradzia
                String usernameStr = username.getText().toString();
                String passwordStr = password.getText().toString();

                username.setError(null);    //issivalome klaidu zurnala (username)
                if (Validation.isUsernameValid(usernameStr) && Validation.isPasswordValid(passwordStr)){  //if zodziu prasideda salyga, jei validus duomenys,(is vieno lango i kita)
                    Toast.makeText(LoginActivity.this, getResources().getString(R.string.login_invalid_credentials), Toast.LENGTH_LONG).show();
                    Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class); // is kur (pirmas parametras) i kur (antras parametras); i new Intent() labai nesigilinti kol kas, taip tiesiog reikia. This reiskia, jog siame lange esu, gali buti net be zodziu LoginActivity. o class reiskia, jog i kuri eisime langa
                    startActivity(goToSearchActivity);
                }
                else {  //be skliausteliu () kiti "" salyga, todel skliausteliu nereikia
                    username.setError(getResources().getString(R.string.login_invalid_credentials));
                    username.requestFocus();

                }
            } // Onclick pabaiga
        }); //mygtuko paspaudimo funkcijos pabaiga

        //register mygtuko paspaudimas

    } //Funkcijos end
} //class end
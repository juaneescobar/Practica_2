package com.example.juanesteban.laboratorio_2;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LogginActivity extends AppCompatActivity {

    Button OnLogin, OnRegister;
    EditText UserName, Password;
    String username,password, user_regis,pass_regis, user_close,pass_close;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loggin);

        OnLogin = findViewById(R.id.OnLogin);
        OnRegister = findViewById(R.id.OnRegister);
        UserName = findViewById(R.id.UserName);
        Password = findViewById(R.id.Password);
        result = findViewById(R.id.Result);

        try {
            Bundle extras = getIntent().getExtras();

            user_regis = extras.getString("usuario");
            pass_regis = extras.getString("contraseña");
        }catch (Exception e){

        }




        OnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = UserName.getText().toString();
                password = Password.getText().toString();



                if (username.equals("") || password.equals("")){
                    Toast.makeText(getApplicationContext(), "Llene Todos Los Campos", Toast.LENGTH_SHORT).show();


                }else if(username.equals(user_regis) && password.equals(pass_regis)){

                    Intent intent =  new Intent(LogginActivity.this, Lab_2.class);

                    //finish();  #Matar appi
                    intent.putExtra("usuario", username);
                    intent.putExtra("contraseña", password);
                    UserName.setText("");
                    Password.setText("");
                    //startActivity(new Intent(LogginActivity.this, RegistroActivity.class));
                    startActivity(intent);

                }else{
                    Toast.makeText(getApplicationContext(), "usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();

                }
            }
        });

        OnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogginActivity.this,RegistroActivity.class);

                startActivityForResult(intent,1235);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode==1235 && resultCode == RESULT_OK){

            //Toast.makeText(this,"Solicitud Aprobada",Toast.LENGTH_SHORT).show();
            user_regis = data.getStringExtra("usuario");
            pass_regis = data.getStringExtra("contraseña");


        }else{
            if (requestCode==RESULT_CANCELED){
                //Toast.makeText(this,"Solicitud Cancelada",Toast.LENGTH_SHORT).show();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }









}

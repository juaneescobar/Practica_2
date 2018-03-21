package com.example.juanesteban.laboratorio_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    String correo,contraseña, con_contraseña;
    EditText Mail,pass, pass_1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Mail = findViewById(R.id.correo);
        pass = findViewById(R.id.contraseña);
        pass_1 = findViewById(R.id.con_contraseña);
    }


    public void Registro(View view) {

        correo = Mail.getText().toString();
        contraseña= pass.getText().toString();
        con_contraseña= pass_1.getText().toString();


        if(contraseña.equals(con_contraseña)){
            Intent intent = new Intent();

            intent.putExtra("usuario", correo);
            intent.putExtra("contraseña", contraseña);


            setResult(RESULT_OK, intent);
            finish();
            Toast.makeText(this, "Usuario Registrado Correctamente", Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, "Las contraseñas no son iguales", Toast.LENGTH_SHORT).show();
        }




    }
}

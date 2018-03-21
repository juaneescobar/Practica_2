package com.example.juanesteban.laboratorio_2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Lab_2 extends AppCompatActivity {


    String usuario,contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_2);
        Log.d("Metodo", "OnCreate");


        Bundle extras = getIntent().getExtras();

        usuario = extras.getString("usuario");
        contraseña = extras.getString("contraseña");



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.Perfil){
            Toast.makeText(this, "Profile Selected", Toast.LENGTH_SHORT).show();
            Intent intent =  new Intent(Lab_2.this, PerfilActivity.class);

            intent.putExtra("usuario", usuario);
            intent.putExtra("contraseña", contraseña);

            startActivityForResult(intent, 1234);

        }
        if (id==R.id.Close){
            Toast.makeText(this, "Closing Sesion", Toast.LENGTH_SHORT).show();

             finish();  //Matar appi

        }
        return super.onOptionsItemSelected(item);
    }



    public void onBackPressed() {
        //  super.onBackPressed();
        moveTaskToBack(true);

    }



    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Método","onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Método","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Método","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Método","onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Método","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Método","onDestroy");
    }



}

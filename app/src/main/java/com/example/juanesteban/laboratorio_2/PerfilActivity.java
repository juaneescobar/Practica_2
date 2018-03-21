package com.example.juanesteban.laboratorio_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PerfilActivity extends AppCompatActivity {

    String User, pass;
    TextView user, pass_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        user = findViewById(R.id.user);
        pass_1 = findViewById(R.id.contraseña);

        Bundle extras = getIntent().getExtras();

        User = extras.getString("usuario");
        pass = extras.getString("contraseña");


        user.setText(User);
        pass_1.setText(pass);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.Principal) {
            finish();
        }
        if (id == R.id.Close) {
            Intent intent =  new Intent(PerfilActivity.this,LogginActivity.class);
            intent.putExtra("usuario", User);
            intent.putExtra("contraseña", pass);

            startActivity(intent);
            finish();
        }

    return super.onOptionsItemSelected(item);
    }
}
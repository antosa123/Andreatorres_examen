package com.example.andrea.andreatorres_examen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Listas extends Activity {

    TextView titulo;
    String titol;
    Button volver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);

        titulo = (TextView) findViewById(R.id.titulo);
        Bundle b = getIntent().getExtras();
        //recojo parametros si los hay del activity principal
        if(b!=null){
            //compruebo el titulo para mostrar el que toca en cada activity
            if(titulo.equals("titulo")){
            titol = b.getString("titulo");
            titulo.setText(titol);}

            if(titulo.equals(("titulo2"))){
                titol = b.getString("titulo2");
                titulo.setText(titol);
            }
        }

        //boton para volver al activity principal
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = getIntent();
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_listas, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

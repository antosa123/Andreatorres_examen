package com.example.andrea.andreatorres_examen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class EntradaDatos extends Activity {

    EditText ponerConcepto;
    EditText textoPagador, textoImporte;
    Button enviar;
    Spinner spinnerCobrador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_datos);

        ponerConcepto = (EditText) findViewById(R.id.tv_ponerConcepto);
        textoPagador = (EditText) findViewById(R.id.eTextPagador);
        textoImporte = (EditText) findViewById(R.id.eTextImporte);
        enviar = (Button) findViewById(R.id.b_enviar);
        spinnerCobrador = (Spinner) findViewById(R.id.spinnerCobrador);

        //rellenar el spinner
        String[] cobrador = new String[]{"Cobrador1","Cobrador2","Cobrador3","Altres"};

        //adaptador para gestionar el spinner
        ArrayAdapter adaptador = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_item,cobrador);

        //que la lista salga hacia abajo
        adaptador.setDropDownViewResource(android.R.layout.simple_list_item_checked);

        //añadimos al spinner el adaptador
        spinnerCobrador.setAdapter(adaptador);



        //en el boton enviar datos volvemos al activity principal
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(comprobarDatos()) {
                    Intent i = getIntent();
                    //añado los datos para llevar al activity principal
                    i.putExtra("pagador", textoPagador.getText().toString());
                    i.putExtra("importe", textoImporte.getText().toString());
                    i.putExtra("cobrador", spinnerCobrador.getSelectedItem().toString());
                    i.putExtra("concepto", ponerConcepto.getText().toString());
                    setResult(RESULT_OK, i);
                    finish();
                }
            }
        });


    }

    /**
     * Comprobacion de que los datos se han rellenado
     * @return
     */
    public boolean comprobarDatos() {
        if (textoPagador.getText().length() <= 0) {
            Toast.makeText(getApplicationContext(), "Rellena el nombre del pagador", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            if (textoImporte.getText().length() <= 0) {
                Toast.makeText(getApplicationContext(), "Rellena el importe", Toast.LENGTH_SHORT).show();
                return false;
            } else {
                if (ponerConcepto.getText().length() <= 0) {
                    Toast.makeText(getApplicationContext(), "Rellena el concepto", Toast.LENGTH_SHORT).show();
                    return false;
                } else {
                    if (spinnerCobrador.getSelectedItem() == null) {
                        Toast.makeText(getApplicationContext(), "Elige un cobrador", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                }

            }

        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_entrada_datos, menu);
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

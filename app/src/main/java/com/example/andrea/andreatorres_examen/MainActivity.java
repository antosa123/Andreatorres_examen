package com.example.andrea.andreatorres_examen;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    Button cobros, pagos, listaCobros, listaPagos;
    ImageView imgCobro, imgPago, imgListCobro, imgListPago;
    final int SUBACTIVITY_1=1;
    final int SUBACTIVITY_2=2;
    final int SUBACTIVITY_3=3;
    final int SUBACTIVITY_4=4;
    String pagador, cobrador, importe, concepto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cobros = (Button) findViewById(R.id.b_cobro);
        pagos = (Button) findViewById(R.id.b_pagos);
        listaCobros = (Button) findViewById(R.id.b_listacobros);
        listaPagos = (Button) findViewById(R.id.b_listapagos);
        imgCobro = (ImageView) findViewById(R.id.img_cobros);
        imgPago = (ImageView) findViewById(R.id.img_pagos);
        imgListCobro = (ImageView) findViewById(R.id.img_listCobros);
        imgListPago = (ImageView) findViewById(R.id.img_listPagos);


        imgCobro.setImageResource(R.drawable.cash);
        imgPago.setImageResource(R.drawable.invoicecolor);
        imgListCobro.setImageResource(R.drawable.list);
        imgListPago.setImageResource(R.drawable.list);

        //creamos los arrayList para guardar los datos de los cobros y pagos
        ArrayList<String> datosCobro = new ArrayList<String>();
        ArrayList<String> datosPago = new ArrayList<String>();


        enviarCobros();
        enviarPagos();
        enviarlistaCobros();
        enviarlistaPagos();

    }

    /**
     * Boton que te envia al subactivity_2
     */
    public void enviarPagos(){
        pagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creo un intent para pasar el subactivity
                Intent i = new Intent(getApplicationContext(),EntradaDatos.class);
                startActivityForResult(i,2);
            }
        });
    }

    /**
     * Boton que te envia al subactivity_1
     */
    public void enviarCobros(){
        cobros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //creo un intent para pasar al subactivity
                Intent i = new Intent(getApplicationContext(), EntradaDatos.class);
                startActivityForResult(i, 1);
            }
        });
    }

    /**
     * Boton que te envia al subactivity_3
     */
    public void enviarlistaCobros(){
        listaCobros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Listas.class);
                String listaCobros= "Lista de cobros";
                i.putExtra("titulo",listaCobros);
                startActivityForResult(i, 3);
            }
        });
    }

    /**
     * Boton que te envia al subactivity_4
     */
    public void enviarlistaPagos(){
        listaPagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Listas.class);
                String listaCobros= "Lista de pagos";
                i.putExtra("titulo2",listaCobros);
                startActivityForResult(i,4);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case SUBACTIVITY_1:
                gestionarCobros(resultCode, data);
                break;
            case SUBACTIVITY_2:
                gestionarPagos(resultCode, data);
                break;
            case SUBACTIVITY_3:
                gestionarListaCobro(resultCode,data);

            case SUBACTIVITY_4:
                gestionarListaPago(resultCode, data);
                break;
        }

    }

    /**
     * Metodo que gestiona los datos del subactivity_1
     * @param resultCode
     * @param data
     */
    public void gestionarCobros(int resultCode,Intent data){
        if(RESULT_OK==resultCode){
            Bundle b = data.getExtras();
            pagador = b.getString("pagador");
            cobrador = b.getString("cobrador");
            importe = b.getString("importe");
            concepto = b.getString("concepto");

            //creo la notificacion para mostrar los datos

            Notification.Builder mBuilder = new Notification.Builder(getApplicationContext());
            mBuilder.setSmallIcon(R.mipmap.ic_launcher);
            mBuilder.setContentTitle("Se ha realizado el COBRO");
            mBuilder.setContentText("Datos enviados");
            mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.mark));

            //Notificación expandida
            Notification.InboxStyle is = new Notification.InboxStyle();
            //Añadimos lineas a la notificación expandida
            is.addLine(pagador+" es el pagador");
            is.addLine(cobrador+" es el cobrador");
            is.addLine("Importe: "+importe);
            is.addLine("Concepto: "+concepto);
            mBuilder.setStyle(is);
        }
    }

    /**
     * Metodo que gestiona los datos del subactivity_2
     * @param resultCode
     * @param data
     */
    public void gestionarPagos(int resultCode,Intent data){
        if(RESULT_OK==resultCode){
            Bundle b = data.getExtras();
            pagador = b.getString("pagador");
            cobrador = b.getString("cobrador");
            importe = b.getString("importe");
            concepto = b.getString("concepto");

            //creo la notificacion para mostrar los datos

            Notification.Builder mBuilder = new Notification.Builder(getApplicationContext());
            mBuilder.setSmallIcon(R.mipmap.ic_launcher);
            mBuilder.setContentTitle("Se ha realizado el PAGO");
            mBuilder.setContentText("Datos enviados");
            mBuilder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.mark));

            //Notificación expandida
            Notification.InboxStyle is = new Notification.InboxStyle();
            //Añadimos lineas a la notificación expandida
            is.addLine(pagador+" es el pagador");
            is.addLine(cobrador+" es el cobrador");
            is.addLine("Importe: "+importe);
            is.addLine("Concepto: "+concepto);
            mBuilder.setStyle(is);
        }
    }

    /**
     * Metodo que gestiona los datos del subactivity_3
     * @param resultCode
     * @param data
     */
    public void gestionarListaCobro(int resultCode,Intent data){
        if(RESULT_OK==resultCode){

        }
    }

    /**
     * Metodo que gestiona los datos del subactivity_4
     * @param resultCode
     * @param data
     */
    public void gestionarListaPago(int resultCode,Intent data){
        if(RESULT_OK==resultCode){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

package com.example.tnb_20.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecordsAvtivity extends Activity {

    private List<Player> players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        try{
            BufferedReader fin = new BufferedReader(new InputStreamReader(openFileInput("playersfinal.txt")));

            String texto;
            while((texto = fin.readLine())!=null){
                String[] cadena = texto.split(",");
                players.add(new Player(cadena[0],Integer.parseInt(cadena[1])));
            }
            fin.close();
        }catch (Exception ex) {
            ex.printStackTrace();
        }


        final TextView tablaRecord = findViewById(R.id.record);
        tablaRecord.setText("");
        if(players.size()>0){
            Collections.sort(players);
            for (Player jug:players) {
                tablaRecord.setText(tablaRecord.getText() + jug.toString());
            }
        }else{
            tablaRecord.setText(tablaRecord.getText() + "No hay datos registrados");
        }
    }


}

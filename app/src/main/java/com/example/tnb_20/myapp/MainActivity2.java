package com.example.tnb_20.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    public class Record{
        public int intentos;
        public String nombre;

        public Record(int intentos, String nombre){
            this.intentos=intentos;
            this.nombre=nombre;
        }
    }

    ArrayList<Record> records= new ArrayList<Record>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        records.add(new Record(33,"Alicia"));

    }

}

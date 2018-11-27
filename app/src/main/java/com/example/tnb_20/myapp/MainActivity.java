package com.example.tnb_20.myapp;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    protected Random r;
    protected int numAle;
    protected int cont=0;
    protected int intentos=0;
    protected  String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();
        numAle = (int) (Math.random()* 100) + 1;

        final EditText num = findViewById(R.id.num);


        final Button button = findViewById(R.id.Endevina);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!num.getText().toString().equals("")) {
                    if (numAle < Integer.parseInt(num.getText().toString())) {
                        Context context = getApplicationContext();
                        CharSequence text = "Numero es mas pequeño";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        num.setText("");
                    } else if (numAle > Integer.parseInt(num.getText().toString())) {
                        Context context = getApplicationContext();
                        CharSequence text = "Numero es mas grande";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        num.setText("");
                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "Numero acertado";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();

                        final Dialog dialog = new Dialog(MainActivity.this);
                        dialog.setContentView(R.layout.dialog_layout);
                        dialog.setTitle("Title");

                        Button button = (Button) dialog.findViewById(R.id.guardar);
                        button.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                                EditText edit = (EditText) dialog.findViewById(R.id.nombre);
                                String text = edit.getText().toString();



                                dialog.dismiss();
                                name = text;
                            }
                        });
                        dialog.show();
                    }
                }
            }
        });


        final Button button2 = findViewById(R.id.TablaRecord);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setContentView(R.layout.activity_record);
            }
        });
    }


}

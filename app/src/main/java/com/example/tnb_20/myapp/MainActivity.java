package com.example.tnb_20.myapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    protected Random r;
    protected int numAle;
    //protected int cont=0;
    protected int intentos=0;
    protected  String name;
    //private int rango;
    public static List<Player> player = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para empezar preguntamos por el nombre del usuario para poder guardarlo luego en la tabla records
        NomPlayer();

        //Aqui estan las condiciones sobre el acierto del numero aleatorio entre el 1 y 100
        r = new Random();
        numAle = (int) (Math.random()* 100) + 1;

        final EditText num = findViewById(R.id.num);

        final Button button = findViewById(R.id.Endevina);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (!num.getText().toString().equals("")) {
                    if (numAle < Integer.parseInt(num.getText().toString())) {
                        //se suma el intento
                        intentos++;
                        Context context = getApplicationContext();
                        CharSequence text = "Numero es mas pequeño";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        num.setText("");
                    } else if (numAle > Integer.parseInt(num.getText().toString())) {
                        //se suma el intento
                        intentos++;
                        Context context = getApplicationContext();
                        CharSequence text = "Numero es mas grande";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        num.setText("");
                    } else {
                        player.add(new Player(name,intentos));
                        Player player1= new Player(name,intentos);
                        nomFile(player1);
                        Context context = getApplicationContext();
                        CharSequence text = "Numero acertado";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        //restaurando todos los valores para el siguiente jugador
                        intentos = 0;
                        //generamos otro numero aleatorio para el siguiente jugador
                        numAle = (int) (Math.random()* 100) + 1;
                        intentos = 0;
                        NomPlayer();


                        /*final Dialog dialog = new Dialog(MainActivity.this);
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
                        dialog.show();*/
                    }
                }
            }
        });


        final Button button2 = findViewById(R.id.TablaRecord);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
               tablaRecord();
            }
        });
    }

    //metodo para preguntar el nombre del jugador
    private String NomPlayer(){
        final Dialog dialog = new Dialog(MainActivity.this);

        dialog.setContentView(R.layout.dialog_layout);
        dialog.setTitle("Escriba su nombre");
        dialog.show();
        Button register = dialog.findViewById(R.id.guardar);
        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText textName = dialog.findViewById(R.id.nombre);
                name = textName.getText().toString();
                dialog.dismiss();
            }
        });

        return name;
    }
    private void tablaRecord(){
        Intent i = new Intent(this, RecordsAvtivity.class);
        startActivity(i);
    }
    //metodo para escribir el nombre del fichero
    private void nomFile(Player p){
        try {
            OutputStreamWriter fout = new OutputStreamWriter(openFileOutput("playersfinal.txt",Context.MODE_APPEND));

            fout.write(p.getName() + "," + p.getIntents());
            fout.append("\r\n");
            fout.close();

        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
}

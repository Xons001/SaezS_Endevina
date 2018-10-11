package com.example.tnb_20.myapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    protected Random r;
    protected int numAle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();
        numAle = r.nextInt(100 + 1);



        final Button button = findViewById(R.id.Endevina);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int cont=0;
                    if (numAle == R.id.num) {
                        Context context = getApplicationContext();
                        CharSequence text = "Numero acertado";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    } else {
                        Context context = getApplicationContext();
                        CharSequence text = "Numero no acertado";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        cont++;
                    }
            }
        });
    }
}
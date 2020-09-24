package com.example.tresenlinea;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iniciamos el array casillas que identifica cada casilla y la almacena

        casillas = new int[9];
        casillas[0]=R.id.a1;
        casillas[1]=R.id.a2;
        casillas[2]=R.id.a3;
        casillas[3]=R.id.b1;
        casillas[4]=R.id.b2;
        casillas[5]=R.id.b3;
        casillas[6]=R.id.c1;
        casillas[7]=R.id.c2;
        casillas[8]=R.id.c3;

    }

    public void aJugar (View vista){

        //Reseteo el tablero
        ImageView imagen;

        for (int cadaCasilla:casillas){
            imagen=(ImageView) findViewById((cadaCasilla));
            imagen.setImageResource(R.drawable.casilla);
        }

        //Establecer 1 o 2 jugadores
        jugadores=1;

        if(vista.getId()==R.id.dosjug){
            jugadores=2;
        }

        // Establezco Dificultad

        RadioGroup configDificultad =(RadioGroup) findViewById(R.id.configD);

        int id = configDificultad.getCheckedRadioButtonId();
        int dificultad = 0;

        if(id==R.id.normal){
            dificultad=1;
        }else if(id==R.id.imposible){
            dificultad=2;
        }

        //Inhabilitar los botones y empiezo la partida

        partida = new Partida(dificultad);
        ((Button) findViewById(R.id.unjug)).setEnabled(false);
        ((Button) findViewById(R.id.dosjug)).setEnabled(false);

        ((RadioGroup) findViewById(R.id.configD)).setAlpha(0);





    }


    private int jugadores;
    private int[] casillas;
    private Partida partida;
}
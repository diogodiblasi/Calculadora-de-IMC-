package com.example.calculadoradeimc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    TextView resultado;
    String resNome;
    Float resAltura, resPeso, resResultado;

    private ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imageView2 = (ImageView) findViewById((R.id.imageView2));
        resultado = (TextView) findViewById(R.id.textViewResultado);

        Intent intent = getIntent();
        resNome = intent.getStringExtra("nome");
        resAltura = Float.parseFloat(intent.getStringExtra("altura"));
        resPeso = Float.parseFloat(intent.getStringExtra("peso"));
        resResultado = resPeso / (resAltura * resAltura);

        String result = "Nome: " + resNome + "\n" + "IMC: ";
        result = result + resResultado.toString();

        if(resResultado < 17){
            result = result + " \n" + "Classificação: Muito abaixo do peso"; imageView2.setImageResource(R.drawable.abaixo);
        }
        else if (resResultado < 18.49){
            result = result + " \n" + "Classificação: Abaixo do peso"; imageView2.setImageResource(R.drawable.abaixo2);
        }
        else if(resResultado < 24.99 ) {
            result = result + " \n" + "Classificação: Peso normal"; imageView2.setImageResource(R.drawable.normal);
        }
        else if(resResultado < 29.99){
            result = result + " \n" + "Classificação: Acima do peso"; imageView2.setImageResource(R.drawable.acima);
        }
        else if(resResultado < 34.99){
            result = result + " \n" + "Classificação: Obesidade I"; imageView2.setImageResource(R.drawable.obesidade);
        }
        else if(resResultado < 39.99){
            result = result + " \n" + "Classificação: Obesidade II"; imageView2.setImageResource(R.drawable.obesidadegrave);
        }
        else{
            result = result + " \n" + "Classificação: Obesidade Mórbida"; imageView2.setImageResource(R.drawable.morbida);
        }
        resultado.setText(result);
    }
}
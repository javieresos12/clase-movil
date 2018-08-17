package com.example.android.calculadora;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    //declararo las variables con las que voy a trabajar
   private EditText n1, n2;
   private TextView res;
   private Resources recursos;
   private Spinner operaciones;
   private String op[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //capturo los obejtos que estan en el layout principal
        n1 = findViewById(R.id.txtnumero1);
        n2= findViewById(R.id.txtnumero2);
        res= findViewById(R.id.txtResultado);
        operaciones = findViewById(R.id.cmbOpciones);
        //guardo las refencias de los recursos de la aplicacion
        recursos= this.getResources();

        //capturo el array de las opciones
        op= recursos.getStringArray(R.array.opciones);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,op);
        operaciones.setAdapter(adapter);


    }


    public void calcular (View v){
        int opcion;
        double num1, num2, res2=0, resultado=0;
        opcion = operaciones.getSelectedItemPosition();
        num1= Double.parseDouble(n1.getText().toString());
        num2=Double.parseDouble(n2.getText().toString());
        switch (opcion){
            case 0:
                resultado = Metodos.sumar(num1, num2);
                break;

            case 1:
                resultado = Metodos.restar(num1, num2);
                break;
            case 2:
                resultado = Metodos.multiplicar(num1, num2);

                break;
            case 3:
                resultado= Metodos.division(num1, num2);
                break;


        }

        res.setText(""+String.format("%.2f",resultado));

    }

    public void limpiar (View v){
        n1.setText("");
        n2.setText("");
        operaciones.setSelection(0);
        n1.requestFocus();

    }





}

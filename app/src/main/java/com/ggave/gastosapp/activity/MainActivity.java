package com.ggave.gastosapp.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ggave.gastosapp.R;
import com.ggave.gastosapp.models.Operation;
import com.ggave.gastosapp.repositories.OperationsRepositoy;

import static com.ggave.gastosapp.repositories.OperationsRepositoy.total;

public class MainActivity extends AppCompatActivity {

    TextView montoAhorro;
    TextView montoCredito;
    TextView montoEfectivo;

    double preciototal=0;

    FloatingActionButton add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        montoAhorro = findViewById(R.id.montoAhorro_text);
        montoCredito = findViewById(R.id.montoCredito_text);
        montoEfectivo = findViewById(R.id.montoEfectivo_text);

        double totalAhorro = OperationsRepositoy.total("Ahorro");
        double totalCredito = OperationsRepositoy.total("Tarjeta de credito");
        double totalEfectivo = OperationsRepositoy.total("Efectivo");

        montoEfectivo.setText(String.valueOf(totalEfectivo));
        montoAhorro.setText(String.valueOf(totalAhorro));
        montoCredito.setText(String.valueOf(totalCredito));

        add = findViewById(R.id.agregar);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_register();
            }
        });

    }

    public void call_register(){
        Intent intent = new Intent(this, NewOperationActivity.class);
        startActivity(intent);
    }
}

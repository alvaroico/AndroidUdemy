package com.example.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private  ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.test_Dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_Euro);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_Calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();


    }

    @Override
    public void onClick(@NotNull View view) {
        if(view.getId() == R.id.button_Calculate ){
            String values = this.mViewHolder.editValue.getText().toString();
            if("".equals(values)){
                // mostra uma mensagem para preencher
                Toast.makeText(this, this.getString(R.string.informe_valor), Toast.LENGTH_LONG).show();
            }else {
                Double real = Double.valueOf(values);
                this.mViewHolder.textDolar.setText(String.format("%.2f", (real / 4 )));
                this.mViewHolder.textEuro.setText(String.format("%.2f", (real / 5 )));
            }
        }
    }

    private  void  clearValues() {
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");

    }

    private static class ViewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        Button buttonCalculate;
    }
}
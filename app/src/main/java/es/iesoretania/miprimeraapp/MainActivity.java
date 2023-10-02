package es.iesoretania.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Toast;

import es.iesoretania.miprimeraapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.botonSumar.setOnClickListener(this);
        binding.botonSegundoActivity.setOnClickListener(this);

        binding.textResultado.setText("Resultado");
    }

    @Override
    public void onClick(View view) {
        
        int id = view.getId();
        
        if (id == R.id.botonSumar){
            String valor1 = binding.editPrimerNumero.getText().toString();
            String valor2 = binding.editSegundoNumero.getText().toString();

            int num1 = Integer.parseInt(valor1);
            int num2 = Integer.parseInt(valor2);

            int suma = num1 + num2;

            String result = String.valueOf(suma);

            binding.textResultado.setText(result);
        } else if (id == R.id.botonSegundoActivity) {
            Intent intent = new Intent(this, SegundoActivity.class);
            intent.putExtra("texto","Este es el texto enviado");
            startActivity(intent);
        }
    }
}
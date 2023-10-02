package es.iesoretania.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;

import es.iesoretania.miprimeraapp.databinding.ActivityMainBinding;
import es.iesoretania.miprimeraapp.databinding.ActivitySegundoBinding;

public class SegundoActivity extends AppCompatActivity {
    private ActivitySegundoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySegundoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Bundle datos = getIntent().getExtras();
        String mensaje = datos.getString("texto");

        binding.textViewSegundaActivity.setText(mensaje);
    }

    public void alarma(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "Despierta")
                .putExtra(AlarmClock.EXTRA_HOUR, 7)
                .putExtra(AlarmClock.EXTRA_MINUTES,10);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }
}
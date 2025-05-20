package com.example.psicoapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.CalendarDay;

public class MainActivity extends AppCompatActivity {

    MaterialCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("PsicoApp");
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setLogo(R.mipmap.ic_launcher); // ou outro ícone
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

        calendarView = findViewById(R.id.calendarView);

        // Exemplo de data selecionada
        calendarView.setOnDateChangedListener((widget, date, selected) -> {
            Toast.makeText(this, "Selecionado: " + date.getDate(), Toast.LENGTH_SHORT).show();
        });

        Button btnPaciente = findViewById(R.id.btnAbrirPaciente);
        btnPaciente.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PacienteActivity.class);
            startActivity(intent);
        });
    }
}

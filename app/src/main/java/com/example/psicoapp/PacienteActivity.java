package com.example.psicoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PacienteActivity extends AppCompatActivity {

    EditText editNome, editNascimento, editTelefone, editObservacoes;
    Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        // Configuração da Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("PsicoApp");
            getSupportActionBar().setLogo(R.mipmap.ic_launcher);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

        // Referência dos campos
        editNome = findViewById(R.id.edtNome);
        editNascimento = findViewById(R.id.edtNascimento);
        editTelefone = findViewById(R.id.edtTelefone);
        editObservacoes = findViewById(R.id.edtObservacoes);
        btnSalvar = findViewById(R.id.btnSalvar);

        // Ação do botão salvar
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editNome.getText().toString();
                String nascimento = editNascimento.getText().toString();
                String telefone = editTelefone.getText().toString();
                String observacoes = editObservacoes.getText().toString();

                Toast.makeText(PacienteActivity.this,
                        "Paciente salvo: " + nome,
                        Toast.LENGTH_SHORT).show();

                finish(); // Fecha a tela
            }
        });
    }
    // Método da seta de voltar
    @Override
    public boolean onSupportNavigateUp() {
        finish(); // go back to MainActivity
        return true;
    }
}

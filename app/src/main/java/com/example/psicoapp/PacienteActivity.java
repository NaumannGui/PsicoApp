package com.example.psicoapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.room.Room;

public class PacienteActivity extends AppCompatActivity {

    EditText editNome, editTelefone, editEmail, editNascimento, editEndereco, editObservacoes;
    Button btnSalvar;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        // Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("PsicoApp");
            getSupportActionBar().setLogo(R.mipmap.ic_launcher);
            getSupportActionBar().setDisplayUseLogoEnabled(true);
        }

        // Initialize views
        editNome = findViewById(R.id.edtNome);
        editTelefone = findViewById(R.id.edtTelefone);
        editEmail = findViewById(R.id.edtEmail);
        editNascimento = findViewById(R.id.edtNascimento);
        editEndereco = findViewById(R.id.edtEndereco);
        editObservacoes = findViewById(R.id.edtObservacoes);
        btnSalvar = findViewById(R.id.btnSalvar);

        // --- CONTROLE DE MODO NOVO/EDIÇÃO ---
        LinearLayout layoutCadastro = findViewById(R.id.layoutCadastro);
        LinearLayout layoutEdicao = findViewById(R.id.layoutEdicao);
        String modo = getIntent().getStringExtra("modo");

        if ("novo".equals(modo)) {
            layoutCadastro.setVisibility(View.VISIBLE);
            layoutEdicao.setVisibility(View.GONE);
        } else if ("editar".equals(modo)) {
            layoutCadastro.setVisibility(View.GONE);
            layoutEdicao.setVisibility(View.VISIBLE);

            int pacienteId = getIntent().getIntExtra("pacienteId", -1);
            carregarDadosPaciente(pacienteId); // Você pode implementar essa função depois
        }

        // Initialize database
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "paciente-db").build();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get values
                String nome = editNome.getText().toString();
                String telefoneOriginal = editTelefone.getText().toString();
                String telefone = normalizarTelefone(telefoneOriginal);
                String email = editEmail.getText().toString();
                String nascimento = editNascimento.getText().toString();
                String endereco = editEndereco.getText().toString();
                String observacoes = editObservacoes.getText().toString();

                // Operação em Thread separada
                new Thread(() -> {
                    Paciente existente = db.pacienteDao().buscarPorTelefone(telefone);

                    if (existente != null) {
                        runOnUiThread(() ->
                                Toast.makeText(PacienteActivity.this,
                                        "Paciente já cadastrado com esse telefone.",
                                        Toast.LENGTH_SHORT).show());
                    } else {
                        Paciente paciente = new Paciente();
                        paciente.nome = nome;
                        paciente.telefone = telefone;
                        paciente.email = email;
                        paciente.nascimento = nascimento;
                        paciente.endereco = endereco;
                        paciente.observacoes = observacoes;

                        db.pacienteDao().insert(paciente);

                        runOnUiThread(() -> {
                            Toast.makeText(PacienteActivity.this,
                                    "Paciente salvo: " + nome,
                                    Toast.LENGTH_SHORT).show();
                            finish(); // Fecha activity
                        });
                    }
                }).start();
            }
        });
    }

    // Métoodo para limpar o telefone (deixa só os números)
    private String normalizarTelefone(String telefone) {
        return telefone.replaceAll("[^\\d]", "");
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}

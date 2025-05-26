package com.example.psicoapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Paciente {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nome;
    public String telefone;
    public String email;
    public String nascimento;
    public String endereco;
    public String observacoes;
}

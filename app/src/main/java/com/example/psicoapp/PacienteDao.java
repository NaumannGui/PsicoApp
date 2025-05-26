package com.example.psicoapp;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PacienteDao {
    @Insert
    void insert(Paciente paciente);

    @Query("SELECT * FROM Paciente")
    List<Paciente> getAll();

    @Query("SELECT * FROM paciente WHERE telefone = :telefone")
    Paciente buscarPorTelefone(String telefone);

}

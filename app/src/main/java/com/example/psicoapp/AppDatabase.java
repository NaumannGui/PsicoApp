package com.example.psicoapp;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Paciente.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PacienteDao pacienteDao();
}

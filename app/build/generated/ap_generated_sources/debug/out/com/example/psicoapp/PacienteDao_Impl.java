package com.example.psicoapp;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PacienteDao_Impl implements PacienteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Paciente> __insertionAdapterOfPaciente;

  public PacienteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPaciente = new EntityInsertionAdapter<Paciente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `Paciente` (`id`,`nome`,`telefone`,`email`,`nascimento`,`endereco`,`observacoes`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Paciente entity) {
        statement.bindLong(1, entity.id);
        if (entity.nome == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.nome);
        }
        if (entity.telefone == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.telefone);
        }
        if (entity.email == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.email);
        }
        if (entity.nascimento == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.nascimento);
        }
        if (entity.endereco == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.endereco);
        }
        if (entity.observacoes == null) {
          statement.bindNull(7);
        } else {
          statement.bindString(7, entity.observacoes);
        }
      }
    };
  }

  @Override
  public void insert(final Paciente paciente) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPaciente.insert(paciente);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Paciente> getAll() {
    final String _sql = "SELECT * FROM Paciente";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNome = CursorUtil.getColumnIndexOrThrow(_cursor, "nome");
      final int _cursorIndexOfTelefone = CursorUtil.getColumnIndexOrThrow(_cursor, "telefone");
      final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
      final int _cursorIndexOfNascimento = CursorUtil.getColumnIndexOrThrow(_cursor, "nascimento");
      final int _cursorIndexOfEndereco = CursorUtil.getColumnIndexOrThrow(_cursor, "endereco");
      final int _cursorIndexOfObservacoes = CursorUtil.getColumnIndexOrThrow(_cursor, "observacoes");
      final List<Paciente> _result = new ArrayList<Paciente>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Paciente _item;
        _item = new Paciente();
        _item.id = _cursor.getInt(_cursorIndexOfId);
        if (_cursor.isNull(_cursorIndexOfNome)) {
          _item.nome = null;
        } else {
          _item.nome = _cursor.getString(_cursorIndexOfNome);
        }
        if (_cursor.isNull(_cursorIndexOfTelefone)) {
          _item.telefone = null;
        } else {
          _item.telefone = _cursor.getString(_cursorIndexOfTelefone);
        }
        if (_cursor.isNull(_cursorIndexOfEmail)) {
          _item.email = null;
        } else {
          _item.email = _cursor.getString(_cursorIndexOfEmail);
        }
        if (_cursor.isNull(_cursorIndexOfNascimento)) {
          _item.nascimento = null;
        } else {
          _item.nascimento = _cursor.getString(_cursorIndexOfNascimento);
        }
        if (_cursor.isNull(_cursorIndexOfEndereco)) {
          _item.endereco = null;
        } else {
          _item.endereco = _cursor.getString(_cursorIndexOfEndereco);
        }
        if (_cursor.isNull(_cursorIndexOfObservacoes)) {
          _item.observacoes = null;
        } else {
          _item.observacoes = _cursor.getString(_cursorIndexOfObservacoes);
        }
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}

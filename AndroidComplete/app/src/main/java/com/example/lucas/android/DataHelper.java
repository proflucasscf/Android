package com.example.lucas.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class DataHelper {

    // Atributos
    private static final String DATABASE_NAME = "DB_ANDROID.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "TB_USERS";
    private Context context;
    private SQLiteDatabase db;
    private SQLiteStatement insertStmt;
    private static final String INSERT = "INSERT INTO " + TABLE_NAME + "(nom_usr) VALUES (?)";

    // Construtor da classe
    public DataHelper (Context context)
    {
        this.context = context;
        OpenHelper openHelper = new OpenHelper(this.context);
        this.db = openHelper.getWritableDatabase();
        this.insertStmt = this.db.compileStatement(INSERT);
    }

    // Método de Insert no Banco de dados
    public long Insert(String name)
    {
        this.insertStmt.bindString(1, name);
        return this.insertStmt.executeInsert();
    }

    // Método para exclusão de todos os registros
    public void DeleteAll()
    {
        this.db.delete(TABLE_NAME, null, null);
    }

    public void Delete(long id)
    {
        this.db.delete(TABLE_NAME, "cod_usr = ?", new String[] { String.valueOf(id) });
    }

    public void Update(ContentValues value, long id)
    {
        //value.put("coluna1","Bob"); // Nome da coluna / valor
        //value.put("coluna2","19"); // Nome da coluna / valor
        //value.put("coluna3","Male"); // Nome da coluna / valor

        this.db.update(TABLE_NAME, value, "cod_usr=" + id, null);
    }

    // Retorna lista com todos os itens cadastrados no banco de dados
    public List<String> SelectAll()
    {
        List<String> list = new ArrayList<String>();

        Cursor cursor = this.db.query(TABLE_NAME, new String[]{"cod_usr", "nom_usr"}, null, null, null, null, "cod_usr");

        if (cursor.moveToFirst()) {
            do {
                list.add(cursor.getString(0) +" - " + cursor.getString(1));
            } while (cursor.moveToNext());
        }

        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }

        return list;
    }

    // Classe responsável pelo gerenciamento e criação do banco de dados
    private static class OpenHelper extends SQLiteOpenHelper
    {
        OpenHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME + "(cod_usr INTEGER PRIMARY KEY, nom_usr TEXT)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w("Example", "Upgrading database, this will drop tables and recreate.");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}
package br.com.nonilton.minhalista.Banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nonilton Alves on 01/10/2015.
 */
public class Banco extends SQLiteOpenHelper {

    public Banco(Context context){
        super(context, "minhaLista", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table produto (id integer not null primary key autoincrement, nome text); ");
        db.execSQL(" create table lista (id integer not null primary key autoincrement, nome text); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public SQLiteDatabase AbreBanco (){
        return this.getWritableDatabase();
    }
}

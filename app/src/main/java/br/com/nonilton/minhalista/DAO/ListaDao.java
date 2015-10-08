package br.com.nonilton.minhalista.DAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import br.com.nonilton.minhalista.activitys.Lista;

/**
 * Created by Nonilton Alves on 01/10/2015.
 */
public class ListaDao {
    private SQLiteDatabase bd;
    private ContentValues cv;

    private void preencher(br.com.nonilton.minhalista.Entidades.Lista lista){
        this.cv.put("id", lista.getId());
        this.cv.put("nome", lista.getNome());
    }

    public ListaDao(SQLiteDatabase db){
        this.bd = db;
        this.cv = new ContentValues();
    }

    public long novo(br.com.nonilton.minhalista.Entidades.Lista lista){
        preencher(lista);
        return this.bd.insert("lista", null, this.cv);
    }

    public int editar(br.com.nonilton.minhalista.Entidades.Lista lista){
        preencher(lista);
        return this.bd.update("lista", this.cv, "id=?", new String[]{String.valueOf(lista.getId())});
    }

    public int excluir(br.com.nonilton.minhalista.Entidades.Lista lista){
        return this.bd.delete("lista","id=?",new String[]{String.valueOf(lista.getId())} );
    }
}

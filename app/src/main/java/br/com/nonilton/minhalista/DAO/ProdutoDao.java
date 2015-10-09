package br.com.nonilton.minhalista.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.nonilton.minhalista.Entidades.Produto;

/**
 * Created by Nonilton Alves on 01/10/2015.
 */
public class ProdutoDao {
    private SQLiteDatabase bd;
    private ContentValues cv;

    private void preencher(Produto produto){
        //this.cv.put("id", produto.getId());
        this.cv.put("nome", produto.getNome());
    }

    public ProdutoDao(SQLiteDatabase db){
        this.bd = db;
        this.cv = new ContentValues();
    }

    public long novo(Produto produto){
        preencher(produto);
        return this.bd.insert("produto", null, this.cv);
    }

    public int editar(Produto produto){
        preencher(produto);
        return this.bd.update("produto", this.cv, "id=?", new String[]{String.valueOf(produto.getId())});
    }

    public int excluir(Produto produto){
        return this.bd.delete("produto", "id=?", new String[]{String.valueOf(produto.getId())});
    }

    public List<Produto> getLista(){
        List<Produto> lista = new ArrayList<>();
        Cursor c = this.bd.rawQuery("select * from produto", null);
        while (c.moveToNext()){
            Produto p = new Produto(c.getLong(0), c.getString(1));
            lista.add(p);
        }
        c.close();
        return lista;
    }
}

package br.com.nonilton.minhalista.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import br.com.nonilton.minhalista.Adapters.ProdutoAdapter;
import br.com.nonilton.minhalista.Banco.Banco;
import br.com.nonilton.minhalista.DAO.ProdutoDao;
import br.com.nonilton.minhalista.R;

public class Produtos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);
        ProdutoDao produtoDao = new ProdutoDao(new Banco(this).AbreBanco());

        ListView listView = (ListView) findViewById(R.id.lista_produtos);
        listView.setAdapter(new ProdutoAdapter(this, produtoDao.getLista()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_produtos, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package br.com.nonilton.minhalista.activitys;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import br.com.nonilton.minhalista.Adapters.ProdutoAdapter;
import br.com.nonilton.minhalista.Banco.Banco;
import br.com.nonilton.minhalista.DAO.ProdutoDao;
import br.com.nonilton.minhalista.Entidades.Produto;
import br.com.nonilton.minhalista.R;

public class Produtos extends AppCompatActivity {
    private ListView listView;
    private ProdutoDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);
        this.dao = new ProdutoDao(new Banco(this).AbreBanco());
        this.listView = (ListView) findViewById(R.id.lista_produtos);

        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                final Dialog dialog = new Dialog(getBaseContext());
                final ProdutoDao pdao = new ProdutoDao(new Banco(getBaseContext()).AbreBanco());

                dialog.setContentView(R.layout.excluir_alterar);

                Button btalterar = (Button) dialog.findViewById(R.id.btAlterar);
                Button btexcluir = (Button) dialog.findViewById(R.id.btExcluir);

                btalterar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        pdao.excluir(pdao.getLista().get(position));
                        loadListView();
                    }
                });


                btexcluir.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                dialog.show();
            }
        });

        loadListView();
    }

    private void loadListView(){
        listView.setAdapter(new ProdutoAdapter(this, this.dao.getLista()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_produtos, menu);
        return true;
    }

    public void cadastrar(View v){
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.cadastro_produto);
        dialog.setTitle(R.string.titulo_dialogo_cad_produto);

        Button btCancelar = (Button) dialog.findViewById(R.id.btCancelar);
        Button btConfirmar = (Button) dialog.findViewById(R.id.btConfirmar);

        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nome = (EditText) dialog.findViewById(R.id.edtNomeProduto);
                ProdutoDao dao = new ProdutoDao(new Banco(getBaseContext()).AbreBanco());

                if (nome.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "Por favor informe o nome do produto.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (nome.getText().toString().length() < 3){
                    Toast.makeText(getBaseContext(), "Minimo de 3 caracteres.", Toast.LENGTH_SHORT).show();
                    return;
                }

                dao.novo(new Produto(nome.getText().toString()));
                loadListView();
                dialog.dismiss();
            }
        });

        dialog.show();
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

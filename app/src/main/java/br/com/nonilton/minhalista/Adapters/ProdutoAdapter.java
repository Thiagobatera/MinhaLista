package br.com.nonilton.minhalista.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.nonilton.minhalista.Entidades.Produto;
import br.com.nonilton.minhalista.R;

/**
 * Created by Nonilton Alves on 05/10/2015.
 */
public class ProdutoAdapter extends BaseAdapter {
    private Context contexto;
    private List<Produto> listaProduto;

    public ProdutoAdapter(Context context, List<Produto> lista) {
        this.contexto = context;
        this.listaProduto = lista;
    }

    @Override
    public int getCount() {
        return this.listaProduto.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listaProduto.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.listaProduto.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Produto p = (Produto) this.getItem(position);

        LayoutInflater inflater = (LayoutInflater) this.contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.lista_produtos, null);

        TextView nome = (TextView) view.findViewById(R.id.txtProduto);
        nome.setText(p.getNome());
        return view;
    }
}

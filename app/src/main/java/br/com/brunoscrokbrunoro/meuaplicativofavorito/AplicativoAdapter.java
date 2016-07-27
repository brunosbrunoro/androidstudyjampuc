package br.com.brunoscrokbrunoro.meuaplicativofavorito;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.com.brunoscrokbrunoro.meuaplicativofavorito.entity.Aplicativo;

/**
 * @author Bruno Scrok Brunoro
 * @create 27/7/16 18:18
 * @project MeuAplicativoFavorito
 */
public class AplicativoAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Aplicativo> list;

    public AplicativoAdapter(LayoutInflater inflater, List<Aplicativo> list){
        this.inflater = inflater;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if(convertView == null){
            convertView = inflater.inflate(android.R.layout.simple_list_item_2,null);

            viewHolder = new ViewHolder();

            viewHolder.txtId = (TextView) convertView.findViewById(android.R.id.text1);
            viewHolder.txtNome = (TextView) convertView.findViewById(android.R.id.text2);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Aplicativo aplicativo = list.get(position);

        viewHolder.txtId.setText(Integer.toString(aplicativo.getId()));
        viewHolder.txtNome.setText(aplicativo.getNome());

        return convertView;
    }
    static class ViewHolder{
        TextView txtId;
        TextView txtNome;
    }
}

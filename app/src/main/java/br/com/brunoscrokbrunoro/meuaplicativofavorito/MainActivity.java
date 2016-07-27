package br.com.brunoscrokbrunoro.meuaplicativofavorito;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.brunoscrokbrunoro.meuaplicativofavorito.entity.Aplicativo;

public class MainActivity extends AppCompatActivity {

    private EditText edtTexto;
    private ListView lstAplicativos;
    private List<Aplicativo> listaAplicativos;
    private AplicativoAdapter adapter;

    private int ids = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTexto = (EditText) findViewById(R.id.edtTexto);
        lstAplicativos = (ListView) findViewById(R.id.lstAplicativos);

        listaAplicativos = new ArrayList<Aplicativo>();

        adapter = new AplicativoAdapter(getLayoutInflater(),listaAplicativos);

        lstAplicativos.setAdapter(adapter);

        Button butTrocaMensagem = (Button) findViewById(R.id.butTrocaMensagem);

        butTrocaMensagem.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Aplicativo aplicativo = new Aplicativo();
                aplicativo.setId(ids);
                aplicativo.setNome(edtTexto.getText().toString());

                listaAplicativos.add(aplicativo);

                adapter.notifyDataSetChanged();

                ids++;

            }
        });

        lstAplicativos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Aplicativo aplicativo = listaAplicativos.get(position);

                Intent intent = new Intent(getApplicationContext(),DadosAplicativoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("id",aplicativo.getId());
                bundle.putString("nome",aplicativo.getNome());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}

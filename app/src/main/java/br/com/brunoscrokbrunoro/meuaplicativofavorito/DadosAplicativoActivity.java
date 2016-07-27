package br.com.brunoscrokbrunoro.meuaplicativofavorito;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class DadosAplicativoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_aplicativo);

        int id = getIntent().getExtras().getInt("id");
        String nome = getIntent().getExtras().getString("nome");


        TextView txtId = (TextView) findViewById(R.id.txtId);
        TextView txtNome = (TextView) findViewById(R.id.txtNome);

        txtId.setText(Integer.toString(id));
        txtNome.setText(nome);

    }

}

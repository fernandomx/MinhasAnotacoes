package com.example.minhasanotaes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAnotacao = findViewById(R.id.editAnotacao);
        preferencias = new AnotacaoPreferencias(getApplicationContext());



        //Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_confirmar_24dp);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Validar se foi digitado algo
                String Anotacao = editAnotacao.getText().toString();
                Snackbar AvisoValidacao = Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG);
                Snackbar AvisoSalvo = Snackbar.make(view, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG);

                if (Anotacao.equals("")){
                    AvisoValidacao.show();
                }else {
                    preferencias.salvarAnotacao(Anotacao);
                    AvisoSalvo.show();
                }


            }
        });

        //Recuperar anotacao
        String anota =  preferencias.recuperarAnotacao();

        if (!anota.equals("")){
            editAnotacao.setText(anota);

        }
    }



}

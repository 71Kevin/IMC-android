package estudo.br.duastelas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivitySaida extends AppCompatActivity {
    /**
     * Declarar os objetos que estão presentes na View
     */
    TextView imc;
    Button btFeminino;
    Button btMasculino;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // chama a tela inicial (view)
        setContentView(R.layout.activity_resultado);

        /**
         * Identificar os controles presentes na View (secundária)
         */
        imc = (TextView) findViewById(R.id.textIMC);

        // recuperando a Intent enviada pela activity anterior
        Intent it = getIntent();

        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){
                String result = params.getString("result");

                String r = String.format("%.2f", Double.parseDouble(params.getString("result")));

                // enviar os valores para a View Saída
                imc.setText(r);

                this.result = result;

            }
        }


        btFeminino = (Button) findViewById(R.id.buttonF);
        // ao clicar no botão voltar, leva para a acvtivity inicial
        btFeminino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent tela2 = new Intent(MainActivitySaida.this, MainActivityFeminino.class);

                Bundle params = new Bundle();

                params.putString("imc", result);

                // atribuido as chaves/valores para o objeto tela2
                tela2.putExtras(params);

                // inicializar a segunda activity
                startActivity(tela2);
            }
        });

        btMasculino = (Button) findViewById(R.id.buttonM);
        // ao clicar no botão voltar, leva para a acvtivity inicial
        btMasculino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tela2 = new Intent(MainActivitySaida.this, MainActivityMasculino.class);

                Bundle params = new Bundle();

                params.putString("imc", result);

                // atribuido as chaves/valores para o objeto tela2
                tela2.putExtras(params);

                // inicializar a segunda activity
                startActivity(tela2);
            }
        });
    }
}

package estudo.br.duastelas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivityFeminino extends AppCompatActivity {
    /**
     * Declarar os objetos que estão presentes na View
     */
    TextView classificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // chama a tela inicial (view)
        setContentView(R.layout.activity_feminino);

        /*
         * Identificar os controles presentes na View (secundária)
         */
        classificacao = (TextView) findViewById(R.id.textIMC);

        // recuperando a Intent enviada pela activity anterior
        Intent it = getIntent();

        if(it != null){
            Bundle params = it.getExtras();
            if(params != null){
                String imc = String.format("%.2f", Double.parseDouble(params.getString("imc")));

                Double d = Double.parseDouble(imc);

                String resultado;

                if(d < 19.1){
                    resultado = "Abaixo do peso";
                }else if(d >= 19.1 && d < 25.8){
                        resultado = "Peso normal";
                }else if(d >= 25.8 && d < 27.3){
                        resultado = "Ligeiramente acima do peso";
                }else if(d >= 27.3 && d < 32.3){
                        resultado = "Acima do peso ideal";
                } else {
                    resultado = "Obesa";
                }

                // enviar os valores para a View Saída
                classificacao.setText(resultado);
            }
        }
    }
}

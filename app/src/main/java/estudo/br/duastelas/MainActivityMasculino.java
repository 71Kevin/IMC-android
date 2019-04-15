package estudo.br.duastelas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivityMasculino extends AppCompatActivity {
    /**
     * Declarar os objetos que estão presentes na View
     */
    TextView classificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // chama a tela inicial (view)
        setContentView(R.layout.activity_masculino);

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

                if(d < 20.7){
                    resultado = "Abaixo do peso";
                }else if(d >= 20.7 && d < 26.4){
                        resultado = "Peso normal";
                }else if(d >= 26.4 && d < 27.8){
                        resultado = "Ligeiramente acima do peso";
                }else if(d >= 27.8 && d < 31.1){
                        resultado = "Acima do peso ideal";
                } else {
                    resultado = "Obeso";
                }

                // enviar os valores para a View Saída
                classificacao.setText(resultado);
            }
        }
    }
}

package br.ifsul.gabriella.impostorenda;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


public class ImpostoRenda extends ActionBarActivity {
    EditText edsalario;
    EditText edgasto;
    Button calcular;
    RadioGroup grup;
    int dependente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imposto_renda);

        calcular = (Button)findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                edsalario = (EditText) findViewById(R.id.salariobruto);
                edgasto = (EditText) findViewById(R.id.gastosplano);
                grup = (RadioGroup)findViewById(R.id.radiogroup);

                double salario = Double.parseDouble(edsalario.getText().toString());
                double gasto = Double.parseDouble(edgasto.getText().toString());

                switch (grup.getCheckedRadioButtonId())
                {
                    case R.id.radio0 :
                        dependente=0;
                        break;
                    case R.id.radio1 :
                        dependente=1;
                        break;
                    case R.id.radio2 :
                        dependente=2;
                        break;
                    case R.id.radio3 :
                        dependente=3;
                        break;
                    case R.id.radio4 :
                        dependente=4;
                        break;
                    case R.id.radio5 :
                        dependente=5;
                        break;
                }

                Intent intencao = new Intent(getApplicationContext(),ir_devido.class);
                intencao.putExtra("salario", salario);
                intencao.putExtra("gasto",gasto);
                intencao.putExtra("depende",dependente);
                startActivity(intencao);


            }
        });
    }
}

package br.ifsul.gabriella.impostorenda;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class ir_devido extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ir_devido);
        Bundle extras = getIntent().getExtras();
        Double Salario = extras.getDouble("salario");
        Double Gasto = extras.getDouble("gasto");
        int dependente = extras.getInt("dependente");
        double desconto_dependente=dependente*179.71;

        double inss = 0;

        if(Salario<=1317.07){
            inss = Salario-(Salario*0.08);
        }
        if(Salario>=1317.08 && Salario<=2195.12){
            inss = Salario-(Salario*0.09);
        }
        if(Salario>=2195.13 && Salario<=4390.24){
            inss = Salario-(Salario*0.11);
        }
        if(Salario>=4390.25){
            inss = 482.93;
        }

        double deducao=0;
        double aliquota=0;

        if(Salario<=1787.77){
            deducao=0;
        }
        if(Salario>=1787.78 && Salario<=2679.29){
            aliquota=7.5;
            deducao=134.08;
        }
        if(Salario>=2679.30 && Salario<=3572.43){
            aliquota=15;
            deducao=335.03;
        }
        if(Salario>=3572.44 && Salario<=4463.80){
            aliquota=22.5;
            deducao=602.96;
        }
        if(Salario>=4463.81){
            aliquota=27.5;
            deducao=826.15;
        }

        double irrf= ((Salario-dependente-inss-gasto)*aliquota-deducao);

        TextView vencimentos = (TextView)findViewById(R.id.vencimentos);
        TextView descontodp = (TextView)findViewById(R.id.descontodp);
        TextView inss = (TextView)findViewById(R.id.inss);
        TextView totalir = (TextView)findViewById(R.id.totalir);

        vencimentos.setText(Salario);
        descontodp.setText(dependente);
        inss.setText(inss);
        totalir.setText(irrf);

        Button voltar = (Button) findViewById(R.id.voltar);

        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencao = new Intent(getApplicationContext(), ImpostoRenda.class);
                startActivity(intencao);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ir_devido, menu);
        return true;
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

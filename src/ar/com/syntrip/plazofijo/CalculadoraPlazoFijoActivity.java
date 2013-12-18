package ar.com.syntrip.plazofijo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculadoraPlazoFijoActivity extends Activity {
    
	float monto_inicial = 0;
	float tasa_nominal_anual = 0;
	int lapso = 0;
	
	float monto_final = 0;
	float intereses_ganados = 0;
	float intereses_por_mes = 0;
	
	
	EditText tvMontoInicial;
	EditText tvTasaNominalAnual;
	EditText tvLapso;
	
	Button bCalcular;
	
	TextView tvMontoFinal;
	TextView tvInteresesGanados;
	TextView tvInteresesPorMes;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tvMontoInicial = (EditText) findViewById(R.id.tvMontoInicial);
        
        tvTasaNominalAnual = (EditText) findViewById(R.id.tvTasaNominalAnual);
        tvLapso = (EditText) findViewById(R.id.tvLapso);
        
        tvMontoFinal = (TextView) findViewById(R.id.tvMontoFinal);
        tvInteresesGanados = (TextView) findViewById(R.id.tvInteresesGanados);
        tvInteresesPorMes = (TextView) findViewById(R.id.tvInteresesPorMes);
        
        bCalcular = (Button) findViewById(R.id.bCalcular);
        bCalcular.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String m = tvMontoInicial.getText().toString();
				monto_inicial = Float.valueOf(m.length() == 0 ? "0" : m);

				String t = tvTasaNominalAnual.getText().toString();
				tasa_nominal_anual = Float.valueOf(t.length() == 0 ? "0" : t);
				tasa_nominal_anual /= 100;
				
				String l = tvLapso.getText().toString();
				lapso = Integer.valueOf(l.length() == 0 ? "0" : l);
								
				monto_final = (monto_inicial * (1 + tasa_nominal_anual * (Float.valueOf(lapso)/365)));
				intereses_ganados = monto_final - monto_inicial;
				
				intereses_por_mes = 0;
				if (lapso != 0) {
					intereses_por_mes = intereses_ganados / (lapso/30);
				}
								
				tvMontoFinal.setText(String.valueOf(monto_final));
				tvInteresesGanados.setText(String.valueOf(intereses_ganados));
				tvInteresesPorMes.setText(String.valueOf(intereses_por_mes));
				
			}
		});	
        
    }
}
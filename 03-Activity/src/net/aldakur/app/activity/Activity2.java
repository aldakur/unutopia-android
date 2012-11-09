package net.aldakur.app.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Activity2 extends Activity implements OnClickListener {
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button btn = (Button) findViewById(R.id.button1);
        //Inplementamos el OnClickListener y el onClick de otra forma diferente
        //a la que se implementa en la MainActivity
        //Las dos implementaciones estan bien
        btn.setOnClickListener(this);
    }

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		
		//cogemos los datos del intent que nos manda MainActivity
		//para ello miramos que intent nos llega
		
		String text = getIntent().getStringExtra("EXTRA_TEXTO");
		//cada vez que se inicia la Activity notificar el texto que pasa la MainActivity
		Toast toast = Toast.makeText(this, text, Toast.LENGTH_LONG);//contexto, texto, duracion
		toast.show();
		super.onStart();
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		//mediante un Switch controlamos que boton ha sido pulsado
		switch(v.getId()){
		
		case R.id.button1:
			
			Context contexto = this;
			Intent intent = new Intent(contexto, MainActivity.class);
			startActivity(intent);
		
			break;
		
		}
		
	}

}

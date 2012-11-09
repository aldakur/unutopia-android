package net.aldakur.app.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
	private TextView texto;

	@Override
    public void onCreate(Bundle savedInstanceState) {
		Log.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        texto = (TextView) findViewById(R.id.texto);
        texto.setOnClickListener(new OnClickListener(){

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Context contexto = MainActivity.this;
				//Intente sortu eta ze aktibitara joan behar dugun zehaztu
				Intent intent = new Intent(contexto, Activity2.class);//contexto, activity a la que se pasa
				
				//preparamos para pasar el texto del TextView texto a la Activity2
				intent.putExtra("EXTRA_TEXTO", texto.getText());
				startActivity(intent); 
				
			}});
    }
    

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.d(TAG,"onStart");
		super.onStart();
	}

	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.d(TAG,"onResume");
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.d(TAG,"onPause");
		super.onPause();
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.d(TAG,"onStop");
		super.onStop();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		Log.d(TAG,"onRestart");
		super.onRestart();
	}
	
    @Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
    	Log.d(TAG,"onDestroy");
		super.onDestroy();
	}
}

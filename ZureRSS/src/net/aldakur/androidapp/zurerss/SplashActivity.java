package net.aldakur.androidapp.zurerss;

import android.os.Handler;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class SplashActivity extends Activity {

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	

	//SPLASH_DISPLAY_LENGTH el tiempo en espera de la Activity splash en milisegundos
	private final int SPLASH_DISPLAY_LENGTH = 6000;


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        LinearLayout btn = (LinearLayout) findViewById(R.id.btn_splash);
        btn.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Context contexto = SplashActivity.this;
				//Intente sortu eta ze aktibitara joan behar dugun zehaztu
				Intent intent = new Intent(contexto,ArticleListActivity.class);
				startActivity(intent); 
				/*Destruye esta*/
				finish();
				
			}});
    
	//cuando pasen dos segundos si el usuario no ha pulsado el boton. Pasamos a la siguiente Activity
    //automaticamente
        
        //postDelayed recibe dos parametros.
        //el primero el Runnable
        //el segundo long delayMillis
        new Handler().postDelayed(new Runnable(){
        	
    	
    	public void run(){
    		Context contexto = SplashActivity.this;
       		Intent intent = new Intent(contexto, ArticleListActivity.class);
    		startActivity(intent);
			/*Destruye esta*/
    		finish();
    	};
    }, SPLASH_DISPLAY_LENGTH);
        
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }
}

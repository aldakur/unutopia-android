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
	
  
	private Handler delayed;
	private Runnable delayedTask = new Runnable () {
		
    			public void run(){
    			Context contexto = SplashActivity.this;
    			Intent intent = new Intent(contexto, ArticleListActivity.class);
    			startActivity(intent);
    			delayed.removeCallbacks(this);
    			/*Destruye esta*/
    			finish();
    			}
	};


	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        
        // creamos un temporizador para que, pasados 6 segundos, se muestre la activity ArticleListActivity
        delayed = new Handler ();
        delayed.removeCallbacks(delayedTask);
        delayed.postDelayed(delayedTask, 6000);
        
        LinearLayout btn = (LinearLayout) findViewById(R.id.btn_splash);
        btn.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Context contexto = SplashActivity.this;
				//Intente sortu eta ze aktibitara joan behar dugun zehaztu
				Intent intent = new Intent(contexto,ArticleListActivity.class);
				startActivity(intent);
				delayed.removeCallbacks(delayedTask);
				/*Destruye esta*/
				finish();
				
			}});
	}//finish_onCreate

	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		delayed.removeCallbacks(delayedTask);
		finish();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onPause();
		delayed.removeCallbacks(delayedTask);
		finish();
	}
}

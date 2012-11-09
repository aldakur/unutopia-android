package net.aldakur.app.activityariketa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ArticleListActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.articlelistactivity);
		
		Button btn1 = (Button) findViewById(R.id.btn1);
        //Inplementamos el OnClickListener y el onClick de otra forma diferente
        //a la que se implementa en la SplashActivity
        //Las dos implementaciones estan bien
        btn1.setOnClickListener(this);
		
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		//mediante un Switch controlamos que boton ha sido pulsado
		switch(v.getId()){
		
		case R.id.btn1:
		
		Context contexto = this;
		Intent intent = new Intent(contexto, AboutActivity.class);
		startActivity(intent);
		
		break;
		
		
		}
		
	}

}

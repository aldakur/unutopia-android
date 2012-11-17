package net.aldakur.androidapp.zurerss;

import java.util.ArrayList;
import java.util.HashMap;

import data.FeedContract;
import data.MisArticulos;

import widget.FeedsAdapter;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ArticleListActivity extends ListActivity  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.articlelistactivity);
		
		//creao un nuevo adaptador del tipo FeedsAdapter (extends SimpleAdapter) que he definido
		final FeedsAdapter adapter = new FeedsAdapter(this, new MisArticulos());
		setListAdapter(adapter);
		
		/*//hasMap (gakoa, balioa)
		ArrayList<HashMap<String, String>> data = new ArrayList<HashMap<String, String>>();
		
		for(int x=0; x<10; x++) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("nombre", "Egoitz "+x);
			map.put("apellido", "Aitor "+x);

			data.add(map);
		}
		
		//****Adapter****
		int layout = android.R.layout.simple_list_item_2;
		String[] from = new String[] { "nombre", "apellido" };
		int[] to = new int[] { android.R.id.text1, android.R.id.text2 };
		
		SimpleAdapter adapter = new SimpleAdapter(this, data, layout, from, to);
		setListAdapter(adapter);*/
		
		//****Boton****///
		//Button btn1 = (Button) findViewById(R.id.btn1);
        //Inplementamos el OnClickListener y el onClick de otra forma diferente
        //a la que se implementa en la SplashActivity
        //Las dos implementaciones estan bien
        //btn1.setOnClickListener(this);
		
	}
		
	  @Override
	  protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		final Adapter adapter = l.getAdapter();
		HashMap<String,Object> feed = (HashMap) adapter.getItem(position);
		
  	    final String title = (String) feed.get(FeedContract.TITLE);
	 	Toast.makeText(this, title, Toast.LENGTH_LONG).show();
	 	
	 	//Intent intent = AppIntent.getArticleIntent(title);
	 	//startActivity(intent);
	 	}

	/*public void onClick(View v) {
		// TODO Auto-generated method stub
		//mediante un Switch controlamos que boton ha sido pulsado
		switch(v.getId()){
		
		case R.id.btn1:
		
		Context contexto = this;
		Intent intent = new Intent(contexto, AboutActivity.class);
		startActivity(intent);
		
		break;
		
		
		}
		
	}*/

}

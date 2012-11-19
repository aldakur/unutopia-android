package net.aldakur.androidapp.zurerss;

import java.util.HashMap;
import data.FeedContract;
import data.MisArticulos;
import widget.FeedsAdapter;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
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
		
	}
		
	  @Override
	  protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		final Adapter adapter = l.getAdapter();
		HashMap<String,Object> feed = (HashMap) adapter.getItem(position);
		
  	    final String title = (String) feed.get(FeedContract.TITLE);
	 	Toast.makeText(this, title, Toast.LENGTH_LONG).show();

	 	}
}

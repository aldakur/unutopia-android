package net.aldakur.app.persistencia;

import net.aldakur.app.persistencia.db.MembersContract.UsersTable;
import net.aldakur.app.persistencia.db.MyDbHelper;
import android.app.ListActivity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.SimpleCursorAdapter;
public class MainActivity extends ListActivity {

	private SimpleCursorAdapter adapter;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        
        //getFilesDir();
        //getCacheDir();
        //getExternalCacheDir();
        //getExternalFilesDir(type);
        
        final MyDbHelper helper = new MyDbHelper(this);
        final SQLiteDatabase db = helper.getWritableDatabase();//Optener la base de datos en modo escritura
        
        ContentValues values = new ContentValues();
        values.put(UsersTable.EMAIL, "aldakur@batbi.com");
        values.put(UsersTable.USERNAME, "aldakur");
        
        long id = db.insert(UsersTable.TABLE_NAME, null, values);
        db.close();
        
        //
       Context context = this;
       int layout = android.R.layout.simple_list_item_2;
       Cursor c = null;
       String[] from = new String[] {UsersTable.USERNAME, UsersTable.EMAIL};
       
       //relacionamos username con text1 y email con text2
       int to[] = new int[] {android.R.id.text1, android.R.id.text2};
  	   int flags = SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER;//Observer. Esta continuamente vigilando los cambios en la BD. Cuando 
  	   //suceda un cambio en la BD el adapter sera notificado
  	   
	   adapter = new SimpleCursorAdapter(context, layout, c, from, to, flags);
	   setListAdapter(adapter);
    }
    
    @Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		adapter.changeCursor(getUsers());
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		adapter.changeCursor(null);
		super.onStop();
	}
	
    private Cursor getUsers(){
    	MyDbHelper helper = new MyDbHelper(this);
    	SQLiteDatabase db = helper.getReadableDatabase();
    	
		String table = UsersTable.TABLE_NAME;
		String[] columns = new String[]{UsersTable._ID, UsersTable.USERNAME, UsersTable.EMAIL};
		//selection es la parte del Where.
		//en el hangout #5 1:30 se explica mejor
		String selection = null;
		String[] selectionArgs = null;
		String orderBy = UsersTable.USERNAME + " DESC";
		String groupBy = null;
		String having = null;
		
		return db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
    	
    }

    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
        //esto me devuelve un objeto con las preferencias del usuario
        SharedPreferences prefs = getSharedPreferences("MisPrefs", MODE_PRIVATE);
        //parametros (key, valoPorDefectoEnCasoDeQueLaProiedadNoExista)
        int counter = prefs.getInt("COUNTER", 0);
        counter++;
        //para poder editar los valores, necesito un editor
        Editor editor = prefs.edit();
        editor.putFloat("COUNTER", 	counter);
        editor.commit();
        
        Log.d("Counter", ""+counter);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

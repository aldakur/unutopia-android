package net.aldakur.app.persistencia.db;

import net.aldakur.app.persistencia.db.MembersContract.UsersTable;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//La clase SQLite OpenHelper ayuda a 
	//Obetener la base de datos
	//Actualizarla
	//... a interactuar con ella
public class MyDbHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;

	public MyDbHelper(Context context){
		
		super(context, MembersContract.DB_NAME, null, DATABASE_VERSION);
	}
	
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + UsersTable.TABLE_NAME + "("
					+ UsersTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ UsersTable.USERNAME + " STRING,"
					+ UsersTable.EMAIL + " STRING"
					+")"
				);

	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}

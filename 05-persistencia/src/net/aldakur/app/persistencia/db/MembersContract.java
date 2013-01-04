package net.aldakur.app.persistencia.db;

import android.provider.BaseColumns;

public class MembersContract {
	//nombre del fichero de texto donde se almacena la base de datos
	public static final String DB_NAME = "users.db";
	//para que nadie pueda instanciar la clase
	private MembersContract(){}
	
	//como lo implementamos a BaseColumn se crean dos campos automaticamente
		//_ID que es un id para cada valor de la BD
		//_COUNT ba contando los valores que tiene la BD
	public static class UsersTable implements BaseColumns{
		//un constructor privado apra que nadie pueda instanciarla
			//automaticamente se crean los atributos _ID y COUNT
		private UsersTable(){}
		
		public static final String TABLE_NAME = "users";
		public static final String USERNAME="username";//entre comillas el nombre que se usa en la BD
		public static final String EMAIL="email";
		
	}

}

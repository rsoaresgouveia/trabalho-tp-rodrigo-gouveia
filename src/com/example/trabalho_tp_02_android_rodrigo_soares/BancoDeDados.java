package com.example.trabalho_tp_02_android_rodrigo_soares;

	import android.content.Context;
	import android.database.sqlite.*;

	public class BancoDeDados extends SQLiteOpenHelper {
	  public static final int DATABASE_VERSION = 1;
	  public static final String DATABASE_NAME = "TravelersGuide.db";

	  private static final String SQL_CREATE_TABLES = "CREATE TABLE Travelers(" +
	      "nome TEXT, email TEXT, telefone TEXT, cpf TEXT PRIMARY KEY, localidade TEXT)";

	  private static final String SQL_DELETE_TABLES = "DROP TABLE IF EXISTS Travelers";

	  public BancoDeDados(Context context) {
	    super(context, DATABASE_NAME, null, DATABASE_VERSION);
	  }

	  public void onCreate(SQLiteDatabase db) {
	    db.execSQL(SQL_CREATE_TABLES);

	  }

	  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	    db.execSQL(SQL_DELETE_TABLES);
	    onCreate(db);
	  }
}

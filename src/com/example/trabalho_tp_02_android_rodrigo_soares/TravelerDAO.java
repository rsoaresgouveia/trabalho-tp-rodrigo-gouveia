package com.example.trabalho_tp_02_android_rodrigo_soares;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TravelerDAO {
	  private SQLiteDatabase BancoDeDados;

	  public TravelerDAO(Context context) {
	    this.BancoDeDados = (new BancoDeDados(context)).getWritableDatabase();
	  }

	  public Traveler getTraveler(String nome, String cpf) {
	    Traveler traveler = null;
	    String sqlQuery = "SELECT * FROM Travelers WHERE " +
	                      "nome='" + nome + "' AND cpf='" + cpf + "'";
	    Cursor cursor = this.BancoDeDados.rawQuery(sqlQuery, null);
	    if (cursor.moveToNext()) {
	        traveler = new Traveler(nome, cursor.getString(1), 
	                              cursor.getString(2), cursor.getString(3), cursor.getString(4));
	    }
	    cursor.close();
	    return traveler;
	  }
	  
	  public boolean addTraveler(Traveler u) {
		    try {
		      String sqlCmd = "INSERT INTO Travelers VALUES ('" + 
		                        u.getNome() + "'," + " '" + u.getEmail() + "', " + 
		                        " '" + u.getTelefone() + "', " + " '" + u.getCpf() + "', " +
		                        " '" + u.getLocalidade() + "'" + ")";
		      this.BancoDeDados.execSQL(sqlCmd);
		      return true;

		    } catch (SQLException e) {

		      Log.e("TravelersGuide.appBD", e.getMessage());
		      return false;

		    }
		  }
	  public int contTraveler(){
	
		  String sqlQuery = "SELECT * FROM Travelers ";		  
		  Cursor cursor = this.BancoDeDados.rawQuery(sqlQuery, null);
		  return cursor.getCount();
	  }
	  
	  public boolean delTraveler(String u){
		  try{
			  String sqlCmd = "DELETE FROM Travelers WHERE " + "nome='" + u + "'";
			  this.BancoDeDados.execSQL(sqlCmd);
			  return true;
		  }
		  catch(SQLException e){
			  Log.e("TravelersGuide.appBD", e.getMessage());
			  return false;
		  }
	  }
	  
		  public Cursor getTravelers() {
		    return this.BancoDeDados.rawQuery("SELECT rowid AS _id, " + 
		           "nome, email, telefone, cpf, localidade " + 
		           "FROM Travelers ORDER BY nome", null);
		  }
}

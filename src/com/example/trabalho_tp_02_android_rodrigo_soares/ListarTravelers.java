package com.example.trabalho_tp_02_android_rodrigo_soares;

import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;
import android.view.MenuItem;

public class ListarTravelers extends ListActivity {
	
	public SimpleCursorAdapter dados;	
	public Traveler traveler;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TravelerDAO travelerdao = new TravelerDAO(this);
		dados = new SimpleCursorAdapter(this, R.layout.activity_remove_certeza, travelerdao.getTravelers(),
										new String[]{"nome", "email", "telefone", "cpf", "localidade"},
										new int[]{R.id.subs_n, R.id.subs_m,R.id.subs_cpf1, R.id.subs_tele,
										R.id.subs_loca},0);
		
		setListAdapter(dados);
	}
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.localidade, menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
			case R.id.sobre:
				Intent i = new Intent(this, MenuActivity.class);
				startActivity(i);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	} 
		
}

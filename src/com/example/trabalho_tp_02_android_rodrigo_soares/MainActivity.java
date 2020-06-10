package com.example.trabalho_tp_02_android_rodrigo_soares;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	public void onClickAdicionar(View view){

		String msg = "Adicionar novo Traveler";
		
		Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
		
		Intent intent = new Intent(this, AdicionarActivity.class);
		startActivity(intent);
	}
	
	public void onRemover (View view){			
		Intent intent = new Intent(this, RemoveCerteza.class);
		startActivity(intent);
	}
	
	public void onLista (View view){
		Intent i = new Intent(this, ListarTravelers.class);
		startActivity(i);
	}
	
	public void onLucrar (View view){
		Intent i = new Intent(this, Lucrar.class);
		startActivity(i);
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

package com.example.trabalho_tp_02_android_rodrigo_soares;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LocalidadeActivity extends Activity {
	
	public void onConcluir(View view){
		Intent intent = getIntent();
		String nome = intent.getStringExtra("nome");
		String telefone = intent.getStringExtra("telefone");
		String cpf = intent.getStringExtra("cpf");
		String email = intent.getStringExtra("email");
		EditText local = (EditText) findViewById(R.id.local);
		String localidade = local.getText().toString();
		Log.i("TravelersGuide", "Antes de tentar adicionar no banco de dados");
		
		Traveler traveler = new Traveler(nome, email, telefone, cpf, localidade);
		TravelerDAO travelerdao = new TravelerDAO(this);
				
		if(travelerdao.addTraveler(traveler)){
			Toast.makeText(getApplicationContext(), "Novo Traveler Adicionado!", Toast.LENGTH_SHORT).show();
			finish();
		}
		else{
			Toast.makeText(getApplicationContext(), "Falha ao adicionar novo Traveler!", Toast.LENGTH_SHORT).show();
			finish();
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_localidade);
	}
	@Override
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

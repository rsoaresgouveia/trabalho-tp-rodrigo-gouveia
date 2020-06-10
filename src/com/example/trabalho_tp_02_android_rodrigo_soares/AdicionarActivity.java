package com.example.trabalho_tp_02_android_rodrigo_soares;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AdicionarActivity extends Activity {
	
	public void onOk(View view){
		EditText nome = (EditText) findViewById(R.id.textoNome); 
		EditText email = (EditText) findViewById(R.id.textoEmail);
		EditText telefone = (EditText) findViewById(R.id.textoTelefone);
		EditText cpf = (EditText) findViewById(R.id.textoCPF);
		
		
		
		Intent intent = new Intent(this, LocalidadeActivity.class);
		
		intent.putExtra("nome", nome.getText().toString());
		intent.putExtra("email", email.getText().toString());
		intent.putExtra("telefone", telefone.getText().toString());
		intent.putExtra("cpf", cpf.getText().toString());
		
		startActivity(intent);
		finish();
		}
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_adicionar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.adicionar, menu);
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

package com.example.trabalho_tp_02_android_rodrigo_soares;

import android.os.Bundle;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.support.v4.widget.SimpleCursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;
import android.view.View;

public class RemoveCerteza extends ListActivity {
	public SimpleCursorAdapter dados;	
	public Traveler traveler;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AlertDialog.Builder alert = new AlertDialog.Builder(this);
		alert.setMessage("Clique no traveler que deseja deletar").setNeutralButton("Ok",null).show(); 
		TravelerDAO travelerdao = new TravelerDAO(this);
		dados = new SimpleCursorAdapter(this, R.layout.activity_remove_certeza, travelerdao.getTravelers(),
										new String[]{"nome", "email", "telefone", "cpf", "localidade"},
										new int[]{R.id.subs_n, R.id.subs_m,R.id.subs_cpf1, R.id.subs_tele,
										R.id.subs_loca},0);
		
		setListAdapter(dados);
	}
		public void onListItemClick(ListView l, View v, int pos, long id){			
			Log.i("TravelersGuide", "Antes de tentar iniciar a activity");
			
			TextView textNome = (TextView) v.findViewById(R.id.subs_n); 
			String nome = textNome.getText().toString();
			TravelerDAO t = new TravelerDAO(this);
			Log.i("TravelersGuide", "Antes Leak 1");
			
			if(t.delTraveler(nome)){
				Log.i("TravelersGuide", "Antes Leak 2.1");
				String toast = "Traveler " + nome + " deletado com Sucesso!!";
				Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
				Log.i("TravelersGuide", "Antes Leak 2.1.1");
				finish();
			}
			else{
				Log.i("TravelersGuide", "Antes Leak 2.2");
				String toast1 = "Erro ao deletar Traveler " + nome + " !";
				Toast.makeText(getApplicationContext(), toast1, Toast.LENGTH_LONG).show();
				finish();
			}
		}
}



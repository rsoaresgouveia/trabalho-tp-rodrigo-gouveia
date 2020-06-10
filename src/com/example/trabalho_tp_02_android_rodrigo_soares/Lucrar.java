package com.example.trabalho_tp_02_android_rodrigo_soares;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Lucrar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lucrar);
		
		TravelerDAO t = new TravelerDAO(this);
		int total = t.contTraveler();
		float ganhos = (float) (total*84.23);
		TextView v = (TextView) findViewById(R.id.lucro);
		TextView g = (TextView) findViewById(R.id.ganhos);
		
		v.setText(Html.fromHtml("Total: </b>" +
								total ));
		g.setText(Html.fromHtml("Total:   </b>" +
								  " R$ </b>" + ganhos));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lucrar, menu);
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


package com.mantri.budgetbuddy;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPrefs extends Activity implements OnClickListener {
	
	EditText sharedData, sharedData1;
	TextView dataResults, dataResults1;
	public static String filename = "MySharedString";
	//public static String filename1 = "MySharedString1";
	SharedPreferences someData  ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sharedpreferences);
		setupVariables();
		someData = getSharedPreferences(filename,0);
		//someData1 = getSharedPreferences(filename1,0);
	}

	private void setupVariables() {
		// TODO Auto-generated method stub
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		
		Button save1 = (Button) findViewById(R.id.bSave1);
		Button load1 = (Button) findViewById(R.id.bLoad1);
		
		sharedData = (EditText) findViewById(R.id.evSharedData);
		dataResults = (TextView) findViewById(R.id.tvLoadData);
		
		sharedData1 = (EditText) findViewById(R.id.evSharedData1);
		dataResults1 = (TextView) findViewById(R.id.tvLoadData1);
		
		save.setOnClickListener(this);
		load.setOnClickListener(this);
		
		save1.setOnClickListener(this);
		load1.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.bSave:
			String stringData = sharedData.getText().toString();
			SharedPreferences.Editor editor = someData.edit();
			editor.putString("sharedString", stringData);
			editor.commit();
			break;
		case R.id.bLoad:
			someData = getSharedPreferences(filename, 0);
			String dataReturned = someData.getString("sharedString", "Couldn`t load Data");
			dataResults.setText(dataReturned);
			break;
		case R.id.bSave1:
			String stringData1 = sharedData1.getText().toString();
			SharedPreferences.Editor editor1 = someData.edit();
			editor1.putString("sharedString1", stringData1);
			editor1.commit();
			break;
		case R.id.bLoad1:
			someData = getSharedPreferences(filename, 0);
			String dataReturned1 = someData.getString("sharedString1", "Couldn`t load Data");
			dataResults1.setText(dataReturned1);
			break;
		}
	}
	
	

}

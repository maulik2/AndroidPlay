package com.mantri.budgetbuddy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class GetMethod extends Activity {
	
	TextView textMsg, textPrompt,httpStuff;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.httpex);
		textMsg = (TextView) findViewById(R.id.tvHttpex);
		new GetMethodTest().execute();
		
		/****
		GetMethodEx test = new GetMethodEx();
		String returned;
		try {
			returned = test.getInternetData();
			httpStuff.setText(returned);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		***/
	}
	
	





/****private class*****/

private class GetMethodTest extends AsyncTask<Void, Void, Void> {

	String textResult;
	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		 URL textUrl;

	        try {
	         textUrl = new URL("http://www.google.com");

	         BufferedReader bufferReader 
	          = new BufferedReader(new InputStreamReader(textUrl.openStream()));
	         
	         StringBuffer sb = new StringBuffer("");
	         String l = "";
	         String nl  = System.getProperty("line.separator");
	         while ((l = bufferReader.readLine()) != null) {
	          sb.append(l + nl);   
	         }
	         bufferReader.close();

	         textResult = sb.toString();
	        } catch (MalformedURLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	         textResult = e.toString();   
	        } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	         textResult = e.toString();   
	        }

		return null;
	}

	@Override
    protected void onPostExecute(Void result) {
     
     textMsg.setText(textResult);
     //textPrompt.setText("Finished!");  
     
     super.onPostExecute(result);   
    }
	
}

}
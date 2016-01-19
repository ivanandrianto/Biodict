package com.tusiri.biodict;

import com.tusiri.biodict.R;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SecondActivity extends Activity {
	DBHelper dbhelper;
	Cursor c=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		TextView txvMain = (TextView) findViewById(R.id.tv2);
		// String[] from = new String[] { "_id", "columnName1", "columnName2" };  
		 // int[] to = new int[] { R.id.TextView1, R.id.TextView2, R.id.TextView3 };  
		  
		/*dbhelper = new DBHelper(SecondActivity.this);
        try {
 
        	dbhelper.createDataBase();
 
 	} catch (IOException ioe) {
 
 		throw new Error("Unable to create database");
 
 	}
 
 	try {
 
 		dbhelper.openDataBase();
 
 	}catch(SQLException sqle){
 
 		throw sqle;
 
 	}
 	Toast.makeText(SecondActivity.this, "Success", Toast.LENGTH_SHORT).show();
 
 	
	
 	c=dbhelper.query("table1", null, null, null, null,null, null);
		
 	if(c.moveToFirst())
    {
        do {
     
        	Toast.makeText(SecondActivity.this,
                    "_id: " + c.getString(0) + "\n" +
                    "E_NAME: " + c.getString(1) + "\n" +
                    "E_AGE: " + c.getString(2) + "\n" +
                    "E_DEPT:  " + c.getString(2),
                    Toast.LENGTH_LONG).show();
        	
        } while (c.moveToNext());
    }*/
		/*DataBaseHelper myDbHelper = new DataBaseHelper(SecondActivity.this);
        try {
  
           myDbHelper.createDataBase();
  
   } catch (IOException ioe) {
  
       throw new Error("Unable to create database");
  
   }
  
   try {
  
       myDbHelper.openDataBase();
  
   }catch(SQLException sqle){
  
       throw sqle;
  
   }
   Toast.makeText(SecondActivity.this, "Success", Toast.LENGTH_SHORT).show();
   Cursor c=null;
   c=myDbHelper.query("table1", null, null, null, null,null, null);
   if(c.moveToFirst()){
	    do {
            
            Toast.makeText(SecondActivity.this,
                    "_id: " + c.getString(0) + "\n" +
                    "E_NAME: " + c.getString(1) + "\n" +
                    "E_DESC: " + c.getString(2) + "\n",
                    Toast.LENGTH_LONG).show();
             
        } while (c.moveToNext());
    }*/
		/*TestAdapter mDbHelper = new TestAdapter(this);        
		mDbHelper.createDatabase();      
		mDbHelper.open();

		Cursor testdata = mDbHelper.getTestData();
		List<String> list = new ArrayList<String>();
		if(testdata.moveToFirst()){
			do{
				list.add(testdata.getString(0));
			} while (testdata.moveToNext());
		}
		if(testdata != null && !testdata.isClosed()){
			testdata.close();
		}
		
		
		StringBuilder sb2 = new StringBuilder();
		for(String r : list){
			sb2.append("Hasil = " + r + "\n");
		}
		String res = sb2.toString();
		txvMain.setText(res);
		
		
		mDbHelper.close();*/
		
		
		/*DBHelper dh = new DBHelper(this);
		List<String> results = dh.getAllData();
		StringBuilder sb = new StringBuilder();
		for(String r : results){
			sb.append("Hasil = " + r + "\n");
		}
		String res = sb.toString();
		txvMain.setText(res);*/
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

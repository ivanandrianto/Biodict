package com.tusiri.biodict;

import java.io.IOException;
import java.util.ArrayList;

import com.tusiri.biodict.R;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class Hewan extends Activity implements
	NavigationDrawerFragment.NavigationDrawerCallbacks {
	
	static DBHelper dbhelper;
	static Cursor c=null;
	static ListView list;
	boolean loaded=false;
	
	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNavigationDrawerFragment = (NavigationDrawerFragment) getFragmentManager()
				.findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();

		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer,
				(DrawerLayout) findViewById(R.id.drawer_layout));
		loaded = true;
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
		Intent intent;
		System.out.println("position = " + position);
		if(loaded){
			switch(position){
				case 0:
		            intent = new Intent(this,MainActivity.class);
		            startActivity(intent);
		            break;
				case 1:
		            intent = new Intent(this,Bakteri.class);
		            startActivity(intent);
		            break;
				case 2:
		            intent = new Intent(this,Fungi.class);
		            startActivity(intent);
		            break;
				case 4:
		            intent = new Intent(this,Protista.class);
		            startActivity(intent);
		            break;
				case 5:
		            intent = new Intent(this,Tumbuhan.class);
		            startActivity(intent);
		            break;
				case 6:
		            intent = new Intent(this,Rangka.class);
		            startActivity(intent);
		            break;
		        default:
		        	break;
			}
		}
	}

	

	public void restoreActionBar() {
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		private static final String ARG_SECTION_NUMBER = "section_number";

		/**
		 * Returns a new instance of this fragment for the given section number.
		 */
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		protected Context context;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
	                false);

			//access database
			dbhelper = new DBHelper(getActivity());
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
	        
	        
	        final TextView txvMain = (TextView) rootView.findViewById(R.id.result);
	        list = (ListView) rootView.findViewById(R.id.list);
	        final EditText search = (EditText) rootView.findViewById(R.id.search);
	        search.addTextChangedListener(new TextWatcher(){
	        	public void onTextChanged(CharSequence s, int start, int before, int count){
	        		ArrayList<String> list_title = new ArrayList();
	        		ArrayList<String> list_content = new ArrayList();
	        		String[] title,content;
	        		if(!s.equals("")){
	        			if(s.length()>0){
		        			c=dbhelper.query("hewan", null, "nama_ilmiah LIKE '%" + search.getText() + "%'", null, null,null, null);
		        		 	if(c.moveToFirst())
		        		    {
		        		        do {
		        		        	list_title.add(c.getString(0));
		        		        	list_content.add(c.getString(1));
		        		        } while (c.moveToNext());
		        		    }
		        		 	title = new String[ list_title.size() ];
		        		 	list_title.toArray(title);
		        		 	content = new String[ list_content.size() ];
		        		 	list_content.toArray(content);
	        			} else {
	        		 		title = new String[1];
		        			content = new String[1];
		        			list_title = new ArrayList();
		        			list_title.toArray(title);
		        			list_content = new ArrayList();
		        			list_content.toArray(content);
	        		 	}
	        			CustomList adapter = new CustomList(getActivity(), title, content);
	        			list.setAdapter(adapter);
	        		}
	        	}
	        	
	        	public void beforeTextChanged(CharSequence s, int start, int count, int after){
	        		
	        	}
	        	
	        	public void afterTextChanged(Editable s){
	        		
	        	}
	        	
	        	
	        });
	        
	                    //set a drawable as the background of the textView

	        return rootView;
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			
		}
	}
	@Override
	protected void onDestroy() {
	    super.onDestroy();
	    if (dbhelper != null) {
	    	dbhelper.close();
        }
	}
}

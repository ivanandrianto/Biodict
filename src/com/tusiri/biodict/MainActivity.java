package com.tusiri.biodict;

import com.tusiri.biodict.R;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends Activity implements
	NavigationDrawerFragment.NavigationDrawerCallbacks {	
	static DBHelper dbhelper;
	static Cursor c=null;
	static ListView list;

	
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
		
		
		
		
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		// update the main content by replacing fragments
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager
				.beginTransaction()
				.replace(R.id.container,
						PlaceholderFragment.newInstance(position + 1)).commit();
	}

	public void onSectionAttached(int number) {
		Intent i;
		switch (number) {
		case 1:
			mTitle = getString(R.string.title_home);
			break;
		case 2:
			mTitle = getString(R.string.title_section1);
			i = new Intent(this,Bakteri.class);
			startActivity(i);
			break;
		case 3:
			mTitle = getString(R.string.title_section2);
			i = new Intent(this,Fungi.class);
			startActivity(i);
			break;
		case 4:
			mTitle = getString(R.string.title_section3);
			i = new Intent(this,Hewan.class);
			startActivity(i);
			break;
		case 5:
			mTitle = getString(R.string.title_section4);
			i = new Intent(this,Protista.class);
			startActivity(i);
			break;
		case 6:
			mTitle = getString(R.string.title_section5);
			i = new Intent(this,Tumbuhan.class);
			startActivity(i);
			break;
		case 7:
			mTitle = getString(R.string.title_section5);
			i = new Intent(this,Rangka.class);
			startActivity(i);
			break;
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
			View rootView = inflater.inflate(R.layout.home, container,
	                false);
			ImageButton btnBakteri = (ImageButton) rootView.findViewById(R.id.buttonbakteri);
			
			btnBakteri.setOnClickListener(new View.OnClickListener() {
			    public void onClick(View v) {
			    	changeClass(1);
			    }
			});
			
			ImageButton btnFungi = (ImageButton) rootView.findViewById(R.id.buttonfungi);
			
			btnFungi.setOnClickListener(new View.OnClickListener() {
			    public void onClick(View v) {
			    	changeClass(2);
			    }
			});
			
			ImageButton btnHewan = (ImageButton) rootView.findViewById(R.id.buttonhewan);
			
			btnHewan.setOnClickListener(new View.OnClickListener() {
			    public void onClick(View v) {
			    	changeClass(3);
			    }
			});
			
			ImageButton btnProtista = (ImageButton) rootView.findViewById(R.id.buttonprotista);
			
			btnProtista.setOnClickListener(new View.OnClickListener() {
			    public void onClick(View v) {
			    	changeClass(4);
			    }
			});
			
			ImageButton btnTumbuhan = (ImageButton) rootView.findViewById(R.id.buttontumbuhan);
			
			btnTumbuhan.setOnClickListener(new View.OnClickListener() {
			    public void onClick(View v) {
			    	changeClass(5);
			    }
			});
			
			ImageButton btnRangka = (ImageButton) rootView.findViewById(R.id.buttonrangka);
			
			btnRangka.setOnClickListener(new View.OnClickListener() {
			    public void onClick(View v) {
			    	changeClass(6);
			    }
			});
			
			
	        return rootView;
		}
		
		public void changeClass(int class_number){
			Intent intent;
			switch(class_number){
				case 1:
					intent = new Intent(getActivity(),Bakteri.class);
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(getActivity(),Fungi.class);
					startActivity(intent);
					break;
				case 3:
					intent = new Intent(getActivity(),Hewan.class);
					startActivity(intent);
					break;
				case 4:
					intent = new Intent(getActivity(),Protista.class);
					startActivity(intent);
					break;
				case 5:
					intent = new Intent(getActivity(),Tumbuhan.class);
					startActivity(intent);
					break;
				case 6:
					intent = new Intent(getActivity(),Rangka.class);
					startActivity(intent);
					break;
			}
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(
					ARG_SECTION_NUMBER));
			
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
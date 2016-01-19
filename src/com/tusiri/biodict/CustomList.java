package com.tusiri.biodict;

import com.tusiri.biodict.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
 
public class CustomList extends ArrayAdapter<String>{
 
	private final Activity context;
	private final String[] title;
	private final String[] content;
	public CustomList(Activity context,
	String[] title, String[] content) {
		super(context, R.layout.list_single, title);
		this.context = context;
		this.title = title;
		this.content = content;
	}
	@Override
	public View getView(int position, View view, ViewGroup parent) {
	LayoutInflater inflater = context.getLayoutInflater();
	View rowView= inflater.inflate(R.layout.list_single, null, true);
	TextView txtTitle = (TextView) rowView.findViewById(R.id.txt1);
	TextView txtContent = (TextView) rowView.findViewById(R.id.txt2);
	txtTitle.setText(title[position]);
	txtContent.setText(content[position]);
	return rowView;
	}
}

package thirdstage.exercise.android.case1;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import thirdstage.exercise.*;
import thirdstage.exercise.android.R;

public class Activity4 extends ListActivity {
	
	TextView textView;
	String[] items = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity4);
		
		this.textView = (TextView)this.findViewById(R.id.a4_textview_1);
		
		int id = R.layout.activity4_listview_item_01;
		int ch = 1;
		
		switch(ch){
		
		case 0 :
			id = R.layout.activity4_listview_item_01;
			break;
		
		case 1 :
			id = android.R.layout.simple_list_item_single_choice;
			break;
			
		default :
			break;
		}
		
		this.setListAdapter(
				new ArrayAdapter<String>(this, id, this.items));
		
		this.textView.setHint("Select one in the list");
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		this.textView.setText("Today is " + this.items[position]);
	}
	
	
	
	

}

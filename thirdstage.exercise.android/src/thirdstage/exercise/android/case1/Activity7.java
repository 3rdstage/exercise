package thirdstage.exercise.android.case1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

import thirdstage.exercise.android.*;

public class Activity7 extends Activity {
	
	TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.activity7);
		this.textView = (TextView)this.findViewById(R.id.a7_textview_1);
		this.textView.setText("Long click here for context menu");
		
		this.registerForContextMenu(this.textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		this.getMenuInflater().inflate(R.menu.activity7, menu);
		
		menu.add(0, 1, 0, "Menu 1")
			.setIcon(R.drawable.ic_launcher);
		menu.add(0, 2, 0, "Menu 2")
			.setIcon(R.drawable.robot);
		
		SubMenu sm = menu.addSubMenu(0, 3, 0, "More Menus");
		sm.add(0, 3, 0, "Menu 3");
		sm.add(0, 4, 0, "Menu 4");
		
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		
		this.textView.setText("Selected Menu : " + item.getTitle());
		
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		this.textView.setText("Selected Context Menu : " + item.getTitle());
				
		AlertDialog.Builder db = new AlertDialog.Builder(this);
		db.setTitle("Notification");
		db.setIcon(R.drawable.ic_launcher);
		db.setMessage("You have selected '" + item.getTitle() + "'.");
		db.setPositiveButton("Confirm",
				new OnClickListener(){
					public void onClick(DialogInterface arg0, int arg1) {
					}
		});
		db.show();
		
		return super.onContextItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		
		menu.setHeaderTitle("Select one");
		menu.add("Title");
		menu.add("Artist");
		menu.add("Album");

		super.onCreateContextMenu(menu, v, menuInfo);
	}
	
	
}

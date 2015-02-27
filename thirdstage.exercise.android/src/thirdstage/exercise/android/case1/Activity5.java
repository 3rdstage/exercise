package thirdstage.exercise.android.case1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import thirdstage.exercise.android.R;

public class Activity5 extends Activity {
	
	private Spinner spinner;
	private TextView textView;
	private ListView listView;
	private String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.activity5);
		
		this.textView = (TextView)this.findViewById(R.id.a5_textview_1);
		this.spinner = (Spinner)this.findViewById(R.id.a5_spinner_1);
		this.spinner.setOnItemSelectedListener(
				new OnItemSelectedListener(){

					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						Activity5.this.textView.setText("Selected : " +
								Activity5.this.spinner.getSelectedItem().toString());
					}

					public void onNothingSelected(AdapterView<?> arg0) {
						Activity5.this.textView.setText("Selected : Nothing");
					}
				});
		
		this.listView = (ListView)this.findViewById(R.id.a5_listview_1);
		this.listView.setAdapter(
				new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, this.days));
		this.listView.setOnItemSelectedListener(
				new OnItemSelectedListener(){

					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int arg2, long arg3) {
						Activity5.this.textView.setText("Selected : " +
							Activity5.this.days[arg2]);
					}

					public void onNothingSelected(AdapterView<?> arg0) {
						Activity5.this.textView.setText("Selected : Nothing");
						
					}
				});
		this.listView.setOnItemClickListener(
				new OnItemClickListener(){

					public void onItemClick(AdapterView<?> av, View v,
							int position, long id) {
						
						Activity5.this.listView.setSelection(position);
					}
				});
	}
}

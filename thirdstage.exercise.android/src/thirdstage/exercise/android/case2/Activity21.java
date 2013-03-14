package thirdstage.exercise.android.case2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import thirdstage.exercise.android.*;

public class Activity21 extends Activity {

	TextView nameView;
	TextView phoneView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity21);
		
		this.nameView = (TextView)this.findViewById(R.id.a21_textview_name);
		this.phoneView = (TextView)this.findViewById(R.id.a21_textview_phone);
		
		Bundle data = this.getIntent().getExtras();
		this.nameView.setText(data.getString("name"));
		this.phoneView.setText(data.getString("phone"));
		
		this.setResult(Activity.RESULT_OK, this.getIntent());
		
		((Button)this.findViewById(R.id.a21_button_1)).setOnClickListener(
				new OnClickListener(){

					public void onClick(View arg0) {
						Activity21.this.finish();
					}
				});
	}
	
	

}

package thirdstage.exercise.android.case1;


import thirdstage.exercise.android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends Activity implements View.OnClickListener{
	
	Button button;
	Button button2;
	Button button3;
	EditText editText;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(thirdstage.exercise.android.R.layout.activity3);
		
		this.button = (Button)this.findViewById(R.id.a3Button);
		this.button2 = (Button)this.findViewById(R.id.a3Button2);
		this.button3 = (Button)this.findViewById(R.id.a3Button3);

		this.button.setOnClickListener(
				new View.OnClickListener() {
					public void onClick(View v) {
						Activity3.this.onClick(v);
					}
				}
			);
		
		this.button2.setOnClickListener(this);
		this.button3.setOnClickListener(this);
	}

	public void onClick(View v) {
		
		String str = "";
		
		switch(v.getId()){
		case R.id.a3Button :
			str = ((Button)v).getText().toString();
			break;
		case R.id.a3Button2 :
			str = ((Button)v).getText().toString();
			break;
		case R.id.a3Button3 :
			str = ((Button)v).getText().toString();
			break;
		default :
			str = "Unknown Button";
			break;
			
		}
		Toast.makeText(Activity3.this, "Clicked : " + str, Toast.LENGTH_LONG).show();
	}
	
	
	
	
	

}

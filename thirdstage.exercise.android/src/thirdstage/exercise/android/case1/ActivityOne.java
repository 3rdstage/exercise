package thirdstage.exercise.android.case1;


import thirdstage.exercise.android.R;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivityOne extends Activity {

	TextView textView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.activity1);
		
		this.textView = (TextView)this.findViewById(R.id.a1TxView);
		
		Resources res = this.getResources();
		String[] hobbys = res.getStringArray(R.array.a1Hobbys);
		int[] ints = res.getIntArray(R.array.a1Ints);
		
		this.textView.append("\n");
		for(int i = 0, n = ints.length; i < n; i++){
			this.textView.append(ints[i] + ". " + hobbys[i] + "\n");
		}
	}
	
	
	

}

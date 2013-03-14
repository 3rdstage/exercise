package thirdstage.exercise.android;

import thirdstage.exercise.android.R;
import thirdstage.exercise.android.case1.*;
import thirdstage.exercise.android.case2.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        this.requestWindowFeature(Window.FEATURE_PROGRESS);
        this.setContentView(R.layout.main);
        
        this.setProgressBarVisibility(true);
        this.setProgress(0);
        this.setProgress(10000);
    }
    
    public void onClickButton1(View v){
    	Intent intent = new Intent(this, ActivityOne.class);
    	this.startActivity(intent);
    }
    
    public void onClickButton2(View v){
    	Intent intent = new Intent(this, ActivityTwo.class);
    	this.startActivity(intent);
    }
    
    public void onClickButton3(View v){
    	Intent intent = new Intent(this, Activity3.class);
    	this.startActivity(intent);
    }
    
    public void onClickButton4(View v){
    	Intent intent = new Intent(this, Activity4.class);
    	this.startActivity(intent);
    }
    
    public void onClickButton5(View v){
    	Intent intent = new Intent(this, Activity5.class);
    	this.startActivity(intent);
    }

    public void onClickButton6(View v){
    	Intent intent = new Intent(this, Activity6.class);
    	this.startActivity(intent);
    }
    
    public void onClickButton7(View v){
    	Intent intent = new Intent(this, Activity7.class);
    	this.startActivity(intent);
    }
    
    
    public void onClickButton21(View v){
    	Intent intent = new Intent(this, Activity21.class);
    	Bundle data = new Bundle();
    	data.putString("name", "Peter");
    	data.putString("phone", "010-555-3235");
    	intent.putExtras(data);
    	this.startActivityForResult(intent, 1);
    }

    public void onClickButton22(View v){
    	Intent intent = new Intent(this, Activity22.class);
    	this.startActivity(intent);
    }
   
    public void onClickButton23(View v){
    	Intent intent = new Intent(this, Activity23.class);
    	this.startActivity(intent);
    }
    
    public void onClickButton24(View v){
    	Intent intent = new Intent(this, Activity24.class);
    	this.startActivity(intent);
    }   
}
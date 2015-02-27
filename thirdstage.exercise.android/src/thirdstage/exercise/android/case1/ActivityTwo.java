package thirdstage.exercise.android.case1;

import thirdstage.exercise.android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class ActivityTwo extends Activity {

	ImageView imgView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.activity2);
		this.imgView = (ImageView)findViewById(R.id.a2Image01);
		this.imgView.setImageResource(R.drawable.robot);
		Animation ani = AnimationUtils.loadAnimation(this, R.anim.activity2);
		this.imgView.startAnimation(ani);
		
		
	}
	
	

}

package thirdstage.exercise.android.case2;

import thirdstage.exercise.android.R;
import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity23 extends Activity implements LocationListener, OnClickListener{
	
	
	Button button1;
	Button button2;
	TextView textView;
	LocationManager locationManager;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity23);
		
		button1 = (Button)this.findViewById(R.id.a23_button_1);
		button2 = (Button)this.findViewById(R.id.a23_button_2);
		
		this.textView = (TextView)this.findViewById(R.id.a23_textview_1);
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		
		
	}
	
	public void onClick(View v){
		switch(v.getId()){
		case R.id.a23_button_1 :
			this.locationManager = (LocationManager)this.getSystemService(
					LOCATION_SERVICE);
			this.locationManager.requestLocationUpdates(
					LocationManager.GPS_PROVIDER, 2000, 10, this);
			
			break;
		case R.id.a23_button_2 :
			break;
		}
		
		
	}

	public void onLocationChanged(Location location) {
		
		this.textView.append("위도 : " + String.valueOf(location.getLatitude()));
		this.textView.append("경도 : " + String.valueOf(location.getLongitude()));
		this.textView.append("\n");
		
		
	}

	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

}

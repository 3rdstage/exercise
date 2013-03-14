package thirdstage.exercise.android.case2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;

import thirdstage.exercise.android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.os.*;

public class Activity22 extends Activity implements OnClickListener{

	private static final String fileName = "activity22.txt";
	private TextView textView;
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	private Button button5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.activity22);
		
		this.textView = (TextView)this.findViewById(R.id.a22_textview_1);
		this.button1 = (Button)this.findViewById(R.id.a22_button_1);
		this.button2 = (Button)this.findViewById(R.id.a22_button_2);
		this.button3 = (Button)this.findViewById(R.id.a22_button_3);
		this.button4 = (Button)this.findViewById(R.id.a22_button_4);
		this.button5 = (Button)this.findViewById(R.id.a22_button_5);
		
		
		button1.setOnClickListener(this);
		button2.setOnClickListener(this);
		button3.setOnClickListener(this);
		button4.setOnClickListener(this);
		button5.setOnClickListener(this);
		
		try{

			
			File f = new File(Environment.getExternalStorageDirectory() + "/" + fileName);
			f.createNewFile();
		}
		catch(Exception ex){
			
		}
		
		
		BufferedReader br = null;
		try{
			br = new BufferedReader(
					new InputStreamReader(this.getAssets().open(fileName)));
			
			String str = null;
			StringBuilder sb = new StringBuilder();
			while((str = br.readLine()) != null){
				sb.append(str).append("\n");
			}
			
			this.textView.setText(sb.toString());
			
		}catch(Exception ex){
			ex.printStackTrace();
			
		}finally{
			if(br != null){
				try{ br.close(); }
				catch(Exception ex){}
			}
		}
		
	}

	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.a22_button_1 :
			this.readFile();
			break;
		case R.id.a22_button_2 :
			this.writeFile();
			break;
		case R.id.a22_button_3 :
			this.readExtStorageInfo();
			break;
		case R.id.a22_button_4 :
			this.readExternalFile();
			break;
		case R.id.a22_button_5 :
			this.writeExternalFile();
			break;
			
		}
	}

	private void writeExternalFile() {
		OutputStreamWriter out = null;
		String filePath = "/sdcard" + "/" + fileName;
				
		try{
			out= new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8");
			
			String str = this.textView.getText().toString();
			if(str.contains("last save:")){
				str = str.substring(0, str.indexOf("last save:"));
			}			
			out.write(str);
			out.append("last save:" + new Date().toLocaleString());			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(out != null){
				try{ out.close(); }
				catch(Exception ex){}
			}
		}
				
	}

	private void readExternalFile() {
		BufferedReader br = null;
		String filePath = "/sdcard" + "/" + fileName;
		
		try{
			br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(filePath), "UTF-8"));
			
			String str = null;
			StringBuilder sb = new StringBuilder();
			while((str = br.readLine()) != null){
				sb.append(str).append("\n");
			}
			this.textView.setText(sb);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(br != null){
				try{ br.close(); }
				catch(Exception ex){}
			}
		}
	}

	private void readExtStorageInfo() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("SD 상태 : " + Environment.getExternalStorageState()).append("\n");
		sb.append("SD 경로 : " + Environment.getExternalStorageDirectory()).append("\n");
		sb.append("Data 경로 : " + Environment.getDataDirectory()).append("\n");
		sb.append("Cache 경로 : " + Environment.getDownloadCacheDirectory()).append("\n");
		
		this.textView.setText(sb);
	}

	private void readFile() {
		BufferedReader br = null;
		
		try{
			br = new BufferedReader(
				new InputStreamReader(
						this.openFileInput(fileName), "UTF-8"));
			
			String str = null;
			StringBuilder sb = new StringBuilder();
			while((str = br.readLine()) != null){
				sb.append(str).append("\n");
			}
			this.textView.setText(sb);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(br != null){
				try{ br.close(); }
				catch(Exception ex){}
			}
		}
		
		
	}

	private void writeFile() {
		
		OutputStreamWriter out = null;
		
		try{
			out= new OutputStreamWriter(this.openFileOutput(fileName, 
					Activity.MODE_WORLD_WRITEABLE), "UTF-8");
			
			
			String str = this.textView.getText().toString();
			if(str.contains("last save:")){
				str = str.substring(0, str.indexOf("last save:"));
			}
			out.write(str);
			out.append("last save:" + new Date().toLocaleString());
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(out != null){
				try{ out.close(); }
				catch(Exception ex){}
			}
		}
		
	}
	
	
	

}

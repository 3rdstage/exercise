package thirdstage.exercise.android.case1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import thirdstage.exercise.android.*;

public class Activity6 extends Activity {
	
	private static final String[] groups = {"가족", "친구", "친구", "가족", "친구"};
	private static final String[] phones = {
		"가족1(010-234-5555)",
		"친구1(010-3829-4313)",
		"친구2(016-932-9482)",
		"가족2(011-302-3910)",
		"친구3(010-8828-0103)"
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.setContentView(R.layout.activity6);
		
		ListView lv = (ListView)this.findViewById(R.id.a6_listview_1);
		lv.setAdapter(new MyAdapter(this));
	}
	
	
	private static class MyViewHolder{
		
		TextView textView1;
		TextView textView2;
	}
	
	private static class MyAdapter extends BaseAdapter{
		
		private Context context;
		private LayoutInflater inflater;
		
		public MyAdapter(Context cntx){
			this.inflater = LayoutInflater.from(cntx);
		}

		public int getCount() {
			return Activity6.groups.length;
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			MyViewHolder holder;
			
			if(convertView == null){
				convertView = this.inflater.inflate(R.layout.activity6_adapter, null);
				holder = new MyViewHolder();
				
				holder.textView1 = (TextView)convertView.findViewById(R.id.a6_textview_1);
				holder.textView2 = (TextView)convertView.findViewById(R.id.a6_textview_2);
				convertView.setTag(holder);
			}else{
				holder=(MyViewHolder)convertView.getTag();
				
			}
			
			holder.textView1.setText(Activity6.phones[position]);
			holder.textView2.setText(Activity6.groups[position]);
			
			return convertView;
		}
		
		
		
	}
	

}

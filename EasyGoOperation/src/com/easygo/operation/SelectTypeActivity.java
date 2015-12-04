package com.easygo.operation;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.example.newappsoperation.R;

public class SelectTypeActivity extends Activity {

	private Button writebtn, selectbtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.select_type_activity);
		writebtn = (Button) findViewById(R.id.write);
		selectbtn = (Button) findViewById(R.id.select);

		writebtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(SelectTypeActivity.this,
						SelectDifficultyActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("selectType", "1");
				intent.putExtras(bundle);
				startActivity(intent);
				//finish();
			}
		});
		selectbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(SelectTypeActivity.this,
						SelectDifficultyActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("selectType", "2");
				intent.putExtras(bundle);
				startActivity(intent);
				//finish();
			}
		});
	}
	
	@Override
	public boolean onKeyDown(int keyCode,KeyEvent event)
	{
		if(keyCode==KeyEvent.KEYCODE_BACK&& event.getRepeatCount()==0)
		{
			dialog();
			return true;
		}
		return true;
	}
	protected void dialog()
	{
		AlertDialog.Builder builder=new Builder(SelectTypeActivity.this);
		builder.setMessage("不练习多一会？");
		builder.setTitle("提示");
		builder.setPositiveButton("不", new android.content.DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				android.os.Process.killProcess(android.os.Process.myPid());
			}
		});
		builder.setNegativeButton("再练习一会", new android.content.DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		builder.create().show();
	}
}

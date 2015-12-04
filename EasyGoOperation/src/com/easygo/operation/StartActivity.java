package com.easygo.operation;

import com.example.newappsoperation.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;


public class StartActivity extends Activity {

	private TextView scale;
	private TextView translation,translation2; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.start_activity);
		
		scale = (TextView) findViewById(R.id.textView1);
		translation = (TextView) findViewById(R.id.textView2);
		translation2 = (TextView) findViewById(R.id.textView3);
		
		ScaleAnimation sAnima = new ScaleAnimation(0, 1, 0, 1);
		sAnima.setDuration(2000);
		scale.startAnimation(sAnima);
		TranslateAnimation tAnim = new TranslateAnimation(0, 0, 800, 0);
		tAnim.setDuration(2000);
		translation.startAnimation(tAnim);
		TranslateAnimation tAnim2 = new TranslateAnimation(400, 0, 0, 0);
		tAnim2.setDuration(2000);
		translation2.startAnimation(tAnim2);
		
			new CountDownTimer(1000L, 1000L)
			{
				public void onFinish()
				{
					Intent intent = new Intent();
					intent.setClass(StartActivity.this,SelectTypeActivity.class);
					startActivity(intent);
					finish();
				}
				public void onTick(long paramLong)
				{
				}
			}
			.start();
		
	}

}
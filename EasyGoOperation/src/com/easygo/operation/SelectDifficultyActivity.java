package com.easygo.operation;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

import com.example.newappsoperation.R;

public class SelectDifficultyActivity extends Activity {

	private Button easybtn, mediumbtn, hardbtn;
	int type;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.select_difficulty_activity);
		easybtn = (Button) findViewById(R.id.easy);
		mediumbtn = (Button) findViewById(R.id.medium);
		hardbtn = (Button) findViewById(R.id.hard);
		Bundle bundle = new Bundle();
		bundle = getIntent().getExtras();
		type = Integer.parseInt(bundle.getString("selectType").toString());

		easybtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				gonext(1);
			}

		});
		mediumbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				gonext(2);
			}
		});
		hardbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				gonext(3);
			}
		});
	}

	private void gonext(int diffi) {
		if (type == 1) {
			Intent intent = new Intent(SelectDifficultyActivity.this,
					WriteAnswerActi.class);
			Bundle bundle = new Bundle();
			bundle.putInt("diffi", diffi);
			intent.putExtras(bundle);
			startActivity(intent);
		}
		if (type == 2) {
			Intent intent = new Intent(SelectDifficultyActivity.this,
					SelectAnswerActivity.class);
			Bundle bundle = new Bundle();
			bundle.putInt("diffi", diffi);
			intent.putExtras(bundle);
			startActivity(intent);
		}
	}
}

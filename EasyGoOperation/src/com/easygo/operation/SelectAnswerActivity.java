package com.easygo.operation;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.easygo.opcode.ToOperation;
import com.easygo.opcode.ProductTimu;
import com.example.newappsoperation.R;

public class SelectAnswerActivity extends Activity {
	public Button A, B, C, D, next;
	public TextView show;
	public TextView timuTextView;
	private double result;
	private int diffi = 0;
	private String timustr = "";
	private TextView tv1;
	private int rightcount,count;
	ProductTimu pro = new ProductTimu();

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.select_answer_activity);

		ActionBar actionBar = getActionBar();// 获取ActionBar对象
		actionBar.setDisplayShowHomeEnabled(true);// 显示应用程序图标
		actionBar.setDisplayHomeAsUpEnabled(true);// 将应用程序图标转变为可点击图标，并添加一个返回箭头。
		
		tv1=(TextView)findViewById(R.id.Count);
		A = (Button) findViewById(R.id.A);
		B = (Button) findViewById(R.id.B);
		C = (Button) findViewById(R.id.C);
		D = (Button) findViewById(R.id.D);
		next = (Button) findViewById(R.id.next);
		show = (TextView) findViewById(R.id.show);
		timuTextView = (TextView) findViewById(R.id.timutitle);
		tv1.setText(rightcount+"/"+count);
		Bundle bundle = new Bundle();
		bundle = getIntent().getExtras();
		diffi = bundle.getInt("diffi");
		timustr = pro.prod(diffi);// 获取题目
		next.setEnabled(false);
		result = Math.round(getAnswer(timustr));

		getResult(result);
		timuTextView.setText("题目：" + timustr + "=?");
		A.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (result == Double.parseDouble(A.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					A.setTextColor(Color.GREEN);
					B.setTextColor(Color.RED);
					C.setTextColor(Color.RED);
					D.setTextColor(Color.RED);
					show.setText("你答对了！");
					rightcount++;
					count++;
					tv1.setText(rightcount+"/"+count+"		");

				} else if (result == Double.parseDouble(B.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					B.setTextColor(Color.GREEN);
					A.setTextColor(Color.RED);
					show.setText("正确答案为：" + result);
					count++;
					tv1.setText(rightcount+"/"+count+"		");
				} else if (result == Double.parseDouble(C.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					C.setTextColor(Color.GREEN);
					A.setTextColor(Color.RED);
					show.setText("正确答案为：" + result);
					count++;
					tv1.setText(rightcount+"/"+count+"		");
				} else if (result == Double.parseDouble(D.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					D.setTextColor(Color.GREEN);
					A.setTextColor(Color.RED);
					show.setText("正确答案为：" + result);
					count++;
					tv1.setText(rightcount+"/"+count+"		");
				}
				next.setEnabled(true);
			}
		});
		B.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (result == Double.parseDouble(B.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					B.setTextColor(Color.GREEN);
					A.setTextColor(Color.RED);
					C.setTextColor(Color.RED);
					D.setTextColor(Color.RED);
					show.setText("你答对了！");
					count++;
					rightcount++;
					tv1.setText(rightcount+"/"+count+"		");
				} else if (result == Double.parseDouble(A.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					A.setTextColor(Color.GREEN);
					B.setTextColor(Color.RED);
					show.setText("正确答案为：" + result);
					count++;
					tv1.setText(rightcount+"/"+count+"		");
				} else if (result == Double.parseDouble(C.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					C.setTextColor(Color.GREEN);
					B.setTextColor(Color.RED);
					show.setText("正确答案为：" + result);
					count++;
					tv1.setText(rightcount+"/"+count+"		");
				} else if (result == Double.parseDouble(D.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					D.setTextColor(Color.GREEN);
					B.setTextColor(Color.RED);
					show.setText("正确答案为：" + result);
					count++;
					tv1.setText(rightcount+"/"+count+"		");
				}
				next.setEnabled(true);
			}
		});
		C.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (result == Double.parseDouble(C.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					C.setTextColor(Color.GREEN);
					A.setTextColor(Color.RED);
					B.setTextColor(Color.RED);
					D.setTextColor(Color.RED);
					show.setText("你答对了！");
					count++;
					rightcount++;
					tv1.setText(rightcount+"/"+count+"		");

				} else if (result == Double.parseDouble(A.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					A.setTextColor(Color.GREEN);
					C.setTextColor(Color.RED);
					show.setText("正确答案为：" + result);
					count++;
					tv1.setText(rightcount+"/"+count+"		");
				} else if (result == Double.parseDouble(B.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					B.setTextColor(Color.GREEN);
					C.setTextColor(Color.RED);
					show.setText("正确答案为：" + result);
					count++;
					tv1.setText(rightcount+"/"+count+"		");
				} else if (result == Double.parseDouble(D.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					D.setTextColor(Color.GREEN);
					C.setTextColor(Color.RED);
					show.setText("正确答案为：" + result);
					count++;
					tv1.setText(rightcount+"/"+count+"		");
				}
				next.setEnabled(true);
			}
		});
		D.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				if (result == Double.parseDouble(D.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					D.setTextColor(Color.GREEN);
					A.setTextColor(Color.RED);
					C.setTextColor(Color.RED);
					B.setTextColor(Color.RED);
					show.setText("你答对了！");
					count++;
					rightcount++;
					tv1.setText(rightcount+"/"+count+"		");

				} else if (result == Double.parseDouble(A.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					A.setTextColor(Color.GREEN);
					D.setTextColor(Color.RED);
					show.setText("正确答案为：" + result);
					count++;
					tv1.setText(rightcount+"/"+count+"		");
				} else if (result == Double.parseDouble(B.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					B.setTextColor(Color.GREEN);
					D.setTextColor(Color.RED);
					show.setText("正确答案为：" + result);
					count++;
					tv1.setText(rightcount+"/"+count+"		");
				} else if (result == Double.parseDouble(C.getText().toString())) {
					A.setEnabled(false);
					B.setEnabled(false);
					C.setEnabled(false);
					D.setEnabled(false);
					C.setTextColor(Color.GREEN);
					D.setTextColor(Color.RED);
					show.setText("正确答案为：" + result);
					count++;
					tv1.setText(rightcount+"/"+count+"		");
				}
				next.setEnabled(true);
			}
		});
		next.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*
				 * InputMethodManager imm = (InputMethodManager)
				 * getSystemService(Context.INPUT_METHOD_SERVICE);
				 * imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
				 */
				next.setEnabled(false);
				timustr = pro.prod(diffi);
				timuTextView.setText(timustr + "=?");
				result = Math.round(getAnswer(timustr));
				D.setTextColor(Color.BLACK);
				A.setTextColor(Color.BLACK);
				C.setTextColor(Color.BLACK);
				B.setTextColor(Color.BLACK);
				getResult(result);
				// showanswertitle.setVisibility(View.INVISIBLE);
				show.setText("");
				A.setEnabled(true);
				B.setEnabled(true);
				C.setEnabled(true);
				D.setEnabled(true);

			}
		});
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater inflater = new MenuInflater(this);
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case android.R.id.home:
			// 创建启动MainActivity的Intent
			dialog();
			Intent intent = new Intent(this, SelectTypeActivity.class);
			// 添加额外的Flag，将Activity栈中处于MainActivity之上的Activity弹出
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);

			break;
		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	protected int dialog() {
		AlertDialog.Builder builder = new Builder(SelectAnswerActivity.this);
		builder.setMessage("你一共做了" + count + "道选择题.一共对了" + rightcount + "道.");
		builder.setTitle("提示");
		builder.create().show();
		Runnable runnable = new Runnable() {// 新建一个线程
			@Override
			public void run() {
				finish();
			}
		};
		Handler handler = new Handler();
		handler.postDelayed(runnable, 5000);
		return 0;
	}

	private double getAnswer(String timustr) {
		ToOperation test = new ToOperation();
		return test.computeWithVector(timustr);
	}

	public void getResult(double result) {
		int a = (int) (1 + Math.random() * 4);

		switch (a) {
		case 1:
			A.setText("" + result + "");
			B.setText("" + (result + new Random().nextInt(300)) + "");
			C.setText("" + (result + new Random().nextInt(300)) + "");
			D.setText("" + (result + new Random().nextInt(300)) + "");
			break;
		case 2:
			B.setText("" + result + "");
			A.setText("" + (result + new Random().nextInt(300)) + "");
			C.setText("" + (result + new Random().nextInt(300)) + "");
			D.setText("" + (result + new Random().nextInt(300)) + "");
			break;
		case 3:
			C.setText("" + result + "");
			A.setText("" + (result + new Random().nextInt(300)) + "");
			B.setText("" + (result + new Random().nextInt(300)) + "");
			D.setText("" + (result + new Random().nextInt(300)) + "");
			break;
		case 4:
			D.setText("" + result + "");
			A.setText("" + (result + new Random().nextInt(300)) + "");
			B.setText("" + (result + new Random().nextInt(300)) + "");
			C.setText("" + (result + new Random().nextInt(300)) + "");
			break;
		default:
			break;
		}
	}
}

package com.easygo.operation;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.easygo.opcode.ProductTimu;
import com.easygo.opcode.ToOperation;
import com.example.newappsoperation.R;

public class WriteAnswerActi extends TabActivity {
	private TabHost tabhost;
	private double result;
	private int count =0;
	private int diffi = 0;
	private String timustr = "";
	private Button surebtn, nextbtn;
	private TextView timuTextView, showanswertitle, showresult;
	private EditText userAnswer;
	ProductTimu pro = new ProductTimu();
	DecimalFormat decimalFormat = new DecimalFormat("0.0");
	
	private ListView lvtimu,lvdaan;
	private Button tijiaobtn,xintimu;
	private EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9,ed10;
	
	private String[] timu = new String[10];
	private Double[] trueAns = new Double[10];
	private Double[] userAns = new Double[10];
	private Double[] str = new Double[10];
	ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.write_answer_scti);
        
        //从TabActivity上面获取放置Tab的TabHost
        tabhost = getTabHost();

        
        TabHost.TabSpec tab1 = tabhost.newTabSpec("one");
        tab1.setIndicator("单题练习");
        tab1.setContent(R.id.widget_layout_danti);
        
        
        TabHost.TabSpec tab2 = tabhost.newTabSpec("two");
        tab2.setIndicator("多题练习");
        tab2.setContent(R.id.widget_layout_duoti);
        
        tabhost.addTab(tab1);
        tabhost.addTab(tab2);
        surebtn = (Button) findViewById(R.id.sure);
		timuTextView = (TextView) findViewById(R.id.timu);
		showanswertitle = (TextView) findViewById(R.id.showanswertitle);
		showresult = (TextView) findViewById(R.id.showresult);
		userAnswer = (EditText) findViewById(R.id.useranswer);
		nextbtn = (Button) findViewById(R.id.next);
		lvtimu = (ListView)findViewById(R.id.lvtimu);
		lvdaan = (ListView)findViewById(R.id.lvdaan);
		tijiaobtn = (Button)findViewById(R.id.tijiao);
		xintimu= (Button)findViewById(R.id.xintimu);
		ed1 = (EditText)findViewById(R.id.ed1);
		ed2 = (EditText)findViewById(R.id.ed2);
		ed3 = (EditText)findViewById(R.id.ed3);
		ed4 = (EditText)findViewById(R.id.ed4);
		ed5 = (EditText)findViewById(R.id.ed5);
		ed6 = (EditText)findViewById(R.id.ed6);
		ed7 = (EditText)findViewById(R.id.ed7);
		ed8 = (EditText)findViewById(R.id.ed8);
		ed9 = (EditText)findViewById(R.id.ed9);
		ed10 = (EditText)findViewById(R.id.ed10);
		
		Bundle bundle = new Bundle();
		bundle = getIntent().getExtras();
		diffi = bundle.getInt("diffi");
		timustr = pro.prod(diffi);//获取题目
		
		
		timuTextView.setText(timustr+"=?");
		nextbtn.setEnabled(false);
		showanswertitle.setVisibility(View.INVISIBLE);
		showresult.setVisibility(View.INVISIBLE);
		surebtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (userAnswer.getText().toString().trim().equals("")) {
					Toast.makeText(WriteAnswerActi.this, "请输入答案",
							Toast.LENGTH_SHORT).show();
					return;
				}
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);  
				imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);//键盘
				surebtn.setEnabled(false);
				nextbtn.setEnabled(true);
				
				
				result =getAnswer(timustr);//四舍五入，结果取整
				result =Double.parseDouble(decimalFormat.format(result));
				
				if (result == Double.parseDouble(userAnswer.getText()
						.toString().trim())) {
					showresult.setTextColor(Color.rgb(0, 255, 0));
					showanswertitle.setText("正确答案为：" + result);
					showresult.setText("你答对了！");
				} else {
					showanswertitle.setText("正确答案为：" + result);
					showresult.setTextColor(Color.rgb(255, 0, 0));
					showresult.setText("你答错了！");
				}
				showanswertitle.setVisibility(View.VISIBLE);
				showresult.setVisibility(View.VISIBLE);
			}
		});
		nextbtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);  
				imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
				surebtn.setEnabled(true);
				nextbtn.setEnabled(false);
				timustr = pro.prod(diffi);
				timuTextView.setText(timustr+"=?");
				showanswertitle.setVisibility(View.INVISIBLE);
				showresult.setVisibility(View.INVISIBLE);
				userAnswer.setText("");
			}
		});
		chongxin();
		xintimu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				lvdaan.setAdapter(null);
				chongxin();
				count=0;
				ed1.setText("");
				ed2.setText("");
				ed3.setText("");
				ed4.setText("");
				ed5.setText("");
				ed6.setText("");
				ed7.setText("");
				ed8.setText("");
				ed9.setText("");
				ed10.setText("");
				
			}
		});
		tijiaobtn.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						if(ed1.getText().toString().trim().equals(""))
						{
							Toast.makeText(WriteAnswerActi.this, "请把题做完~~", Toast.LENGTH_SHORT).show();
							return;
						}
						if(ed2.getText().toString().trim().equals(""))
						{
							Toast.makeText(WriteAnswerActi.this, "请把题做完~~", Toast.LENGTH_SHORT).show();
							return;
						}
						if(ed3.getText().toString().trim().equals(""))
						{
							Toast.makeText(WriteAnswerActi.this, "请把题做完~~", Toast.LENGTH_SHORT).show();
							return;
						}
						if(ed4.getText().toString().trim().equals(""))
						{
							Toast.makeText(WriteAnswerActi.this, "请把题做完~~", Toast.LENGTH_SHORT).show();
							return;
						}
						if(ed5.getText().toString().trim().equals(""))
						{
							Toast.makeText(WriteAnswerActi.this, "请把题做完~~", Toast.LENGTH_SHORT).show();
							return;
						}
						if(ed6.getText().toString().trim().equals(""))
						{
							Toast.makeText(WriteAnswerActi.this, "请把题做完~~", Toast.LENGTH_SHORT).show();
							return;
						}
						if(ed7.getText().toString().trim().equals(""))
						{
							Toast.makeText(WriteAnswerActi.this, "请把题做完~~", Toast.LENGTH_SHORT).show();
							return;
						}
						if(ed8.getText().toString().trim().equals(""))
						{
							Toast.makeText(WriteAnswerActi.this, "请把题做完~~", Toast.LENGTH_SHORT).show();
							return;
						}
						if(ed9.getText().toString().trim().equals(""))
						{
							Toast.makeText(WriteAnswerActi.this, "请把题做完~~", Toast.LENGTH_SHORT).show();
							return;
						}
						if(ed10.getText().toString().trim().equals(""))
						{
							Toast.makeText(WriteAnswerActi.this, "请把题做完~~", Toast.LENGTH_SHORT).show();
							return;
						}
						InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);  
						imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);//键盘
						daan();
						pd();
						dialog();
					}
				});
	}

	private void chongxin() {
		//创建一个数组放题目
				for(int i = 0;i<10;i++)
				{
					timu[i] = pro.prod(diffi);
					trueAns[i] = Double.parseDouble(decimalFormat.format(getAnswer(timu[i])));
					timu[i] = timu[i]+"=?";
				}
				lvtimu.setAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1, timu));
	}

	private double getAnswer(String timustr) {
		ToOperation test = new ToOperation();
		return test.computeWithVector(timustr);
	}
        
	private void daan() {
		lvdaan.setAdapter(new ArrayAdapter<Double>(this,
				android.R.layout.simple_list_item_1, trueAns));
	}
	private void pd() {
		// TODO Auto-generated method stub
		
		userAns[0]=Double.parseDouble(ed1.getText().toString().trim());
		userAns[1]=Double.parseDouble(ed2.getText().toString().trim());
		userAns[2]=Double.parseDouble(ed3.getText().toString().trim());
		userAns[3]=Double.parseDouble(ed4.getText().toString().trim());
		userAns[4]=Double.parseDouble(ed5.getText().toString().trim());
		userAns[5]=Double.parseDouble(ed6.getText().toString().trim());
		userAns[6]=Double.parseDouble(ed7.getText().toString().trim());
		userAns[7]=Double.parseDouble(ed8.getText().toString().trim());
		userAns[8]=Double.parseDouble(ed9.getText().toString().trim());
		userAns[9]=Double.parseDouble(ed10.getText().toString().trim());
		
		//Toast.makeText(this, "hh"+userAns[5], Toast.LENGTH_SHORT).show();
		for(int i=0;i<10;i++)
		{
			if(userAns[i]-trueAns[i]>-0.01&&userAns[i]-trueAns[i]<0.01)
			{
				count = count +10;
				switch (i) {
				case 0:
					ed1.setTextColor(Color.rgb(0, 255, 0));
					break;
				case 1:
					ed2.setTextColor(Color.rgb(0, 255, 0));
					break;
				case 2:
					ed3.setTextColor(Color.rgb(0, 255, 0));
					break;
				case 3:
					ed4.setTextColor(Color.rgb(0, 255, 0));
					break;
				case 4:
					ed5.setTextColor(Color.rgb(0, 255, 0));
					break;
				case 5:
					ed6.setTextColor(Color.rgb(0, 255, 0));
					break;
				case 6:
					ed7.setTextColor(Color.rgb(0, 255, 0));
					break;
				case 7:
					ed8.setTextColor(Color.rgb(0, 255, 0));
					break;
				case 8:
					ed9.setTextColor(Color.rgb(0, 255, 0));
					break;
				case 9:
					ed10.setTextColor(Color.rgb(0, 255, 0));
					break;
				default:
					break;
				}
			}
			else {
				switch (i) {
				case 0:
					ed1.setTextColor(Color.rgb(255, 0, 0));
					break;
				case 1:
					ed2.setTextColor(Color.rgb(255, 0, 0));
					break;
				case 2:
					ed3.setTextColor(Color.rgb(255, 0, 0));
					break;
				case 3:
					ed4.setTextColor(Color.rgb(255, 0, 0));
					break;
				case 4:
					ed5.setTextColor(Color.rgb(255, 0, 0));
					break;
				case 5:
					ed6.setTextColor(Color.rgb(255, 0, 0));
					break;
				case 6:
					ed7.setTextColor(Color.rgb(255, 0, 0));
					break;
				case 7:
					ed8.setTextColor(Color.rgb(255, 0, 0));
					break;
				case 8:
					ed9.setTextColor(Color.rgb(255, 0, 0));
					break;
				case 9:
					ed10.setTextColor(Color.rgb(255, 0, 0));
					break;
				default:
					break;
				}
			}
		}
	}
	protected void dialog()
	{
		AlertDialog.Builder builder=new Builder(WriteAnswerActi.this);
		builder.setMessage("本次练习你得了"+count+"分~~");
		builder.setTitle("您的成绩");
		builder.setPositiveButton("退出", new android.content.DialogInterface.OnClickListener() {
			
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

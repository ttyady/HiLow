package com.example.hilow;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Game extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
		View highButton = findViewById(R.id.high_button);
		highButton.setOnClickListener(this);
		View lowButton = findViewById(R.id.low_button);
		lowButton.setOnClickListener(this);
		View nextButton = findViewById(R.id.next_button);
		nextButton.setOnClickListener(this);
		GameStart();
	}


	//ゲーム部分
	int win_count = 0;
	int ran1,ran2;
	boolean flag=true; //不正解になった時にfalseに切り替える
	boolean result=true; //結果発表を表示したらfalseに
	public void GameStart(){
		TextView textView;

		Random ran = new Random();
		ran1 = ran.nextInt(13)+1;
		ran2 = ran.nextInt(13)+1;

		textView = (TextView)findViewById(R.id.textView1);
		textView.setText(""+ran1);
		textView = (TextView)findViewById(R.id.textView2);
		textView.setText("???");
		textView = (TextView)findViewById(R.id.textView3);
		textView.setText("???は大きいか小さいか?");
		ButtonVISIBLE();
		Button nextButton = (Button)findViewById(R.id.next_button);
		nextButton.setVisibility(View.INVISIBLE);

	}
	public void ButtonINVISIBLE(){
		Button highButton = (Button)findViewById(R.id.high_button);
		highButton.setVisibility(View.INVISIBLE);
		Button lowButton = (Button)findViewById(R.id.low_button);
		lowButton.setVisibility(View.INVISIBLE);
	}
	public void ButtonVISIBLE(){
		Button highButton = (Button)findViewById(R.id.high_button);
		highButton.setVisibility(View.VISIBLE);
		Button lowButton = (Button)findViewById(R.id.low_button);
		lowButton.setVisibility(View.VISIBLE);
	}
	public void AnsCurrent(){
		TextView currenttext;
		currenttext = (TextView)findViewById(R.id.textView2);
		TextView answertext;
		answertext= (TextView)findViewById(R.id.textView3);
		Button nextButton = (Button)findViewById(R.id.next_button);
		currenttext.setText(""+ran2);
		answertext.setText("正解");
		win_count++;
		ButtonINVISIBLE();
		nextButton.setVisibility(View.VISIBLE);
	}
	public void AnsIncorrect(){
		TextView currenttext;
		currenttext = (TextView)findViewById(R.id.textView2);
		TextView answertext;
		answertext= (TextView)findViewById(R.id.textView3);
		currenttext.setText(""+ran2);
		answertext.setText("不正解");
		flag=false;
		ButtonINVISIBLE();
		Button nextButton = (Button)findViewById(R.id.next_button);
		nextButton.setVisibility(View.VISIBLE);
	}

	public void onClick(View v){
		switch(v.getId()){
		case R.id.high_button:
			if(flag){
				if(ran1<=ran2){
					AnsCurrent();
				}else{
					AnsIncorrect();
				}
			}
			break;
		case R.id.low_button:
			if(flag){
				if(ran1>=ran2){
					AnsCurrent();
				}else{
					AnsIncorrect();
				}
			}
			break;
		case R.id.next_button:
			if(result){
				if(flag==false){
					TextView answertext;
					answertext= (TextView)findViewById(R.id.textView3);
					answertext.setText("正解数は"+win_count+"問");
					result=false;
				}else{
					GameStart();
				}
			}else{
				finish();
			}
			break;
		//ここに別ボタンの処理コード
		}
	}
}
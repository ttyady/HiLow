package com.example.hilow;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class HiLow extends Activity implements OnClickListener{

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		View gamestartButton = findViewById(R.id.gamestart_button);
		gamestartButton.setOnClickListener(this);
		View aboutButton = findViewById(R.id.about_button);
		aboutButton.setOnClickListener(this);
		View exitButton = findViewById(R.id.exit_button);
		exitButton.setOnClickListener(this);
	}
	public void onClick(View v){
		Intent i = new Intent();
		switch(v.getId()){
		case R.id.about_button:
			i = new Intent(this,About.class);

			startActivity(i);
			break;
		case R.id.exit_button:
			finish();
			break;
		case R.id.gamestart_button:
			i = new Intent(this,Game.class);
			startActivity(i);
			break;
		//ここに別ボタンの処理コード
		}
	}

}
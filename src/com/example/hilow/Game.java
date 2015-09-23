package com.example.hilow;

import java.util.Random;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

public class Game extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);
	}


	//ゲーム部分
	public static final int SUIT = 4; //スートの数
	public static final int MAISU = 13; //枚数
	public static final int MAX_MAISU = SUIT*MAISU; //総枚数
	int buff,ran1,ran2;
	int[] tor = new int[MAX_MAISU];


	private Drawable[] card_img;
	private Drawable[] card_img2;
	private int win_count = 0;

	public void Shuffle(){
		Random r1 = new Random();
		Random r2 = new Random();
		for(int i=1;i<=MAX_MAISU;i++){
			tor[i-1] = i-1;
		}
		for(int i=1;i<=200;i++){
			ran1 = r1.nextInt(MAX_MAISU);
			ran2 = r2.nextInt(MAX_MAISU);

			buff = tor[ran1];
			tor[ran1] = tor[ran2];
			tor[ran2] = buff;
		}
	}
}
package com.example.hilow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class CardView extends ImageView implements AnimationListener,View.OnClickListener{
	private int imageNo; //カード番号
	private boolean state; //表か裏か f=裏,t=表


	public CardView(Context context,int imageNo){
		super(context);
		this.imageNo = imageNo;
		state = false;
		setPadding(0,0,0,0);
		setScaleType(ScaleType.CENTER);
		setImage();
		setLayoutParams(new LayoutParams(96,96));
		setScaleType(ScaleType.FIT_XY);
		setOnClickListener(this);
	}
	private void setImage(){
		if(!state){
			if(imageNo==-1)setImageBitmap(createTalon());
			else setImageResource(R.drawable.c01);
		}else{
			if(imageNo==-1)this.setImageBitmap(createTalon());
			else setImageResource(R.drawable.c02);
		}
	}

	// 山札のイメージ作成
	private Bitmap createTalon(){
		Bitmap orgBitmap = BitmapFactory.decodeResource( getContext().getResources(), R.drawable.c01);
		int width = orgBitmap.getWidth();
		int height = orgBitmap.getHeight();
		// 元画像より30px大きなbitmapを作成（４枚を10pxずつずらして重ねるため）
		Bitmap bm = Bitmap.createBitmap( width+30, height+30, Config.ARGB_8888);
		BitmapDrawable db = new BitmapDrawable(orgBitmap);
		// ここでdbに対して描画
		Canvas canvas = new Canvas(bm);
		// ４枚のカードが重なっているイメージを作成
		canvas.drawBitmap( orgBitmap, 0, 0, null);
		canvas.drawBitmap( orgBitmap, 10, 10, null);
		canvas.drawBitmap( orgBitmap, 20, 20, null);
		canvas.drawBitmap( orgBitmap, 30, 30, null);
		db.draw(canvas);
		return bm;
	}

	public void onClick(View v){
		ScaleAnimation scale = new ScaleAnimation(1.0f,0.0f,1.0f,1.0f,96f/2,96f/2);
		scale.setAnimationListener(this);;
		scale.setFillAfter(true);
		scale.setFillEnabled(true);
		scale.setDuration(500);
		scale.setInterpolator(new LinearInterpolator());
		startAnimation(scale);
	}
	public void onAnimationEnd(Animation animation){
		state = !state;
		setImage();
		ScaleAnimation scale = new ScaleAnimation( 0.0f, 1.0f, 1.0f, 1.0f, 96f/2, 96f/2);
		scale.setFillAfter(true);
		scale.setFillEnabled(true);
		scale.setDuration(500);
		scale.setInterpolator( new LinearInterpolator());
		startAnimation(scale);
	}
	public void onAnimationRepeat(Animation animation){
	}
	public void onAnimationStart(Animation animation){
	}
}
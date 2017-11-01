package andi.crypto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MyIntro extends Activity{
	
	//Splash screen timer
   private static int SPLASH_TIME_OUT = 8000;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_intro);
	
		new Handler().postDelayed(new Runnable(){

			@Override
			public void run() {

				Intent myIntent = new Intent(MyIntro.this,SampleSlider2.class);
				startActivity(myIntent);
				
			}

	 },SPLASH_TIME_OUT);
   }
}
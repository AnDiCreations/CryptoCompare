package andi.crypto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SampleSlider2 extends Activity{
	
	   //Splash screen timer
	   private static int SPLASH_TIME_OUT = 8000;

		
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.app_intro2);
		
			new Handler().postDelayed(new Runnable(){

				@Override
				public void run() {

					Intent myIntent = new Intent(SampleSlider2.this,MainActivity.class);
					myIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					myIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
					myIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
					startActivity(myIntent);
					
				}

		 },SPLASH_TIME_OUT);
	   }
	
}

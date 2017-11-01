package andi.crypto;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity{


	//Splash screen timer
	private static int SPLASH_TIME_OUT = 5000;

	private SharedPreferences dataSave;
	
	@Override
	protected void onCreate(Bundle savedInsatnceState){
		super.onCreate(savedInsatnceState);
		setContentView(R.layout.activity_splash);
		dataSave = getSharedPreferences("firstLog",0);
		//Delay for 5 seconds before going to homeScreen 
		new Handler().postDelayed(new Runnable(){

			
			@Override
			public void run() {
				
				if(dataSave.getString("firstTime","").toString().equals("n")){
				Intent I = new Intent(SplashScreen.this,MainActivity.class);
				I.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				I.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
				I.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
				startActivity(I);
					
				}else{
				SharedPreferences.Editor editor = dataSave.edit();
				editor.putString("firstTime", "n");
				editor.commit();
				
				Intent myIntent = new Intent(SplashScreen.this,MyIntro.class);
				startActivity(myIntent);
				
				}
			}
			
			
		},SPLASH_TIME_OUT);
	}
 
}

package andi.crypto;

/**
 * A simple cryptocurrency to currency converter application.
 * @author Noel Eugene k.
 */

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;

public class MainActivity extends Activity {

	     // Declaring our tabs and the corresponding fragments.
			ActionBar.Tab ethTab, bitcoinTab;
			Fragment FragmentTab1 = new FragmentTab1();
			Fragment FragmentTab2 = new FragmentTab2();
		//Our button
			Button aboutBtn;
			boolean exit = false;
			
			@SuppressLint("InlinedApi")
			@Override
			protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);
				
				// Asking for the default ActionBar element that our platform supports.
				ActionBar actionBar = getActionBar();
				 
		        // Screen handling while hiding ActionBar icon.
		        actionBar.setDisplayShowHomeEnabled(false);
		 
		        // Screen handling while hiding Actionbar title.
		        actionBar.setDisplayShowTitleEnabled(false);
		 
		        // Creating ActionBar tabs.
		        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		 
		        // Setting custom tab icons.
		        ethTab = actionBar.newTab().setIcon(R.drawable.eth);
		        bitcoinTab = actionBar.newTab().setIcon(R.drawable.bitcoin);
		      
		        
		        // Setting tab listeners.
		        ethTab.setTabListener(new TabListener(FragmentTab1));
		        bitcoinTab.setTabListener(new TabListener(FragmentTab2));
		      
		        
		        // Adding tabs to the ActionBar.
		        actionBar.addTab(ethTab);
		        actionBar.addTab(bitcoinTab);
		        
		        // Button 
		        aboutBtn = (Button)findViewById(R.id.aboutBtn);
		        
		        aboutBtn.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						Intent i = new Intent(MainActivity.this,AndiInfo.class);
						startActivity(i);
					}
				});
			} 
			
			@Override
			 public void onBackPressed(){
				 super.onBackPressed();
				 if(exit){
				 System.exit(-1);
				 finish();
				 }else{
					 Toast.makeText(getApplicationContext(),"press back again to exit",Toast.LENGTH_SHORT).show();
					 exit=true;
					 
					 new Handler().postDelayed(new Runnable(){

						@Override
						public void run() {
							exit = false;
						}
						 
					 },3000);
				 }
			 }
}

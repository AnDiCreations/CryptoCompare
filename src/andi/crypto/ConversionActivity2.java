package andi.crypto;

import com.apptakk.HttpRequest;
import com.apptakk.HttpRequestTask;
import com.apptakk.HttpResponse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class ConversionActivity2 extends Activity{
	
	//Copy and Paste of ConversionActivity
	
	 String BASE_CURRENCY = "BTC";
	 String QUOTE_CURRENCY;
	    
	 EditText base,quote;
	 String results,holder;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conversion2);
		
		Intent i = getIntent();
	    QUOTE_CURRENCY = i.getStringExtra("myInfo");
	    
	    base =(EditText)findViewById(R.id.editText3);
	    quote=(EditText)findViewById(R.id.editText4);
	    
	    
	    base.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable s) {
			}

			@Override
			public void beforeTextChanged(CharSequence s, int p1,
					int p2, int p3) {
			}

			@Override
			public void onTextChanged(CharSequence s, int p1, int p2,
					int p3) {
				
				String URL = "https://min-api.cryptocompare.com/data/price?fsym="+BASE_CURRENCY+"&tsyms="+base.getText().toString()+","+QUOTE_CURRENCY;
				
				new HttpRequestTask(
	                    new HttpRequest(URL, HttpRequest.POST, "{ \"currency\": \"value\" }"),
	                    new HttpRequest.Handler() {

							@Override
							public void response(HttpResponse response) {
								 if (response.code == 200) {
		                               results = response.body.replaceAll("\"", "")
		                                        .replace("{", "").replace("}", "").split(":")[1];
		                                
		                                if(base.getText().length()==0) {
		                                    quote.setText(" " + results);
		                                }else if(base.getText().length()>0){
		                                    float initialResult = Float.parseFloat(String.valueOf(results));
		                                    float convertedResult = initialResult * Float.parseFloat(String.valueOf(base.getText()));

		                                    quote.setText(" " + convertedResult);
		                                }

		                            } else {
		                                Toast.makeText(getApplicationContext(), "Error, check your internet connection!", Toast.LENGTH_LONG).show();
		                             
		                            }
		                        }
								
	                    }).execute();
			}
	    	
	    });
	    
	}
}


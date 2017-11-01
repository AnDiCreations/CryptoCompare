package andi.crypto;
/**
 * @author Noel Eugene K
 */
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

public class ConversionActivity extends Activity{
	
	
    private String BASE_CURRENCY = "ETH"; // This activity is dedicated to ETH thats why its hard coded.It wont change.
    private String QUOTE_CURRENCY; // This is a  holder for the world currency chosen by the user.
    
    private EditText base,quote; // Declaration of our Input fields . Although the second is used for displaying the results.
    private String results; 
	 
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conversion);
		
		//Initialization
	    Intent i = getIntent();
	    QUOTE_CURRENCY = i.getStringExtra("myInfo");
	    
	    base =(EditText)findViewById(R.id.editText1);
	    quote=(EditText)findViewById(R.id.editText2);
	    
	    // Adding a listener to detect when text is being input.
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
				//Our URL to the public api where we will get the exchange.We add both the figured quoted and the currency chosen.
				
				String URL = "https://min-api.cryptocompare.com/data/price?fsym="+BASE_CURRENCY+"&tsyms="+base.getText().toString()+","+QUOTE_CURRENCY;
				
				new HttpRequestTask(
	                    new HttpRequest(URL, HttpRequest.POST, "{ \"currency\": \"value\" }"),
	                    new HttpRequest.Handler() {

							@Override
							public void response(HttpResponse response) {
								//if response equals 200 then everything is fine.Less than 100 means problems.
								 if (response.code == 200) {
		                               results = response.body.replaceAll("\"", "")
		                                        .replace("{", "").replace("}", "").split(":")[1];
		                                
		                                if(base.getText().length()==0) {
		                                    quote.setText(" " + results);
		                                }else if(base.getText().length()>0){
		                                	//Parse the results obtained
		                                    float initialResult = Float.parseFloat(String.valueOf(results));
		                                    float convertedResult = initialResult * Float.parseFloat(String.valueOf(base.getText()));
                                          
		                                    //Displaying the results
		                                    quote.setText(" " + convertedResult);
		                                }

		                            } else {
		                            	//Pop a error message if there is no Internet connection on the device.
		                                Toast.makeText(getApplicationContext(), "Error, check your internet connection!", Toast.LENGTH_LONG).show();
		                             
		                            }
		                        }
						//run		
	                    }).execute();
			}
	    	
	    });
	    
	}

}

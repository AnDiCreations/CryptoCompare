package andi.crypto;
/**
 * 
 * @author Noel Eugene K.
 */
import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.app.Fragment;
import android.content.Intent;

public class FragmentTab1 extends Fragment {

	//Declaration of button,spinner,list.
   private  Button ethAdd;
   private  Spinner spinner1;
   private ListView listView;
	
   private View rootView; // Required as this is a fragment and not an Activity.
   private String[]currencies; //We store the 20 possible conversions in a String array(Currencies)
	
   private ArrayList<String>list = new ArrayList<String>();
   private ArrayAdapter<String> adapter,adapter2; //Adapters for our list and Spinner.
   private String input; // Where we will store the selected currency.
  
   
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragmenttab1, container, false);
        
        //Our Currencies if you wish you can add more.
        currencies = new String[]{"KSH","USD","TZS","GBP","NGN","AUD","CAD",
        		"JPY","NZD","KRW","EUR","DKK","CZK","ILS","IDR","HKD","MXN",
        		"MYR","BRL","HUF"};
        
        //Initialization
        ethAdd =(Button)rootView.findViewById(R.id.ethAdd);
        spinner1 =(Spinner)rootView.findViewById(R.id.spinner1);
        listView =(ListView)rootView.findViewById(R.id.card);
        
        adapter = new ArrayAdapter<String>(rootView.getContext(),R.layout.spinner_item,currencies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);//assigning our spinner adapter
        
        adapter2 = new ArrayAdapter<String>(rootView.getContext(),R.layout.custom_list,list);
        listView.setAdapter(adapter2);//assigning our list adapter
      
        //Our spinner listener allows us to Know which currency is selected by the user.
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long Id) {
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
				
			}
		});
        //Our button listener
        ethAdd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				//We get the item selected
			    input = spinner1.getSelectedItem().toString();
			    //As long as the length is greater > than 0 is entered .As long as nothing is not selected.
			    if(input.length() > 0){
			    	//Check if item already exists
			    if(!(list.indexOf(input)>-1))
			    	adapter2.add(input);
			       }else{
			    	Toast.makeText(getActivity(),"Card has already been created!", Toast.LENGTH_SHORT).show();
			    
			       }
			}
		});
        
        //Our list listener hence our items in the list becomes clickable.
        listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position,long id) {
		//Intents.If a card is clicked we take the user to the conversionScreen.		            
				Intent i = new Intent(getActivity(),ConversionActivity.class);
				i.putExtra("myInfo",input);
				startActivity(i);
			}
        });
        
        
        return rootView;
  
    }

}


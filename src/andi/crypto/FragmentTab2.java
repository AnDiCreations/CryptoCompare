package andi.crypto;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Fragment;
import android.content.Intent;

public class FragmentTab2 extends Fragment {
	
	//Copy and paste of FragmentTab1
	
	    Button bitcoinAdd;
	    Spinner spinner2;
	    ListView listView;
		
		View rootView;
		String[]currencies;
		
		ArrayList<String>list2 = new ArrayList<String>();
		ArrayAdapter<String> adapter,adapter2;
		
		String input2;
		
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragmenttab2, container, false);
        
        currencies = new String[]{"KSH","USD","TZS","GBP","NGN","AUD","CAD",
        		"JPY","NZD","KRW","EUR","DKK","CZK","ILS","IDR","HKD","MXN",
        		"MYR","BRL","HUF"};
        
        bitcoinAdd =(Button)rootView.findViewById(R.id.bitcoinAdd);
        spinner2 =(Spinner)rootView.findViewById(R.id.spinner2);
        listView =(ListView)rootView.findViewById(R.id.card2);
        
        
        adapter = new ArrayAdapter<String>(rootView.getContext(),R.layout.spinner_item,currencies);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        adapter2 = new ArrayAdapter<String>(rootView.getContext(),R.layout.custom_list,list2);
        listView.setAdapter(adapter2);
        
        spinner2.setAdapter(adapter);
        
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long Id) {
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				
				
			}
		});
        
        bitcoinAdd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				 input2 = spinner2.getSelectedItem().toString();
				    if(input2.length() > 0){
				    	if(!(list2.indexOf(input2)>-1))
					    	adapter2.add(input2);
					       }else{
					    	Toast.makeText(getActivity(),"Card has already been created!", Toast.LENGTH_SHORT).show();
					       }
				    }
			
		});
        
        listView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position,long id) {
	            
					Intent i = new Intent(getActivity(),ConversionActivity2.class);
					startActivity(i);            
				
			}
        });
        
       
        
        return rootView;
    }
 
}
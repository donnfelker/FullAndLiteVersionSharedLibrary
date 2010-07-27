package com.example.foolibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static final int FULL_VERSION_REQUIRED = 1; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button feature1 = (Button)findViewById(R.id.feature1Button); 
        feature1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "This is feature 1", Toast.LENGTH_SHORT).show(); 
			}
		});
        
        Button feature2 = (Button)findViewById(R.id.feature2Button); 
        feature2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(isLiteVersion()) {
					showDialog(FULL_VERSION_REQUIRED); 
				} else {
					Toast.makeText(MainActivity.this, "This is feature 2!", Toast.LENGTH_SHORT).show();
				}
			}
		});
        
        
    }
    
    @Override
    protected Dialog onCreateDialog(int id) {
    	switch(id) {
    		case FULL_VERSION_REQUIRED: 
	    		return new AlertDialog.Builder(MainActivity.this)
	    		.setIcon(android.R.drawable.ic_dialog_alert)
	    		.setTitle("Full Version Required")
	    		.setPositiveButton(R.string.buy	, new DialogInterface.OnClickListener() {
	    			public void onClick(DialogInterface dialog, int whichButton) {
	    				Toast.makeText(MainActivity.this, "Replace this toast with an intent to start the android market to buy your full version.", Toast.LENGTH_SHORT).show(); 
	    			} 
	    		}) 
	    		.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() 
	    		{ 
	    			public void onClick(DialogInterface dialog, int whichButton) {
	    				dialog.dismiss();
	    			} 
	    		}
	    		).create(); 
    			
    	}
    	return super.onCreateDialog(id);
    }
    
    public boolean isLiteVersion()  {
    	return ((FooLibraryApplication)getApplication()).isLiteVersion(); 
    }
}
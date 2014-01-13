package com.chengxu.tipcal;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculation);
        Log.d("DEBUG", "onCreate was just called!");
    }
    
    protected void onResume() {
       super.onResume();
       Log.d("DEBUG", "onResume was just called!");
    }

    protected void onPause() {
       super.onPause();
       Log.d("DEBUG", "onPause was just called!");
    }
    
    public void calculateTip(View v) {
    	float tip;
    	float cost=0;
    	
    	//fetch percentage 
        String percentageString = v.getTag().toString(); 
        Log.d("DEBUG", "percentage is "+percentageString );
        int percentage= Integer.parseInt(percentageString);
        
        //fetch cost 
        EditText etAmount   = (EditText)findViewById(R.id.etEnterAmount);
        String costString = etAmount.getText().toString();

        try{
        	cost = Float.parseFloat(costString);
        } catch (NumberFormatException e) {
        	// e.printStackTrace();
        	cost = 0; 	
        }
//        Log.d("DEBUG", "cost is "+Float.toString(cost) );
        	
        //change display
        tip = (float) (cost*percentage/100.0);         
        TextView tv = (TextView)findViewById(R.id.tvTipAmount);
        tv.setText(percentageString + "% tip is $"+ Float.toString(tip));
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculation, menu);
        return true;
    }
    
}

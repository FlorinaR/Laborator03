package ro.pub.cs.systems.pdsd.lab03.phonedialer;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;


public class PhoneDialerActivity extends Activity {
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        //change the orientation 
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
    	int[] buttonIds = {R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn4,
    		R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10, R.id.btn11};
    	final EditText phoneNumber = (EditText)findViewById(R.id.editText1);
 
    	for(int i = 0; i <  buttonIds.length; i++) {
    		final Button btn = (Button)findViewById(buttonIds[i]);
    		
    		btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String number = btn.getText().toString();
					phoneNumber.setText(phoneNumber.getText().toString() + number);
					/* Place the cursor in the end of EditText */
			    	phoneNumber.setSelection(phoneNumber.length(), phoneNumber.length());
				}
			});
    	}
    	/* Backspace functionality */
    	final ImageButton backspace_btn = (ImageButton)findViewById(R.id.backspace);
    	if(phoneNumber.getText().toString() != " ") {
    		backspace_btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					String number = phoneNumber.getText().toString();
					if(number.length() > 0) {
						number = number.substring(0, number.length() - 1);
						phoneNumber.setText(number);
						/* Place the cursor in the end of EditText */
				    	phoneNumber.setSelection(phoneNumber.length(), phoneNumber.length());
					}
				}
			});
    		
    	}
    	
    	/* Call functionality */
    	ImageButton call_btn = (ImageButton) findViewById(R.id.call);
    	if (phoneNumber.getText().toString() != " ") {
    		call_btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(Intent.ACTION_CALL);
					intent.setData(Uri.parse("tel:"+ phoneNumber));
					startActivity(intent);
				}
			});
    	}
    	
    	/* Hang-up functionality */
    	ImageButton hangup_btn = (ImageButton) findViewById(R.id.hangup);
    	if (phoneNumber.getText().toString() != " ") {
    		hangup_btn.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
    	}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.phone_dialer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    
}

package stephen.woods.bscproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
/*
 *  Email.java
 * 
 *  Rev 1
 *
 *  25/2/2013

 * @author Stephen Woods, 09104232
 *
 */
public class Email extends Activity{
	
   	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.match_report); 
		
		// link buttons & EditText
		final Button btnsend = (Button) findViewById(R.id.send_button);
    	final EditText email = (EditText) findViewById(R.id.email_entry);
    	    	
        btnsend.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            	email.setText(email.getText().toString().trim());
            	// no text entered
            	if(email.getText().toString().equals(""))
            	{
            		Toast.makeText(getBaseContext(), "Please enter text ", Toast.LENGTH_LONG).show();
            	}
            	// text entered
            	else
            	{
                    sendEmail(email.getText().toString());
            	}
            }
         });    	
			
   	}
   	//send e-amil
   	public void sendEmail(String strEmail){
		
		String strDetailMsg = "";
       	strDetailMsg = strEmail;
       	
       	Intent sendIntent = new Intent(Intent.ACTION_SEND);
  	    sendIntent.putExtra(Intent.EXTRA_TEXT, strDetailMsg);           
        sendIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"woodsie316@hotmail.com"});        
	    sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Match Report for: ");  
	    sendIntent.setType("text/plain"); 
	    startActivity(Intent.createChooser(sendIntent, "Send Mail")); 
   	}
}

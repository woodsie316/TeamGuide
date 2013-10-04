package stephen.woods.bscproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
 *  RefOptions.java
 * 
 *  Rev 2
 *
 *  04/2/2013

 * @author Stephen Woods, 09104232
 *
 */
public class RefOptions extends Activity{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ref_options);
		        
    	// link buttons
    	final Button btnEmail = (Button) findViewById(R.id.send_report_button);
    	final Button btnPassword = (Button) findViewById(R.id.change_password_button);
    	
    	//create OnClickListener
        btnEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
           	  
            	sendEmail();
            }
         });
        
        //create OnClickListener
        btnPassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            	
            	changePassword();

            }
         });
    	
	} 
	//This is what the button will do when clicked
	public void sendEmail()
	{
		
		Intent sendEmail = new Intent(this, Email.class);
		startActivity(sendEmail);	
		
	}
	//This is what the button will do when clicked
	public void changePassword()
	{
		
		Intent changePassword = new Intent(this, ChangePassword.class);
		startActivity(changePassword);	
		
	}
		
}

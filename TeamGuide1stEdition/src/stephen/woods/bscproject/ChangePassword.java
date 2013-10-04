package stephen.woods.bscproject;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
 *  ChangePassword.java
 * 
 *  Rev 3
 *
 *  17/2/2013

 * @author Stephen Woods, 09104232
 *
 */
public class ChangePassword extends Activity{

	ArrayList<String> strArrayPassword = new ArrayList();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.change_password);
		
		// link buttons & EditText
		final Button buttonChange = (Button) findViewById(R.id.change_button);		
		final EditText editOld = (EditText) findViewById(R.id.text_old);
		final EditText editNew1 = (EditText) findViewById(R.id.text_new1);
		final EditText editNew2 = (EditText) findViewById(R.id.text_new2);
		
        buttonChange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            	
            	//enter passwords
            	editOld.setText(editOld.getText().toString().trim());
            	editNew1.setText(editNew1.getText().toString().trim());
            	editNew2.setText(editNew2.getText().toString().trim());
            	
            	// update if new is confirmed
            	if (editNew1.getText().toString().equals(editNew2.getText().toString()))
            	{
            		updatePassword(editOld.getText().toString(), editNew1.getText().toString());	
            	}
            	// if new and confirmed do not match
            	else
            	{
            		Toast.makeText(getBaseContext(), "New Password does not match", Toast.LENGTH_LONG).show();
            	}
            	
            	    

            }
         });
		


		
	} 
	// update password
	public void updatePassword(String strOld, String strNew1)
	{
		ReadWritePrefs rwPrefs = new ReadWritePrefs();
		String strUsername = rwPrefs.readWriteUserSetting(ChangePassword.this, "Read", "Username", ""); 
		String strPassword = rwPrefs.readWriteUserSetting(ChangePassword.this, "Read", "Password", ""); 

		// if old password = password currently held then change
        if(strOld.toString().equals(strPassword))
        {
            DatabaseHelper myDbHelper = new DatabaseHelper(ChangePassword.this); 	    	
            myDbHelper.openDataBase();
            myDbHelper.UpdateRecord("Login", "password = '" + strNew1.toString() + "'", "Where username='" + strUsername.toString() + "'");            
            myDbHelper.close();
            Toast.makeText(getBaseContext(), "Password change sucessful", Toast.LENGTH_LONG).show();
            final EditText editOld = (EditText) findViewById(R.id.text_old);
            editOld.setText("");
    		final EditText editNew1 = (EditText) findViewById(R.id.text_new1);
    		editNew1.setText("");
    		final EditText editNew2 = (EditText) findViewById(R.id.text_new2);
    		editNew2.setText("");
        }
        else
        {
        	Toast.makeText(getBaseContext(), "Incorrect Password", Toast.LENGTH_LONG).show();
        }
		
	}
	
} 

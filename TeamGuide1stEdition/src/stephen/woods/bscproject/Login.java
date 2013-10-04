package stephen.woods.bscproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
 *  Login.java
 * 
 *  Rev 2
 *
 *  31/1/2013

 * @author Stephen Woods, 09104232
 *
 */
public class Login extends Activity{
	
	ArrayList<String> strArrayAnswer = new ArrayList();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		
		//  load the database
        DatabaseHelper myDbHelper = new DatabaseHelper(this);
        
        try {
        	 
        	myDbHelper.createDataBase();
        	myDbHelper.close();
        } catch (IOException ioe) {
        	//throw new Error("Unable to create database");
        }

        myDbHelper.close();
		
        
        // link buttons & EditText
    	final EditText txtUser = (EditText) findViewById(R.id.editText_user);
    	final EditText txtPsswd = (EditText) findViewById(R.id.editText_password);
    	final Button btnLogin = (Button) findViewById(R.id.login_button);
    	final Button btnHelp = (Button) findViewById(R.id.help_button);
    	
    	//check if a username has been entered
        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

            	txtUser.setText(txtUser.getText().toString().trim());
            	txtPsswd.setText(txtPsswd.getText().toString().trim());
            	// if no username display error
            	if(txtUser.getText().toString().equals(""))
            	{
            		Toast.makeText(getBaseContext(), "Please neter a valid username", Toast.LENGTH_LONG).show();
            	}
            	// if no username display error
            	else if(txtPsswd.getText().toString().equals("")){
            		Toast.makeText(getBaseContext(), "Please neter a valid password", Toast.LENGTH_LONG).show();
            	}
            	// if email entered send to check
            	else{
            	checkLogin(txtUser.getText().toString(), txtPsswd.getText().toString());    
            	}
            }
         });
        // Help button listener
        btnHelp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            	
            	openHelp();

            }
         });
    	
	} 
	// do if help button was pressed
	public void openHelp()
	{
		Intent iMain = new Intent(this, Help.class);
		startActivity(iMain);
	}
	

	//check if username & password are correct
	public void checkLogin(String strUsername, String strPassword )
	{
						
        String strTable = "Login";
        String strFields = "password";
        String strWhere = "username = '" + strUsername + "'";
        String strOrder = "";

        DatabaseHelper myDbHelper = new DatabaseHelper(Login.this);
        myDbHelper.openDataBase();       
        List<String> questionAnswer = myDbHelper.select(strTable, strFields, strWhere, strOrder);
        myDbHelper.close();
        strArrayAnswer = (ArrayList<String>) questionAnswer;
        
        
        //if correct
        if(strArrayAnswer.get(0).toString().equals(strPassword))
        {
        	
        	
    		ReadWritePrefs rwPrefs = new ReadWritePrefs();
    		rwPrefs.readWriteUserSetting(this, "Write", "Username" , strUsername.toString() );
    		rwPrefs.readWriteUserSetting(this, "Write", "Password" , strPassword.toString() );
        	   		
    		Intent iMain = new Intent(this, RefOptions.class);
    			startActivity(iMain);	
        }
        //if not correct
        else
        {
        	Toast.makeText(getBaseContext(), "Incorrect Username / Password combination", Toast.LENGTH_LONG).show();
        }
	
    	
	} 
	
}
	
	
	






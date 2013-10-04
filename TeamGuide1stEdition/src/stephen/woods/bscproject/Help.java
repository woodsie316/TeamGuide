package stephen.woods.bscproject;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
 *  Help.java
 * 
 *  Rev 4
 *
 *  11/2/2013

 * @author Stephen Woods, 09104232
 *
 */
public class Help extends Activity{

	
    String gStrReturnedAnswer;
    String gStrReturnedPassword;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.help);
    	

    	// link buttons & EditText
    	final Button btnVerify = (Button) findViewById(R.id.verify_button);
    	final EditText edtEmail = (EditText) findViewById(R.id.edtEmailAddress);
    	final EditText edtAnswer = (EditText) findViewById(R.id.edtAnswer);
    	final Button btnOK = (Button) findViewById(R.id.btnOK);
    	
    	   	
    	//check if an email has been entered
        btnVerify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            	edtEmail.setText(edtEmail.getText().toString().trim());
            	// if no email display error
            	if(edtEmail.getText().toString().equals(""))
            	{
            		Toast.makeText(getBaseContext(), "Please neter a valid email address", Toast.LENGTH_LONG).show();
            	}
            	// if email entered send to check
            	else
            	{
                    checkEmail(edtEmail.getText().toString());
            	}
            }
         });
        //check if an answer has been entered
        btnOK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
            	edtAnswer.setText(edtAnswer.getText().toString().trim());
            	// if no answer display error
            	if(edtAnswer.getText().toString().equals(""))
            	{
            		Toast.makeText(getBaseContext(), "Please enter a valid answer", Toast.LENGTH_LONG).show();
            	}
            	// if answer entered send to check
            	else
            	{
                    checkAnswer(edtAnswer.getText().toString());
            	}
            }
         }); 
		
	} 
	// check if email is correct
	public void checkEmail(String strEmail)
	{
		ArrayList<String> strArrayAnswer = new ArrayList();
		
        String strTable = "Login";
        String strFields = "question,answer,password";
        String strWhere = "email = '" + strEmail + "'";
        String strOrder = "";

        DatabaseHelper myDbHelper = new DatabaseHelper(Help.this);
        myDbHelper.openDataBase();       
        List<String> questionAnswer = myDbHelper.select(strTable, strFields, strWhere, strOrder);
        myDbHelper.close();
        strArrayAnswer = (ArrayList<String>) questionAnswer;
        
               
        if (!strArrayAnswer.get(0).toString().equals(""))
        {
        	final TextView txtQ = (TextView) findViewById(R.id.txtQuestion);
        	txtQ.setText(strArrayAnswer.get(0).toString());
        	txtQ.setVisibility(View.VISIBLE);
        	
        	final EditText edtAnswer = (EditText) findViewById(R.id.edtAnswer);
        	edtAnswer.setVisibility(View.VISIBLE);

        	final Button btnOK = (Button) findViewById(R.id.btnOK);
        	btnOK.setVisibility(View.VISIBLE);
        	
            gStrReturnedAnswer = strArrayAnswer.get(1).toString();
            gStrReturnedPassword = strArrayAnswer.get(2).toString();

        }
        else
        {
        	Toast.makeText(getBaseContext(), "Incorrect Username / Password combination", Toast.LENGTH_LONG).show();
        }
        
	}
	
	// check if answer is correct
	public void checkAnswer(String strAnswer)
	{
    	if(strAnswer.equals(gStrReturnedAnswer))
    	{
    		showPassword();
    	}
    	else
    	{
    		Toast.makeText(getBaseContext(), "Invalid Answer", Toast.LENGTH_LONG).show();
    	}
    	
	}
	
	// only show Password. Hide everything else
	public void showPassword()
	{
    	final Button btnVerify = (Button) findViewById(R.id.verify_button);
    	btnVerify.setVisibility(View.INVISIBLE);    	
    	final EditText edtEmail = (EditText) findViewById(R.id.edtEmailAddress);
    	edtEmail.setVisibility(View.INVISIBLE);
    	final EditText edtAnswer = (EditText) findViewById(R.id.edtAnswer);
    	edtAnswer.setVisibility(View.INVISIBLE);
    	final Button btnOK = (Button) findViewById(R.id.btnOK);
    	btnOK.setVisibility(View.INVISIBLE);
    	final TextView txtQuestion = (TextView) findViewById(R.id.txtQuestion);
    	txtQuestion.setVisibility(View.INVISIBLE);
    	final TextView txtEmail = (TextView) findViewById(R.id.txtMessage2);
    	txtEmail.setVisibility(View.INVISIBLE);
    	final TextView txtTitle = (TextView) findViewById(R.id.txtMessage1);
    	txtTitle.setText("Your password is: " + gStrReturnedPassword);
    	
	}
	
	
} 

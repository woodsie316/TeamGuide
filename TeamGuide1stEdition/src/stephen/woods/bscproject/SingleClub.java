package stephen.woods.bscproject;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

/*
 *  SingleClub.java
 * 
 *  Rev 4
 *
 *  10/5/2013

 * @author Stephen Woods, 09104232
 *
 */
public class SingleClub extends Activity implements OnClickListener{
	
	//creates global string
	String gStrLong = "";
	String gStrLat = "";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.single_club_view);
        
        //create TextView
        TextView txtClub = (TextView) findViewById(R.id.club_label);
        
        Intent i = getIntent();
        // get attached intent data
        String club = i.getStringExtra("clubs");
        
        // displaying selected club name
        txtClub.setText(club);
        
        // create string holders
        String strColour = "";
        String strContact = "";
        String strContactNumber = "";
        String strLocation = "";
        
        //Fetch data from SelectedClub in ClubsListFromDatastore.java and populate String
        try{
        	JSONObject clubObject = new JSONObject(i.getStringExtra("SelectedClub"));
        		strColour = clubObject.getString("clubColour").toString();
        		strContact = clubObject.getString("contactName").toString();
        		strContactNumber = clubObject.getString("contactNum").toString();
        		strLocation = clubObject.getString("location").toString();
        		gStrLong = clubObject.getString("longitude").toString();
        		gStrLat = clubObject.getString("latitude").toString();
        		
        }
        //Display error
        catch (JSONException e){
        	Toast.makeText(getBaseContext(), "Please make sure you have internet access", Toast.LENGTH_LONG).show();
        		e.printStackTrace();
        }
        
        // populate TextViews
        TextView txtColour = (TextView) findViewById(R.id.club_colour_label);
        txtColour.setText("Team Colours: " +strColour);
        TextView txtContactName = (TextView) findViewById(R.id.club_contact_name_label);
        txtContactName.setText("Contact Name: " + strContact);
        TextView txtContactNumber = (TextView) findViewById(R.id.club_contact_number_label);
        txtContactNumber.setText("Contact Number: " + strContactNumber);
        TextView txtClubLocation = (TextView) findViewById(R.id.club_location_label);
        txtClubLocation.setText("Club Location: " + strLocation);
        
        //connect OnClickListener to button             
        View directionsButton = findViewById(R.id.directions_button);
        directionsButton.setOnClickListener(this);
        
               
    }
    //This is what the button will do when clicked   
    public void onClick(View v){
    	switch (v.getId()){
    	case R.id.directions_button: Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://maps.google.com/maps?q=" +  gStrLat + "+++" + gStrLong + ""));
        startActivity(browserIntent);
      	break;
    	
    	
    	}
	}
    
}

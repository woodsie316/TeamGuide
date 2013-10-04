package stephen.woods.bscproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/*
 *  TeamGuide.java
 * 
 *  Rev 4
 *
 *  02/05/2013
 *	
 * @reference https://developers.google.com/eclipse/docs/endpoints-addentities
 * @author Stephen Woods, 09104232
 *
 */

public class TeamGuide extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /**
         * @reference https://developers.google.com/eclipse/docs/endpoints-addentities
         	*/
        
        // call AsyncTask
        //new EndpointsTask().execute(getApplicationContext());
        
        
        /**
    	* @author Stephen Woods, 09104232
     	*/
     
        //connect OnClickListener to button	 
        View ddslButton = findViewById(R.id.ddsl_button);
        ddslButton.setOnClickListener(this);
        View sdflButton = findViewById(R.id.sdfl_button);
        sdflButton.setOnClickListener(this);
        View ndslButton = findViewById(R.id.ndsl_button);
        ndslButton.setOnClickListener(this);
        View refereeButton = findViewById(R.id.referee_button);
        refereeButton.setOnClickListener(this);
                
       }
    
    /**
    * @reference https://developers.google.com/eclipse/docs/endpoints-addentities
    	*/

    // Adding a club to the datastore
   /* public class EndpointsTask extends AsyncTask<Context, Integer, Long> {
        protected Long doInBackground(Context... contexts) {

          Clubendpoint.Builder endpointBuilder = new Clubendpoint.Builder(
              AndroidHttp.newCompatibleTransport(),
              new JacksonFactory(),
              new HttpRequestInitializer() {
              public void initialize(HttpRequest httpRequest) { 
            	  
              }
              });
      Clubendpoint endpoint = CloudEndpointUtils.updateBuilder(
      endpointBuilder).build();
      
      try {
          Club club = new Club().setClubName("AFC Belgrave");
          club.setClubColour("Blue & Black Stripes");
          club.setLocation("Bluebell Road");
          club.setLatitude(53.332949);
          club.setLongitude(-6.335163);
          club.setId("AFCBEL");
          club.setContactName("Colm Cannon");
          club.setContactNum("0868350416");
          Club result = endpoint.insertClub(club).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
          return (long) 0;
        }
    }*/
    
    /**
	* @author Stephen Woods, 09104232
 	*/    
    //This is what the button will do when clicked
    public void onClick(View v){
    	switch (v.getId()){
    	case R.id.ddsl_button: Intent ddsl = new Intent(this, Ddsl.class);
    	startActivity(ddsl);
    	break;
    	case R.id.sdfl_button: Intent sdfl = new Intent(this, Sdfl.class);
    	startActivity(sdfl);
    	break;
    	case R.id.ndsl_button: Intent ndsl = new Intent(this, Ndsl.class);
    	startActivity(ndsl);
    	break;
    	case R.id.referee_button: Intent ref = new Intent(this, Login.class);
    	startActivity(ref);
    	break;
    	}
    }
}
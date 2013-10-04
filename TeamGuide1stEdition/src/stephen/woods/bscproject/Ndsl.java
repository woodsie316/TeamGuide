package stephen.woods.bscproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/*
 *  Ndsl.java
 * 
 *  Rev 2
 *
 *  16/4/2013

 * @author Stephen Woods, 09104232
 *
 */
public class Ndsl extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ndsl);
		
		//connect OnClickListener to button
		View clubsButton = findViewById(R.id.clubs_button);
        clubsButton.setOnClickListener(this);
        View ndsl_table_button = findViewById(R.id.ndsl_table_button);
        ndsl_table_button.setOnClickListener(this);
        View ndsl_fixtures_button = findViewById(R.id.ndsl_fixtures_button);
        ndsl_fixtures_button.setOnClickListener(this);
        View ndsl_results_button = findViewById(R.id.ndsl_results_button);
        ndsl_results_button.setOnClickListener(this);
        View ndsl_referees_button = findViewById(R.id.ndsl_referee_button);
        ndsl_referees_button.setOnClickListener(this);
        
        
	}
	//This is what the button will do when clicked
	public void onClick(View v){
    	switch (v.getId()){
    	case R.id.clubs_button: Intent clubs = new Intent(this, ClubsListFromDatastore.class);
    	startActivity(clubs);
    	break;
    	case R.id.ndsl_table_button: Intent ndsl_tables = new Intent(this, NdslTables.class);
    	startActivity(ndsl_tables);
    	break;
    	case R.id.ndsl_fixtures_button: Intent ndsl_fixtures = new Intent(this, NdslFixtures.class);
    	startActivity(ndsl_fixtures);
    	break;
    	case R.id.ndsl_results_button: Intent ndsl_results = new Intent ("android.intent.action.VIEW",
    			Uri.parse("http://www.ndsl.ie/"));
    	startActivity(ndsl_results);
    	break;
    	case R.id.ndsl_referee_button: Intent ndsl_referees = new Intent ("android.intent.action.VIEW",
    			Uri.parse("http://www.ndsl.ie/downloads/05_referees_list.pdf"));
    	startActivity(ndsl_referees);
    	break;
    	
    	}
	}
}

package stephen.woods.bscproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/*
 *  Ddsl.java
 * 
 *  Rev 2
 *
 *  16/4/2013

 * @author Stephen Woods, 09104232
 *
 */
public class Ddsl extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ddsl);
		
		//connect OnClickListener to button
		View clubsButton = findViewById(R.id.clubs_button);
        clubsButton.setOnClickListener(this);
        View ddsl_table_button = findViewById(R.id.ddsl_table_fixtures_results_button);
        ddsl_table_button.setOnClickListener(this);
        View ddsl_referees_button = findViewById(R.id.ddsl_referee_button);
        ddsl_referees_button.setOnClickListener(this);
        
	}
	
	//This is what the button will do when clicked
	public void onClick(View v){
    	switch (v.getId()){
    	case R.id.clubs_button: Intent clubs = new Intent(this, ClubsListFromDatastore.class);
    	startActivity(clubs);
    	break;
    	case R.id.ddsl_table_fixtures_results_button: Intent ddslTFR = new Intent(this, DdslTablesFixturesResults.class);
    	startActivity(ddslTFR);
    	break;
    	case R.id.ddsl_referee_button: Intent ddsl_referees = new Intent ("android.intent.action.VIEW",
    			Uri.parse("http://www.ddsl.ie/attachments/article/626/New%20Ref%20List%20for%20Dropdown.doc"));
    	startActivity(ddsl_referees);
    	break;
    	
    	}
	}
}

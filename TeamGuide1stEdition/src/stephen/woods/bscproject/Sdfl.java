package stephen.woods.bscproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/*
 *  Sdfl.java
 * 
 *  Rev 2
 *
 *  16/4/2013

 * @author Stephen Woods, 09104232
 *
 */
public class Sdfl extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sdfl);
		
		//connect OnClickListener to button
		View clubsButton = findViewById(R.id.clubs_button);
        clubsButton.setOnClickListener(this);
        View tablesButton = findViewById(R.id.sdfl_table_button);
        tablesButton.setOnClickListener(this);
        View fixturesButton = findViewById(R.id.sdfl_fixtures_button);
        fixturesButton.setOnClickListener(this);
        View resultsButton = findViewById(R.id.sdfl_results_button);
        resultsButton.setOnClickListener(this);
        View refereeButton = findViewById(R.id.sdfl_referee_button);
        refereeButton.setOnClickListener(this);
	}
	//This is what the button will do when clicked
	public void onClick(View v){
    	switch (v.getId()){
    	case R.id.clubs_button: Intent clubs = new Intent(this, ClubsListFromDatastore.class);
    	startActivity(clubs);
    	break;
    	case R.id.sdfl_table_button: Intent sdfl_table = new Intent ("android.intent.action.VIEW",
    			Uri.parse("http://www.sdflsoccer.com/index.php?option=com_content&view=article&id=73&Itemid=96"));
    	startActivity(sdfl_table);
    	break;
    	case R.id.sdfl_fixtures_button: Intent sdfl_fixtures = new Intent ("android.intent.action.VIEW",
    			Uri.parse("http://www.sdflsoccer.com/index.php?option=com_content&view=article&id=92&Itemid=93"));
    	startActivity(sdfl_fixtures);
    	break;
    	case R.id.sdfl_results_button: Intent sdfl_results = new Intent ("android.intent.action.VIEW",
    			Uri.parse("http://www.sdflsoccer.com/index.php?option=com_content&view=article&id=75&Itemid=94"));
    	startActivity(sdfl_results);
    	break;
    	case R.id.sdfl_referee_button: Intent sdfl_referees = new Intent ("android.intent.action.VIEW",
    			Uri.parse("http://www.sdflsoccer.com/index.php?option=com_content&view=article&id=96&Itemid=99"));
    	startActivity(sdfl_referees);
    	break;
    	}
	}	
}

package stephen.woods.bscproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/*
 *  DdslTablesFixturesResults.java
 * 
 *  Rev 1
 *
 *  18/4/2013

 * @author Stephen Woods, 09104232
 *
 */
public class DdslTablesFixturesResults extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ddsl_tables_fixtures_results);
		
		//connect OnClickListener to button
		View sat_ssg_Button = findViewById(R.id.sat_ssg_button);
			sat_ssg_Button.setOnClickListener(this);
		View sat_11aside_Button = findViewById(R.id.sat_11aside_button);
			sat_11aside_Button.setOnClickListener(this);
		View sun_ssg_Button = findViewById(R.id.sun_ssg_button);
			sun_ssg_Button.setOnClickListener(this);
		View sun_11aside_Button = findViewById(R.id.sun_11aside_button);
			sun_11aside_Button.setOnClickListener(this);
	}
	//This is what the button will do when clicked
	@Override
	public void onClick(View v) {
		switch (v.getId()){
	case R.id.sat_ssg_button: Intent ddsl_sat_ssg = new Intent ("android.intent.action.VIEW",
			Uri.parse("http://scoreweek.com/?p=27"));
	startActivity(ddsl_sat_ssg);
	break;
	case R.id.sat_11aside_button: Intent ddsl_sat_11 = new Intent ("android.intent.action.VIEW",
			Uri.parse("http://scoreweek.com/?p=25"));
	startActivity(ddsl_sat_11);
	break;
	case R.id.sun_ssg_button: Intent ddsl_sun_ssg = new Intent ("android.intent.action.VIEW",
			Uri.parse("http://scoreweek.com/?p=23"));
	startActivity(ddsl_sun_ssg);
	break;
	case R.id.sun_11aside_button: Intent ddsl_sun_11 = new Intent ("android.intent.action.VIEW",
			Uri.parse("http://scoreweek.com/?p=21"));
	startActivity(ddsl_sun_11);
	break;
		}
	}
}
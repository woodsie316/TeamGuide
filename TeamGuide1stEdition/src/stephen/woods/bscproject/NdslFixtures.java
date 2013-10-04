package stephen.woods.bscproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/*
 *  NdslFixtures.java
 * 
 *  Rev 1
 *
 *  18/4/2013

 * @author Stephen Woods, 09104232
 *
 */
public class NdslFixtures extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ndsl_fixtures);
		
		//connect OnClickListener to button
		View ssg_fix_Button = findViewById(R.id.ndsl_ssg_fixtures_button);
			ssg_fix_Button.setOnClickListener(this);
		View elevens_fix_Button = findViewById(R.id.ndsl_11aside_fixtures_button);
			elevens_fix_Button.setOnClickListener(this);
		
	}
	
	//This is what the button will do when clicked
	@Override
	public void onClick(View v) {
		switch (v.getId()){
	case R.id.ndsl_ssg_fixtures_button: Intent ndsl_ssg_fix = new Intent ("android.intent.action.VIEW",
			Uri.parse("http://www.ndsl.ie/downloads/04_ssg_fixtures.pdf"));
	startActivity(ndsl_ssg_fix);
	break;
	case R.id.ndsl_11aside_fixtures_button: Intent ndsl_11_fix = new Intent ("android.intent.action.VIEW",
			Uri.parse("http://www.ndsl.ie/downloads/03_11aside_fixtures.pdf"));
	startActivity(ndsl_11_fix);
	break;
	
		}
	}
}
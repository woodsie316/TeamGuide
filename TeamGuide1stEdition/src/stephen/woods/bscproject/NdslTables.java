package stephen.woods.bscproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

/*
 *  NdslTables.java
 * 
 *  Rev 1
 *
 *  18/4/2013

 * @author Stephen Woods, 09104232
 *
 */
public class NdslTables extends Activity implements OnClickListener{
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ndsl_tables);
		
		//connect OnClickListener to button
		View ssg_Button = findViewById(R.id.ndsl_ssg_table_button);
			ssg_Button.setOnClickListener(this);
		View elevens_Button = findViewById(R.id.ndsl_11aside_table_button);
			elevens_Button.setOnClickListener(this);
		
	}
	
	//This is what the button will do when clicked
	@Override
	public void onClick(View v) {
		switch (v.getId()){
	case R.id.ndsl_ssg_table_button: Intent ndsl_ssg = new Intent ("android.intent.action.VIEW",
			Uri.parse("http://www.a2zsoccer.com/ResultsandFixtures/NDSLSSG.aspx"));
	startActivity(ndsl_ssg);
	break;
	case R.id.ndsl_11aside_table_button: Intent ndsl_11 = new Intent ("android.intent.action.VIEW",
			Uri.parse("http://www.a2zsoccer.com/ResultsandFixtures/NDSL11Aside.aspx"));
	startActivity(ndsl_11);
	break;
	
		}
	}
}
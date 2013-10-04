package stephen.woods.bscproject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import stephen.woods.bscproject.clubendpoint.Clubendpoint;
import stephen.woods.bscproject.clubendpoint.model.Club;
import stephen.woods.bscproject.clubendpoint.model.CollectionResponseClub;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.json.gson.GsonFactory;
import com.google.gson.Gson;

/*
 *  ClubsListFromDatastore.java
 * 
 *  Rev 12
 *
 *  11/05/2013
 *	
 * @reference https://developers.google.com/appengine/docs/java/endpoints/consume_android
 * @author Stephen Woods, 09104232
 *
 */
public class ClubsListFromDatastore extends ListActivity {
	/**
	* @author Stephen Woods, 09104232
 	*/
	
	// Store clubs
	ArrayList<String> serviceClubs = new ArrayList<String>();
	//Store indexes 
	ArrayList<String> serviceClubs2 = new ArrayList<String>();
	//Store all clubs data
	ArrayList<Club>myClubs = new ArrayList<Club>(); 
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Insert and Item
		serviceClubs.add("--CLUBS--");
		
		// Binding serviceClubs ArrayList to ListAdapter
		this.setListAdapter(new ArrayAdapter<String>(this,
				R.layout.club_details, R.id.label,serviceClubs));

		new pullClubsFromServiceTask().execute(getApplicationContext());
		ListView lv = getListView();

		// listening to single list item on click
		lv.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				// selected club
				String club = ((TextView) view).getText().toString();
                
				//where to send data
				Intent i = new Intent(getApplicationContext(), SingleClub.class);
	              // sending data to new activity
	              i.putExtra("clubs", club);
	                            
	              //linking Club name to relivant data
	              String selectedClub = (new Gson()).toJson(myClubs.get(serviceClubs2.indexOf(serviceClubs.get(position))));
	              i.putExtra("SelectedClub", selectedClub);
	              startActivity(i);
			}
		});
	}
	
	/**
     * @reference https://developers.google.com/eclipse/docs/endpoints-addentities
     	*/
	// Thread to pull clubs
	public class pullClubsFromServiceTask extends  
			AsyncTask<Context, Integer, Long> {
		String strError = "";
		ProgressDialog dialog;
		@Override
		
		/**
    	* @author Stephen Woods, 09104232
     	*/
		//Display message before data is retrieved
        protected void onPreExecute() {
            dialog = ProgressDialog.show(ClubsListFromDatastore.this, "Progress", "Fetching Data");
            super.onPreExecute();
        }
		
		/**
         * @reference https://developers.google.com/eclipse/docs/endpoints-addentities
         	*/
		protected Long doInBackground(Context... contexts) {  
			
			
			Clubendpoint.Builder builder = new Clubendpoint.Builder(
					AndroidHttp.newCompatibleTransport(), new GsonFactory(),
					null);

			Clubendpoint service = builder.build();

			try {
				CollectionResponseClub clubendpoint = service.listClub().execute();
				
				/**
		    	* @author Stephen Woods, 09104232
		     	*/
				//Do we have clubs?
				if (clubendpoint.size()>0) { 
					serviceClubs.clear();
					
					// If so add them here
					myClubs.addAll(clubendpoint.getItems());
					for (int iClubCounter = 0; iClubCounter < clubendpoint.getItems().size(); iClubCounter++) {
						serviceClubs.add(clubendpoint.getItems().get(iClubCounter).getClubName());
						serviceClubs2.add(clubendpoint.getItems().get(iClubCounter).getClubName());
						Collections.sort(serviceClubs);	
						
					}
				}
			// Capture an error
			} catch (IOException e) {
				strError = e.getMessage();  
				e.printStackTrace();
			}
			return (long) 0;
		}
		
		//Display error
		@Override
		protected void onPostExecute(Long result) {  
			if (strError.length() > 0) {  
				Toast.makeText(getBaseContext(), "Please make sure you have internet access", Toast.LENGTH_LONG).show();							
			}
			
			// Refresh the listview
			refreshList();  
			super.onPostExecute(result);
			dialog.cancel();
		}

	}

	void refreshList() {
		this.setListAdapter(new ArrayAdapter<String>(this,
				R.layout.club_details, R.id.label, serviceClubs));
	}
}
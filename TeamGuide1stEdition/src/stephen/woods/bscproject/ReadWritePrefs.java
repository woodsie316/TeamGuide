package stephen.woods.bscproject;

import android.content.Context;
import android.content.SharedPreferences;

/*
 *  ReadWritePrefs.java
 * 
 *  Rev 1
 *
 *  08/01/2013

 * @author Stephen Woods, 09104232
 * 
 */
public class ReadWritePrefs {
    public static final String PREFS_NAME = "MyPrefsFile";
    
    public String readWriteUserSetting(Context context,String readWrite, String userOption, String settingValue) {

  	  SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);

        String usersetting = ""; 
        // read settings
        if (readWrite == "Read" )
        {
      	  String strUsersetting = settings.getString(userOption,"");  
      	  usersetting = strUsersetting ;
        } 
          // write settings
        if (readWrite == "Write" )
        {
      	  SharedPreferences.Editor editor = settings.edit();      
      	  editor.putString(userOption,settingValue.toString());      
      
      	  editor.commit();
            usersetting ="Write";
        } 
          
          return usersetting;

    }    
} 
package stephen.woods.bscproject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/*
 *  DatabaseHelper.java
 * 
 *  Rev 3
 *
 *  05/01/2013

 * @author Stephen Woods, 09104232
 * 
 */

public class DatabaseHelper extends SQLiteOpenHelper {
 
	//The Android's default system path of your application database.
    private static String DB_PATH = "/data/data/stephen.woods.bscproject/databases/";
    private static String DB_NAME = "login.sql";
    private static String DB_TABLE = "";
    private SQLiteDatabase myDataBase; 
    private final Context myContext;
  
         
    //Takes and keeps a reference of the passed context in order to access to the application assets and resources.
    public DatabaseHelper(Context context) {
    	super(context, DB_NAME, null, 1);
        this.myContext = context;
    }	
 
  
     //Creates a empty database on the system and rewrites it with your own database.
    public void createDataBase() throws IOException{
 
    	boolean dbExist = checkDataBase();
 
    	if(dbExist){
    		//do nothing - database already exist
    	}else{
    		
        	this.getWritableDatabase(); // .getReadableDatabase();
 
        	try {
 
    			copyDataBase();
 
    		} catch (IOException e) {
 
        		throw new Error("Error copying database");
 
        	}
    	}
 
    }
 
    // Check if the database already exists      
    private boolean checkDataBase(){
    	SQLiteDatabase checkDB = null;
    	try{
    		String myPath = DB_PATH + DB_NAME;
    		
    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    	}catch(SQLiteException e){
    	
    	}
 
    	if(checkDB != null){
    		checkDB.close();
    	}
    	return checkDB != null ? true : false;
    }
 
   // Copies your database from your local assets-folder to the just created empty database in the
   // system folder, from where it can be accessed and handled.
     
    private void copyDataBase() throws IOException{
 
    	//Open your local db as the input stream
    	InputStream myInput = myContext.getAssets().open(DB_NAME);
 
    	// Path to the just created empty db
    	String outFileName = DB_PATH + DB_NAME;
 
    	//Open the empty db as the output stream
    	OutputStream myOutput = new FileOutputStream(outFileName);
 
    	//transfer bytes from the inputfile to the outputfile
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
 
    	//Close the streams
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
 
    }
 
    public List<String> select(String strTable, String strFields, String strWhere, String strOrder) {
    	int iCount = 0;
    	
    	List<String> list = new ArrayList<String>();  
    	
    	Cursor cursor = myDataBase.query(strTable, new String[] {strFields}, strWhere, null, null, null, strOrder);
       
    	if (cursor.moveToFirst()) {  
    		do {
    			iCount = -1;
    			do {
    				iCount++;
    				
    				list.add(cursor.getString(iCount).toString());
    				
    				
    			} while (iCount != cursor.getColumnCount()-1);
    			   
    		} while (cursor.moveToNext());  
    	}  
    	if (cursor != null && !cursor.isClosed()) {  
    		cursor.close();  
    	}	  
    	return list;  
    }  
    
    // insert record to database
    public void insertRecord(String strTable, String strFields, String strValues) {
    	//
    	myDataBase.execSQL("Insert Into " + strTable + " (" + strFields + ") Values (" + strValues + ")");
    } 
    // delete all records
    public void DeleteAll(String strTable) {
    	
    	myDataBase.execSQL("Delete From " + strTable + "" );
    }    
    // delete single record
    public void DeleteRecord(String strTable, String strField, String strCondition) {
    	//
    	myDataBase.execSQL("Delete From " + strTable + " Where " + strField + " " + strCondition );
    }  
    // update record
    public void UpdateRecord(String strTable, String strFields, String strCondition) {
    	//
    	myDataBase.execSQL("Update " + strTable + " Set " + strFields + " " + strCondition );
    }     
   
 
    public void openDataBase() throws SQLException{
 
    	//Open the database
        String myPath = DB_PATH + DB_NAME;
    	myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    	
    }
 
    @Override
	public synchronized void close() {
 
    	    if(myDataBase != null)
    		    myDataBase.close();
 
    	    super.close();
 
	}
 
	@Override
	public void onCreate(SQLiteDatabase db) {
 
	}
 
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
 
	}
 
       
}
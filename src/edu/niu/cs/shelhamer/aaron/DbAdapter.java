package edu.niu.cs.shelhamer.aaron;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbAdapter {

	/*	DB_NAME - name of the database
	VERSION - version of the database*/
	static final String DB_NAME = "contacts.db";
	static final int VERSION = 1;
	private static final String TABLE_NAME = "contactList";
	private static final String PK = "_id";
	private static final String NAME = "name";
	private static final String PHONE = "phone";
	final Context CONTEXT;
	SQLiteDatabase db;
	MySQLiteHelper myHelper;

	public DbAdapter(Context ctx){
		this.CONTEXT = ctx;
		myHelper = new MySQLiteHelper(CONTEXT);
	}// end Constructor
	
	public DbAdapter open() throws SQLException{
		db = myHelper.getWritableDatabase();
		return this;
	}//end open
	
	public void close(){
		myHelper.close();
	}

	private static class MySQLiteHelper extends SQLiteOpenHelper{


		private static final String CREATE_CONTACTS = "Create table " + TABLE_NAME
				+ " (" + PK + " integer primary key autoincrement, "
				+ NAME + " text, " + PHONE + " text);";

		MySQLiteHelper (Context c){
			super(c,DB_NAME, null, VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db){
			try{
				db.execSQL(CREATE_CONTACTS);
			}
			catch(SQLiteException e){
				Log.e("D_ERROR", e.toString());
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
			db.execSQL("sql table if exists " + TABLE_NAME);
			onCreate(db);
		}
	}
}

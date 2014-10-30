package edu.niu.cs.shelhamer.aaron;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ListView myList;
	DbAdapter db;
	DbCursorAdapter curse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myList = (ListView) findViewById(android.R.id.list);
		db = new DbAdapter(this);
		insert();
		db.open();
		curse = new DbCursorAdapter(this, db.getAll());
		myList.setAdapter(curse);
	}

	private void insert() {
		db.open();
		db.insertContact("John Doe", "123-555-1234");
		db.insertContact("Mary Smith", "321-555-0987");
		db.close();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

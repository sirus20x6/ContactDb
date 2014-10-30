/**
 * 
 */
package edu.niu.cs.shelhamer.aaron;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * @author z1757807
 *
 */
public class DbCursorAdapter extends CursorAdapter {
	DbAdapter db;
	/**
	 * @param context
	 * @param c
	 * @param autoRequery
	 */
	public DbCursorAdapter(Context context, Cursor c){
		//, boolean autoRequery) {
	//}
		super(context, c);//, autoRequery);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param context
	 * @param c
	 * @param flags
	 */
	public DbCursorAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see android.widget.CursorAdapter#bindView(android.view.View, android.content.Context, android.database.Cursor)
	 */
	@Override
	public void bindView(View v, Context c, Cursor curse) {
		// TODO Auto-generated method stub
		TextView tvName, tvPhone, tvPK;
		int id;
		db = new DbAdapter(c);
		Cursor myCursor;
		tvName = (TextView) v.findViewById(R.id.tvName);
		tvPhone = (TextView) v.findViewById(R.id.tvPhone);
		tvPK = (TextView)v.findViewById(R.id.tvPK);
		db.open();
		myCursor = db.getOne(curse.getLong(0));
		id = myCursor.getInt(0);
		tvPK.setText("Primary key is " + id);
		tvName.setText(myCursor.getString(1));
		tvPhone.setText(myCursor.getString(2));
		db.close();

	}

	/* (non-Javadoc)
	 * @see android.widget.CursorAdapter#newView(android.content.Context, android.database.Cursor, android.view.ViewGroup)
	 */
	@Override
	public View newView(Context c, Cursor curse, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater;
		View v;
		inflater = LayoutInflater.from(parent.getContext());
		v = inflater.inflate(R.layout.item, parent, false);

		return v;
	}

}

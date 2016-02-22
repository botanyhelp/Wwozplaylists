/**Copyright (C) 2013 Thomas Maher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.jimsuplee.wwozplaylists;

//import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//import java.util.ArrayList;
//import java.util.HashMap;
//import android.widget.Toast;

public class DBAdapter {
	static final String TAG = "WWOZ";
	static final String DATABASE_NAME = "wwozplaylists";
	static final String DATABASE_TABLE = "song";
	static final int DATABASE_VERSION = 1;
    static final String artist = "artist";
    static final String title = "title";
    static final String album = "album";
    static final String time = "time";
    static final String show = "show";
    static final String DATABASE_CREATE = "CREATE TABLE song (artist text default null, title text default null, album text default null, time text default null, show integer default null);";
	
	final Context context;

	DatabaseHelper DBHelper;
	SQLiteDatabase db;

	public DBAdapter(Context ctx) {
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				db.execSQL(DATABASE_CREATE);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			////Log.w(TAG, "Upgrading database from version " + oldVersion + " to "+ newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS contacts");
			onCreate(db);
		}
	}

	public DBAdapter open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		DBHelper.close();
	}
	
	public Cursor getByEasy(String titleParam) throws SQLException {
		//Log.w(TAG, "In DBAdapter.getByEasy");
		String[] columns = new String[] {artist,title,album,time,show};				
		String selection;
		selection = "(artist LIKE ? OR title LIKE ? OR album LIKE ?)";
		String[] infoArray = titleParam.split("\\s*,\\s*");
	    String[] selectionArgs = new String[infoArray.length*3];
//	    if (Wwozplaylists.pagerCounterTotal == 0) {
	        if(infoArray.length > 0) {
			        int j=0;
				    for(int i=0; i<infoArray.length;i++) {
					    if(i>0) {
						    selection += " AND (artist LIKE ? OR title LIKE ? OR album LIKE ?)";
						    ////Log.w(TAG, "In DBAdapter.getByInfo, AND info LIKE");
    					}
	    				//selectionArgs[i] = "%"+infoArray[i]+"%";
		    			selectionArgs[j++] = "%"+infoArray[i]+"%";
			    		selectionArgs[j++] = "%"+infoArray[i]+"%";
				    	selectionArgs[j++] = "%"+infoArray[i]+"%";
				    	////Log.w(TAG, "In DBAdapter.getByInfo, selectionArgs+="+selectionArgs[i]);
				    }
			    
	    	} else {
		    	;
		    }
//	        
//	    } else {
//	    	//selection = "title LIKE ? ORDER BY "+Wwozplaylists.orderBy+" LIMIT " + Integer.toString(Wwozplaylists.pagerCounterTotal) + ",100";
//	    
//	    }
	    
		//We want here to find the total number chosen, without limits, so save it as is for use later
		String selectionAll = selection;
		if (Wwozplaylists.pagerCounterTotal == 0) {
			//selection = "title LIKE ? ORDER BY "+Wwozplaylists.orderBy+" LIMIT 100";
			selection += " ORDER BY "+Wwozplaylists.orderBy+" LIMIT 100";
		} else {
			//selection = "title LIKE ? ORDER BY "+Wwozplaylists.orderBy+" LIMIT " + Integer.toString(Wwozplaylists.pagerCounterTotal) + ",100";
			//selection = " ORDER BY "+Wwozplaylists.orderBy+" LIMIT " + Integer.toString(Wwozplaylists.pagerCounterTotal) + ",100";
			selection += " ORDER BY "+Wwozplaylists.orderBy+" LIMIT " + Integer.toString(Wwozplaylists.pagerCounterTotal) + ",100";
		}
		//Log.w(TAG, "In DBAdapter.getByEasy(), searching selection: " + selection); 
	    //Log.w(TAG, "In DBAdapter.getByEasy(), searching for: " + titleParam);
		//String selectionAll = "title LIKE ?";
		//String[] selectionArgs = new String[] { "%" + titleParam + "%" };
		//Cursor allCursor = db.query(DATABASE_TABLE, columns, selectionAll, selectionArgs, null, null, null);
	    //This works, but limits the total to 100, not good:
	    //Cursor allCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
	    //Use the unlimited query to get the total count:
	    Cursor allCursor = db.query(DATABASE_TABLE, columns, selectionAll, selectionArgs, null, null, null);
		
		int sqlCount=0;
		if (allCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByTitle(String album), c is NOT null, about to c.moveToFirst()");
			allCursor.moveToFirst();
			do {
				sqlCount++;
			} while (allCursor.moveToNext());
			Wwozplaylists.sqlCount = sqlCount;
		}
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByTitle(String title), About to check if Cursor c is null");
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByTitle(String title), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		//Log.w(TAG,"In DBAdapter.getByTitle(String title), about to return cursor, c");
		return mCursor;
	}
	
	public Cursor getByTitle(String titleParam) throws SQLException {
		String[] columns = new String[] {artist,title,album,time,show};				
		String selection;
		if (Wwozplaylists.pagerCounterTotal == 0) {
		    //selection = "album=?";
			//selection = "album=? LIMIT 100";
			//WORKS-SEE ORDERBY___
			selection = "title LIKE ? ORDER BY "+Wwozplaylists.orderBy+" LIMIT 100";
		    //Log.w(TAG, "In DBAdapter.getByShow(), searching DATABASE_TABLE: " + DATABASE_TABLE);
		    ////Log.w(TAG, "In DBAdapter.getByShow(), searching columns: " + columns);
			//Log.w(TAG, "In DBAdapter.getByShow(), searching selection: " + selection); 
		    //Log.w(TAG, "In DBAdapter.getByShow(), searching Show for: " + titleParam);
		} else {
			//WORKS:
			selection = "title LIKE ? ORDER BY "+Wwozplaylists.orderBy+" LIMIT " + Integer.toString(Wwozplaylists.pagerCounterTotal) + ",100";
			//selection = "album=? LIMIT " + Integer.toString(Wwozplaylists.pagerCounterTotal) + ",100";
		}
		String selectionAll = "title LIKE ?";
		String[] selectionArgs = new String[] { "%" + titleParam + "%" };
		Cursor allCursor = db.query(DATABASE_TABLE, columns, selectionAll, selectionArgs, null, null, null);
		int sqlCount=0;
		if (allCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByTitle(String album), c is NOT null, about to c.moveToFirst()");
			allCursor.moveToFirst();
			do {
				sqlCount++;
			} while (allCursor.moveToNext());
			Wwozplaylists.sqlCount = sqlCount;
		}
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByTitle(String title), About to check if Cursor c is null");
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByTitle(String title), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		//Log.w(TAG,"In DBAdapter.getByTitle(String title), about to return cursor, c");
		return mCursor;
	}
	public Cursor getByAlbum(String albumParam) throws SQLException {
		String[] columns = new String[] {artist,title,album,time,show};				
		String selection;
		if (Wwozplaylists.pagerCounterTotal == 0) {
		    //selection = "album=?";
			//selection = "album=? LIMIT 100";
			//WORKS-SEE ORDERBY___
			selection = "album LIKE ? ORDER BY "+Wwozplaylists.orderBy+" LIMIT 100";
		    //Log.w(TAG, "In DBAdapter.getByShow(), searching DATABASE_TABLE: " + DATABASE_TABLE);
		    ////Log.w(TAG, "In DBAdapter.getByShow(), searching columns: " + columns);
			//Log.w(TAG, "In DBAdapter.getByShow(), searching selection: " + selection); 
		    //Log.w(TAG, "In DBAdapter.getByShow(), searching Show for: " + albumParam);
		} else {
			//WORKS:
			selection = "album LIKE ? ORDER BY "+Wwozplaylists.orderBy+" LIMIT " + Integer.toString(Wwozplaylists.pagerCounterTotal) + ",100";
			//selection = "album=? LIMIT " + Integer.toString(Wwozplaylists.pagerCounterTotal) + ",100";
		}
		//This is to report total count for search term:
		String selectionAll = "album LIKE ?";
		
		String[] selectionArgs = new String[] { "%" + albumParam + "%" };
		Cursor allCursor = db.query(DATABASE_TABLE, columns, selectionAll, selectionArgs, null, null, null);
		int sqlCount=0;
		if (allCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByAlbum(String album), c is NOT null, about to c.moveToFirst()");
			allCursor.moveToFirst();
			do {
				sqlCount++;
			} while (allCursor.moveToNext());
			Wwozplaylists.sqlCount = sqlCount;
		}
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByAlbum(String album), About to check if Cursor c is null");
		//int sqlCount=0;
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByAlbum(String album), c is NOT null, about to c.moveToFirst()");
			//mCursor.moveToFirst();
			//do {
			//	sqlCount++;
			//} while (mCursor.moveToNext());
			mCursor.moveToFirst();
		}
		//Wwozplaylists.sqlCount=sqlCount;
		//Log.w(TAG,"In DBAdapter.getByAlbum(String album), about to return cursor, c");
		return mCursor;
	}
	public Cursor getByArtist(String artistParam) throws SQLException {
		String[] columns = new String[] {artist,title,album,time,show};				
		String selection;
		if (Wwozplaylists.pagerCounterTotal == 0) {
			selection = "artist LIKE ? ORDER BY "+Wwozplaylists.orderBy+" LIMIT 100";
		        //Log.w(TAG, "In DBAdapter.getByShow(), searching DATABASE_TABLE: " + DATABASE_TABLE);
			//Log.w(TAG, "In DBAdapter.getByArtist(), searching selection: " + selection); 
		    //Log.w(TAG, "In DBAdapter.getByArtist(), searching Show for: " + artistParam);
		} else {
			selection = "artist LIKE ? ORDER BY "+Wwozplaylists.orderBy+" LIMIT " + Integer.toString(Wwozplaylists.pagerCounterTotal) + ",100";
		}
		String selectionAll = "artist LIKE ?";
		String[] selectionArgs = new String[] { "%" + artistParam + "%" };
		Cursor allCursor = db.query(DATABASE_TABLE, columns, selectionAll, selectionArgs, null, null, null);
		int sqlCount=0;
		if (allCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByArtist(String album), c is NOT null, about to c.moveToFirst()");
			allCursor.moveToFirst();
			do {
				sqlCount++;
			} while (allCursor.moveToNext());
			Wwozplaylists.sqlCount = sqlCount;
		}
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByArtist(String artist), About to check if Cursor c is null");
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByArtist(String artist), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		//Log.w(TAG,"In DBAdapter.getByArtist(String artist), about to return cursor, c");
		return mCursor;
	}
	
	public Cursor getByArtistTitle(String artistParam, String titleParam) throws SQLException {
		String[] columns = new String[] {artist,title,album,time,show};				
		String selection;
		if (Wwozplaylists.pagerCounterTotal == 0) {
			selection = "artist LIKE ? AND title LIKE ? LIMIT 100";
		        //Log.w(TAG, "In DBAdapter.getByArtistTitle(), searching DATABASE_TABLE: " + DATABASE_TABLE);
			//Log.w(TAG, "In DBAdapter.getByArtistTitle(), searching selection: " + selection); 
		    //Log.w(TAG, "In DBAdapter.getByArtistTitle(), searching Show for artist: " + artistParam + ", title: " + titleParam);
		} else {
			selection = "artist LIKE ? AND title LIKE ? LIMIT " + Integer.toString(Wwozplaylists.pagerCounterTotal) + ",100";
		}
		String selectionAll = "artist LIKE ? AND title LIKE ?";
		String[] selectionArgs = new String[] { "%" + artistParam + "%", "%" + titleParam + "%" };
		Cursor allCursor = db.query(DATABASE_TABLE, columns, selectionAll, selectionArgs, null, null, null);
		int sqlCount=0;
		if (allCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByArtistTitle(String artist, String title), c is NOT null, about to c.moveToFirst()");
			allCursor.moveToFirst();
			do {
				sqlCount++;
			} while (allCursor.moveToNext());
			Wwozplaylists.sqlCount = sqlCount;
		}
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByArtistTitle(String artist, String title), About to check if Cursor c is null");
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByArtistTitle(String artist, String title), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		//Log.w(TAG,"In DBAdapter.getByArtistTitle(String artist, String title), about to return cursor, c");
		return mCursor;
	}
	
	
	public Cursor getByShow(String showParam) throws SQLException {
		String[] columns = new String[] {artist,title,album,time,show};				
		String selection;
		if (Wwozplaylists.pagerCounterTotal == 0) {
		    //selection = "album=?";
			//selection = "album=? LIMIT 100";
			//WORKS-SEE ORDERBY___
			selection = "show=? ORDER BY "+Wwozplaylists.orderBy+" LIMIT 100";
		    //Log.w(TAG, "In DBAdapter.getByShow(), searching DATABASE_TABLE: " + DATABASE_TABLE);
		    ////Log.w(TAG, "In DBAdapter.getByShow(), searching columns: " + columns);
			//Log.w(TAG, "In DBAdapter.getByShow(), searching selection: " + selection); 
		    //Log.w(TAG, "In DBAdapter.getByShow(), searching Show for: " + showParam);
		} else {
			//WORKS:
			selection = "show=? ORDER BY "+Wwozplaylists.orderBy+" LIMIT " + Integer.toString(Wwozplaylists.pagerCounterTotal) + ",100";
			//selection = "album=? LIMIT " + Integer.toString(Wwozplaylists.pagerCounterTotal) + ",100";
		}
		
		    
		String[] selectionArgs = new String[] { showParam };
		//Maybe we mean to use wwozplaylists.orderBy
		//String orderBy = time;
		//WORKS, but it seems like its wrong to set the Wwozplaylists.orderBy to time
		//Wwozplaylists.orderBy = "time";
		//Log.w(TAG, "In DBAdapter.getByShow(), About to make Cursor, c, with db.query()");
		//WORKS: unsorted:
		//Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//NOT WORK: fails because this doesn't work in SQLite:
		// sqlite> SELECT time from zozplaylists WHERE album="Afghanistan" LIMIT 5 ORDER BY time;
		// Error: near "ORDER": syntax error
		//Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, orderBy);
		//The LIMIT in db.query is the last (and apparently optional) argument.  Its a String:
		//String limit = "100";
		// ...but we will have a problem because we will have to manage the paging in the LIMIT argument. 
		// We will have to set it next to """ String limit = "200,100" """...and so on. 
		// Managing the LIMIT string won't be too difficult because we are already managing it by tracking 
		// the pagerCounterTotal.  But that is an integer and easy to increment.  Even so, the way to 
		// do paging is by managing the limit String in the db.query().
		//Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, orderBy, limit);
		//Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, orderBy);
		//REMOVE
		//These will make search all records:
		//selectionArgs = new String[] {"James Booker"};
		//selection = "artist=? ORDER BY artist LIMIT 10";
		////Log.w(TAG, "In DBAdapter.getByShow(), searching "+DATABASE_TABLE+" for "+selection+" with selectionArgs[0] value: "+selectionArgs[0]);
		//REMOVE
		//WORKS SEE ORDERBY___
		////Log.w(TAG, "About to run: db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);");
		//Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);

		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByShow(String showParam), About to check if Cursor c is null");
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByShow(String showParam), c is NOT null, about to c.moveToFirst()");
			//This doesn't need to happen now...and MIGHT interfere??:
			//mCursor.moveToFirst();
		}
		//Log.w(TAG, "In DBAdapter.getByShow(String showParam), about to return cursor, c");
		return mCursor;
	}	
	public Cursor getByNearby() throws SQLException {
		String[] columns = new String[] {artist,title,album,time,show};				
		String selection;
		String timeChoiceParam = Wwozplaylists.timeChoice;
		String[] splitResults = timeChoiceParam.split(":");
		String timeChoiceParamHour = splitResults[0];
		//String timeChoiceParamAmPm = splitResults[1].substring(1);
		String timeChoiceParamAmPm = splitResults[1].substring(2);
		Wwozplaylists.orderBy = "time";
		selection = "time LIKE ? AND time LIKE ? ORDER BY "+Wwozplaylists.orderBy;
		//Here we want some SQL that looks like this:
		// SELECT * FROM song WHERE time LIKE "2013-06-23 10%" AND time LIKE "%am";
		// SELECT * FROM song WHERE time LIKE "2011-10-19 12%" AND time LIKE "%pm";
		// ...so that we get songs played during that hour
		String[] selectionArgs = new String[] { timeChoiceParamHour + "%",  "%" + timeChoiceParamAmPm};
		Cursor mCursor = db.query(DATABASE_TABLE, columns, selection, selectionArgs, null, null, null);
		//Log.w(TAG, "In DBAdapter.getByNearby(), About to check if Cursor c is null");
		if (mCursor != null) {
			//Log.w(TAG,"In DBAdapter.getByNearby(), c is NOT null, about to c.moveToFirst()");
			mCursor.moveToFirst();
		}
		//Log.w(TAG,"In DBAdapter.getByNearby(), about to return cursor, c");
		return mCursor;
	}
}

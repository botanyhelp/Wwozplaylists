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

import java.util.HashMap;

import com.jimsuplee.wwozplaylists.DBAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WwozplaylistsActivity extends Activity {
	DBAdapter db;
	static final String TAG = "WWOZ";
	//Disasters.country String will be set to the chosen country.  It is 
	// static because it will be written to by other classes.  This global 
	// is NOT good but convenient.  It is used to select the image to display. 
	static int pagerCounter = 0;
	static int pagerCounterTotal = 0;
	static String showChoice = "";
	//static String descriptionChoice = "";
	//static String locationType = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wwozplaylists);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wwozplaylists, menu);
		return true;
	}

}

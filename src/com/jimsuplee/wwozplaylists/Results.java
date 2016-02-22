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

import android.app.ListActivity;
//import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.util.Log;
import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Toast;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
//import android.view.Gravity;


public class Results extends ListActivity {
	static final String TAG = "WWOZ";
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    String results = getIntent().getStringExtra("results");
	    ////Log.w(TAG, "In Results.onCreate(), about to displayListView(results)");
	    displayListView(results);
    }
	
	private void displayListView(String results) {
		//Log.w(TAG, "In Results.displayListView(results)");
		List<String> resultsList = new ArrayList<String>(Arrays.asList(results.split("___")));
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, resultsList);
		setListAdapter(dataAdapter);
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent("");
				String resultChoice = ((TextView) view).getText().toString();
				//Here we find the value of the time column in the database by split()ting it out
				// Then we paste back on the chopped off 201 (from 2012, 2013, etc.)
				// and then we assign that date as value of the static variable Wwozplaylists.timeChoice 
				// this is done so that onClickNearby can fetch songs that were played at that time. 
				String[] splitResultChoice = resultChoice.split("201");
				String timeChoice;
				//Log.w(TAG, "In Results.displayListView_onItemClick");
				//BAD__if(splitResultChoice.length > 0) {
				if(splitResultChoice.length > 1) {
					//Log.w(TAG, "In Results.displayListView_onItemClick, splitResultChoice >1");
					timeChoice = "201"+splitResultChoice[1];
				} else {
					timeChoice = "2013-03-17 12:09pm";
				}
				Wwozplaylists.timeChoice = timeChoice;
				//String[] countryOne = resultChoice.split("Country: ");
				//String[] countryTwo = countryOne[1].split("\nEnd");
				//String[] countryTwo = countryOne[1].split("\nLocation:");
				//Wwozplaylists.country = countryTwo[0];
				////Log.w(TAG, "In Results.displayListView(results), setting Wwozplaylists.country to: "+countryTwo[0]);
				i.setData(Uri.parse(resultChoice));
				setResult(RESULT_OK, i);
				finish();
			}
		});
    }
}

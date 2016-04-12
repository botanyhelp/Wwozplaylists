package com.jimsuplee.wwozplaylists;

import android.app.ListActivity;
//import android.app.Activity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
//import android.widget.ArrayAdapter;
import android.net.Uri;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
//import android.util.Log;
//import java.util.HashMap;
//import android.widget.Toast;

public class Album extends ListActivity {
	static final String TAG = "WWOZ";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
//		if (Wwozplaylists.showChoice == "") {
//	        displayListView();
//		} else {
//			//Log.w(TAG,"In Show.onCreate(), Wwozplaylists.showChoice!=emptyString, setting showChoice to Wwozplaylists.showChoice and calling finish()");
//			Intent i = new Intent("");
//			String showChoice = Wwozplaylists.showChoice;
//			i.setData(Uri.parse(showChoice));
//			setResult(RESULT_OK, i);
//			finish();
//		}
		displayListView();
	}


	private void displayListView() {
		List<String> albumList = new ArrayList<String>();
		albumList.add("45");
		albumList.add("12");
		albumList.add("New Orleans");
		albumList.add("Unlock Your Mind");
		albumList.add("Blue Crescent");
		albumList.add("100 Classics Of The 1920s");
		albumList.add("Compendium");
		albumList.add("Petit Cadeau");
		albumList.add("Street Parade");
		albumList.add("New Orleans Jazz");
		albumList.add("Greatest Hits");
		albumList.add("unreleased");
		albumList.add("New Orleans Jazz Of The 1920s");
		albumList.add("Shimmy");
		albumList.add("The Ultimate Jazz Archive");
		albumList.add("Medicated Magic");
		albumList.add("Lucky Devil");
		albumList.add("Throwback");
		albumList.add("Cruisin` Deuces");
		albumList.add("Everybody`s Gettin` Some");
		albumList.add("Mike Dillon");
		albumList.add("It Aint My Fault");
		albumList.add("Atlantic Jazz:New Orleans");
		albumList.add("Lars Edegran Triolian String Band");
		albumList.add("Change in the Weather");
		albumList.add("The Bridge Trio");
		albumList.add("They Call Me The Fat Man- The Le");
		albumList.add("New Orleans Reborn");
		albumList.add("Moody`s Mood For Love");
		albumList.add("Twenty Dozen");
		albumList.add("Chicago:Living Legends");
		albumList.add("Live");
		albumList.add("TWOS COMPANY");
		albumList.add("Ten Strings");
		albumList.add("best of");
		albumList.add("mos scocious");
		albumList.add("The Coming Tide");
		albumList.add("Rebirth of New Orleans");
		albumList.add("The Ones I Love");
		albumList.add("Wonderful World of Louis Armstrong");
		albumList.add("2 Man Wrecking Crew");
		albumList.add("DRUMSCUSSION");
		albumList.add("Livin the Legacy");
		albumList.add("Funkify Your Life- The Meters An");
		albumList.add("The Impulse Story");
		albumList.add("Indian Blues");
		albumList.add("The very best of");
		albumList.add("Jazz From The Soul Of New Orleans");
		albumList.add("All About Everything");
		albumList.add("From the Corner to the Block");
		albumList.add("Best of");
		albumList.add("Livin A Treme Life");
		albumList.add("The Essential");
		albumList.add("greatest hits");
		albumList.add("single");
		albumList.add("Helen Gillet");
		albumList.add("Something Sweet");
		albumList.add("Return Of Django");
		albumList.add("7");
		albumList.add("Heels Over Head");
		albumList.add("s/t");
		albumList.add("Blue Moon");
		albumList.add("LIVE ON WWOZ- Jam Session");
		albumList.add("New Orleans Dance Bands");
		albumList.add("Radio Music Society");
		albumList.add("Brasileiro");
		albumList.add("Fly");
		albumList.add("Home");
		albumList.add("King Of New Orleans");
		albumList.add("Preservation");
		albumList.add("GENE KRUPA, ANITA ODAY AND THE ORCHESTRA");
		albumList.add("Needle In The Groove");
		albumList.add("Treme Traditions");
		albumList.add("For True");
		albumList.add("Hasta");
		albumList.add("Occapella");
		albumList.add("Slither Slice");
		albumList.add("Yellow Moon");
		albumList.add("2005");
		albumList.add("Claroscuro");
		albumList.add("Global Noize");
		albumList.add("Heavy Sugar");
		albumList.add("Best Of");
		albumList.add("Its About Time");
		albumList.add("Livin The Legacy");
		albumList.add("Shrimp Boots and Vintage Suits");
		albumList.add("Southland Sessions");
		albumList.add("Tuba Fats");
		albumList.add("Bobby Charles");
		albumList.add("Legendary Jazz Drummers");
		albumList.add("Pin Your Spin");
		albumList.add("Trombone Shorty Meets Lionel Ferbos: Two Trumpets, Two Ears");
		albumList.add("I Got A Big Fat Woman");
		albumList.add("Jamais de la Vie");
		albumList.add("Save the Bones");
		albumList.add("Eyes On Zion");
		albumList.add("Foolers Gold");
		albumList.add("Genius");
		albumList.add("Look Out Mama");
		albumList.add("Vidacovich");

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, albumList);
		setListAdapter(dataAdapter);
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent("");
				//String showChoice = ((TextView) view).getText().toString();
				String albumChoice = ((TextView) view).getText().toString();
				//String showChoiceNumber = "28";
//				String showChoiceNumber;
//				if(showMap.get(showChoice) != null) {
//				    showChoiceNumber = showMap.get(showChoice);
//				} else {
//					showChoiceNumber = "37";
//				}
				    
				//Wwozplaylists.showChoice = showChoiceNumber;				
				Wwozplaylists.albumChoice = albumChoice;				
				i.setData(Uri.parse(albumChoice));
				setResult(RESULT_OK, i);
				finish();
			}
		});
	}
}


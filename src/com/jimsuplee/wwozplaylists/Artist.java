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
//import android.widget.EditText;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
//import android.util.Log;
//import java.util.HashMap;
//import android.widget.Toast;

public class Artist extends ListActivity {
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
		List<String> artistList = new ArrayList<String>();
		artistList.add("Louis Armstrong");
		artistList.add("Dr. John");
		artistList.add("Kermit Ruffins");
		artistList.add("Johnny Adams");
		artistList.add("Dirty Dozen Brass Band");
		artistList.add("Allen Toussaint");
		artistList.add("Irma Thomas");
		artistList.add("Fats Domino");
		artistList.add("Preservation Hall Jazz Band");
		artistList.add("Earl King");
		artistList.add("Dr. Michael White");
		artistList.add("Bruce Daigrepont");
		artistList.add("Sidney Bechet");
		artistList.add("Wynton Marsalis");
		artistList.add("Galactic");
		artistList.add("Jelly Roll Morton");
		artistList.add("Miles Davis");
		artistList.add("Treme Brass Band");
		artistList.add("Ray Charles");
		artistList.add("Lee Dorsey");
		artistList.add("Snooks Eaglin");
		artistList.add("James Booker");
		artistList.add("Professor Longhair");
		artistList.add("James Brown");
		artistList.add("John Coltrane");
		artistList.add("Rebirth Brass Band");
		artistList.add("The Meters");
		artistList.add("Herbie Hancock");
		artistList.add("Jon Cleary");
		artistList.add("Anders Osborne");
		artistList.add("John Boutte");
		artistList.add("Cab Calloway and his Orchestra");
		artistList.add("Eric Lindell");
		artistList.add("Louis Prima");
		artistList.add("Billie Holiday");
		artistList.add("Johnny Sansone");
		artistList.add("Nina Simone");
		artistList.add("Meters");
		artistList.add("Honey Island Swamp Band");
		artistList.add("Ella Fitzgerald");
		artistList.add("Grant Green");
		artistList.add("Mahalia Jackson");
		artistList.add("Bessie Smith");
		artistList.add("Rahsaan Roland Kirk");
		artistList.add("Bobby Charles");
		artistList.add("Joe Houston");
		artistList.add("Ahmad Jamal");
		artistList.add("Danny Barker");
		artistList.add("Frogman Henry");
		artistList.add("Duke Ellington");
		artistList.add("Fats Waller");
		artistList.add("Little Freddie King");
		artistList.add("Eddie Bo");
		artistList.add("George Lewis");
		artistList.add("Kid Ory");
		artistList.add("Tommy Ridgley");
		artistList.add("Soul Rebels");
		artistList.add("Dr. Lonnie Smith");
		artistList.add("Danny Gatton");
		artistList.add("Mike Dillon");
		artistList.add("Lars Edegran");
		artistList.add("Etta James");
		artistList.add("Paul Barbarin");
		artistList.add("John Scofield");
		artistList.add("Papa Grows Funk");
		artistList.add("Bonerama");
		artistList.add("Clifton Chenier");
		artistList.add("Dave Bartholomew");
		artistList.add("Pete Fountain");
		artistList.add("Donald Byrd");
		artistList.add("Trombone Shorty");
		artistList.add("AFO Executives");
		artistList.add("Ernie K-Doe");
		artistList.add("Freddie Hubbard");
		artistList.add("Lost Bayou Ramblers");
		artistList.add("Charles Mingus");
		artistList.add("Junior Wells");
		artistList.add("Aaron Neville");
		artistList.add("Glenn Miller Orchestra");
		artistList.add("Jimmy Smith");
		artistList.add("Nicholas Payton");
		artistList.add("Eddie Harris");
		artistList.add("Big Daddy O");
		artistList.add("Count Basie and his Orchestra");
		artistList.add("Helen Gillet");
		artistList.add("Leroy Jones");
		artistList.add("Al Hirt");
		artistList.add("Joe Krown");
		artistList.add("Smokey Johnson");
		artistList.add("Bill Frisell");
		artistList.add("Esperanza Spalding");
		artistList.add("Keb Mo");
		artistList.add("Marco Benevento");
		artistList.add("Monty Alexander");
		artistList.add("Neville Brothers");
		artistList.add("miles davis");
		artistList.add("Hot 8 Brass Band");
		artistList.add("Debbie Davis");
		artistList.add("Terence Blanchard");
		artistList.add("Fletcher Henderson and his Orchestra");

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, artistList);
		setListAdapter(dataAdapter);
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent("");
				//String showChoice = ((TextView) view).getText().toString();
				String artistChoice = ((TextView) view).getText().toString();
				//String showChoiceNumber = "28";
//				String showChoiceNumber;
//				if(showMap.get(showChoice) != null) {
//				    showChoiceNumber = showMap.get(showChoice);
//				} else {
//					showChoiceNumber = "37";
//				}
				    
				//Wwozplaylists.showChoice = showChoiceNumber;				
				Wwozplaylists.artistChoice = artistChoice;
				//Normally, the user entered their artistChoice into the EditText field. 
				// ..but here we want to set it so that the pager can find it:
				//EditText txt_artist = (EditText) findViewById(R.id.txt_artist);
				//txt_artist.setText(artistChoice);
				i.setData(Uri.parse(artistChoice));
				setResult(RESULT_OK, i);
				finish();
			}
		});
	}
}


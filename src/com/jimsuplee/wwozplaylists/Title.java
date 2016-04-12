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

public class Title extends ListActivity {
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
		List<String> titleList = new ArrayList<String>();
		titleList.add("Royal Garden Blues");
		titleList.add("Time Out");
		titleList.add("Basin Street Blues");
		titleList.add("Hindustan");
		titleList.add("St. James Infirmary");
		titleList.add("Harlem Nocturne");
		titleList.add("St. Louis Blues");
		titleList.add("Perrodin two step");
		titleList.add("Panama");
		titleList.add("Good Morning New Orleans");
		titleList.add("Summertime");
		titleList.add("Sweet Georgia Brown");
		titleList.add("Bourbon Street Parade");
		titleList.add("Tin Roof Blues");
		titleList.add("storm warning");
		titleList.add("Well Meet Again");
		titleList.add("After Youve Gone");
		titleList.add("Tiger Rag");
		titleList.add("Muskrat Ramble");
		titleList.add("Sing On");
		titleList.add("Waltz While You Sleep");
		titleList.add("Wolverine Blues");
		titleList.add("Swan Blues [1962]");
		titleList.add("Blue Crescent");
		titleList.add("Careless Love");
		titleList.add("High Society");
		titleList.add("West End Blues");
		titleList.add("Maple Leaf Rag");
		titleList.add("Such Trying Times");
		titleList.add("Crossroad Blues");
		titleList.add("Bugle Boy March");
		titleList.add("Caravan");
		titleList.add("Black Bottom Stomp");
		titleList.add("What A Wonderful World");
		titleList.add("Bounce Baby");
		titleList.add("Sugar Blues");
		titleList.add("Aint Nothin But a Party");
		titleList.add("New Orleans");
		titleList.add("Mahogany Hall");
		titleList.add("It Aint My Fault-");
		titleList.add("Got No Blues Today");
		titleList.add("Two Bit Town");
		titleList.add("THANKS FOR THE BOOGIE RIDE");
		titleList.add("Certain Girl");
		titleList.add("Clarinet Marmalade");
		titleList.add("OPENING PRAYER");
		titleList.add("I FEEL A SONG COMING ON (1963)");
		titleList.add("Mood Indigo");
		titleList.add("STILL UNRULY ON THE PLANTATION");
		titleList.add("Big Butter and Egg Man");
		titleList.add("John The Revelator");
		titleList.add("10 to 12");
		titleList.add("Body and Soul");
		titleList.add("On The Sunny Side Of The Street");
		titleList.add("Milneberg Joys");
		titleList.add("Over The Waves");
		titleList.add("Afro Blue");
		titleList.add("I Wish I Could Shimmy Like My Sister Kate");
		titleList.add("Its Later than You Think");
		titleList.add("Stardust");
		titleList.add("Amazing Grace");
		titleList.add("Do You Know What It Means To Miss New Orleans");
		titleList.add("Some Of These Days");
		titleList.add("Out Of Nowhere");
		titleList.add("Weary Blues");
		titleList.add("Jazz Me Blues");
		titleList.add("When The Saints Go Marching In");
		titleList.add("i cant stand it");
		titleList.add("Darktown Strutters Ball");
		titleList.add("JellyRoll Blues");
		titleList.add("What is This?");
		titleList.add("Bill Bailey");
		titleList.add("Brazil");
		titleList.add("Coffee (Vocal)");
		titleList.add("Everybody Loves My Baby");
		titleList.add("Exactly Like You");
		titleList.add("My Blue Heaven");
		titleList.add("Thats a Plenty");
		titleList.add("Joe Avery Blues");
		titleList.add("Lord, Lord, Lord");
		titleList.add("When the Saints Go Marching In");
		titleList.add("Burgundy Street Blues");
		titleList.add("Honeysuckle Rose");
		titleList.add("I Cant Get Started");
		titleList.add("Old Man River");
		titleList.add("Trouble In Mind");
		titleList.add("Turtle Twist");
		titleList.add("Milenberg Joys");
		titleList.add("No City Like New Orleans");
		titleList.add("Take Five");
		titleList.add("Thats A Plenty");
		titleList.add("America The Beautiful");
		titleList.add("Blue Skies");
		titleList.add("Dinah");
		titleList.add("Ill Fly Away");
		titleList.add("Jingle Bells");
		titleList.add("Ruler of My Heart");
		titleList.add("Squeeze Me");
		titleList.add("We Just Couldnt Say Goodbye");
		titleList.add("A Kiss To Build A Dream On");    	

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, titleList);
		setListAdapter(dataAdapter);
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent("");
				//String showChoice = ((TextView) view).getText().toString();
				String titleChoice = ((TextView) view).getText().toString();
				//String showChoiceNumber = "28";
//				String showChoiceNumber;
//				if(showMap.get(showChoice) != null) {
//				    showChoiceNumber = showMap.get(showChoice);
//				} else {
//					showChoiceNumber = "37";
//				}
				    
				//Wwozplaylists.showChoice = showChoiceNumber;				
				Wwozplaylists.titleChoice = titleChoice;				
				i.setData(Uri.parse(titleChoice));
				setResult(RESULT_OK, i);
				finish();
			}
		});
	}
}


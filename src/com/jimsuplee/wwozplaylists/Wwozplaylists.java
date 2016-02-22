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



import com.jimsuplee.wwozplaylists.R;
import com.jimsuplee.wwozplaylists.DBAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
//import android.os.Bundle;
//import android.app.Activity;
//import android.view.Menu;
//import android.net.Uri;
import android.widget.TextView;
import android.widget.Button;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import android.widget.Toast;
import android.content.Intent;
import android.database.Cursor;
//import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
//import android.widget.DatePicker;
//import android.widget.Toast;
//import java.util.Date;
//import java.text.SimpleDateFormat;
//import android.widget.ImageView;
//import java.util.HashMap;
//import java.util.Map;

public class Wwozplaylists extends Activity {
	DBAdapter db;
	static final String TAG = "WWOZ";
	//Wwozplaylists.country String will be set to the chosen country.  It is 
	// static because it will be written to by other classes.  This global 
	// is NOT good but convenient.  It is used to select the image to display. 
	static int pagerCounter = 0;
	static int pagerCounterTotal = 0;
	static String showChoice = "";
	static String easyChoice = "";
	static String titleChoice = "";
	static String artistChoice = "";
	static String timeChoice = "";
	static String albumChoice = "";
	static String orderBy = "time";
	static int sqlCount = 0;
	//static String titleChoice = "";
	//static String showType = "";
	final HashMap<String,String> countMap = new HashMap<String,String>();
	final HashMap<String,String> showMap = new HashMap<String,String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wwozplaylists);
		try {
			String destPath = "/data/data/" + getPackageName() + "/databases";
			File f = new File(destPath);
			if (!f.exists()) {
				f.mkdirs();
				f.createNewFile();
				Toast.makeText(this, "Please Wait...Database Being Created",
						Toast.LENGTH_LONG).show();
				CopyDB(getBaseContext().getAssets().open("wwozplaylists"),
						new FileOutputStream(destPath + "/wwozplaylists"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		db = new DBAdapter(this);
		//final HashMap<String,String> countMap = new HashMap<String,String>();
        countMap.put("1", "11");
        countMap.put("2", "2222");
        countMap.put("3", "772");
        countMap.put("4", "3486");
        countMap.put("5", "3092");
        countMap.put("6", "4384");
        countMap.put("7", "2743");
        countMap.put("8", "2387");
        countMap.put("9", "1059");
        countMap.put("10", "12");
        countMap.put("11", "2313");
        countMap.put("12", "2627");
        countMap.put("13", "3778");
        countMap.put("14", "2333");
        countMap.put("15", "2648");
        countMap.put("16", "1097");
        countMap.put("17", "2764");
        countMap.put("18", "4282");
        countMap.put("19", "2");
        countMap.put("20", "902");
        countMap.put("21", "540");
        countMap.put("22", "2679");
        countMap.put("23", "2409");
        countMap.put("24", "3636");
        countMap.put("25", "2310");
        countMap.put("26", "2059");
        countMap.put("27", "1355");
        countMap.put("28", "13");
        countMap.put("29", "2686");
        countMap.put("30", "2323");
        countMap.put("31", "2816");
        countMap.put("32", "2576");
        countMap.put("33", "3425");
        countMap.put("34", "2204");
        countMap.put("35", "2793");
        countMap.put("36", "3804");
        countMap.put("37", "29");
        countMap.put("38", "3834");
        countMap.put("39", "760");
        countMap.put("40", "3231");
        countMap.put("41", "2093");
        countMap.put("42", "2150");
        countMap.put("43", "1745");
        countMap.put("44", "2376");
        countMap.put("45", "659");
        countMap.put("46", "4");
        countMap.put("47", "1452");
        countMap.put("48", "6");
        countMap.put("49", "77");
        countMap.put("50", "1130");
        countMap.put("51", "2986");
        countMap.put("52", "1487");
        countMap.put("53", "2742");
        countMap.put("54", "2250");
        countMap.put("55", "2002");
        countMap.put("56", "2076");
        countMap.put("57", "1406");
        countMap.put("58", "10");
        countMap.put("59", "1768");
        countMap.put("60", "2532");
        countMap.put("61", "3407");
        countMap.put("62", "1870");
        countMap.put("63", "2490");
        countMap.put("64", "2484");
        countMap.put("65", "1090");
        countMap.put("66", "2293");
        countMap.put("67", "2550");
        countMap.put("68", "2542");
        

        showMap.put("2","Contemporary Jazz: The Deans List with Dean Ellis");
        showMap.put("3","Overnight Jazz with Jelly Roll Justice");
        showMap.put("4","The Morning Set with Joel Heavy D Dinerstein");
        showMap.put("5","Traditional Jazz with Dan Meyer");
        showMap.put("6","New Orleans Music Show with Murf Reeves");
        showMap.put("7","Blues Eclectic with Andrew Grafe");
        showMap.put("8","Jazz from the French Market with Sondra Bibb");
        showMap.put("9","Blues and RandB with Gentilly Jr.");
        showMap.put("10","Governors Mansion with The Governor");
        showMap.put("11","Contemporary Jazz with Mockingbird");
        showMap.put("12","Overnight Jazz with Johnny Woodstock");
        showMap.put("13","The Morning Set with Mark LaMaire");
        showMap.put("14","Traditional Jazz with Zach");
        showMap.put("15","New Orleans Music Show with Ms. Smalls");
        showMap.put("16","Soul Serenade with Marc Stone");
        showMap.put("17","Jazz from the French Market with T.R. Johnson");
        showMap.put("18","50s RandB with Neil Pellegrin");
        showMap.put("19","Kitchen Sink with David Kunian");
        showMap.put("20","Contemporary Jazz with Johnny Ray");
        showMap.put("21","Overnight Jazz with Jelly Roll Justice");
        showMap.put("22","The Morning Set with K. Balewa");
        showMap.put("23","Fresh Fig Jam with Olivia Greene (Trad. Jazz)");
        showMap.put("24","New Orleans Music Show with George Ingmire");
        showMap.put("25","Sittin at the Crossroad with Big D (Blues)");
        showMap.put("26","Jazz from the French Market with Maryse Dejean");
        showMap.put("27","RandB Oldies with Rare On The Air");
        showMap.put("28","Kitchen Sink with A.J. Rodrigue and A.A.");
        showMap.put("29","Late Night Jazz with Russell");
        showMap.put("30","The Spin Cycle with Old Man River");
        showMap.put("31","The Morning Set with Scott Borne");
        showMap.put("32","Traditional Jazz with Sally Young");
        showMap.put("33","New Orleans Music Show with Sherwood Collins");
        showMap.put("34","The Blues Ball with David Torkanowsky");
        showMap.put("35","Jazz from the French Market with Jelly Roll Justice");
        showMap.put("36","Blues and RandB with Missy Bowen");
        showMap.put("37","Kitchen Sink with Brian McColgan");
        showMap.put("38","Swing and Big Band with The Minister of Swing");
        showMap.put("39","Overnight Jazz with Jellyroll Justice");
        showMap.put("40","The Morning Set with Raymond Kent");
        showMap.put("41","Traditional Jazz with Keith Hill");
        showMap.put("42","New Orleans Music Show with Black Mold or Bill DeTurk");
        showMap.put("43","The Blues Breakdown with Valerie The Problem Child Kacprzak");
        showMap.put("44","Jazz from the French Market with Vin Chary");
        showMap.put("45","Music of Mass Distraction with Black Mold");
        showMap.put("46","The Rhythm Room with Allan Alski Laskey");
        showMap.put("47","Midnight Blues with Moses");
        showMap.put("48","Putumayo World Music Hour");
        showMap.put("49","Jazz From Lincoln Center");
        showMap.put("50","New Orleans All the Way Live on WWOZ");
        showMap.put("51","Traditional Jazz and New Orleans Music with Big Pete");
        showMap.put("52","Music in the Glen with Sean OMeara");
        showMap.put("53","Tiene Sabor (Latin Show) with Yolanda Estrada");
        showMap.put("54","Tudo Bem (Brazilian) with Dean Ellis or Suzanne Corley");
        showMap.put("55","World Journey with Suzanne Corley");
        showMap.put("56","Block Party with Brice Nice");
        showMap.put("57","Soul Power with Soul Sister");
        showMap.put("58","Awake and Willing with Peggy Lou");
        showMap.put("59","Blues in the Night with Jamie DellApa");
        showMap.put("60","Blues with Sam Cammarata");
        showMap.put("61","The Sunday Morning Jazz Set with Mark Landesman");
        showMap.put("62","The Gospel Show with Lauren Mastro");
        showMap.put("63","Old Time Country and Bluegrass with Hazel The Delta Rambler");
        showMap.put("64","Cajun and Zydeco with Charles Laborde or Jim Hobbs");
        showMap.put("65","Acoustic Blues with Your Cousin Dimitri");
        showMap.put("66","Sitting In with Elizabeth Meneray");
        showMap.put("67","Swing Session with Kathleen Lee");
        showMap.put("68","Spirits of Congo Square with Eugene Thomas");
        showMap.put("1","Whats New");

		setContentView(R.layout.activity_wwozplaylists);
	}

	public void CopyDB(InputStream inputStream, OutputStream outputStream)
			throws IOException {
		byte[] buffer = new byte[1024];
		int length;
		while ((length = inputStream.read(buffer)) > 0) {
			outputStream.write(buffer, 0, length);
		}
		inputStream.close();
		outputStream.close();
	}	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.wwozplaylists, menu);
		return true;
	}
	
	public void onClickShow(View view) {
		////Log.w(TAG, "In Wwozplaylists.onClickShow()");
		pagerCounter = 0;
		pagerCounterTotal = 0;
		showChoice="";
		titleChoice="";
		Intent iShow = new Intent("com.jimsuplee.wwozplaylists.Show");
		startActivityForResult(iShow, 0);
	}	
	public void onClickTopTitle(View view) {
		////Log.w(TAG, "In Wwozplaylists.onClickTopTitle()");
		pagerCounter = 0;
		pagerCounterTotal = 0;
		showChoice="";
		titleChoice="";
		albumChoice="";
		artistChoice="";
		Intent iTitle = new Intent("com.jimsuplee.wwozplaylists.Title");
		startActivityForResult(iTitle, 4);
	}
	public void onClickTopArtist(View view) {
		//Log.w(TAG, "In Wwozplaylists.onClickTopArtist()");
		pagerCounter = 0;
		pagerCounterTotal = 0;
		showChoice="";
		titleChoice="";
		albumChoice="";
		artistChoice="";
		Intent iArtist = new Intent("com.jimsuplee.wwozplaylists.Artist");
		startActivityForResult(iArtist, 5);
	}
	public void onClickTopAlbum(View view) {
		////Log.w(TAG, "In Wwozplaylists.onClickTopAlbum()");
		pagerCounter = 0;
		pagerCounterTotal = 0;
		showChoice="";
		titleChoice="";
		albumChoice="";
		artistChoice="";
		Intent iAlbum = new Intent("com.jimsuplee.wwozplaylists.Album");
		startActivityForResult(iAlbum, 6);
	}
	
	public void onClickShowTitle(View view) {
		////Log.w(TAG, "In Wwozplaylists.onClickShow()");
		pagerCounter = 0;
		pagerCounterTotal = 0;
		showChoice="";
		Wwozplaylists.orderBy="title";
		Intent iShow = new Intent("com.jimsuplee.wwozplaylists.Show");
		startActivityForResult(iShow, 0);
	}
	public void onClickShowArtist(View view) {
		////Log.w(TAG, "In Wwozplaylists.onClickShow()");
		pagerCounter = 0;
		pagerCounterTotal = 0;
		showChoice="";
		Wwozplaylists.orderBy="artist";
		Intent iShow = new Intent("com.jimsuplee.wwozplaylists.Show");
		startActivityForResult(iShow, 0);
	}
	public void onClickShowAlbum(View view) {
		//Log.w(TAG, "In Wwozplaylists.onClickShow()");
		pagerCounter = 0;
		pagerCounterTotal = 0;
		showChoice="";
		Wwozplaylists.orderBy="album";
		Intent iShow = new Intent("com.jimsuplee.wwozplaylists.Show");
		startActivityForResult(iShow, 0);
	}
	public void onClickShowMore(View view) {
		//Log.w(TAG, "In Wwozplaylists.onClickShowMore()");
		if(showChoice!="") {
            Toast.makeText(this, "Getting "+Integer.toString(Wwozplaylists.pagerCounterTotal+1)+" to "+Integer.toString(Wwozplaylists.pagerCounterTotal+100)+" out of "+countMap.get(showChoice), Toast.LENGTH_LONG).show();
            Intent iShow = new Intent("com.jimsuplee.wwozplaylists.Show");
            startActivityForResult(iShow, 0);		
        } else if (albumChoice!="") {
    		onClickAlbum(view);
		} else if (titleChoice!="" && artistChoice!="") {
			onClickArtistTitle(view);
		} else if (titleChoice!="") {
			onClickTitle(view);
		} else if (artistChoice!="") {
			onClickArtist(view);
		} else if (easyChoice!="") {
			onClickEasy(view);
		} else {
			//should never get here:
			//Log.w(TAG, "In Wwozplaylists.onClickShowMore(), but showChoice,titleChoice both ne 0!!! BAD");
		}
	}
	
	
	public void onClickEasy(View view) {
		//Log.w(TAG, "In Wwozplaylists.onClickEasy()");
		pagerCounter = 0;
		//pagerCounterTotal is NOT set to 0 here because it is sometimes called from onClickShowMore()
		//pagerCounterTotal = 0;
		showChoice="";
		artistChoice="";
		albumChoice="";
		//Intent iShow = new Intent("com.jimsuplee.wwozplaylists.Show");
		//startActivityForResult(iShow, 0);
		EditText txt_description = (EditText) findViewById(R.id.txt_easy);
		db.open();
		String easyParam;
		if (easyChoice == "") {
			// txt_description was obtained a few lines above
			easyParam = txt_description.getText().toString();
			easyChoice = easyParam;
			//Log.w(TAG, "In Wwozplaylists.onClickEasy(), easyChoice WAS empty.");
			//Log.w(TAG, "In Wwozplaylists.onClickEasy(), easyChoice NOW: "	+ easyChoice);
			pagerCounterTotal = 0;
		} else {
			//Log.w(TAG,"In Wwozplaylists.onClickEasy(), easyChoice IS NOT empty.");
			//Log.w(TAG,"In Wwozplaylists.onClickEasy(), reuse easyChoice: "+ easyChoice);
			String currentEasyParam = txt_description.getText().toString();
			// If the user hasn't typed in a different search item:
			if (easyChoice.equals(currentEasyParam)) {
				//Log.w(TAG,"In Wwozplaylists.onClickEasy(), same search choice: "+ easyChoice + currentEasyParam);
				easyParam = easyChoice;
			} else {
				// In this case, Ufosightings.titleChoice is not empty.
				// However, we cannot reuse Ufosightings.titleChoice if
				// the user has since typed in a different value to search by.
				// Remember that onClickDescription() is called for new
				// searches and for "next 10" pager requests. Therefore, this
				// logic is required. Further, if this is a new search, then
				// we also want to reset pagerCountTotal to 0.
				//Log.w(TAG,"In Wwozplaylists.onClickEasy(), NOT same search choice: "+ easyChoice + currentEasyParam);

				easyChoice = currentEasyParam;
				easyParam = currentEasyParam;
				pagerCounterTotal = 0;
			}
			// pagerCounterTotal = 0;
			// pagerCounter = 0;
		}
		if(easyParam.isEmpty()){
			Toast.makeText(this, "Enter comma separated search term for fewer results", Toast.LENGTH_LONG).show();
		}
		Cursor c = db.getByEasy(easyParam);
		Toast.makeText(this, Integer.toString(Wwozplaylists.sqlCount)+" total records for Easy = \""+easyChoice+"\". Showing up to 100 records, starting from "+Integer.toString(Wwozplaylists.pagerCounterTotal+1), Toast.LENGTH_LONG).show();
		String results = "";
		if (c != null) {
			//Log.w(TAG,"In Wwozplaylists.onClickEasy(), cursor c is not null.");
		}
		//Log.w(TAG,"In Wwozplaylists.onClickEasy(), about to c.moveToFirst()");
		if (c.moveToFirst()) {
			//Log.w(TAG,"In Wwozplaylists.onClickEasy(), c.moveToFirst() returned true");
			do {
				pagerCounter++;
				// results += "Occurred: " + c.getString(0) + "\nReported: " +
				// c.getString(1) + "\nCity/State: " + c.getString(2) +
				// "\nUfo Shape: " + c.getString(3) + "\nEvent Duration: " +
				// c.getString(4) + "\nDescription: " + c.getString(5) + "___";
				results += c.getString(0)+"\n" + c.getString(1) + "\n" + c.getString(2)+ "\n" + c.getString(3) + "___";

			} while (c.moveToNext());
		}
		// if(pagerCounter == 10) {
		// if(pagerCounter > 8) {
		// for search term 'urgent' 8 results were returned??? actual DB has 27
		// hmmm??
		// if(pagerCounter > 7) {
		if (pagerCounter == 100) {
			pagerCounterTotal += 100;
			pagerCounter = 0;
			//Log.w(TAG,"In Wwozplaylists.onClickEasy(), pagerCounter was ten, now: "+ Integer.toString(pagerCounter));
			//Log.w(TAG,"In Wwozplaylists.onClickEasy(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
			//Log.w(TAG,"In Wwozplaylists.onClickEasy(), easyChoice is: "+ easyChoice);
		} else {
			// results+=Integer.toString(pagerCounter);
			//Log.w(TAG,"In Wwozplaylists.onClickEasy(), pagerCounter is NOT ten, it is: "+ Integer.toString(pagerCounter));
			pagerCounterTotal = 0;
			pagerCounter = 0;
			//showChoice = "";
			//locationType = "";
			//Log.w(TAG,"In Wwozplaylists.onClickEasy(), pagerCounter is NOT ten: "+ Integer.toString(pagerCounter));
			//Log.w(TAG,"In Wwozplaylists.onClickEasy(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
			//Log.w(TAG,"In Wwozplaylists.onClickEasy(), easyChoice is: "+ easyChoice);
		}
		//Log.w(TAG, "In Wwozplaylists.onClickEasy(), about to db.close()");
		Intent iResults = new Intent("com.jimsuplee.wwozplaylists.Results");
		iResults.putExtra("results", results);
		startActivityForResult(iResults, 3);
		db.close();
	}

	
	
	public void onClickTitle(View view) {
		//Log.w(TAG, "In Wwozplaylists.onClickTitle()");
		pagerCounter = 0;
		//pagerCounterTotal is NOT set to 0 here because it is sometimes called from onClickShowMore()
		//pagerCounterTotal = 0;
		showChoice="";
		artistChoice="";
		albumChoice="";
		//Intent iShow = new Intent("com.jimsuplee.wwozplaylists.Show");
		//startActivityForResult(iShow, 0);
		EditText txt_description = (EditText) findViewById(R.id.txt_title);
		db.open();
		String titleParam;
		if (titleChoice == "") {
			// txt_description was obtained a few lines above
			titleParam = txt_description.getText().toString();
			titleChoice = titleParam;
			//Log.w(TAG, "In Wwozplaylists.onClickTitle(), titleChoice WAS empty.");
			//Log.w(TAG, "In Wwozplaylists.onClickTitle(), titleChoice NOW: "	+ titleChoice);
			pagerCounterTotal = 0;
		} else {
			//Log.w(TAG,"In Wwozplaylists.onClickTitle(), titleChoice IS NOT empty.");
			//Log.w(TAG,"In Wwozplaylists.onClickTitle(), reuse titleChoice: "+ titleChoice);
			String currentTitleParam = txt_description.getText().toString();
			// If the user hasn't typed in a different search item:
			if (titleChoice.equals(currentTitleParam)) {
				//Log.w(TAG,"In Wwozplaylists.onClickTitle(), same search choice: "+ titleChoice + currentTitleParam);
				titleParam = titleChoice;
			} else {
				// In this case, Ufosightings.titleChoice is not empty.
				// However, we cannot reuse Ufosightings.titleChoice if
				// the user has since typed in a different value to search by.
				// Remember that onClickDescription() is called for new
				// searches and for "next 10" pager requests. Therefore, this
				// logic is required. Further, if this is a new search, then
				// we also want to reset pagerCountTotal to 0.
				//Log.w(TAG,"In Wwozplaylists.onClickTitle(), NOT same search choice: "+ titleChoice + currentTitleParam);

				//Next three lines work but not with TopTitle
				//titleChoice = currentTitleParam;
				//titleParam = currentTitleParam;
				//pagerCounterTotal = 0;
				if(currentTitleParam.isEmpty()) {
					titleParam=titleChoice;
					//Log.w(TAG,"In Wwozplaylists.onClickTitle(), currentTitleParam.isEmpty()");
					//Log.w(TAG,"In Wwozplaylists.onClickTitle(), setting titleParam to titleChoice"+titleChoice);
				} else {
				    titleChoice = currentTitleParam;
				    titleParam = currentTitleParam;
				    pagerCounterTotal = 0;
				}
			}
			// pagerCounterTotal = 0;
			// pagerCounter = 0;
		}
		Cursor c = db.getByTitle(titleParam);
		Toast.makeText(this, Integer.toString(Wwozplaylists.sqlCount)+" total records for Title = \""+titleChoice+"\". Showing up to 100 records, starting from "+Integer.toString(Wwozplaylists.pagerCounterTotal+1), Toast.LENGTH_LONG).show();
		String results = "";
		if (c != null) {
			//Log.w(TAG,"In Wwozplaylists.onClickTitle(), cursor c is not null.");
		}
		//Log.w(TAG,"In Wwozplaylists.onClickTitle(), about to c.moveToFirst()");
		if (c.moveToFirst()) {
			//Log.w(TAG,"In Wwozplaylists.onClickTitle(), c.moveToFirst() returned true");
			do {
				pagerCounter++;
				// results += "Occurred: " + c.getString(0) + "\nReported: " +
				// c.getString(1) + "\nCity/State: " + c.getString(2) +
				// "\nUfo Shape: " + c.getString(3) + "\nEvent Duration: " +
				// c.getString(4) + "\nDescription: " + c.getString(5) + "___";
				results += c.getString(0)+"\n" + c.getString(1) + "\n" + c.getString(2)+ "\n" + c.getString(3) + "___";

			} while (c.moveToNext());
		}
		// if(pagerCounter == 10) {
		// if(pagerCounter > 8) {
		// for search term 'urgent' 8 results were returned??? actual DB has 27
		// hmmm??
		// if(pagerCounter > 7) {
		if (pagerCounter == 100) {
			pagerCounterTotal += 100;
			pagerCounter = 0;
			//Log.w(TAG,"In Wwozplaylists.onClickTitle(), pagerCounter was ten, now: "+ Integer.toString(pagerCounter));
			//Log.w(TAG,"In Wwozplaylists.onClickTitle(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
			//Log.w(TAG,"In Wwozplaylists.onClickTitle(), titleChoice is: "+ titleChoice);
		} else {
			// results+=Integer.toString(pagerCounter);
			//Log.w(TAG,"In Wwozplaylists.onClickTitle(), pagerCounter is NOT ten, it is: "+ Integer.toString(pagerCounter));
			pagerCounterTotal = 0;
			pagerCounter = 0;
			//showChoice = "";
			//locationType = "";
			//Log.w(TAG,"In Wwozplaylists.onClickTitle(), pagerCounter is NOT ten: "+ Integer.toString(pagerCounter));
			//Log.w(TAG,"In Wwozplaylists.onClickTitle(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
			//Log.w(TAG,"In Wwozplaylists.onClickTitle(), titleChoice is: "+ titleChoice);
		}
		//Log.w(TAG, "In Wwozplaylists.onClickTitle(), about to db.close()");
		Intent iResults = new Intent("com.jimsuplee.wwozplaylists.Results");
		iResults.putExtra("results", results);
		startActivityForResult(iResults, 3);
		db.close();
	}

	public void onClickArtist(View view) {
		//Log.w(TAG, "In Wwozplaylists.onClickArtist()");
		pagerCounter = 0;
		//pagerCounterTotal is NOT set to 0 here because it is sometimes called from onClickShowMore()
		
		showChoice="";
		titleChoice="";
		albumChoice="";
		//Normally, there is a value here, because the user entered something:
		EditText txt_artist = (EditText) findViewById(R.id.txt_artist);
		// ..but if not, then its because they used "Top Artist"
		db.open();
		String artistParam;
		if (artistChoice == "") {
			// txt_artist was obtained a few lines above
			artistParam = txt_artist.getText().toString();
			artistChoice = artistParam;
			//Log.w(TAG, "In Wwozplaylists.onClickArtist(), artistChoice WAS empty.");
			//Log.w(TAG, "In Wwozplaylists.onClickArtist(), artistChoice NOW: "	+ artistChoice);
			pagerCounterTotal = 0;
		} else {
			//Log.w(TAG,"In Wwozplaylists.onClickArtist(), artistChoice IS NOT empty.");
			//Log.w(TAG,"In Wwozplaylists.onClickArtist(), reuse artistChoice: "+ artistChoice);
			String currentArtistParam = txt_artist.getText().toString();
			// If the user hasn't typed in a different search item:
			if (artistChoice.equals(currentArtistParam)) {
				//Log.w(TAG,"In Wwozplaylists.onClickArtist(), same search choice: "+ artistChoice + currentArtistParam);
				artistParam = artistChoice;
			} else {
				// In this case, Wwozplaylists.artistChoice is not empty.
				// However, we cannot reuse Wwozplaylists.artistChoice if
				// the user has since typed in a different value to search by.
				// Remember that onClickDescription() is called for new
				// searches and for "next 10" pager requests. Therefore, this
				// logic is required. Further, if this is a new search, then
				// we also want to reset pagerCountTotal to 0.
				//Log.w(TAG,"In Wwozplaylists.onClickArtist(), NOT same search choice: "+ artistChoice + currentArtistParam);
                //WORKS, but not for TopArtist, next two lines:
				//artistChoice = currentArtistParam;
				//artistParam = currentArtistParam;
				if(currentArtistParam.isEmpty()) {
					artistParam=artistChoice;
					//Log.w(TAG,"In Wwozplaylists.onClickArtist(), currentArtistParam.isEmpty()");
					//Log.w(TAG,"In Wwozplaylists.onClickArtist(), setting artistParam to artistChoice"+artistChoice);
				} else {
				    artistChoice = currentArtistParam;
				    artistParam = currentArtistParam;
				    pagerCounterTotal = 0;
				}
			}
		}
		Cursor c = db.getByArtist(artistParam);
		Toast.makeText(this, Integer.toString(Wwozplaylists.sqlCount)+" total records for Artist = \""+artistChoice+"\". Showing up to 100 records, starting from "+Integer.toString(Wwozplaylists.pagerCounterTotal+1), Toast.LENGTH_LONG).show();
		String results = "";
		if (c != null) {
			//Log.w(TAG,"In Wwozplaylists.onClickArtist(), cursor c is not null.");
		}
		//Log.w(TAG,"In Wwozplaylists.onClickArtist(), about to c.moveToFirst()");
		if (c.moveToFirst()) {
			//Log.w(TAG,"In Wwozplaylists.onClickArtist(), c.moveToFirst() returned true");
			do {
				pagerCounter++;
				results += c.getString(0)+"\n" + c.getString(1) + "\n" + c.getString(2)+ "\n" + c.getString(3) + "___";
			} while (c.moveToNext());
		}
		if (pagerCounter == 100) {
			pagerCounterTotal += 100;
			pagerCounter = 0;
			//Log.w(TAG,"In Wwozplaylists.onClickArtist(), pagerCounter was ten, now: "+ Integer.toString(pagerCounter));
			//Log.w(TAG,"In Wwozplaylists.onClickArtist(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
			//Log.w(TAG,"In Wwozplaylists.onClickArtist(), artistChoice is: "+ artistChoice);
		} else {
			//Log.w(TAG,"In Wwozplaylists.onClickArtist(), pagerCounter is NOT ten, it is: "+ Integer.toString(pagerCounter));
			pagerCounterTotal = 0;
			pagerCounter = 0;
			//showChoice = "";
			//locationType = "";
			//Log.w(TAG,"In Wwozplaylists.onClickArtist(), pagerCounter is NOT ten: "+ Integer.toString(pagerCounter));
			//Log.w(TAG,"In Wwozplaylists.onClickArtist(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
			//Log.w(TAG,"In Wwozplaylists.onClickArtist(), artistChoice is: "+ artistChoice);
		}
		//Log.w(TAG, "In Wwozplaylists.onClickArtist(), about to db.close()");
		Intent iResults = new Intent("com.jimsuplee.wwozplaylists.Results");
		iResults.putExtra("results", results);
		startActivityForResult(iResults, 3);
		db.close();
	}

	public void onClickAlbum(View view) {
		//Log.w(TAG, "In Wwozplaylists.onClickShow()");
		pagerCounter = 0;
		//pagerCounterTotal is NOT set to 0 here because it is sometimes called from onClickShowMore()
		//pagerCounterTotal = 0;
		showChoice="";
		titleChoice="";
		artistChoice="";
		//Intent iShow = new Intent("com.jimsuplee.wwozplaylists.Show");
		//startActivityForResult(iShow, 0);
		EditText txt_album = (EditText) findViewById(R.id.txt_album);
		db.open();
		String albumParam;
		if (albumChoice == "") {
			// txt_description was obtained a few lines above
			albumParam = txt_album.getText().toString();
			albumChoice = albumParam;
			//Log.w(TAG, "In Wwozplaylists.onClickAlbum(), albumChoice WAS empty.");
			//Log.w(TAG, "In Wwozplaylists.onClickAlbum(), albumChoice NOW: "	+ albumChoice);
			pagerCounterTotal = 0;
		} else {
			//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), albumChoice IS NOT empty.");
			//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), reuse albumChoice: "+ albumChoice);
			String currentAlbumParam = txt_album.getText().toString();
			// If the user hasn't typed in a different search item:
			if (albumChoice.equals(currentAlbumParam)) {
				//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), same search choice: "+ albumChoice + currentAlbumParam);
				albumParam = albumChoice;
			} else {
				// In this case, Ufosightings.albumChoice is not empty.
				// However, we cannot reuse Ufosightings.albumChoice if
				// the user has since typed in a different value to search by.
				// Remember that onClickDescription() is called for new
				// searches and for "next 10" pager requests. Therefore, this
				// logic is required. Further, if this is a new search, then
				// we also want to reset pagerCountTotal to 0.
				//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), NOT same search choice: "+ albumChoice + currentAlbumParam);

				//WORKS, next three lines, but not with TopAlbum
				//albumChoice = currentAlbumParam;
				//albumParam = currentAlbumParam;
				//pagerCounterTotal = 0;
				if(currentAlbumParam.isEmpty()) {
					albumParam=albumChoice;
					//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), currentAlbumParam.isEmpty()");
					//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), setting albumParam to albumChoice"+albumChoice);
				} else {
				    albumChoice = currentAlbumParam;
				    albumParam = currentAlbumParam;
				    pagerCounterTotal = 0;
				}
			}
			// pagerCounterTotal = 0;
			// pagerCounter = 0;
		}
		Cursor c = db.getByAlbum(albumParam);
		Toast.makeText(this, Integer.toString(Wwozplaylists.sqlCount)+" total records for Album = \""+albumChoice+"\". Showing up to 100 records, starting from "+Integer.toString(Wwozplaylists.pagerCounterTotal+1), Toast.LENGTH_LONG).show();
		String results = "";
		if (c != null) {
			//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), cursor c is not null.");
		}
		//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), about to c.moveToFirst()");
		if (c.moveToFirst()) {
			//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), c.moveToFirst() returned true");
			do {
				pagerCounter++;
				// results += "Occurred: " + c.getString(0) + "\nReported: " +
				// c.getString(1) + "\nCity/State: " + c.getString(2) +
				// "\nUfo Shape: " + c.getString(3) + "\nEvent Duration: " +
				// c.getString(4) + "\nDescription: " + c.getString(5) + "___";
				results += c.getString(0)+"\n" + c.getString(1) + "\n" + c.getString(2)+ "\n" + c.getString(3) + "___";

			} while (c.moveToNext());
		}
		// if(pagerCounter == 10) {
		// if(pagerCounter > 8) {
		// for search term 'urgent' 8 results were returned??? actual DB has 27
		// hmmm??
		// if(pagerCounter > 7) {
		if (pagerCounter == 100) {
			pagerCounterTotal += 100;
			pagerCounter = 0;
			//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), pagerCounter was ten, now: "+ Integer.toString(pagerCounter));
			//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
			//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), albumChoice is: "+ albumChoice);
		} else {
			// results+=Integer.toString(pagerCounter);
			//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), pagerCounter is NOT ten, it is: "+ Integer.toString(pagerCounter));
			pagerCounterTotal = 0;
			pagerCounter = 0;
			//showChoice = "";
			//locationType = "";
			//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), pagerCounter is NOT ten: "+ Integer.toString(pagerCounter));
			//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
			//Log.w(TAG,"In Wwozplaylists.onClickAlbum(), albumChoice is: "+ albumChoice);
		}
		//Log.w(TAG, "In Wwozplaylists.onClickAlbum(), about to db.close()");
		Intent iResults = new Intent("com.jimsuplee.wwozplaylists.Results");
		iResults.putExtra("results", results);
		startActivityForResult(iResults, 3);
		db.close();
	}
	
	public void onClickArtistTitle(View view) {
		//Log.w(TAG, "In Wwozplaylists.onClickArtistTitle()");
		pagerCounter = 0;
		showChoice="";
		//titleChoice="";
		albumChoice="";
		EditText txt_artisttitleartist = (EditText) findViewById(R.id.txt_artisttitleartist);
		EditText txt_artisttitletitle = (EditText) findViewById(R.id.txt_artisttitletitle);
		db.open();
		String artistParam;
		String titleParam;
		if (artistChoice == "" && titleChoice == "") {
			// txt_artist was obtained a few lines above
			artistParam = txt_artisttitleartist.getText().toString();
			titleParam = txt_artisttitletitle.getText().toString();
			artistChoice = artistParam;
			titleChoice = titleParam;
			//Log.w(TAG, "In Wwozplaylists.onClickArtistTitle(), artistChoice WAS empty.");
			//Log.w(TAG, "In Wwozplaylists.onClickArtistTitle(), artistChoice NOW: "	+ artistChoice);
			//Log.w(TAG, "In Wwozplaylists.onClickArtistTitle(), titleChoice WAS empty.");
			//Log.w(TAG, "In Wwozplaylists.onClickArtistTitle(), titleChoice NOW: "	+ titleChoice);
			pagerCounterTotal = 0;
		} else {
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), artistChoice or titleChoice IS NOT empty.");
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), reuse artistChoice: "+ artistChoice);
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), artistChoice or titleChoice IS NOT empty.");
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), reuse titleChoice: "+ titleChoice);
			String currentArtistParam = txt_artisttitleartist.getText().toString();
			String currentTitleParam = txt_artisttitletitle.getText().toString();
			// If the user hasn't typed in a different search item:
			if (artistChoice.equals(currentArtistParam) && titleChoice.equals(currentTitleParam)) {
				//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), same search choice: "+ artistChoice + currentArtistParam);
				//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), same search choice: "+ titleChoice + currentTitleParam);
				artistParam = artistChoice;
				titleParam = titleChoice;
			} else {
				// In this case, Wwozplaylists.artistChoice is not empty.
				// However, we cannot reuse Wwozplaylists.artistChoice if
				// the user has since typed in a different value to search by.
				// Remember that onClickDescription() is called for new
				// searches and for "next 10" pager requests. Therefore, this
				// logic is required. Further, if this is a new search, then
				// we also want to reset pagerCountTotal to 0.
				//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), NOT same search choice artistChoice: "+ artistChoice + " currentArtistParam " + currentArtistParam);
				//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), NOT same search choice titleChoice: "+ titleChoice + " currentTitleParam " + currentTitleParam);

				artistChoice = currentArtistParam;
				artistParam = currentArtistParam;

				titleChoice = currentTitleParam;
				titleParam = currentTitleParam;
				pagerCounterTotal = 0;
			}
		}
		Cursor c = db.getByArtistTitle(artistParam, titleParam);
		Toast.makeText(this, Integer.toString(Wwozplaylists.sqlCount)+" total records for Artist = \""+artistChoice+"\", Title = \""+titleChoice+"\". Showing up to 100 records, starting from "+Integer.toString(Wwozplaylists.pagerCounterTotal+1), Toast.LENGTH_LONG).show();
		String results = "";
		if (c != null) {
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), cursor c is not null.");
		}
		//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), about to c.moveToFirst()");
		if (c.moveToFirst()) {
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), c.moveToFirst() returned true");
			do {
				pagerCounter++;
				results += c.getString(0)+"\n" + c.getString(1) + "\n" + c.getString(2)+ "\n" + c.getString(3) + "___";
			} while (c.moveToNext());
		}
		if (pagerCounter == 100) {
			pagerCounterTotal += 100;
			pagerCounter = 0;
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), pagerCounter was ten, now: "+ Integer.toString(pagerCounter));
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), artistChoice is: "+ artistChoice);
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), titleChoice is: "+ titleChoice);
		} else {
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), pagerCounter is NOT ten, it is: "+ Integer.toString(pagerCounter));
			pagerCounterTotal = 0;
			pagerCounter = 0;
			//showChoice = "";
			//locationType = "";
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), pagerCounter is NOT ten: "+ Integer.toString(pagerCounter));
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), artistChoice is: "+ artistChoice);
			//Log.w(TAG,"In Wwozplaylists.onClickArtistTitle(), titleChoice is: "+ titleChoice);
		}
		//Log.w(TAG, "In Wwozplaylists.onClickArtistTitle(), about to db.close()");
		Intent iResults = new Intent("com.jimsuplee.wwozplaylists.Results");
		iResults.putExtra("results", results);
		startActivityForResult(iResults, 3);
		db.close();
	}
	
	public void onClickAdvanced(View view) {
		//Log.w(TAG, "In Wwozplaylists.onClickAdvanced()");
		pagerCounter = 0;
		pagerCounterTotal = 0;
		//Turn off the pager button, no matter what when clicking on Help button
		Button pagerButton = (Button) findViewById(R.id.btn_ShowPager);
	    pagerButton.setVisibility(View.INVISIBLE);
		showChoice="";
		titleChoice="";
		artistChoice="";
		albumChoice="";
		//Toast.makeText(this, "WWOZ is the greatest radio station in the world. To donate, call 1 877 907 6999.", Toast.LENGTH_LONG).show();
		//TextView tvshow = (TextView) findViewById(R.id.txt_Songdata);
		//tvshow.setVisibility(View.INVISIBLE);
		//TextView tv = (TextView) findViewById(R.id.txt_Songsearch);
	    //tv.setVisibility(View.VISIBLE);
	    //tv.setText(R.string.helptext);
		TextView txt_Songdata = (TextView) findViewById(R.id.txt_Songdata);
		txt_Songdata.setVisibility(View.VISIBLE);
		TextView txt_Songsearch = (TextView) findViewById(R.id.txt_Songsearch);
		txt_Songsearch.setVisibility(View.VISIBLE);
		//Button btn_ShowPager = (Button) findViewById(R.id.btn_ShowPager);
		//btn_ShowPager.setVisibility(View.VISIBLE);
		EditText txt_title = (EditText) findViewById(R.id.txt_title);
		txt_title.setVisibility(View.VISIBLE);
		Button btn_Title = (Button) findViewById(R.id.btn_Title);
		btn_Title.setVisibility(View.VISIBLE);
		EditText txt_artist = (EditText) findViewById(R.id.txt_artist);
		txt_artist.setVisibility(View.VISIBLE);
		Button btn_Artist = (Button) findViewById(R.id.btn_Artist);
		btn_Artist.setVisibility(View.VISIBLE);
		EditText txt_album = (EditText) findViewById(R.id.txt_album);
		txt_album.setVisibility(View.VISIBLE);
		Button btn_Album = (Button) findViewById(R.id.btn_Album);
		btn_Album.setVisibility(View.VISIBLE);
		EditText txt_artisttitleartist = (EditText) findViewById(R.id.txt_artisttitleartist);
		txt_artisttitleartist.setVisibility(View.VISIBLE);
		EditText txt_artisttitletitle = (EditText) findViewById(R.id.txt_artisttitletitle);
		txt_artisttitletitle.setVisibility(View.VISIBLE);
		Button btn_ArtistTitle = (Button) findViewById(R.id.btn_ArtistTitle);
		btn_ArtistTitle.setVisibility(View.VISIBLE);
		TextView tv_shows = (TextView) findViewById(R.id.tv_shows);
		tv_shows.setVisibility(View.VISIBLE);
		
		TextView tv_top = (TextView) findViewById(R.id.tv_top);
		tv_top.setVisibility(View.VISIBLE);
		TextView tv_artist = (TextView) findViewById(R.id.tv_artist);
		tv_artist.setVisibility(View.VISIBLE);
		TextView tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setVisibility(View.VISIBLE);
		TextView tv_album = (TextView) findViewById(R.id.tv_album);
		tv_album.setVisibility(View.VISIBLE);
		TextView tv_artisttitle = (TextView) findViewById(R.id.tv_artisttitle);
		tv_artisttitle.setVisibility(View.VISIBLE);
		
		Button btn_Show = (Button) findViewById(R.id.btn_Show);
		btn_Show.setVisibility(View.VISIBLE);
		Button btn_Showtitle = (Button) findViewById(R.id.btn_Showtitle);
		btn_Showtitle.setVisibility(View.VISIBLE);
		Button btn_Showartist = (Button) findViewById(R.id.btn_Showartist);
		btn_Showartist.setVisibility(View.VISIBLE);
		Button btn_Showalbum = (Button) findViewById(R.id.btn_Showalbum);
		btn_Showalbum.setVisibility(View.VISIBLE);
		Button btn_Advanced = (Button) findViewById(R.id.btn_Advanced);
		btn_Advanced.setVisibility(View.VISIBLE);
		Button btn_Help = (Button) findViewById(R.id.btn_Help);
		btn_Help.setVisibility(View.VISIBLE);
		txt_Songsearch.setText(R.string.helptext);
		EditText txt_easy = (EditText) findViewById(R.id.txt_easy);
		txt_easy.setVisibility(View.INVISIBLE);
		Button btn_Easy = (Button) findViewById(R.id.btn_Easy);
		btn_Easy.setVisibility(View.INVISIBLE);
	}
	
	public void onClickNotadvanced(View view) {
		//Log.w(TAG, "In Wwozplaylists.onClickAdvanced()");
		pagerCounter = 0;
		pagerCounterTotal = 0;
		//Turn off the pager button, no matter what when clicking on Help button
		Button pagerButton = (Button) findViewById(R.id.btn_ShowPager);
	    pagerButton.setVisibility(View.INVISIBLE);
		showChoice="";
		titleChoice="";
		artistChoice="";
		albumChoice="";
		//Toast.makeText(this, "WWOZ is the greatest radio station in the world. To donate, call 1 877 907 6999.", Toast.LENGTH_LONG).show();
		//TextView tvshow = (TextView) findViewById(R.id.txt_Songdata);
		//tvshow.setVisibility(View.INVISIBLE);
		//TextView tv = (TextView) findViewById(R.id.txt_Songsearch);
	    //tv.setVisibility(View.VISIBLE);
	    //tv.setText(R.string.helptext);
		TextView txt_Songdata = (TextView) findViewById(R.id.txt_Songdata);
		txt_Songdata.setVisibility(View.VISIBLE);
		TextView txt_Songsearch = (TextView) findViewById(R.id.txt_Songsearch);
		txt_Songsearch.setVisibility(View.VISIBLE);
		//Button btn_ShowPager = (Button) findViewById(R.id.btn_ShowPager);
		//btn_ShowPager.setVisibility(View.VISIBLE);
		EditText txt_title = (EditText) findViewById(R.id.txt_title);
		txt_title.setVisibility(View.INVISIBLE);
		Button btn_Title = (Button) findViewById(R.id.btn_Title);
		btn_Title.setVisibility(View.INVISIBLE);
		EditText txt_artist = (EditText) findViewById(R.id.txt_artist);
		txt_artist.setVisibility(View.INVISIBLE);
		Button btn_Artist = (Button) findViewById(R.id.btn_Artist);
		btn_Artist.setVisibility(View.INVISIBLE);
		EditText txt_album = (EditText) findViewById(R.id.txt_album);
		txt_album.setVisibility(View.INVISIBLE);
		Button btn_Album = (Button) findViewById(R.id.btn_Album);
		btn_Album.setVisibility(View.INVISIBLE);
		EditText txt_artisttitleartist = (EditText) findViewById(R.id.txt_artisttitleartist);
		txt_artisttitleartist.setVisibility(View.INVISIBLE);
		EditText txt_artisttitletitle = (EditText) findViewById(R.id.txt_artisttitletitle);
		txt_artisttitletitle.setVisibility(View.INVISIBLE);
		Button btn_ArtistTitle = (Button) findViewById(R.id.btn_ArtistTitle);
		btn_ArtistTitle.setVisibility(View.INVISIBLE);
		TextView tv_shows = (TextView) findViewById(R.id.tv_shows);
		tv_shows.setVisibility(View.INVISIBLE);
		
		//TextView tv_top = (TextView) findViewById(R.id.tv_top);
		//tv_top.setVisibility(View.INVISIBLE);
		TextView tv_artist = (TextView) findViewById(R.id.tv_artist);
		tv_artist.setVisibility(View.INVISIBLE);
		TextView tv_title = (TextView) findViewById(R.id.tv_title);
		tv_title.setVisibility(View.INVISIBLE);
		TextView tv_album = (TextView) findViewById(R.id.tv_album);
		tv_album.setVisibility(View.INVISIBLE);
		TextView tv_artisttitle = (TextView) findViewById(R.id.tv_artisttitle);
		tv_artisttitle.setVisibility(View.INVISIBLE);
		
		Button btn_Show = (Button) findViewById(R.id.btn_Show);
		btn_Show.setVisibility(View.INVISIBLE);
		Button btn_Showtitle = (Button) findViewById(R.id.btn_Showtitle);
		btn_Showtitle.setVisibility(View.INVISIBLE);
		Button btn_Showartist = (Button) findViewById(R.id.btn_Showartist);
		btn_Showartist.setVisibility(View.INVISIBLE);
		Button btn_Showalbum = (Button) findViewById(R.id.btn_Showalbum);
		btn_Showalbum.setVisibility(View.INVISIBLE);
		Button btn_Advanced = (Button) findViewById(R.id.btn_Advanced);
		btn_Advanced.setVisibility(View.VISIBLE);
		Button btn_Help = (Button) findViewById(R.id.btn_Help);
		btn_Help.setVisibility(View.VISIBLE);
		txt_Songsearch.setText(R.string.helptext);
		EditText txt_easy = (EditText) findViewById(R.id.txt_easy);
		txt_easy.setVisibility(View.VISIBLE);
		Button btn_Easy = (Button) findViewById(R.id.btn_Easy);
		btn_Easy.setVisibility(View.VISIBLE);
	}
	
	public void onClickHelp(View view) {
		//Log.w(TAG, "In Wwozplaylists.onClickHelp()");
		pagerCounter = 0;
		pagerCounterTotal = 0;
		//Turn off the pager button, no matter what when clicking on Help button
		Button pagerButton = (Button) findViewById(R.id.btn_ShowPager);
	    pagerButton.setVisibility(View.INVISIBLE);
		showChoice="";
		titleChoice="";
		artistChoice="";
		albumChoice="";
		Toast.makeText(this, "WWOZ is the greatest radio station in the world. To donate, call 1 877 907 6999.", Toast.LENGTH_LONG).show();
		TextView tvshow = (TextView) findViewById(R.id.txt_Songdata);
		tvshow.setVisibility(View.INVISIBLE);
		TextView tv = (TextView) findViewById(R.id.txt_Songsearch);
	    tv.setVisibility(View.VISIBLE);
	    tv.setText(R.string.helptext);
	}
	
	public void onClickNearby(View view) {
		//onClickNearby uses the value in Wwozplaylists.timeChoice to find songs that were 
		// played at about the same time as the song that was chosen.  That value for 
		// Wwozplaylists.timeChoice is set in Results.java after the user clicks on a song
		// that value was obtained from the time column in the database
		//Log.w(TAG, "In Wwozplaylists.onClickNearby()");
		Toast.makeText(this, "Finding songs played during that same hour.", Toast.LENGTH_LONG).show();
		pagerCounter = 0;
		pagerCounterTotal = 0;
		//Turn off the pager button, no matter what when clicking on Help button
		Button pagerButton = (Button) findViewById(R.id.btn_ShowPager);
	    pagerButton.setVisibility(View.INVISIBLE);
		showChoice="";
		titleChoice="";
		artistChoice="";
		albumChoice="";
		db.open();
		//timeChoice="";
		Cursor c = db.getByNearby();		
		if (c != null) {
			//Log.w(TAG,"In Wwozplaylists.onClickNearby(), cursor c is not null.");
		}
		//Log.w(TAG,"In Wwozplaylists.onClickNearby(), about to c.moveToFirst()");
		String results = "";
		if (c.moveToFirst()) {
			//Log.w(TAG,"In Wwozplaylists.onClickNearby(), c.moveToFirst() returned true");
			do {
				pagerCounter++;
				results += c.getString(0)+"\n" + c.getString(1) + "\n" + c.getString(2)+ "\n" + c.getString(3) + "___";
			} while (c.moveToNext());
		}		
		if (pagerCounter == 100) {
			pagerCounterTotal += 100;
			pagerCounter = 0;
			//Log.w(TAG,"In Wwozplaylists.onClickNearby(), pagerCounter was ten, now: "+ Integer.toString(pagerCounter));
			//Log.w(TAG,"In Wwozplaylists.onClickNearby(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
			//Log.w(TAG,"In Wwozplaylists.onClickNearby(), artistChoice is: "+ artistChoice);
			//Log.w(TAG,"In Wwozplaylists.onClickNearby(), titleChoice is: "+ titleChoice);
		} else {
			//Log.w(TAG,"In Wwozplaylists.onClickNearby(), pagerCounter is NOT ten, it is: "+ Integer.toString(pagerCounter));
			pagerCounterTotal = 0;
			pagerCounter = 0;
			//showChoice = "";
			//locationType = "";
			//Log.w(TAG,"In Wwozplaylists.onClickNearby(), pagerCounter is NOT ten: "+ Integer.toString(pagerCounter));
			//Log.w(TAG,"In Wwozplaylists.onClickNearby(), pagerCounterTotal is: "+ Integer.toString(pagerCounterTotal));
			//Log.w(TAG,"In Wwozplaylists.onClickNearby(), artistChoice is: "+ artistChoice);
			//Log.w(TAG,"In Wwozplaylists.onClickNearby(), titleChoice is: "+ titleChoice);
		}
		//Log.w(TAG, "In Wwozplaylists.onClickNearby(), about to db.close()");
		Intent iResults = new Intent("com.jimsuplee.wwozplaylists.Results");
		iResults.putExtra("results", results);
		startActivityForResult(iResults, 3);
		db.close();
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// ---check if the request code is 0 1 2 3 4 5---
		////Log.w(TAG, "In Wwozplaylists.onActivityResult(), checking reqCod");
		// onClickShow startActivityForResult section
		if (requestCode == 0) {
			////Log.w(TAG, "In Wwozplaylists.onActivityResult(int-reqCode=0,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				Toast.makeText(this, showMap.get(showChoice), Toast.LENGTH_LONG).show();
				db.open();
				String show = data.getData().toString();	
				Cursor c = db.getByShow(show);
				String results = "";
				if (c != null) {
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor is not null");
				}
				int counterResults = 0;
				if (c.moveToFirst()) {
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor.moveToFirst() is true, about to loop through results");
					do {
						pagerCounter++;
						counterResults++;						
						//results += "Affected: " + getString(0) + "Cost: " + getString(1) + "Country: " + getString(2) + "End: " + getString(3) + "Id: " + getString(4) + "Killed: " + getString(5) + "Show: " + getString(6) + "Name: " + getString(7) + "Start: " + getString(8) + "Sub_Type: " + getString(9) + "Type: " + getString(10)
			 		    //results += "\nStartyear: " + c.getString(9) +"\nType: " + c.getString(11) + "\nSub_Type: " + c.getString(10) + "\nCountry: " + c.getString(2) +"\nShow: " + c.getString(6) +"\nKilled: " + c.getString(5) +"\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +"\nStart: " + c.getString(9) + c.getString(8) + "\nEnd: " + c.getString(3) + "\nName: " + c.getString(7) +"\nId: " + c.getString(4) + "___";
						results += c.getString(0)+"\n" + c.getString(1) + "\n" + c.getString(2)+ "\n" + c.getString(3) + "___";
					} while (c.moveToNext());
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor.moveToFirst(), finished loop with " + Integer.toString(counterResults));
				} else {
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor.moveToFirst() is NOT TRUE!");
				}

				if (pagerCounter == 100) {
					pagerCounterTotal += 100;
					pagerCounter = 0;
					//showType = "showCity";
				} else {
					//results+=Integer.toString(pagerCounter);
					pagerCounterTotal = 0;
					pagerCounter = 0;
					showChoice = "";
					//showType = "";
				}
				Intent iResults = new Intent("com.jimsuplee.wwozplaylists.Results");
				iResults.putExtra("results", results);
				//Log.w(TAG, "In Wwozplaylists.onActivityResult(), about to startActivityForResult(iResults, 3)");
				startActivityForResult(iResults, 3);
				//Log.w(TAG, "In Wwozplaylists.onActivityResult(), iResults started, about to db.close()");
				db.close();
			}
		}
		if (requestCode == 3) {
			////Log.w(TAG, "In Wwozplaylists.onActivityResult(int-reqCode=3,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				//Log.w(TAG, "In Wwozplaylists.onActivityResult(3) RESULT_OK, about to set TextView");
				//String songData = Html.fromHtml(data.getData().toString()).toString();
				// The next if/else lines decide whether there are more (than
				// the last 10) records
				// If so, then make-visible the proper 10-more-records button in
				// activity_wwozplaylists.xml
				// Decide and set visibility of the LocationPager
				Button pagerButton = (Button) findViewById(R.id.btn_ShowPager);
				//if (pagerCounterTotal > 0 && locationType == "locationCity") {
				if (pagerCounterTotal > 0) {
						pagerButton.setVisibility(View.VISIBLE);
				} else {
					pagerButton.setVisibility(View.INVISIBLE);
				}
				//pagerButton = (Button) findViewById(R.id.btn_TypePager);
				//if (pagerCounterTotal > 0 && titleChoice != "") {
				//	pagerButton.setVisibility(View.VISIBLE);
				//} else {
				//	pagerButton.setVisibility(View.INVISIBLE);
				//}
				String orderByText = "";
				if(orderBy=="") {
					;
				} else {
					orderByText = " (in "+orderBy+" order)";
				}
				String showData = showMap.get(showChoice);
				if(showData==null) {
					showData="Any show"+orderByText;
				} else {
					showData=showData+orderByText;
				}
				TextView tvshow = (TextView) findViewById(R.id.txt_Songdata);
				tvshow.setVisibility(View.VISIBLE);
				tvshow.setText(showData);
				
				String songData = data.getData().toString();
				TextView tv = (TextView) findViewById(R.id.txt_Songsearch);
				tv.setVisibility(View.VISIBLE);
				tv.setText(songData);
				
				Button btn_Nearby = (Button) findViewById(R.id.btn_Nearby);
				btn_Nearby.setVisibility(View.VISIBLE);
				//ImageView iv = (ImageView) findViewById(R.id.imagedetail);
            	//if(photoMap.get(Wwozplaylists.country) != null) {
            		////Log.w(TAG, "In Wwozplaylists.onActivityResult(3) photoMap ok, about to set ImageView to"+Wwozplaylists.country);
            	    //iv.setImageResource(photoMap.get(Wwozplaylists.country));
            		//iv.setImageResource(photoMap.get(country));
            	    //iv.setVisibility(View.VISIBLE);
            	//} else {
            		////Log.w(TAG, "In Wwozplaylists.onActivityResult(3) photoMap empty, about to set ImageView to"+Wwozplaylists.country);
            	    //iv.setImageResource(photoMap.get(Wwozplaylists.country));
            		//iv.setImageResource(R.drawable.disasters);
            	    //iv.setVisibility(View.VISIBLE);
            	//}
			}
		}
		if (requestCode == 4) {
			////Log.w(TAG, "In Wwozplaylists.onActivityResult(int-reqCode=4,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				//Toast.makeText(this, showMap.get(showChoice), Toast.LENGTH_LONG).show();
				db.open();
				String title = data.getData().toString();	
				Cursor c = db.getByTitle(title);
				String results = "";
				if (c != null) {
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor is not null");
				}
				int counterResults = 0;
				if (c.moveToFirst()) {
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor.moveToFirst() is true, about to loop through results");
					do {
						pagerCounter++;
						counterResults++;						
						//results += "Affected: " + getString(0) + "Cost: " + getString(1) + "Country: " + getString(2) + "End: " + getString(3) + "Id: " + getString(4) + "Killed: " + getString(5) + "Show: " + getString(6) + "Name: " + getString(7) + "Start: " + getString(8) + "Sub_Type: " + getString(9) + "Type: " + getString(10)
			 		    //results += "\nStartyear: " + c.getString(9) +"\nType: " + c.getString(11) + "\nSub_Type: " + c.getString(10) + "\nCountry: " + c.getString(2) +"\nShow: " + c.getString(6) +"\nKilled: " + c.getString(5) +"\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +"\nStart: " + c.getString(9) + c.getString(8) + "\nEnd: " + c.getString(3) + "\nName: " + c.getString(7) +"\nId: " + c.getString(4) + "___";
						results += c.getString(0)+"\n" + c.getString(1) + "\n" + c.getString(2)+ "\n" + c.getString(3) + "___";
					} while (c.moveToNext());
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor.moveToFirst(), finished loop with " + Integer.toString(counterResults));
				} else {
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor.moveToFirst() is NOT TRUE!");
				}

				if (pagerCounter == 100) {
					pagerCounterTotal += 100;
					pagerCounter = 0;
					//showType = "showCity";
				} else {
					//results+=Integer.toString(pagerCounter);
					pagerCounterTotal = 0;
					pagerCounter = 0;
					showChoice = "";
					//showType = "";
				}
				Intent iResults = new Intent("com.jimsuplee.wwozplaylists.Results");
				iResults.putExtra("results", results);
				//Log.w(TAG, "In Wwozplaylists.onActivityResult(), about to startActivityForResult(iResults, 3)");
				startActivityForResult(iResults, 3);
				//Log.w(TAG, "In Wwozplaylists.onActivityResult(), iResults started, about to db.close()");
				db.close();
			}
		}
		if (requestCode == 5) {
			////Log.w(TAG, "In Wwozplaylists.onActivityResult(int-reqCode=5,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				//Toast.makeText(this, showMap.get(showChoice), Toast.LENGTH_LONG).show();
				db.open();
				String artist = data.getData().toString();	
				Cursor c = db.getByArtist(artist);
				String results = "";
				if (c != null) {
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor is not null");
				}
				int counterResults = 0;
				if (c.moveToFirst()) {
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor.moveToFirst() is true, about to loop through results");
					do {
						pagerCounter++;
						counterResults++;						
						//results += "Affected: " + getString(0) + "Cost: " + getString(1) + "Country: " + getString(2) + "End: " + getString(3) + "Id: " + getString(4) + "Killed: " + getString(5) + "Show: " + getString(6) + "Name: " + getString(7) + "Start: " + getString(8) + "Sub_Type: " + getString(9) + "Type: " + getString(10)
			 		    //results += "\nStartyear: " + c.getString(9) +"\nType: " + c.getString(11) + "\nSub_Type: " + c.getString(10) + "\nCountry: " + c.getString(2) +"\nShow: " + c.getString(6) +"\nKilled: " + c.getString(5) +"\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +"\nStart: " + c.getString(9) + c.getString(8) + "\nEnd: " + c.getString(3) + "\nName: " + c.getString(7) +"\nId: " + c.getString(4) + "___";
						results += c.getString(0)+"\n" + c.getString(1) + "\n" + c.getString(2)+ "\n" + c.getString(3) + "___";
					} while (c.moveToNext());
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor.moveToFirst(), finished loop with " + Integer.toString(counterResults));
				} else {
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor.moveToFirst() is NOT TRUE!");
				}

				if (pagerCounter == 100) {
					pagerCounterTotal += 100;
					pagerCounter = 0;
					//showType = "showCity";
				} else {
					//results+=Integer.toString(pagerCounter);
					pagerCounterTotal = 0;
					pagerCounter = 0;
					showChoice = "";
					//showType = "";
				}
				Intent iResults = new Intent("com.jimsuplee.wwozplaylists.Results");
				iResults.putExtra("results", results);
				//Log.w(TAG, "In Wwozplaylists.onActivityResult(), about to startActivityForResult(iResults, 3)");
				startActivityForResult(iResults, 3);
				//Log.w(TAG, "In Wwozplaylists.onActivityResult(), iResults started, about to db.close()");
				db.close();
			}
		}
		if (requestCode == 6) {
			////Log.w(TAG, "In Wwozplaylists.onActivityResult(int-reqCode=6,int-resCode,Intent-data)");
			if (resultCode == RESULT_OK) {
				//Toast.makeText(this, showMap.get(showChoice), Toast.LENGTH_LONG).show();
				db.open();
				String album = data.getData().toString();	
				Cursor c = db.getByAlbum(album);
				String results = "";
				if (c != null) {
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor is not null");
				}
				int counterResults = 0;
				if (c.moveToFirst()) {
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor.moveToFirst() is true, about to loop through results");
					do {
						pagerCounter++;
						counterResults++;						
						//results += "Affected: " + getString(0) + "Cost: " + getString(1) + "Country: " + getString(2) + "End: " + getString(3) + "Id: " + getString(4) + "Killed: " + getString(5) + "Show: " + getString(6) + "Name: " + getString(7) + "Start: " + getString(8) + "Sub_Type: " + getString(9) + "Type: " + getString(10)
			 		    //results += "\nStartyear: " + c.getString(9) +"\nType: " + c.getString(11) + "\nSub_Type: " + c.getString(10) + "\nCountry: " + c.getString(2) +"\nShow: " + c.getString(6) +"\nKilled: " + c.getString(5) +"\nAffected: " + c.getString(0) + "\nCost: " + c.getString(1) +"\nStart: " + c.getString(9) + c.getString(8) + "\nEnd: " + c.getString(3) + "\nName: " + c.getString(7) +"\nId: " + c.getString(4) + "___";
						results += c.getString(0)+"\n" + c.getString(1) + "\n" + c.getString(2)+ "\n" + c.getString(3) + "___";
					} while (c.moveToNext());
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor.moveToFirst(), finished loop with " + Integer.toString(counterResults));
				} else {
					//Log.w(TAG, "In Wwozplaylists.onActivityResult(), cursor.moveToFirst() is NOT TRUE!");
				}

				if (pagerCounter == 100) {
					pagerCounterTotal += 100;
					pagerCounter = 0;
					//showType = "showCity";
				} else {
					//results+=Integer.toString(pagerCounter);
					pagerCounterTotal = 0;
					pagerCounter = 0;
					showChoice = "";
					//showType = "";
				}
				Intent iResults = new Intent("com.jimsuplee.wwozplaylists.Results");
				iResults.putExtra("results", results);
				//Log.w(TAG, "In Wwozplaylists.onActivityResult(), about to startActivityForResult(iResults, 3)");
				startActivityForResult(iResults, 3);
				//Log.w(TAG, "In Wwozplaylists.onActivityResult(), iResults started, about to db.close()");
				db.close();
			}
		}
	}		
}


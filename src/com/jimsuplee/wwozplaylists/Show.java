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
import java.util.HashMap;
//import android.widget.Toast;

public class Show extends ListActivity {
	static final String TAG = "WWOZ";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (Wwozplaylists.showChoice == "") {
	        displayListView();
		} else {
			//Log.w(TAG,"In Show.onCreate(), Wwozplaylists.showChoice!=emptyString, setting showChoice to Wwozplaylists.showChoice and calling finish()");
			Intent i = new Intent("");
			String showChoice = Wwozplaylists.showChoice;
			i.setData(Uri.parse(showChoice));
			setResult(RESULT_OK, i);
			finish();
		}
	}


	private void displayListView() {
		List<String> showList = new ArrayList<String>();
        showList.add("Contemporary Jazz: The Deans List with Dean Ellis");
        showList.add("Overnight Jazz with Jelly Roll Justice");
        showList.add("The Morning Set with Joel Heavy D Dinerstein");
        showList.add("Traditional Jazz with Dan Meyer");
        showList.add("New Orleans Music Show with Murf Reeves");
        showList.add("Blues Eclectic with Andrew Grafe");
        showList.add("Jazz from the French Market with Sondra Bibb");
        showList.add("Blues and RandB with Gentilly Jr.");
        showList.add("Governors Mansion with The Governor");
        showList.add("Contemporary Jazz with Mockingbird");
        showList.add("Overnight Jazz with Johnny Woodstock");
        showList.add("The Morning Set with Mark LaMaire");
        showList.add("Traditional Jazz with Zach");
        showList.add("New Orleans Music Show with Ms. Smalls");
        showList.add("Soul Serenade with Marc Stone");
        showList.add("Jazz from the French Market with T.R. Johnson");
        showList.add("50s RandB with Neil Pellegrin");
        showList.add("Kitchen Sink with David Kunian");
        showList.add("Contemporary Jazz with Johnny Ray");
        showList.add("Overnight Jazz with Jelly Roll Justice");
        showList.add("The Morning Set with K. Balewa");
        showList.add("Fresh Fig Jam with Olivia Greene (Trad. Jazz)");
        showList.add("New Orleans Music Show with George Ingmire");
        showList.add("Sittin at the Crossroad with Big D (Blues)");
        showList.add("Jazz from the French Market with Maryse Dejean");
        showList.add("RandB Oldies with Rare On The Air");
        showList.add("Kitchen Sink with A.J. Rodrigue and A.A.");
        showList.add("Late Night Jazz with Russell");
        showList.add("The Spin Cycle with Old Man River");
        showList.add("The Morning Set with Scott Borne");
        showList.add("Traditional Jazz with Sally Young");
        showList.add("New Orleans Music Show with Sherwood Collins");
        showList.add("The Blues Ball with David Torkanowsky");
        showList.add("Jazz from the French Market with Jelly Roll Justice");
        showList.add("Blues and RandB with Missy Bowen");
        showList.add("Kitchen Sink with Brian McColgan");
        showList.add("Swing and Big Band with The Minister of Swing");
        showList.add("Overnight Jazz with Jellyroll Justice");
        showList.add("The Morning Set with Raymond Kent");
        showList.add("Traditional Jazz with Keith Hill");
        showList.add("New Orleans Music Show with Black Mold or Bill DeTurk");
        showList.add("The Blues Breakdown with Valerie The Problem Child Kacprzak");
        showList.add("Jazz from the French Market with Vin Chary");
        showList.add("Music of Mass Distraction with Black Mold");
        showList.add("The Rhythm Room with Allan Alski Laskey");
        showList.add("Midnight Blues with Moses");
        showList.add("Putumayo World Music Hour");
        showList.add("Jazz From Lincoln Center");
        showList.add("New Orleans All the Way Live on WWOZ");
        showList.add("Traditional Jazz and New Orleans Music with Big Pete");
        showList.add("Music in the Glen with Sean OMeara");
        showList.add("Tiene Sabor (Latin Show) with Yolanda Estrada");
        showList.add("Tudo Bem (Brazilian) with Dean Ellis or Suzanne Corley");
        showList.add("World Journey with Suzanne Corley");
        showList.add("Block Party with Brice Nice");
        showList.add("Soul Power with Soul Sister");
        showList.add("Awake and Willing with Peggy Lou");
        showList.add("Blues in the Night with Jamie DellApa");
        showList.add("Blues with Sam Cammarata");
        showList.add("The Sunday Morning Jazz Set with Mark Landesman");
        showList.add("The Gospel Show with Lauren Mastro");
        showList.add("Old Time Country and Bluegrass with Hazel The Delta Rambler");
        showList.add("Cajun and Zydeco with Charles Laborde or Jim Hobbs");
        showList.add("Acoustic Blues with Your Cousin Dimitri");
        showList.add("Sitting In with Elizabeth Meneray");
        showList.add("Swing Session with Kathleen Lee");
        showList.add("Spirits of Congo Square with Eugene Thomas");
        showList.add("Whats New");
        
    	final HashMap<String,String> showMap = new HashMap<String,String>();
        showMap.put("Contemporary Jazz: The Deans List with Dean Ellis","2");
        showMap.put("Overnight Jazz with Jelly Roll Justice","3");
        showMap.put("The Morning Set with Joel Heavy D Dinerstein","4");
        showMap.put("Traditional Jazz with Dan Meyer","5");
        showMap.put("New Orleans Music Show with Murf Reeves","6");
        showMap.put("Blues Eclectic with Andrew Grafe","7");
        showMap.put("Jazz from the French Market with Sondra Bibb","8");
        showMap.put("Blues and RandB with Gentilly Jr.","9");
        showMap.put("Governors Mansion with The Governor","10");
        showMap.put("Contemporary Jazz with Mockingbird","11");
        showMap.put("Overnight Jazz with Johnny Woodstock","12");
        showMap.put("The Morning Set with Mark LaMaire","13");
        showMap.put("Traditional Jazz with Zach","14");
        showMap.put("New Orleans Music Show with Ms. Smalls","15");
        showMap.put("Soul Serenade with Marc Stone","16");
        showMap.put("Jazz from the French Market with T.R. Johnson","17");
        showMap.put("50s RandB with Neil Pellegrin","18");
        showMap.put("Kitchen Sink with David Kunian","19");
        showMap.put("Contemporary Jazz with Johnny Ray","20");
        showMap.put("Overnight Jazz with Jelly Roll Justice","21");
        showMap.put("The Morning Set with K. Balewa","22");
        showMap.put("Fresh Fig Jam with Olivia Greene (Trad. Jazz)","23");
        showMap.put("New Orleans Music Show with George Ingmire","24");
        showMap.put("Sittin at the Crossroad with Big D (Blues)","25");
        showMap.put("Jazz from the French Market with Maryse Dejean","26");
        showMap.put("RandB Oldies with Rare On The Air","27");
        showMap.put("Kitchen Sink with A.J. Rodrigue and A.A.","28");
        showMap.put("Late Night Jazz with Russell","29");
        showMap.put("The Spin Cycle with Old Man River","30");
        showMap.put("The Morning Set with Scott Borne","31");
        showMap.put("Traditional Jazz with Sally Young","32");
        showMap.put("New Orleans Music Show with Sherwood Collins","33");
        showMap.put("The Blues Ball with David Torkanowsky","34");
        showMap.put("Jazz from the French Market with Jelly Roll Justice","35");
        showMap.put("Blues and RandB with Missy Bowen","36");
        showMap.put("Kitchen Sink with Brian McColgan","37");
        showMap.put("Swing and Big Band with The Minister of Swing","38");
        showMap.put("Overnight Jazz with Jellyroll Justice","39");
        showMap.put("The Morning Set with Raymond Kent","40");
        showMap.put("Traditional Jazz with Keith Hill","41");
        showMap.put("New Orleans Music Show with Black Mold or Bill DeTurk","42");
        showMap.put("The Blues Breakdown with Valerie The Problem Child Kacprzak","43");
        showMap.put("Jazz from the French Market with Vin Chary","44");
        showMap.put("Music of Mass Distraction with Black Mold","45");
        showMap.put("The Rhythm Room with Allan Alski Laskey","46");
        showMap.put("Midnight Blues with Moses","47");
        showMap.put("Putumayo World Music Hour","48");
        showMap.put("Jazz From Lincoln Center","49");
        showMap.put("New Orleans All the Way Live on WWOZ","50");
        showMap.put("Traditional Jazz and New Orleans Music with Big Pete","51");
        showMap.put("Music in the Glen with Sean OMeara","52");
        showMap.put("Tiene Sabor (Latin Show) with Yolanda Estrada","53");
        showMap.put("Tudo Bem (Brazilian) with Dean Ellis or Suzanne Corley","54");
        showMap.put("World Journey with Suzanne Corley","55");
        showMap.put("Block Party with Brice Nice","56");
        showMap.put("Soul Power with Soul Sister","57");
        showMap.put("Awake and Willing with Peggy Lou","58");
        showMap.put("Blues in the Night with Jamie DellApa","59");
        showMap.put("Blues with Sam Cammarata","60");
        showMap.put("The Sunday Morning Jazz Set with Mark Landesman","61");
        showMap.put("The Gospel Show with Lauren Mastro","62");
        showMap.put("Old Time Country and Bluegrass with Hazel The Delta Rambler","63");
        showMap.put("Cajun and Zydeco with Charles Laborde or Jim Hobbs","64");
        showMap.put("Acoustic Blues with Your Cousin Dimitri","65");
        showMap.put("Sitting In with Elizabeth Meneray","66");
        showMap.put("Swing Session with Kathleen Lee","67");
        showMap.put("Spirits of Congo Square with Eugene Thomas","68");
        showMap.put("Whats New","1");    	

		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.locationtextview, showList);
		setListAdapter(dataAdapter);
		ListView listView = getListView();
		listView.setTextFilterEnabled(true);
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Intent i = new Intent("");
				String showChoice = ((TextView) view).getText().toString();
				//String showChoiceNumber = "28";
				String showChoiceNumber;
				if(showMap.get(showChoice) != null) {
				    showChoiceNumber = showMap.get(showChoice);
				} else {
					showChoiceNumber = "37";
				}
				    
				Wwozplaylists.showChoice = showChoiceNumber;				
				i.setData(Uri.parse(showChoiceNumber));
				setResult(RESULT_OK, i);
				finish();
			}
		});
	}
}

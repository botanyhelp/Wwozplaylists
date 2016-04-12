### Code for Wwozplaylists android application.

There is an sqlite database with all of the playlist data in it at the center of this application. 
```{sql}
CREATE TABLE song (artist text default null, title text default null, album text default null, time 
text default null, show integer default null);
CREATE INDEX idxalbum ON song(album);
CREATE INDEX idxartist ON song(artist);
CREATE INDEX idxshow ON song(show);
CREATE INDEX idxtime ON song(time);
CREATE INDEX idxtitle ON song(title);
```
It has records with data like these:
```
Rockin Tabby Thomas|Evil Woman Blues|Swamp Man Blues|2014-01-15 2:11pm|25
Willie Dixon|Evil.|The Chess Box Set|2014-01-15 2:09pm|25
Big Daddy O|Got No Blues Today|What You Got To Go Through|2014-01-15 2:07pm|25
John Sinclair|Crossroad Blues|LIVE ON WWOZ- Jam Session|2014-01-15 2:04pm|25
Mahalia Jackson|Rusty Old Hzlo|Gospels, Spirituals, and Hymns Vol. 1|2014-01-15 2:02pm|25
allen toussaint|freedom for the stallion|the complete warner recordings|2014-01-15 1:59pm|24
allen toussaint|brickyard blues|songbook|2014-01-15 1:51pm|24
Devo|Working in a Coal Mine|Greatest Hits|2014-01-15 1:35pm|24
Ringo Starr|Sneakin Sally through the Alley|Ringo|2014-01-15 1:29pm|24
Tami Lynn|Cast Last Much Longer|Love is Here to Stay|2014-01-15 1:28pm|24
```
It was used to generate the 100 most frequently played albums which are embodied in this code.  That "45" and "12" look like DJs entering data in a convenient manner:
```{java}
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
```
Likewise the most frequently played artist, in order:
```{java}
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
```
Likewise titles in order of most played:
```{java}
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
```
This code is not available on Google Play.

This application contains over two years of playlist data for songs played on WWOZ 90.7FM.  It is organized by show.  You can select a show and find out what songs have been played during that show.  Most shows will reveal a few thousand songs.  You can get an idea of the type of music played on a particular show.  You can probably find out what is playing right now online at [http://www.wwoz.org/programs/playlists](http://www.wwoz.org/programs/playlists)

If you google for something like, "greatest radio station in the world", wwoz should be at the top.  It is plainly true that WWOZ is the greatest radio station in the world.  You can start listening to the online music stream at www.wwoz.org and find out the truth about WWOZ for yourself.  The truth is that WWOZ is the greatest radio station in the world.  The WWOZ DJs are not playing commercials and they are not being told what music to play.  It works.  
Yeah, you will be a fan of WWOZ.
By the way, if you Google for 

"greatest radio station in the world"

with double quotes around the sentence, WWOZ is the first result.  As Brother Jesse might say, Amen.  This app and its code are free.  All of the data is copyright 2001 to 2014 WWOZ 90.7FM and or its licensors.  All mistakes are the developers fault who was probably not listening to WWOZ when the mistakes occurred.  

ImageMagick convert is a good way to make the app icons, as was done in this case like this:
```{bash}
convert -resize 36x36 wwozplaylists.png wwozplaylists36/wwozplaylists.png
convert -resize 48x48 wwozplaylists.png wwozplaylists48/wwozplaylists.png
convert -resize 72x72 wwozplaylists.png wwozplaylists72/wwozplaylists.png
convert -resize 96x96 wwozplaylists.png wwozplaylists96/wwozplaylists.png
convert -resize 144x144 wwozplaylists.png wwozplaylists144/wwozplaylists.png
convert -resize 192x192 wwozplaylists.png wwozplaylists192/wwozplaylists.png
```

package com.zlatan.student.qrs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class Roomlist extends AppCompatActivity {
TextView tv;
    String miniaudi[] = {"Mysore Tell-Tale"};
    String avroom[]={"Social Media Movie","Vivriti Video","Lazer Maze"};
    String complab[]={"Abundant Scl. of Shady Lane","Maze Game","Social Networking App","Guess the Music","App. Support Strayers", "Quiz Game","NPS Connect App","Recipe App","Vivriti App","Camrix","Traffic Bot","Daily Schedule App","Self-Driving Robot"};
    String centralcourtyard[]={"Green Futuristic City", "Fashion Tech"};
    String a12B[]={"Bharat Ek Khoj"};
    //firstfloor
    String a2a[]={"Eat...Play...Love"};
    String a2b[]={"Rediscover Australia"};
    String a2d[]={"American Cruise"};
    String a3b[]={"Info Desk", "Beauty in Nature","Colored Enlightment","Against all Odds","Spin a Yarn","Portable Rainbow","Child's Play","Polychromatic Blooms","Solar Kitchen","Colours of Safety","Say Cheese!","Abracadabra","Shady Business","Wildlife Conservation in Asian Countries","Celestial Seven",};
    String a3c[]={"Welcome Desk","Centre Piece","Erupting Volcano", "Tornado in a bottle","Dance of the Tides","Surf and Turf","Seize the Shake","Old is Gold","Angry Ocean","Rhythm of Africa"};
    String a4a[]={"Welcome Desk","All wound up","Spin off","Nice Rice","All is well","Bahubali","Magic Box","Scream Machine","Wind of Change","Great Minds think alike",""};
    String a4b[]={"Welcome Desk","Bescom at your service","Begin with a spark","Jumping Jack","Magical Moves","Lightning Thief","Are you brighter than a fifth grader?","May the best win","Lemony Glow","To be or not to be","Mutual Attraction","Buoyant Latitudes","Instant attraction","Dancing Magnets","Stylised Dimensions"};



    //secondfloor
    String a8a[]={"Life on Mars","Epsilon Star","Neptune","Black hole to White hole","Life in a space ship","Worm Hole","Big Bang Theory","Mars Landforms","Jupiter"};
   //8b
    String a8b[]={"Geostationary Objects","Space Shuttles","Space Drones","Mars Rovers","Hubble Telescope", "Planetary Migration","Rockets","Weather Station",};
    String a9a[]={"Heart","Eye Diseases","Stem Cells","Brain Inside Out","DNA Mutation","Food Pyramid","Wound Healing","Illusions","Brain Disorders"};
    String a9b[]={"Space Drones","Weather Station","Mars Rover","Rocket","Planetary Migration","Space Shuttle", "Geostationary Objects","Hubble Telescope","Bizarre Planets"};
String a10a[]={"Hydraulic Arm","Obstacle Avoiding Car","Wireless Transfer of Energy","RubeGold Machine","Piezo Electric Energy","Electromagnetic Induction"};
    String a10b[]={"Nuclear Reactor","Wine Preparation","Rayon Fibre","Cheese to Please","Magic with Chemistry","Colorful Chemistry","Organic Chemistry","Mode Lumiere"};
    //String a10c
    String avroomf3[]={"Antariksh- Puppet Show and Dance"};
    String smartboardroom[]={"Quiz","End of Universe"};
    String a7b[]={"Levitating orb.","Smart Hospital","Futuristic House Interiors","Future Highway","Mobile Home","Electricity from Garbage Generator","Energy Conservation in a park","Light House","Home made AC","Cyclone Protected City","Non Newtonian Fluid","AMES Room","Solar Wind Mill","Golden Gate Bridge","Smart Home" };
    String a7c[]={"Taj Mahal","Egyptian Rope Stretchers","Qutb Minar","Curve Stitching", "Napiers Bones","Cuisenaire Rods","Pyramid Puzzle", "Kingdom Tour of Saudi Arabia", "Platonic Solids","Fireworks in a jar","History of Pythagoras Theorem","Paper Bridge","Mathematical Clock"};
    String a6a[]={"AM Radio","Hover Craft","Hover Board","Drone","Autonomous Vehicle Nerve Impulse","Polln. Free Transport"};
    String frenchroom[]={"Fourth Order Magic Square Dance"};
    String a6b[]={"Mind Control Car","Remote Control Car","Radio FM","Enigma","Telegraph"};
    String a6c[]={"Aerodynamics","Solar Powered boat","Obstacle Avoiding robot", "ICE","Omni Bot","Segregation Unit","Brail"};
   String a10c[]={"Heart Pumping","RNA","Harmful Micro Organisms","Adultered Food","Cyclone Protecting City", "Food Myths","Endocrine Glands","Respiratory System","DNA Extraction","Haemodialysis","Digestive System"};
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomlist);
        Intent intent = getIntent();
        tv = (TextView) findViewById(R.id.textView12);

        final String Room = intent.getStringExtra("Room");
        list = (ListView) findViewById(R.id.listView);


switch(Room) {
    case ("Mini Auditorium"):
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, miniaudi);
        list.setAdapter(adapter);
        break;
    case("AV ROOM"):

         ArrayAdapter<String> aadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, avroom);
        list.setAdapter(aadapter);
        break;
    case("Computer Lab"):
        ArrayAdapter<String> aaadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, complab);
        list.setAdapter(aaadapter);
        break;

    case("Chess Room"):
        ArrayAdapter<String> aaaadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, avroom);
        list.setAdapter(aaaadapter);
        break;

    case("Central Courtyard"):

        ArrayAdapter<String> aaaaadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, centralcourtyard);
        list.setAdapter(aaaaadapter);
        break;
    case("12 B"):

        ArrayAdapter<String> aaaaaaadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a12B);
        list.setAdapter(aaaaaaadapter);
        break;
    case("8A"):

        ArrayAdapter<String> aaaaaaaadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a8a);
        list.setAdapter(aaaaaaaadapter);
        break;
    case("8B"):
//FIX THIS ASAP
        ArrayAdapter<String> aaaaaaaaadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a8b);
        list.setAdapter(aaaaaaaaadapter);
        break;
    case("9A"):
        ArrayAdapter<String> badapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a9a);
        list.setAdapter(badapter);
        break;
    case("9B"):
        ArrayAdapter<String> cadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a9b);
        list.setAdapter(cadapter);
        break;
    case("10A"):
        ArrayAdapter<String> dadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a10a);
        list.setAdapter(dadapter);
        break;
    case("10B"):
        ArrayAdapter<String> eadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a10b);
        list.setAdapter(eadapter);
        break;
    case("10C"):
      //ajmal qasab will shoot you if you dont check this
       ArrayAdapter<String> fadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a10c);
        list.setAdapter(fadapter);
        break;
    case("6A"):
        ArrayAdapter<String> gadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a6a);
        list.setAdapter(gadapter);
        break;
    case("6B"):
        ArrayAdapter<String> hadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a6b);
        list.setAdapter(hadapter);
        break;

    case("6C"):
        ArrayAdapter<String> iadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a6c);
        list.setAdapter(iadapter);
        break;
    case("7B"):
        ArrayAdapter<String> jadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a7b);
        list.setAdapter(jadapter);
        break;
    case("7C"):
        ArrayAdapter<String> kadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a7c);
        list.setAdapter(kadapter);
        break;
    case("3B"):
        ArrayAdapter<String> ladapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a3b);
        list.setAdapter(ladapter);
        break;
    case("3C"):
        ArrayAdapter<String> madapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a3c);
        list.setAdapter(madapter);
        break;
    case("4A"):
        ArrayAdapter<String> nadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a4a);
        list.setAdapter(nadapter);
        break;
    case("4B"):
        ArrayAdapter<String> oadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a4b);
        list.setAdapter(oadapter);
        break;
    case("2A"):
        ArrayAdapter<String> padapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a2a);
        list.setAdapter(padapter);
        break;
    case("2B"):
        ArrayAdapter<String> qadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a2b);
        list.setAdapter(qadapter);
        break;
    case("2D"):
        ArrayAdapter<String> radapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, a2d);
        list.setAdapter(radapter);
        break;
    case("Smartboard Room"):
        ArrayAdapter<String> sadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, smartboardroom);
        list.setAdapter(sadapter);
        break;
    case("French Room"):
        ArrayAdapter<String> tadapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, frenchroom);
        list.setAdapter(tadapter);
        break;
}





tv.setText(Room);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int pos,
                                    long id) {

                TextView listText = (TextView) view.findViewById(R.id.listText);
                String text = listText.getText().toString();
                Intent intent = new Intent(Roomlist.this, Mapest.class);
                intent.putExtra("selected-item", text);
                startActivity(intent);

            }
        });
    }
}

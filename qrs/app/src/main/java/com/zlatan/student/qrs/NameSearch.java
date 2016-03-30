package com.zlatan.student.qrs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

public class NameSearch extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    Button button;
    static String b = "";
    ListView list;
    SearchView sv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ns1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String Names[] = {
                "Krithika, Mihika", "Anshika, Aditi", "Aayusshmaan, Roslyn, Pujitha, Saransh", "Mishika, Agastya, Ishaan, Sanvi", "Darsh, Nithya, Nysa, Mukund", "Meghna, Lohitaksh, Nainika, Aayush", "Pravvrath, Abheeshta, Shaurya, Nithila", "Tejas, Adya, Shruthi, Suhani", "Bhromor, Bhavin, Jiya, Tejas", "Vaibhav, Aditi, Tara, Ishanth", "Aadhya, Madhav, Shrijani, Aadit", "Vihaan, Anika, Nila, Avdhoot", "Rishi, Vibha, Anushka, Ishanvi","Ishaan, Arnav, Ishana, Akshith","Niharika, Tanmay, Akshara, Jeet","Arjun C, Samridhi, Johan, Prarthana, Mukul, Kaavyaa, Aahana R, Aadya, Puri Jagannath, Vishakha, Hamshini, Mihika, Gokul, Jasnavi, Riya, Sarvesh, Arjun P, Sharath, Amogh, Dhriti, Kyra, Rohith, Abhinav, Ansh, Samrath, Tanvi, Manasvi, Shravan, Vedanth, Manasvi, Tanvi, Johan", "Shreyas, Dheeyanksha, Vidyuth, Ananya Srinivasan, Krish, Aahana U, Meghna, Pranav, Anjali, Mahima, Ananya Srisailam, Yash, Pallavi, Srimathi, Ethan, Anika, Manya, Shresta, Nandita, Sharan, Uthkarsh, Ananya K, Shlok, Sakshi, Sidharth, Chandana, \n" +
                " Ilina, Swapnil, Madhav N, Anika, Nandita, Ananya K",



                "Arohi, Rhea", "Vinaya, Ritvik, Tvisha, Cheethan", "Yashas, Harsheeth", "Harini, Shreya, Maitri, Madhav", "Aditya, Aditi, Aditya, Gautham","Megha, Ketaki, Nishanth, Anjali","Ishaan, Arya, Hoysal, Kaushikh","Anaga, Anaika, Ishita, Jatin","Prithvi, Harshini, Saanvi, Shreya","Riya, Ojas, Anavi, Aiyana","Tejaas, Arhan, Mishka, Navya","Anshuman, Advay, Shruthi, Srijon","Adithi, Aishani, Sujan, Sumaira","Siddharth, Prakruthi, Dhruv, Rishith","Pranathi, Vrinda, Khushi, Krish","Pranav T., Suhanee, Siddharth, Prajwal, Sharvi, Akash, Pranav H, Zoyah, Lakshya, Akanksha, Advika, Bhavni, Irene, Rakshan, Aditya, Samanvay, Muskaan, Mehr, Ananya, Vibha, Esha, Pragna, Emily, Dakshin, Prathik, Aarav, Namya, Aashi, Piyush, Ruddhra, Tarush ","Sameeksha, Kushi, Taanvi, Amoghavarsha, Ved, Kunal, Hamsini, Manya, Adarsh, Nihaar, Suman, Aditi, Varsha, Saqib, Sumukh, Elena,  Medha, Akshita, Shraddha, Taanvi, Dravya, Shloka, Kushi, Laksh, Sameeksha,  Sirish, Preetham, Sarah, Aashi, Pari, Suhani, Pawan, Tanusha ",


                "Kavya, Manushree","Meghali, T. Suraj", "Meghana, Jaimie, Amod, Daksh ", "Pranav, Sonali, Aadya, Neelkanth", "Rituparna, Ansh K, Leah, Atulya","Ansh, Sanjana, Tanushree, Vishnu","Riya, Shakthi, Jeevika, Aron","Sai Samvrutha, Kopal, Narayan, Subudh,","Chayan, Satwik, Dhruvika, Daniel","Ashvath, Shreya, Vaibhavi, Aarush","Nishanth, Aniket, Srinidhi, Meghna","Avika, Harshan, Chinmay, Soham", "Manan, Mithil, Dhruv Ramasubban, Bhavin, Gaurav, Harshith, Nihaar, Mythri, Sai Charan, Avi, Harshita, Krisha, Vaishnavi, Trisha, Navya, Dhruv Deepak, Sahana, Poorvi, Sanskriti, Tanya Verma, Stuti, Yeshas,Poorvi, Tanya Verma, Nikita, Ritanya, Vaishnavi, Nikita", " Aathreya, Rishi,  Mervyn, Siddarth, Anikethan, Preryth, Ankit, Shourya, Ayush, Lekshmi, Sharvi, Punitha, Mridula, Kenisha, Akanksha, Amrit, Samiksha, Aarna, Sanika, Tanya Roy, Dharshita, Krish, Tanya Roy, Kashvi, Aarna, Sanika, Kenisha, Mridula",


                "Sanchana, Kabini","Anwesha T, Tvisha, Jahnavi, Cherag", "Hrishit, Ada, Shreya B, Dhaani", "Niyati, Tony, Ishika, Shweta","Aratrika, Arya, Karun, Isabel","Ollie, Nanditha R, Mokshita, Raghav","Adithya, Vrindha, Pratyush, Anwesha S","Josh, Vayun, Anjali V, Shaarav","Gargi, Surabhi, Suhana, John","Stuti, Jagrav, Pranshu, Vineela","Disha, Srishti Sinha, Aanchal B, Anoushka","Srihari, Srishti, Samarth, Eshwari","Vignesh, Mrigaj, Krishna N, Tanuj, Siddharth, Harsh, Shreya K, Ananya, Saxena, Shaurya, Esanjo, Dinesh, Aarushi, Tishya, Gia, Ribhav, Aditya, Arav, Daksh, Akshat, Yashas, Disha, Dinesh, Akshat, Krishna.N, Ananya","Shivang, Abhay, Sahil, Harsha, Krishna.S, Abhinav, Nidhi, Divya, Samaraditya, Anika, Shreyas, Pranav, Shrivali, Mihika, Darsh, Sourav, Hrishikesh, Dharshan, Rishab, Smayyan, Nihaal, Dharshan, Rishab, Shreyas, Nandana",


                "Jennifer, Saniha","Aparajitha, Laalenthika, Vanini, Amrita","Anika, Aditya A","Diya P, Sanjana, Shishir, Aryan D","Prachi, Shaina, Parth, Pranav","Surabhi, Anushree","Surya  M, Shreyas, Mrinal, Meghashyam","Naisha, Sharmila,  Omkar, Arjyo","Rohan, Prishim, Gia, Samarth","Shreya, Arundhati, Arushi, Anushka","Arin, Ishan","Andhiya, Gayana, Shriya, Ravina","Sameer, Aryan, Kriti, Aditi","Atharv, Gokul, Yash, Aditya S","Soham, Shreya, Michelle, Aarav","Vasundhara, Sampada, Isha Priya, Prakhar","Kriti, Nandita, Tanvi, Diya Prakash"," Aritro, Sanjana K, Surabhi Reddy, Aadi, Aarav Sinha, Aarshi, Aarshia, Riddhibrata, Aarav A, Ravi, Rhea, Samraksh, Karan Goel, Shriya, Asija, Anggadh,  Raghhav,  Mahathi, Nandana, Angad B, Medha Mrityunjay, Mrinmayii, Dhruv, Tanya Suraj, Ansruta, Tarun, Nandika Keerthan, Mahathi, Rhea, Anushka","Ranjna K, Akshaya, Arin, Lakshmi, Ayesha, Surya, Rehan, Pradnyan, Disha R, Anshul R, Mayukh, Isha, Vignesh, Kunsh, Ananya J, Dipsmita, Chiranthan, Avni, Abhimanyu, Nirajit, Anshul B, Akul, Rianne, Shrikha, Aditi, Monal, Ananya J, Sravya, Disha, Arshe ",

                //grade7 here m8


                "Soumya A, Sruti N, Ananya B", "Sushrut W, SriVishnu, AdityaB", "Anishka, Ananya S, Tejasvi Pradeep", "Sona T, Soumya G.", "Tanish, Ajith, Shreyas", "Dhruti, Aditi K", "Durga, Rachita"," Nethra, Sneha V.", "Divyaansh, Nakul, Arjun S.", "Sahil Agarwal, Satvik S", "Medha Dhir , Shreya", "Yamini A , Sharanya S , Veda , Kripa", "TusharC , Jeff J", "Aastha , Harshita", "Keerthana , Manognya", "Ronit Nallagatla, RishabK, Vishnu", "Adarsh A , Alina , Gauri , Isha , Vishveshwar, Nikhil , Sarthak", "AdarshM , Ananya B , Devanshi , Gaurav , Saket , Nikhil , Risheet, Siddharth", "Aditi R, Anukarsh, Jishnu, Katyayani, Nandan, Ritisha, Ronith Nair, Sanjana Dixit, Shriya G, Trideeb B, Aayush K", "Nisshta, Animisha", "Sai Gayathri, Sanjana G.", "Srishti, Meghana A Rupanagunta", "Ila, Chinmayi, Shamika", "Nikita, Maanasa", "Anjali, Manasi, Kaajal", "Megha, Meghana M M", "Chetna, Ganavi", "Aditi A, Archita, Diya B",



                "Abeer, Pranav, Radhika, Rohan, Yashvi M,", "Ananya U, Anwesha, Ritisha, Rima, Samyukta, Sayoojya, Vibha", "Anirudh, Aranya, Deepta, Hamsini, Indumathi, Kasturi, Keerthana A, Poorva, Riddhiman G, Rishabh K, Snigdha, Swathi A, Tarani J", "Aditya R,Jathin A, Nishanth SM", "Arpita, Akshita, Manasvi, Kavya S", "Aditya K", "Jeevan, Jnanendra, Satvik A, Sreyes S", "Arphan S, Dhruv R, Rahul T, Shaumik", "Abhijna, Rebecca", "Jahnavi, Preksha", "Keerthana B, Srikavya", "Achyut, Shreyas B", "Kriti T, Maithili B.", "Mahalaxmi, Prithvi P", "Saahithi M, Sneha K, Tanvi R, Meghna D", "Simran T, Lalitha Dasu", "Aayush V, Advaith J", "Anish P, Sumukh, Tejas", "Sai Thanmayi, Rachel", "Aayushi J, Mira", "Tapas R., Aditya Samyak", "Abhinav, Shrey, Vishal", "Varun, Dhruv", "Apoorva, Nidhish", "Atmesh, Rishi", "Guha, Dhruv C, Ayush T", "Lauhitya, Malavika, Trithi J, Siddhant G",



                "Ojas B , Dhruv M, Sameer C , Siddhant V, Vikram A, Aditya S, Shreyas S, Smarak P, Varun V, Jacob M, Yash R", "Chinmayee, Shriya S", "Aditya D , Jaideep, Virinchi", "Lingesh K , Shreyas Saket, Kalyan Verma, Shubham Kumar, Siddharth Mishra, Tushar Reddy", "Chinmayee, Shriya S", "Prithik Karthikeyan, Ananda S, Rithwik Sathyan", "Moushumi Choudhury, Anisha Nath", "Krishna Girish, Nandan Shanmuhan", "Ananya Jalali , Mihika Bairathi", "Niket 'gapargoat' Jain", "Aanandi Siddharth, Aarshia C, Arundhati, Mugdha, Sakshi, Sneha", "Akash A., Atman, Lord Devavrath, Diya G, Gayatri, Ishita, Janani, Jayani, Priya K, Medhavi, Parkhi, Sejal, Shivani, Shreya, Smriti Bhargavi, Kush, Rishita, Ritesh, SuryaSaveri, Shrish", "Arpita S., Sejal E", "Atharva R, Gurmeher S, Ritvik U", "Ishita C, Ananya S, Ishika B, Saniya S", "Kavya N, Tanisha M", "Manzood Ali, Amit R, Rohan C, Aryan R, Shreyas S, Palash", "Nesha , Nitya D, Sanskriti M, Shruthi K", "Manasa S., Shreya R, Radhika",



                "Kayan Katrak , Ashwin P", "SiddharthV, Suraj K, Vinay S", "Anirudh O,Nikhil PE, Pradyumna S, PallavRD, Abhinav Murali", "Ayushi Shah, Preeti S", "Pranav P, Rahul I, Roche", "Rashi P , Reshma R, Sanjana, Asrita", "S Vandana, sayee shruthi", "Sriya Adiraju, Asha", "Swati K , Vineet M,", "Aparna M , Keerthi K", "Arushi B , Madhulika B", "Vidisha K, Shefali S", "Agresh, Kunal", "Anand S, Adarsh Prasad, Karthik V", "Anika,Swethashri,Nikhila VK", "Gautam N, Varun Balaji, Ruchir Joshi", "Anubhav C, KanishQ, Saketh", "Mahesh P, Gaven J", "Aditi,  Ananya", "Aditya VH, Jijis, Pranav V, Rishav G", "Mathew S, Siddharth K, Rajat K", "Meghana A,  Sneha S, Sneha SM", "Hradini, Taanya M, Rakshana G", "Juhie F, Ramya, Trisha A",

        };

        list = (ListView) findViewById(R.id.list);
        sv = (SearchView) findViewById(R.id.search);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int pos,
                                    long id) {

                TextView listText = (TextView) view.findViewById(R.id.listText);
                String text = listText.getText().toString();
                Intent intent = new Intent(NameSearch.this, Rate.class);
                intent.putExtra("selected-item", text);
                startActivity(intent);

            }
        });
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_view_row, R.id.listText, Names);
        list.setAdapter(adapter);
        //list.setOnItemClickListener(this);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String text) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String text) {
                adapter.getFilter().filter(text);
                return false;
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.name, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //this part does navbar shiz
        int id = item.getItemId();

        if (id == R.id.Home) {
            Intent mainIntent = new Intent(NameSearch.this,Home.class);
            NameSearch.this.startActivity(mainIntent);
            NameSearch.this.finish();  // goes to homescreen
        } else if (id == R.id.Map_View) {
            Intent mainIntent = new Intent(NameSearch.this,MapView.class);
            NameSearch.this.startActivity(mainIntent);
            NameSearch.this.finish();
        }
        else if (id == R.id.About) {
            Intent mainIntent = new Intent(NameSearch.this,AboutApp.class);
            NameSearch.this.startActivity(mainIntent);
            NameSearch.this.finish();
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}



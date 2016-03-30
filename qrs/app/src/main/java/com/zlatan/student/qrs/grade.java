package com.zlatan.student.qrs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class grade extends AppCompatActivity {
    static String b = "";
    ListView list;
    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String Recipes[] = {
                "Soumya A ,Sruti N Ananya B", "Sushrut W, SriVishnu, AdityaB", "Anishka, Ananya S, Tejasvi Pradeep", "Sona T, Soumya G.", "Tanish, Ajith, Shreyas", "Dhruti, Aditi K", "Durga, Rachita"," Nethra, Sneha V.", "Divyaansh, Nakul, Arjun S.", "Sahil Agarwal, Satvik S", "Medha Dhir , Shreya", "Yamini A , Sharanya S , Veda , Kripa", "TusharC , Jeff J", "Aastha , Harshita", "Keerthana , Manognya", "Ronit Nallagatla, RishabK, Vishnu", "Adarsh A , Alina , Gauri , Isha , Vishveshwar, Nikhil , Sarthak", "AdarshM , Ananya B , Devanshi , Gaurav , Saket , Nikhil , Risheet, Siddharth", "Aditi R, Anukarsh, Jishnu, Katyayani, Nandan, Ritisha, Ronith Nair, Sanjana Dixit, Shriya G, Trideeb B, Aayush K", "Nisshta, Animisha", "Sai Gayathri, Sanjana G.", "Srishti, Meghana A Rupanagunta", "Ila, Chinmayi, Shamika", "Nikita, Maanasa", "Anjali, Manasi, Kaajal", "Megha, Meghana M M", "Chetna, Ganavi", "Aditi A, Archita, Diya B",
        "Abeer, Pranav, Radhika, Rohan, Yashvi M,", "Ananya U, Anwesha, Ritisha, Rima, Samyukta, Sayoojya, Vibha", "Anirudh, Aranya, Deepta, Hamsini, Indumathi, Kasturi, Keerthana A, Poorva, Riddhiman G, Rishabh K, Snigdha, Swathi A, Tarani J", "Aditya R,Jathin A, Nishanth SM", "Arpita, Akshita, Manasvi, Kavya S", "Aditya K", "Jeevan, Jnanendra, Satvik A, Sreyes S", "Arphan S, Dhruv R, Rahul T, Shaumik", "Abhijna, Rebecca", "Jahnavi, Preksha", "Keerthana B, Srikavya", "Achyut, Shreyas B", "Kriti T, Maithili B.", "Mahalaxmi, Prithvi P", "Saahithi M, Sneha K, Tanvi R, Meghna D", "Simran T, Lalitha Dasu", "Aayush V, Advaith J", "Anish P, Sumukh, Tejas", "Sai Thanmayi, Rachel", "Aayushi J, Mira", "Tapas R., Aditya Samyak", "Abhinav, Shrey, Vishal", "Varun, Dhruv", "Apoorva, Nidhish", "Atmesh, Rishi", "Guha, Dhruv C, Ayush T", "Lauhitya, Malavika, Trithi J, Siddhant G",

        "Ojas B , Dhruv M, Sameer C , Siddhant V, Vikram A, Aditya S, Shreyas S, Smarak P, Varun V, Jacob M, Yash R", "Chinmayee, Shriya S", "Aditya D , Jaideep, Virinchi", "Lingesh K , Shreyas Saket, Kalyan Verma, Shubham Kumar, Siddharth Mishra, Tushar Reddy", "Chinmayee, Shriya S", "Prithik Karthikeyan, Ananda S, Rithwik Sathyan", "Moushumi Choudhury, Anisha Nath", "Krishna Girish, Nandan Shanmuhan", "Ananya Jalali , Mihika Bairathi", "Niket 'gapargoat' Jain", "Aanandi Siddharth, Aarshia C, Arundhati, Mugdha, Sakshi, Sneha", "Akash A., Atman, Devavrath, Diya G, Gayatri, Ishita, Janani, Jayani, Priya K, Medhavi, Parkhi, Sejal, Shivani, Shreya, Smriti Bhargavi, Kush, Rishita, Ritesh, SuryaSaveri, Shrish", "Arpita S., Sejal E", "Atharva R, Gurmeher S, Ritvik U", "Ishita C, Ananya S, Ishika B, Saniya S", "Kavya N, Tanisha M", "Manzood Ali, Amit R, Rohan C, Aryan R, Shreyas S, Palash", "Nesha , Nitya D, Sanskriti M, Shruthi K", "Manasa S., Shreya R, Radhika",
        "Kayan Katrak , Ashwin P", "SiddharthV, Suraj K, Vinay S", "Anirudh O,Nikhil PE, Pradyumna S, PallavRD, Abhinav Murali", "Ayushi Shah, Preeti S", "Pranav P, Rahul I, Roche", "Rashi P , Reshma R, Sanjana, Asrita", "S Vandana, sayee shruthi", "Sriya Adiraju, Asha", "Swati K , Vineet M,", "Aparna M , Keerthi K", "Arushi B , Madhulika B", "Vidisha K, Shefali S", "Agresh, Kunal", "Anand S, Adarsh Prasad, Karthik V", "Anika,Swethashri,Nikhila VK", "Gautam N, Varun Balaji, Ruchir Joshi", "Anubhav C, KanishQ, Saketh", "Mahesh P, Gaven J", "Aditi,  Ananya", "Aditya VH, Jijis, Pranav V, Rishav G", "Mathew S, Siddharth K, Rajat K", "Meghana A,  Sneha S, Sneha SM", "Hradini, Taanya M, Rakshana G", "Juhie F, Ramya, Trisha A",
                
        };
        list = (ListView) findViewById(R.id.list);
        sv = (SearchView) findViewById(R.id.search);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Recipes);
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
    }

    }



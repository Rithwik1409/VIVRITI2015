package com.zlatan.student.qrs;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;

import org.w3c.dom.Text;

public class SBN extends AppCompatActivity {
TextView Student;
    Button button;
    EditText feedback;
ImageView iv;
    TextView Project;
    TextView Location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sbn);


        Student = (TextView) findViewById(R.id.textView8);
        Project = (TextView) findViewById(R.id.textView7);
        Location = (TextView) findViewById(R.id.textView9);
iv=(ImageView) findViewById(R.id.imageView7);
        Intent intent = getIntent();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);

        final String UserName = pref.getString("key_name", "");
        final RatingBar mBar = (RatingBar) findViewById(R.id.ratingBar2);
        final float a = (mBar.getRating());
        final int numStars =(int)a;
        feedback = (EditText)findViewById(R.id.editText3);
        // fetch value from key-value pair and make it visible on TextView.
        final String item = intent.getStringExtra("selected-item");
        Student.setText(item);


switch (item){
    case("Krithika, Mihika"):
        Project.setText("Info Desk"); Location.setText("Located in: 3B");
        break;
    case("Anshika, Aditi"):
        Project.setText("Beauty in Nature"); Location.setText("Located in: 3B");
        break;
    case("Aayusshmaan, Roslyn, Pujitha, Saransh"):
        Project.setText("Colored Enlightment"); Location.setText("Located in: 3B");
        break;
    case("Mishika, Agastya, Ishaan, Sanvi"):
        Project.setText("Against All Odds"); Location.setText("Located in: 3B");
        break;
    case("Darsh, Nithya, Nysa, Mukund"):
        Project.setText("Spin a Yarn"); Location.setText("Located in: 3B");
        break;
    case("Meghna, Lohitaksh, Nainika, Aayush"):
        Project.setText("Portable Rainbow"); Location.setText("Located in: 3B");
        break;
    case("Pravvrath, Abheeshta, Shaurya, Nithila"):
        Project.setText("Child's Play"); Location.setText("Located in: 3B");
        break;
    case("Tejas, Adya, Shruthi, Suhani"):
        Project.setText("Polychromatic Blooms"); Location.setText("Located in: 3B");
        break;
    case("Bhromor, Bhavin, Jiya, Tejas"):
        Project.setText("Solar Kitchen"); Location.setText("Located in: 3B");
        break;
    case("Vaibhav, Aditi, Tara, Ishanth"):
        Project.setText("Colours of Safety"); Location.setText("Located in: 3B");
        break;
    case("Aadhya, Madhav, Shrijani, Aadit"):
        Project.setText("Say Cheese!"); Location.setText("Located in: 3B");
        break;
    case("Vihaan, Anika, Nila, Avdhoot"):
        Project.setText("Abracadabra"); Location.setText("Located in: 3B");
        break;
    case("Rishi, Vibha, Anushka, Ishanvi"):
        Project.setText("Shady Business"); Location.setText("Located in: 3B");
        break;
    case("Ishaan, Arnav, Ishana, Akshith"):
        Project.setText("Wildlife Conservation in Asian Countries"); Location.setText("Located in: 3B");
        break;
    case("Niharika, Tanmay, Akshara, Jeet"):
        Project.setText("Celestial Seven"); Location.setText("Located in: 3B");
        break;
    case("Arjun C, Samridhi, Johan, Prarthana, Mukul, Kaavyaa, Aahana R, Aadya, Puri Jagannath, Vishakha, Hamshini, Mihika, Gokul, Jasnavi, Riya, Sarvesh, Arjun P, Sharath, Amogh, Dhriti, Kyra, Rohith, Abhinav, Ansh, Samrath, Tanvi, Manasvi, Shravan, Vedanth, Manasvi, Tanvi, Johan"):
        Project.setText("Social Science (Morning)"); Location.setText("");
        break;
    case("Shreyas, Dheeyanksha, Vidyuth, Ananya Srinivasan, Krish, Aahana U, Meghna, Pranav, Anjali, Mahima, Ananya Srisailam, Yash, Pallavi, Srimathi, Ethan, Anika, Manya, Shresta, Nandita, Sharan, Uthkarsh, Ananya K, Shlok, Sakshi, Sidharth, Chandana, Ilina, Swapnil, Madhav N, Anika, Nandita, Ananya K"):
        Project.setText("Social Science (Evening)"); Location.setText("");
        break;

    //GR2

    case("Arohi, Rhea"):
        Project.setText("Info Desk"); Location.setText("Located in: Yoga Room");
        break;
    case("Vinaya, Ritvik, Tvisha, Cheethan"):
        Project.setText("Centre Piece"); Location.setText("Located in: Yoga Room");
        break;
    case("Yashas, Harsheeth"):
        Project.setText("Quiz"); Location.setText("Located in: Yoga Room");
        break;
    case("Harini, Shreya, Maitri, Madhav"):
        Project.setText("Matter of Fact"); Location.setText("Located in: Yoga Room");
        break;
    case("Aditya, Aditi, Aditya, Gautham"):
        Project.setText("Floating Orange"); Location.setText("Located in: Yoga Room");
        break;
    case("Megha, Ketaki, Nishanth, Anjali"):
        Project.setText("Colour Splash!"); Location.setText("Located in: Yoga Room");
        break;
    case("Ishaan, Arya, Hoysal, Kaushikh"):
        Project.setText("No Entry!"); Location.setText("Located in: Yoga Room");
        break;
    case("Anaga, Anaika, Ishita, Jatin"):
        Project.setText("Stretch it if you can…"); Location.setText("Located in: Yoga Room");
        break;
    case("Prithvi, Harshini, Saanvi, Shreya"):
        Project.setText("Dancing Raisins"); Location.setText("Located in: Yoga Room");
        break;
    case("Riya, Ojas, Anavi, Aiyana"):
        Project.setText("Explosion !!"); Location.setText("Located in: Yoga Room");
        break;
    case("Tejaas, Arhan, Mishka, Navya"):
        Project.setText("Lasting Health"); Location.setText("Located in: Yoga Room");
        break;
    case("Anshuman, Advay, Shruthi, Srijon"):
        Project.setText("Magical Jar"); Location.setText("Located in: Yoga Room");
        break;
    case("Adithi, Aishani, Sujan, Sumaira"):
        Project.setText("Kitchen Surprise Solved"); Location.setText("Located in: Yoga Room");

        break;
    case("Ayush, Kritin, Arjun, Vishnu "):
        Project.setText("Tricky Visual"); Location.setText("Located in: Yoga Room");

        break;
    case("Siddharth, Prakruthi, Dhruv, Rishith"):
        Project.setText("Pollution"); Location.setText("Located in: Yoga Room");
        break;
    case("Pranathi, Vrinda, Khushi, Krish"):
        Project.setText("Mathemagic"); Location.setText("Located in: Yoga Room");
        break;
    case("Pranav T., Suhanee, Siddharth, Prajwal, Sharvi, Akash, Pranav H, Zoyah, Lakshya, Akanksha, Advika, Bhavni, Irene, Rakshan, Aditya, Samanvay, Muskaan, Mehr, Ananya, Vibha, Esha, Pragna, Emily, Dakshin, Prathik, Aarav, Namya, Aashi, Piyush, Ruddhra, Tarush "):
        Project.setText("Eat...Play...Love"); Location.setText("Located in: 2A");
        break;
    case ("Sameeksha, Kushi, Taanvi, Amoghavarsha, Ved, Kunal, Hamsini, Manya, Adarsh, Nihaar, Suman, Aditi, Varsha, Saqib, Sumukh, Elena,  Medha, Akshita, Shraddha, Taanvi, Dravya, Shloka, Kushi, Laksh, Sameeksha,  Sirish, Preetham, Sarah, Aashi, Pari, Suhani, Pawan, Tanusha "):
        Project.setText("Eat...Play...Love"); Location.setText("Located in: 2A");
        break;
//GR3
    case("Kavya, Manushree"):
        Project.setText("Welcome Desk"); Location.setText("Located in: 3C");
        break;
    case("Meghali, T. Suraj"):
        Project.setText("Centre Piece"); Location.setText("Located in: 3C");
        break;
    case("Meghana, Jaimie, Amod, Daksh"):
        Project.setText("Erupting Volcanoes"); Location.setText("Located in: 3C");
        break;
    case("Pranav, Sonali, Aadya, Neelkanth"):
        Project.setText("Tornado in a bottle"); Location.setText("Located in: 3C");
        break;
    case("Rituparna, Ansh K, Leah, Atulya"):
        Project.setText("Dance of the Tides"); Location.setText("Located in: 3C");
        break;
    case("Ansh, Sanjana, Tanushree, Vishnu"):
        Project.setText("Surf and Turf -Changing Coastline"); Location.setText("Located in: 3C");
        break;
    case("Riya, Shakthi, Jeevika, Aron"):
        Project.setText("Rumble Tumble -Earthquake Simulation"); Location.setText("Located in: 3C");
        break;
    case("Sai Samvrutha, Kopal, Narayan, Subudh"):
        Project.setText("Models:Seize the Shake -Seismograph"); Location.setText("Located in: 3C");

        break;
    case("Chayan, Satwik, Dhruvika, Daniel"):
        Project.setText("Old is Gold - Fossils"); Location.setText("Located in: 3C");
        break;
    case("Ashvath, Shreya, Vaibhavi, Aarush"):
        Project.setText("Angry Ocean -Tsunami"); Location.setText("Located in: 3C");
        break;
    case("Nishanth, Aniket, Srinidhi, Meghna"):
        Project.setText("EE Corner-Keep it Cool…Stop Global Warming!"); Location.setText("Located in: 3C");
        break;
    case("Avika, Harshan, Chinmay, Soham"):
        Project.setText("Math Corner-Fun with Fractions"); Location.setText("Located in: 3C");
        break;
    case("Manan, Mithil, Dhruv Ramasubban, Bhavin, Gaurav, Harshith, Nihaar, Mythri, Sai Charan, Avi, Harshita, Krisha, Vaishnavi, Trisha, Navya, Dhruv Deepak, Sahana, Poorvi, Sanskriti, Tanya Verma, Stuti, Yeshas, Poorvi, Tanya Verma, Nikita, Ritanya, Vaishnavi, Nikita"):
        Project.setText("RHYTHM OF AFRICA…!(Morning)"); Location.setText("Located in: ");
        break;
    case(" Aathreya, Rishi,  Mervyn, Siddarth, Anikethan, Preryth, Ankit, Shourya, Ayush, Lekshmi, Sharvi, Punitha, Mridula, Kenisha, Akanksha, Amrit, Samiksha, Aarna, Sanika, Tanya Roy, Dharshita, Krish, Tanya Roy, Kashvi, Aarna, Sanika, Kenisha, Mridula"):
        Project.setText("RHYTHM OF AFRICA…!(Afternoon)"); Location.setText("Located in: ");
        break;
//gr4

    case("Sanchana, Kabini"):
        Project.setText("Welcome Desk & Feed back"); Location.setText("Located in: 4A");

        break;
    case("Anwesha T, Tvisha, Jahnavi, Cherag"):
        Project.setText("All wound up!"); Location.setText("Located in: 4A");
        break;
    case("Hrishit, Ada, Shreya B, Dhaani"):
        Project.setText("Spin off!"); Location.setText("Located in: 4A");
        break;
    case("Niyati, Tony, Ishika, Shweta"):
        Project.setText("Nice Rice"); Location.setText("Located in: 4A");
        break;
    case("Aratrika, Arya, Karun, Isabel"):
        Project.setText("All is Well!"); Location.setText("Located in: 4A");
        break;
    case("Ollie, Nanditha R, Mokshita, Raghav"):
        Project.setText("Bahubali"); Location.setText("Located in: 4A");
        break;
    case("Adithya, Vrindha, Pratyush, Anwesha S"):
        Project.setText("Magic Box"); Location.setText("Located in: 4A");
        break;
    case("Josh, Vayun, Anjali V, Shaarav"):
        Project.setText("Scream Machine!"); Location.setText("Located in: 4A");
        break;
    case("Gargi, Surabhi, Suhana, John"):
        Project.setText("Wind of Change"); Location.setText("Located in: 4A");
        break;
    case("Stuti, Jagrav, Pranshu, Vineela"):
        Project.setText("Great Minds Think A..bike"); Location.setText("Located in: 4A");
        break;
    case("Disha, Srishti Sinha, Aanchal B, Anoushka"):
        Project.setText("EE Corner - Ae bhai …..zara dekh ke chalo! (Road Safety)"); Location.setText("Located in: 4A");
        break;
    case("Srihari, Srishti, Samarth, Eshwari"):
        Project.setText("Math Corner - An Equal Share"); Location.setText("Located in: 4A");
        break;
    case("Vignesh, Mrigaj, Krishna N, Tanuj, Siddharth, Harsh, Shreya K, Ananya, Saxena, Shaurya, Esanjo, Dinesh, Aarushi, Tishya, Gia, Ribhav, Aditya, Arav, Daksh, Akshat, Yashas, Disha, Dinesh, Akshat, Krishna.N, Ananya"):
        Project.setText("Rediscovering Australia (Morning)"); Location.setText("Located in: 2B");
        break;
    case("Shivang, Abhay, Sahil, Harsha, Krishna.S, Abhinav, Nidhi, Divya, Samaraditya, Anika, Shreyas, Pranav, Shrivali, Mihika, Darsh, Sourav, Hrishikesh, Dharshan, Rishab, Smayyan, Nihaal, Dharshan, Rishab, Shreyas, Nandana"):
        Project.setText("Rediscovering Australia (Afternoon)"); Location.setText("Located in: 2B");
        break;
//gr5


    case("Jennifer, Saniha"):
        Project.setText("Welcome Desk/Feedback"); Location.setText("Located in: 4B");
        break;
    case("Aparajitha, Laalenthika, Vanini, Amrita"):
        Project.setText("BESCOM at your service!"); Location.setText("Located in: 4B");
        break;
    case("Anika, Aditya A"):
        Project.setText("Begin with a spark"); Location.setText("Located in: 4B");
        break;
    case("Diya P, Sanjana, Shishir, Aryan D"):
        Project.setText("Jumping Jack"); Location.setText("Located in: 4B");
        break;
    case("Prachi, Shaina, Parth, Pranav"):
        Project.setText("Magical Moves"); Location.setText("Located in: 4B");
        break;
    case("Surabhi, Anushree"):
        Project.setText("Lightning Thief"); Location.setText("Located in: 4B");
        break;
    case("Surya  M, Shreyas, Mrinal, Meghashyam"):
        Project.setText("Are you brighter than a fifth grader?"); Location.setText("Located in: 4B");
        break;
    case("Naisha, Sharmila,  Omkar, Arjyo"):
        Project.setText("May the best win!"); Location.setText("Located in: 4B");
        break;
    case("Rohan, Prishim, Gia, Samarth"):
        Project.setText("Lemony Glow"); Location.setText("Located in: 4B");
        break;
    case("Shreya, Arundhati, Arushi, Anushka"):
        Project.setText("To be or not to be"); Location.setText("Located in: 4B");
        break;
    case("Arin, Ishan"):
        Project.setText("Mutual Attraction"); Location.setText("Located in: 4B");
        break;
    case("Andhiya, Gayana, Shriya, Ravina"):
        Project.setText("Buoyant Latitudes"); Location.setText("Located in: 4B");
        break;
    case("Sameer, Aryan, Kriti, Aditi"):
        Project.setText("Instant Attraction"); Location.setText("Located in: 4B");
        break;
    case("Atharv, Gokul, Yash, Aditya S"):
        Project.setText("Dancing Magnets"); Location.setText("Located in: 4B");
        break;
    case("Soham, Shreya, Michelle, Aarav"):
        Project.setText("Stylised Dimensions"); Location.setText("Located in: 4B");
        break;
    case("Vasundhara, Sampada, Isha Priya, Prakhar"):
        Project.setText("E.E Corner- Alternative sources of energy"); Location.setText("Located in: 4B");
        break;
    case("Kriti, Nandita, Tanvi, Diya Prakash"):
        Project.setText("Math Corner – Light Up!"); Location.setText("Located in: 4B");
        break;
    case(" Aritro, Sanjana K, Surabhi Reddy, Aadi, Aarav Sinha, Aarshi, Aarshia, Riddhibrata, Aarav A, Ravi, Rhea, Samraksh, Karan Goel, Shriya, Asija, Anggadh,  Raghhav,  Mahathi, Nandana, Angad B, Medha Mrityunjay, Mrinmayii, Dhruv, Tanya Suraj, Ansruta, Tarun, Nandika Keerthan, Mahathi, Rhea, Anushka"):
        Project.setText(""); Location.setText("Located in: 2D");
        break;
    case("Ranjna K, Akshaya, Arin, Lakshmi, Ayesha, Surya, Rehan, Pradnyan, Disha R, Anshul R, Mayukh, Isha, Vignesh, Kunsh, Ananya J, Dipsmita, Chiranthan, Avni, Abhimanyu, Nirajit, Anshul B, Akul, Rianne, Shrikha, Aditi, Monal, Ananya J, Sravya, Disha, Arshe"):
        Project.setText("American Cruise"); Location.setText("Located in: 2D");
        break;
//Gr7
    case("Anahat, Aryan, Ishaan, Pradyut, Inika, KanishQ, Neha, Kyra, Anand S, Hiya, Minhal, Manogna "):
        Project.setText(""); Location.setText("Located in: ");
        break;
    case("Sanjana GR, Tarunya"):
        Project.setText("Heart Pumping"); Location.setText("Located in: 10C ");
        break;
    case("Sai Vaidyaa, Vikas K, Keerthana G"):
        Project.setText("RNA"); Location.setText("Located in: 10C");
        break;
    case("Antara V, Riya A"):
        Project.setText("Harmful Micro-organisms"); Location.setText("Located in: 10C");
        break;
    case("Dhruv Bhatia, Param L, Sudhanva K"):
        Project.setText("Adulterated Food"); Location.setText("Located in: 10C");
        break;
    case("Malavika M, Nisha J"):
        Project.setText("Cyclone protecting city"); Location.setText("Located in: 7B");
        break;
    case("Ananya M, Nina H"):
        Project.setText("Non Newtonian Fluid"); Location.setText("Located in: 7B");
        break;
    case("Rahul M, Shreyas G"):
        Project.setText("Home Made AC"); Location.setText("Located in: 7B");
        break;
    case("Varun I, Chaitanya G"):
        Project.setText("Light house"); Location.setText("Located in: 7B");
        break;
    case("Neha S, Kritika R, Meghna M"):
        Project.setText("Golden Gate bridge"); Location.setText("Located in: 7B");
        break;
    case("Disha P, Nithya A, Madhura S"):
        Project.setText("Energy conservation in a park"); Location.setText("Located in: 7B");
        break;
    case("Shivanshi D, Richelle A, Rohini S"):
        Project.setText("AMES Room"); Location.setText("Located in: 7B");
        break;
    case("Suvvan N, Abhiram S"):
        Project.setText("Mobile Home"); Location.setText("Located in: 7B");
        break;
    case("Aryan S Dhruv A"):
        Project.setText("Futuristic interiors of a house"); Location.setText("Located in: 7B");
        break;
    case("Aditya S, Pavvan P, Vivek V"):
        Project.setText("Smart Home"); Location.setText("Located in: 7B");
        break;
    case("Ananya S, Esha S"):
        Project.setText("Smart Hospital"); Location.setText("Located in:7B ");
        break;
    case("Shreya J, Stuti G, Anoushka V"):
        Project.setText("Electricity from garbage generator"); Location.setText("Located in: 7B");
        break;
    case("Varun H, Rohan T, Mohnish"):
        Project.setText("Solar Wind Mill"); Location.setText("Located in: 7B");
        break;
    case("Mrigank, Jairaj Arnav O"):
        Project.setText("Future Highways"); Location.setText("Located in: 7B");
        break;
    case("Akshit P, Aldrich"):
        Project.setText("Levitating orb."); Location.setText("Located in: 7B");
        break;
    case("Sanjana Giridhar, Ridhima B"):
        Project.setText("Paper bridge"); Location.setText("Located in: 7C");
        break;
    case("Saathivik S, Tanmay V"):
        Project.setText("Kingdom tour of Saudi Arabia"); Location.setText("Located in: 7C");
        break;
    case("Ojaswi B, Adeeba M"):
        Project.setText("Fireworks in a jar"); Location.setText("Located in: 7C");
        break;
    case("Anupam D, Suyash, Rahul M"):
        Project.setText("Pyramid puzzle"); Location.setText("Located in: 7C");
        break;
    case("Prithvi , Akash"):
        Project.setText("Qutab Minar"); Location.setText("Located in: 7C");
        break;
    case("Mahit, Mehul ,Sayee Charan"):
        Project.setText("Taj Mahal"); Location.setText("Located in: 7C");
        break;
    case("Aditi I, Mihika S, Tiana D"):
        Project.setText("Platonic solids"); Location.setText("Located in: 7C");
        break;
    case("Maya "):
        Project.setText("History of Pythagoras Theorem"); Location.setText("Located in: 7C");
        break;
    case("Akash Singh, Nitish R, Rahul HR"):
        Project.setText("Napiers bones"); Location.setText("Located in: 7C");
        break;
    case("Aryaman, Rohit V"):
        Project.setText("Cuisenaire rods"); Location.setText("Located in: 7C");
        break;
    case("Benther, Raj deep"):
        Project.setText("Mathematical Clock"); Location.setText("Located in: 7C");
        break;
    case("Peri, Sahiti"):
        Project.setText("Egyptian rope stretchers"); Location.setText("Located in: 7C");
        break;
    case("Prisha, Rachna"):
        Project.setText("Curve stitching"); Location.setText("Located in: 7C");
        break;
    case("Mihika , Nitish, Rachana, Rahul M, Aryaman, Sai Charan, Stuti, Adeeba, Perie, Anoushka, Riya, Tiana, Nina, Benther, Neha S, Ananya, Saranghi"):
        Project.setText("Fourth order magic square dance"); Location.setText("Located in: French Room ");
        break;






/*
     ,
     ,



 */

//Gr8
    case("Soumya A, Sruti N, Ananya B"):
        Project.setText("Quiz"); Location.setText("Located in: Smartboard Room ");
        break;
    case("Sushrut W, SriVishnu, AdityaB"):
        Project.setText("End of Universe"); Location.setText("Located in: Smartboard Room ");
        break;
    case("Anishka, Ananya S, Tejasvi Pradeep"):
        Project.setText("Geostationary Objects"); Location.setText("Located in: 8B");
        break;
    case("Sona T, Soumya G."):
        Project.setText("Space Shuttles"); Location.setText("Located in: 8B");
        break;
    case("Tanish, Ajith, Shreyas"):
        Project.setText("Space Drones"); Location.setText("Located in: 8B");
        break;
    case("Dhruti, Aditi K"):
        Project.setText("Mars Rover"); Location.setText("Located in: 8B");
        break;
    case("Durga, Rachita"):
        Project.setText("Hubble Telescope"); Location.setText("Located in: 8B");
        break;
    case(" Nethra, Sneha V."):
        Project.setText("Planetary Migration"); Location.setText("Located in: 8B");
        break;
    case("Divyaansh, Nakul, Arjun S."):
        Project.setText("Rockets"); Location.setText("Located in: 8B");
        break;
    case("Sahil Agarwal, Satvik S"):
        Project.setText("Weather Station"); Location.setText("Located in: 8B");
        break;
    case("Medha Dhir , Shreya"):
        Project.setText("Bizarre Planets"); Location.setText("Located in: 9B");
        break;
    case("Yamini A , Sharanya S , Veda , Kripa"):
        Project.setText("Goldilocks"); Location.setText("Located in: 9B");
        break;
    case("TusharC , Jeff J"):
        Project.setText("Solar Farm"); Location.setText("Located in: 9B");
        break;
    case("Aastha , Harshita"):
        Project.setText("Future Earth"); Location.setText("Located in: 9B");
        break;
    case("Keerthana , Manognya"):
        Project.setText("Andromeda Collision"); Location.setText("Located in: 9B");
        break;
    case("Ronit Nallagatla, RishabK, Vishnu"):
        Project.setText("Quasi stellar radiations"); Location.setText("Located in: 9B");
        break;
    case("Adarsh A , Alina , Gauri , Isha , Vishveshwar, Nikhil , Sarthak, AdarshM , Ananya B , Devanshi , Gaurav , Saket , Nikhil , Risheet, Siddharth, Aditi R, Anukarsh, Jishnu, Katyayani, Nandan, Ritisha, Ronith Nair, Sanjana Dixit, Shriya G, Trideeb B, Aayush K"):
        Project.setText("Antariksh – Puppet " +

                "Show and Dance"); Location.setText("Located in: AV ROOM 3rd Floor");
        break;
    case("Nisshta, Animisha"):
        Project.setText("Life in a space-ship"); Location.setText("Located in: 8A");
        break;
    case("Sai Gayathri, Sanjana G."):
        Project.setText("Big Bang Theory"); Location.setText("Located in: 8A");
        break;
    case("Srishti, Meghana A Rupanagunta"):
        Project.setText("Black hole to White hole"); Location.setText("Located in:8A ");
        break;
    case("Ila, Chinmayi, Shamika"):
        Project.setText("Worm hole"); Location.setText("Located in: 8A");
        break;
    case("Nikita, Maanasa"):
        Project.setText("Neptune"); Location.setText("Located in: 8A");
        break;
    case("Anjali, Manasi, Kaajal"):
        Project.setText("Jupiter and Saturn"); Location.setText("Located in: 8A");
        break;
    case("Megha, Meghana M M"):
        Project.setText("Epsilon Star"); Location.setText("Located in: 8A");
        break;
    case("Chetna, Ganavi"):
        Project.setText("Mars Landforms"); Location.setText("Located in: 8A");
        break;
    case("Aditi A, Archita, Diya B"):
        Project.setText("Life on Mars"); Location.setText("Located in: 8A");
        break;

//gr9
    case("Abeer, Pranav, Radhika, Rohan, Yashvi M, Ananya U, Anwesha, Ritisha, Rima, Samyukta, Sayoojya, Vibha, Anirudh, Aranya, Deepta, Hamsini, Indumathi, Kasturi, Keerthana A, Poorva, Riddhiman G, Rishabh K, Snigdha, Swathi A, Tarani J"):
        Project.setText("Bharat Ek Khoj"); Location.setText("Located in: 12 B ");
        break;

    case("Aditya R,Jathin A, Nishanth SM"):
        Project.setText("Laser Maze"); Location.setText("Located in: Chess Room ");
        break;
    case("Arpita, Akshita, Manasvi, Kavya S"):
        Project.setText("Abundant Scl. Of " +
                "Shady lane"); Location.setText("Located in: Computer Lab ");
        break;
    case("Aditya K"):
        Project.setText("Quiz Game"); Location.setText("Located in: Computer Lab");
        break;
    case("Jeevan, Jnanendra, Satvik A, Sreyes S"):
        Project.setText("Guess the music"); Location.setText("Located in: Computer Lab ");
        break;
    case("Arphan S, Dhruv R, Rahul T, Shaumik"):
        Project.setText("Maze game"); Location.setText("Located in: Computer Lab ");
        break;
    case("Abhijna, Rebecca"):
        Project.setText("Rayon Fibre"); Location.setText("Located in: 10B");
        break;
    case("Jahnavi, Preksha"):
        Project.setText("Magic with Chemistry"); Location.setText("Located in: 10B");
        break;
    case("Keerthana B, Srikavya"):
        Project.setText("Cheese to please"); Location.setText("Located in: 10B ");
        break;
    case("Achyut, Shreyas B"):
        Project.setText("Wine preparation"); Location.setText("Located in: 10B ");
        break;
    case("Kriti T, Maithili B."):
        Project.setText("Nuclear Reactor"); Location.setText("Located in: 10B ");
        break;
    case("Mahalaxmi, Prithvi P"):
        Project.setText("Organic Chemistry"); Location.setText("Located in: 10B ");
        break;
    case("Saahithi M, Sneha K, Tanvi R, Meghna D"):
        Project.setText("Mode Lumiere"); Location.setText("Located in: 10B ");
        break;
    case("Simran T, Lalitha Dasu"):
        Project.setText("Colorful Chemistry"); Location.setText("Located in: 10B ");
        break;
    case("Aayush V, Advaith J"):
        Project.setText("Food Myths"); Location.setText("Located in: 10C ");
        break;
    case("Anish P, Sumukh, Tejas"):
        Project.setText("Endocrine Glands"); Location.setText("Located in: 10C");
        break;
    case("Sai Thanmayi, Rachel"):
        Project.setText("Respiratory System"); Location.setText("Located in: 10C");
        break;
    case("Aayushi J, Mira"):
        Project.setText("DNA Extraction"); Location.setText("Located in: 10C");
        break;
    case("Tapas R., Aditya Samyak"):
        Project.setText("Haemodialysis"); Location.setText("Located in: 10C");
        break;
    case("Abhinav, Shrey, Vishal"):
        Project.setText("Obstacle Avoiding Car"); Location.setText("Located in: 10A");
        break;
    case("Varun, Dhruv"):
        Project.setText("Wireless transfer of energy"); Location.setText("Located in: 10A");
        break;
    case("Apoorva, Nidhish"):
        Project.setText("Electromagnetic Induction"); Location.setText("Located in: 10A");
        break;
    case("Atmesh, Rishi"):
        Project.setText("Piezo electric energy"); Location.setText("Located in: 10A");
        break;
    case("Guha, Dhruv C, Ayush T"):
        Project.setText("Hydraulic arm"); Location.setText("Located in: 10A");
        break;
    case("Lauhitya, Malavika, Trithi J, Siddhant G"):
        Project.setText("Rubegold machine"); Location.setText("Located in: 10A");
        break;
//gr10
    case("Ojas B, Dhruv M, Sameer C, Siddhant V, Vikram A, Aditya S, Shreyas S, Smarak P, Varun V, Jacob M, Yash R"):
        Project.setText("Green Futuristic city"); Location.setText("Central courtyard");
        break;
    case("Chinmayee, Shriya S"):
        Project.setText("Social Media " +
                "Movie"); Location.setText("Located in: AV Room ");
        break;
    case("Aditya D, Jaideep, Virinchi"):
        Project.setText("Self-driving robot"); Location.setText("Located in: Computer Lab");
        break;
    case("Lingesh K, Shreyas Saket, Kalyan Verma, Shubham Kumar, Siddharth Mishra, Tushar Reddy"):
        Project.setText("Recipe App."); Location.setText("Located in: Computer Lab");
        break;

case("Prithik Karthikeyan, Ananda S, Rithwik Sathyan"):
    Project.setText("Vivriti App.");
    break;
    case("Moushumi Choudhury, Anisha Nath"):
        Project.setText("Camrix: Photoeditor"); Location.setText("Located in: Computer Lab");
        break;
    case("Krishna Girish, Nandan Shanmuhan"):
        Project.setText("Traffic Bot."); Location.setText("Located in: Computer Lab");
        break;
    case("Ananya Jalali , Mihika Bairathi"):
        Project.setText("App. Support Strayers"); Location.setText("Located in: Computer Lab");
        break;
    case("Niket Jain"):
        Project.setText("Daily schedule App. "); Location.setText("Located in: Computer Lab");
        break;
    case("Aanandi Siddharth, Aarshia C, Arundhati, Mugdha, Sakshi, Sneha"):
        Project.setText(""); Location.setText("Located in:");
        break;
    case("Akash A., Atman, Lord Devavrath, Diya G, Gayatri, Ishita, Janani, Jayani, Priya K, Medhavi, Parkhi, Sejal, Shivani, Shreya, Smriti Bhargavi, Kush, Rishita, Ritesh, SuryaSaveri, Shrish"):
        Project.setText("Mysore " +
                "Tell- Tale"); Location.setText("Located in: Mini Auditorium(Basement) ");
        break;
    case("Arpita S., Sejal E"):
        Project.setText("Digestive System"); Location.setText("Located in: 10C");
        break;
    case("Atharva R, Gurmeher S, Ritvik U"):
        Project.setText("AM Radio"); Location.setText("Located in: 6A");
        break;
    case("Ishita C, Ananya S, Ishika B, Saniya S"):
        Project.setText("Hovercraft"); Location.setText("Located in: 6A");
        break;
    case("Kavya N, Tanisha M"):
        Project.setText("Hoverboard"); Location.setText("Located in: 6A");
        break;
    case("Manzood Ali, Amit R, Rohan C, Aryan R, Shreyas S, Palash"):
        Project.setText("Drone"); Location.setText("Located in: 6A");
        break;
    case("Nesha , Nitya D, Sanskriti M, Shruthi K"):
        Project.setText("Autonomous Vehicle-Nerve Impulse"); Location.setText("Located in: 6A");
        break;
    case("Manasa S., Shreya R, Radhika"):
        Project.setText("Pollution-Free Transport"); Location.setText("Located in: 6A");
        break;
//gr11
    case("Kayan Katrak , Ashwin P"):
        Project.setText("Vivriti video "); Location.setText("Located in: AV Room ");
        break;
    case("SiddharthV, Suraj K, Vinay S"):
        Project.setText("NPS connect App."); Location.setText("Located in: Computer Lab ");
        break;
    case("Anirudh O,Nikhil PE, Pradyumna S, PallavRD, Abhinav Murali"):
        Project.setText("Social networking and " +
                "App."); Location.setText("Located in: Computer Lab ");
        break;
    case("Ayushi Shah, Preeti S"):
        Project.setText("Eye Diseases"); Location.setText("Located in: 9A ");
        break;
    case("Pranav P, Rahul I, Roche"):
        Project.setText("Stem Cells"); Location.setText("Located in: 9A");
        break;
    case("Rashi P , Reshma R, Sanjana, Asrita"):
        Project.setText("Heart"); Location.setText("Located in: 9A");
        break;
    case("S Vandana, sayee shruthi"):
        Project.setText("Brain Disorders"); Location.setText("Located in: 9A");
        break;
    case("Sriya Adiraju, Asha"):
        Project.setText("DNA Mutation"); Location.setText("Located in: 9A");
        break;
    case("Swati K , Vineet M,"):
        Project.setText("Food Pyramid"); Location.setText("Located in: 9A");
        break;
    case("Aparna M , Keerthi K"):
        Project.setText("Wound Healing"); Location.setText("Located in: 9A ");
        break;
    case("Arushi B , Madhulika B"):
        Project.setText("Brain Inside Out"); Location.setText("Located in: 9A ");
        break;
    case("Vidisha K, Shefali S"):
        Project.setText("Illusions"); Location.setText("Located in: 9A ");
        break;
    case("Agresh, Kunal"):
        Project.setText("FM Radio"); Location.setText("Located in: 6B");
        break;
    case("Anand S, Adarsh Prasad, Karthik V"):
        Project.setText("Enigma"); Location.setText("Located in: 6B");
        break;
    case("Anika,Swethashri,Nikhila VK"):
        Project.setText("Telegraph"); Location.setText("Located in: 6B");
        break;
    case("Gautam N, Varun Balaji, Ruchir Joshi"):
        Project.setText("OmniBot"); Location.setText("Located in: 6B");
        break;
    case("Anubhav C, KanishQ, Saketh"):
        Project.setText("Aerodynamics"); Location.setText("Located in: 6C");
        break;
    case("Mahesh P, Gaven J"):
        Project.setText("Obstacle avoiding Robot"); Location.setText("Located in: 6C");
        break;
    case("Aditi,  Ananya"):
        Project.setText("Solar Powered boat"); Location.setText("Located in: 6C");
        break;
    case("Aditya VH, Jijis, Pranav V, Rishav G"):
        Project.setText("ICE"); Location.setText("Located in: 6C");
        break;
    case("Mathew S, Siddharth K, Rajat K"):
        Project.setText("Mind Control Car"); Location.setText("Located in: 6C");
        break;
    case("Meghana A,  Sneha S, Sneha SM"):
        Project.setText("Remote Control Car"); Location.setText("Located in: 6C");
        break;
    case("Hradini, Taanya M, Rakshana G"):
        Project.setText("Segregation Unit"); Location.setText("Located in: 6C");
        break;
    case("Juhie F, Ramya, Trisha A"):
        Project.setText("Brail"); Location.setText("Located in: 6C");
        break;
    case("Shalini , Aadyasha , Nikareka, Ayesha F"):
        Project.setText("Fashion Tech. \n" +
                "(Touch me not)"); Location.setText("Central courtyard");
        break;
















}


        button=(Button)findViewById(R.id.button8);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ParseObject testObject = new ParseObject("Viviv");
                String comments = feedback.getText().toString();
testObject.put("GroupMembers", item);
                testObject.put("UserName", UserName);
                testObject.put("StarRating", String.valueOf(mBar.getRating()));
                testObject.put("Comments", comments);
                testObject.saveInBackground();
                Toast.makeText(getApplicationContext(), "Feedback recieved!! Thank you for your feedback",
                        Toast.LENGTH_LONG).show();
                Intent i = new Intent (SBN.this, ns1.class);
                startActivity(i);
            }
        });


    }
}

package com.zlatan.student.qrs;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Vibrator;



import net.sourceforge.zbar.Config;
import net.sourceforge.zbar.Image;
import net.sourceforge.zbar.ImageScanner;
import net.sourceforge.zbar.Symbol;
import net.sourceforge.zbar.SymbolSet;

public class MainActivity extends ActionBarActivity {

    private Camera mCamera;
    private CameraPreview mPreview;
    private Handler autoFocusHandler;

    private Button scanButton;
    private ImageScanner scanner;
    private ImageView Painting;
    private TextView name;

    private boolean barcodeScanned = false;
    private boolean previewing = true;
private boolean isLighOn = false;


    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)
        ;

        // Locate the button in activity_main.xml



       initControls();
        button = (ImageButton) findViewById(R.id.imageButton);

        Context context = this;
        PackageManager pm = context.getPackageManager();

        // if device support camera?
       // if (!pm.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
         //   Log.e("err", "Device has no camera!");
           // return;


//        mCamera = Camera.open();
        final Camera.Parameters p = mCamera.getParameters();

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                if (isLighOn) {

                    Log.i("info", "torch is turn off!");

                    p.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
                   mCamera.setParameters(p);
                    //mCamera.startPreview();
                    previewing = true;
                    //mCamera.autoFocus(autoFocusCB);
                    isLighOn = false;

                } else {

                    Log.i("info", "torch is turn on!");

                    p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);

                    mCamera.setParameters(p);
                  //  mCamera.startPreview();
                    isLighOn = true;
                    previewing = true;
                  //  mCamera.autoFocus(autoFocusCB);

                }

            }
        });

    }



    private void initControls() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        autoFocusHandler = new Handler();
        mCamera = getCameraInstance();

        // Instance barcode scanner
        scanner = new ImageScanner();
        scanner.setConfig(0, Config.X_DENSITY, 3);
        scanner.setConfig(0, Config.Y_DENSITY, 3);

        mPreview = new CameraPreview(MainActivity.this, mCamera, previewCb,
                autoFocusCB);
        FrameLayout preview = (FrameLayout) findViewById(R.id.cameraPreview);
        preview.addView(mPreview);

        scanButton = (Button) findViewById(R.id.ScanButton);

        scanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (barcodeScanned) {
                    barcodeScanned = false;
                    mCamera.setPreviewCallback(previewCb);
                    mCamera.startPreview();
                    previewing = true;
                    mCamera.autoFocus(autoFocusCB);
                }
            }
        });
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // SCAdminTapToScanScreen.isFromAssetDetail = false;
            releaseCamera();
        }
        return super.onKeyDown(keyCode, event);
    }


    /**
     * A safe way to get an instance of the Camera object.
     */
    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open();
        } catch (Exception e) {
        }
        return c;
    }

    private void releaseCamera() {
        if (mCamera != null) {
            previewing = false;
            mCamera.setPreviewCallback(null);
            mCamera.release();
            mCamera = null;
        }
    }

    private Runnable doAutoFocus = new Runnable() {
        public void run() {
            if (previewing)
                mCamera.autoFocus(autoFocusCB);
        }
    };

    Camera.PreviewCallback previewCb = new Camera.PreviewCallback() {
        public void onPreviewFrame(byte[] data, Camera camera) {
            Camera.Parameters parameters = camera.getParameters();
            Camera.Size size = parameters.getPreviewSize();

            Image barcode = new Image(size.width, size.height, "Y800");
            barcode.setData(data);
            int compResult=-1;
            String scanResult="";
            int result = scanner.scanImage(barcode);

            if (result != 0) {
                previewing = false;
                mCamera.setPreviewCallback(null);
                mCamera.stopPreview();

                SymbolSet syms = scanner.getResults();

                for (Symbol sym : syms) {

                    Log.d("Asset Code",
                            "Bar Code" + sym.getData());
                    scanResult = sym.getData().trim();

                //    Toast.makeText(MainActivity.this, scanResult,
                  //   Toast.LENGTH_SHORT).show();


                    barcodeScanned = true;

                    //final Vibrator vibe = (Vibrator) MainActivity.this.getSystemService(Context.VIBRATOR_SERVICE);
                    //vibe.vibrate(100);//80 represents the milliseconds (the duration of the vibration)
                    break;
                }

            }



            Log.i("<<<<scanResult>>>>", scanResult);



            // compResult = scanResult.compareTo("1");
            switch(scanResult){
                case "gr1_1":
                    Intent act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Information Desk (May I Help?)");
                    act2.putExtra("Members", "Krithika, Mihika");


                    startActivity(act2);
                    break;

                case "gr1_2":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Beauty in Nature");
                    act2.putExtra("Members", "Anshika, Aditi");

                    startActivity(act2);
                    break;
                case "gr1_3":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Coloured Enlightenment");
                    act2.putExtra("Members", "Aayusshmaan, Roslyn, Pujitha, Saransh");

                    startActivity(act2);
                    break;
                case "gr1_4":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Against all Odds");
                    act2.putExtra("Members", "Mishika, Agastya, Ishaan, Sanvi");

                    startActivity(act2);
                    break;
                case "gr1_5":
                    act2 = new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Spin a Yarn");
                    act2.putExtra("Members", "Darsh, Nithya, Nysa, Mukund");
                    startActivity(act2);
                    break;
                case "gr1_6":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Portable Rainbow");
                    act2.putExtra("Members", "Meghna, Lohitaksh, Nainika, Aayush");
                    startActivity(act2);
                    break;
                case "gr1_7":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Child’s Play");
                    act2.putExtra("Members", "Pravvrath, Abheeshta, Shaurya, Nithila");

                    startActivity(act2);
                    break;
                case "gr1_8":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Polychromatic Blooms");
                    act2.putExtra("Members", "Tejas, Adya, Shruthi, Suhani");

                    startActivity(act2);
                    break;
                case "gr1_9":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Solar Kitchen");
                    act2.putExtra("Members", "Bhromor, Bhavin, Jiya, Tejas");

                    startActivity(act2);
                    break;
                case "gr1_10":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Colours of Safety");
                    act2.putExtra("Members", "Vaibhav, Aditi, Tara, Ishanth");

                    startActivity(act2);
                    break;
                case "gr1_11":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Say Cheese!");
                    act2.putExtra("Members", "Aadhya, Madhav, Shrijani, Aadit");

                    startActivity(act2);
                    break;
                case "gr1_13":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Abracadabra");
                    act2.putExtra("Members", "Vihaan, Anika, Nila, Avdhoot");

                    startActivity(act2);
                    break;
                case "gr1_12":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Shady Business");
                    act2.putExtra("Members", "Rishi, Vibha, Anushka, Ishanvi");

                    startActivity(act2);
                    break;

                case "gr1_14":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Wildlife Conservation in Asian Countries");
                    act2.putExtra("Members", "Ishaan, Arnav, Ishana, Akshith");

                    startActivity(act2);
                    break;
                case "gr1_15":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Celestial Seven");
                    act2.putExtra("Members", "Niharika, Tanmay, Akshara, Jeet");

                    startActivity(act2);
                    break;
                case "gr3_1":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Welcome Desk");
                    act2.putExtra("Members", "Kavya, Manushree");

                    startActivity(act2);
                    break;
                case "gr3_2":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Centre Piece");
                    act2.putExtra("Members", "Meghali, T. Suraj");

                    startActivity(act2);
                    break;
                case "gr3_3":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Erupting Volcanoes");
                    act2.putExtra("Members", "Meghana, Jaimie, Amod, Daksh ");

                    startActivity(act2);
                    break;
                case "gr3_4":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Tornado in a bottle");
                    act2.putExtra("Members", "Pranav, Sonali, Aadya, Neelkanth");

                    startActivity(act2);
                    break;
                case "gr3_5":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Dance of the Tides");
                    act2.putExtra("Members", "Rituparna, Ansh K, Leah, Atulya");

                    startActivity(act2);
                    break;
                case "gr3_6":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Surf and Turf -Changing Coastline");
                    act2.putExtra("Members", "Ansh, Sanjana, Tanushree, Vishnu");

                    startActivity(act2);
                    break;
                case "gr3_7":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Rumble Tumble -Earthquake Simulation");
                    act2.putExtra("Members", "Riya, Shakthi, Jeevika, Aron");

                    startActivity(act2);
                    break;
                case "gr3_8":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Seize the Shake -Seismograph");
                    act2.putExtra("Members", "Sai Samvrutha, Kopal, Narayan, Subudh,");

                    startActivity(act2);
                    break;
                case "gr3_9":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Old is Gold - Fossils ");
                    act2.putExtra("Members", "Chayan, Satwik, Dhruvika, Daniel");

                    startActivity(act2);
                    break;
                case "gr3_10":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Angry Ocean -Tsunami");
                    act2.putExtra("Members", "Ashvath, Shreya, Vaibhavi, Aarush");

                    startActivity(act2);
                    break;

                case "gr3_11":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "EE Corner-Keep it Cool…Stop Global Warming! ");
                    act2.putExtra("Members", "Nishanth, Aniket, Srinidhi, Meghna");

                    startActivity(act2);
                    break;
                case "gr3_12":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Math Corner-Fun with Fractions ");
                    act2.putExtra("Members", "Avika, Harshan, Chinmay, Soham");

                    startActivity(act2);
                    break;
                case "gr2_13":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Tricky Visuals");
                    act2.putExtra("Members", "Vishnu, Kritin, Arjun, Ayush");

                    startActivity(act2);
                    break;
                case "gr2_14":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Kitchen Surprise Solved");

                    act2.putExtra("Members", "Adithi, Aishani, Sujan, Sumaira");

                    startActivity(act2);
                    break;
                case "gr2_15":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Pollution");
                    act2.putExtra("Members", "Siddharth, Prakruthi, Dhruv, Rishith");

                    startActivity(act2);
                    break;

                case "gr2_16":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Mathemagic");
                    act2.putExtra("Members", "Pranathi, Vrinda, Khushi, Krish");

                    startActivity(act2);
                    break;

                case "gr4_1":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Welcome Desk");
                    act2.putExtra("Members", "Sanchana, Kabini");

                    startActivity(act2);
                    break;
                case "gr4_2":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "All wound up!");
                    act2.putExtra("Members", "Anwesha T, Tvisha, Jahnavi, Cherag");

                    startActivity(act2);
                    break;
                case "gr4_3":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Spin off!");
                    act2.putExtra("Members", "Hrishit, Ada, Shreya B, Dhaani");

                    startActivity(act2);
                    break;
                case "gr4_4":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Nice Rice");
                    act2.putExtra("Members", "Niyati, Tony, Ishika, Shweta");

                    startActivity(act2);
                    break;
                case "gr4_5":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "All Is Well!");
                    act2.putExtra("Members", "Aratrika, Arya, Karun, Isabel");

                    startActivity(act2);
                    break;
                case "gr4_6":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Bahubali");
                    act2.putExtra("Members", "Ollie, Nanditha R, Mokshita, Raghav");

                    startActivity(act2);
                    break;
                case "gr4_7":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Magic Box");
                    act2.putExtra("Members", "Adithya, Vrindha, Pratyush, Anwesha S");

                    startActivity(act2);
                    break;
                case "gr4_8":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Scream Machine!");
                    act2.putExtra("Members", "Josh, Vayun, Anjali V, Shaarav");

                    startActivity(act2);
                    break;
                case "gr4_9":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Wind of Change");
                    act2.putExtra("Members", "Gargi, Surabhi, Suhana, John");

                    startActivity(act2);
                    break;
                case "gr4_10":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Great Minds Think A..bike");
                    act2.putExtra("Members", "Stuti, Jagrav, Pranshu, Vineela");

                    startActivity(act2);
                    break;

                case "gr4_11":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "EE Corner - Ae bhai …..zara dekh ke chalo! (Road Safety)");
                    act2.putExtra("Members", "Disha, Srishti Sinha, Aanchal B, Anoushka");

                    startActivity(act2);
                    break;
                case "gr4_12":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Math Corner - An Equal Share");
                    act2.putExtra("Members", "Srihari, Srishti, Samarth, Eshwari");

                    startActivity(act2);
                    break;
                case "gr2_1":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Welcome Desk");
                    act2.putExtra("Members", "Arohi, Rhea");

                    startActivity(act2);
                    break;
                case "gr2_2":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Centre Piece");
                    act2.putExtra("Members", "Vinaya, Ritvik, Tvisha, Cheethan");

                    startActivity(act2);
                    break;
                case "gr2_3":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Quiz");
                    act2.putExtra("Members", "Yashas, Harsheeth");

                    startActivity(act2);
                    break;
                case "gr2_4":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Matter of Fact");
                    act2.putExtra("Members", "Harini, Shreya, Maitri, Madhav");

                    startActivity(act2);
                    break;
                case "gr2_5":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Floating Orange");
                    act2.putExtra("Members", "Aditya, Aditi, Aditya, Gautham");

                    startActivity(act2);
                    break;
                case "gr2_6":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Colour Splash!");
                    act2.putExtra("Members", "Megha, Ketaki, Nishanth, Anjali");

                    startActivity(act2);
                    break;
                case "gr2_7":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "No Entry!");
                    act2.putExtra("Members", "Ishaan, Arya, Hoysal, Kaushikh");

                    startActivity(act2);
                    break;
                case "gr2_8":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Stretch it if you can…");
                    act2.putExtra("Members", "Anaga, Anaika, Ishita, Jatin");

                    startActivity(act2);
                    break;
                case "gr2_9":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Dancing Raisins");
                    act2.putExtra("Members", "Prithvi, Harshini, Saanvi, Shreya");

                    startActivity(act2);
                    break;
                case "gr2_10":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Explosion!!");
                    act2.putExtra("Members", "Riya, Ojas, Anavi, Aiyana");

                    startActivity(act2);
                    break;

                case "gr2_11":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Lasting Health");
                    act2.putExtra("Members", "Tejaas, Arhan, Mishka, Navya");

                    startActivity(act2);
                    break;
                case "gr2_12":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Magical Jar");
                    act2.putExtra("Members", "Anshuman, Advay, Shruthi, Srijon");

                    startActivity(act2);
                    break;

                case "gr5_1":
                     act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Information Desk (May I Help?)");
                    act2.putExtra("Members", "Jennifer, Saniha");


                    startActivity(act2);
                    break;

                case "gr5_2":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "BESCOM at your service!");
                    act2.putExtra("Members", "Aparajitha, Laalenthika, Vanini, Amrita");

                    startActivity(act2);
                    break;
                case "gr5_3":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Begin with a spark");
                    act2.putExtra("Members", "Anika, Aditya A");

                    startActivity(act2);
                    break;
                case "gr5_4":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Jumping Jack");
                    act2.putExtra("Members", "Diya P, Sanjana, Shishir, Aryan D");

                    startActivity(act2);
                    break;
                case "gr5_5":
                    act2 = new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Magical Moves");
                    act2.putExtra("Members", "Prachi, Shaina, Parth, Pranav");
                    startActivity(act2);
                    break;
                case "gr5_6":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Lightning Thief");
                    act2.putExtra("Members", "Surabhi, Anushree");
                    startActivity(act2);
                    break;
                case "gr5_7":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Are you brighter than a fifth grader?");
                    act2.putExtra("Members", "Surya  M, Shreyas, Mrinal, Meghashyam");

                    startActivity(act2);
                    break;
                case "gr5_8":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "May the best win!");
                    act2.putExtra("Members", "Naisha, Sharmila,  Omkar, Arjyo");

                    startActivity(act2);
                    break;
                case "gr5_9":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Lemony Glow");
                    act2.putExtra("Members", "Rohan, Prishim, Gia, Samarth");

                    startActivity(act2);
                    break;
                case "gr5_10":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "To be or not to be");
                    act2.putExtra("Members", "Shreya, Arundhati, Arushi, Anushka ");

                    startActivity(act2);
                    break;
                case "gr5_11":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Mutual Attraction");
                    act2.putExtra("Members", "Arin, Ishan");

                    startActivity(act2);
                    break;
                case "gr5_13":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Buoyant Latitudes");
                    act2.putExtra("Members", "Andhiya, Gayana, Shriya, Ravina");

                    startActivity(act2);
                    break;
                case "gr5_12":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Instant Attraction");
                    act2.putExtra("Members", "Sameer, Aryan, Kriti, Aditi");

                    startActivity(act2);
                    break;

                case "gr5_14":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Dancing Magnets");
                    act2.putExtra("Members", "Atharv, Gokul, Yash, Aditya S");

                    startActivity(act2);
                    break;
                case "gr5_15":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Stylised Dimensions");
                    act2.putExtra("Members", "Soham, Shreya, Michelle, Aarav");

                    startActivity(act2);
                    break;
                case "gr5_16":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "E.E Corner- Alternative sources of energy");
                    act2.putExtra("Members", "Vasundhara, Sampada, Isha Priya, Prakhar");

                    startActivity(act2);
                    break;
                case "gr5_17":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Math Corner – Light Up!");
                    act2.putExtra("Members", "Kriti, Nandita, Tanvi, Diya Prakash");

                    startActivity(act2);
                    break;

                case "gr6_1":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");


                    startActivity(act2);
                    break;

                case "gr6_2":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;
                case "gr6_3":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;
                case "gr6_4":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;
                case "gr6_5":
                    act2 = new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");
                    startActivity(act2);
                    break;
                case "gr6_6":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");
                    startActivity(act2);
                    break;
                case "gr6_7":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;
                case "gr6_8":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;
                case "gr6_9":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;
                case "gr6_10":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;
                case "gr6_11":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;
                case "gr6_13":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;
                case "gr6_12":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;

                case "gr6_14":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;
                case "gr6_15":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;
                case "gr6_16":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;
                case "gr6_17":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "");
                    act2.putExtra("Members", ""); act2.putExtra("Location", "Located in: ");

                    startActivity(act2);
                    break;

                case "gr7_1":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Darpan – Street Play");
                    act2.putExtra("Members", "Anahat, Aryan, Ishaan, Pradyut, Inika, KanishQ, Neha, Kyra, Anand S, Hiya, Minhal, Manogna"); act2.putExtra("Location", "Located in: Central Courtyard");


                    startActivity(act2);
                    break;

                case "gr7_2":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Heart Pumping");
                    act2.putExtra("Members", "Sanjana GR, Tarunya"); act2.putExtra("Location", "Located in:10C ");

                    startActivity(act2);
                    break;
                case "gr7_3":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "RNA");
                    act2.putExtra("Members", "Sai Vaidyaa, Vikas K, Keerthana G"); act2.putExtra("Location", "Located in: 10C ");

                    startActivity(act2);
                    break;
                case "gr7_4":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Harmful Microorganisms");
                    act2.putExtra("Members", "AntaraV, Riya A"); act2.putExtra("Location", "Located in: 10C");

                    startActivity(act2);
                    break;
                case "gr7_5":
                    act2 = new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Adulterated food");
                    act2.putExtra("Members", "Dhruv Bhatia, Param L, SudhanvaK"); act2.putExtra("Location", "Located in: 10C");
                    startActivity(act2);
                    break;
                case "gr7_6":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Cyclone protecting city"
                             );
                    act2.putExtra("Members", "Malavika M, Nisha J"); act2.putExtra("Location", "Located in: 7B");
                    startActivity(act2);
                    break;
                case "gr7_7":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Non Newtonian Fluid");
                    act2.putExtra("Members", "Ananya M, Nina H"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;
                case "gr7_8":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Home Made AC");
                    act2.putExtra("Members", "Rahul M, Shreyas G"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;
                case "gr7_9":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Light house");
                    act2.putExtra("Members", "Varun I, Chaitanya G"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;
                case "gr7_10":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Golden Gate bridge");
                    act2.putExtra("Members", "Neha S , Kritika R, Meghna M"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;
                case "gr7_11":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Energy conservation in a Park");
                    act2.putExtra("Members", "Disha P, Nithya A, Madhura S"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;
                case "gr7_13":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "AMES Room");
                    act2.putExtra("Members", "Shivanshi D, Richelle A, Rohini S"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;
                case "gr7_12":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Mobile Home");
                    act2.putExtra("Members", "Suvvan N, Abhiram S"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;

                case "gr7_14":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Futuristic interiors of a house");
                    act2.putExtra("Members", "Aryan S, Dhruv A"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;
                case "gr7_15":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Smart Home");
                    act2.putExtra("Members", "Aditya S, Pavvan P, Vivek V"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;
                case "gr7_16":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Smart Hospital");
                    act2.putExtra("Members", "Ananya S, Esha S"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;
                case "gr7_17":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Electricity from Garbage Generator");
                    act2.putExtra("Members", "Shreya J, Stuti G, Anoushka V"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;
                case "gr7_18":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Solar Wind Mill");
                    act2.putExtra("Members", "Varun H, Rohan T, Mohnish"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;
                case "gr7_19":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Future Highways");
                    act2.putExtra("Members", "Mrigank, Jairaj Arnav O"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;
                case "gr7_20":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Levitating orb.");
                    act2.putExtra("Members", "Akshit P, Aldrich"); act2.putExtra("Location", "Located in: 7B");

                    startActivity(act2);
                    break;

                case "gr7_21":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Paper bridge");
                    act2.putExtra("Members", "Sanjana Giridhar, Ridhima B"); act2.putExtra("Location", "Located in: 7C");


                    startActivity(act2);
                    break;

                case "gr7_22":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Kingdom tour of Saudi Arabia");
                    act2.putExtra("Members", "Saathivik S, Tanmay V"); act2.putExtra("Location", "Located in:7C ");

                    startActivity(act2);
                    break;
                case "gr7_23":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Fireworks in a jar");
                    act2.putExtra("Members", "Ojaswi B , Adeeba M"); act2.putExtra("Location", "Located in: 7C ");

                    startActivity(act2);
                    break;
                case "gr7_24":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Pyramid puzzle");
                    act2.putExtra("Members", "Anupam D , Suyash, Rahul M"); act2.putExtra("Location", "Located in: 7C");

                    startActivity(act2);
                    break;
                case "gr7_25":
                    act2 = new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Qutab Minar");
                    act2.putExtra("Members", "Prithvi , Akash"); act2.putExtra("Location", "Located in: 7C");
                    startActivity(act2);
                    break;
                case "gr7_26":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Taj Mahal"
                    );
                    act2.putExtra("Members", "Mahit, Mehul ,Sayee Charan"); act2.putExtra("Location", "Located in: 7C");
                    startActivity(act2);
                    break;
                case "gr7_27":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Platonic solids");
                    act2.putExtra("Members", "Aditi I , Mihika S, Tiana D"); act2.putExtra("Location", "Located in: 7C");

                    startActivity(act2);
                    break;
                case "gr7_28":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "History of Pythagoras Theorem");
                    act2.putExtra("Members", "Maya"); act2.putExtra("Location", "Located in: 7C");

                    startActivity(act2);
                    break;
                case "gr7_29":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Napiers bones");
                    act2.putExtra("Members", "Akash Singh, Nitish R, Rahul HR"); act2.putExtra("Location", "Located in: 7C");

                    startActivity(act2);
                    break;
                case "gr7_30":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Cuisenaire rods");
                    act2.putExtra("Members", "Aryaman, Rohit V"); act2.putExtra("Location", "Located in: 7C");

                    startActivity(act2);
                    break;
                case "gr7_31":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Mathematical Clock");
                    act2.putExtra("Members", "Benther, Raj deep"); act2.putExtra("Location", "Located in: 7C");

                    startActivity(act2);
                    break;
                case "gr7_32":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Egyptian rope stretchers");
                    act2.putExtra("Members", "Peri , Sahiti"); act2.putExtra("Location", "Located in: 7C");

                    startActivity(act2);
                    break;
                case "gr7_33":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Curve stitching");
                    act2.putExtra("Members", "Prisha , Rachna"); act2.putExtra("Location", "Located in: 7C");

                    startActivity(act2);
                    break;
                case "gr7_34":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Fourth order magic square dance");
                    act2.putExtra("Members", "Mihika , Nitish, Rachana,Rahul M, Aryaman, Sai charan , Stuti, Adeeba, Perie, Anoushka, Riya , Tiana, Nina, Benther, NehaS Ananya Saranghi"); act2.putExtra("Location", "Located in: French Room");

                    startActivity(act2);
                    break;
                case "gr8_1":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Quiz");
                    act2.putExtra("Members", "Soumya A, Sruti N, Ananya"); act2.putExtra("Location", "Located in: Smart Board Room");


                    startActivity(act2);
                    break;

                case "gr8_2":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "End Of Universe");
                    act2.putExtra("Members", "Sushrut W, SriVishnu, Aditya B"); act2.putExtra("Location", "Located in: Smart Board Room");

                    startActivity(act2);
                    break;
                case "gr8_3":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Geostationary objects");
                    act2.putExtra("Members", "Anishka, Ananya S, Tejasvi, Pradeep"); act2.putExtra("Location", "Located in: 8B");

                    startActivity(act2);
                    break;
                case "gr8_4":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Space shuttles");
                    act2.putExtra("Members", "Sona T, Soumya G."); act2.putExtra("Location", "Located in: 8B");

                    startActivity(act2);
                    break;
                case "gr8_5":
                    act2 = new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Space drones");
                    act2.putExtra("Members", "Tanish, Ajith, Shreyas"); act2.putExtra("Location", "Located in: 8B");
                    startActivity(act2);
                    break;
                case "gr8_6":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Mars Rover");
                    act2.putExtra("Members", "Dhruti, Aditi K"); act2.putExtra("Location", "Located in: 8B");
                    startActivity(act2);
                    break;
                case "gr8_7":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Hubble’s Telescope");
                    act2.putExtra("Members", "Durga, Rachita"); act2.putExtra("Location", "Located in: 8B");

                    startActivity(act2);
                    break;
                case "gr8_8":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Planetary Migration");
                    act2.putExtra("Members", "Nethra, Sneha V."); act2.putExtra("Location", "Located in: 8B");

                    startActivity(act2);
                    break;
                case "gr8_9":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Rocket- Interior and Exterior");
                    act2.putExtra("Members", "Divyaansh, Nakul, Arjun S."); act2.putExtra("Location", "Located in: 8B");

                    startActivity(act2);
                    break;
                case "gr8_10":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Weather Station");
                    act2.putExtra("Members", "Sahil Agarwal, Satvik S"); act2.putExtra("Location", "Located in: 8B");

                    startActivity(act2);
                    break;
                case "gr8_11":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Bizarre Planets");
                    act2.putExtra("Members", "Medha Dhir , Shreya"); act2.putExtra("Location", "Located in: 9B");

                    startActivity(act2);
                    break;
                case "gr8_13":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Goldilocks zone");
                    act2.putExtra("Members", "Yamini A , Sharanya S , Veda , Kripa"); act2.putExtra("Location", "Located in: 9B");

                    startActivity(act2);
                    break;
                case "gr8_12":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Solar farm");
                    act2.putExtra("Members", "Tushar C , Jeff J"); act2.putExtra("Location", "Located in: 9B");

                    startActivity(act2);
                    break;

                case "gr8_14":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Future Earth");
                    act2.putExtra("Members", "Aastha , Harshita"); act2.putExtra("Location", "Located in: 9B");

                    startActivity(act2);
                    break;
                case "gr8_15":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Andromeda Collision");
                    act2.putExtra("Members", "Keerthana , Manognya"); act2.putExtra("Location", "Located in: 9B");

                    startActivity(act2);
                    break;
                case "gr8_16":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Quasi stellar radiations"); // martial <<<<<<<<<<<<<<<<<<< kenedy courtois >>>>>>>>>>>> de g
                    act2.putExtra("Members", "Ronit Nallagatla, Rishab K, Vishnu"); act2.putExtra("Location", "Located in: 9B");

                    startActivity(act2);
                    break;
                case "gr8_17":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Antariksh – Puppet Show and Dance");
                    act2.putExtra("Members", "Adarsh A, Alina, Gauri, Isha, Vishveshwar, Nikhil, Sarthak, Adarsh M, Ananya B, Devanshi, Gaurav, Saket, Nikhil, Risheet, Siddharth, Aditi R, Anukarsh, Jishnu, Katyayani, Nandan, Ritisha, Ronith Nair, Sanjana Dixit, Shriya G, Trideeb B, Aayush K"); act2.putExtra("Location", "Located in: 3rd Floor AV ROOM");

                    startActivity(act2);
                    break;
                case "gr8_18":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Life in a space-ship");
                    act2.putExtra("Members", "Nisshta, Animisha"); act2.putExtra("Location", "Located in: Smart Board Room");


                    startActivity(act2);
                    break;

                case "gr8_19":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Big Bang Theory");
                    act2.putExtra("Members", "Sai Gayathri, Sanjana G."); act2.putExtra("Location", "Located in: Smart Board Room");

                    startActivity(act2);
                    break;
                case "gr8_20":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Black hole to white hole");
                    act2.putExtra("Members", "Srishti, Meghana A Rupanagunta"); act2.putExtra("Location", "Located in: 8A");

                    startActivity(act2);
                    break;
                case "gr8_21":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Worm hole");
                    act2.putExtra("Members", "Ila, Chinmayi, Shamika"); act2.putExtra("Location", "Located in: 8A");

                    startActivity(act2);
                    break;
                case "gr8_22":
                    act2 = new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Neptune");
                    act2.putExtra("Members", "Nikita, Maanasa"); act2.putExtra("Location", "Located in: 8A");
                    startActivity(act2);
                    break;
                case "gr8_23":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Jupiter and Saturn");
                    act2.putExtra("Members", "Anjali, Manasi, Kaajal"); act2.putExtra("Location", "Located in: 8A");
                    startActivity(act2);
                    break;
                case "gr8_24":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Epsilon star");
                    act2.putExtra("Members", "Megha, Meghana M M"); act2.putExtra("Location", "Located in: 8A");

                    startActivity(act2);
                    break;
                case "gr8_25":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Mars landforms");
                    act2.putExtra("Members", "Chetna, Ganavi"); act2.putExtra("Location", "Located in: 8A");

                    startActivity(act2);
                    break;
                case "gr8_26":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Life on Mars");
                    act2.putExtra("Members", "Aditi A, Archita, Diya B"); act2.putExtra("Location", "Located in: 8A");

                    startActivity(act2);
                    break;
                case "gr9_1":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Bharat Ek Khoj");
                    act2.putExtra("Members", "Abeer, Pranav, Radhika, Rohan, Yashvi M, Ananya U, Anwesha, Ritisha, Rima, Samyukta, Sayoojya, Vibha, Anirudh, Aranya, Deepta, Hamsini, Indumathi, Kasturi, Keerthana A, Poorva, Riddhiman G, Rishabh K, Snigdha, Swathi A, Tarani"); act2.putExtra("Location", "Located in: 12B");


                    startActivity(act2);
                    break;

                case "gr9_2":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Rayon Fibre");
                    act2.putExtra("Members", " Abhijna, Rebecca, "); act2.putExtra("Location", "Located in: 10B");

                    startActivity(act2);
                    break;
                case "gr9_3":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Magic with Chemistry");
                    act2.putExtra("Members", "Jahnavi, Preksha"); act2.putExtra("Location", "Located in: 10B");

                    startActivity(act2);
                    break;
                case "gr9_4":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Cheese to please");
                    act2.putExtra("Members", "Keerthana B, Srikavya"); act2.putExtra("Location", "Located in: 10B");

                    startActivity(act2);
                    break;
                case "gr9_5":
                    act2 = new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Wine preparation");
                    act2.putExtra("Members", "Achyut, Shreyas B"); act2.putExtra("Location", "Located in: 10B");
                    startActivity(act2);
                    break;
                case "gr9_6":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Nuclear reactor");
                    act2.putExtra("Members", "Kriti T, Maithili B"); act2.putExtra("Location", "Located in: 10B");
                    startActivity(act2);
                    break;
                case "gr9_7":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Organic chemistry");
                    act2.putExtra("Members", "Mahalaxmi, Prithvi P"); act2.putExtra("Location", "Located in: 10B");

                    startActivity(act2);
                    break;
                case "gr9_8":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Mode Lumiere");
                    act2.putExtra("Members", "Saahithi M, Sneha K, Tanvi R, Meghna D"); act2.putExtra("Location", "Located in: 10B");

                    startActivity(act2);
                    break;
                case "gr9_9":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Colourful  Chemistry");
                    act2.putExtra("Members", "Simran T, Lalitha Dasu"); act2.putExtra("Location", "Located in: 10B");

                    startActivity(act2);
                    break;
                case "gr9_10":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Food Myths");
                    act2.putExtra("Members", "Aayush V, Advaith J");
                             act2.putExtra("Location", "Located in: 10C");

                    startActivity(act2);
                    break;
                case "gr9_11":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Endocrine glands");
                    act2.putExtra("Members", "Anish P, Sumukh, Tejas"); act2.putExtra("Location", "Located in: 10C");

                    startActivity(act2);
                    break;
                case "gr9_13":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Respiratory System");
                    act2.putExtra("Members", "Sai Thanmayi, Rachel, "); act2.putExtra("Location", "Located in: 10C");

                    startActivity(act2);
                    break;
                case "gr9_12":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "DNA Extraction");
                    act2.putExtra("Members", "Aayushi J, Mira"); act2.putExtra("Location", "Located in: 10C");

                    startActivity(act2);
                    break;

                case "gr9_14":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Haemodialysis");
                    act2.putExtra("Members", "Tapas R., Aditya Samyak"); act2.putExtra("Location", "Located in: 10C");

                    startActivity(act2);
                    break;
                case "gr9_15":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Obstacle avoiding car");
                    act2.putExtra("Members", "Abhinav, Shrey, Vishal"); act2.putExtra("Location", "Located in:10A ");

                    startActivity(act2);
                    break;
                case "gr9_16":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Wireless transfer of energy");
                    act2.putExtra("Members", "Varun, Dhruv"); act2.putExtra("Location", "Located in: 10A");

                    startActivity(act2);
                    break;
                case "gr9_17":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Electromagnetic induction");
                    act2.putExtra("Members", "Apoorva, Nidhish"); act2.putExtra("Location", "Located in: 10A");

                    startActivity(act2);
                    break;
                case "gr9_18":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Piezo electric energy");
                    act2.putExtra("Members", "Atmesh, Rishi"); act2.putExtra("Location", "Located in:10A ");

                    startActivity(act2);
                    break;
                case "gr9_19":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Hydraulic arm");
                    act2.putExtra("Members", "Guha, Dhruv C, Ayush T"); act2.putExtra("Location", "Located in: 10A");

                    startActivity(act2);
                    break;
                case "gr9_20":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Rubegold machine");
                    act2.putExtra("Members", "Lauhitya, Malavika, Trithi J, Siddhant G"); act2.putExtra("Location", "Located in: 10A");

                    startActivity(act2);
                    break;
                case "gr10_1":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Mysore Tell- Tale");

                    act2.putExtra("Members", "Aanandi S., Arshia, Arundhati, Mugdha, Sakshi, Sneha, Akash A., Atman, Devavrath, Diya G, Gayatri, Ishita, Janani, Jayani, Priya K, Medhavi, Parkhi, Sejal, Shivani, Shreya, Smriti, Bhargavi, Kush, Rishita, Ritesh, SuryaSaveri, Shrish"); act2.putExtra("Location", "Located in: Mini Auditorium ");


                    startActivity(act2);
                    break;

                case "gr10_2":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Green Futuristic city");
                    act2.putExtra("Members", "Ojus B , Dhruv M, Sameer C , Siddhant V, Vikram A,  Aditya S, Shreyas S, Smarak P, Varun V, Jacob M, Yash R"); act2.putExtra(" Location", " Located in:Central Courtyard");



                    startActivity(act2);
                    break;
                case "gr10_3":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Social Media Movie");
                    act2.putExtra("Members", "Chinmayee, Shriya S"); act2.putExtra("Location", "Located in: AV ROOM");

                    startActivity(act2);
                    break;
                case "gr10_4":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Self-driving robot");
                    act2.putExtra("Members", "Aditya D, Jaideep, Virinchi, "); act2.putExtra("Location", "Located in: Computer Lab");

                    startActivity(act2);
                    break;
                case "gr10_5":
                    act2 = new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Recipe App.");
                    act2.putExtra("Members", "Lingesh K, Shreyas S, Kalyan V, Shubham K, Siddharth M, Tushar R"); act2.putExtra("Location", "Located in: Computer Lab");
                    startActivity(act2);
                    break;
                case "gr10_6":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Vivriti App.");
                    act2.putExtra("Members", "Rithwik, Prithik, Ananda"); act2.putExtra("Location", "Located on: Your phone :D ");
                    startActivity(act2);
                    break;
                case "gr10_7":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Camrix, photoeditor");
                    act2.putExtra("Members", "Moushumi, Anisha N"); act2.putExtra("Location", "Located in: Computer Lab");

                    startActivity(act2);
                    break;
                case "gr10_8":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Traffic Bot.");
                    act2.putExtra("Members", "Krishna G, Nandan S"); act2.putExtra("Location", "Located in: Computer Lab");

                    startActivity(act2);
                    break;
                case "gr10_9":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "App. Support Strayers");
                    act2.putExtra("Members", "Ananya J , Mihika"); act2.putExtra("Location", "Located in: Computer Lab");

                    startActivity(act2);
                    break;
                case "gr10_10":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Daily schedule App.");
                    act2.putExtra("Members", "Niket Jain"); act2.putExtra("Location", "Located in: Computer Lab");

                    startActivity(act2);
                    break;
                case "gr10_11":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Digestive System");
                    act2.putExtra("Members", "Arpita S., Sejal E."); act2.putExtra("Location", "Located in: 10C");

                    startActivity(act2);
                    break;
                case "gr10_13":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "AM Radio");
                    act2.putExtra("Members", "Atharva R, Gurmeher S, Ritvik U"); act2.putExtra("Location", "Located in: 6A");

                    startActivity(act2);
                    break;
                case "gr10_12":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Hover craft");
                    act2.putExtra("Members", "Ishita C, Ananya S, Ishika B, Saniya S"); act2.putExtra("Location", "Located in: 6A");

                    startActivity(act2);
                    break;

                case "gr10_14":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Hover board");
                    act2.putExtra("Members", "Kavya N, Tanisha M"); act2.putExtra("Location", "Located in: 6A");

                    startActivity(act2);
                    break;
                case "gr10_15":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Drone");
                    act2.putExtra("Members", "Manzood Ali, Amit R, Rohan, Aryan R, Shreyas S, Palash"); act2.putExtra("Location", "Located in: 6A");

                    startActivity(act2);
                    break;
                case "gr10_16":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Autonomous vehicle-nerve impulse");
                    act2.putExtra("Members", "Nesha , Nitya D, Sanskriti M, Shruthi K"); act2.putExtra("Location", "Located in: 6A");

                    startActivity(act2);
                    break;
                case "gr10_17":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Pollution free ways of Transport");
                    act2.putExtra("Members", "Manasa S., Shreya R, Radhika"); act2.putExtra("Location", "Located in: 6A");

                    startActivity(act2);
                    break;

                case "gr11_1":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Vivriti video");
                    act2.putExtra("Members", "Kayan Katrak , Ashwin P"); act2.putExtra("Location", "Located in: AV ROOM");

                    startActivity(act2);
                    break;
                case "gr11_2":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "NPS connect App.");
                    act2.putExtra("Members", "Siddharth V, Suraj K, Vinay S"); act2.putExtra("Location", "Located in: Computer Lab");

                    startActivity(act2);
                    break;
                case "gr11_3":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Social networking and App");
                    act2.putExtra("Members", "Anirudh O, Nikhil PE, Pradyumna S, Pallav RD, Abhinav Murali"); act2.putExtra("Location", "Located in: Computer Lab");

                    startActivity(act2);
                    break;
                case "gr11_4":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Eye diseases");
                    act2.putExtra("Members", "Ayushi Shah, Preeti S"); act2.putExtra("Location", "Located in: 9A");

                    startActivity(act2);
                    break;
                case "gr11_5":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Stem cells");
                    act2.putExtra("Members", "Pranav P, Rahul I, Roche"); act2.putExtra("Location", "Located in: 9A");

                    startActivity(act2);
                    break;
                case "gr11_6":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Heart");
                    act2.putExtra("Members", "Rashi P, Reshma R, Sanjana, Asrita"); act2.putExtra("Location", "Located in: 9A");

                    startActivity(act2);
                    break;
                case "gr11_7":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Brain disorders");
                    act2.putExtra("Members", "S Vandana, Sayee Shruthi"); act2.putExtra("Location", "Located in: 9A");

                    startActivity(act2);
                    break;
                case "gr11_8":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "DNA Mutation");
                    act2.putExtra("Members", "Sriya Adiraju, Asha"); act2.putExtra("Location", "Located in: 9A");

                    startActivity(act2);
                    break;
                case "gr11_9":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Food Pyramid");
                    act2.putExtra("Members", "Swati K, Vineet M"); act2.putExtra("Location", "Located in: 9A");

                    startActivity(act2);
                    break;
                case "gr11_10":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Wound Healing");
                    act2.putExtra("Members", "Aparna M, Keerthi K"); act2.putExtra("Location", "Located in: 9A");

                    startActivity(act2);
                    break;

                case "gr11_11":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Brain Inside out");
                    act2.putExtra("Members", "Arushi B, Madhulika B"); act2.putExtra("Location", "Located in: 9A");

                    startActivity(act2);
                    break;
                case "gr11_12":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Illusions");
                    act2.putExtra("Members", "Vidisha K, Shefali S"); act2.putExtra("Location", "Located in: 9A");

                    startActivity(act2);
                    break;
                case "gr11_13":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Radio FM");
                    act2.putExtra("Members", "Agresh, Kunal"); act2.putExtra("Location", "Located in: 6B");

                    startActivity(act2);
                    break;
                case "gr11_14":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Enigma");
                    act2.putExtra("Members", "Anand S, Adarsh Prasad, Karthik V"); act2.putExtra("Location", "Located in: 6B");

                    startActivity(act2);
                    break;
                case "gr11_15":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Telegraph");
                    act2.putExtra("Members", "Anika, Swethashri,Nikhila VK"); act2.putExtra("Location", "Located in: 6B");

                    startActivity(act2);
                    break;
                case "gr11_16":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Omni-Bot");
                    act2.putExtra("Members", "Gautam N, Varun Balaji, Ruchir Joshi"); act2.putExtra("Location", "Located in: 6B");

                    startActivity(act2);
                    break;
                case "gr11_17":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Aerodynamics");
                    act2.putExtra("Members", "Anubhav C, KanishQ, Saketh"); act2.putExtra("Location", "Located in: 6C");

                    startActivity(act2);
                    break;
                case "gr11_18":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Obstacle avoiding Robot");
                    act2.putExtra("Members", "Mahesh P, Gaven J"); act2.putExtra("Location", "Located in: 6C");

                    startActivity(act2);
                    break;
                case "gr11_19":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Solar Powered boat");
                    act2.putExtra("Members", "Aditi,  Ananya"); act2.putExtra("Location", "Located in: 6C");

                    startActivity(act2);
                    break;
                case "gr11_20":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "ICE");
                    act2.putExtra("Members", "Aditya VH, Jijis, Pranav V, Rishav G"); act2.putExtra("Location", "Located in: 6C");

                    startActivity(act2);
                    break;
                case "gr11_21":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Mind Control Car");
                    act2.putExtra("Members", "Mathew S, Siddharth K, Rajat K"); act2.putExtra("Location", "Located in: 6C");

                    startActivity(act2);
                    break;
                case "gr11_22":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Remote Control Car");
                    act2.putExtra("Members", "Meghana A,  Sneha S, Sneha SM"); act2.putExtra("Location", "Located in: 6C");

                    startActivity(act2);
                    break;
                case "gr11_23":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Segregation Unit");
                    act2.putExtra("Members", "Hradini, Taanya M, Rakshana G"); act2.putExtra("Location", "Located in: 6C");
                    startActivity(act2);
                    break;
                case "gr11_24":
                    act2= new Intent(MainActivity.this,fivest.class);
                    act2.putExtra("Project", "Brail");
                    act2.putExtra("Members", "JuhieF, Ramya, Trisha A"); act2.putExtra("Location", "Located in: 6C");

                    startActivity(act2);
                    break;
                case "Mini Auditorium":
                    Intent intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","French Room");
                    startActivity(intent);
                    break;
                case "AV Room":
                     intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","AV ROOM");
                    startActivity(intent);
                    break;
                case "Computer Lab":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room", "Computer Lab");
                    startActivity(intent);
                    break;
                case "Central Courtyard":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","Central Courtyard");
                    startActivity(intent);
                    break;
                case "12B":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","12 B");
                    startActivity(intent);
                    break;
                case "2A":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","2A");
                    startActivity(intent);
                    break;
                case "2B":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","2B");
                    startActivity(intent);
                    break;
                case "2D":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","2D");
                    startActivity(intent);
                    break;
                case "3B":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","3B");
                    startActivity(intent);
                    break;
                case "3C":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","3C");
                    startActivity(intent);
                    break;
                case "4A":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","4A");
                    startActivity(intent);
                    break;
                case "4B":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room", "4B");
                    startActivity(intent);
                    break;
                //papemape
                case "8A":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room", "8A");
                    startActivity(intent);
                    break;
                case "8B":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room", "8B");
                    startActivity(intent);
                    break;
                case "9A":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room", "9A");
                    startActivity(intent);
                    break;
                case "9B":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room", "9B");
                    startActivity(intent);
                    break;
                case "10A":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room", "10A");
                    startActivity(intent);
                    break;
                case "10B":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room", "10B");
                    startActivity(intent);
                    break;
                case "10C":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room", "10C");
                    startActivity(intent);
                    break;
                case "Smartboard Room":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room", "Smartboard Room");
                    startActivity(intent);
                    break;
                case "6A":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room", "6A");
                    startActivity(intent);
                    break;
                case "6B":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","6B");
                    startActivity(intent);
                    break;
                case "6C":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","6C");
                    startActivity(intent);
                    break;
                case "7C":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","7C");
                    startActivity(intent);
                    break;
                case "French Room":
                    intent = new Intent(MainActivity.this, Roomlist.class);
                    intent.putExtra("Room","French Room");
                    startActivity(intent);
                    break;

            }

/*






























*/

            }







            /*if (result == 1) {
     Intent myIntent = new Intent(MainActivity.this,
             Chessroom.class);
     overridePendingTransition(R.anim.rightin, R.anim.rightout);
 }
*/
    };

    // Mimic continuous auto-focusing
    Camera.AutoFocusCallback autoFocusCB = new Camera.AutoFocusCallback() {
        public void onAutoFocus(boolean success, Camera camera) {
            autoFocusHandler.postDelayed(doAutoFocus, 1000);
        }
    };


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();

            return true;
        }
        return false;
    }



}
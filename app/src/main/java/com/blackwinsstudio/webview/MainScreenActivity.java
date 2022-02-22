package com.blackwinsstudio.webview;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class MainScreenActivity extends AppCompatActivity implements SigninDialog.DialogListener{
    Button FillMenuButton, ExitButton;
    TextView myText;
    // Urls of our images.
    String url1 = "https://images.unsplash.com/photo-1563729784474-d77dbb933a9e?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8";
    String url2 = "https://images.unsplash.com/photo-1599785209796-786432b228bc?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=800&q=280";
    String url3 = "https://images.unsplash.com/photo-1616690710400-a16d146927c5?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=800&q=280";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        Button AppMainButton = (Button) findViewById(R.id.appmainbutton);
        FillMenuButton = (Button) findViewById (R.id.fillmenubutton);
        ExitButton = (Button) findViewById (R.id.exitbutton);
        myText = (TextView)findViewById (R.id.myText);

        // Landing Page Image Slider
        // we are creating array list for storing our image urls.
        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(url1));
        sliderDataArrayList.add(new SliderData(url2));
        sliderDataArrayList.add(new SliderData(url3));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();



        // Landing Page Image Slider ends here
        AppMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Opensastaamart();
            }
        });

        FillMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               OpenFillMenu();
            }


        });

        myText.setOnLongClickListener (new View.OnLongClickListener () {
            @Override
            public boolean onLongClick(View view) {
                //FillMenuButton.setVisibility (View.VISIBLE);
                //ExitButton.setVisibility (View.VISIBLE);
                showAlertDialog();
                return false;
            }
        });


        ExitButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FillMenuButton.setVisibility(View.INVISIBLE);
                ExitButton.setVisibility(View.INVISIBLE);
            }
        });
    }



    private void showAlertDialog() {
            SigninDialog signDialog = new SigninDialog();
            Bundle bundle = new Bundle();
            bundle.putBoolean("notAlertDialog",true);
            signDialog.setArguments(bundle);
            signDialog.show(getSupportFragmentManager(), "signin");


    }



    public void OpenFillMenu() {
        Intent intent = new Intent(this, fillMenuscreen.class);
        startActivity(intent);
    }

    public void Opensastaamart(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra ("page", "mainscreen");
        startActivity(intent);

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
    // except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    @Override
    public void onFinishEditDialog(String inputText) {
        if (TextUtils.isEmpty(inputText)) {
            //textView.setText("Email was not entered");
            Log.i(ApplicationConstant.TAG, "Sign In Vendor OnResponse Code :" + inputText);
            Toast.makeText (MainScreenActivity.this, "Email was not entered", Toast.LENGTH_LONG).show ();

        } else {
            if(inputText.equals("admin@gmail.com")){
                Toast.makeText(MainScreenActivity.this, "Email  entered", Toast.LENGTH_LONG).show();
                FillMenuButton.setVisibility(View.VISIBLE);
                ExitButton.setVisibility(View.VISIBLE);
            }

        }
    }
}
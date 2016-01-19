package com.tusiri.biodict;

import java.io.IOException;
import java.io.InputStream;

import com.tusiri.biodict.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 5000;

    /** Called when the activity is first created. */
    @SuppressLint("ResourceAsColor")
	@Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        /*setContentView(R.layout.splash);
        GifImageView gifImageView = (GifImageView) findViewById(R.id.splashscreen);
        if (Build.VERSION.SDK_INT >= 11) {
            gifImageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        }*/
        
        InputStream stream = null;
        try {
            stream = getAssets().open("splash_final.gif");
        } catch (IOException e) {
            e.printStackTrace();
        }
        GifWebView view = new GifWebView(this, "file:///android_res/drawable/splash_final.gif");
        view.setBackgroundColor(R.color.black);
        setContentView(view);
        
        
        
        /*
        View mainView = getLayoutInflater().inflate(R.layout.splash_web_view, null);

        RelativeLayout rlContainer = (RelativeLayout) mainView.findViewById(R.id.rlContainer);

        GifWebView view = new GifWebView (this, "file:///android_asset/splash_final.gif");

        RelativeLayout.LayoutParams wvParams = new RelativeLayout.LayoutParams(
                                                      RelativeLayout.LayoutParams.MATCH_PARENT,
                                                      RelativeLayout.LayoutParams.MATCH_PARENT);


        rlContainer.addView(view, wvParams);

        setContentView(mainView);
        */
        
        /* New Handler to start the Menu-Activity 	
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(Splash.this,MainActivity.class);
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}

package com.dam.mynicestart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class Splash extends AppCompatActivity {

    ImageView bgLogin;
    TextView linea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        bgLogin = findViewById(R.id.bgLogin);
        linea = findViewById(R.id.signUp2);

        //    New Glide
        Glide.with(this)
                .load(R.drawable.bg_login)
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade(500))
//    .placeholder(new ColorDrawable(this.getResources().getColor(R.color.color2)))
//                .circleCrop()
//                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(bgLogin);


//        "https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80"


//        // sets a Pretty Custom Font
//        Typeface myFont = Typeface.createFromAsset(getAssets(), "bromello.otf");
//        myTitle.setTypeface(myFont);

//        Typeface typeface = getResources().getFont(R.font.bromello);
//        myTitle.setTypeface(typeface);


        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        linea.startAnimation(myAnim);

        openApp(true);

    }

    private void openApp(boolean locationPermission) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash
                        .this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }

}
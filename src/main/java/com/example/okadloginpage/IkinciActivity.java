package com.example.okadloginpage;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import java.util.Random;

public class IkinciActivity extends AppCompatActivity{

    LinearLayout linearLayoutDegiskeni;
    Animation animationDegiskeni, animationDegiskeni2;
    Button butonDegiskeniRenk, butonDegiskeniGeri;
    CardView cardViewDegiskeni1, cardViewDegiskeni2, cardViewDegiskeni3;

    Random rastgeleSayi = new Random();

    float red = rastgeleSayi.nextInt(255);
    float green = rastgeleSayi.nextInt(255);
    float blue = rastgeleSayi.nextInt(255);

    int randomColor = Color.rgb(red, green, blue);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iki);

        linearLayoutDegiskeni = findViewById(R.id.layout2);
        butonDegiskeniRenk = findViewById(R.id.id_btn_renk);
        butonDegiskeniGeri = findViewById(R.id.id_btn_geri);

        cardViewDegiskeni1 = findViewById(R.id.id_cardview_1);
        cardViewDegiskeni2 = findViewById(R.id.id_cardview_2);
        cardViewDegiskeni3 = findViewById(R.id.id_cardview_3);

        animationDegiskeni2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.yukari_kayma);

        cardViewDegiskeni1.startAnimation(animationDegiskeni2);
        cardViewDegiskeni2.setVisibility(View.INVISIBLE);
        cardViewDegiskeni3.setVisibility(View.INVISIBLE);

        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {

            @Override
            public void run() {
                // Do something after 5s = 5000ms

                cardViewDegiskeni2.startAnimation(animationDegiskeni2);
                cardViewDegiskeni2.setVisibility(View.VISIBLE);
                final Handler handler2 = new Handler();
                handler2.postDelayed(new Runnable() {

                    @Override
                    public void run() {
                        // Do something after 5s = 5000ms

                        cardViewDegiskeni3.startAnimation(animationDegiskeni2);
                        cardViewDegiskeni3.setVisibility(View.VISIBLE);
                    }
                }, 2100);
            }
        }, 2100);








        butonDegiskeniRenk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rastgeleSayi = new Random();

                red = rastgeleSayi.nextInt(255);
                green = rastgeleSayi.nextInt(255);
                blue = rastgeleSayi.nextInt(255);

                randomColor = Color.rgb(red, green, blue);

                linearLayoutDegiskeni.setBackgroundColor(randomColor);
            }
        });

        butonDegiskeniGeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                overridePendingTransition(R.anim.sayfa_animasyonu3 , R.anim.sayfa_animasyonu2);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.sayfa_animasyonu3 , R.anim.sayfa_animasyonu2);
    }
}

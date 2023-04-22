package com.example.okadloginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Telephony;
import android.text.InputType;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /* Kimlik: 203405025
       Şifre: 123456   */
    Animation animationDegiskeni;
    ImageView ımageViewDegiskeni;
    TextView textViewDegiskeniBilgilendirmeMesajı;
    EditText editTextDegiskeniKimlik, editTextDegiskeniSifre;
    Button butonDegiskeniGiris;
    ImageButton ımageButonDegiskeniSifreGörme;
    SwitchCompat switchCompatDegiskeniBeniHatırla;

    AbsoluteLayout sa;

    int girilenSifre;
    int beniHatırlaTusuSırası = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        animationDegiskeni = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sola_kayma);
        editTextDegiskeniKimlik = findViewById(R.id.id_kimlik_numarası);
        editTextDegiskeniSifre = findViewById(R.id.id_şifre);
        sa = findViewById(R.id.id_absolute_layout);
        ımageViewDegiskeni = findViewById(R.id.id_profil_resmi);
        textViewDegiskeniBilgilendirmeMesajı = findViewById(R.id.id_bilgilendirme_mesajı);
        butonDegiskeniGiris = findViewById(R.id.id_btn_giriş);
        ımageButonDegiskeniSifreGörme = findViewById(R.id.id_göz);
        switchCompatDegiskeniBeniHatırla = findViewById(R.id.id_beni_hatırla);





        sa.setVisibility(View.INVISIBLE);
        editTextDegiskeniKimlik.startAnimation(animationDegiskeni);



        final Handler handler1 = new Handler();

        handler1.postDelayed(new Runnable() {

            @Override
            public void run() {
                // Do something after 5s = 5000ms

                sa.startAnimation(animationDegiskeni);
                sa.setVisibility(View.VISIBLE);
            }
        }, 2100);





        girilenSifre = editTextDegiskeniSifre.getInputType();

        switchCompatDegiskeniBeniHatırla.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    editTextDegiskeniKimlik.setText("203405025");
                    editTextDegiskeniSifre.setText("12345");
                } else{
                    editTextDegiskeniKimlik.setText("");
                    editTextDegiskeniSifre.setText("");
                }
            }
        });
    }

    public void seçildi(View v) {
        switch (v.getId()){
            case R.id.id_btn_giriş:
                if(editTextDegiskeniKimlik.getText().toString().equals("203405025") && editTextDegiskeniSifre.getText().toString().equals("12345")){
                    ımageViewDegiskeni.setBackground(getDrawable(R.drawable.icon_kisi_dogru));
                    textViewDegiskeniBilgilendirmeMesajı.setText("Şifre Doğru Sisteme Girdiniz");
                    textViewDegiskeniBilgilendirmeMesajı.setTextColor(getColor(R.color.açık_yeşil));

                    Intent geçmeIntenti = new Intent(MainActivity.this, IkinciActivity.class);
                    startActivity(geçmeIntenti);
                    overridePendingTransition(R.anim.sayfa_animasyonu3 , R.anim.sayfa_animasyonu2);
                } else{
                    ımageViewDegiskeni.setBackground(getDrawable(R.drawable.icon_kisi_yanlis));
                    textViewDegiskeniBilgilendirmeMesajı.setText("Şifre veya TC Kimlik Yanlış");
                    textViewDegiskeniBilgilendirmeMesajı.setTextColor(getColor(R.color.açık_kırmızı));
                } break;

            case R.id.id_göz://TYPE_NUMBER_VARIATION_PASSWORD
                    if(beniHatırlaTusuSırası==0){
                        ımageButonDegiskeniSifreGörme.setBackground(getDrawable(R.drawable.icon_goz_secili));
                        editTextDegiskeniSifre.setInputType(InputType.TYPE_CLASS_NUMBER);
                        beniHatırlaTusuSırası = 1;
                    } else if(beniHatırlaTusuSırası==1){
                        ımageButonDegiskeniSifreGörme.setBackground(getDrawable(R.drawable.icon_goz));
                        editTextDegiskeniSifre.setInputType(girilenSifre);
                        beniHatırlaTusuSırası = 0;
                    } break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.sayfa_animasyonu3 , R.anim.sayfa_animasyonu2);
    }




}
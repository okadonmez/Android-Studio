package com.example.okadhesapmakinesi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText işlemEkranı;

    int işlemSırası = 1;
    Double sayi4 = 0.0;
    Double sonuc = 0.0;
    String ilkSayı = "";
    String ikinciSayı = "";
    String operatör;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);
        işlemEkranı = findViewById(R.id.işlemEkranı_Edt_Txt);
        işlemEkranı.setShowSoftInputOnFocus(false);//Klavyenin çıkmasını engelliyor

        işlemEkranı.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getString(R.string.işlem_için_basınız).equals(işlemEkranı.getText().toString())){
                    işlemEkranı.setText("");
                }
            }
        });
    }

    public void butonTiklama(View v){
        switch (v.getId()){
            case R.id.silme_Btn   :
                    silmeFonksiyonu();
                    ilkSayı = işlemEkranı.getText().toString();
                    textView.setText(String.valueOf(ilkSayı));
                break;

            case R.id.c_Btn       :
                    textView.setText("");
                    işlemEkranı.setText("");
                break;

            case R.id.us_Btn      :
                    ilkSayı = işlemEkranı.getText().toString();
                    textView.append("^");
                    işlemEkranı.setText("");
                    operatör = "^";
                    işlemSırası = 2;
                break;

            case R.id.yüzde_Btn   :
                     ilkSayı = işlemEkranı.getText().toString();
                     textView.append("%");
                     işlemEkranı.setText("");
                     operatör = "%";
                     işlemSırası = 2;

                     if(operatör.equalsIgnoreCase("%")){
                        sayi4 = Double.parseDouble(ilkSayı) / 100;
                        işlemEkranı.setText("" + sayi4);
                        sonuc = sayi4;
                        sayi4 = 0.0;
                     }
                 break;

            case R.id.bölüm_Btn   :
                    ilkSayı = işlemEkranı.getText().toString();
                    textView.append("/");
                    işlemEkranı.setText("");
                    operatör = "/";
                    işlemSırası = 2;
                break;

            case R.id.yedi_Btn    :
                    ekranıGüncelle("7");

                    if(işlemSırası==1){
                        ilkSayı = işlemEkranı.getText().toString();
                    } else if(işlemSırası==2){
                        ikinciSayı = işlemEkranı.getText().toString();
                    }

                    textView.append("7");
                break;

            case R.id.sekiz_Btn   :
                    ekranıGüncelle("8");

                    if(işlemSırası==1){
                        ilkSayı = işlemEkranı.getText().toString();
                    } else if(işlemSırası==2){
                        ikinciSayı = işlemEkranı.getText().toString();
                    }

                    textView.append("8");
                break;

            case R.id.dokuz_Btn   :
                    ekranıGüncelle("9");

                    if(işlemSırası==1){
                        ilkSayı = işlemEkranı.getText().toString();
                    } else if(işlemSırası==2){
                        ikinciSayı = işlemEkranı.getText().toString();
                    }

                    textView.append("9");
                break;

            case R.id.çarpım_Btn  :
                    ilkSayı = işlemEkranı.getText().toString();
                    textView.append("*");
                    işlemEkranı.setText("");
                    operatör = "*";
                    işlemSırası = 2;
                break;

            case R.id.dört_Btn    :
                    ekranıGüncelle("4");

                    if(işlemSırası==1){
                        ilkSayı = işlemEkranı.getText().toString();
                    } else if(işlemSırası==2){
                        ikinciSayı = işlemEkranı.getText().toString();
                    }

                    textView.append("4");
                break;

            case R.id.beş_Btn     :
                    ekranıGüncelle("5");

                    if(işlemSırası==1){
                        ilkSayı = işlemEkranı.getText().toString();
                    } else if(işlemSırası==2){
                        ikinciSayı = işlemEkranı.getText().toString();
                    }

                    textView.append("5");
                break;

            case R.id.altı_Btn    :
                    ekranıGüncelle("6");

                    if(işlemSırası==1){
                        ilkSayı = işlemEkranı.getText().toString();
                    } else if(işlemSırası==2){
                        ikinciSayı = işlemEkranı.getText().toString();
                    }

                    textView.append("6");
                break;

            case R.id.eksi_Btn    :
                    ilkSayı = işlemEkranı.getText().toString();
                    textView.append("-");
                    işlemEkranı.setText("");
                    operatör = "-";
                    işlemSırası = 2;
                break;

            case R.id.bir_Btn     :
                    ekranıGüncelle("1");

                    if(işlemSırası==1){
                        ilkSayı = işlemEkranı.getText().toString();
                    } else if(işlemSırası==2){
                        ikinciSayı = işlemEkranı.getText().toString();
                    }

                    textView.append("1");
                break;

            case R.id.iki_Btn     :
                    ekranıGüncelle("2");

                    if(işlemSırası==1){
                        ilkSayı = işlemEkranı.getText().toString();
                    } else if(işlemSırası==2){
                        ikinciSayı = işlemEkranı.getText().toString();
                    }

                    textView.append("2");
                break;

            case R.id.üç_Btn      :
                    ekranıGüncelle("3");

                    if(işlemSırası==1){
                        ilkSayı = işlemEkranı.getText().toString();
                    } else if(işlemSırası==2){
                        ikinciSayı = işlemEkranı.getText().toString();
                    }

                    textView.append("3");
                break;

            case R.id.artı_Btn    :
                    ilkSayı = işlemEkranı.getText().toString();
                    textView.append("+");
                    işlemEkranı.setText("");
                    operatör = "+";
                    işlemSırası = 2;
                break;

            case R.id.üçSıfır_Btn :
                    uçSıfırEklemeFonksiyonu();

                    if(işlemSırası==1){
                        ilkSayı = işlemEkranı.getText().toString();
                    } else if(işlemSırası==2){
                        ikinciSayı = işlemEkranı.getText().toString();
                    }

                    textView.append("000");
                break;

            case R.id.sıfır_Btn   :
                    ekranıGüncelle("0");
                    ilkSayı = işlemEkranı.getText().toString();
                    textView.append("0");
                break;

            case R.id.nokta_Btn   :
                    ekranıGüncelle(".");
                    ilkSayı = işlemEkranı.getText().toString();
                    textView.append(".");
                break;

            case R.id.eşittir_Btn :
                    if(işlemSırası==2){
                        ikinciSayı = işlemEkranı.getText().toString();
                    }

                    textView.append("=");

                    if(operatör.equals("/")){
                        sayi4 = Double.parseDouble(ilkSayı) / Double.parseDouble(ikinciSayı);
                        sonuc = sayi4;
                        sayi4 = 0.0;
                    }else if(operatör.equals("*")){
                        sayi4 = Double.parseDouble(ilkSayı) * Double.parseDouble(ikinciSayı);
                        sonuc = sayi4;
                        sayi4 = 0.0;
                    }else if(operatör.equals("+")){
                        sayi4 = Double.parseDouble(ilkSayı) + Double.parseDouble(ikinciSayı);
                        sonuc = sayi4;
                        sayi4 = 0.0;
                    }else if(operatör.equals("-")){
                        sayi4 = Double.parseDouble(ilkSayı) - Double.parseDouble(ikinciSayı);
                        sonuc = sayi4;
                        sayi4 = 0.0;
                    }else if(operatör.equals("^")){
                        usAlma(ilkSayı, ikinciSayı);
                        sonuc = sayi4;
                        sayi4 = 0.0;
                    }

                    işlemEkranı.setText(""+sonuc);
                    textView.append(String.valueOf(sonuc));
                    işlemEkranı.setSelection(String.valueOf(sonuc).length());
                break;
        }
    }

    private void ekranıGüncelle(String girilenKarakter){

        int imlecPozisyonu = işlemEkranı.getSelectionStart();//İmlecin Yeri

        if(getString(R.string.işlem_için_basınız).equals(işlemEkranı.getText().toString())){

            işlemEkranı.setText("");
        } else{

            String eskiIslemEkrani = işlemEkranı.getText().toString();
            String liftSideOfDisplay = eskiIslemEkrani.substring(0, imlecPozisyonu);
            String rightSideOfDisplay = eskiIslemEkrani.substring(imlecPozisyonu);
            String yeniİslemEkrani = liftSideOfDisplay + girilenKarakter + rightSideOfDisplay;

            işlemEkranı.setText(yeniİslemEkrani);
        }
        //EditText içinde yer alan değerin belirtilen index aralığına göre seçili gelmesini sağlar.
        işlemEkranı.setSelection(imlecPozisyonu + 1);
    }

    private void uçSıfırEklemeFonksiyonu(){

        int imlecPozisyonu = işlemEkranı.getSelectionStart();

        if(getString(R.string.işlem_için_basınız).equals(işlemEkranı.getText().toString())){

            işlemEkranı.setText("000");
        } else{

            String eskiIslemEkrani = işlemEkranı.getText().toString();
            String liftSideOfDisplay = eskiIslemEkrani.substring(0, imlecPozisyonu);
            String rightSideOfDisplay = eskiIslemEkrani.substring(imlecPozisyonu);
            String yeniİslemEkrani = liftSideOfDisplay + "000" + rightSideOfDisplay;

            işlemEkranı.setText(yeniİslemEkrani);
        }

        işlemEkranı.setSelection(imlecPozisyonu + 3);
    }

    private void silmeFonksiyonu(){

        int imlecPozisyonu = işlemEkranı.getSelectionStart();

        if(imlecPozisyonu > 0){

            String eskiIslemEkrani = işlemEkranı.getText().toString();
            String liftSideOfDisplay = eskiIslemEkrani.substring(0, imlecPozisyonu - 1);
            String rightSideOfDisplay = eskiIslemEkrani.substring(imlecPozisyonu);
            String yeniİslemEkrani = liftSideOfDisplay + rightSideOfDisplay;

            işlemEkranı.setText(yeniİslemEkrani);
            işlemEkranı.setSelection(imlecPozisyonu - 1);
        }
    }

    private double usAlma(String Sayı1, String Sayi2){

        sayi4 = 1.0;

        for(int i=0; i<Integer.parseInt(Sayi2); i++){

            sayi4 = sayi4 * Double.parseDouble(Sayı1);
        }

        return sayi4;
    }
}
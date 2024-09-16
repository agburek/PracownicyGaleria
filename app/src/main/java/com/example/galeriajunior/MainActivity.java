package com.example.galeriajunior;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Pracownik> pracownicy = new ArrayList<>();
    TextView textViewImie;
    TextView textViewStanowisko;
    ImageView imageViewStaz;
    Button buttonDalej;
    Button buttonWstecz;
    int aktualnyNumerPracownika = 0;
    Button buttonUsun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pracownicy.add(new Pracownik("Jaś","Tester",0));
        pracownicy.add(new Pracownik("Asia","Programista",2));
        pracownicy.add(new Pracownik("Marek","Informatyk",1));

        textViewImie = findViewById(R.id.textView);
        textViewStanowisko = findViewById(R.id.textView2);
        imageViewStaz = findViewById(R.id.imageView);

        wyswietlPracownika(aktualnyNumerPracownika);

        buttonDalej = findViewById((R.id.button2));
        buttonDalej.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualnyNumerPracownika++;
                        if (aktualnyNumerPracownika == pracownicy.size()){
                            aktualnyNumerPracownika = 0;
                        }
                        wyswietlPracownika(aktualnyNumerPracownika);
                    }
                }
        );

        buttonWstecz = findViewById(R.id.button);
        buttonWstecz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        aktualnyNumerPracownika--;
                        if (aktualnyNumerPracownika < 0){
                            aktualnyNumerPracownika = pracownicy.size()-1;
                        }

                        wyswietlPracownika(aktualnyNumerPracownika);
                    }
                }
        );


     buttonUsun = findViewById(R.id.button3);
        buttonUsun.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (pracownicy.size()>1) {
                            pracownicy.remove(aktualnyNumerPracownika);
                            aktualnyNumerPracownika = 0;
                            wyswietlPracownika(aktualnyNumerPracownika);
                        }
                        else{
                            Toast.makeText(MainActivity.this,
                                    "To jest ostatni pracownik :)",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );

    }

    private void wyswietlPracownika (int i){
        textViewImie.setText(pracownicy.get(i).getImie());
        textViewStanowisko.setText(pracownicy.get(i).getStanowisko());
        int[] idObrazkow = new int[]{R.drawable.junior, R.drawable.middle, R.drawable.senior};
        imageViewStaz.setImageResource(idObrazkow[pracownicy.get(i).getStaz()]);
    }

}
package com.april.uts;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    ImageView Ggunting, Gbatu, Gkertas, hasilkamu, hasilkom;
    TextView jawabanmu, jawabankom, jawaban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Ggunting = (ImageView) findViewById(R.id.Ggunting);
        Gbatu = (ImageView) findViewById(R.id.Gbatu);
        Gkertas = (ImageView) findViewById(R.id.Gkertas);

        hasilkamu = (ImageView) findViewById(R.id.hasilkamu);
        hasilkom = (ImageView) findViewById(R.id.hasilkom);

        jawabanmu = (TextView) findViewById(R.id.jawabanmu);
        jawabankom = (TextView) findViewById(R.id.jawabankom);
        jawaban = (TextView) findViewById(R.id.jawaban);

        Ggunting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasilkamu.setImageResource(R.drawable.gunting);
                String pesan = play_turn("gunting");
                Toast.makeText(GameActivity.this, pesan, Toast.LENGTH_SHORT).show();

            }
        });

        Gbatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasilkamu.setImageResource(R.drawable.batu);
                play_turn("batu");
                String pesan = play_turn("batu");
                Toast.makeText(GameActivity.this, pesan, Toast.LENGTH_SHORT).show();

            }
        });

        Gkertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasilkamu.setImageResource(R.drawable.kertas);
                String pesan = play_turn("kertas");
                Toast.makeText(GameActivity.this, pesan, Toast.LENGTH_SHORT).show();

            }
        });



    }

    public String play_turn(String pilihanmu) {
        String pilihankom = "";
        Random r = new Random();

        //pilih 1 atau 2 atau 3
        int komp_nomer = r.nextInt(3) + 1;

        if (komp_nomer == 1) {
            pilihankom = "gunting";
        } else if (komp_nomer == 2) {
            pilihankom = "batu";
        } else if (komp_nomer == 3) {
            pilihankom = "kertas";
        }

        // pilihan gambar
        if (pilihankom == "gunting"){
            hasilkom.setImageResource(R.drawable.gunting);
        } else if (pilihankom == "batu"){
            hasilkom.setImageResource(R.drawable.batu);
        } else if (pilihankom == "kertas"){
            hasilkom.setImageResource(R.drawable.kertas);
        }

        //hasil yang menang
        if (pilihankom == pilihanmu){
            return "Seri";
        }else if (pilihankom == "gunting" && pilihanmu == "batu"){
            return "Yeay! Kamu Menang";
        }else if (pilihankom == "gunting" && pilihanmu == "kertas"){
            return "Yah.. Kamu Kalah";
        }else if (pilihankom == "batu" && pilihanmu == "gunting"){
            return "Yah.. Kamu Kalah";
        }else if (pilihankom == "batu" && pilihanmu == "kertas") {
            return "Yeay! Kamu Menang";
        }else if (pilihankom == "kertas" && pilihanmu == "batu") {
            return "Yah.. Kamu Kalah";
        }else if (pilihankom == "kertas" && pilihanmu == "gunting") {
            return "Yeay! Kamu Menang!";
        }
        return "sembarang";
    }
}

package com.april.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //String of menu
    ListView menu;
    String[] menuarray = {"Game", "Aboutme"};
    ArrayAdapter adapter_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //konfigurasi dr Front End(xml) ke Back End (java)
        menu = (ListView)findViewById(R.id.isimenu);

        //membuat constructor ArrayAdapter (dgn 3 parameter)
        adapter_menu = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, menuarray);

        //mengirim data u/ ditempatkan ke dalam listview menggunakan method setAdapter()
        menu.setAdapter(adapter_menu);


//            menu = (ListView)findViewById(R.id.isimenu);
            menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (Array.get(menuarray,position).toString().equals("Game")) {
                        ActivityGame();
                    } else if (Array.get(menuarray,position).toString().equals("Aboutme")) {
                        ActivityAboutme();
                    }
                }
            });







    }



    public void ActivityGame(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    private void ActivityAboutme() {
        Intent intent = new Intent(this, AboutmeActivity.class);
        startActivity(intent);
    }
}
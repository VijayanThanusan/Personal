package com.example.shree.materialdesign8.vinod4.setfavorite;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod.SqliteFav.MainActivity;
import com.example.shree.materialdesign8.vinod.SqliteFav.ShowDb;
import com.example.shree.materialdesign8.vinod10.SqliteFav.Fav5;
import com.example.shree.materialdesign8.vinod7.sqlFav.Fav2;
import com.example.shree.materialdesign8.vinod8.sqliteFav.Fav3;
import com.example.shree.materialdesign8.vinod9.sqliteFav.Fav4;

public class SetFavorite extends AppCompatActivity {
    SharedPreferences  sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_favorite);

        Button fav1=(Button)findViewById(R.id.setfav1);
        Button fav2=(Button)findViewById(R.id.setfav2);
        Button fav3=(Button)findViewById(R.id.setfav3);
        Button fav4=(Button)findViewById(R.id.setfav4);
        Button fav5=(Button)findViewById(R.id.setfav5);


        fav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences("Fav1", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();

                boolean  firstTime=sharedPreferences.getBoolean("first", true);
                if(firstTime) {
                    editor.putBoolean("first",false);
                    editor.commit();  //or  editor.apply();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), ShowDb.class);
                    startActivity(intent);
                }

            }
        });

        fav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f2=new Intent(getApplicationContext(), Fav2.class);
                startActivity(f2);
            }
        });

        fav3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f3=new Intent(getApplicationContext(), Fav3.class);
                startActivity(f3);
            }
        });

        fav4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent f4=new Intent(getApplicationContext(), Fav4.class);
                startActivity(f4);
            }
        });

        fav5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f5=new Intent(getApplicationContext(), Fav5.class);
                startActivity(f5);
            }
        });
    }
}

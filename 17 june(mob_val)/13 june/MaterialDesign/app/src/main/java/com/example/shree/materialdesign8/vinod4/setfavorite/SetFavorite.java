package com.example.shree.materialdesign8.vinod4.setfavorite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod.SqliteFav.MainActivity;
import com.example.shree.materialdesign8.vinod10.SqliteFav.Fav5;
import com.example.shree.materialdesign8.vinod7.sqlFav.Fav2;
import com.example.shree.materialdesign8.vinod8.sqliteFav.Fav3;
import com.example.shree.materialdesign8.vinod9.sqliteFav.Fav4;

public class SetFavorite extends AppCompatActivity {
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
                Intent f1=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(f1);
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

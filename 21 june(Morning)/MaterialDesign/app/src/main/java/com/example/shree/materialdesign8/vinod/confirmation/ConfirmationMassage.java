package com.example.shree.materialdesign8.vinod.confirmation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod2.labcategory.Thankyou;

public class ConfirmationMassage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_massage);
        Button button=(Button)findViewById(R.id.confirm);
        TextView notice = (TextView)findViewById(R.id.notice);
        TextView pname1 = (TextView)findViewById(R.id.pname);
        TextView pmnumber1 = (TextView)findViewById(R.id.pmnumber);
        TextView landmark1 = (TextView)findViewById(R.id.landmark);
        TextView zipcode1 = (TextView)findViewById(R.id.zipcode);
        TextView test = (TextView)findViewById(R.id.test);
        Intent in = getIntent();
        Bundle b = in.getExtras();

        String name = b.getString("pname");
        //long phnumber = b.getLong("phnum");
        String phnumber = b.getString("phnum");
        String land=b.getString("landmark");
        String ZipCode=b.getString("ZipCode");
        String test1=b.getString("abc");
       String n=b.getString("notice");
        // String phno = Long.toString(phnumber);


        pname1.setText(name);
        pmnumber1.setText(phnumber);
        landmark1.setText(land);
        zipcode1.setText(ZipCode);
        test.setText(test1);
        notice.setText(n);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getBaseContext(), Thankyou.class);
                startActivity(i);

            }
        });

    }
}

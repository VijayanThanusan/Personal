package com.example.shree.materialdesign8.vinod11.editprofile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shree.materialdesign8.Otp;
import com.example.shree.materialdesign8.R;

public class RegisterProfile extends AppCompatActivity {

    String Dfname;
    String Dlname;
    String Dcity;
    String DRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_profile);

        final TextView textName=(TextView)findViewById(R.id.txtname);
        final TextView textLast=(TextView)findViewById(R.id.txtlname);
        final TextView textcity=(TextView)findViewById(R.id.txtcity);
        final EditText EditEducation=(EditText)findViewById(R.id.txteducation);
        final TextView textregistration=(TextView)findViewById(R.id.txteregnum);
        final EditText textspeciality=(EditText) findViewById(R.id.txtspeciality);
        final EditText textMobNumber=(EditText)findViewById(R.id.txtmobile);
        Button  editprofile=(Button)findViewById(R.id.txtsubmit);


        SharedPreferences prefs = getSharedPreferences(Otp.OTP, MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        Dfname = prefs.getString("name1", null);
        Dlname = prefs.getString("lastname",null);
        Dcity =prefs.getString("city",null);
        DRegister =prefs.getString("registration",null);

        //int idName = 0;
        if (restoredText != null) {
            String name = prefs.getString("name1", "No name defined"); //"No name defined" is the default value.
            // idName = prefs.getInt("idName", 0);
        }
        textName.setText(Dfname);
        textLast.setText(Dlname);
        textcity.setText(Dcity);
        textregistration.setText(DRegister);

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView textna=(TextView)findViewById(R.id.txtname);
                TextView textLa=(TextView)findViewById(R.id.txtlname);
                TextView textci=(TextView)findViewById(R.id.txtcity);
                EditText EditEd=(EditText)findViewById(R.id.txteducation);
                TextView textreg=(TextView)findViewById(R.id.txteregnum);
                EditText textsp=(EditText) findViewById(R.id.txtspeciality);
                EditText textMo=(EditText)findViewById(R.id.txtmobile);


                String textDname = textna.getText().toString();
                String textDlname = textLa.getText().toString();
                String textDCity = textci.getText().toString();
                String textDEducation = EditEd.getText().toString();
                String textDregistration =textreg.getText().toString();
                String textDspeciality = textsp.getText().toString();
                String textDmobilenum = textMo.getText().toString();

                if (textna.getText().toString().length() == 0 && textLa.getText().toString().length() == 0 && textci.getText().toString().length() == 0 && EditEd.getText().toString().length() == 0 && textreg.getText().toString().length() == 0 && textsp.getText().toString().length() == 0 && textMo.getText().toString().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "plz enter all details", Toast.LENGTH_SHORT).show();
                } else {

                    //Converting phnumber to long type
                    //long phno = Long.parseLong(phnumber1);
                    //Creating Bundle object
                    Bundle buD = new Bundle();

                    //Storing data into bundle
                    buD.putString("Dname", textDname);
                    buD.putString("Dlname", textDlname);
                    buD.putString("Dcity", textDCity);
                    buD.putString("Deducation", textDEducation);
                    buD.putString("Dregistratin", textDregistration);
                    buD.putString("Dspeciality", textDspeciality);
                    buD.putString("Dmobile", textDmobilenum);
                    //Creating Intent object
                    Intent Regp = new Intent(RegisterProfile.this, EditProfile.class);
                    //Storing bundle object into intent
                    Regp.putExtras(buD);
                    startActivity(Regp);

                    //Intent editp = new Intent(RegisterProfile.this, EditProfile.class);
                    //startActivity(editp);
                }
            }
        });
    }
}

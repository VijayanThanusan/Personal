package com.example.shree.materialdesign8.vinod1.alertregistration;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.shree.materialdesign8.Otp;
import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.SelectQualification;
import com.example.shree.materialdesign8.LoginWithDiff;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.Specility;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SpecilityAyush1;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SpecilityHomopathic;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SpecilitySiddha;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SpecilityVetrinary;
import com.hbb20.CountryCodePicker;

public class LoginAlert extends AppCompatActivity {
    CountryCodePicker ccp;
    EditText mobile;
    String TAG;
    String code;
    public static String  MY_PREFS_MOBILE="mobile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_alert);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);



        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
            //  Toast.makeText(LoginAlert.this, "You Slected " + ccp.getSelectedCountryName(), Toast.LENGTH_SHORT).show();

               // Toast.makeText(LoginAlert.this, "You Slected " + ccp.getSelectedCountryCodeWithPlus(), Toast.LENGTH_SHORT).show();

                Log.d(TAG, "changes: " + ccp.getSelectedCountryName());
                //String countryname = ccp.getDefaultCountryCodeWithPlus().toString();
                //EditText editmobcode=(EditText)findViewById(R.id.mobilewithcode);
               // editmobcode.setText(countryname.toString());
                //mobile.setText(ccp.getDefaultCountryCode().toString());

            }
        });

        final EditText mobile=(EditText)findViewById(R.id.mobilewithcode);


        Button getsatart=(Button)findViewById(R.id.getstarted);
        getsatart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                /*Intent getstr=new Intent(getApplicationContext(),RegisterDialog.class);
                startActivity(getstr);*/
                String m=mobile.getText().toString().trim();
                if(m.isEmpty()||!isValidMobile(m)||mobile.getText().toString().toString().length()<10 || m.length()>13 )
                {
                    mobile.setError("Please Enter Valid Mobile Number");


                }
                else {
                    String code1= ccp.getSelectedCountryCodeWithPlus();
                    final String number=code1+m;
                   // Toast.makeText(LoginAlert.this,number,Toast.LENGTH_LONG).show();
                    final CharSequence[] items = {"Allopathic Doctor", "Ayush Medicine Practitioner","Homeopathy","Undergraduate Student","Siddha Medicine","Vetrinary Doctor","Other"};

                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginAlert.this);

                    builder.setTitle("I Am-");
                    builder.setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int item) {
                            if (items[item].equals("Allopathic Doctor")) {

                                EditText editmobcode=(EditText)findViewById(R.id.mobilewithcode);
                                String m=editmobcode .getText().toString();

                                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_MOBILE, MODE_PRIVATE).edit();
                                editor.putString("mobile",number);
                                editor.putString("ald","Allopathic Doctor");

                                editor.commit();

                            /* //start pass data
                            String a="Allopathic Doctor";
                            EditText editmobcode=(EditText)findViewById(R.id.mobilewithcode);
                            String m=editmobcode .getText().toString();
                            Bundle b=new Bundle();
                            b.putString("mobile",m);
                            b.putString("alopathic", a);
                            //end paSS DATA*/

                                Intent i=new Intent(LoginAlert.this, Specility.class);
                                // i.putExtras(b);
                                //Toast.makeText(LoginAlert.this, "You Slected " + b.toString(), Toast.LENGTH_SHORT).show();
                                startActivity(i);

                            } else if (items[item].equals("Ayush Medicine Practitioner")) {

                                EditText editmobcode=(EditText)findViewById(R.id.mobilewithcode);
                                String m=editmobcode .getText().toString();

                                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_MOBILE, MODE_PRIVATE).edit();
                                editor.putString("mobile",number);
                                editor.putString("ald","Ayush Medicine");

                                editor.commit();


                                Intent i=new Intent(LoginAlert.this, SpecilityAyush1.class);
                                startActivity(i);
                            }

                            else if (items[item].equals("Homeopathy")) {

                                EditText editmobcode=(EditText)findViewById(R.id.mobilewithcode);
                                String m=editmobcode .getText().toString();

                                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_MOBILE, MODE_PRIVATE).edit();
                                editor.putString("mobile",number);
                                editor.putString("ald","Homeopathy");

                                editor.commit();
                                Intent i=new Intent(LoginAlert.this, SpecilityHomopathic.class);
                                startActivity(i);
                            }

                            else if (items[item].equals("Undergraduate Student")) {
                                EditText editmobcode=(EditText)findViewById(R.id.mobilewithcode);
                                String m=editmobcode .getText().toString();

                                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_MOBILE, MODE_PRIVATE).edit();
                                editor.putString("mobile",number);
                                editor.putString("ald","Undergraduate Student");

                                editor.commit();
                                Intent i=new Intent(LoginAlert.this, SelectQualification.class);
                                startActivity(i);
                            }
                            else if (items[item].equals("Siddha Medicine")) {
                                EditText editmobcode=(EditText)findViewById(R.id.mobilewithcode);
                                String m=editmobcode .getText().toString();

                                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_MOBILE, MODE_PRIVATE).edit();
                                editor.putString("mobile",number);
                                editor.putString("ald","Siddha Medicine");

                                editor.commit();
                                Intent i=new Intent(LoginAlert.this, SpecilitySiddha.class);
                                startActivity(i);
                            }
                            else if (items[item].equals("Vetrinary Doctor")) {

                                EditText editmobcode=(EditText)findViewById(R.id.mobilewithcode);
                                String m=editmobcode .getText().toString();

                                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_MOBILE, MODE_PRIVATE).edit();
                                editor.putString("mobile",number);
                                editor.putString("ald","Vetrinary Doctor");

                                editor.commit();
                                Intent i=new Intent(LoginAlert.this, SpecilityVetrinary.class);
                                startActivity(i);
                            }
                            else if (items[item].equals("Other")) {
                                //dialog.dismiss();
                                EditText editmobcode=(EditText)findViewById(R.id.mobilewithcode);
                                String m=editmobcode .getText().toString();

                                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_MOBILE, MODE_PRIVATE).edit();
                                editor.putString("mobile",number);
                                editor.putString("ald","Other");

                                editor.commit();
                                Intent i=new Intent(LoginAlert.this, Otp.class);
                                startActivity(i);
                            }
                        }
                    });
                    builder.show();
                }


            }

        });

        LinearLayout regvtru=(LinearLayout) findViewById(R.id.registervTrue);
        regvtru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent regv=new Intent(getApplicationContext(),LoginWithDiff.class);
                startActivity(regv);

            }
        });

    }
    private static boolean isValidMobile(String mobile)
    {
        return !TextUtils.isEmpty(mobile)&& Patterns.PHONE.matcher(mobile).matches();
    }


}

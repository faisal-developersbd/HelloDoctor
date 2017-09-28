package system.faisalshakiba.com.hellodoctor.commonactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import system.faisalshakiba.com.hellodoctor.R;


/**
 * Created by TC on 9/27/2017.
 */

public class LandingActivity extends AppCompatActivity {
    TextView notRegistration;
   // RadioButton parent,doctor;
    EditText username,password;
    String user="";
    Button sign_in;
    final int REQUEST_CODE_ASK_PERMISSIONS = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);
        ActivityCompat.requestPermissions(LandingActivity.this, new String[]{"android.permission.INTERNET"}, REQUEST_CODE_ASK_PERMISSIONS);
        notRegistration=(TextView) findViewById(R.id.txt_not_registration);
        //parent=(RadioButton) findViewById(R.id.radio_patient);
       // doctor=(RadioButton) findViewById(R.id.radio_doctor);
        username=(EditText) findViewById(R.id.txt_username);
        password=(EditText) findViewById(R.id.txt_password);
        sign_in=(Button) findViewById(R.id.btn_signin);
         user=getIntent().getStringExtra("user");
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!username.equals(null)&&!password.equals(null))
                {
                    String userId=username.getText().toString();
                    String userPassword=password.getText().toString();
//                    if(parent.isChecked())
//                    {
                        Intent intent=new Intent(LandingActivity.this,PatientNavActivity.class);
                        startActivity(intent);
                        finish();
                  //  }
//                    else if(doctor.isChecked())
//                    {
//                        Intent intent2=new Intent(LandingActivity.this,DoctorRegistration.class);
//                        startActivity(intent2);
//                        finish();
                   // }
                  //  else Toast.makeText(getBaseContext(),"ERROR: SELECT PATIENT/DOCTOR FIRST",Toast.LENGTH_LONG).show();
                }
                else Toast.makeText(getBaseContext(),"WARNING: username/password is emplty",Toast.LENGTH_LONG).show();

            }
        });
        notRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent;
                if(user.equals("doctor"))
                {
                    intent=new Intent(LandingActivity.this,DoctorRegistration.class);
                }
                else intent=new Intent(LandingActivity.this,PatientRegistration.class);

                startActivity(intent);
                finish();
            }
        });

    }
}

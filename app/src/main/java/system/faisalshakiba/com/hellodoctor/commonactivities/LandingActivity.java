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
import system.faisalshakiba.com.hellodoctor.server.BackgroundWorker;

import static java.lang.Thread.sleep;


/**
 * Created by TC on 9/27/2017.
 */

public class LandingActivity extends AppCompatActivity {
    TextView notRegistration;
   // RadioButton parent,doctor;
    String result;
    EditText username,password;
    String user="";
    Button sign_in;
    final int REQUEST_CODE_ASK_PERMISSIONS = 123;
    String userId="";
    String userPassword="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing_page);
        ActivityCompat.requestPermissions(LandingActivity.this, new String[]{"android.permission.INTERNET"}, REQUEST_CODE_ASK_PERMISSIONS);
        notRegistration=(TextView) findViewById(R.id.txt_not_registration);
        //parent=(RadioButton) findViewById(R.id.radio_patient);
       // doctor=(RadioButton) findViewById(R.id.radio_doctor);
        username=(EditText) findViewById(R.id.txt_username4);
        password=(EditText) findViewById(R.id.txt_password4);
        sign_in=(Button) findViewById(R.id.btn_signin);
         user=getIntent().getStringExtra("user");
       result="";
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userId=username.getText().toString();
                userPassword=password.getText().toString();

                if(userId.equals("")&&userPassword.equals(""))
                {

//                    else if(doctor.isChecked())
//                    {
//                        Intent intent2=new Intent(LandingActivity.this,DoctorRegistration.class);
//                        startActivity(intent2);
//                        finish();
                   // }
                   Toast.makeText(getBaseContext(),"ERROR: SELECT PATIENT/DOCTOR FIRST",Toast.LENGTH_LONG).show();
                }
                else
                {
                    //API calling
                    String url="http://hellodoctor.kilatiron.com/login_patient";
                    String method="pat_login";
                    final BackgroundWorker worker=new BackgroundWorker(LandingActivity.this,url);
                    worker.execute(method,userId,userPassword);

                    Thread thread=new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try
                            {
                                sleep(1000);
                                 result =worker.returnqueryString();

                            }catch (Exception e)
                            {

                            }


                        }
                    });
                    thread.start();

                    Toast.makeText(getBaseContext(),"Registration Successfully! "+ result,Toast.LENGTH_LONG).show();





//                    if(parent.isChecked())
//                    {
                    Toast.makeText(getBaseContext(),userId+" "+userPassword,Toast.LENGTH_LONG).show();
//                    Intent intent=new Intent(LandingActivity.this,PatientNavActivity.class);
//                    startActivity(intent);
//                    finish();

                    //  }
                }

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

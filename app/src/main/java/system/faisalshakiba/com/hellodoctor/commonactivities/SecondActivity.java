package system.faisalshakiba.com.hellodoctor.commonactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import system.faisalshakiba.com.hellodoctor.R;

public class SecondActivity extends AppCompatActivity {
    RadioButton patient,doctor;
    Button next,back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        patient=(RadioButton) findViewById(R.id.s_patient);
        doctor=(RadioButton) findViewById(R.id.s_doctor);
        next=(Button) findViewById(R.id.s_btn_next2);
       // back=(Button) findViewById(R.id.s_btn_back);
        try

        {

        next.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if(patient.isChecked())
                {

                    Intent intent=new Intent(SecondActivity.this,LandingActivity.class);
                    intent.putExtra("user","patient");
                    startActivity(intent);
                    finish();
                }
                else if(doctor.isChecked())
                {
                    Intent intent2=new Intent(SecondActivity.this,LandingActivity.class);
                    intent2.putExtra("user","doctor");
                    startActivity(intent2);
                    finish();
                }
            }

        });
        }catch(Exception e)
        {

        }
//        back.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(SecondActivity.this,LandingActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }
}

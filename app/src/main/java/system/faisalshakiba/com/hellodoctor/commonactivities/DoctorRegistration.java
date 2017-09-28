package system.faisalshakiba.com.hellodoctor.commonactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import system.faisalshakiba.com.hellodoctor.R;

/**
 * Created by TC on 9/27/2017.
 */

public class DoctorRegistration extends AppCompatActivity {
  Button registration,addShedule,addLocation,back;
    EditText doc_id,name,password,mobile,email,fees,sp_id,day,from_time,to_time,location;
    TimePicker timePicker;
    DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_registration);
        back=(Button) findViewById(R.id.d_btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DoctorRegistration.this,LandingActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

}

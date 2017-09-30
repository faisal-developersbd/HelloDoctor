package system.faisalshakiba.com.hellodoctor.commonactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import system.faisalshakiba.com.hellodoctor.R;
import system.faisalshakiba.com.hellodoctor.apitest.DoctorActivity;
import system.faisalshakiba.com.hellodoctor.items.doctor;
import system.faisalshakiba.com.hellodoctor.items.doctorlist;
import system.faisalshakiba.com.hellodoctor.server.ApiCall;
import system.faisalshakiba.com.hellodoctor.server.BackgroundWorker;

/**
 * Created by TC on 9/27/2017.
 */

public class DoctorRegistration extends AppCompatActivity {
  Button registration,addShedule,addLocation,back;
    EditText doc_id,name,password,mobile,email,fees,day,from_time,to_time,location;
    TimePicker timePicker;
    DatePicker datePicker;
    Spinner sp_id;
    int isbusy=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_registration);
        doc_id=(EditText) findViewById(R.id.d_id);
        name=(EditText) findViewById(R.id.d_name);
        password=(EditText) findViewById(R.id.d_password);
        mobile=(EditText) findViewById(R.id.d_mobile);
        email=(EditText) findViewById(R.id.d_email);
        fees=(EditText) findViewById(R.id.d_fees);
        sp_id=(Spinner) findViewById(R.id.d_sp_id);
        day=(EditText) findViewById(R.id.d_date);
        from_time=(EditText) findViewById(R.id.d_from_time);
        to_time=(EditText) findViewById(R.id.d_to_time);
        doc_id=(EditText) findViewById(R.id.d_id);
        location=(EditText) findViewById(R.id.d_location);
        back=(Button) findViewById(R.id.d_btn_back);
        timePicker=(TimePicker) findViewById(R.id.d_timepicker);
        datePicker=(DatePicker) findViewById(R.id.d_datePicker);
        back=(Button) findViewById(R.id.d_btn_back);
        registration=(Button) findViewById(R.id.d_btn_registration);


        List<String > items=new ArrayList<String>();
        items.add("select");
        items.add("Psychiatrist (5)");
        items.add("Child and Adolescent Psychiatrist (4)");
        items.add("Psychopharmacologist (5)");
        items.add("Pediatric Psychopharmacologist (8)");
        items.add("Psychologist (3)");
        items.add("Neuropsychologist (6)");
        items.add("Psychotherapist (4)");
        items.add("Pediatrician (3)");
        items.add("Developmental and behavioral pediatricians (8)");
        items.add("Neurologist (2)");
        items.add("Pediatric Neurologist (3)");


        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1,items);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_id.setAdapter(myadapter);
        sp_id.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = position - 1;
                String it = parent.getItemAtPosition(position).toString();
                if (it.equals("select")) {
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{


                String docId=doc_id.getText().toString();
                String docName=name.getText().toString();
                String docPassword=password.getText().toString();
                String docMobile=mobile.getText().toString();
                String docEmail=email.getText().toString();
                String docFees=fees.getText().toString();



                String url="http://192.168.0.108:8084/HelloDoctorApi/create_doctor";
                String method="create_doctor";
               BackgroundWorker worker=new BackgroundWorker(DoctorRegistration.this,url);
            worker.execute(method,docId,docName,docPassword,docMobile,docEmail,docFees,"101","101");
//                Toast.makeText(getBaseContext(),"Data inserted!",Toast.LENGTH_LONG).show();
                //ApiCall apiCall=new ApiCall();
               // apiCall.create_doctor(url,docId,docName,docPassword,docMobile,docEmail,docFees,"101","101");

               // apiCall.create_patient(url,docId,docName,docPassword,docMobile,docEmail);
//                    Intent intent=new Intent(DoctorRegistration.this,DoctorActivity.class);
//                    startActivity(intent);
                    clear();
                Toast.makeText(getBaseContext(),"Registration Successfully!",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getBaseContext(),"Error: "+e,Toast.LENGTH_LONG).show();
                }
            }
        });
        from_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(isbusy==1)
                {
                    String s=""+timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
                    from_time.setText(s);
                }
                timePicker.setVisibility(View.VISIBLE);
                isbusy=1;
                Toast.makeText(getBaseContext(),"enter from time",Toast.LENGTH_LONG).show();

            }
        });
        to_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(isbusy==2)
                {
                    String s=""+timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
                    to_time.setText(s);
                }
                timePicker.setVisibility(View.VISIBLE);
                isbusy=2;
                Toast.makeText(getBaseContext(),"enter to time",Toast.LENGTH_LONG).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isbusy==0)
                {
                    Intent intent=new Intent(DoctorRegistration.this,LandingActivity.class);
                    intent.putExtra("user","doctor");
                    startActivity(intent);
                    finish();
                }
                else{
                    timePicker.setVisibility(View.GONE);
                    isbusy=0;
                }
            }
        });

    }
    public void clear()
    {
        doc_id.setText("");
        email.setText("");
        name.setText("");
        password.setText("");
        mobile.setText("");
        fees.setText("");
    }

}

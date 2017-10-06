package system.faisalshakiba.com.hellodoctor.commonactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import system.faisalshakiba.com.hellodoctor.R;
import system.faisalshakiba.com.hellodoctor.server.BackgroundWorker;



public class PatientRegistration extends AppCompatActivity {

    EditText id,name,password,mobile,email;
    Button signup;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.setVisibility(View.GONE);
        id=(EditText) findViewById(R.id.p_id);
        name=(EditText) findViewById(R.id.p_name);
        password=(EditText) findViewById(R.id.p_password);
        mobile=(EditText) findViewById(R.id.p_mobile);
        email=(EditText) findViewById(R.id.p_email);
        signup=(Button) findViewById(R.id.p_signup);
        back=(Button) findViewById(R.id.p_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientRegistration.this,LandingActivity.class);
                intent.putExtra("user","patient");
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String docId=id.getText().toString();
                String docName=name.getText().toString();
                String docPassword=password.getText().toString();
                String docMobile=mobile.getText().toString();
                String docEmail=email.getText().toString();

                String url="http://hellodoctor.kilatiron.com/create_patient";
                String method="create_patient";
                BackgroundWorker worker=new BackgroundWorker(PatientRegistration.this,url);
                worker.execute(method,docId,docName,docPassword,docMobile,docEmail);
                Toast.makeText(getBaseContext(),"Registration Successfully! "+worker.getResult(),Toast.LENGTH_LONG).show();
                clear();
            }
        });
    }
    public void clear()
    {
        id.setText("");
        email.setText("");
        name.setText("");
        password.setText("");
        mobile.setText("");

    }

}

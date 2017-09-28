package system.faisalshakiba.com.hellodoctor.apitest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import system.faisalshakiba.com.hellodoctor.R;
import system.faisalshakiba.com.hellodoctor.server.BackgroundWorker;

public class DoctorActivity extends AppCompatActivity {
    Button loginDoc;
    EditText id;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);

        loginDoc=(Button) findViewById(R.id.btn_doc_login);
        id=(EditText) findViewById(R.id.inp_id);
        password=(EditText) findViewById(R.id.inp_password);

        loginDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String i_id=id.getText().toString();
                String i_password=password.getText().toString();

//                String url="http://192.168.0.108:8084/HelloDoctorApi/login_patient";
                String url="http://192.168.0.108:8084/HelloDoctorApi/create_time";
                String method="create_time";
                BackgroundWorker worker=new BackgroundWorker(DoctorActivity.this,url);
                worker.execute(method,i_id,i_password,"1234","1234");
            }
        });

    }
}

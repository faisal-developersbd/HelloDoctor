package system.faisalshakiba.com.hellodoctor;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by faisal on 4/18/17.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    private String connectionString="";
    ApiCall apiCall;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    protected String doInBackground(String... params) {
        String type=params[0];
        //String connectionString="http://192.168.0.100:8084/NabannaApiGenerator/calculation";
       // setConnectionString("http://192.168.0.106:8084/NabannaApiGenerator/calculation");
        if(type.equals("pat_login"))
        {
            apiCall.login_patient(connectionString,params[1],params[2]);
        }
        else if(type.equals("create_patient"))
        {
            apiCall.create_patient(connectionString,params[1],params[2],params[3],params[4],params[5]);
        }
        else if(type.equals("create_doctor"))
        {
            apiCall.create_doctor(connectionString,params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8]);
        }
        else if(type.equals("create_time"))
        {
            apiCall.create_time(connectionString,params[1],params[2],params[3],params[4]);
        }
        else if(type.equals("create_ambulance"))
        {
            apiCall.create_ambulance(connectionString,params[1],params[2],params[3],params[4],params[5]);
        }
        else if(type.equals("create_booking"))
        {
            apiCall.create_booking(connectionString,params[1],params[2],params[3],params[4]);
        }
        else if(type.equals("create_rehab"))
        {
            apiCall.create_rehab(connectionString,params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8]);
        }
        else if(type.equals("create_specialist"))
        {
            apiCall.create_specialist(connectionString,params[1],params[2],params[3]);
        }
        else if(type.equals("login_doctor"))
        {
            apiCall.login_doctor(connectionString,params[1],params[2]);
        }
        else if(type.equals("list_ambulance"))
        {
            apiCall.list_ambulance(connectionString);
        }
        else if(type.equals("list_booking"))
        {
            apiCall.list_booking(connectionString,params[1]);
        }
        else if(type.equals("list_rehab"))
        {
            apiCall.list_rehab(connectionString);
        }else if(type.equals("list_specialist"))
        {
            apiCall.list_specialist(connectionString);
        }
        else if(type.equals("list_time"))
        {
            apiCall.list_time(connectionString);
        }
        else if(type.equals("doctor_time"))
        {
            apiCall.doctor_time(connectionString,params[1]);
        }
        else if(type.equals("booking_patient"))
        {
            apiCall.booking_patient(connectionString,params[1]);
        }
        else if(type.equals("booking_doctor"))
        {
            apiCall.booking_patient(connectionString,params[1]);
        }



        return null;
    }

    @Override
    protected void onPreExecute() {

//        alertDialog=new AlertDialog.Builder(context).create();
//        alertDialog.setTitle("Login Status");


    }

    @Override
    protected void onPostExecute(String aVoid) {

       // alertDialog.setMessage(aVoid);
//       alertDialog.show();
        Log.d("message","Message: "+aVoid);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    public BackgroundWorker(Context context,String connectionString) {
        this.context=context;
        this.connectionString=connectionString;
        apiCall=new ApiCall();
    }
}

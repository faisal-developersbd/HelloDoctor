package system.faisalshakiba.com.hellodoctor.server;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by faisal on 4/18/17.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    private String connectionString="";
    ApiCall apiCall;
    String result;

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
            result=apiCall.login_patient(connectionString,params[1],params[2]);
        }
        else if(type.equals("create_patient"))
        {
            result=apiCall.create_patient(connectionString,params[1],params[2],params[3],params[4],params[5]);
        }
        else if(type.equals("create_doctor"))
        {
            result=apiCall.create_doctor(connectionString,params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8]);
        }
        else if(type.equals("create_time"))
        {
            result=apiCall.create_time(connectionString,params[1],params[2],params[3],params[4]);
        }
        else if(type.equals("create_ambulance"))
        {
            result=apiCall.create_ambulance(connectionString,params[1],params[2],params[3],params[4],params[5]);
        }
        else if(type.equals("create_booking"))
        {
            result=apiCall.create_booking(connectionString,params[1],params[2],params[3],params[4]);
        }
        else if(type.equals("create_rehab"))
        {
            result=apiCall.create_rehab(connectionString,params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8]);
        }
        else if(type.equals("create_specialist"))
        {
            result= apiCall.create_specialist(connectionString,params[1],params[2],params[3]);
        }
        else if(type.equals("login_doctor"))
        {
            result= apiCall.login_doctor(connectionString,params[1],params[2]);
        }
        else if(type.equals("list_ambulance"))
        {
            result=apiCall.list_ambulance(connectionString);
        }
        else if(type.equals("list_booking"))
        {
            result=apiCall.list_booking(connectionString,params[1]);
        }
        else if(type.equals("list_rehab"))
        {
            result=apiCall.list_rehab(connectionString);
        }else if(type.equals("list_specialist"))
        {
            result=apiCall.list_specialist(connectionString);
        }
        else if(type.equals("list_time"))
        {
            result=apiCall.list_time(connectionString);
        }
        else if(type.equals("doctor_time"))
        {
            result=apiCall.doctor_time(connectionString,params[1]);
        }
        else if(type.equals("booking_patient"))
        {
            result=apiCall.booking_patient(connectionString,params[1]);
        }
        else if(type.equals("booking_doctor"))
        {
            result=apiCall.booking_patient(connectionString,params[1]);
        }



        return null;
    }
public String getResult()
{
    return  result;
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

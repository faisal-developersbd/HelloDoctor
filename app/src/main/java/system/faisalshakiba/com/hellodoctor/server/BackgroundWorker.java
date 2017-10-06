package system.faisalshakiba.com.hellodoctor.server;

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
    String result;
    String queryresult="";
    HttpURLConnection httpURLConnection;
    InputStream inputStream;

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        //String connectionString="http://192.168.0.100:8084/NabannaApiGenerator/calculation";
        // setConnectionString("http://192.168.0.106:8084/NabannaApiGenerator/calculation");
        if (type.equals("pat_login")) {
            // result=apiCall.login_patient(connectionString,params[1],params[2]);


            URL url = null;
            try {

                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String user_name = params[1]; //change 2
                String password = params[2];
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("pat_id", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" //change 3
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                Log.d("serverexception", "Data: " + "" + post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception", "Response: " + sb.toString());
                }
                queryresult=sb.toString();
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                this.result = sb.toString();
                Log.d("serverexception", "result: " + result);

            } catch (IOException e) {
                Log.d("serverexception", "Error: " + e);

            }
            return result;
        }


/////
        else if(type.equals("create_patient"))
        {
            //result=apiCall.create_patient(connectionString,params[1],params[2],params[3],params[4],params[5]);
            URL url= null;
            try {

                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String user_name=params[1]; //change 2
                String name=params[2];
                String password=params[3];
                String phone=params[4];
                String mail=params[5];
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("pat_id","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("mobile","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(mail,"UTF-8");
                Log.d("spring","Data: "+""+post_data);

                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("spring","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);
                inputStream.close();
                httpURLConnection.disconnect();
                Log.d("spring1","Response: "+sb.toString());
            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;

    }
        else if(type.equals("create_doctor"))
        {
            //result=apiCall.create_doctor(connectionString,params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8]);
            URL url= null;
            try {

                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String user_name=params[1]; //change 2
                String name=params[2];
                String password=params[3];
                String phone=params[4];
                String mail=params[5];
                String fees=params[6];
                String sp_id=params[7];
                String time=params[8];
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("doc_id","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("mobile","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(mail,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("fees","UTF-8")+"="+URLEncoder.encode(fees,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("sp_id","UTF-8")+"="+URLEncoder.encode(sp_id,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("time_id","UTF-8")+"="+URLEncoder.encode(time,"UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;

        }
        else if(type.equals("create_time"))
        {
            //result=apiCall.create_time(connectionString,params[1],params[2],params[3],params[4]);
            URL url= null;
            try {
                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String time_id=params[1]; //change 2
                String day=params[2];
                String time=params[3];
                String place=params[4];

                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("time_id","UTF-8")+"="+URLEncoder.encode(time_id,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("day","UTF-8")+"="+URLEncoder.encode(day,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("time","UTF-8")+"="+URLEncoder.encode(time,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("place","UTF-8")+"="+URLEncoder.encode(place,"UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        }
        else if(type.equals("create_ambulance"))
        {
           // result=apiCall.create_ambulance(connectionString,params[1],params[2],params[3],params[4],params[5]);
            URL url= null;
            try {

                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String am_id=params[1]; //change 2
                String hospital=params[2];
                String mobile=params[3];
                String charge=params[4];
                String note=params[5];

                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("am_id","UTF-8")+"="+URLEncoder.encode(am_id,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("hospital","UTF-8")+"="+URLEncoder.encode(hospital,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("mobile","UTF-8")+"="+URLEncoder.encode(mobile,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("charge","UTF-8")+"="+URLEncoder.encode(charge,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("note","UTF-8")+"="+URLEncoder.encode(note,"UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        }
        else if(type.equals("create_booking"))
        {
           // result=apiCall.create_booking(connectionString,params[1],params[2],params[3],params[4]);
            URL url= null;
            try {

                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String book_id=params[1]; //change 2
                String doc_id=params[2];
                String time_id=params[3];
                String pat_id=params[4];


                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("book_id","UTF-8")+"="+URLEncoder.encode(book_id,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("doc_id","UTF-8")+"="+URLEncoder.encode(doc_id,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("time_id","UTF-8")+"="+URLEncoder.encode(time_id,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("pat_id","UTF-8")+"="+URLEncoder.encode(pat_id,"UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        }
        else if(type.equals("create_rehab"))
        {
           // result=apiCall.create_rehab(connectionString,params[1],params[2],params[3],params[4],params[5],params[6],params[7],params[8]);
            URL url= null;
            try {

                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String re_id=params[1]; //change 2
                String name=params[2];
                String description=params[3];
                String own_number=params[4];
                String location=params[5]; //change 2
                String lat_long=params[6];
                String help_service=params[7];
                String rating=params[8];


                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("re_id","UTF-8")+"="+URLEncoder.encode(re_id,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("description","UTF-8")+"="+URLEncoder.encode(description,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("own_number","UTF-8")+"="+URLEncoder.encode(own_number,"UTF-8")+"&"
                        +URLEncoder.encode("location","UTF-8")+"="+URLEncoder.encode(location,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("lat_long","UTF-8")+"="+URLEncoder.encode(lat_long,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("help_service","UTF-8")+"="+URLEncoder.encode(help_service,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("rating","UTF-8")+"="+URLEncoder.encode(rating,"UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();


                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        }
        else if(type.equals("create_specialist"))
        {
           // result= apiCall.create_specialist(connectionString,params[1],params[2],params[3]);

            URL url= null;
            try {
                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String re_id=params[1]; //change 2
                String name=params[2];
                String description=params[3];



                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("re_id","UTF-8")+"="+URLEncoder.encode(re_id,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("description","UTF-8")+"="+URLEncoder.encode(description,"UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        }
        else if(type.equals("login_doctor"))
        {
            //result= apiCall.login_doctor(connectionString,params[1],params[2]);
            URL url= null;
            try {
                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String user_name=params[1]; //change 2
                String password=params[2];
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("doc_id","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;

        }

        //list_doctor

        else if(type.equals("list_doctor"))
        {
            //result= apiCall.login_doctor(connectionString,params[1],params[2]);
            URL url= null;
            try {
                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String user_name=params[1]; //change 2
                String password=params[2];
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("doc_id","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&" //change 3
                        +URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;

        }

        //list ambulance
        else if(type.equals("list_ambulance"))
        {
          //  result=apiCall.list_ambulance(connectionString);

            URL url= null;
            try {
                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {


                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("am_id","UTF-8")+"="+URLEncoder.encode("","UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        }
        else if(type.equals("list_booking"))
        {
            //result=apiCall.list_booking(connectionString,params[1]);

            URL url= null;
            try {
                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String book_id=params[1]; //change 2

                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("book_id","UTF-8")+"="+URLEncoder.encode(book_id,"UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        }
        else if(type.equals("list_rehab"))
        {
            //result=apiCall.list_rehab(connectionString);

            URL url= null;
            try {
                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {


                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("am_id","UTF-8")+"="+URLEncoder.encode("","UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;

        }else if(type.equals("list_specialist"))
        {
           // result=apiCall.list_specialist(connectionString);

            URL url= null;
            try {
                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {


                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("am_id","UTF-8")+"="+URLEncoder.encode("","UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;

        }
        else if(type.equals("list_time"))
        {
           // result=apiCall.list_time(connectionString);
            URL url= null;
            try {

                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {


                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("am_id","UTF-8")+"="+URLEncoder.encode("","UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        }
        else if(type.equals("doctor_time"))
        {
           // result=apiCall.doctor_time(connectionString,params[1]);
            URL url= null;
            try {

                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {

                String id=params[1];
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("doc_id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        }
        else if(type.equals("booking_patient"))
        {
            //result=apiCall.booking_patient(connectionString,params[1]);
            URL url= null;
            try {

                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {

                String id=params[1];
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("pat_id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();


                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        }
        else if(type.equals("booking_doctor"))
        {
            //result=apiCall.booking_patient(connectionString,params[1]);

            URL url= null;
            try {

                url = new URL(connectionString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {

                String id=params[1];
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("doc_id","UTF-8")+"="+URLEncoder.encode(id,"UTF-8");
                Log.d("serverexception","Data: "+""+post_data);
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"),8);
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line + "\n");
                    Log.d("serverexception","Response: "+sb.toString());
                    Log.d("message","Message1: "+sb.toString());
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();


                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
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
        Log.d("message","Message2: "+aVoid);
    }
    public String returnqueryString()
    {
        return queryresult;
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

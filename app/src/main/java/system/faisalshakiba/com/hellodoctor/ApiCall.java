package system.faisalshakiba.com.hellodoctor;

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
 * Created by TC on 9/24/2017.
 */

public class ApiCall {
    String connecString="";String result;
    HttpURLConnection httpURLConnection;
    InputStream inputStream;
    public ApiCall()
    {

    }
    public String login_patient(String connecString,String param1,String param2)//change 1
    {
        try {
            URL url= null;
            try {
                this.connecString=connecString;
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String user_name=param1; //change 2
                String password=param2;
                httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data= URLEncoder.encode("pat_id","UTF-8")+"="+URLEncoder.encode(user_name,"UTF-8")+"&" //change 3
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

               this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //create_patient Method
    public String create_patient(String connecString,String param1,String param2,String param3,String param4,String param5)//change 1
    {
        try {
            URL url= null;
            try {
                this.connecString=connecString;
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String user_name=param1; //change 2
                String name=param2;
                String password=param3;
                String phone=param4;
                String mail=param5;
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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
//create_doctor Method
    public String create_doctor(String connecString,String param1,String param2,String param3,String param4,String param5,String param6,String param7,String param8)//change 1
    {
        try {
            URL url= null;
            try {
                this.connecString=connecString;
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String user_name=param1; //change 2
                String name=param2;
                String password=param3;
                String phone=param4;
                String mail=param5;
                String fees=param6;
                String sp_id=param7;
                String time=param8;
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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //create_time method

    public String create_time(String connecString,String param1,String param2,String param3,String param4)//change 1
    {
        try {
            URL url= null;
            try {
                this.connecString=connecString;
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String time_id=param1; //change 2
                String day=param2;
                String time=param3;
                String place=param4;

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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //create_ambulance method 5 parameters

    public String create_ambulance(String connecString,String param1,String param2,String param3,String param4,String param5)//change 1
    {
        try {
            URL url= null;
            try {
                this.connecString=connecString;
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String am_id=param1; //change 2
                String hospital=param2;
                String mobile=param3;
                String charge=param4;
                String note=param5;

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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //create_ambulance method 4 parameters

    public String create_booking(String connecString,String param1,String param2,String param3,String param4)//change 1
    {
        try {
            URL url= null;
            try {
                this.connecString=connecString;
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String book_id=param1; //change 2
                String doc_id=param2;
                String time_id=param3;
                String pat_id=param4;


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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //rehab 8 parameters
    public String create_rehab(String connecString,String param1,String param2,String param3,String param4,String param5,String param6,String param7,String param8)//change 1
    {
        try {
            URL url= null;
            try {
                this.connecString=connecString;
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String re_id=param1; //change 2
                String name=param2;
                String description=param3;
                String own_number=param4;
                String location=param1; //change 2
                String lat_long=param2;
                String help_service=param3;
                String rating=param4;


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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //create_specialist 3 parameters
    public String create_specialist(String connecString,String param1,String param2,String param3)//change 1
    {
        try {
            this.connecString=connecString;;
            URL url= null;
            try {
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String re_id=param1; //change 2
                String name=param2;
                String description=param3;



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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //login doctor 2 parameters
    public String login_doctor(String connecString,String param1,String param2)//change 1
    {
        try {
            URL url= null;
            try {
                this.connecString=connecString;
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String user_name=param1; //change 2
                String password=param2;
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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //list booking 1 parameter
    public String list_booking(String connecString,String param1)//change 1
    {
        try {
            this.connecString=connecString;
            URL url= null;
            try {
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                String book_id=param1; //change 2

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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //list_ambulance no parameters
    public String list_ambulance(String connecString)//change 1
    {
        try {
            this.connecString=connecString;
            URL url= null;
            try {
                url = new URL(connecString);
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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //list_rehab no parameters
    public String list_rehab(String connecString)//change 1
    {
        try {
            this.connecString=connecString;
            URL url= null;
            try {
                url = new URL(connecString);
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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //list_specialist no parameters
    public String list_specialist(String connecString)//change 1
    {
        try {
            this.connecString=connecString;
            URL url= null;
            try {
                url = new URL(connecString);
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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //list_time 1 parameters
    public String list_time(String connecString)//change 1
    {
        try {
            URL url= null;
            try {
                this.connecString=connecString;
                url = new URL(connecString);
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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //doctor_time 1 parameters
    public String doctor_time(String connecString,String param1)//change 1
    {
        try {
            URL url= null;
            try {
                this.connecString=connecString;
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {

                String id=param1;
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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //booking_patient 1 parameters
    public String booking_patient(String connecString,String param1)//change 1
    {
        try {
            URL url= null;
            try {
                this.connecString=connecString;
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {

                String id=param1;
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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
    //booking_doctor 1 parameters
    public String booking_doctor(String connecString,String param1)//change 1
    {
        try {
            URL url= null;
            try {
                this.connecString=connecString;
                url = new URL(connecString);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {

                String id=param1;
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

                this.result=sb.toString();
                Log.d("serverexception","result: "+result);

            } catch (IOException e) {
                Log.d("serverexception","Error: "+e);

            }
            return result;
        } finally {
            try {
                inputStream.close();
                httpURLConnection.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}

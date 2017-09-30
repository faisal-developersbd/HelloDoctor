package system.faisalshakiba.com.hellodoctor.patientfragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import system.faisalshakiba.com.hellodoctor.R;
import system.faisalshakiba.com.hellodoctor.VoiceFeature;
import system.faisalshakiba.com.hellodoctor.items.doctorlist;
import system.faisalshakiba.com.hellodoctor.patientfragments.patient_dashboard.AppoinmentFragment;

import static android.app.Activity.RESULT_OK;
import static java.lang.Thread.sleep;

/**
 * Created by TC on 9/27/2017.
 */

public class patient_dashboard_fragment extends Fragment {

    View myview;
    Context context;
    ListView doctorlistview;
    VoiceFeature vf;
    String cmd="";
    Thread thread;
    String wordString="";
    doctorlist dlist;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.patient_dashboard, container, false);
        context=getActivity().getBaseContext();
        vf=new VoiceFeature(context);
        final List<doctorlist> arrayList=new ArrayList<doctorlist>();
         dlist=new doctorlist();
        dlist=new doctorlist("101",null,"Dr. Hasan","Appoinment 1",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
        arrayList.add(dlist);
        dlist=new doctorlist("102",null,"Dr. Mahmud","Appoinment 2",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
        arrayList.add(dlist);
        dlist=new doctorlist("103",null,"Dr. Sagor","Appoinment 3",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
        arrayList.add(dlist);
        dlist=new doctorlist("104",null,"Dr. Hossain","Appoinment 4",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
        arrayList.add(dlist);
        dlist=new doctorlist("105",null,"Dr. Afroza","Appoinment 5",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
        arrayList.add(dlist);
        doctorlistview=(ListView) myview.findViewById(R.id.listdoctorview);
        final BaseAdapter adapter=new BaseAdapter() {
            LayoutInflater inflater= (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @Override
            public int getCount() {
                return arrayList.size();
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(final int position, View view, ViewGroup viewGroup) {
                if(view==null)
                {
                    view=inflater.inflate(R.layout.patient_dashboard_item,null);
                }
                ImageView imageView=(ImageView) view.findViewById(R.id.doctor_img);
                TextView dName=(TextView) view.findViewById(R.id.doctors_name);
                TextView header=(TextView) view.findViewById(R.id.list_header);
                CheckBox checkNotification=(CheckBox) view.findViewById(R.id.check_notification);
                TextView specialist=(TextView) view.findViewById(R.id.doctors_sp);
                TextView location=(TextView) view.findViewById(R.id.doctors_location);
                TextView time=(TextView) view.findViewById(R.id.doctors_time);
                TextView date=(TextView) view.findViewById(R.id.doctors_date);
                TextView distance=(TextView) view.findViewById(R.id.doctors_distance);
                if(arrayList.get(position).getPropic()!=null)
                    imageView.setImageBitmap(arrayList.get(position).getPropic());
                dName.setText(arrayList.get(position).getDoctorName());
                header.setText(arrayList.get(position).getHeader());
                checkNotification.setChecked(arrayList.get(position).isNotification());
                specialist.setText(arrayList.get(position).getSpecialist());
                location.setText(arrayList.get(position).getLocation());
                time.setText(arrayList.get(position).getTime());
                date.setText(arrayList.get(position).getDate());
                distance.setText(arrayList.get(position).getDistance());

                return view;
            }
        };
        doctorlistview.setAdapter(adapter);
        doctorlistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item= (int) doctorlistview.getAdapter().getItem(position);

                doctorlist dl=arrayList.get(item);

                AppoinmentFragment appoinmentFragment=new AppoinmentFragment();
                appoinmentFragment.setDlist(dl);
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.pat_dashboard,appoinmentFragment).commit();
            }
        });
        adapter.notifyDataSetChanged();
        set_getWordString("Good "+vf.getevent()+"! Do you need anything sir?");
        cmdThread();
        return  myview;
    }
    public String set_getWordString(String wordString)
    {
        this.wordString=wordString;
        return wordString;
    }
    void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Speak Something!");
        try {
             startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);

        } catch (ActivityNotFoundException a) {

        }
    }
    public void cmdThread()
    {
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                    vf.speakWords(wordString);
                    sleep(3000);
                    promptSpeechInput();

                }catch (Exception e)
                {

                }
            }

        });
        thread.start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    cmd=result.get(0);
                    Toast.makeText(context,"Cmd: "+cmd,Toast.LENGTH_LONG).show();
                    if (cmd.equals("yes"))
                    {

//

                            set_getWordString("What do you like me to do sir?");
                            cmdThread();

                    }
                    else if (cmd.equals("no")||cmd.equals("exit")||cmd.equals("you may exit now"))
                    {

//


                        vf.speakWords( set_getWordString("Good bye, sir!"));
                        //cmdThread();

                    }
                    else if (cmd.equals("who are you"))
                    {

//

                        set_getWordString("I am a new AI, installed for assist you, sir.");
                        cmdThread();

                    }
                    else if (cmd.equals("amazing")||cmd.equals("thats great"))
                    {

//

                        set_getWordString("thank you, sir.");
                        cmdThread();

                    }
                    else if (cmd.equals("exit app")||cmd.equals("exit application"))
                    {

//

                        set_getWordString("sure, sir.");
                       System.exit(0);

                    }
                    else if (cmd.equals("hi"))
                    {

//

                        set_getWordString("hello");
                        cmdThread();

                    }

                    else
                    {

//

                        set_getWordString("Sorry sir, I don't recognize. I voice recognation fetures are limited yet.");
                        cmdThread();

                    }

                }
                break;
            }

        }
    }
}

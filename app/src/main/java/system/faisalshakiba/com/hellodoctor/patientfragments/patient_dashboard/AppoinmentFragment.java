package system.faisalshakiba.com.hellodoctor.patientfragments.patient_dashboard;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import system.faisalshakiba.com.hellodoctor.R;
import system.faisalshakiba.com.hellodoctor.VoiceFeature;
import system.faisalshakiba.com.hellodoctor.items.doctorlist;
import system.faisalshakiba.com.hellodoctor.items.time;

import static java.lang.Thread.sleep;

/**
 * Created by TC on 9/28/2017.
 */

public class AppoinmentFragment extends Fragment {
   ImageView imageView;
    TextView nameText;
    TextView specialText;
    TextView location;
    TextView distance;
    TextView ifnull;
    ListView listhistory;
    Button map,call,cancel;
    doctorlist dlist=null;
    View myview;
    TextToSpeech ts;
    Context context;
    VoiceFeature vf;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.activity_appoinment, container, false);
        imageView=(ImageView) myview.findViewById(R.id.img_doctor_details);
        nameText=(TextView) myview.findViewById(R.id.details_doctorName);
        specialText=(TextView) myview.findViewById(R.id.details_doctorSpecialist);
        location=(TextView) myview.findViewById(R.id.details_doctorLocation);
        distance=(TextView) myview.findViewById(R.id.details_doctorDistance);
        ifnull=(TextView) myview.findViewById(R.id.details_ifnull);
        listhistory=(ListView) myview.findViewById(R.id.details_listHistory);
        map=(Button)myview.findViewById(R.id.details_map);
        call=(Button)myview.findViewById(R.id.details_call);
        cancel=(Button)myview.findViewById(R.id.details_cancel);
        context=getActivity().getBaseContext();
        vf=new VoiceFeature(context);
        ts=new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    ts.setLanguage(Locale.UK);
                }
            }
        });


        //setting values
        if(dlist!=null)
        {
            if(dlist.getPropic()!=null)
                imageView.setImageBitmap(dlist.getPropic());
            nameText.setText(dlist.getDoctorName());
            specialText.setText("Specialist in: "+dlist.getSpecialist());
            location.setText("Location: "+dlist.getLocation());
            distance.setText("Distance: "+dlist.getDistance());

        }
        int time_id;
        String day;
        String time;
        String place;
        String note;

        final  ArrayList<time> arrayList=new ArrayList<>();
        time t=new time();
         t=new time(12,"12/05/2017","12:55","PG Hospital","visit after 12/06/2017");
        arrayList.add(t);
         t=new time(16,"12/05/2017","12:45","PG Hospital","visit after 17/06/2017");
        arrayList.add(t);
         t=new time(17,"12/05/2017","12:55","PG Hospital","visit after 18/06/2017");
        arrayList.add(t);
         t=new time(18,"12/05/2017","12:65","PG Hospital","visit after 19/06/2017");
        arrayList.add(t);
         t=new time(19,"12/05/2017","12:35","PG Hospital","visit after 10/06/2017");
        arrayList.add(t);

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
                    view=inflater.inflate(R.layout.history_list,null);
                }

                TextView date=(TextView) view.findViewById(R.id.visit_date);
                TextView time=(TextView) view.findViewById(R.id.visit_time);
                TextView comment=(TextView) view.findViewById(R.id.visit_comment);



                date.setText(arrayList.get(position).getDay());
                time.setText(arrayList.get(position).getTime());
                comment.setText(arrayList.get(position).getNote());


                return view;
            }
        };
        listhistory.setAdapter(adapter);

        adapter.notifyDataSetChanged();

//        final Thread thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//                try {
//                    sleep(1000);
//                    vf.speakWords("Good Moring sir!");
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
        listhistory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String toSpeak="Good Morning Sir! You have 1 appoinment today!";
//                speakWords(toSpeak);
             //   Toast.makeText(context,toSpeak,Toast.LENGTH_LONG).show();
            }
        });

        return myview;
    }
    // speak the user text
    private void speakWords(String speech) {

        // speak straight away
        if(ts != null)
        {
            ts.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    public void onPause() {
        if(ts !=null){
            ts.stop();
            ts.shutdown();
        }
        super.onPause();
    }

    public void setDlist(doctorlist dlist)
    {
        this.dlist=dlist;
    }
}


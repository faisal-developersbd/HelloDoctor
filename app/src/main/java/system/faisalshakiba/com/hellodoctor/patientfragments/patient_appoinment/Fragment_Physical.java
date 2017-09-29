package system.faisalshakiba.com.hellodoctor.patientfragments.patient_appoinment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import system.faisalshakiba.com.hellodoctor.R;
import system.faisalshakiba.com.hellodoctor.items.doctorlist;

/**
 * Created by TC on 9/28/2017.
 */

public class Fragment_Physical extends Fragment {
    Spinner spinner;
    ListView listView;
    View myview;
Context context;
    doctorlist dlist;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.physical_health, container, false);
        spinner=(Spinner) myview.findViewById(R.id.physical_spinner);
        listView=(ListView) myview.findViewById(R.id.physical_listview);
        context=getActivity().getBaseContext();
        List<String > items=new ArrayList<String>();
        items.add("select");
        items.add("Adolescent medicine specialist (2)");
        items.add("Allergist (immunologist) (3)");
        items.add("Anesthesiologist (5)");
        items.add("Cardiac electrophysiologist (1)");
        items.add("Cardiologist (0)");
        items.add("Cardiovascular surgeon (0)");
        items.add("Colon and rectal surgeon (5)");
        items.add("Critical care medicine specialist (0)");
        items.add("Dermatologist (0)");
        items.add("Developmental pediatrician (0)");
        items.add("Emergency medicine specialist (0)");
        items.add("Endocrinologist (0)");
        items.add("Family medicine physician (0)");
        items.add("Forensic pathologist (0)");
        items.add("Gastroenterologist (0)");
        items.add("Geriatric medicine specialist (0)");
        items.add("Gynecologist (0)");
        items.add("Gynecologic oncologist (0)");
        items.add("Hand surgeon (0)");
        items.add("Hematologist (0)");
        items.add("Hepatologist (0)");
        items.add("Hospitalist (0)");

        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,items);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);

        final List<doctorlist> arrayList=new ArrayList<doctorlist>();
         dlist=new doctorlist();

       // listView=(ListView) myview.findViewById(R.id.listdoctorview);
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
                checkNotification.setVisibility(View.GONE);
                specialist.setText(arrayList.get(position).getSpecialist());
                location.setText(arrayList.get(position).getLocation());
                time.setText(arrayList.get(position).getTime());
                date.setText(arrayList.get(position).getDate());
                distance.setText(arrayList.get(position).getDistance());

                return view;
            }
        };
        listView.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = position - 1;
                String it = parent.getItemAtPosition(position).toString();
                if (it.equals("select")) {
                    //Toast.makeText(context,"nothing is selected",Toast.LENGTH_LONG).show();
                    arrayList.clear();
                    adapter.notifyDataSetChanged();
                }
                else if (it.equals("Adolescent medicine specialist (2)")) {
                    //Toast.makeText(context,"nothing is selected",Toast.LENGTH_LONG).show();
                    arrayList.clear();
                    dlist=new doctorlist("101",null,"Dr. Hasan","Appoinment 1",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("102",null,"Dr. Mahmud","Appoinment 2",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);

                    adapter.notifyDataSetChanged();
                }
                else if (it.equals("Allergist (immunologist) (3)")) {
                    //Toast.makeText(context,"nothing is selected",Toast.LENGTH_LONG).show();
                    arrayList.clear();
                    dlist=new doctorlist("101",null,"Dr. Hasan","Appoinment 1",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("102",null,"Dr. Mahmud","Appoinment 2",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("103",null,"Dr. Sagor","Appoinment 3",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);

                    adapter.notifyDataSetChanged();
                }
                else if (it.equals("Anesthesiologist (5)")) {
                    //Toast.makeText(context,"nothing is selected",Toast.LENGTH_LONG).show();
                    arrayList.clear();
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
                    adapter.notifyDataSetChanged();
                }
                else if (it.equals("Cardiac electrophysiologist (1)")) {
                    //Toast.makeText(context,"nothing is selected",Toast.LENGTH_LONG).show();
                    arrayList.clear();
                    dlist=new doctorlist("101",null,"Dr. Hasan","Appoinment 1",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);

                    adapter.notifyDataSetChanged();
                }
                else if (it.equals("Colon and rectal surgeon (5)")) {
                    //Toast.makeText(context,"nothing is selected",Toast.LENGTH_LONG).show();
                    arrayList.clear();
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
                    adapter.notifyDataSetChanged();
                }

                else
                {
                    Toast.makeText(context,"Selected Category: "+it,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
      adapter.notifyDataSetChanged();

                return myview;
    }
}

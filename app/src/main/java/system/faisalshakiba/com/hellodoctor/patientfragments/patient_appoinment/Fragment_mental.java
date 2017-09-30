package system.faisalshakiba.com.hellodoctor.patientfragments.patient_appoinment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
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
import system.faisalshakiba.com.hellodoctor.patientfragments.patient_dashboard_fragment;

/**
 * Created by TC on 9/28/2017.
 */

public class Fragment_mental extends Fragment {
    View myview;
    Context context;
    ListView listView;
    Spinner spinner;
    doctorlist dlist;
    Button back;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.mental_health, container, false);
        spinner=(Spinner) myview.findViewById(R.id.mental_spinner);
        listView=(ListView) myview.findViewById(R.id.mental_listview);
        context=getActivity().getBaseContext();
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

        final List<doctorlist> arrayList=new ArrayList<doctorlist>();
        dlist=new doctorlist();
        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,items);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);

        back=myview.findViewById(R.id.mental_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();

                fragmentManager.beginTransaction().replace(R.id.content_patient_nav,new DoctorAppoinmentFragment()).commit();
            }
        });

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
        adapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = position - 1;
                String it = parent.getItemAtPosition(position).toString();
                if (it.equals("select")) {
                    arrayList.clear();
                    adapter.notifyDataSetChanged();
                    //Toast.makeText(context,"nothing is selected",Toast.LENGTH_LONG).show();
                }
                else  if (it.equals("Psychiatrist (5)"))
                {
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
                else  if (it.equals("Child and Adolescent Psychiatrist (4)"))
                {
                    arrayList.clear();
                    dlist=new doctorlist("101",null,"Dr. Hasan","Appoinment 1",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("102",null,"Dr. Mahmud","Appoinment 2",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("103",null,"Dr. Sagor","Appoinment 3",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("104",null,"Dr. Hossain","Appoinment 4",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                   adapter.notifyDataSetChanged();
                }
                else  if (it.equals("Psychopharmacologist (5)"))
                {
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
                else  if (it.equals("Pediatric Psychopharmacologist (8)"))
                {
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
                    dlist=new doctorlist("103",null,"Dr. Sagor","Appoinment 3",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("104",null,"Dr. Hossain","Appoinment 4",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("105",null,"Dr. Afroza","Appoinment 5",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    adapter.notifyDataSetChanged();
                }
                else  if (it.equals("Neuropsychologist (6)"))
                {
                    arrayList.clear();
                    dlist=new doctorlist("103",null,"Dr. Sagor","Appoinment 3",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("104",null,"Dr. Hossain","Appoinment 4",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("105",null,"Dr. Afroza","Appoinment 5",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("103",null,"Dr. Sagor","Appoinment 3",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("104",null,"Dr. Hossain","Appoinment 4",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("105",null,"Dr. Afroza","Appoinment 5",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    adapter.notifyDataSetChanged();
                }
                else  if (it.equals("Psychiatrist (5)"))
                {
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
                } else  if (it.equals("Developmental and behavioral pediatricians (8)"))
                {
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
                    arrayList.add(dlist);
                    dlist=new doctorlist("104",null,"Dr. Hossain","Appoinment 4",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("105",null,"Dr. Afroza","Appoinment 5",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("105",null,"Dr. Afroza","Appoinment 5",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    adapter.notifyDataSetChanged();
                }
                else  if (it.equals("Neurologist (2)"))
                {
                    arrayList.clear();
                     dlist=new doctorlist("104",null,"Dr. Hossain","Appoinment 4",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("105",null,"Dr. Afroza","Appoinment 5",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    adapter.notifyDataSetChanged();
                }
                else  if (it.equals("Pediatric Neurologist (3)"))
                {
                    arrayList.clear();

                    dlist=new doctorlist("104",null,"Dr. Hossain","Appoinment 4",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("105",null,"Dr. Afroza","Appoinment 5",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    dlist=new doctorlist("105",null,"Dr. Afroza","Appoinment 5",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
                    arrayList.add(dlist);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return myview;
    }
}

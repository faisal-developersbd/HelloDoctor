package system.faisalshakiba.com.hellodoctor;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
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
import java.util.List;

import system.faisalshakiba.com.hellodoctor.items.doctorlist;

/**
 * Created by TC on 9/27/2017.
 */

public class patient_dashboard_fragment extends Fragment {

    View myview;
    Context context;
    ListView doctorlist;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.patient_dashboard, container, false);
        context=getActivity().getBaseContext();
        final List<doctorlist> arrayList=new ArrayList<doctorlist>();
        doctorlist dlist=new doctorlist();
        dlist=new doctorlist(null,"Dr. Hasan","Appoinment 1",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
        arrayList.add(dlist);
        dlist=new doctorlist(null,"Dr. Mahmud","Appoinment 2",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
        arrayList.add(dlist);
        dlist=new doctorlist(null,"Dr. Sagor","Appoinment 3",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
        arrayList.add(dlist);
        dlist=new doctorlist(null,"Dr. Hossain","Appoinment 4",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
        arrayList.add(dlist);
        dlist=new doctorlist(null,"Dr. Afroza","Appoinment 5",true,"Heart Specialist","Mirpur","12:45-01:4","Date","2 km");
        arrayList.add(dlist);
        doctorlist=(ListView) myview.findViewById(R.id.listdoctorview);
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
        doctorlist.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        doctorlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int position=adapterView.getSelectedItemPosition();
                Toast.makeText(context,"Position: "+position,Toast.LENGTH_LONG).show();
            }
        });
        return  myview;
    }
}

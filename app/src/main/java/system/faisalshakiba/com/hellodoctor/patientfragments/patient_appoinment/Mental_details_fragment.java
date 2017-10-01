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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import system.faisalshakiba.com.hellodoctor.R;
import system.faisalshakiba.com.hellodoctor.items.doctorlist;

/**
 * Created by TC on 10/1/2017.
 */

public class Mental_details_fragment extends Fragment {
    View myview;
    Context context;
    doctorlist dlistn;
    ImageView imageView;
    TextView nameText;
    TextView specialText;
    TextView location;
    TextView distance;
    Spinner spinner;
    Button bookingbtn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.booking_appoinment, container, false);
        context=this.getActivity().getBaseContext();

        List<String> items=new ArrayList<String>();
        imageView=(ImageView) myview.findViewById(R.id.img_bookingdoctor);
        nameText=(TextView) myview.findViewById(R.id.booking_doctorName);
        specialText=(TextView) myview.findViewById(R.id.book_doctorSpecialist);
        location=(TextView) myview.findViewById(R.id.booking_doctorLocation);
        distance=(TextView) myview.findViewById(R.id.booking_doctorDistance);
        spinner=(Spinner) myview.findViewById(R.id.booking_spinner);
        bookingbtn=(Button) myview.findViewById(R.id.btn_appoinment_booking);
        nameText.setText(dlistn.getDoctorName());
        specialText.setText(dlistn.getSpecialist());
        distance.setText(dlistn.getLocation());
        nameText.setText(dlistn.getDoctorName());
        bookingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"your booking is confirmed!",Toast.LENGTH_LONG).show();
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_patient_nav,new DoctorAppoinmentFragment()).commit();
            }
        });

        items.add("select time shedule");
        items.add("12:45pm - 03:-01pm Tuesday");
        items.add("12:45pm - 03:-01pm Wednesday");
        items.add("12:45pm - 03:-01pm Monday");
        items.add("12:45pm - 03:-01pm Tuesday");
        items.add("12:45pm - 03:-01pm Wednesday");
        ArrayAdapter<String> myadapter=new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,items);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myadapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = position - 1;
                String it = parent.getItemAtPosition(position).toString();
                if (pos!=0) {
                   location.setText("Mirpur");
                }
                else
                    location.setText("");
               // Toast.makeText(context,"done",Toast.LENGTH_LONG).show();
            }
                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        return myview;
    }

    public void setDlist(doctorlist dlist) {

        dlistn=new doctorlist();
        dlistn = dlist;
    }
}

package system.faisalshakiba.com.hellodoctor;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import system.faisalshakiba.com.hellodoctor.items.doctorlist;

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
        return myview;
    }
    public void setDlist(doctorlist dlist)
    {
        this.dlist=dlist;
    }
}


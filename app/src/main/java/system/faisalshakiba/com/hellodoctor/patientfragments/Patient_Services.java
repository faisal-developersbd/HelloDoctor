package system.faisalshakiba.com.hellodoctor.patientfragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import system.faisalshakiba.com.hellodoctor.patientfragments.patient_services.Ambulance_Fragment;
import system.faisalshakiba.com.hellodoctor.R;
import system.faisalshakiba.com.hellodoctor.patientfragments.patient_services.Rehab_Fragment;

/**
 * Created by TC on 9/27/2017.
 */

public class Patient_Services extends Fragment {

    View myview;
    Button ambulance;
    Button rehab;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.services, container, false);
        ambulance=(Button) myview.findViewById(R.id.amb_button);
        rehab=(Button) myview.findViewById(R.id.rehab_button);

        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_patient_nav,new Ambulance_Fragment()).commit();
            }
        });

        rehab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_patient_nav,new Rehab_Fragment()).commit();
            }
        });

        return  myview;
    }
}

package system.faisalshakiba.com.hellodoctor.patientfragments.patient_appoinment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.usage.UsageEvents;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import system.faisalshakiba.com.hellodoctor.R;

/**
 * Created by TC on 9/28/2017.
 */

public class DoctorAppoinmentFragment extends Fragment {
    View myview;
    Button mental,physical;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.doctors_appointment, container, false);
        mental=(Button) myview.findViewById(R.id.btn_mental);
        physical=(Button) myview.findViewById(R.id.btn_physical);
        mental.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        view.setAlpha(0.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        view.setAlpha(1f);
                        FragmentManager fragmentManager=getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_patient_nav,new Fragment_mental()).commit();
                        break;
                    case MotionEvent.ACTION_MOVE:break;
                }
                return false;
            }
        });
        physical.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        view.setAlpha(0.5f);
                        break;
                    case MotionEvent.ACTION_UP:
                        view.setAlpha(1f);
                        FragmentManager fragmentManager=getFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.content_patient_nav,new Fragment_Physical()).commit();
                        break;
                    case MotionEvent.ACTION_MOVE:break;
                }
                return false;
            }
        });
        return myview;
    }
}

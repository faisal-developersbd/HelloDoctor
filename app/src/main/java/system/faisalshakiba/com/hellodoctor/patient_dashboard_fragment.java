package system.faisalshakiba.com.hellodoctor;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by TC on 9/27/2017.
 */

public class patient_dashboard_fragment extends Fragment {

    View myview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.patient_dashboard, container, false);
        return  myview;
    }
}

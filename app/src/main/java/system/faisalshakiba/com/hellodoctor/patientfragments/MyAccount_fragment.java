package system.faisalshakiba.com.hellodoctor.patientfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import system.faisalshakiba.com.hellodoctor.R;

/**
 * Created by TC on 9/28/2017.
 */

public class MyAccount_fragment extends Fragment {
    View myview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.fragment_myaccount, container, false);
        return myview;
    }
}

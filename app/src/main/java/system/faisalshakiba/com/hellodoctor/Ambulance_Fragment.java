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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import system.faisalshakiba.com.hellodoctor.items.AmulanceListing;

/**
 * Created by faisal-shakiba on 9/28/2017.
 */

public class Ambulance_Fragment extends Fragment {
    View myview;
    Context context;
    ListView ambulance;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.ambulance_information, container, false);
        context=getActivity().getBaseContext();
        final List<AmulanceListing> arrayList=new ArrayList<AmulanceListing>();
        AmulanceListing dlist=new AmulanceListing();

        dlist=new AmulanceListing("1","Ibne Cina","01712347894","500");
        arrayList.add(dlist);
        dlist=new AmulanceListing("2","Apollo","01612347894","500");
        arrayList.add(dlist);
        dlist=new AmulanceListing("3","Berdam","01912347894","500");
        arrayList.add(dlist);
        dlist=new AmulanceListing("4","Medinova","01719947894","500");
        arrayList.add(dlist);

        ambulance=(ListView) myview.findViewById(R.id.listambulanceview);

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
                    view=inflater.inflate(R.layout.ambulance_listview,null);
                }
                TextView amid=(TextView) view.findViewById(R.id.amb_id);
                TextView amhos=(TextView) view.findViewById(R.id.amb_hospital);
                TextView ambnum=(TextView) view.findViewById(R.id.amb_num);
                TextView ambcharge=(TextView) view.findViewById(R.id.amb_charge);
                amid.setText(arrayList.get(position).getId());
                amhos.setText(arrayList.get(position).getHospital());
                ambnum.setText(arrayList.get(position).getNumber());
                ambcharge.setText(arrayList.get(position).getCharge());

                return view;
            }
        };

        ambulance.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ambulance.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int position=adapterView.getSelectedItemPosition();
                Toast.makeText(context,"Position: "+position,Toast.LENGTH_LONG).show();
            }
        });
        return  myview;



    }
}

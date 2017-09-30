package system.faisalshakiba.com.hellodoctor.patientfragments.patient_services;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import system.faisalshakiba.com.hellodoctor.R;
import system.faisalshakiba.com.hellodoctor.items.RehabListing;
import system.faisalshakiba.com.hellodoctor.patientfragments.Patient_Services;
import system.faisalshakiba.com.hellodoctor.patientfragments.patient_dashboard_fragment;

/**
 * Created by faisal-shakiba on 9/28/2017.
 */

public class Rehab_Fragment extends Fragment {

    View myview;
    Context context;
    ListView rehab;
    Button back;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        myview = inflater.inflate(R.layout.rehab_info, container, false);
        context=getActivity().getBaseContext();
        final List<RehabListing> arrayList=new ArrayList<RehabListing>();
        RehabListing dlist=new RehabListing();

        dlist=new RehabListing(null,"1","Addiction Intensive Care (Green Channel)","01711159828, 01778553063, 01613203103",": House:20, Road:2, Block:G, Mirpur:1\n" +
                "(Opposite of Ogsb Hospital Near Eid Ghah Play ground)\n");
        arrayList.add(dlist);
        dlist=new RehabListing(null,"2","Addiction Management and Integrated Care (AMIC)","+880-2-8151114","House # 3D, Road # 1, Shaymoli, Dhaka - 1207, Bangladesh");
        arrayList.add(dlist);
        dlist=new RehabListing(null,"3","Addiction Management And Rehabilitation Home (AMAR Home)","019 66 18 66 18","House # 39; Road # 8; Sector 11; Uttara. Dhaka -1230");
        arrayList.add(dlist);
        dlist=new RehabListing(null,"4","Ashokti Punorbashon Nibash (APON) ( For Male & Children)","+880-2-9126294","Treatment and Rehabilitation Residence (Male & Children), 19/1 Babor Road, Mohammadpur, Dhaka - 1207, Bangladesh");
        arrayList.add(dlist);

        rehab=(ListView) myview.findViewById(R.id.listrehabview);
        back=(Button)  myview.findViewById(R.id.rehab_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=getFragmentManager();

                fragmentManager.beginTransaction().replace(R.id.content_patient_nav,new Patient_Services()).commit();
            }
        });
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
                    view=inflater.inflate(R.layout.rehab_list,null);
                }
                ImageView imageView=(ImageView) view.findViewById(R.id.re_image);
                TextView reid=(TextView) view.findViewById(R.id.re_id);
                TextView rename=(TextView) view.findViewById(R.id.re_name);
                TextView renum=(TextView) view.findViewById(R.id.re_num);
                TextView relocation=(TextView) view.findViewById(R.id.re_location);
                if(arrayList.get(position).getPropic()!=null)
                    imageView.setImageBitmap(arrayList.get(position).getPropic());
                reid.setText(arrayList.get(position).getId());
                rename.setText(arrayList.get(position).getRehabName());
                renum.setText(arrayList.get(position).getNumber());
                relocation.setText(arrayList.get(position).getLocation());

                return view;
            }
        };

        rehab.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        rehab.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int position=adapterView.getSelectedItemPosition();
                Toast.makeText(context,"Position: "+position,Toast.LENGTH_LONG).show();
            }
        });
        return  myview;



    }
}

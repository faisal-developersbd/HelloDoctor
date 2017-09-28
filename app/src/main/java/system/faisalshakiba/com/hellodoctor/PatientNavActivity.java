package system.faisalshakiba.com.hellodoctor;


import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import system.faisalshakiba.com.hellodoctor.items.doctorlist;

public class PatientNavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FragmentManager fragmentManager;
    int trackFragment=0;
    patient_dashboard_fragment patientFragment;
    Patient_About fragment_Patient_about;
    Patient_Doctors_Appoinment fragment_PatientDoctorsAppoinment;
    Patient_Services fragment_Patient_services;
    Patient_RateUs fragment_Patient_rateUs;
    Patient_TermsConditions fragment_TermsConditions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentManager=getFragmentManager();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        fab.setVisibility(View.GONE);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        patientFragment=new patient_dashboard_fragment();
        fragment_Patient_about=new Patient_About();
        fragment_PatientDoctorsAppoinment=new Patient_Doctors_Appoinment();
        fragment_Patient_rateUs=new Patient_RateUs();
        fragment_Patient_services=new Patient_Services();
        fragment_TermsConditions=new Patient_TermsConditions();
        fragmentManager.beginTransaction().replace(R.id.content_patient_nav,patientFragment).commit();
        trackFragment=1;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.patient_nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dashboard) {
            // Handle the camera action
            patient_dashboard_fragment patientFragment=new patient_dashboard_fragment();
            fragmentManager.beginTransaction().replace(R.id.content_patient_nav,patientFragment).commit();
            trackFragment=1;
        } else if (id == R.id.nav_aboutus) {
            patient_dashboard_fragment patientFragment=new patient_dashboard_fragment();
            fragmentManager.beginTransaction().replace(R.id.content_patient_nav,fragment_Patient_about).commit();
            trackFragment=2;
        } else if (id == R.id.nav_doctorsappoinment) {
            patient_dashboard_fragment patientFragment=new patient_dashboard_fragment();
            fragmentManager.beginTransaction().replace(R.id.content_patient_nav,fragment_PatientDoctorsAppoinment).commit();
            trackFragment=3;
        } else if (id == R.id.nav_services) {
            patient_dashboard_fragment patientFragment=new patient_dashboard_fragment();
            fragmentManager.beginTransaction().replace(R.id.content_patient_nav,fragment_Patient_services).commit();
            trackFragment=4;
        }
        else if (id == R.id.nav_rateus) {
            patient_dashboard_fragment patientFragment=new patient_dashboard_fragment();
            fragmentManager.beginTransaction().replace(R.id.content_patient_nav,fragment_Patient_rateUs).commit();
            trackFragment=5;
        }
        else if (id == R.id.nav_termsconditions) {
            patient_dashboard_fragment patientFragment=new patient_dashboard_fragment();
            fragmentManager.beginTransaction().replace(R.id.content_patient_nav,fragment_TermsConditions).commit();
            trackFragment=6;
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

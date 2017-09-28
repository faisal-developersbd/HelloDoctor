package system.faisalshakiba.com.hellodoctor.commonactivities;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import system.faisalshakiba.com.hellodoctor.doctorfragments.Doctor_TermsConditions;
import system.faisalshakiba.com.hellodoctor.doctorfragments.Doctor_about;
import system.faisalshakiba.com.hellodoctor.doctorfragments.Doctor_account;
import system.faisalshakiba.com.hellodoctor.doctorfragments.Doctor_dashboard_fragment;
import system.faisalshakiba.com.hellodoctor.doctorfragments.Doctor_payment;
import system.faisalshakiba.com.hellodoctor.doctorfragments.Doctor_rateus;

import system.faisalshakiba.com.hellodoctor.R;


public class DoctorNavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager;
    int trackFragment=0;
    Doctor_dashboard_fragment doctorFragment;
    Doctor_about fragment_Doctor_about;
    Doctor_account fragment_DoctorsAccount;
    Doctor_payment fragment_Doctors_payment;
    Doctor_rateus fragment_Doctor_rateUs;
    Doctor_TermsConditions fragment_TermsConditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_nav2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        doctorFragment=new Doctor_dashboard_fragment();
        fragment_Doctor_about=new Doctor_about();
        fragment_DoctorsAccount=new Doctor_account();
        fragment_Doctors_payment=new Doctor_payment();
        fragment_Doctor_rateUs=new Doctor_rateus();
        fragment_TermsConditions=new Doctor_TermsConditions();
        fragmentManager.beginTransaction().replace(R.id.content_doctor_nav,doctorFragment).commit();
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
        getMenuInflater().inflate(R.menu.doctor_nav2, menu);
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

            Intent intent=new Intent(DoctorNavActivity.this,LandingActivity.class);
            intent.putExtra("user","patient");
            startActivity(intent);
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dashboard_dr) {
            // Handle the camera action
            Doctor_dashboard_fragment doctorFragment=new Doctor_dashboard_fragment();
            fragmentManager.beginTransaction().replace(R.id.content_doctor_nav,doctorFragment).commit();
            trackFragment=1;
        } else if (id == R.id.nav_aboutus) {

            fragmentManager.beginTransaction().replace(R.id.content_doctor_nav,fragment_Doctor_about).commit();
            trackFragment=2;
        } else if (id == R.id.nav_account) {

            fragmentManager.beginTransaction().replace(R.id.content_doctor_nav,fragment_DoctorsAccount).commit();
            trackFragment=3;
        } else if (id == R.id.nav_payement) {

            fragmentManager.beginTransaction().replace(R.id.content_doctor_nav,fragment_Doctors_payment).commit();
            trackFragment=4;
        }
        else if (id == R.id.nav_rateus) {

            fragmentManager.beginTransaction().replace(R.id.content_doctor_nav,fragment_Doctor_rateUs).commit();
            trackFragment=5;
        }
        else if (id == R.id.nav_termsconditions) {

            fragmentManager.beginTransaction().replace(R.id.content_doctor_nav,fragment_TermsConditions).commit();
            trackFragment=6;
        }else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

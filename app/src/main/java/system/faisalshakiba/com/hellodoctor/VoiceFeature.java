package system.faisalshakiba.com.hellodoctor;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Locale;

import system.faisalshakiba.com.hellodoctor.patientfragments.patient_dashboard_fragment;

/**
 * Created by TC on 9/29/2017.
 */

public class VoiceFeature {
    Context context;
    TextToSpeech ts;
    public VoiceFeature(Context context)
    {
        this.context=context;
        ts=new TextToSpeech(context, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    ts.setLanguage(Locale.UK);
                }
            }
        });
    }

    public  void speakWords(String speech) {

        // speak straight away
        if(ts != null)
        {
            ts.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
        }
    }
    public String getevent()
    {
        Calendar currentTime    = Calendar.getInstance()                ;
        int hour                = currentTime.get(Calendar.HOUR_OF_DAY) ;
        String event;
        if ((hour>=6)&&(hour<=12))
            event="morning";
        else if ((hour>=13)&&(hour<=17))
            event="afternoon";
        else if ((hour>=18)&&(hour<=24))
            event="evening";
        else  event="evening";
        return event;
    }

}

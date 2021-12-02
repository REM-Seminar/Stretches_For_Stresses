package com.example.s4s.ui.login;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.s4s.R;

public class CatalogScreenFragment extends Fragment {

    public static final String TAG ="CatalogScreenFragment";
    ImageView stretchImage2;
    SeekBar timer_sb;
    TextView text_view_countdown;
    Button startAndStopButton;
    CountDownTimer countDownTimer;
    Boolean counterIsActive;

    public CatalogScreenFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalog_screen_fragment, container, false);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = null;
        text_view_countdown = view.findViewById(R.id.text_view_countdown);
        stretchImage2 = view.findViewById(R.id.stretchImage2);
        startAndStopButton = view.findViewById(R.id.startAndStopButton);
        timer_sb = view.findViewById(R.id.timer_sb);
        timer_sb.setMax(60);
        timer_sb.setProgress(0);
        timer_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                update(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    private void update(int progress) {
        int minutes = progress / 60;
        int seconds = progress % 60;
        String secondsFinal = "";
        if(seconds <=5) {
            secondsFinal = "0" + seconds;
        }else{
            secondsFinal = "" + seconds;
        }
        timer_sb.setProgress(progress);
        text_view_countdown.setText("" + minutes + ":" + secondsFinal);
    }

    public void start_timer(View view){
        if (counterIsActive == false) {
            counterIsActive = true;
            timer_sb.setEnabled(false);
            startAndStopButton.setText("STOP");
            countDownTimer = new CountDownTimer(timer_sb.getProgress() * 100, 100) {
                @Override
                public void onTick(long millisUntilFinished) {
                    update((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    reset();
                }
            }.start();
        } else {
                    reset();
                }
            }


    private void reset() {
        text_view_countdown.setText("0:30");
        timer_sb.setProgress(30);
        countDownTimer.cancel();
        startAndStopButton.setText("START");
        timer_sb.setEnabled(true);
        counterIsActive = false;
    }
}
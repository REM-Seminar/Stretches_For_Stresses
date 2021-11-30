package com.example.s4s.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.s4s.Back;
import com.example.s4s.FullBody;
import com.example.s4s.LowerBody;
import com.example.s4s.R;
import com.example.s4s.UpperBody;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CatalogFragment extends Fragment {

    public static final String TAG = "CatalogFragment";
    TextView tvSelect;
    ImageButton ibUpperBody;
    ImageButton ibLowerBody;
    ImageButton ibFullBody;
    ImageButton ibBack;

    ImageView stretchImage2;
    SeekBar timer_sb;
    TextView text_view_countdown;
    Button startAndStopButton;
    CountDownTimer countDownTimer;
    Boolean counterIsActive;

    public CatalogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvSelect = view.findViewById(R.id.tvSelect);
        ibUpperBody = view.findViewById(R.id.ibUpperBody);
        ibLowerBody = view.findViewById(R.id.ibLowerBody);
        ibFullBody = view.findViewById(R.id.ibFullBody);
        ibBack = view.findViewById(R.id.ibBack);

        ibUpperBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick upperbody button");
                goUpperBodyActivity();
            }
        });

        ibLowerBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick lowerbody button");
                goLowerBodyActivity();
            }
        });

        ibFullBody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick fullbody button");
                goFullBodyActivity();
            }
        });

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick back button");
                goBackActivity();
            }
        });
    }

    private void goFullBodyActivity() {
        Intent i = new Intent(getActivity(), FullBody.class);
        startActivity(i);
    }

    private void goBackActivity() {
        Intent i = new Intent(getActivity(), Back.class);
        startActivity(i);
    }

    private void goLowerBodyActivity() {
        Intent i = new Intent(getActivity(), LowerBody.class);
        startActivity(i);
    }

    private void goUpperBodyActivity() {
        Intent i = new Intent(getActivity(), UpperBody.class);
        startActivity(i);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = null;
        text_view_countdown = view.findViewById(R.id.tvCountdown);
        stretchImage2 = view.findViewById(R.id.stretchImage2);
        startAndStopButton = view.findViewById(R.id.timerButton);
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



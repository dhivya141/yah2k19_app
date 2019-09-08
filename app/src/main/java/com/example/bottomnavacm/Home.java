package com.example.bottomnavacm;

import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextClock;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Home extends Fragment {
    public int counter;
    Button button;

    TextView textView;
    View view;

    @Nullable
    @Override

    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home,null) ;
        button = (Button) view.findViewById(R.id.button);
        textView = (TextView) view.findViewById(R.id.textview);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                new CountDownTimer(86400000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        int seconds = (int) (millisUntilFinished / 1000) % 60;
                        int minutes = (int) ((millisUntilFinished / (1000 * 60)) % 60);
                        int hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                        textView.setText(String.format("%d:%d:%d", hours, minutes, seconds));
                        if(hours>=10)
                            textView.setText(String.format("%d:",hours));
                        else if(hours<10)
                            textView.setText(String.format("0%d:",hours));
                        if (minutes>=10)
                            textView.append(String.format("%d:",minutes));
                        else if(minutes<10)
                            textView.append(String.format("0%d:",minutes));
                        if (seconds>=10)
                            textView.append(String.format("%d",seconds));
                        else if(seconds<10)
                            textView.append(String.format("0%d",seconds));

                    }

                    public void onFinish() {
                        textView.setText("done!");
                    }
                }.start();
}
        });
        return view;
    }
}
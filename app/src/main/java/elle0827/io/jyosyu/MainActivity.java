package elle0827.io.jyosyu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int percent;
    Button hogeButton;
    EditText EditText1;
    EditText EditText2;
    EditText EditText3;
    int time1;
    int time2;
    int time3;
    ProgressBar progress1;
    ProgressBar progress2;
    ProgressBar progress3;
    ProgressBar progresstotal;
    SharedPreferences pref;
    CountDown countDown1;
    CountDown countDown2;
    CountDown countDown3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hogeButton = (Button) findViewById(R.id.hogeButton);
        EditText1 = (EditText) findViewById(R.id.EditText1);
        EditText2 = (EditText) findViewById(R.id.EditText2);
        EditText3 = (EditText) findViewById(R.id.EditText3);
        pref = getSharedPreferences("pref   ", MODE_PRIVATE);
        time1 = 0;
        time2 = 0;
        time3 = 0;


        EditText1.setText(pref.getString("key_time1", ""));
        EditText2.setText(pref.getString("key_time2", ""));
        EditText3.setText(pref.getString("key_time3", ""));

        percent = 50;
        progress1 = (ProgressBar) findViewById(R.id.progress1);
        progress2 = (ProgressBar) findViewById(R.id.progress2);
        progress3 = (ProgressBar) findViewById(R.id.progress3);
        progresstotal = (ProgressBar) findViewById(R.id.progresstotal);
        progress1.setMax(100);
        progress1.setProgress(percent);
        progress1.setMin(0);
        progress2.setMax(100);
        progress2.setProgress(percent);
        progress2.setMin(0);
        progress3.setMax(100);
        progress3.setProgress(percent);
        progress3.setMin(0);
        progresstotal.setMax(100);
        progresstotal.setProgress(percent);
        progresstotal.setMin(0);

        countDown1 = new CountDown(time1, 100);
        countDown2 = new CountDown(time2, 100);
        countDown3 = new CountDown(time3, 100);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void hogeButton(View view) {

        progressBar.setProgress(percent, true);
    }

    public void save(View v) {
        String TimeText1 = EditText1.getText().toString();
        String TimeText2 = EditText2.getText().toString();
        String TimeText3 = EditText3.getText().toString();


        time1 = Integer.parseInt(TimeText1);
        time2 = Integer.parseInt(TimeText2);
        time3 =  Integer.parseInt(TimeText3);;

        Log.d("log",String.valueOf(time1)+" "+String.valueOf(time2) +" "+ String.valueOf(time3));

        SharedPreferences.Editor editor = pref.edit();
        editor.putString("key_time1", TimeText1);
        editor.putString("key_time2", TimeText2);
        editor.putString("key_time3", TimeText3);

        editor.commit();


        countDown1.start();

        countDown1.setOnFinishListener(new OnFinishListener() {
            @Override
            public void onFinish() {
//                //カウントダウン終了時の処理
//                TimeText1.setText(String.valueOf(0));
                Toast.makeText(getApplicationContext(), "カウント終了" , Toast.LENGTH_SHORT).show();
            }
        });


        countDown2.setOnTickListener(new OnTickListener() {
            @Override
            public void onTick(long millisUntilFinished) {
                //カウントダウン中の処理
//                TimeText1.setText(String.valueOf(millisUntilFinished));
            }
        });
        countDown2.start();
        countDown2.setOnFinishListener(new OnFinishListener() {
            @Override
            public void onFinish() {
//                //カウントダウン終了時の処理
//                TimeText1.setText(String.valueOf(0));
                Toast.makeText(getApplicationContext(), "カウント終了" , Toast.LENGTH_SHORT).show();
            }
        });


        countDown3.setOnTickListener(new OnTickListener() {
            @Override
            public void onTick(long millisUntilFinished) {
                //カウントダウン中の処理
//                TimeText1.setText(String.valueOf(millisUntilFinished));
            }
        });
        countDown3.start();
        countDown3.setOnFinishListener(new OnFinishListener() {
            @Override
            public void onFinish() {
//                //カウントダウン終了時の処理
//                TimeText1.setText(String.valueOf(0));
                Toast.makeText(getApplicationContext(), "カウント終了" , Toast.LENGTH_SHORT).show();
            }
        });

    }
}


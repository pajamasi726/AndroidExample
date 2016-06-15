package com.example.yeasangkug.bluetoothcheck;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yeasangkug.bluetoothcheck.BlueTooth.BlueToothUtil;

public class MainActivity extends AppCompatActivity {

    private TextView tv_support;
    private TextView tv_state;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_support = (TextView)findViewById(R.id.tv_supportBl);
        tv_state = (TextView)findViewById(R.id.tv_stateBl);

    }

    public void onClick(View v)
    {
        BlueToothUtil blue = new BlueToothUtil(this);

        switch(v.getId())
        {
            case R.id.btn_supprotBl :
                boolean support = blue.getSupportBluetooth();
                tv_support.setText("BlueTooth 지원 여부 : "+support);
            break;

            case R.id.btn_stateBl :
                boolean state = blue.getBluetoothState();
                tv_state.setText("BlueTooth 상태 : "+state);
            break;

            case R.id.btn_onBl :
                blue.setOnBluetooth();
            break;

            case R.id.btn_on :
                blue.setEnableBluetooth();
            break;

            case R.id.btn_off :
                blue.setDisableBluetooth();
            break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch(requestCode)
        {
            case BlueToothUtil.REQUEST_ENABLE_BLUETOOTH :

                if(resultCode == RESULT_OK){
                    Toast.makeText(this, "BlueTooth 활성화 클릭", Toast.LENGTH_SHORT).show();
                }
                else if(resultCode == RESULT_CANCELED){
                    Toast.makeText(this, "BlueTooth 취소 클릭", Toast.LENGTH_SHORT).show();
                }
            break;
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}

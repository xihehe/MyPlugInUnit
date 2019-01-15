package com.pluginunit.fc.mypluginunit;

import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.qihoo360.replugin.RePlugin;
import com.example.fc.newmvpproject.*;

public class MainActivity extends AppCompatActivity {

    ITest asInterface;

    Button btn_use1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_use1 = (Button)findViewById(R.id.btn_use1);


        btn_use1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                useMainMethod();
            }
        });
    }




    private void useMainMethod(){
        //        根据名字获取注册的IBinder
        IBinder globalBinder = RePlugin.getGlobalBinder("host");

        //获取ISp实现类
        asInterface = ITest.Stub.asInterface(globalBinder);

        try {
            //调用方法，获取返回值
            asInterface.Hello();

            //弹出提示
        } catch (RemoteException e) {
            //捕获异常
            e.printStackTrace();
        }
    }
}

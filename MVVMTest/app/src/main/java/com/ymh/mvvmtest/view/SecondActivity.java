package com.ymh.mvvmtest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.ymh.mvvmtest.R;
import com.ymh.mvvmtest.databinding.ActivitySecondBinding;
import com.ymh.mvvmtest.messageEvent.ModelEvent;

import org.greenrobot.eventbus.EventBus;

public class SecondActivity extends AppCompatActivity {
    ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_second);
        binding.setClick(new Click());
    }

    public class Click{
        public void btnsClick(){
            EventBus.getDefault().post(new ModelEvent(1));
        }
    }
}

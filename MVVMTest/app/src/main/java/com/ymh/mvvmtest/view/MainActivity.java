package com.ymh.mvvmtest.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import com.ymh.mvvmtest.messageEvent.ModelEvent;
import com.ymh.mvvmtest.R;
import com.ymh.mvvmtest.viewModel.MainActivityViewModel;
import com.ymh.mvvmtest.databinding.ActivityMainBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;
    ActivityMainBinding binding;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        EventBus.getDefault().register(this);
        binding.setClick(new Click());

        initData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(ModelEvent event) {
        num += event.getNum();
        binding.tvNum.setText(num + "");
    }

    private void initData() {
        viewModel.getFeiGe().observe(this, s -> {
            binding.setModel(s);
        });
    }

    public class Click {
        public void next() {
            startActivity(new Intent(MainActivity.this, SecondActivity.class));
        }
    }
}

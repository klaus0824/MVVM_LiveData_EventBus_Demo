package com.ymh.mvvmtest.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.ymh.mvvmtest.model.Model;

public class MainActivityViewModel extends AndroidViewModel {

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }
    public LiveData<Model> getFeiGe(){
        MutableLiveData<Model> liveData = new MutableLiveData<>();
        Model fei = new Model();
        fei.setName("快点它进下个页面");
        liveData.setValue(fei);
        return liveData;
    }
}

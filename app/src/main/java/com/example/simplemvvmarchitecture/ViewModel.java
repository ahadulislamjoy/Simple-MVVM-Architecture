package com.example.simplemvvmarchitecture;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.Random;

public class ViewModel extends androidx.lifecycle.ViewModel {
    public MutableLiveData<String> myRandomNumber;
    public String TAG = this.getClass().getSimpleName();

    public MutableLiveData<String> getMyRandomNumber() {

        Log.i(TAG, "get my random number");
        if (myRandomNumber == null) {
            myRandomNumber = new MutableLiveData<>();
            createNumber();
        }
        return myRandomNumber;
    }

    public void createNumber() {
        Log.i(TAG, "create random number");
        Random random = new Random();
        myRandomNumber.postValue("my random number is "+random.nextInt(100-1));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG, "destroy random number");
    }
}

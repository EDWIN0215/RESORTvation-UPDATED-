package ucucite.edu.resortvations.ui.Resort;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ResortViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ResortViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Resort fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }


}
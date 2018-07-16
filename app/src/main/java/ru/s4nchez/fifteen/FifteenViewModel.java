package ru.s4nchez.fifteen;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import ru.s4nchez.fifteen.model.Fifteen;

/**
 * Created by S4nchez on 16.07.2018.
 */

public class FifteenViewModel extends BaseObservable {

    private Fifteen mFifteen;

    public FifteenViewModel(Fifteen fifteen) {
        mFifteen = fifteen;
    }

    @Bindable
    public Fifteen getFifteen() {
        return mFifteen;
    }

    public void setFifteen(Fifteen fifteen) {
        mFifteen = fifteen;
        notifyChange();
    }

    public void move(int i, int j) {
        mFifteen.move(i, j);
        notifyChange();
    }
}
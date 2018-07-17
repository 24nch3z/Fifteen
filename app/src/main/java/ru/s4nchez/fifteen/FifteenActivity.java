package ru.s4nchez.fifteen;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.s4nchez.fifteen.databinding.ActivityFifteenBinding;
import ru.s4nchez.fifteen.model.Fifteen;

public class FifteenActivity extends AppCompatActivity {

    private Fifteen mFifteen;
    private FifteenViewModel mViewModel;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityFifteenBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_fifteen);

        mFifteen = Fifteen.get();
        mViewModel = new FifteenViewModel(mFifteen);
        binding.setViewModel(mViewModel);
    }
}

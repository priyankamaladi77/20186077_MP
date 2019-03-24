package com.example.pill_remainder.alarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.pill_remainder.data.Injection;
import com.example.pill_remainder.R;
import com.example.pill_remainder.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RemainderActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    ReminderPresenter mReminderPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder_actvity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        if (!intent.hasExtra(RemainderFragment.EXTRA_ID)) {
            finish();
            return;
        }
        long id = intent.getLongExtra(RemainderFragment.EXTRA_ID, 0);
        RemainderFragment reminderFragment = (RemainderFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (reminderFragment == null) {
            reminderFragment = RemainderFragment.newInstance(id);
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), reminderFragment, R.id.contentFrame);
        }

        //Create MedicinePresenter
        mReminderPresenter = new ReminderPresenter(Injection.provideMedicineRepository(RemainderActivity.this), reminderFragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (mReminderPresenter != null) {
                mReminderPresenter.finishActivity();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (mReminderPresenter != null) {
            mReminderPresenter.finishActivity();
        }
    }
}
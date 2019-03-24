package com.example.pill_remainder.alarm;

import com.example.pill_remainder.views.BasePresenter;
import com.example.pill_remainder.views.BaseView;
import com.example.pill_remainder.data.source.local.History;
import com.example.pill_remainder.data.source.local.MedicineAlarm;


interface ReminderContract {

    interface View extends BaseView<Presenter> {

        void showMedicine(MedicineAlarm medicineAlarm);

        void showNoData();

        boolean isActive();

        void onFinish();

    }

    interface Presenter extends BasePresenter {

        void finishActivity();

        void onStart(long id);

        void loadMedicineById(long id);

        void addPillsToHistory(History history);

    }
}
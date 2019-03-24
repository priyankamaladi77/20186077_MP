package com.example.pill_remainder.medicine;

import android.support.annotation.NonNull;

import com.example.pill_remainder.views.BasePresenter;
import com.example.pill_remainder.views.BaseView;
import com.example.pill_remainder.data.source.local.MedicineAlarm;

import java.util.Date;
import java.util.List;


public interface MedicineContract {

    interface View extends BaseView<Presenter>{

        void showLoadingIndicator(boolean active);

        void showMedicineList(List<MedicineAlarm> medicineAlarmList);

        void showAddMedicine();

        void showMedicineDetails(long medId, String medName);

        void showLoadingMedicineError();

        void showNoMedicine();

        void showSuccessfullySavedMessage();

        boolean isActive();


    }

    interface Presenter extends BasePresenter{

        void onStart(int day);

        void reload(int day);

        void result(int requestCode, int resultCode);

        void loadMedicinesByDay(int day, boolean showIndicator);


        void addNewMedicine();

    }
}


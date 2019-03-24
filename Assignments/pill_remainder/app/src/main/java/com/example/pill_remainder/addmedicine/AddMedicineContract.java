package com.example.pill_remainder.addmedicine;

import com.example.pill_remainder.views.BasePresenter;
import com.example.pill_remainder.views.BaseView;
import com.example.pill_remainder.data.source.local.MedicineAlarm;
import com.example.pill_remainder.data.source.local.Pills;

import java.util.List;


public interface AddMedicineContract {

    interface View extends BaseView<Presenter> {

        void showEmptyMedicineError();

        void showMedicineList();

        boolean isActive();

    }

    interface  Presenter extends BasePresenter{


        void saveMedicine(MedicineAlarm alarm, Pills pills);


        boolean isDataMissing();

        boolean isMedicineExits(String pillName);

        long addPills(Pills pills);

        Pills getPillsByName(String pillName);

        List<MedicineAlarm> getMedicineByPillName(String pillName);

        List<Long> tempIds();

        void deleteMedicineAlarm(long alarmId);

    }
}


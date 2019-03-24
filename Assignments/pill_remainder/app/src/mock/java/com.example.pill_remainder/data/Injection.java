package com.example.pill_remainder.data;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.pill_remainder.data.source.local.MedicineRepository;
import com.example.pill_remainder.data.source.local.MedicinesLocalDataSource;

public class Injection {

    public static MedicineRepository provideMedicineRepository(@NonNull Context context) {
        return MedicineRepository.getInstance(MedicinesLocalDataSource.getInstance(context));
    }
}

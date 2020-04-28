package com.example.basereceiver;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityController {
    public static List<Activity> activityList = new ArrayList<>();

    public static void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public static void removeActivity(Activity activity) {
        activityList.remove(activity);
    }

    public static void finishAll() {
        for (Activity a : activityList) {
            if (!a.isFinishing()) {
                a.finish();
            }
        }
        activityList.clear();
    }
}

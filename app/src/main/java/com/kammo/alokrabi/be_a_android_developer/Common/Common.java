package com.kammo.alokrabi.be_a_android_developer.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Kamala on 11/29/2017.
 */

public class Common {

    public static final String STR_PUSH = "pushNotification";
    public static boolean isConnectedToInternet(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    public static final String[] YOUTUBE_PLAYLISTS = {
            //"PLAwxTw4SYaPnMwH5-FNkErnnq_aSy706S",
            "PLshdtb5UWjSrOJfpFOE-u55s3SnY2EO9v",
            "PLshdtb5UWjSoyfVybSD_sLVbT1w_CV2e5",
            "PLshdtb5UWjSqUQr8WdpDGCFyM-Da70ycx",
            "PLshdtb5UWjSpfB8v5FwmN2wf4D5zvg8yK",
            "PLshdtb5UWjSpuY32NbRcCQaW7pnkvtiR2",
            "PLshdtb5UWjSqEIBOKwb6-bgE4wD2yEVK-",
            "PLshdtb5UWjSpc5PSqX0EYop_WjYgY7Y5C",
            "UUVHFbqXqoYvEWM1Ddxl0QDg",


    };

}
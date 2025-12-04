package com.spkt.app_student_attendance.Retrofit;

import com.spkt.app_student_attendance.model.IPConfigModel;

public class APIUtils {
    public static String Base_Ur = "";
    private static IPConfigModel ipConfigModel = new IPConfigModel();
    public static DataClient getData(){
        Base_Ur = "http://" + ipConfigModel.getIpconfig() + "/student_attendence/";
        return RetrofitClient.getClient(Base_Ur).create(DataClient.class);
    }
}

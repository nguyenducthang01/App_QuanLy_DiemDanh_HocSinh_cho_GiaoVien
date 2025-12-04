package com.example.myapplication.model;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.LoginActivity;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPConfigModel {
//    private String ipconfig;
//    private String ipconfig = "192.168.127.234"; // Your IP
    private  String ipconfig = GetIPv4.getIpv4();
    public  IPConfigModel () {}
    public String getIpconfig() {
        Log.d(ipconfig,"ip_Config "+ipconfig);
        GetIPv4.getAllIPAddresses();
        return ipconfig;
    }
}

//package com.example.myapplication.model;
//
//import android.content.Context;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.net.wifi.WifiManager;
//import android.text.format.Formatter;
//import android.util.Log;
//
//import java.net.NetworkInterface;
//import java.util.Collections;
//import java.util.List;
//
//public class IPConfigModel {
//    private static final String TAG = "IPConfigModel";
//    private String ipconfig;
//
//    public IPConfigModel() {}
//    public IPConfigModel(Context context) {
//        this.ipconfig = getLocalIpAddress(context);
//    }
//
//    private String getLocalIpAddress(Context context) {
//        try {
//            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
//
//            if (activeNetwork != null && activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
//                WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
//                return Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
//            } else {
//                List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
//                for (NetworkInterface intf : interfaces) {
//                    List<java.net.InetAddress> addrs = Collections.list(intf.getInetAddresses());
//                    for (java.net.InetAddress addr : addrs) {
//                        if (!addr.isLoopbackAddress() && addr.getHostAddress().indexOf(':') == -1) {
//                            return addr.getHostAddress();
//                        }
//                    }
//                }
//            }
//        } catch (Exception e) {
//            Log.e(TAG, "Không thể lấy địa chỉ IP", e);
//        }
//        return "127.0.0.1"; // Giá trị mặc định nếu có lỗi
//    }
//
//    public String getIpconfig() {
//        Log.d(TAG, "Địa chỉ IP: " + ipconfig);
//        return ipconfig;
//    }
//}
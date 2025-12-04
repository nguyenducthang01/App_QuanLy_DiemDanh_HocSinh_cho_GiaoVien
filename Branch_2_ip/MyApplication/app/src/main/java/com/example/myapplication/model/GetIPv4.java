package com.example.myapplication.model;

import android.util.Log;

import java.net.*;
import java.util.Enumeration;

public class GetIPv4 {
    public static void main(String[] args) {}
    public static String getIpv4(){
        String ipconfig = "";
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();

                // Bỏ qua card mạng ảo, loopback
                if (networkInterface.isLoopback() || !networkInterface.isUp() || networkInterface.isVirtual()) {
                    continue;
                }

                // Chuyển tên card mạng thành chữ thường để kiểm tra
                String networkName = networkInterface.getDisplayName().toLowerCase();

                // Chỉ lấy các card mạng chính như Wi-Fi và Ethernet
                if (networkName.contains("wlan") || networkName.contains("wifi") || networkName.contains("eth")) {
                    Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddress = inetAddresses.nextElement();

                        // Chỉ lấy IPv4, không lấy IPv6 hoặc localhost
//                        if (inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress()) {
                        if (inetAddress instanceof Inet4Address) {
                            System.out.println("Card mạng: " + networkInterface.getDisplayName() +
                                    " | Địa chỉ: " + inetAddress.getHostAddress());
//                            Log.d(ipconfig,"ip_Config "+ipconfig);
                            return inetAddress.getHostAddress();
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static void getAllIPAddresses() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();

                // Kiểm tra nếu card mạng hoạt động
                if (!networkInterface.isUp() || networkInterface.isLoopback() || networkInterface.isVirtual()) {
                    continue;
                }

                System.out.println("Card mạng: " + networkInterface.getDisplayName());

                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = inetAddresses.nextElement();
                    System.out.println("  Địa chỉ: " + inetAddress.getHostAddress());
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}

//import android.content.Context;
//import android.net.wifi.WifiManager;
//import android.text.format.Formatter;
//
//import java.net.Inet4Address;
//import java.net.InetAddress;
//import java.net.NetworkInterface;
//import java.util.Enumeration;
//
//public class GetIPv4 {
//    // Method using WifiManager (recommended for Android Wi-Fi)
//    public static String getIpAddress(Context context) {
//        try {
//            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
//            int ipAddress = wifiManager.getConnectionInfo().getIpAddress();
//
//            // Format the IP address from int to String
//            return Formatter.formatIpAddress(ipAddress);
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Fallback to the network interface method if Wi-Fi method fails
//            return getIpFromNetworkInterface();
//        }
//    }
//
//    // Alternative method using NetworkInterface
//    public static String getIpFromNetworkInterface() {
//        String ipAddress = "";
//        try {
//            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
//            while (networkInterfaces.hasMoreElements()) {
//                NetworkInterface networkInterface = networkInterfaces.nextElement();
//
//                // Skip loopback, virtual, and inactive interfaces
//                if (networkInterface.isLoopback() || !networkInterface.isUp() || networkInterface.isVirtual()) {
//                    continue;
//                }
//
//                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
//                while (inetAddresses.hasMoreElements()) {
//                    InetAddress inetAddress = inetAddresses.nextElement();
//                    if (inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress()) {
//                        ipAddress = inetAddress.getHostAddress();
//                        // Return immediately when we find a valid IP
//                        return ipAddress;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ipAddress;
//    }
//
////    public static void main(String[] args) {}
//}
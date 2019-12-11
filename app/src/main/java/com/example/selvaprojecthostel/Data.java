package com.example.selvaprojecthostel;

public class Data {
    public String reason;
    public String time;
    public String date;
    public Data(){}
    public String getReason(){
            return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTime() {
        return time;
    }


    public void setTime(String time) {
        this.time = time;
    }

    public Data(String reason, String time) {
        this.reason = reason;
        this.time = time;
    }

    public String getDate() {
   return date;
    }


}

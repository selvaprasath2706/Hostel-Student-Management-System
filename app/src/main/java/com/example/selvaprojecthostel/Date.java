package com.example.selvaprojecthostel;

public class Date {
        public String name;
        public String reason;
        public String time;
        public String account;
    public Date(){}
        public  String getReason() {
            return reason;
        }
        public  String getTime() {
            return time;
        }
        public String getAcc(){ return account;}
        public  String getName() {
            return name;
        }
    public void setReason(String reason) {
        this.reason = reason;
    }
    public void setTime(String time) {
        this.time = time;
    }
}

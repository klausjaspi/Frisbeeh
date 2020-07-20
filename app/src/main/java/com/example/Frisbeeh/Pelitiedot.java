package com.example.Frisbeeh;

public class Pelitiedot {
    public String coursename, date, userscore;



    public void setCoursename(String coursename){
        this.coursename = coursename;
    }

    public void setDate(String date){
        this.date = date;
    }
    public void setUserscore(String userscore){
        this.userscore = userscore;
    }

    public String getCoursename() {
        return coursename;
    }

    public String getDate() {
        return date;
    }

    public String getUserscore() {
        return userscore;
    }

    public Pelitiedot(String coursename, String date, String userscore){
        this.coursename = coursename;
        this.date = date;
        this.userscore = userscore;
    }
    public Pelitiedot(){

    }
}

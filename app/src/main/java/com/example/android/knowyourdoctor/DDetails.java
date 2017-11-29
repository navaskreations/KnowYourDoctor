package com.example.android.knowyourdoctor;

import android.provider.ContactsContract;

/**
 * Created by navas on 8/17/2017.
 */

public class DDetails {

    private String dName;
    private String dGender;
    private  String dExperience;
    private String dQualification;
    private String dPhone;
    private String dSpeciality;
    private int dImgResourceId;



    public DDetails(String name, String gender, String exp, String quali, String phone, String speciality, int imgResourceid){
        dName = name;
        dGender = gender;
        dExperience = exp;
        dQualification = quali;
        dPhone = phone;
        dSpeciality = speciality;
        dImgResourceId = imgResourceid;
    }


    public String getDName(){
        return dName;
    }


    public String getdGender(){

        String displayString = "Gender : ";
        displayString = displayString + dGender;
        return displayString;
    }
    public String getdExperience(){

        String displayString = "Experience : ";
        displayString = displayString + dExperience;
        return displayString;
    }

    public String getdQualification(){

        String displayString = "Qualification : ";
        displayString = displayString + dQualification;
        return displayString;
    }

    public String getDSpeciality(){

        //String displayString = "Speciality : ";
        //displayString = displayString + dSpeciality;
        return dSpeciality;
    }

    public String getdPhone(){

        String displayString = "Phone : ";
        displayString = displayString + dPhone;
        return displayString;
    }

    public int getdImgResourceId(){

        return dImgResourceId;
    }
}

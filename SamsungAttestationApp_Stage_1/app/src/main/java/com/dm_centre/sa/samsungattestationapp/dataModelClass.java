package com.dm_centre.sa.samsungattestationapp;

/**
 * Created by Berlin on 23.08.15.
 */
public class dataModelClass {

    private String _name;
    private String _comment;

    public dataModelClass(){}


    public dataModelClass(String name, String comment){
        this._name = name;
        this._comment = comment;
    }



    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }


    // getting name
    public String getComment(){
        return this._comment;
    }

    // setting name
    public void setComment(String comment){
        this._comment = comment;
    }

}

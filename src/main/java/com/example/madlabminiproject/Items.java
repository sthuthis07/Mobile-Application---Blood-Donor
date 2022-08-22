package com.example.madlabminiproject;

public class Items {
    private String name,contact,bloodgroup;
    public Items(String name,String contact,String bloodgroup)
    {
        this.contact=contact;
        this.bloodgroup=bloodgroup;
        this.name=name;
    }

    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBloodgroup() {
        return bloodgroup;
    }
    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }
}

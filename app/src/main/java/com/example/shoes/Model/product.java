package com.example.shoes.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class product implements Parcelable {
    public int id;
    public String Pname,Pbrand;
    public int Pimage;
    public double Pprice;

    public product(String pname, String pbrand, int pimage, double pprice) {
        Pname = pname;
        Pbrand = pbrand;
        Pimage = pimage;
        Pprice = pprice;
    }

    protected product(Parcel in) {
        id = in.readInt();
        Pname = in.readString();
        Pbrand = in.readString();
        Pimage = in.readInt();
        Pprice = in.readDouble();
    }

    public static final Creator<product> CREATOR = new Creator<product>() {
        @Override
        public product createFromParcel(Parcel in) {
            return new product(in);
        }

        @Override
        public product[] newArray(int size) {
            return new product[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getPbrand() {
        return Pbrand;
    }

    public void setPbrand(String pbrand) {
        Pbrand = pbrand;
    }

    public int getPimage() {
        return Pimage;
    }

    public void setPimage(int pimage) {
        Pimage = pimage;
    }

    public double getPprice() {
        return Pprice;
    }

    public void setPprice(double pprice) {
        Pprice = pprice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(Pname);
        parcel.writeString(Pbrand);
        parcel.writeInt(Pimage);
        parcel.writeDouble(Pprice);
    }
}

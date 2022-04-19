package com.example.shoes.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Item implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    public String Iname,Ibrand;
    public int Iimage;
    public double Iprice;
    public int Iquantity;
    public double ItotalPrice;

    public Item(String iname, String ibrand, int iimage,
                double iprice, int iquantity, double itotalPrice) {
        Iname = iname;
        Ibrand = ibrand;
        Iimage = iimage;
        Iprice = iprice;
        Iquantity = iquantity;
        ItotalPrice = itotalPrice;
    }

    public Item() {

    }

    protected Item(Parcel in) {
        uid = in.readInt();
        Iname = in.readString();
        Ibrand = in.readString();
        Iimage = in.readInt();
        Iprice = in.readDouble();
        Iquantity = in.readInt();
        ItotalPrice = in.readDouble();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public double getIprice() {
        return Iprice;
    }

    public void setIprice(double iprice) {
        Iprice = iprice;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getIname() {
        return Iname;
    }

    public void setIname(String iname) {
        Iname = iname;
    }

    public String getIbrand() {
        return Ibrand;
    }

    public void setIbrand(String ibrand) {
        Ibrand = ibrand;
    }

    public int getIimage() {
        return Iimage;
    }

    public void setIimage(int iimage) {
        Iimage = iimage;
    }

    public int getIquantity() {
        return Iquantity;
    }

    public void setIquantity(int iquantity) {
        Iquantity = iquantity;
    }

    public double getItotalPrice() {
        return ItotalPrice;
    }

    public void setItotalPrice(double itotalPrice) {
        ItotalPrice = itotalPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(uid);
        parcel.writeString(Iname);
        parcel.writeString(Ibrand);
        parcel.writeInt(Iimage);
        parcel.writeDouble(Iprice);
        parcel.writeInt(Iquantity);
        parcel.writeDouble(ItotalPrice);
    }
}

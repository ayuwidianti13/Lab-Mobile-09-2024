package com.example.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Instagram implements Parcelable {

    private String nama, followers,caption;
    private Integer imageprofile, imagefeed, imagestory,  following;

    public Instagram(String nama, String caption, Integer imageprofile, Integer imagefeed, Integer imagestory,String followers,  Integer following) {
        this.nama = nama;
        this.caption = caption;
        this.imageprofile = imageprofile;
        this.imagefeed = imagefeed;
        this.imagestory = imagestory;
        this.followers = followers;
        this.following = following;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Integer getImageprofile() {
        return imageprofile;
    }

    public void setImageprofile(Integer imageprofile) {
        this.imageprofile = imageprofile;
    }

    public Integer getImagefeed() {
        return imagefeed;
    }

    public void setImagefeed(Integer imagefeed) {
        this.imagefeed = imagefeed;
    }

    public Integer getImagestory() {
        return imagestory;
    }

    public void setImagestory(Integer imagestory) {
        this.imagestory = imagestory;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public Integer getFollowing() {
        return following;
    }

    public void setFollowing(Integer following) {
        this.following = following;
    }

    protected Instagram(Parcel in) {
        nama = in.readString();
        caption = in.readString();
        followers = in.readString();
        if (in.readByte() == 0) {
            imageprofile = null;
        } else {
            imageprofile = in.readInt();
        }
        if (in.readByte() == 0) {
            imagefeed = null;
        } else {
            imagefeed = in.readInt();
        }
        if (in.readByte() == 0) {
            imagestory = null;
        } else {
            imagestory = in.readInt();
        }
        if (in.readByte() == 0) {
            following = null;
        } else {
            following = in.readInt();
        }
    }

    public static final Creator<Instagram> CREATOR = new Creator<Instagram>() {
        @Override
        public Instagram createFromParcel(Parcel in) {
            return new Instagram(in);
        }

        @Override
        public Instagram[] newArray(int size) {
            return new Instagram[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(caption);
        dest.writeString(followers);
        if (imageprofile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imageprofile);
        }
        if (imagefeed == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imagefeed);
        }
        if (imagestory == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imagestory);
        }
        if (following == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(following);
        }
    }
}

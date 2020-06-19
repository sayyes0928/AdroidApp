package com.example.myapplication001;

public class UserDTO {

    String title;
    int profileImg;

    public UserDTO(int profileImg, String title){
        this.profileImg = profileImg;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }
}

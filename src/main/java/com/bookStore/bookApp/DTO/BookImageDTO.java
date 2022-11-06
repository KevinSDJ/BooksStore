package com.bookStore.bookApp.DTO;

import java.io.Serializable;


public class BookImageDTO implements  Serializable {
    
    private String nameFile;
    private String type;
    private String data;
    public String getNameFile() {
        return nameFile;
    }
    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return "coverFrontDTO [nameFile=" + nameFile + ", type=" + type + ", data=" + data + "]";
    }


}

package com.org.materialdesign;

public class Stores {
    //declaring private member variables
    private final int storeImage;
    private String storeTitle;
    private String storeDescription;

    Stores(int storeImage, String storeTitle, String storeDescription){
        this.storeImage=storeImage;
        this.storeTitle=storeTitle;
        this.storeDescription=storeDescription;
    }


    public int getStoreImage() {
        return storeImage;
    }

    public String getStoreTitle() {
        return storeTitle;
    }

    public String getStoreDescription() {
        return storeDescription;
    }
}

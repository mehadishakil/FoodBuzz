package com.miui.foodbuzz.dataUpload;

public class dataUploadClass {

    String title, price, description, dbTable, image;

    public dataUploadClass(String title, String price, String description, String dbTable, String image) {
        this.title = title;
        this.price = price;
        this.description = description;
        this.dbTable = dbTable;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDbTable() {
        return dbTable;
    }

    public void setDbTable(String dbTable) {
        this.dbTable = dbTable;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}

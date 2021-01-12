package com.example.appoctect;

public class Items {

    private int imageResource;
    private String title;
    private String quantinkg;
    private String kg;
    private String rupee;
    private String amount;
    private String rupee1;
    private String amount1;
    private String quantity;




    public Items(int imageResource, String title, String quantinkg, String kg, String rupee, String amount, String rupee1, String amount1,String quantity) {
        this.imageResource = imageResource;
        this.title = title;
        this.quantinkg = quantinkg;
        this.kg = kg;
        this.rupee = rupee;
        this.amount = amount;
        this.rupee1 = rupee1;
        this.amount1 = amount1;
        this.quantity = quantity;

    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getQuantinkg() {
        return quantinkg;
    }

    public String getKg() {
        return kg;
    }

    public String getRupee() {
        return rupee;
    }

    public String getAmount() {
        return amount;
    }

    public String getRupee1() {
        return rupee1;
    }

    public String getAmount1() {
        return amount1;
    }

    public String getQuantity() {
        return quantity;
    }
}

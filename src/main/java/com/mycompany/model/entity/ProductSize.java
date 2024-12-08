package com.mycompany.model.entity;
public class ProductSize {     
    private int exempleId;              
    private int size;    
    private int stockQuantity;          

 
    public ProductSize( int exempleId,  int size, int stockQuantity) {

        this.exempleId = exempleId;
        this.size = size;
        this.stockQuantity = stockQuantity;
    }


    public ProductSize() {}

    @Override
    public String toString() {
        return "" + size + "";
    }




    public int getExempleId() {
        return exempleId;
    }

    public void setExempleId(int exempleId) {
        this.exempleId = exempleId;
    }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

  
}

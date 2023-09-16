/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class VaccineType {
    String typeID;
    String typeName;
    String productCom;
    int restPeriod;

    public VaccineType() {
    }
    
    public VaccineType(String typeID, String typeName, String productCom, int restPeriod) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.productCom = productCom;
        this.restPeriod = restPeriod;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getProductCom() {
        return productCom;
    }

    public void setProductCom(String productCom) {
        this.productCom = productCom;
    }

    public int getRestPeriod() {
        return restPeriod;
    }

    public void setRestPeriod(int restPeriod) {
        this.restPeriod = restPeriod;
    }
    
    
}

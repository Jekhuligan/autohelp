package com.autohelp.model;

import javax.persistence.*;

/**
 * Created by jek on 10.01.16.
 */

@Entity
@Table(name="Price")
public class PriceModel
{
    public PriceModel()
    {

    }
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String service;
    private int price;
    private String brand;
    private String model;


    public long getId()
    {
        return id;
    }
    public void setId(long id)
    {
        this.id = id;
    }

    public void setService(String service)
    {
        this.service = service;
    }

    public String getService()
    {
        return service;
    }

    public void setPrice(int price)
    {
        this.price = price;
    }

    public int getPrice()
    {
        return price;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }
}

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
    private String pricevaz;
    private String priceino;

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


    public String getPricevaz()
    {
        return pricevaz;
    }

    public void setPricevaz(String pricevaz)
    {
        this.pricevaz = pricevaz;
    }

    public String getPriceino()
    {
        return priceino;
    }

    public void setPriceino(String priceino)
    {
        this.priceino = priceino;
    }
}

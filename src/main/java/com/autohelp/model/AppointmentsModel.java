package com.autohelp.model;





import javax.persistence.*;

/**
 * Created by jek on 26.12.15.
 */
@Entity
@Table(name="Appointments")
public class AppointmentsModel
{
    public AppointmentsModel()
    {

    }
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String auto;
    private String description;
    private String phone;
    private String date;
    private String time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuto()
    {
        return auto;
    }
    public void setAuto(String auto)
    {
        this.auto = auto;
    }

    public String getDescription()
    {
        return description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getDate()
    {
        return date;
    }
    public void setDate(String date)
    {
        this.date = date;
    }

    public String getTime()
    {
        return time;
    }
    public void setTime(String time)
    {
        this.time = time;
    }

}

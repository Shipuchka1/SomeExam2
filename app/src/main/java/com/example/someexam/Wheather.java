package com.example.someexam;

public class Wheather {
    public String description;
    public double temp;
    public double pressure;
    public double huminity;
    public double speed;
    public double deg;
    public  String name;

    public  String getDescription()
    {
        return description;
    }

    public  double getTemp()
    {
        return temp;
    }

    public  double getPressure()
    {
        return pressure;
    }

    public  double getHuminity()
    {
        return huminity;
    }

    public  double getSpeed()
    {
        return speed;
    }

    public  double getDeg()
    {
        return deg;
    }

    public String getName()
    {
        return name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setTemp(double temp)
    {
        this.temp = temp;
    }

    public void setPressure(double pressure)
    {
        this.pressure = pressure;
    }

    public void setHuminity(double huminity)
    {
        this.huminity = huminity;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDeg(double deg)
    {
        this.deg = deg;
    }

    public void setName(String  name)
    {
        this.name = name;
    }
}

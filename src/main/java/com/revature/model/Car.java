package com.revature.model;
import java.io.Serializable;
import java.util.Objects;
public class Car implements Serializable{

    private int id;
    private String name;
    private String type;
    private String make;
    private String color;

    private int price;

   // private Topic topic;

    public Car() {
        this.id = id;
        this.name = name;
        this.type = type;
        this.make = make;
        this.color = color;
        this.price = price;
    }

    public int getId(){

        return id;
    }

    public Car setId(int id){
        this.id = id;
        return this;
    }

    public String getName(){
        return name;
    }

    public Car setName(String name){
        this.name = name;
        return this;

    }

    public String getType(){
        return type;
    }

    public Car setType(String type){
        this.type = type;
        return this;
    }

    public String getMake(){
        return make;
    }

    public Car setMake(String make){
        this.make = make;
        return this;
    }

    public String getColor(){
        return color;
    }

    public Car setColor(String color){
        this.color = color;
        return this;
    }

    public int getPrice(){

        return price;
    }

    public Car setPrice(int price){
        this.price = price;
        return this;
    }

    /*public Topic getTopic() {
        return topic;
    }

    public Car setTopic(Topic topic) {
        this.topic = topic;
        return this;
    } */



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && Objects.equals(name, car.name) && Objects.equals(type, car.type) && Objects.equals(make, car.make) && Objects.equals(color, car.color) && Objects.equals(price, car.price);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, make, color, price);
    }

    @Override
    public String toString(){
            return "Car{" +
                    "id=" + id +
                    "Name = " + name +
                    ", Type = " + type + '\'' +
                    ", Make = " + make + '\'' +
                    ", Color = " + color +
                    ", Price = " + price +
                    "}";
        }


    }


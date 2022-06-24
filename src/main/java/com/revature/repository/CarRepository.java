package com.revature.repository;

import com.revature.model.Car;
import com.revature.model.Topic;
import com.revature.util.ConnectionUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements DAO<Car> {
    private List<Car> cars;

    public CarRepository(){cars = new ArrayList<>();}

    public CarRepository(List<Car> cars){this.cars = cars;}

    @Override
    public Car create(Car car){
        if(cars.add(car)){
            return car;
        } else {
            return null;
        }
    }




    @Override
    public List<Car> getAll(){

        List<Car> cars = new ArrayList<>();

        String sql = "select * from cars";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet results = stmt.executeQuery();

            while(results.next()) {
                cars.add(new Car()
                        .setId(results.getInt("id"))
                        .setName(results.getString("name"))
                        .setType(results.getString("type"))
                        .setMake(results.getString("make"))
                        .setColor(results.getString("color"))
                                .setPrice(results.getInt("price"))
                        );

            }
            } catch(SQLException e){
                e.printStackTrace();

        }

        return cars;}

    @Override
    public Car getById(int id){
        for (int i = 0; i <cars.size(); i++){
            if (cars.get(i).getId() == id){
                return cars.get(i);
            }
        }
        return null;
    }


   /* public List<Car> getAllByTopic(Topic topic){
        List<Car> filteredCars = new ArrayList<>();

        for(Car car: cars){
            if(car.getTopic().equals(topic)){
                filteredCars.add(car);
            }
        }
        return filteredCars;
    } */
    @Override
    public Car update(Car car){return null;}

    @Override
    public boolean deleteById(int id){return false;}


}

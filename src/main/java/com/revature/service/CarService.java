package com.revature.service;


import com.revature.model.Car;
import com.revature.model.Topic;
import com.revature.model.User;
import com.revature.repository.CarRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CarService {

    private CarRepository carRepository;

    public CarService(){
        carRepository = new CarRepository();
    }

    public CarService(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    public Car createNewCar(Car car){
        return carRepository.create(car);
    }

    public List<Car> getAllCars(){
        return carRepository.getAll();
    }

    public Car createCar(Car car){
        return carRepository.create(car);
    }

    public Car updateCar(Car car){
        return carRepository.update(car);
    }

    /*public List<Car> getAllCarsByTopic(Topic topic){
        return carRepository.getAllByTopic(topic);
    }*/

    public Car getCarById(int id) {
        return carRepository.getById(id);
    }

    public int something(){
        return 0;
    }

    public void printSomething(){
        System.out.println(something());
    }
}

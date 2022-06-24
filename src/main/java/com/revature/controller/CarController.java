package com.revature.controller;

import com.revature.Driver;
import com.revature.model.Car;
import com.revature.model.Topic;
import com.revature.model.User;
import com.revature.service.CarService;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


public class CarController {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    CarService carService = new CarService();

    public Handler getAllCars = context -> {
        // get our list of flashcards
        List<Car> cars = new ArrayList<>();
        // check to see if there are any arguments, if so, filter by those arguments and return the result
        // if not, return all flashcards
        String topicParam = context.queryParam("topic"); // this could be null


        // if topic is null, get all flashcards
        if(topicParam == null){
            cars = carService.getAllCars();
        }
        // if topic is not null, get all flashcards by topic
        else {
            try{
               /* Topic topic = Topic.valueOf(topicParam.toUpperCase(Locale.ROOT));
                cars = carService.getAllCarsByTopic(topic);*/
            }catch(IllegalArgumentException e){

                String failureMessage = "{\"success\":false, \"message\":\"" +
                        "Please only use the following topic values: " + Arrays.toString(Topic.values())
                        + "\"}";

                context.status(400).json(failureMessage);
                return;
            }
        }
        context.json(cars);
    };

    public Handler updateCar = context -> {
        Car car = context.bodyAsClass(Car.class);
        car = carService.updateCar(car);

        if(car != null){
            context.status(200).json(car);
        } else{
            context.status(400).result("Could not update the car");
        }
    };

    // intended to receive an id in the request
    public Handler getCarById = context -> {
        // how do I pass more information when asking for information
        String param = context.pathParam("id");
        int id = 0;
        try{
            id = Integer.parseInt(param);
            Car car = carService.getCarById(id);

            if(car != null){
                context.json(car);
            } else {
                context.result("Flashcard not found").status(404);
            }

        } catch (NumberFormatException e){
            // i would log it
            context.result("Stop giving me words as IDS");
            context.status(HttpStatus.BAD_REQUEST_400);
        } catch(NullPointerException e){
            logger.warn(e.getMessage());
        }
        // TODO: add a null check on the getFlashcardById
    };

    public Handler setCar = ctx -> {
        Car car = ctx.bodyAsClass(Car.class);
        carService.createNewCar(car);
    };

}

package com.revature;

import com.revature.controller.AuthController;
import com.revature.controller.CarController;
import com.revature.controller.UserController;

import com.revature.model.Role;
import com.revature.model.User;
import com.revature.util.ConnectionUtility;
import io.javalin.Javalin;
import io.javalin.http.HandlerType;
import org.eclipse.jetty.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Driver {

    static Logger logger = LoggerFactory.getLogger(Driver.class);

    public static void main(String []args){

        logger.error("This is an error");

        CarController carController = new CarController();
        UserController userController = new UserController();

        Javalin app = Javalin.create().start(8080);
        app.get("/", context -> context.result("Welcome to the CarShopAPI"));


        app.get("/cars", carController.getAllCars);
        app.get("/cars/{id}", carController.getCarById);
        app.post("/cars", carController.setCar);
        app.put("/cars", carController.updateCar);

        app.get("/users", userController.getAllUsers);
        app.get("/users/{id}", userController.getUserById);
        app.post("/users", userController.createNewUser);
        app.put("/users", userController.updateUser);
        app.delete("/users/{id}", userController.deleteUserById);

        app.post("/authenticate", AuthController.authenticate);
        app.post("/register", userController.createNewUser);

       /* app.before("/users*", AuthController.withAuth);
        app.before("/users*", AuthController.test);
        app.before("/flashcards*", AuthController.withAuth);  */
    }
}

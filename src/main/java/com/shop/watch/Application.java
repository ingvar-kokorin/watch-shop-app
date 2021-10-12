package com.shop.watch;

import com.shop.watch.controller.Controller;
import com.shop.watch.model.Model;
import com.shop.watch.view.View;

/**
 * Watch shop application
 */
public class Application {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.run();
    }
}

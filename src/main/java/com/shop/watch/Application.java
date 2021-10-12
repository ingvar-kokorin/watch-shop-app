package com.shop.watch;

import com.shop.watch.controller.Controller;
import com.shop.watch.model.Model;
import com.shop.watch.view.InputReader;
import com.shop.watch.view.OutputWriter;
import com.shop.watch.view.View;

/**
 * Watch shop application
 */
public class Application {
    public static void main(String[] args) {
        Model model = new Model();
        InputReader inputReader = new InputReader();
        OutputWriter outputWriter = new OutputWriter();
        View view = new View(inputReader, outputWriter);
        Controller controller = new Controller(model, view);
        controller.run();
    }
}

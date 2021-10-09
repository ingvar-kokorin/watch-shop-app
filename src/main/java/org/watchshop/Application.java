package org.watchshop;

import org.watchshop.controller.Controller;
import org.watchshop.model.Model;
import org.watchshop.view.*;

/**
 * Watch shop app!
 */
public class Application {
    public static void main(String[] args) {
        Model model = new Model();
        ViewInputReader viewInputReader = new ConsoleInputReader();
        ViewOutputWriter viewOutputWriter = new ConsoleOutputWriter();
        View view = new View(viewInputReader, viewOutputWriter);
        Controller controller = new Controller(model, view);
        controller.run();
    }
}

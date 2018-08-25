package Controllers;

import db.DBHelper;
import db.Seeds;
import models.Customer;
import models.Farm;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class MainController {

    public static void main(String[] args) {
        Seeds.seedData();


        FarmController farmController = new FarmController();
        CustomersController customersController = new CustomersController();
        ProductsController productsController = new ProductsController();
        ShopController shopController = new ShopController();


        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Farm> farms = DBHelper.getAll(Farm.class);
            model.put("farms", farms);

            List<Customer> customers = DBHelper.getAll(Customer.class);
            model.put("customers", customers);

            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

    }
}

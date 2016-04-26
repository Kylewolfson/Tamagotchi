
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/mypet", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String inputtedName = request.queryParams("name");

      Tamagotchi myPet = request.session().attribute("myPet");
      if(myPet == null) {
        myPet = new Tamagotchi(inputtedName);
        request.session().attribute("myPet", myPet);
      }
      model.put("name", myPet.getName());

      model.put("template", "templates/mypet.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}


import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

public class App {
  public static void main(String[] args) {
    Timer timer = new Timer();
    timer.schedule(new TamagotchiTime(), 0, 5000);

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
      myPet = new Tamagotchi(inputtedName);
      request.session().attribute("myPet", myPet);
      model.put("name", myPet.getName());
      model.put("food", myPet.getFoodLevel());
      model.put("sleep", myPet.getSleepLevel());
      model.put("activity", myPet.getActivityLevel());

      model.put("template", "templates/mypet.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/timepasses", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      Tamagotchi myPet = request.session().attribute("myPet");
      myPet.timePasses();
      model.put("name", myPet.getName());
      model.put("food", myPet.getFoodLevel());
      model.put("sleep", myPet.getSleepLevel());
      model.put("activity", myPet.getActivityLevel());
      model.put("isAlive", myPet.isAlive());

      model.put("template", "templates/mypet.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/feed", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      Tamagotchi myPet = request.session().attribute("myPet");
      myPet.feed();
      model.put("name", myPet.getName());
      model.put("food", myPet.getFoodLevel());
      model.put("sleep", myPet.getSleepLevel());
      model.put("activity", myPet.getActivityLevel());
      model.put("isAlive", myPet.isAlive());

      model.put("template", "templates/mypet.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/sleep", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      Tamagotchi myPet = request.session().attribute("myPet");
      myPet.sleep();
      model.put("name", myPet.getName());
      model.put("food", myPet.getFoodLevel());
      model.put("sleep", myPet.getSleepLevel());
      model.put("activity", myPet.getActivityLevel());
      model.put("isAlive", myPet.isAlive());

      model.put("template", "templates/mypet.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/exercise", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      Tamagotchi myPet = request.session().attribute("myPet");
      myPet.exercise();
      model.put("name", myPet.getName());
      model.put("food", myPet.getFoodLevel());
      model.put("sleep", myPet.getSleepLevel());
      model.put("activity", myPet.getActivityLevel());
      model.put("isAlive", myPet.isAlive());

      model.put("template", "templates/mypet.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }
}

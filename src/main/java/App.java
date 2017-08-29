import dao.Sql2oTrailDao;
import dao.Sql2oUserDao;
import dao.Sql2oReviewDao;
import models.Trail;
import models.User;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import javax.jws.WebParam;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFileLocation;

/**
 * Created by Guest on 8/24/17.
 */
public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/971trail.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'"; //Temporary name of db is 971Trail
        Sql2o sql2o = new Sql2o(connectionString, "","");
        Sql2oTrailDao trailDao = new Sql2oTrailDao();
        Sql2oUserDao userDao = new Sql2oUserDao();
        Sql2oReviewDao reviewDao = new Sql2oReviewDao();

        //-CONTENT:-(inorder)
        //get: Display Homepage.
        //get: Display trail form.
        //post: process trail form.
        //get: display delete confirmation form (optional).
        //get: delete all data (optional) - no success page for delete
        //get: display user form.
        //post: process user form.
        //get: display all trails.
        //get: display all users (optional) - not on html for admin purposes
        //get: display journal form for user.
        //post: process journal form. - no success for journal form
        //get: display trails per id
        //get: display trail form for edit
        //post: update the trail
        //get: display journal form for edit
        //post: update the journal

        //-end of content-


        //get: Display homepage
        get("/",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            List<Trail> trails = trailDao.getAll();
            List<User> users = userDao.getAll();
            List<Journal> journal = journalDao.getAll();
            model.put("users", users);
            model.put("trails", trails);
            model.put("journal", journal);
            return new ModelAndView(model,"index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: Display trail form
        get("/trails/new",(req,res)->{
           Map<String, Object> model = new HashMap<>();
           List<Trail> trails = trailDao.getAll();
           model.put("trails", trails);
           return new ModelAndView(model,"trail-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process trail form
        post("/trails/new",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String difficulty = req.queryParams("difficulty");
            String location = req.queryParams("location");
            String distance = req.queryParams("distance");
            Trail trail = new Trail(name, difficulty, location, distance);
            trailDao.add(trail);
            List<Trail> trails = trailDao.getAll();
            model.put("trails", trails);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: display delete confirmation form (optional)
        get("/trails/delete",(req,res)->{
           Map<String,Object> model = new HashMap<>();
           return new ModelAndView(model, "delete.hbs");
        }, new HandlebarsTemplateEngine());

        //get: delete all data (optional)
        get("/trails/delete/success",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            trailDao.clearAllTrails();                        // sample- just rename method
            userDao.clearAllUser();
            List<Trail> trails = trailDao.getAll();
            List<User> users = userDao.getAll();
            model.put("trails",trail);
            model.put("users",user);
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: display user form
        get("/users/new",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            List<Trail> trails = trailDao.getAll();
            List<User> users = userDao.getAll();
            model.put("trail", trails);
            model.put("users", users);
            return new ModelAndView(model, "user-form");
        }, new HandlebarsTemplateEngine());

        //post: process user form
        post("/users/new", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String location = req.queryParams("location");
            String distance = req.queryParams("distance");
            User user = new Trail(name, location, distance);
            userDao.add(user);
            List<User> users = userDao.getAll();
            model.put("users",users);
            return new ModelAndView(model, "user-success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: display all trails
        get("/trails",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            List<Trail> trails = trailDao.getAll();
            model.put("trails", trails);
            return new ModelAndView(model,"all-trails.hbs");
        }, new HandlebarsTemplateEngine());

        //get: display all users (optional)
        get("/users",(req,res)->{
           Map<String, Object> model = new HashMap<>();
           List<User> users = userDao.getAll();
           return new ModelAndView (model,"user-list.hbs");
        }, new HandlebarsTemplateEngine());

        //get: display journal form for user
        get("/trails/:id/journals/new", (req,res)->{ // not sure of the right path "/user/:userid/journal/new"
            Map<String, Object> model = new HashMap<>();
            List<Trail> trails = trailDao.getAll();
            List<User> users = userDao.getAll();
            model.put("trails",trails);
            model.put("users",users);
            return new ModelAndView(model,"journal-form");
        }, new HandlebarsTemplateEngine());

        //post: process journal form
        post("/trails/:id/journals/new", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            String userId = req.queryParams("userId");
            String createdAt = req.queryParams("createdAt");
            String bestSeason = req.queryParams("bestSeason");
            String didTheHike = req.queryParams("didTheHike"); // boolean?
            String notes = req.queryParams("notes");
            Journal journal = new Journal(userId, createdAt, bestSeason, didTheHike);
            journalDao.add(journal);
            model.put("journals",journal);
            return new ModelAndView(model, "trail-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get: display trails per id
        get("/trails/:id", (req,res)->{
            Map<String, Object> model = new HashMap<>();
            Trail foundTrail = trailDao.findById(Integer.parseInt(req.params("id")));
            List<Journal> journals = trailDao.getAllJournalByTrail(foundTrail.getId());
            model.put("trails",trail);
            model.put("journals", journal);
            return new ModelAndView(model, "trail-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get: display trails form for edit
        get("/trails/:id/update",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            Trail editTrail = trailDao.findById(Integer.parseInt(req.params("id")));
            model.put("editTrail",editTrail);
            return new ModelAndView(model, "trail-form");
        }, new HandlebarsTemplateEngine());

        //post: update the trail
        post("/trails/:id/update",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String difficulty = req.queryParams("difficulty");
            String location = req.queryParams("location");
            String distance = req.queryParams("distance");
            int trailId = Integer.parseInt(req.params("id"));
            trailDao.update(trailId, name, difficulty, location, distance);
            List<Trails> trails = trailDao.getAll();
            model.put("trails", trails);
            return new ModelAndView(model,"trail-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get: display journal form for edit
        get("/journals/:id/update",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            Journal editJournal = journalDao.findById(Integer.parseInt(req.params("id")));
            model.put("editJournal",editJournal);
            return new ModelAndView(model, "journal-form");
        }, new HandlebarsTemplateEngine());

        //post: update the journal
        post("/journals/:id/update",(req,res)->{
            Map<String, Object> model = new HashMap<>();
            String userId = req.queryParams("userId");
            String createdAt = req.queryParams("createdAt");
            String bestSeason = req.queryParams("bestSeason");
            String didTheHike = req.queryParams("didTheHike"); // boolean?
            String notes = req.queryParams("notes");
            int journalId = Integer.parseInt(req.params("id"));
            journalDao.update(journalId, userId, createdAt, bestSeason, didTheHike, notes);
            List<Trails> trails = trailDao.getAll();
            List<Journal> journals = journalDao.getAll();
            model.put("trails", trails);
            model.put("journals", journals);
            return new ModelAndView(model,"trail-detail.hbs");
        }, new HandlebarsTemplateEngine());
    }
}


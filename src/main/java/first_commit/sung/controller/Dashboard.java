package first_commit.sung.controller;


import com.google.gson.JsonObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Dashboard {

    @ResponseBody
    @GetMapping("/dashboard_summary")
    public String summary(){
        JsonObject obj = new JsonObject();
        obj.addProperty("title", "test1");
        obj.addProperty("name", "sungbum");
        return obj.toString();
    }
}

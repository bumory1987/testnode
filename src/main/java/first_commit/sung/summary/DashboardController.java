package first_commit.sung.summary;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import first_commit.sung.entity.dto.InfoDto;
import first_commit.sung.entity.dto.SummaryDe;
import first_commit.sung.entity.dto.SummaryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@Slf4j
public class DashboardController {

    private final DashboardFacade dashboardFacade;



    @ResponseBody
    @GetMapping("/dashboard_summary")
    public List<SummaryDe> summary(@RequestParam(name= "count", required = false) String count){
        int param = 5;
        try{
            param = Integer.parseInt(count);
        }catch (Exception e){
        }

        return dashboardFacade.getJsonList(param);
    }

    @ResponseBody
    @RequestMapping(value = "/receiver", method = RequestMethod.POST, produces = "application/json; charset=utf8")
    public String getJson(@RequestBody Map<String, Object> param){
        Gson gson = new Gson();
        String info = param.get("info").toString();
//        InfoDto infoDto = gson.fromJson(info, InfoDto.class);
//        String jsonInfo = gson.toJson(infoDto);
        String save = dashboardFacade.save(info);
//        log.info("data ={}", jsonInfo );
//        GsonBuilder gsonBuilder = new GsonBuilder();

//        InfoDto summaryDe = gson.fromJson(jsonInfo, InfoDto.class);
        //log.info("response ={}", summaryDe );
        return "ok";
    }





}

package phonebook.controller;

import phonebook.requestbody.Record;
import phonebook.requestbody.User;
import phonebook.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
class MainController {

    @Autowired
    private RecordService recordService;

   @GetMapping("/")
    public String greeting(Map<String, Object> model){
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user, Map<String, Object> model){

       Iterable<Record> records = recordService.findRecordsByUserId(user.getId());

        model.put("records", records);

        return "main";
    }

    @PostMapping("add")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String firstName,
                      @RequestParam String lastName,
                      @RequestParam String patronymic,
                      @RequestParam String phoneNumber,
                      @RequestParam String address,
                      @RequestParam String email,
                      Map<String, Object> model) {

        model.put("records", recordService.saveAndShowAllRecords(firstName, lastName, patronymic, phoneNumber, address, email, user));

        return "main";
    }

    @PostMapping("deleted")
    public String delete(@AuthenticationPrincipal User user,
                         @RequestParam String deleterecord,
                         Map<String, Object> model){

       recordService.deleteByEmail(deleterecord);
       model.put("records", recordService.findRecordsByUserId(user.getId()));

       return "main";
    }
}


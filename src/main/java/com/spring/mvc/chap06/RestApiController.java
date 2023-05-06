package com.spring.mvc.chap06;

import com.spring.mvc.jdbc.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/rests")
public class RestApiController {

    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요!";
    }

    @GetMapping("/foods")
    public List<String> foods() {
//        String[] foodList = {"탕수육", "족발", "마라탕"};
        List<String> foodList = List.of("탕수육", "족발", "마라탕");
        return foodList;
    }

    @GetMapping("/person")
    public Person person() {
        Person p = new Person(1L, "루피", 3);
        return p;
    }

    @GetMapping("/person-list")
    public ResponseEntity<?> personList() {
        Person p = new Person(1L, "루피", 3);
        Person p2 = new Person(2L, "딸긔겅듀", 4);
        Person p3 = new Person(3L, "뽀롤로", 5);
        List<Person> personList = List.of(p, p2, p3);

        return ResponseEntity.ok().body(personList);
    }

    @GetMapping("/bmi")
    public ResponseEntity<?> bmi(
            @RequestParam(required = false) Double cm,
            @RequestParam(required = false) Double kg) {

        if (cm == null || kg == null) {
            return ResponseEntity.badRequest().body("키랑 몸무게 보내 이새갸");
        }

        double bmi = kg / (cm / 100) * (cm / 100);

        HttpHeaders headers = new HttpHeaders();
        headers.add("fruits", "melon");
        headers.add("hobby", "soccer");

        return ResponseEntity
                .ok()
                .headers(headers)
                .body(bmi);
    }
}

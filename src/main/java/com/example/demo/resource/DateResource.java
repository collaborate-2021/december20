package com.example.demo.resource;
import com.example.demo.repository.DateRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Date;

@RestController
public class DateResource {

    // todo
    // inject DateRepository into constructor
    // use spring dependency injection

    DateRepository dateRepository;
    public DateResource(){
        this.dateRepository = new DateRepository();
    }
    @RequestMapping("/current-date")
    @GetMapping
    public Date hello() throws SQLException {
            return dateRepository.fetchCurrentDate(); // todo mock this call
    }

}

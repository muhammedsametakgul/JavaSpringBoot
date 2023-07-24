package com.samet.cardemo.rest;


import com.samet.cardemo.entity.Worker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WorkerRestController {

    @GetMapping("/workers")
    public List<Worker> getWorkers(){

        List<Worker> theWorkers = new ArrayList<>();
        theWorkers.add(new Worker("Samet","Sam"));
        theWorkers.add(new Worker("Muhammed","Güneş"));
        theWorkers.add(new Worker("Mert","Katı"));

        return theWorkers;
    }
}

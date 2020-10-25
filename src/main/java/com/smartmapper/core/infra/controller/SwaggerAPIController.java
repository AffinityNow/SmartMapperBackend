package com.smartmapper.core.infra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerAPIController {
    @RequestMapping(value = "/addresses", method = RequestMethod.GET)
    public List<String> getaddresses() {
        List<String> addressesList = new ArrayList<>();
        addressesList.add("10 rue Nanterre");
        addressesList.add("7 rue Constantine");
        return addressesList;
    }
    @RequestMapping(value = "/addresses", method = RequestMethod.POST)
    public String searchAddresse() {
        return "addresse not found";
    }
}


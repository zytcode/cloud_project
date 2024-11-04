package com.zytcode.controller;

import com.zytcode.entity.GeoCode;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/webgis")
public class WebGisController {

    @Resource
    private RestTemplate restTemplate;

    private static final String URL = "http://provider-service-nacos/geocode";

    @RequestMapping
    public Object list() {
        System.out.println("call geocode");
        Object obj = restTemplate.getForObject(URL, Object.class);
        System.out.println("generate map");
        return obj;
    }

    @PostMapping
    public Object save(@RequestBody GeoCode geoCode) {
        System.out.println("call geocode save method");
        Object obj = restTemplate.postForObject(URL, geoCode, Object.class);
        System.out.println("save generate finish");
        return obj;
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable Integer id) {
        restTemplate.delete(URL + "/" + id);
        return true;
    }

    @GetMapping("{id}")
    public String selectId(@PathVariable Integer id) {
        return restTemplate.getForObject(URL + "/" + id, String.class);
    }

    @PutMapping
    public void update(@RequestBody GeoCode geoCode) {
        restTemplate.put(URL, geoCode);
    }
}

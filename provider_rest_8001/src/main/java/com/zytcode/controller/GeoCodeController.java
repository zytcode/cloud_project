package com.zytcode.controller;

import com.zytcode.entity.GeoCode;
import com.zytcode.service.GeoCodeService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/geocode")
public class GeoCodeController {

    @Resource
    private GeoCodeService geoCodeService;

    @GetMapping
    public Object list() {
        return geoCodeService.list();
    }

    @PostMapping
    public Object save(@RequestBody GeoCode geoCode) {
        return geoCodeService.save(geoCode);
    }

    @PutMapping
    public Object update(@RequestBody GeoCode geoCode) {
        return geoCodeService.updateById(geoCode);
    }

    @DeleteMapping("{id}")
    public Object delete(@PathVariable Integer id) {
        return geoCodeService.removeById(id);
    }

    @GetMapping("{id}")
    public Object getById(@PathVariable Integer id) {
        return geoCodeService.getById(id);
    }

}

package com.example.example.demo.book.api;

import com.example.example.demo.book.entity.Koefs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Regression management REST API")
@RequestMapping("/api/v1/regression")
public interface RegressionApi {
    @ApiOperation("Get regression koefs API")
    @GetMapping(value = "/koefs/{id}")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<Koefs> findKoefs(@PathVariable Long id);

    @ApiOperation("Create XY koefs API")
    @PostMapping("new")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<Koefs> addXYKoefs(@RequestBody Koefs koefs);
}

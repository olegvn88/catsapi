package com.olnester.cats.controller;

import com.olnester.cats.dto.CatDto;
import com.olnester.cats.entity.CatEntity;
import com.olnester.cats.service.CatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatController {

    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping
    public ResponseEntity<List<CatEntity>> getAllCats() {
        return ResponseEntity.ok(catService.getAllCats());
    }

    @PostMapping
    public ResponseEntity<CatEntity> addCat(@RequestBody CatDto cat) {
        return ResponseEntity.created(URI.create("")).body(catService.saveCat(cat));
    }

    @GetMapping("/{catId}")
    public ResponseEntity<CatEntity> getCatById(@PathVariable Long catId) {
        return ResponseEntity.ok(catService.getCatById(catId));
    }
}

package com.store.catalog.controller;

import com.store.catalog.entity.Category;
import com.store.catalog.entity.Pengguna;
import com.store.catalog.service.CategoryService;
import com.store.catalog.service.PenggunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class penggunaController {
    @Autowired
    private PenggunaService penggunaService;

    @GetMapping("/penggunas")
    public List<Pengguna> findAll(){
        return penggunaService.findAll();
    }
    @GetMapping("/penggunas/{id}")
    public Pengguna findById(@PathVariable("id") String id){
        return penggunaService.findById(id);
    }
    @PostMapping("/penggunas")
    public Pengguna create(@RequestBody Pengguna pengguna){
        return penggunaService.create(pengguna);
    }
    @PutMapping("/pengguna")
    public Pengguna update(@RequestBody Pengguna pengguna){
        return penggunaService.update(pengguna);
    }
    @DeleteMapping("/penggunas/{id}")
    public void deleteById(@PathVariable("id") String id){
        penggunaService.deletedById(id);
    }
}

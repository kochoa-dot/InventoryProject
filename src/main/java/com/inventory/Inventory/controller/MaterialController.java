package com.inventory.Inventory.controller;

import com.inventory.Inventory.model.Materials;
import com.inventory.Inventory.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materials")
@CrossOrigin
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @PostMapping("/add")
    public String add(@RequestBody Materials materials){
        return materialService.saveMaterial(materials);
    }

    @GetMapping("/getAll")
    public List<Materials> getAllMaterial(){
        return materialService.getAllMaterial();
    }

    @GetMapping("/getMaterialById/{id_material}")
    public Materials getMaterialById(@PathVariable Integer id_material){
        return materialService.getMaterialById(id_material);
    }

    @PutMapping("/updateMaterial/{id_material}")
    public Materials updateMaterial(@RequestBody Materials newmaterial, @PathVariable Integer id_material){
        return materialService.updateMaterial(newmaterial, id_material);
    }

    @DeleteMapping("/deleteMaterial/{id_material}")
    public String deleteMaterial(@PathVariable Integer id_material){
        return materialService.deleteMaterial(id_material);
    }
}

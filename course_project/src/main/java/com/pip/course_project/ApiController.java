package com.pip.course_project;

import com.pip.course_project.database.ItemType;
import com.pip.course_project.database.ItemTypeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ItemTypeRep itemTypeRep;

    @Autowired
    public ApiController(ItemTypeRep itemTypeRep) {
        this.itemTypeRep = itemTypeRep;
    }

    @GetMapping("/itemType")
    public Iterable<ItemType> getItemTypes() {
        return itemTypeRep.findAll();
    }

    @GetMapping("/itemTypes/{id}")
    public ResponseEntity<ItemType> getItemTypeById (@PathVariable(value = "id") Long itemTypeId){
        ItemType itemType = itemTypeRep.findOne(itemTypeId);
        if (itemType == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(itemType);
    }


}

package com.pip.course_project;

import com.pip.course_project.database.ItemTypes;
import com.pip.course_project.database.ItemTypesRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final ItemTypesRep itemTypesRep;

    @Autowired
    public ApiController(ItemTypesRep itemTypesRep) {
        this.itemTypesRep = itemTypesRep;
    }

    @GetMapping("/itemTypes")
    public Iterable<ItemTypes> getItemTypes() {
        return itemTypesRep.findAll();
    }

}

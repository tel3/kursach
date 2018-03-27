package pip;

import pip.database.ItemType;
import pip.database.ItemTypeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

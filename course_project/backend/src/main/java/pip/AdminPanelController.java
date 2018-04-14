package pip;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pip.database.User;
import pip.database.UserRep;

@RestController
@RequestMapping("/admin_panel")
public class AdminPanelController {
    private final UserRep userRep;

    @Autowired
    public AdminPanelController(UserRep userRep){
        this.userRep = userRep;
    }

    @PostMapping("/set_role/{email}:{role}")
    public void setRole(@PathVariable("role") String role, @PathVariable("email") String email){
        User user = userRep.findByEmail(email);
        user.setRole(role);
    }
}

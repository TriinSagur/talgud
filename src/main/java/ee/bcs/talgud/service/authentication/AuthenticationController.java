package ee.bcs.talgud.service.authentication;

import ee.bcs.talgud.domain.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Resource
    private AuthenticationService authenticationService;

    @PostMapping
    @Operation(summary = "Loob uue kasutaja.")
    public int addNewUser(@RequestBody UserDto userDto) {
        return authenticationService.addNewUser(userDto);
    }

    @PostMapping("/exists")
    @Operation(summary = "Otsib kasutaja andmebaasist.")
    public int userExists(@RequestBody UserDto userDto) {
        return authenticationService.getUser(userDto);
    }

    @PutMapping
    @Operation(summary = "Uuendab kliendi info")
    public void updateUser(@RequestBody UserDto userDto, @RequestParam Integer userId) {
        authenticationService.updateUser(userId, userDto);
    }

    @DeleteMapping
    @Operation(summary = "Kustutab kliendi.")
    public void deleteUser(@RequestParam Integer userId) {
        authenticationService.deleteUser(userId);
    }



    // todoo - tagastab listi mis sisaldab userDto-sid. Andmebaasi päring mis tagastab kõikide kasutajate
    // nimekirja. Add (user/)contact, muuda, (kustuta,)

}


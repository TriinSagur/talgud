package ee.bcs.talgud.service.authentication;

import ee.bcs.talgud.domain.contact.ContactDto;
import ee.bcs.talgud.domain.user.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    @Resource
    private AuthenticationService authenticationService;

    @PostMapping
    @Operation(summary = "Loob uue kasutaja.")
    public Integer addNewUser(@RequestBody UserDto userDto) {
        return authenticationService.addNewUser(userDto);
    }

    @PostMapping("/exists")
    @Operation(summary = "Otsib olemasoleva kasutaja andmebaasist.")
    public int userExists(@RequestBody UserDto userDto) {
        return authenticationService.getUser(userDto);
    }

    @PutMapping
    @Operation(summary = "Uuendab olemasoleva kasutaja info.")
    public void updateUser(@RequestBody UserDto userDto, @RequestParam Integer userId) {
        authenticationService.updateUser(userId, userDto);
    }

    @DeleteMapping
    @Operation(summary = "Kustutab kasutaja.")
    public void deleteUser(@RequestParam Integer userId) {
        authenticationService.deleteUser(userId);
    }

    @PostMapping("/contact")
    @Operation(summary = "Loob olemasolevale kasutajale uued kontaktid.")
    public void addNewContact(@RequestBody ContactDto contactDto) {
        authenticationService.addNewContact(contactDto);
    }

    @PutMapping("/contact")
    @Operation(summary = "Uuendab olemasoleva kasutaja kontaktid.")
    public void updateContact(@RequestBody ContactDto contactDto) {
        authenticationService.updateContact(contactDto);
    }


    // todoo - tagastab listi mis sisaldab userDto-sid. Andmebaasi päring mis tagastab kõikide kasutajate
    // nimekirja. Add (user/)contact, muuda, (kustuta, user_role, üks kasutaja kontakt)

}


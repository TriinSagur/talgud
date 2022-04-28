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

    @GetMapping("/exists")
    @Operation(summary = "Otsib kasutaja andmebaasisit.")
    public int userExists(@RequestBody UserDto userDto) {
        return authenticationService.getUser(userDto);
    }
}


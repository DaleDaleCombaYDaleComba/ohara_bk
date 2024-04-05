package Controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/alquiler")
@SecurityRequirement(name = "Bearer Authentication")
public class AlquilerController {
}

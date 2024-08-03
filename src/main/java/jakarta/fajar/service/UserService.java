package jakarta.fajar.service;

import jakarta.fajar.constraints.CheckPasswordParameter;
import jakarta.validation.constraints.NotBlank;

public class UserService {

    @CheckPasswordParameter(passwordParam = 1, confirmPassword = 2)//ini dihitung field yang ada di parameter method, dan dimulai dari 0. karna yang ingin kita validasi password dan confirmPassword maka index ke 1 dan 2
    public void register(
            @NotBlank(message = "username can not blank") String username,
            @NotBlank(message = "password can not blank") String password,
            @NotBlank(message = "confirm password can not blank") String confirmPassword){

    }


}

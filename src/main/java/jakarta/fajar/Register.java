package jakarta.fajar;

import jakarta.fajar.constraints.CheckPassword;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@CheckPassword(message = "{register.password}")//contoh dari level class constraint yaitu memberi anntotaion pada class register
public class Register {

    @NotBlank(message = "name must not blank")
    private String name;

    @NotBlank(message = "password must not blank")
    private String password;

    @NotBlank(message = "confirm Password can not blank")
    private String confirmPassword;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "Register{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}

package jakarta.fajar;

import org.junit.jupiter.api.Test;

import java.util.Locale;

public class LevelClassConstraintTest extends AbstractValidatorTest{

    /** Class-Level Constraint
     * Sebelumnya kita hanya membuat Constraint pada Field, Method, dan Constructor
     * Constraint juga  bisa kita tambahkan pada level class
     * Hal ini kadang bermanfaat, seperti misal kita ingin membandingkan lebih dari satu Field misalnya
     * Untuk membuat Class-Level Constraint, kita cukup tambahkan Annotation Constraint pada Class, dan pastikan saat membuat Constraint, tambahkan target Class
     */


    /**
     * Sebelumnya jika kita menggunakan level class property bawaan dari class tersebut akan hilang
     * kita bisa membuat property sendiri untuk memberi tahu property class yang hilang dengan menggunakan Constraint Validator Context
     *
     */
    @Test
    void testConstraintLevelClass() {
        Locale.setDefault(new Locale("in", "ID"));



        Register register = new Register();
        register.setPassword("fajar");
        register.setConfirmPassword("fajar1");


        validate(register);

    }
}

package jakarta.fajar;

import jakarta.validation.metadata.BeanDescriptor;
import jakarta.validation.metadata.ConstraintDescriptor;
import jakarta.validation.metadata.PropertyDescriptor;
import org.junit.jupiter.api.Test;

public class MetadataClassTest extends AbstractValidatorTest{


    /** Metadata
     * Materi ini sebenarnya bisa kita tangani dengan menggunakan Reflection
     * Namun Bean Validation memberikan fitur untuk mempermudah kita
     * Bean Validation memungkinkan kita melihat sebuah constraint yang terdapat di sebuah class
     * Kita bisa melihat detail dari constraint tersebut, mirip seperti ketika kita melihat semua struktur class menggunakan Java Reflection
     * Metadata untuk constraint, disimpan dalam object BeanDescriptor
     * https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/metadata/beandescriptor

     */

    @Test
    void testMetadata() {
        BeanDescriptor constraintsForClass = validator.getConstraintsForClass(Person.class);// dengan menggunakan method getConstraintsForClass kita bisa mengecek detail isi dari pada BeanDescriptor kita

        //kita bisa melihat detail metadate dengan menggunakan BeanDescriptor ini mirip seperti java Reflection
        for (PropertyDescriptor constrainedProperty : constraintsForClass.getConstrainedProperties()) {
            System.out.println(constrainedProperty.getPropertyName());
            for (ConstraintDescriptor<?> descriptor : constrainedProperty.getConstraintDescriptors()) {
                System.out.println(descriptor.getMessageTemplate());
                System.out.println(descriptor.getAnnotation());
            }
            System.out.println("======================");
        }

    }
}

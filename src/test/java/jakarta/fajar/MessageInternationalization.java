package jakarta.fajar;

import jakarta.fajar.group.CreditCardPaymentGroup;
import jakarta.fajar.group.VirtualAccountPaymentGroup;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

public class MessageInternationalization extends AbstractValidatorTest {

    /** Message Internationalization
     * Secara default saat kita menggunakan Resource Bundle, Locale yang akan dipilih adalah Locale.getDefault()
     * Jadi jika kita ingin mengubah Locale untuk Resource Bundle, kita harus mengubah default Locale nya
     */


    /** MessageInterpolator
     * Salah satu yang cara lumayan sulit, namun lebih flexible adalah menggunakan MessageInterpolator secara langsung
     * Cara ini sangat flexible, tapi sangat sulit karena kita harus membuat context secara manual untuk MessageInterpolator
     * Kita tidak perlu mengubah Default Locale, hanya cukup  gunakan parameter Locale di Message Interpolator
     * https://jakarta.ee/specifications/bean-validation/3.0/apidocs/jakarta/validation/messageinterpolator 
     */


    @Test
    void testGetDefaultInternationalization() {

        Locale.setDefault(new Locale("in","ID"));

        Payment payment = new Payment();
        payment.setOrderId("121412904518350125");
        payment.setAmount(10L);

        validateWithGroup(payment, VirtualAccountPaymentGroup.class);
        
    }


    @Test
    void testFlexibleMessageInterpolar() {
        Payment payment = new Payment();
        payment.setOrderId("121412904518350125");
        payment.setAmount(10L);

        Locale locale = new Locale("in","ID");


        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);

        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessageTemplate());

            MessageInterpolator.Context context = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(),
                    violation.getInvalidValue(),
                    violation.getRootBeanClass(),
                    violation.getPropertyPath(),
                    violation.getConstraintDescriptor().getAttributes(),
                    violation.getConstraintDescriptor().getAttributes(),
                    ExpressionLanguageFeatureLevel.VARIABLES,
                    true
            );

//            MessageInterpolator.Context context = new MessageInterpolatorContext()

            String message = messageInterpolator.interpolate(violation.getMessageTemplate(), context, locale );
            System.out.println(message);




            System.out.println("=====================");

        }


    }
}

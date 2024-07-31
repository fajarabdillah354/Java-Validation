package jakarta.fajar.constraints;


import jakarta.fajar.enums.CaseMode;
import jakarta.fajar.group.CreditCardPaymentGroup;
import jakarta.fajar.group.VirtualAccountPaymentGroup;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.Default;

import java.lang.annotation.*;


//kita bisa mengumpulkan beberapa constraint dalam 1 contraint, ini bertujuan untuk persingkat sekaligus membersihkan code kita


@CheckCase(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, mode = CaseMode.UPPER, message = "{order.id.upper}")
@NotBlank(groups = {Default.class,CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},message = "{order.id.notblank}")
@Size(groups = {VirtualAccountPaymentGroup.class, CreditCardPaymentGroup.class},min = 1, max = 6, message = "{order.id.size}")
@Documented
@Constraint(validatedBy = {})//validateBy harus kita kosong kan, karna kita menggabungkan beberapa constraint jadi 1
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@ReportAsSingleViolation//kita bisa meng combine semua error dalam orderId dalam 1 report, yaitu jika menggunakan annotationn @ReportAsSingleViolation error2 lainnya dalam field tidak ditampilkan hanya menampikan secara general bahwa orderId tidak valid
public @interface CheckOrderId {


    /** @ReportAsSingleViolation
     * Secara default, semua Constraint di Constraint Composite akan dieksekusi, jadi jika misal  terdapat lebih dari satu error, maka semua error akan diberitahukan
     * Kadang ada baiknya, jika misal terdapat satu constraint yang error, kita tidak perlu lakukan pengecekan ke  constraint berikutnya
     * Untuk melakukan hal ini, kita bisa tambahkan annotation @ReportAsSingleViolation pada Composite Constraint Annotation
     * @return
     */


    String message() default "Invalid Format Case"; // jika menggunakan @ReportAsSingleViolation maka yang akan ditampilkan saat error adalah bagian default bukan setiap bagian2 yang terdapat error, sehingga kita bisa memberi message pada field yang menggunakan interface ini

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}

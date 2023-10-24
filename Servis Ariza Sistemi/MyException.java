/**
 * @file MyException
 * @description Servis - Ariza Sistemi (Bir servisin verdiği hizmetin yani Randevularının ve müşterilerin araçlarını bir
 * tekniker ile onarıp gerekli kontrollerin yapıldığı program)
 * @assignment 2
 * @date 23.01.2022
 * @author Şahan Aytekin - 2021221033
 */

package ProjeÖdevi_2;

public class MyException extends Exception{

    private String message;

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

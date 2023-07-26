package enumTypes;

import static enumTypes.PasswordStrengthConstant.*;
import static enumTypes.PasswordStrengthConstant.HIGH;

public class Runner {
    public static void main(String[] args) {

        useConstant("LOW");
        useConstant("HIGH");
        useConstant("medium"); // CTE yok, RTE yok...

        System.out.println("----------");

        useEnum(PasswordStrengthEnum.LOW);
        useEnum(PasswordStrengthEnum.MEDIUM);
        useEnum(PasswordStrengthEnum.HIGH);
    }

    public static void useConstant(String strength) {
        switch (strength) {
            case LOW -> System.out.println("Password gucunuz dusuktur!!!");
            case MEDIUM -> System.out.println("Password gucunuz orta seviyededir!!!");
            case HIGH -> System.out.println("Password gucunuz yuksektir!!!");
        }
    }

    public static void useEnum(PasswordStrengthEnum strength) {
        switch (strength) {
            case LOW -> System.out.println("Password gucunuz dusuktur!!!");
            case MEDIUM -> System.out.println("Password gucunuz orta seviyededir!!!");
            case HIGH -> System.out.println("Password gucunuz yuksektir!!!");
        }
        System.out.println("Enum ismi : " + strength.name());
        System.out.println("Enum sirasi : " + strength.ordinal());
    }
}

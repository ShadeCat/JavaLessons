/*Написать метод, который проверяет на корректность и исправляет по возможности введенный номер телефона
1.На вход подается строка с номером телефона
2.Если номер начинается с +7, то заменять на 8
3.Если в номере есть пробелы и/или скобки - удалять
4.Если после изменений количество символов не 11 - считаем что введен некорректный номер.
5.На выход отдаем массив из 2 строк:
    Исправленный номер телефона, если номер корректный, или строку "Введен некорректный номер" для некорректных номеров
    Список изменений и сработавших проверок на некорректность, которые были совершены через ; . Если изменений не было - выводить "Не было изменений" . Например:
"Замена +7 на 8; В номере есть пробелы и/или скобки" или "Сумма символов больше 11" */

import java.util.Arrays;

public class PhoneNormalize {
    public static void main(String[] args){
        String example = "+7(921)115-11-17";
        String[] originResult = {example, ""};
        String[] valid_phone = validCheck((whitespacesCheck(sevenCheck(originResult))));
        System.out.println(Arrays.toString(valid_phone));
    }

    private static String[] sevenCheck(String[] phoneWithDescription){
        String validationError = "Замена +7 на 8";
            if (phoneWithDescription[0].startsWith("+7")){
                phoneWithDescription[0] = phoneWithDescription[0].replace("+7", "8");
                addDescription(phoneWithDescription, validationError);
        }
        return phoneWithDescription;
    }

    private static String[] whitespacesCheck(String[] phoneWithDescription){
        String validationError = "В номере есть пробелы и/или спецсимволы";
        if (phoneWithDescription[0].contains(" ") || phoneWithDescription[0].contains("(") || phoneWithDescription[0].contains(")")){
            addDescription(phoneWithDescription, validationError);
        }
        phoneWithDescription[0] = phoneWithDescription[0].replaceAll("[^0-9]", "");
        return phoneWithDescription;

    }


    private static String[] validCheck(String[] phoneWithDescription){
        String incorrectNumber = "Введен некорректный номер";
        String phoneIsValid = "Не было изменений";
        String validationError = "Количество символов не равно 11";
        if (phoneWithDescription[0].length() != 11 ){
            phoneWithDescription[0] = incorrectNumber;
            addDescription(phoneWithDescription, validationError);
        }
        if (phoneWithDescription[1].equals("")){
            phoneWithDescription[1] = phoneIsValid;
        }
        phoneWithDescription[1] = phoneWithDescription[1] + ".";
        return phoneWithDescription;
    }

    private static void addDescription(String[] phoneWithDescription, String description){
        if (!phoneWithDescription[1].equals("")){
            phoneWithDescription[1] = phoneWithDescription[1] + "; ";
        }
        phoneWithDescription[1] = phoneWithDescription[1] + description;
    }
}


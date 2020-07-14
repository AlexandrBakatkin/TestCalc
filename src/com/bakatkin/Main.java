package com.bakatkin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static com.bakatkin.RomanDigit.*;

public class Main {

    static boolean ROMAN_MODE;

    public static void main(String[] args) throws IllegalInputException {

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Input:");
            String input = in.nextLine();
            ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList(input.split(" ")));

            if (stringArrayList.size() != 3){
                throw new IllegalInputException("Illegal Format");
            }

            if (!CheckArithmetic(stringArrayList.get(1))){
                throw new IllegalInputException("Illegal Arithmetic Action - " + stringArrayList.get(1));
            }
            //Проверка чисел на запись римскими цифрами
            ROMAN_MODE = CheckRomanDigit(stringArrayList.get(0)) && CheckRomanDigit(stringArrayList.get(2));
            if (!ROMAN_MODE && (CheckRomanDigit(stringArrayList.get(0)) || CheckRomanDigit(stringArrayList.get(1)))){
                throw new IllegalInputException("Illegal Type Error");
            }
            //Конвертация цифр в объекты класса Digital
            Digit digitFirst = ConvertToDigit(stringArrayList.get(0));
            Digit digitSecond = ConvertToDigit(stringArrayList.get(2));

            int result = 0;
            String resultStr = null;
            //Вычисляем значение выражения в зависимости от арифметического действия
            switch (stringArrayList.get(1)){
                case "+":
                    result = digitFirst.getValue() + digitSecond.getValue();
                    break;
                case "-":
                    result = digitFirst.getValue() - digitSecond.getValue();
                    break;
                case "/":
                    result = digitFirst.getValue() / digitSecond.getValue();;
                    break;
                case "*":
                    result = digitFirst.getValue() * digitSecond.getValue();;
                    break;
            }
            if (ROMAN_MODE){
                resultStr = ConvertToRoman(result);
            } else {
                resultStr = String.valueOf(result);
            }
            System.out.println("Output" + "\n" + resultStr);
        }
    }

    private static String ConvertToRoman(int i) {
        String decadesStr = "";
        String unitsStr = null;
        int decades = i/10;
        int units = i%10;

        switch (decades){
            case 1:
                decadesStr = "X";
                break;
            case 2:
                decadesStr = "XX";
                break;
            case 3:
                decadesStr = "XXX";
                break;
            case 4:
                decadesStr = "XL";
                break;
            case 5:
                decadesStr = "L";
                break;
            case 6:
                decadesStr = "LX";
                break;
            case 7:
                decadesStr = "LXX";
                break;
            case 8:
                decadesStr = "LXXX";
                break;
            case 9:
                decadesStr = "XC";
                break;
            case 10:
                decadesStr = "C";
                break;
        }

        switch (units) {
           case 1:
               unitsStr = "I";
               break;
           case 2:
               unitsStr = "II";
               break;
           case 3:
               unitsStr = "III";
               break;
           case 4:
               unitsStr = "IV";
               break;
           case 5:
               unitsStr = "V";
               break;
           case 6:
               unitsStr = "VI";
               break;
           case 7:
               unitsStr = "VII";
               break;
           case 8:
               unitsStr = "VIII";
               break;
           case 9:
               unitsStr = "IX";
               break;
       }
       return decadesStr + unitsStr;
    }

    private static Digit ConvertToDigit(String s) throws IllegalInputException {

        int digit = 0;

        if (!ROMAN_MODE) {
            try {
                digit = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } else {
            switch (s) {
                case "I":
                    return new Digit(I);
                case "II":
                    return new Digit(II);
                case "III":
                    return new Digit(III);
                case "IV":
                    return new Digit(IV);
                case "V":
                    return new Digit(V);
                case "VI":
                    return new Digit(VI);
                case "VII":
                    return new Digit(VII);
                case "VIII":
                    return new Digit(VIII);
                case "IX":
                    return new Digit(IX);
                case "X":
                    return new Digit(X);
                default:
                    return null;
            }
        }

        if (digit > 10 || digit < 1){
            throw new IllegalInputException("Illegal Digit Value - " + digit);
        }

        return new Digit(digit);
    }

    private static boolean CheckRomanDigit(String d) {
        return d.equals("I") || d.equals("II") || d.equals("III") || d.equals("IV") || d.equals("V") || d.equals("VI") || d.equals("VII") || d.equals("VIII") || d.equals("IX") || d.equals("X");
    }

    private static boolean CheckArithmetic(String s) {
        return s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*");
    }
}
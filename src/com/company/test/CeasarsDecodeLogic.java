package com.company.test;

public class CeasarsDecodeLogic {

    private final static String ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

    public void decodeText(String text) {

        int versionNum = 1;

        for (int alphabetIndex = ALPHABET.length() - 1; alphabetIndex > 0; alphabetIndex--) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int letterIndex = 0; letterIndex < text.length(); letterIndex++) {
                char currentLetter = text.charAt(letterIndex);
                if (String.valueOf(currentLetter).equals(" ") || String.valueOf(currentLetter).equals(".") || String.valueOf(currentLetter).equals(",")) {
                    stringBuilder.append(currentLetter);
                } else {
                    boolean isUpperCase = Character.isUpperCase(currentLetter);
                    int index = ALPHABET.indexOf(Character.toUpperCase(currentLetter));
                    int resultIndex = index - alphabetIndex;
                    if (resultIndex < 0) {
                        resultIndex = ALPHABET.length() + resultIndex;
                    }
                    stringBuilder.append(isUpperCase ? ALPHABET.charAt(resultIndex) : String.valueOf(ALPHABET.charAt(resultIndex)).toLowerCase());
                }
            }
            System.out.println("Версия " + versionNum++ + ". Смещение на " + alphabetIndex + ".");
            System.out.println("Результат: " + stringBuilder.toString());
            System.out.println("=====");
        }
    }

}

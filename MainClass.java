/*
Написати функцію, яка:
- приймає як вхідний параметр масив рядків;
- із заданого списку рядків знаходить перші два,
  в яких кожна літера трапляється парну кількість разів (наприклад "мама", "тато", "їж їжак желе");
- знаходить набір унікальних символів у словах знайдених слів (для наведеного прикладу "мама", "папа" це буде [м а п]);
- повертає набір літер у вигляді масиву або будь-якого типу колекції, порядок літер при цьому значення не має.

Рядок перетворюється на набір символів методом String.toCharArray().
Застосувати якнайбільше різних видів циклів (мінімум 2).
Використовувати ключові слова керування циклами.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainClass {

    public static final int NUMBER_OF_STRINGS = 2; // перші два

    public static void main(String[] args) {
        String[] strings = new String[]{"mama", "baobab", "oo ooo o", "papa", "tootsie"};
        Set<Character> characterSet = checkStringArray(strings);
        System.out.println(Arrays.toString(characterSet.toArray()));
    }

    // приймає як вхідний параметр масив рядків
    // повертає набір літер
    public static Set<Character> checkStringArray(String[] strings){
        String[] evenStrings = findEvenStrings(strings);
        System.out.println(Arrays.toString(evenStrings));
        Set<Character> characterSet = findUniqueSymbols(evenStrings);
        return characterSet;
    }

    // заданого списку рядків знаходить перші два
    private static String[] findEvenStrings(String[] strings) {
        int counter  = 0;
        String[] evenStrings = new String[NUMBER_OF_STRINGS];
        for (int i = 0; i < strings.length & counter < NUMBER_OF_STRINGS; i++) {
            if ( isStringEven(strings[i]) ) {
                evenStrings[counter] = strings[i];
                counter++;
            }
        }
        return evenStrings;
    }

    //трапляється парну кількість разів
    private static boolean isStringEven(String string) {
        Map<Character,Integer> charStat = new HashMap<>();
        for ( Character ch : string.toCharArray() ) {
            Integer count = charStat.get(ch);
            charStat.put(ch,( count == null ? 1 : ++count));
        }
        Iterator entries = charStat.entrySet().iterator();
        while (entries.hasNext()) {
            Entry entry = (Entry) entries.next();
            if (  (int) entry.getValue() % 2 != 0) return false;
        }
        return true;
    }


    // знаходить набір унікальних символів
    private static Set<Character> findUniqueSymbols(String[] evenStrings) {
        Set<Character> characterSet = new HashSet<>();
        for (String s : evenStrings){
            if (s == null) continue;
            for ( Character ch : s.toCharArray() ) {
                characterSet.add(ch);
            }
        }
        return characterSet;
    }


}

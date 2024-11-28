package practice;

import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        List<String> numbers = CoolNumbers.generateCoolNumbers();
        System.out.println("Сгенерировано номеров: " + numbers.size());

        HashSet<String> numbersHashSet = new HashSet<>(numbers);
        TreeSet<String> numbersTreeSet = new TreeSet<>(numbers);

        String number = "A111BC197";

        CoolNumbers.bruteForceSearchInList(numbers, number);
        CoolNumbers.binarySearchInList(numbers, number);
        CoolNumbers.searchInHashSet(numbersHashSet, number);
        CoolNumbers.searchInTreeSet(numbersTreeSet, number);

    }
}

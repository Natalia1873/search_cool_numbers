package practice;

import java.util.*;

public class CoolNumbers {

    private static final char[] LETTERS = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};
    private static final int MIN_REGION = 1;
    private static final int MAX_REGION = 199;
    private static final int COLLECTION_SIZE = 2_000_000;

    private static String formatRegion(int region){
        return String.format("%02d", region);
    }

    private static char getRandomLetter(){
        return LETTERS[new Random().nextInt(LETTERS.length)];
    }

    private static String generateNumber(){
        StringBuilder number = new StringBuilder();

        // First letter
        number.append(getRandomLetter());

        // Three digits
        number.append(String.format("%03d", new Random().nextInt(1000)));

        // Two letters
        number.append(getRandomLetter());
        number.append(getRandomLetter());

        // Region
        number.append(formatRegion(new Random().nextInt(MAX_REGION-MIN_REGION + 1)+ MIN_REGION));

        return number.toString();

    }


    public static List<String> generateCoolNumbers() {
        Set<String> uniqueNumbers = new HashSet<>();
        // Generate unique numbers
        while(uniqueNumbers.size()<COLLECTION_SIZE){
            uniqueNumbers.add(generateNumber());
        }

        return new ArrayList<>(uniqueNumbers);
    }

    public static boolean bruteForceSearchInList(List<String> numbers, String number) {
        long start = System.nanoTime();
        boolean found = numbers.contains(number);
        long duration = System.nanoTime() - start;
        String result = found ? "найден" : "не найден";
        System.out.printf("Поиск перебором: номер %s, поиск занял %d нс%n",
                result, duration);
        return found;
    }

    public static boolean binarySearchInList(List<String> numbers, String number) {
        Collections.sort(numbers);
        long start = System.nanoTime();
        boolean found = Collections.binarySearch(numbers, number) >= 0;
        long duration = System.nanoTime()-start;
        String result = found ? "найден" : "не найден";
        System.out.printf("Бинарный поиск: номер %s, поиск занял %d нс%n",
                result, duration);
        return found;
    }

    public static boolean searchInHashSet(HashSet<String> numbers, String number) {
        long start = System.nanoTime();
        boolean found = numbers.contains(number);
        long duration = System.nanoTime()- start;
        String result = found ? "найден" : "не найден";
        System.out.printf("Поиск в HashSet: номер %s, поиск занял %d нс%n",
                               result, duration);
        return found;
    }


    public static boolean searchInTreeSet(TreeSet<String> numbers, String number) {
        long start = System.nanoTime();
        boolean found = numbers.contains(number);
        long duration = System.nanoTime()- start;
        String result = found ? "найден" : "не найден";
        System.out.printf("Поиск в TreeSet: номер %s, поиск занял %d нс%n",
                               result, duration);
        return found;

    }

}

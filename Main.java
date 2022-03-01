import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);

        System.out.println();
        LinkedList<Integer> LinkedList = new LinkedList<>();
        System.out.println("Please insert the value of list item seperated by a space: ");
        String userInput = scan.nextLine();
        String[] arrOfStr = userInput.split(" ");

        for (String s : arrOfStr) {
            LinkedList.add(Integer.parseInt(s));
        }

        System.out.println(LinkedList);
        System.out.println("Please enter a value to add to the list: ");
        int value = scan.nextInt();
        addAndSort(LinkedList, value);
        System.out.println(LinkedList);

        System.out.println("Please enter the first index for swapping item: ");
        int index1 = scan.nextInt();
        System.out.println("Please enter the second index for swapping item: ");
        int index2 = scan.nextInt();
        swap(LinkedList, index1, index2);
        System.out.println("");
        System.out.println(LinkedList);

        LinkedList<Integer> ll = new LinkedList<>();
        int randomNum = 0;

        for (int i = 0; i < 500; ++i) {
            randomNum = ThreadLocalRandom.current().nextInt(1000, 10000);
            ll.add(randomNum);
        }

        randomNum = ThreadLocalRandom.current().nextInt(1000, 10000);

        System.out.println("Position of value " + randomNum + " found in the list:");
        System.out.println(findValue(ll, randomNum));

        System.out.println("");
        scan.nextLine();

        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println("Please insert the value for hash map item seperated by a space: ");
        userInput = scan.nextLine();
        arrOfStr = userInput.split(" ");

        int count = 0;
        for (String s : arrOfStr) {
            map.put(count, Integer.parseInt(s));
            count++;
        }
        System.out.println(map);

        System.out.println("Please enter a value to add to the list: ");
        value = scan.nextInt();
        addAndSortHash(map, value);
        System.out.println(map);

        System.out.println("Please enter the first index for swapping item: ");
        index1 = scan.nextInt();
        System.out.println("Please enter the second index for swapping item: ");
        index2 = scan.nextInt();
        swapHash(map, index1, index2);

        System.out.println("");
        System.out.println(map);

        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < 500; ++i) {
            randomNum = ThreadLocalRandom.current().nextInt(1000, 1200);
            map2.put(i, randomNum);
        }

        randomNum = ThreadLocalRandom.current().nextInt(1000, 1200);
        System.out.println("");
        System.out.println("Position of value " + randomNum + " found in the list:");
        System.out.println(findValueHash(map2, randomNum));

    }

    public static void addAndSortHash(HashMap<Integer, Integer> map, int value) {
        map.put(map.size(), value);
        for (int i : map.keySet()) {
            if (map.get(i) < value) {
                continue;
            } else {
                swapHash(map, i, map.size() - 1);
            }
        }
    }

    public static void swapHash(HashMap<Integer, Integer> map, int key1, int key2) {
        int temp = map.get(key2);
        map.put(key2, map.get(key1));
        map.put(key1, temp);
    }

    public static int findValueHash(HashMap<Integer, Integer> map, int number) {
        for (int i : map.keySet()) {
            if (map.get(i) == number) {
                return i;
            }
        }
        return -1;
    }

    public static int findValue(LinkedList<Integer> ll, int number) {
        for (int i = 0; i < ll.size(); ++i) {
            if (ll.get(i) == number) {
                return i;
            }
        }

        return -1;
    }

    public static void addAndSort(LinkedList<Integer> ll, int value) {
        ll.add(value);

        for (int i = 0; i < ll.size(); ++i) {
            if (ll.get(i) < value) {
                continue;
            } else {
                swap(ll, i, ll.size() - 1);
            }
        }

    }

    public static void swap(LinkedList<Integer> ll, int index1, int index2) {
        // Swapping the elements
        int temp = ll.get(index2);
        ll.set(index2, ll.get(index1));
        ll.set(index1, temp);
    }
}

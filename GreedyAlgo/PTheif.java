package GreedyAlgo;
import java.util.*;

public class PTheif {
    public static int catchThieves(char[] arr, int k) {
        int n = arr.length;
        List<Integer> police = new ArrayList<>();
        List<Integer> thief = new ArrayList<>();

        // Store indices of police and thieves
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'P')
                police.add(i);
            else if (arr[i] == 'T')
                thief.add(i);
        }

        int i = 0, j = 0, caught = 0;

        // Greedily match thieves and police
        while (i < thief.size() && j < police.size()) {
            if (Math.abs(thief.get(i) - police.get(j)) <= k) {
                caught++;
                i++;
                j++;
            } else if (thief.get(i) < police.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return caught;
    }

    public static void main(String[] args) {
        char[] arr = {'T', 'T', 'P', 'P', 'T', 'P'};
        int k = 2;
        System.out.println("Maximum thieves caught: " + catchThieves(arr, k));
    }
}


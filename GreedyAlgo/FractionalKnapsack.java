package GreedyAlgo;

import java.util.*;

public class FractionalKnapsack {
    static class Item implements Comparable<Item> {
        int val;
        int wt;
        double ratio;

        Item(int v, int w) {
            val = v;
            wt = w;
            ratio = (double) val / (double) wt;
        }

        // decreasing order to sort to get the maximum ratio
        @Override
        public int compareTo(Item that) {
            if (this.ratio <= that.ratio)
                return 1;
            return -1;
        }
    }

    double Fraction(List<Integer> val, List<Integer> wt, int capacity) {
        int n = val.size();
        ArrayList<Item> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Item(val.get(i), wt.get(i)));
        }

        double res = 0.0;
        for (Item item : list) {
            if (item.wt >= capacity) {
                res += (capacity * item.ratio);
                capacity = 0;
            } else {
                res += item.val;
                capacity -= item.wt;
            }
            if (capacity == 0)
                break;
        }
        return res;
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int res = 0;
        for (int[] boxType : boxTypes) {
            if (boxType[0] >= truckSize) { // if the capacity is less
                res += (truckSize * boxType[1]); // remaining TruckSize * arr[3,1<---val] ---1x1
                truckSize = 0;// reduce the TruckSize
            } else {
                res += (boxType[0] * boxType[1]);
                truckSize -= boxType[0];
            }
            if (truckSize == 0)
                break;

        }
        return res;
    }

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (diff[i] <= additionalRocks) {
                additionalRocks -= diff[i];
                diff[i] = 0;
            }
            if (diff[i] == 0) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        FractionalKnapsack fk = new FractionalKnapsack();

        List<Integer> val = Arrays.asList(60, 100, 120);
        List<Integer> wt = Arrays.asList(10, 20, 30);
        int capacity = 50;

        double maxValue = fk.Fraction(val, wt, capacity);
        System.out.println("Maximum value in Knapsack = " + maxValue);
    }
}

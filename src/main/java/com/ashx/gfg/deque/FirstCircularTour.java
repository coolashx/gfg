package com.ashx.gfg.deque;

public class FirstCircularTour {
    public static void main(String[] args) {
        int[] petrol = {50, 10, 60, 100};
        int[] dist = {30, 20, 100, 10};
        System.out.println(firstPetrolPump(petrol, dist));
    }

    public static int firstPetrolPump(int[] petrol, int[] dist) {
        int n = petrol.length, start = 0, currPet = 0, prevPet = 0;
        for (int i = 0; i < n; i++) {
            currPet += (petrol[i] - dist[i]);
            if (currPet < 0) {
                start = i + 1;
                prevPet += currPet;
                currPet = 0;
            }
        }
        return currPet + prevPet >= 0 ? start + 1 : -1;
    }
}

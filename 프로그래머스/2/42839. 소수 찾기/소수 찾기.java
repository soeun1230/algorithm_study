import java.lang.*;
import java.io.*;
import java.util.*;

class Solution {
    public HashSet<Integer> hs = new HashSet<>();
    
    public int solution(String numbers) {
        generateNumbers("", numbers);
 
        int primeCount = 0;
        for (int num : hs) {
            if (isPrime(num)) {
                primeCount++;
            }
        }
        
        return primeCount;
    }
    private void generateNumbers(String current, String remaining) {
        if (!current.isEmpty()) {
            hs.add(Integer.parseInt(current)); 
        }
        
        for (int i = 0; i < remaining.length(); i++) {
            generateNumbers(current + remaining.charAt(i), remaining.substring(0, i) 
                            + remaining.substring(i + 1));
        }
    }
    
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}
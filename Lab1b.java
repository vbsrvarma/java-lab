public class Lab1b {
// Single-word battle method
    public void battle(String word) {
        int leftScore = 0, rightScore = 0;
// Calculate scores for each character in word
        for (char c : word.toCharArray()) {
            leftScore += getLeftStrength(c);
            rightScore += getRightStrength(c);
        }
// Determine and print winner
        if (leftScore > rightScore) {
            System.out.println("Left side wins!");
        } else if (rightScore > leftScore) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }
// Two-word battle method
    public void battle(String leftWord, String rightWord) {
        int leftScore = 0, rightScore = 0;
// Calculate left and right scores separately
        for (char c : leftWord.toCharArray()) leftScore += getLeftStrength(c);
        for (char c : rightWord.toCharArray()) rightScore += getRightStrength(c);
// Determine and print winner
        if (leftScore > rightScore) {
            System.out.println("Left side wins!");
        } else if (rightScore > leftScore) {
            System.out.println("Right side wins!");
        } else {
            System.out.println("Let's fight again!");
        }
    }
// Get strength of left-side characters
    private int getLeftStrength(char c) {
        return switch (c) {
            case 'w' -> 4;
            case 'p' -> 3;
            case 'b' -> 2;
            case 's' -> 1;
            default -> 0;
        };
    }
// Get strength of right-side characters
    private int getRightStrength(char c) {
        return switch (c) {
            case 'm' -> 4;
            case 'q' -> 3;
            case 'd' -> 2;
            case 'z' -> 1;
            default -> 0;
        };
    }
// Main method to test battles
    public static void main(String[] args) {
        Lab1b game = new Lab1b();
        System.out.println("Test 1 (Word: 'z'):");
        game.battle("z");

        System.out.println("Test 2 (Word: 'zdqmwpbs'):");
        game.battle("zdqmwpbs");

        System.out.println("Test 3 (Word: 'wwwwwwz'):");
        game.battle("wwwwwwz");

        System.out.println("Test 4 (Left Word: 'wbp', Right Word: 'mqdz'):");
        game.battle("wbp", "mqdz");

        System.out.println("Test 5 (Left Word: 'wbp', Right Word: 'aei'):");
        game.battle("wbp", "aei");

    }
}

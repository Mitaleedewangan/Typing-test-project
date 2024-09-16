import java.util.*;

public class Main {
    
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       boolean continueTesting = true;

       while (continueTesting) {
           // Clear the terminal whenever the user restarts
           System.out.print("\033[H\033[2J");
           System.out.flush();

           // Set terminal text color to cyan
           System.out.println("\u001B[36mSelect mode: 1. Normal 2. Medium 3. Hard\u001B[0m");
           int mode = 0;
           boolean validMode = false;
           while (!validMode) {
               try {
                   mode = Integer.parseInt(scanner.nextLine());
                   if (mode < 1 || mode > 3) {
                       throw new IllegalArgumentException("Invalid mode selected. Please select 1, 2, or 3.");
                   }
                   validMode = true;
               } catch (NumberFormatException e) {
                   System.out.println("Invalid input. Please enter a number.");
               } catch (IllegalArgumentException e) {
                   System.out.println(e.getMessage());
               }
           }

           // Clear the terminal and set background color to black for the whole terminal
           System.out.print("\033[H\033[2J");
           System.out.flush();
           System.out.println("\u001B[40m"); // Set background color to black

           String wordsToType = "example words to type in this typing test random unique words for typing practice";
           String[] wordsArray = wordsToType.split(" ");
           List<String> userInputs = new ArrayList<>();

           // Pick 10 random unique words
           Set<String> uniqueWords = new HashSet<>();
           Random random = new Random();
           while (uniqueWords.size() < 10) {
               int randomIndex = random.nextInt(wordsArray.length);
               uniqueWords.add(wordsArray[randomIndex]);
           }
           List<String> wordsList = new ArrayList<>(uniqueWords);
           Collections.shuffle(wordsList);
           String wordsToDisplay = String.join(" ", wordsList);

           // Set terminal text color to green
           System.out.println("\u001B[32mStart typing the following words. Enter '0' to stop:\u001B[0m");
           System.out.println(wordsToDisplay);

           long startTime = System.currentTimeMillis();
           while (userInputs.size() < wordsList.size()) {
               String userInput = scanner.nextLine();
               if (userInput.equals("0")) {
                   break;
               }
               userInputs.addAll(Arrays.asList(userInput.split(" ")));
           }
           long endTime = System.currentTimeMillis();

           int totalWordsTyped = userInputs.size();
           long timeTaken = endTime - startTime; // in milliseconds
           double timeTakenMinutes = timeTaken / 60000.0; // convert to minutes
           double wordsPerMinute = totalWordsTyped / timeTakenMinutes;

           // Set terminal text color to yellow
           System.out.println("\u001B[33mWords per minute: " + wordsPerMinute + "\u001B[0m");
           System.out.println("Total words typed: " + totalWordsTyped);
           System.out.println("Typed words: " + userInputs);

           // Ask user if they want to restart or quit
           System.out.println("\u001B[36mDo you want to restart or quit? (R/Q)\u001B[0m");
           String userChoice = scanner.nextLine().trim().toUpperCase();
           if (userChoice.equals("Q")) {
               continueTesting = false;
           }
       }
   }
}

// random words
// wrong words
// have the typing test input in a single line
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Calculates the power of a number.
 *
 * @author Kevin Csiffary
 * @version 1.0
 * @since 2024-05-01
 */

// Power class
public final class Power {

  /** Private constructor to prevent instantiation. */
  private Power() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {
    try {
      // Setup scanner on file.
      File file = new File("input.txt");
      Scanner sc = new Scanner(file);
      // Setup writer for output file.
      FileWriter writer = new FileWriter("output.txt");
      BufferedWriter bufferedWriter = new BufferedWriter(writer);

      while (sc.hasNextLine()) {
        // Read the line from file.
        String line = sc.nextLine();

        /// Check if line is valid input.
        try {
          String[] lineArr = line.split(" ");
          int intBase = Integer.parseInt(lineArr[0]);
          int intPow = Integer.parseInt(lineArr[1]);

          // Call method and write to file.
          bufferedWriter.write(Integer.toString(recPow(intBase, intPow)));
        } catch (Exception e) {
          // Write non number error.
          bufferedWriter.write("Please input a number!");
        }
        // Adds a new line
        bufferedWriter.newLine();
      }

      // Close all writers and scanner.
      bufferedWriter.close();
      writer.close();
      sc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Calculates power with base and power.
   *
   * @param base
   * @param pow
   * @return Returns integer of power.
   */
  public static Integer recPow(final Integer base, final Integer pow) {
    if (pow <= 0) {
      return 1;
    } else {
      // Recursive call.
      return base * recPow(base, pow - 1);
    }
  }
}

package resources.algorithms.arrays;

public class Arrays {

  // O(N)
  // Add another element on first position of an array
  // To do that, you should move all elements that you have in your array to another position
  public int[] insertPolePosition(final int[] racingGrid, final int first) {
    int[] newRacingGrid = new int[racingGrid.length + 1];
    newRacingGrid[0] = first;

    for (int i = 0; i < racingGrid.length; i++) {
      newRacingGrid[i + 1] = racingGrid[i];
    }

    return newRacingGrid;
  }

}

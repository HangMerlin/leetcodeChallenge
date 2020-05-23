package Challenge052020

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3336/
 *
 * Count Square Submatrices with All Ones
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 * Example 1:
 *
 * Input: matrix =
 * [
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]
 * ]
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * Example 2:
 *
 * Input: matrix =
 * [
 * [1,0,1],
 * [1,1,0],
 * [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 */

//brute force solution
object Solution {
  def countSquares(matrix: Array[Array[Int]]): Int = {
    val maxX = matrix(0).length
    val maxY = matrix.length
    val maxSide = maxX max maxY
    val list = for (side <- 0 until maxSide; x <- 0 until (maxX - side); y <- 0 until (maxY - side); if isAllOne(matrix, x, y, side)) yield 1
    list.size
  }

  def isAllOne(matrix: Array[Array[Int]], startX: Int, startY: Int, side: Int): Boolean =
    !(startX to startX + side).exists(x => (startY to startY + side).exists(y => matrix(y)(x) == 0))

}

//optimized solution O(x * y * 2)
object Solution2 {
  def countSquares(matrix: Array[Array[Int]]): Int = {
    val maxX = matrix(0).length
    val maxY = matrix.length
    val res = Array.fill(maxY)(Array.fill(maxX)(0))
    for (x <- 0 until maxX; y <- 0 until maxY; if matrix(y)(x) == 1) {
      res(y)(x) = if (x != 0 && y != 0) ((res(y - 1)(x) min res(y - 1)(x - 1)) min res(y)(x - 1)) + 1 else 1
    }
    res.foldLeft(0)((acc, rang) => acc + rang.sum)
  }
}

//optimized solution+ O(x * y)
object Solution3 {
  def countSquares(matrix: Array[Array[Int]]): Int = {
    val maxX = matrix(0).length
    val maxY = matrix.length
    val res = Array.fill(maxY)(Array.fill(maxX)(0))
    var total = 0
    for (x <- 0 until maxX; y <- 0 until maxY; if matrix(y)(x) == 1) {
      res(y)(x) = if (x != 0 && y != 0) ((res(y - 1)(x) min res(y - 1)(x - 1)) min res(y)(x - 1)) + 1 else 1
      total += res(y)(x)
    }
    total
  }
}
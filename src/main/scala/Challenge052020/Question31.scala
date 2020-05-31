package Challenge052020

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3346/
 *
 * Edit Distance
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 */
class Question31 {
  //Dynamic programming solution
  object Solution {
    def minDistance(word1: String, word2: String): Int = {
      val (l1, l2) = (word1.length, word2.length)
      val dp = Array.ofDim[Int](l1 + 1, l2 + 1)
      for (i <- 0 to l1) { dp(i)(0) = i }
      for (j <- 0 to l2) { dp(0)(j) = j }
      for (i <- 0 until l1; j <- 0 until l2) {
        if (word1(i) == word2(j)) dp(i + 1)(j + 1) = dp(i)(j)
        else dp(i + 1)(j + 1) = (dp(i)(j) min (dp(i)(j + 1) min dp(i + 1)(j))) + 1
      }
      dp(l1)(l2)
    }
  }

}

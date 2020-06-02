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
  //Dynamic programming tabulation
  object Solution {
    def minDistance(word1: String, word2: String): Int = {
      val (l1, l2) = (word1.length, word2.length)
      val dp = Array.ofDim[Int](l1 + 1, l2 + 1)
      for (i <- 0 to l1) { dp(i)(0) = i } //init base case: j == 0
      for (j <- 0 to l2) { dp(0)(j) = j } //init base case: i == 0
      for (i <- 0 until l1; j <- 0 until l2) {
        if (word1(i) == word2(j)) dp(i + 1)(j + 1) = dp(i)(j)
        else dp(i + 1)(j + 1) = (dp(i)(j) min (dp(i)(j + 1) min dp(i + 1)(j))) + 1
      }
      dp(l1)(l2)
    }
  }

  //dynamic programming memoization
  object Solution2 {
    def minDistance(word1: String, word2: String): Int = {
      //memory notebook
      val memo = scala.collection.mutable.HashMap.empty[(Int, Int), Int]
      def dp(i: Int, j: Int): Int = {
        memo.get((i, j)) match {
          case Some(v) => v
          case None => {
            //base case, if one string reach the head, we count the rest length of another string
            if (i < 0) j + 1
            else if (j < 0) i + 1
            else {
              val res = {
                //if the character in the string are the same, we skip
                if (word1(i) == word2(j)) dp(i - 1, j - 1)
                //take the minimize operations among insert/remove/replace
                else (dp(i - 1, j - 1) // replace
                  min (dp(i, j - 1) // insert
                    min dp(i - 1, j)) // remove
                ) + 1
              }
              //memoize result 
              memo += ((i, j) -> res)
              res
            }
          }
        }
      }
      //begin from the last characters
      dp(word1.length - 1, word2.length - 1)
    }
  }

}

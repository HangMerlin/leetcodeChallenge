package Challenge052020

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3343/
 *
 * Counting Bits
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 */
class Question28 {

  object Solution {
    def countBits(num: Int): Array[Int] = {
      val res = Array.fill(num + 1)(0)
      for (i <- 0 to num) {
        res(i) = countOne(i)
      }
      res
    }

    def countOne(num: Int): Int = {
      var count = 0
      var rest = num
      while (rest > 1) {
        count += rest % 2
        rest = rest / 2
      }
      count + rest
    }
  }

  object Solution2 {
    def countBits(num: Int): Array[Int] = Range(0, num + 1).map(Solution.countOne).toArray
  }

}
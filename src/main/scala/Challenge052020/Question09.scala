package Challenge052020

/**
  * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3324/
  *
  * Valid Perfect Square
  * Given a positive integer num, write a function which returns True if num is a perfect square else False.
  *
  * Note: Do not use any built-in library function such as sqrt.
  *
  * Example 1:
  *
  * Input: 16
  * Output: true
  * Example 2:
  *
  * Input: 14
  * Output: false
  */
object Solution {
  def isPerfectSquare(num: Int): Boolean = isPerfectSquareWithRange(num, (0, 46341))

  def isPerfectSquareWithRange(num: Int, range: (Int, Int)): Boolean = {
    if (range._2 - range._1 < 2) false
    else {
      val mid = (range._1 + range._2) / 2
      val midSqr = mid * mid
      if (midSqr == num) true
      else isPerfectSquareWithRange(num, if (midSqr > num) (range._1, mid) else (mid, range._2))
    }
  }
}
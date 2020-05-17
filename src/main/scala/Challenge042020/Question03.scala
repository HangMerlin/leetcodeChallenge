package Challenge042020

/**
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3285/
 *
 * Maximum Subarray
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
object Solution {
  def maxSubArray(nums: Array[Int]): Int = maxSubArrayFrom(nums, 0, nums(0))

  def maxSubArrayFrom(nums: Array[Int], from: Int, knownMaxSum: Int): Int = {
    if (from == nums.length) knownMaxSum
    else {
      var sum = nums(from)
      var maxSum = sum
      var i = from + 1
      while (i < nums.length && sum > 0) {
        sum += nums(i)
        maxSum = maxSum max sum
        i += 1
      }
      maxSubArrayFrom(nums, i, knownMaxSum max maxSum)
    }
  }

}

object Solution2 {
  def maxSubArray(nums: Array[Int]): Int = {
    val (_, m) = nums.foldLeft((0, Int.MinValue))((acc, n) => {
      val sum = (acc._1 max 0) + n
      val cur = sum max acc._2
      (sum, cur)
    })
    m
  }
}

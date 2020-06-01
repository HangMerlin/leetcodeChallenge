package Challenge052020

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3327/
 *
 * Single Element in a Sorted Array
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 */
class Question12 {

  // 2*O(n)
  object Solution1 {
    def singleNonDuplicate(nums: Array[Int]): Int = nums.groupBy(p => p).find(_._2.length == 1).get._1
  }

  // O(n)
  object Solution2 {
    def singleNonDuplicate(nums: Array[Int]): Int = nums.reduce((a, b) => a ^ b)
  }

  // O(log(n))
  object Solution3 {
    def singleNonDuplicate(nums: Array[Int]): Int = {

      def singleNonDuplicateByRange(start: Int, end: Int): Int = {
        if (start == end) nums(start)
        else {
          val mid = start + (end - start) / 2
          val midValue = nums(mid)
          val isLeftOdd = (mid - start) % 2 == 0
          if (midValue == nums(mid - 1)) {
            if (isLeftOdd) singleNonDuplicateByRange(start, mid - 2)
            else singleNonDuplicateByRange(mid + 1, end)
          } else if (midValue == nums(mid + 1)) {
            if (isLeftOdd) singleNonDuplicateByRange(mid + 2, end)
            else singleNonDuplicateByRange(start, mid - 1)
          } else {
            midValue
          }
        }
      }

      singleNonDuplicateByRange(0, nums.length - 1)
    }

  }

}

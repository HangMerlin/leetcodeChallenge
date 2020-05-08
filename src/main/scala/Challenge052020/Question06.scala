package Challenge052020

/**
  * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3321/
  * Majority Element
  * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
  *
  * You may assume that the array is non-empty and the majority element always exist in the array.
  *
  * Example 1:
  *
  * Input: [3,2,3]
  * Output: 3
  * Example 2:
  *
  * Input: [2,2,1,1,1,2,2]
  * Output: 2
  */
object Solution {
  def majorityElement(nums: Array[Int]): Int = {
    val map = scala.collection.mutable.HashMap.empty[Int, Int]
    var found = false
    var index = 0
    var foundNumber = nums(0)
    while (!found && index < nums.length){
      val num = nums(index)
      map.get(num) match {
        case None => map.put(num, 1)
        case _ => {
          val repeatTime = map(num) + 1
          if (repeatTime > nums.length / 2) {
            found = true
            foundNumber = num
          }
          map.put(num, repeatTime)
        }
      }
      index = index + 1
    }
    foundNumber
  }
}

package Challenge052020

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3333/
 *
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
 *
 *
 *
 * Example 1:
 *
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 *
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *
 *
 * Note:
 *
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 */
//almost the same as Question 17 , we use exists instead of filter to find the first permutation
object Solution {
  import scala.collection.mutable._

  def checkInclusion(s1: String, s2: String): Boolean = {
    val diffMap = HashMap.empty[Char, Int]
    s1.foreach(updateMap(diffMap, _, 1))

    (0 until s2.length).toList.exists(index => {
      if (index >= s1.length) updateMap(diffMap, s2(index - s1.length), 1)
      updateMap(diffMap, s2(index), -1)
      diffMap.isEmpty
    })
  }

  def updateMap(map: HashMap[Char, Int], char: Char, incrementer: Int): Unit =
    map.get(char) match {
      case Some(number) if number + incrementer == 0 => map -= char
      case Some(number)                              => map += (char -> (number + incrementer))
      case None                                      => map += (char -> incrementer)
    }
}

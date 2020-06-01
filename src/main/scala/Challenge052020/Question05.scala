package Challenge052020

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3320/
 * First Unique Character in a String
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
class Question05 {

  object Solution {
    def firstUniqChar(s: String): Int = {
      val letterMap = scala.collection.mutable.HashMap.empty[Char, (Int, Boolean)]
      var repeatingCharCount = 0
      var index = 0
      val chars = s.toCharArray
      val length = chars.length
      while (index < length && repeatingCharCount < 26) {
        val char = chars(index)
        letterMap.get(char) match {
          case None => letterMap.put(char, (index, true))
          case Some(v) => {
            letterMap.put(char, (v._1, false))
            if (v._2) repeatingCharCount = repeatingCharCount + 1
          }
        }
        index = index + 1
      }
      if (repeatingCharCount == 26) -1
      else {
        val filteredMap = letterMap.filter(_._2._2)
        if (filteredMap.isEmpty) -1
        else filteredMap.minBy(_._2._1)._2._1
      }
    }
  }
}

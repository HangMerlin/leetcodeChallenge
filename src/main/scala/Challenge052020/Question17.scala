package Challenge052020

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3332/
 *
 * Find All Anagrams in a String
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 *
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 *
 * The order of output does not matter.
 *
 * Example 1:
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 *
 * Output:
 * [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *
 * Input:
 * s: "abab" p: "ab"
 *
 * Output:
 * [0, 1, 2]
 *
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
// for small & simple dataset, exception:  "memory limit exceeded" when s & p are both too long O((n - m) * m)
object Solution1 {
  def findAnagrams(s: String, p: String): List[Int] = {
    val sortedP = p.sorted
    (0 to s.length - sortedP.length).filter(index => isAnagram(s.substring(index, index + sortedP.length), sortedP)).toList
  }

  def isAnagram(textA: String, sortedTextB: String): Boolean = textA.length == sortedTextB.length && textA.sorted == sortedTextB
}

object Solution2 {
  def findAnagrams(s: String, p: String): List[Int] = {
    val charMapP = p.grou
  }
}
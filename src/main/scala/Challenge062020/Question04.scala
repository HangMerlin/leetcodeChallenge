package Challenge062020

/**
 * Reverse String
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
class Question04 {

  object Solution {
    def reverseString(s: Array[Char]): Unit = {
      var index = 0
      //not necessary to revert middle char in a odd array
      while (index < (s.length.toDouble - 1) / 2) {
        val tmp = s(index)
        s(index) = s(s.length - 1 - index)
        s(s.length - 1 - index) = tmp
        index += 1
      }
    }
  }

}

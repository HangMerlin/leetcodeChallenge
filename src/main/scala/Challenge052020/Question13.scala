package Challenge052020

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3328/
 *
 * Remove K Digits
 * Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */
class Question13 {

  object Solution {
    def removeKdigits(num: String, k: Int): String =
      if (num.length == k) "0"
      else trimLeftZero(removeKdigitsWithAcc(num, num.length - k, ""))

    def removeKdigitsWithAcc(num: String, restNumberLength: Int, acc: String): String = {
      if (restNumberLength == 0) acc
      else if (num.length == restNumberLength) acc + num
      else {
        val rightIndexEnd = num.length - restNumberLength
        var smallestNumberIndex = 0
        var smallestNumber = num.head
        var index = 1
        while (index <= rightIndexEnd && smallestNumber != '0') {
          if (num(index).toInt < smallestNumber.toInt) {
            smallestNumber = num(index)
            smallestNumberIndex = index
          }
          index += 1
        }
        val newAcc = acc + smallestNumber
        removeKdigitsWithAcc(num.drop(smallestNumberIndex + 1), restNumberLength - 1, newAcc)
      }
    }

    def trimLeftZero(num: String): String = {
      val leftZeroDroppedNumber = num.dropWhile(_ == '0')
      if (leftZeroDroppedNumber.isEmpty) "0" else leftZeroDroppedNumber
    }

  }

}

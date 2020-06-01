package Challenge052020

/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 *
 *
 * Example 1:
 *
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 *
 *
 * Example 2:
 *
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 *
 *
 * Note:
 *
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 */

class Question04 {

  object Solution1 {
    def findComplement(num: Int): Int = {
      num
        .toBinaryString
        .map(c => if (c == '1') '0' else '1')
        .dropWhile(_ != '1')
        .reverse
        .zipWithIndex
        .map(t => t._1.toString.toInt * math.pow(2, t._2))
        .sum
        .toInt

    }
  }

  //with java function Integer.parseInt
  object Solution2 {
    def findComplement(num: Int): Int = Integer.parseInt(num.toBinaryString.map(c => if (c == '1') '0' else '1'), 2)
  }

  object Solution3 {
    def findComplement(num: Int): Int = {
      var mask = 1
      while (mask < num) {
        mask = (mask << 1) + 1
      }
      num ^ mask
    }
  }

}

package Challenge052020
/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/534/week-1-may-1st-may-7th/3318/
 *
 * Ransom Note
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
class Question03 {

  object Solution1 {
    def canConstruct(ransomNote: String, magazine: String): Boolean = canConstructRec(ransomNote, magazine, rIndex = 0, alwaysPresent = true)

    def canConstructRec(ransomNote: String, magazine: String, rIndex: Int, alwaysPresent: Boolean): Boolean = {
      if (!alwaysPresent) false
      else if (ransomNote.length <= rIndex) true
      else {
        var mIndex = 0
        while (mIndex <= magazine.length - 1 && ransomNote(rIndex) != magazine(mIndex)) mIndex = mIndex + 1
        canConstructRec(ransomNote, removeByIndex(magazine, mIndex), rIndex + 1, !(mIndex == magazine.length))
      }
    }

    def removeByIndex(list: String, index: Int): String = list.take(index) ++ list.drop(index + 1)

  }

  //solution more "scala"
  object Solution2 {
    def canConstruct(ransomNote: String, magazine: String): Boolean =
      magazine.diff(ransomNote).length == magazine.length - ransomNote.length
  }
}

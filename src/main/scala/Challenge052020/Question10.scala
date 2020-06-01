package Challenge052020

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3325/
 *
 * Find the Town Judge
 * In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 *
 * Example 2:
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 * Example 3:
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 * Example 4:
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 *
 * Example 5:
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 * Note:
 *
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 */
class Question10 {

  object Solution {
    def findJudge(N: Int, trust: Array[Array[Int]]): Int = {
      // number of people who trust same people
      val beTrusteds = Array.fill[Int](N)(0)
      // people who trust other or others
      val doTrusts = Array.fill[Boolean](N)(false)

      for (t <- trust) {
        // doTrust "trust" beTrusted
        val beTrusted = t(1)
        val doTrust = t(0)
        beTrusteds(beTrusted - 1) += 1
        doTrusts(doTrust - 1) = true
      }

      doTrusts
        .zip(beTrusteds)
        .zipWithIndex
        .find { case ((doTrust, beTrusted), _) => !doTrust && beTrusted == N - 1 }
        .map(_._2 + 1)
        .getOrElse(-1)
    }
  }

  // 1 array solution
  object Solution2 {
    def findJudge(N: Int, trust: Array[Array[Int]]): Int = {
      // difference between numberBeTrusts and numberTrustOthers
      val diffTrusts = Array.fill[Int](N)(0)

      for (t <- trust) {
        val beTrusted = t(1)
        val doTrust = t(0)
        diffTrusts(beTrusted - 1) += 1
        diffTrusts(doTrust - 1) -= 1
      }

      diffTrusts
        .zipWithIndex
        .find(_._1 == N - 1)
        .map(_._2 + 1)
        .getOrElse(-1)

      // faster with var & while loop, but not very scala
      //    var maybeJudge = -1
      //    var index = 0
      //    while(maybeJudge == -1 && index < diffTrusts.length){
      //      val trusted = diffTrusts(index)
      //      if (trusted == N - 1) maybeJudge = index + 1
      //      index += 1
      //    }
      //    maybeJudge
    }
  }

}


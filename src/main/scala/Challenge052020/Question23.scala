package Challenge052020

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3338/
 *
 * Interval List Intersections
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 *
 * Return the intersection of these two interval lists.
 *
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.
 * For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 *
 */
object Solution {
  def intervalIntersection(A: Array[Array[Int]], B: Array[Array[Int]]): Array[Array[Int]] = {
    import scala.collection.mutable
    var res = mutable.Seq.empty[Array[Int]]
    var indexA = 0
    var indexB = 0
    while (indexA < A.length && indexB < B.length) {
      val (intAStart, intAEnd) = (A(indexA)(0), A(indexA)(1))
      val (intBStart, intBEnd) = (B(indexB)(0), B(indexB)(1))
      val start = intAStart max intBStart
      val end = intAEnd min intBEnd
      if (intAEnd >= intBEnd) indexB += 1
      if (intBEnd >= intAEnd) indexA += 1
      if (end >= start) res = res :+ Array(start, end)
    }
    res.toArray
  }
}

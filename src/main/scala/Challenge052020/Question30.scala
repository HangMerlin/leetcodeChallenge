package Challenge052020

/**
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/538/week-5-may-29th-may-31st/3345/
 * K Closest Points to Origin
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 */
class Question30 {

  //simplest solution O(n * log(n))
  object Solution {
    def kClosest(points: Array[Array[Int]], K: Int): Array[Array[Int]] = points.sortBy(p => p(0) * p(0) + p(1) * p(1)).take(K)
  }

  //QuickSelect solution with random pivot O(n) to 0(n*n)
  object Solution2 {
    def kClosest(points: Array[Array[Int]], K: Int): Array[Array[Int]] =
      quickSelect(points, 0, points.length - 1, K)

    def quickSelect(points: Array[Array[Int]], start: Int, end: Int, K: Int): Array[Array[Int]] = {
      val pivot = scala.util.Random.nextInt(end - start + 1) + start
      var i = start
      var j = start
      swap(points, pivot, end)

      while (j < end) {
        if (SqAddition(points(j)) <= SqAddition(points(end))) {
          swap(points, i, j)
          i += 1
        }
        j += 1
      }

      swap(points, i, j)
      if (K == i + 1 - start) points.take(i + 1)
      else if (K > i + 1 - start) quickSelect(points, i + 1, end, K - i - 1 + start)
      else quickSelect(points, start, i - 1, K)
    }

    def swap(points: Array[Array[Int]], i: Int, j: Int): Unit = {
      val tmp = points(i)
      points(i) = points(j)
      points(j) = tmp
    }

    def SqAddition(point: Array[Int]): Int = point(0) * point(0) + point(1) * point(1)
  }

}

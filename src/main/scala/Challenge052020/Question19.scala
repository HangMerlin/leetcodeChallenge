package Challenge052020

/**
 * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/
 *
 * Online Stock Span
 * Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
 *
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards)
 * for which the price of the stock was less than or equal to today's price.
 *
 * For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
 *
 * Your StockSpanner object will be instantiated and called as such:
 * var obj = new StockSpanner()
 * var param_1 = obj.next(price)
 */
// Solution 8000+ ms
class StockSpanner() {
  import scala.collection.mutable
  var stocks = mutable.Seq.empty[Int]
  def next(price: Int): Int = {
    stocks = stocks.+:(price)
    stocks.indices.find(i => stocks(i) > price).getOrElse(stocks.length)
  }
}

// Solution 2000+ ms
class StockSpanner2() {
  import scala.collection.mutable
  var stocks = mutable.Seq.empty[(Int, Int)]
  def next(price: Int): Int = {
    var weight = 1
    while (stocks.nonEmpty && stocks.head._1 <= price) {
      weight += stocks.head._2
      stocks = stocks.tail
    }
    stocks = stocks.+:(price, weight)
    weight
  }
}

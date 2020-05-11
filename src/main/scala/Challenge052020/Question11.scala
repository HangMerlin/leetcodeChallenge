package Challenge052020

/**
  * https://leetcode.com/explore/featured/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/
  * Flood Fill
  * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).
  *
  * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.
  *
  * To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.
  *
  * At the end, return the modified image.
  *
  * Example 1:
  * Input:
  * image = [[1,1,1],[1,1,0],[1,0,1]]
  * sr = 1, sc = 1, newColor = 2
  * Output: [[2,2,2],[2,2,0],[2,0,1]]
  * Explanation:
  * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
  * by a path of the same color as the starting pixel are colored with the new color.
  * Note the bottom corner is not colored 2, because it is not 4-directionally connected
  * to the starting pixel.
  * Note:
  *
  * The length of image and image[0] will be in the range [1, 50].
  * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
  * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
  *
  * Hide Hint #1
  * Write a recursive function that paints the pixel if it's the correct color, then recurses on neighboring pixels.
  */
object Solution {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    fill(image, sr, sc, image(sr)(sc), newColor)
    image
  }

  def fill(image: Array[Array[Int]], r: Int, c: Int, startColor: Int, newColor: Int): Unit = {
    val oldColor = image(r)(c)
    if (oldColor == startColor && oldColor != newColor) {
      image(r)(c) = newColor
      if (r - 1 >= 0) fill(image, r - 1, c, startColor, newColor)
      if (c - 1 >= 0) fill(image, r, c - 1, startColor, newColor)
      if (r + 1 < image.length) fill(image, r + 1, c, startColor, newColor)
      if (c + 1 < image(0).length) fill(image, r, c + 1, startColor, newColor)
    }
  }
}


object Solution2 {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, newColor: Int): Array[Array[Int]] = {
    val startColor = image(sr)(sc)

    def fill(r: Int, c: Int): Unit = {
      val oldColor = image(r)(c)
      if (oldColor == startColor && oldColor != newColor) {
        image(r)(c) = newColor
        if (r - 1 >= 0) fill(r - 1, c)
        if (c - 1 >= 0) fill(r, c - 1)
        if (r + 1 < image.length) fill(r + 1, c)
        if (c + 1 < image(0).length) fill(r, c + 1)
      }
    }

    fill(sr, sc)
    image
  }
}

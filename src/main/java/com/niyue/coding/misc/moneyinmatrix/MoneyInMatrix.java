package com.niyue.coding.misc.moneyinmatrix;

/*
 * http://www.mitbbs.com/article_t/JobHunting/32322891.html
 * Given a NxM matrix. Each grid in the matrix has certain amount of money in it.
 * There are two people in (0, 0), and they would like to move to (N, M), and they can move to either up or right direction.
 * Each move, the person will fetch the amount of money in the grid he/she goes through.
 * How can we get a path for each of the person so that the total amount of money they fetch is maximum?
 * 
 * Define f(x1, y1, x2, y2) as the total amount of money they can get when p1 is in (x1, y1) and p2 is in (x2, y2).
 * f(x1, y1, x2, y2) = max(
 * 	f(x1 + 1, y1, x2 + 1, y2)
 *  f(x1 + 1, y1, x2, y2 + 1)
 *  f(x1, y1 + 1, x2, y2 + 1)
 * 	f(x1, y1 + 1, x2 + 1, y2)
 * )
 * Use a four dimensional bottom up DP can solve this problem with (N^2 * M^2)
 */
public class MoneyInMatrix {

}

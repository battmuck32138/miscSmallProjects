package hw2;

import static org.junit.Assert.*;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;



//row order (think of rows as layers to drill through)
//0
//1
//2
//3
//4
// 0 1 2 3 4 column order is same as standard x value.
public class Percolation {

    private int N;

    private int numOpen;
    private boolean[][] stateOfSiteArr;
    private WeightedQuickUnionUF uf;
    private WeightedQuickUnionUF aux;
    private int topSentinel;
    private int bottomSentinel;


    // create N-by-N grid, with all sites initially blocked
    public Percolation(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }
        this.N = N;
        this.stateOfSiteArr = new boolean[N][N];
        this.uf = new WeightedQuickUnionUF(N * N + 2);
        this.aux = new WeightedQuickUnionUF(N * N + 1);
        this.topSentinel = N * N;
        this.bottomSentinel = N * N + 1;
        this.numOpen = 0;
    }


    //open the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!stateOfSiteArr[row][col]) {
            int thisId = gridId(row, col);
            int adjacentId;

            if (row == 0) {
                uf.union(thisId, topSentinel);
                aux.union(thisId, topSentinel);
            }

            if (row == N - 1) {
                uf.union(thisId, bottomSentinel);
            }

            if (row != 0 && stateOfSiteArr[row - 1][col]) {
                adjacentId = gridId(row - 1, col);
                uf.union(thisId, adjacentId);
                aux.union(thisId, adjacentId);
            }
            if (row != N - 1 && stateOfSiteArr[row + 1][col]) {
                adjacentId = gridId(row + 1, col);
                uf.union(thisId, adjacentId);
                aux.union(thisId, adjacentId);
            }
            if (col != 0 && stateOfSiteArr[row][col - 1]) {
                adjacentId = gridId(row, col - 1);
                uf.union(thisId, adjacentId);
                aux.union(thisId, adjacentId);
            }
            if (col != N - 1 && stateOfSiteArr[row][col + 1]) {
                adjacentId = gridId(row, col + 1);
                uf.union(thisId, adjacentId);
                aux.union(thisId, adjacentId);
            }
            stateOfSiteArr[row][col] = true;
            numOpen++;
        }
    }


    //returns an int assigned to a grid location such that:
    // 0  1  2  3
    // 4  5  6  7
    // 8  9 10 11
    //12 13 14 15
    private int gridId(int row, int col) {
        return row * N + col;
    }


    // is the site (row, col) open?
    //backwards parameters (y , x)
    public boolean isOpen(int row, int col) {
        return stateOfSiteArr[row][col];
    }


    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        int thisId = gridId(row, col);
        return aux.connected(thisId, topSentinel);
    }


    // number of open sites
    public int numberOfOpenSites() {
        return numOpen;
    }


    // does the system percolate?
    public boolean percolates() {
        return uf.connected(topSentinel, bottomSentinel);
    }


    // use for unit testing (not required)
    public static void main(String[] args) {

        Percolation p = new Percolation(5);
        PercolationFactory pf = new PercolationFactory();
        PercolationStats ps = new PercolationStats(20, 100, pf);

        System.out.println(ps.mean());
        System.out.println(ps.stddev());
        System.out.println(ps.confidenceLow());
        System.out.println(ps.confidenceHigh());

        assertTrue(p.gridId(1, 4) == 9);
        assertTrue(p.gridId(2, 3) == 13);
        assertTrue(p.gridId(4, 4) == 24);
        assertTrue(p.gridId(3, 0) == 15);
    }




}

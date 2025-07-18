package com.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
        // System.out.println(pathRetDiagonalList("", 3, 3));
        boolean[][] board = {
                { true, true, true },
                { true, true, true },
                { true, true, true },
        };
        // pathObstacles("", board, 0, 0);
        // allPath("", board, 0, 0);
        int[][] path = new int[board.length][board[0].length];
        allPathPrint("", board, 0, 0, path, 1);
    }

    static void path(String p, int r, int c) {
        if (r == 1 || c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1)
            path(p + "D", r - 1, c);
        if (c > 1)
            path(p + "R", r, c - 1);
    }

    public static List<String> pathRet(String p, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> base = new ArrayList<>();
            base.add(p);
            return base;
        }
        List<String> list = new ArrayList<>();
        if (r > 1)
            // whatever answer you are getting from all the recursion calls, add all of them
            // to the local list.
            list.addAll(pathRet(p + "D", r - 1, c));
        if (c > 1)
            // whatever answer you are getting from all the recursion calls, add all of them
            // to the local list.
            list.addAll(pathRet(p + "R", r, c - 1));
        return list;
    }

    public static List<String> pathRetDiagonalList(String p, int r, int c) {
        if (r == 1 && c == 1) {
            List<String> base = new ArrayList<>();
            base.add(p);
            return base;
        }
        List<String> list = new ArrayList<>();
        if (r > 1 && c > 1) {
            list.addAll(pathRetDiagonalList(p + "D", r - 1, c - 1));
        }
        if (r > 1)
            // whatever answer you are getting from all the recursion calls, add all of them
            // to the local list.
            list.addAll(pathRetDiagonalList(p + "V", r - 1, c));
        if (c > 1)
            // whatever answer you are getting from all the recursion calls, add all of them
            // to the local list.
            list.addAll(pathRetDiagonalList(p + "H", r, c - 1));
        return list;
    }

    static int count(int r, int c) {
        if (r == 1 || c == 1) {
            return 1;
        }
        return count(r - 1, c) + count(r, c - 1);
    }

    static void pathObstacles(String p, boolean[][] maze, int r, int c) {
        if (!maze[r][c]) {
            return;
        }
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (r < maze.length - 1)
            pathObstacles(p + "D", maze, r + 1, c);
        if (c < maze[0].length - 1)
            pathObstacles(p + "R", maze, r, c + 1);
    }

    static void allPath(String p, boolean[][] maze, int r, int c) {
        if (!maze[r][c]) {
            return;
        }
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        maze[r][c] = false;
        if (r < maze.length - 1)
            allPath(p + "D", maze, r + 1, c);
        if (c < maze[0].length - 1)
            allPath(p + "R", maze, r, c + 1);
        if (r > 0)
            allPath(p + "U", maze, r - 1, c);
        if (c > 0)
            allPath(p + "L", maze, r, c - 1);
        maze[r][c] = true;
    }

    static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        if (!maze[r][c]) {
            return;
        }
        if (r == maze.length - 1 && c == maze[0].length - 1) {
            path[r][c] = step;
            for (int[] num : path) {
                System.out.println(Arrays.toString(num));
            }
            System.out.println(p);
            return;
        }
        maze[r][c] = false;
        path[r][c] = step;
        if (r < maze.length - 1)
            allPathPrint(p + "D", maze, r + 1, c, path, step + 1);
        if (c < maze[0].length - 1)
            allPathPrint(p + "R", maze, r, c + 1, path, step + 1);
        if (r > 0)
            allPathPrint(p + "U", maze, r - 1, c, path, step + 1);
        if (c > 0)
            allPathPrint(p + "L", maze, r, c - 1, path, step + 1);
        maze[r][c] = true;
    }
}

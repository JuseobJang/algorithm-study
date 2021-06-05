package Baekjoon.StackAndQueue.BOJ3190;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int size; // 사각형사이즈
    static int snakeSize; // 뱀 사이즈

    static int appleCnt; // 사과 개수
    static Positions[] applePos; // 사과 위치

    static int directCnt; // 방향전환 횟수
    static String[] directChange; // 방향

    public static void initialization() {
        Scanner sc = new Scanner(System.in);

        size = sc.nextInt();

        appleCnt = sc.nextInt();
        applePos = new Positions[appleCnt];

        for (int i = 0; i < appleCnt; i++) {
            applePos[i] = new Positions(0, 0);
            applePos[i].y = sc.nextInt() - 1;
            applePos[i].x = sc.nextInt() - 1;

            applePos[i].eating = true;
        }

        directCnt = sc.nextInt();
        directChange = new String[10000];

        for (int i = 0; i < directCnt; i++) {
            directChange[sc.nextInt()] = sc.next();
        }
    }

    public static boolean appleEatCheck(Positions head) {

        for (int i = 0; i < appleCnt; i++) {
            if (head.x == applePos[i].x && head.y == applePos[i].y && applePos[i].eating == true) {
                applePos[i].eating = false;
                return true; // 이제 먹음
            }
        }
        return false; // 전에 먹었거나 애초에 없음
    }

    public static int snake() {
        Iterator<Positions> itr;
        Queue<Positions> snake = new LinkedList();
        Positions head = new Positions(0, 0);

        int direct = 0;
        int count = 0;

        snake.add(new Positions(0, 0));

        while (true) {
            System.out.println("x : " + head.x + " y : " + head.y);
            // 방향 설정
            if (directChange[count] != null) {
                if (directChange[count].equals("D")) {
                    direct = direct % 4 + 1;
                    if (direct > 3)
                        direct = 0;
                } else if (directChange[count].equals("L")) {
                    direct = direct % 4 - 1;
                    if (direct < 0)
                        direct = 3;
                }
            }
            count++;
            if (count == 10000) {
                return count;
            }

            // 한칸이동
            int nX = head.x;
            int nY = head.y;

            if (direct == 0) {
                nX++;
            } else if (direct == 1) {
                nY++;
            } else if (direct == 2) {
                nX--;
            } else {
                nY--;
            }

            head.x = nX;
            head.y = nY;

            // 종료 조건
            itr = snake.iterator();
            while (itr.hasNext()) {
                Positions pos = itr.next();
                if (head.x == pos.x && head.y == pos.y)
                    return count;
            }
            if (head.x >= size || head.y >= size || head.x < 0 || head.y < 0)
                return count;

            // 사과 먹었는지 체크
            if (appleEatCheck(head)) {
            } else
                snake.poll();

            snake.add(new Positions(nX, nY));

        }
    }

    public static void main(String[] args) {
        initialization();
        System.out.print(snake());
    }
}

class Positions {
    public int x;
    public int y;
    public boolean eating = false;

    Positions(int a, int b) {
        x = a;
        y = b;
    }
}

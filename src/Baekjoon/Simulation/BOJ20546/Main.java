package Baekjoon.Simulation.BOJ20546;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static int seed;
    static int[] day;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        seed = Integer.parseInt(br.readLine());
        day = new int[14];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < 14; i++) {
            day[i] = Integer.parseInt(input[i]);
        }

        Person jun = new Person("BNP", seed, 0);
        Person seong = new Person("TIMING", seed, 0);

        for (int i = 0; i < 14; i++) {
            jun.buy(day[i]);
            if (i > 2 && day[i] > day[i - 1] && day[i - 1] > day[i - 2] && day[i - 2] > day[i - 3]) {
                seong.sell(day[i]);
            } else if (i > 2 && day[i] < day[i - 1] && day[i - 1] < day[i - 2] && day[i - 2] < day[i - 3]) {
                seong.buy(day[i]);
            }
        }

        if (jun.total(day[13]) > seong.total(day[13])) {
            bw.write(jun.strategy);
        } else if (jun.total(day[13]) < seong.total(day[13])) {
            bw.write(seong.strategy);
        } else {
            bw.write("SAMESAME");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}

class Person {
    public String strategy;
    public int money;
    public int cnt;

    public Person(String strategy, int money, int cnt) {
        this.strategy = strategy;
        this.money = money;
        this.cnt = cnt;
    }

    public void buy(int day_price) {
        while (day_price <= money) {
            this.cnt++;
            this.money -= day_price;
        }
    }

    public void sell(int day_price) {
        while (cnt > 0) {
            this.cnt--;
            this.money += day_price;
        }
    }

    public int total(int day_price) {
        return (day_price * cnt) + money;
    }
}

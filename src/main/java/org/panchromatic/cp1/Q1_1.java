package org.panchromatic.cp1;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Q1_1 {
    public static void problem1(Path path) {
        Stack<String> stack = new Stack<>();
        var file = path.toFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String s = reader.readLine();
            while (s != null) {
                stack.push(s);
                s = reader.readLine();
            }

            while (!stack.empty()) {
                System.out.println(stack.pop());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void problem2(Path path) {
        Stack<String> stack = new Stack<>();
        File file = path.toFile();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String s = reader.readLine();
            while (s != null) {

                while (s != null && stack.size() < 50) {
                    stack.push(s);
                    s = reader.readLine();
                }

                while (!stack.empty()) {
                    System.out.println(stack.pop());
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void problem3(Path path) {
        Deque<String> queue = new ArrayDeque<>(42);
        File file = path.toFile();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String s = reader.readLine();
            while (s != null) {
                if (queue.size() == 42 && s.isBlank()) {
                    String first = queue.getFirst();
                    System.out.println(first);
                }
                if (queue.size() >= 42) queue.removeFirst();

                queue.addLast(s);
                s = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void problem4(Path path) {
        HashSet<String> set = new HashSet<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));

            String s = reader.readLine();
            while (s != null) {
                if (!set.contains(s)) System.out.println(s);

                set.add(s);
                s = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void problem5(Path path) {
        HashSet<String> set = new HashSet<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));

            String s = reader.readLine();
            while (s != null) {
                if (set.contains(s)) System.out.println(s);

                set.add(s);
                s = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void problem6(Path path) {
        TreeSet<String> set = new TreeSet<>((s1, s2) -> 0);
    }
    public static void main(String[] args) {
        try {
            URI uri = Thread.currentThread().getContextClassLoader().getResource("cp1/testfile.txt").toURI();
            Path path = Paths.get(uri);
            System.out.println("Problem1.1_1");
            problem1(path);

            System.out.println("Problem1.1_2");
            problem2(path);

            uri = Thread.currentThread().getContextClassLoader().getResource("cp1/testfile_with_blank.txt").toURI();
            path = Paths.get(uri);

            System.out.println("Problem1.1_3");
            problem3(path);

            uri = Thread.currentThread().getContextClassLoader().getResource("cp1/testfile_with_duplicate.txt").toURI();
            path = Paths.get(uri);

            System.out.println("Problem1.1_4");
            problem4(path);

            System.out.println("Problem1.1_5");
            problem5(path);

        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}

/*
package org.example.java17;

*/
/*Java 17 introduced Pattern Matching for switch expressions and statements,
 which significantly enhances the expressiveness and readability of code when
 dealing with different types or values.
Here is an example demonstrating type patterns in a switch statement:*//*

public class SwitchPatternMatching {

        public static String describeObject(Object obj) {
            return switch (obj) {
                case Integer i -> "An Integer: " + i;
                case String s -> "A String: \"" + s + "\"";
                case Double d && (d > 0) -> "A positive Double: " + d; // Guarded pattern
                    case Double d -> "A non-positive Double: " + d;
                    case null -> "It's null";
                    default -> "An unknown type";
            };
        }

        public static void main(String[] args) {
            System.out.println(describeObject(10));
            System.out.println(describeObject("Hello Java 17"));
            System.out.println(describeObject(3.14));
            System.out.println(describeObject(-2.5));
            System.out.println(describeObject(null));
            System.out.println(describeObject(true));
        }
    }
*/

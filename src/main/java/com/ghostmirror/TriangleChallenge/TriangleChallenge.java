package com.ghostmirror.TriangleChallenge;

public class TriangleChallenge {
    public static void main(String[] args) {
        if(args.length == 0) {
            help();
            return;
        }
        if(args.length < 3 || args.length < 4) {
            System.out.println("Wrong arguments. See Help.");
            help();
            return;
        }
        Triangle t;
        try {
            t = TriangleFactory.createTriangle(args[0], args[1], args[2]);
        } catch (IllegalArgumentException e) {
            System.err.println("Wrong triangle data");
            System.err.println(e.getMessage());
            help();
            return;
        }
        if(args.length == 4) {
            try {
                System.out.println("Triangle Type: " + TriangleProperties.getTriangleType(t, Integer.parseInt(args[3])));
            } catch (NumberFormatException e) {
                System.err.println("Wrong argument precision, must be Integer value");
                System.err.println(e.getMessage());
                help();
            }
        } else {
            System.out.println("Triangle Type: " + TriangleProperties.getTriangleType(t));
            System.out.println("A size       : " + t.getA().toString());
            System.out.println("B size       : " + t.getB().toString());
            System.out.println("C size       : " + t.getC().toString());
        }
    }

    private static void help() {
        System.out.println("Use command line:");
        System.out.println("java -jar TriangleChallenge.jar sideA sideB sideC [precision]");
        System.out.println("    sideA, sideB, sideC - Triangle sides.");
        System.out.println("                          Any decimal number.");
        System.out.println("    precision           - The accuracy of the ratio(exponent) between the triangle sides.");
        System.out.println("                          Integer number.");
    }
}

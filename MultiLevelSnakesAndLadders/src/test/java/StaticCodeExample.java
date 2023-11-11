/*
 * Copyright © Kai Hofbauer – All Rights Reserved
 * 
 * EN
 * Unauthorized copying of this software, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by Kai Hofbauer kaihofbauer@icloud.com, October 2023
 * All components of this software that have not been newly developed (compilers, package sources and archives), as well as the development environment, have been expressly released by the manufacturers for commercial use.
 * The newly designed source code and its compilations, however, are newly created intellectual property of Kai Hofbauer for commercial use.
 * 
 * DE
 * Unerlaubtes Kopieren dieser Software, egal mit welchem Medium, ist strengstens verboten.
 * Proprietär und vertraulich
 * Geschrieben von Kai Hofbauer kaihofbauer@icloud.com, Oktober 2023
 * Alle nicht neu entwickelten Bestandteile (Compiler, Paketquellen und Archive) dieser Software, sowie die Entwicklungsumgebung sind von den Herstellern für die kommerzielle Nutzung ausdrücklich freigegeben.
 * Der neu entworfene Quellcode und seine Kompilierungen sind hingegen für den kommerziellen Gebrauch neu erschaffenes, geistiges Eigentum von Kai Hofbauer.
 * 
 * 
 * Verwendete Software:
 * •	Entwicklungsumgebung:		Apache NetBeans IDE 19	https://netbeans.apache.org/
 * •	Programmiersprache:		JAVA
 * •	JDK:				21			https://adoptium.net
 * 
 * 
 * © Kai Hofbauer – 2023
 */

/**
 * In this example we can see the ssequence in wich the code will be executed.
 *
 * @author Kai Hofbauer
 */
public class StaticCodeExample {

    private static final Object obj = obj();

    //This can be used to initialize static final variables when they throw a
    //Exception during initialization.
    static {
        System.out.println("in static block");
    }

    //This Classes constructor / Its own constructor
    public StaticCodeExample() {
        System.out.println("in const");
    }

    {
        System.out.println("in initialization block");
    }

    public static void main(String[] args) {
        System.out.println("in main method");
        StaticCodeExample block = new StaticCodeExample();
    }

    private static Object obj() {
        System.out.println("In static void, caused through variable init!");
        return new Object();
    }

}

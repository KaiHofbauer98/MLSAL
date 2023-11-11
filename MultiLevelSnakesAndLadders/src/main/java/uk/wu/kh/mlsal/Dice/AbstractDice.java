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
package uk.wu.kh.mlsal.Dice;

/**
 * <b>WREXHAM UNIVERSITY COM 648 2023</b>
 * <p>
 * This Interface needed to be created during the week 3 lesson during the
 * COM648 module on WU. The abstract dice should definde the characteristics of
 * a real dice.
 * </p>
 *
 * <p>
 * The Idea of what properties a dice could have can be found here:
 * <a href="https://en.wikipedia.org/wiki/Dice">
 * https://en.wikipedia.org/wiki/Dice</a>
 * </p>
 *
 * @author Kai Hofbauer
 */
public interface AbstractDice {

    /**
     * This abstract void sould set the UPPER_EYE value to a random generated
     * number between 1 and the SIDES value.
     */
    void roll_the_dice();

    /**
     * @return The amount of sides from this dice.
     */
    int getSides();

    /**
     * Set the amount of sides of this dice.
     *
     * @param sides
     * @throws java.lang.Exception The dices side count needs to be between 2 and 120!
     */
    void setSides(int sides) throws Exception;

    /**
     * @return The side of the dice which is on top.
     */
    int getUpperEye();

}

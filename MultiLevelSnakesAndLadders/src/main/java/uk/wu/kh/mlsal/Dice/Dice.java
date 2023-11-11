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
 * Implementation of the AbstractDice Interface.
 * </p>
 * 
 * @see AbstractDice
 * @author Kai Hofbauer
 */
public class Dice implements AbstractDice {

    /**
     * <p>
     * Referring to the Wikipedia article about dices, the number of sides a
     * human made dice can have is probably <i>not greater than 120</i>. This
     * natural number can fit into an integer.</p>
     */
    private int sides;

    /**
     * Before the dice isnt rolled at least once, there is no upper eye.
     * Theoretically we can generate a random value for the initial upper eye
     * value as well, because after getting a new dice in the your hands it will
     * have a upper eye vaule that is random to your mind. In this case we just
     * want to rill the dice first to get our first after-rolled upper eye.
     */
    private int upper_eye = 0;

    /**
     * Initialize the new dice with the amount of sides.
     *
     * @param sides
     * @throws java.lang.Exception
     */
    public Dice(int sides) throws Exception {
        setSides(sides);
    }

    @Override
    public void roll_the_dice() {
        //Implementatio of the thoughts in the AbstractDice with Java Math
        upper_eye = ((Double) (Math.random() * sides)).intValue() + 1;
    }

    @Override
    public int getSides() {
        return sides;
    }

    @Override
    public final void setSides(int sides) throws Exception {
        if (sides >= 2 && sides <= 120) {
            this.sides = sides;
        } else {
            throw new Exception("The dices side count needs to be between 2 and 120!");
        }
    }

    @Override
    public int getUpperEye() {
        return upper_eye;
    }

}

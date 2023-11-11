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
package uk.wu.kh.mlsal.History;

/**
 * The Movement symbolizes the process in the broadgame when the dice is rolled
 * and the ball needs to be moved. There is a Field where the Ball is lying on.
 * There is a next Field where the ball will be placed on after counting the
 * fields stepped over. After moving the ball logically the field can be one out
 * of three field types, two field types are leading the Ball to another Field.
 * To store the information of this particular action, my Program is creating a
 * object for every single movement.
 *
 * @author kai.hofbauer
 */
public interface AbstractMovement {

    /**
     *
     * @return The start Field object.
     */
    public Object getStart();

    /**
     *
     * @return the very end Field object.
     */
    public Object getEnd();

    /**
     *
     * @return The information if the player moved the Ball after rolling the
     * dice, maybe the dice fell to the ground or was not on a plain surface.
     */
    public boolean isBall_moved();

    /**
     * Sets the information if the player moved the Ball after rolling the dice.
     *
     * @param ball_moved
     */
    public void setBall_moved(boolean ball_moved);

    /**
     *
     * @return The objects class. It is not possible to get a subclass out of:
     * ArrayList.get(index).getClass(); The returning class object will always
     * be the class thats definded in: ArrayList"Field" - Field.
     */
    public Class getMvmtClass();

    /**
     *
     * @return The diced value from the dice for this movement.
     */
    public int getDice_upper_eye();

}

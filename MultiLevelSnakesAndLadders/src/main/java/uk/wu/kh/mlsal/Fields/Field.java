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
package uk.wu.kh.mlsal.Fields;

/**
 * The standard Field class only contains its own FieldNumber. If the ball is
 * placed on a standard Field nothing will happen. The subclasses inherit the
 * FieldNumber.
 *
 * @author Kai Hofbauer
 */
public class Field {

    /**
     * The number wich stands written on this broadgame field.
     */
    private final int FiledNumber;

    /**
     * While creating a Field the FieldNumber is already known, so it can be
     * stored while constructing the object.
     *
     * @param FiledNumber
     */
    public Field(int FiledNumber) {
        this.FiledNumber = FiledNumber;
    }

    /**
     *
     * @return The FieldNumber of this Field.
     */
    public int getFiledNumber() {
        return FiledNumber;
    }
}

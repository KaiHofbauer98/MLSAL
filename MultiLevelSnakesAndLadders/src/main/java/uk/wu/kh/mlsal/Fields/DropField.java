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
 * The DropField contains its connected field information in the
 * DropFieldNumber. When a ball is placed on a DropField it will be moved to the
 * Field with the DropFieldNumber.
 *
 * @author Kai Hofbauer
 */
public class DropField extends Field {

    /**
     * The number of the broadgame field which is connected to this Field.
     */
    private final int DropFieldNumber;

    /**
     * The information should be stored during the construction.
     *
     * @param DropFieldNumber
     * @param FiledNumber
     */
    public DropField(int DropFieldNumber, int FiledNumber) {
        super(FiledNumber);
        this.DropFieldNumber = DropFieldNumber;
    }

    /**
     *
     * @return The connected Field number (a standard Field).
     */
    public int getDropFieldNumber() {
        return DropFieldNumber;
    }
}

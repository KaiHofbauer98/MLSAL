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
package uk.wu.kh.mlsal.Maps;

import java.util.ArrayList;
import uk.wu.kh.mlsal.Fields.Field;

/**
 * This calss displays the boardgame map wich contains all fields in its range.
 * For this purpose we need to store all fields in a ArrayList and we need to
 * know how many fields the map has.
 *
 * @author Kai Hofbauer
 */
public class Map {

    /**
     *
     */
    private final int number_of_fields;

    /**
     * All field objects are stored in this ArrayList. It symbolizes the
     * boardgame map.
     */
    private ArrayList<Field> field_array = new ArrayList<>();

    /**
     * The final value of Field objects count can be stored at Object
     * construction.
     *
     * @param number_of_fields
     */
    public Map(int number_of_fields) {
        this.number_of_fields = number_of_fields;
    }

    /**
     *
     * @return Number of fields on the boardgame map.
     */
    public int getNumber_of_fields() {
        return number_of_fields;
    }

    /**
     *
     * @param field_array
     */
    public void setField_array(ArrayList<Field> field_array) {
        this.field_array = field_array;
    }

    /**
     *
     * @return The ArrayList containing all boardgame field objects.
     */
    public ArrayList<Field> getField_array() {
        return field_array;
    }

}

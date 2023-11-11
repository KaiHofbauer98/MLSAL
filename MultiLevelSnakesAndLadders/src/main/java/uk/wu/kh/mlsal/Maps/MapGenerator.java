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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.wu.kh.mlsal.Fields.DropField;
import uk.wu.kh.mlsal.Fields.Field;
import uk.wu.kh.mlsal.Fields.LadderField;

/**
 *
 * This class is used to fill up the ArrayList of the Map with the specific
 * field types of the boardgame. It simply iterates over a list of given static
 * entries from a properties file. If all Field objects out of the properties
 * file are created it searches for empty ranges between the overall amount of
 * Fields and fills them up with standard fields. After that it sorts the
 * ArrayList to a ArrayList with the FieldNumber matching the ArrayList Index.
 *
 * @see Map
 * @author Kai Hofbauer
 */
public class MapGenerator {

    /**
     * Contains the information needed to build the specific Field objects.
     *
     * @see DropField
     * @see LadderField
     */
    private static Properties properties;

    /**
     * Loads the default special field list out of the specified path.
     */
    public static void loadProperties() {
        try {
            properties = new Properties();
            properties.load(MapGenerator.class.getResourceAsStream("/MapProperties.properties"));
        } catch (IOException ex) {
            Logger.getLogger(MapGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * <p>
     * For each property found in the properties file, a new Field is generated
     * and added to the Map ArrayList. It Splits the notation in the properties
     * file and creates new objects wich are added to he map ArrayList.
     * </p>
     *
     * @param map
     * @see DropField
     * @see LadderField
     *
     */
    public static void generateSpecialFieldsFromProperties(Map map) {
        try {

            if (properties != null) {

                for (java.util.Map.Entry<Object, Object> entry : properties.entrySet()) {

                    if (entry.getKey().toString().contains("Ladders")) {
                        map.getField_array().add(new LadderField(Integer.parseInt(entry.getValue().toString().split("\\-")[1]),
                                Integer.parseInt(entry.getValue().toString().split("\\-")[0])));
                    } else {
                        if (entry.getKey().toString().contains("Drops")) {
                            map.getField_array().add(new DropField(Integer.parseInt(entry.getValue().toString().split("\\-")[1]),
                                    Integer.parseInt(entry.getValue().toString().split("\\-")[0])));
                        }
                    }
                }

                //The FieldNumbers of the existing fields gets stored in the intArray.
                ArrayList<Integer> intArray = new ArrayList<>();
                for (Object fld : map.getField_array()) {
                    intArray.add(((Field) fld).getFiledNumber());
                }

                //For every field that is NOT already generated and contained in the intArray, a standard Field
                //will be created at with the empty Field number.
                for (int i = 1; i <= map.getNumber_of_fields(); i++) {
                    if (!intArray.contains(i)) {
                        map.getField_array().add(new Field(i));
                    }
                }
                //Now all Fields are created!

                //All fields in the map ArrayList are searched for the lowest number to add them logically from 
                //1-100 to the new ArrayList to match the Index with the FieldNumber.
                ArrayList<Field> sorted_field_array = new ArrayList<>();
                for (int i = 1; i <= map.getNumber_of_fields(); i++) {
                    for (Field field : map.getField_array()) {
                        if (((Field) field).getFiledNumber() == i) {
                            sorted_field_array.add(field);
                        }
                    }

                }
                //The new sorted ArrayList list is being referenced to the maps ArrayList.
                map.setField_array(sorted_field_array);

            } else {
                throw new FileNotFoundException("Properties File not found!");
            }
        } catch (FileNotFoundException | NumberFormatException e) {
        }
    }

}

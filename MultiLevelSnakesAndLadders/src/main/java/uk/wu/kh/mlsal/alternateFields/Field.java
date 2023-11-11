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
package uk.wu.kh.mlsal.alternateFields;

/**
 * UPDATE! This Field class contains all needed information to create appropiate
 * field objects. I noticed this circumstance too late but my implementation is
 * bad with the two subclasses. In this Implementation all objects created are
 * the same class.
 *
 * I had the problem that I cant get the class of an object in a Object
 * ArrayList because its calss identity gets lost there. I could have given the
 * subcalsses of field and the field class a variable wich contains its own
 * class like: private Class fieldClass = class.getclass(); but this isnt the
 * best way to do it. I wrote this final Class of Field and for the purpose its
 * the best.
 *
 * UPDATE! THIS FILE IS DEPRECATED I was wrong with my calsses problem!
 * .getClass() will always deliver the right Classtype back! I used instanceof
 * and this was the problem! A instance of a Superclass will return the same as
 * the subclasses because they are all instances of the superclass!
 *
 * @deprecated
 * @author Kai Hofbauer
 */
public class Field {

    public final static int NO_CONNECTED_FIELD_NUMBER = -1;
    private final int FieldNumber;
    private final int ConnectedFieldNumber;
    private final FieldTypes FieldType;

    public Field(int FieldNumber, int ConnectedFieldNumber, FieldTypes FieldType) {
        this.FieldNumber = FieldNumber;
        this.ConnectedFieldNumber = ConnectedFieldNumber;
        this.FieldType = FieldType;
    }

    public Field(int FieldNumber, FieldTypes FieldType) {
        this.FieldNumber = FieldNumber;
        this.ConnectedFieldNumber = Field.NO_CONNECTED_FIELD_NUMBER;
        this.FieldType = FieldType;
    }

    public int getFieldNumber() {
        return FieldNumber;
    }

    public int getConnectedFieldNumber() {
        return ConnectedFieldNumber;
    }

    public FieldTypes getFieldType() {
        return FieldType;
    }

}

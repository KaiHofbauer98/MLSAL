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
package uk.wu.kh.mlsal.GUIs.Visualizer;

import javax.swing.JPanel;
import uk.wu.kh.mlsal.Fields.Field;

/**
 * This class connects a JPanel object with a Field object. It is a good way to
 * build the JPanel Graphical-Map in:
 *
 * @see GraphicFiledView
 * @author Kai Hofbauer
 */
public class GraphicField {

    private final Field field;
    private final JPanel jpanel;

    /**
     * The objects can be stored directly during construction. Nothing will be
     * changed, so the variables are finalized.
     * @param field
     * @param jpanel
     */
    public GraphicField(Field field, JPanel jpanel) {
        this.field = field;
        this.jpanel = jpanel;
    }

    /**
     *
     * @return The to the JPanel connected Field
     */
    public Field getField() {
        return field;
    }

    /**
     *
     * @return The to the Field connected JPanel
     */
    public JPanel getJpanel() {
        return jpanel;
    }

}

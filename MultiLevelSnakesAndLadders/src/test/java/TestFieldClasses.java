
import java.util.ArrayList;
import uk.wu.kh.mlsal.Fields.DropField;
import uk.wu.kh.mlsal.Fields.Field;
import uk.wu.kh.mlsal.Fields.LadderField;

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
 *
 * @author kai.hofbauer
 */
public class TestFieldClasses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Field field = new Field(1);
        Field field2 = new DropField(23, 2);
        Field field3 = new LadderField(33, 3);

        System.out.println(
                field.getClass() + "\n"
                + field2.getClass() + "\n"
                + field3.getClass()
        );

        ArrayList<Field> FieldArrLst = new ArrayList<>();

        FieldArrLst.add(field);
        FieldArrLst.add(field2);
        FieldArrLst.add(field3);

        for (Field fieldE : FieldArrLst) {
            System.out.println(fieldE.getClass());
        }

        System.out.println(
                FieldArrLst.get(0).getClass() + "\n"
                + FieldArrLst.get(1).getClass() + "\n"
                + FieldArrLst.get(2).getClass()
        );

    }

}

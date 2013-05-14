
package org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ElementType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ElementType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="RESISTOR"/>
 *     &lt;enumeration value="CAPACITOR"/>
 *     &lt;enumeration value="INDUCTOR"/>
 *     &lt;enumeration value="TRANSISTOR"/>
 *     &lt;enumeration value="DIODE"/>
 *     &lt;enumeration value="SWITCH"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ElementType")
@XmlEnum
public enum ElementType {

    RESISTOR,
    CAPACITOR,
    INDUCTOR,
    TRANSISTOR,
    DIODE,
    SWITCH;

    public String value() {
        return name();
    }

    public static ElementType fromValue(String v) {
        return valueOf(v);
    }

}


package org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RuleType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RuleType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="EXIST"/>
 *     &lt;enumeration value="ENABLED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RuleType")
@XmlEnum
public enum RuleType {

    EXIST,
    ENABLED;

    public String value() {
        return name();
    }

    public static RuleType fromValue(String v) {
        return valueOf(v);
    }

}

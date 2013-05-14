
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
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RuleType", namespace = "http://rules.jaxb.circuit.processor.core.taskexecuter.myeducation.org/")
@XmlEnum
public enum RuleType {

    EXIST;

    public String value() {
        return name();
    }

    public static RuleType fromValue(String v) {
        return valueOf(v);
    }

}

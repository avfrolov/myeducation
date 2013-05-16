
package org.myeducation.taskexecuter.core.processor.circuit.jaxb.rules;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ExistSubType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ExistSubType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NAME"/>
 *     &lt;enumeration value="COUNT"/>
 *     &lt;enumeration value="VALUE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ExistSubType")
@XmlEnum
public enum ExistSubType {

    NAME,
    COUNT,
    VALUE;

    public String value() {
        return name();
    }

    public static ExistSubType fromValue(String v) {
        return valueOf(v);
    }

}

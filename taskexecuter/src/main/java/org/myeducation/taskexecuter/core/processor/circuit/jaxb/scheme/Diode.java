//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.12 at 01:54:12 PM MSK 
//


package org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Diode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Diode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countOfInputs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxCurrent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxPotential" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Diode", propOrder = {
    "countOfInputs",
    "maxCurrent",
    "maxPotential"
})
public class Diode {

    @XmlElement(defaultValue = "2")
    protected int countOfInputs;
    @XmlElement(defaultValue = "0.0")
    protected double maxCurrent;
    @XmlElement(defaultValue = "0.0")
    protected double maxPotential;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the countOfInputs property.
     * 
     */
    public int getCountOfInputs() {
        return countOfInputs;
    }

    /**
     * Sets the value of the countOfInputs property.
     * 
     */
    public void setCountOfInputs(int value) {
        this.countOfInputs = value;
    }

    /**
     * Gets the value of the maxCurrent property.
     * 
     */
    public double getMaxCurrent() {
        return maxCurrent;
    }

    /**
     * Sets the value of the maxCurrent property.
     * 
     */
    public void setMaxCurrent(double value) {
        this.maxCurrent = value;
    }

    /**
     * Gets the value of the maxPotential property.
     * 
     */
    public double getMaxPotential() {
        return maxPotential;
    }

    /**
     * Sets the value of the maxPotential property.
     * 
     */
    public void setMaxPotential(double value) {
        this.maxPotential = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
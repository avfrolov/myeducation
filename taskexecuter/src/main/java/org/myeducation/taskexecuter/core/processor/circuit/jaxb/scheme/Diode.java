
package org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


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
public class Diode
    implements Equals, HashCode, ToString
{

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Diode)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Diode that = ((Diode) object);
        {
            int lhsCountOfInputs;
            lhsCountOfInputs = (true?this.getCountOfInputs(): 0);
            int rhsCountOfInputs;
            rhsCountOfInputs = (true?that.getCountOfInputs(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "countOfInputs", lhsCountOfInputs), LocatorUtils.property(thatLocator, "countOfInputs", rhsCountOfInputs), lhsCountOfInputs, rhsCountOfInputs)) {
                return false;
            }
        }
        {
            double lhsMaxCurrent;
            lhsMaxCurrent = (true?this.getMaxCurrent(): 0.0D);
            double rhsMaxCurrent;
            rhsMaxCurrent = (true?that.getMaxCurrent(): 0.0D);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "maxCurrent", lhsMaxCurrent), LocatorUtils.property(thatLocator, "maxCurrent", rhsMaxCurrent), lhsMaxCurrent, rhsMaxCurrent)) {
                return false;
            }
        }
        {
            double lhsMaxPotential;
            lhsMaxPotential = (true?this.getMaxPotential(): 0.0D);
            double rhsMaxPotential;
            rhsMaxPotential = (true?that.getMaxPotential(): 0.0D);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "maxPotential", lhsMaxPotential), LocatorUtils.property(thatLocator, "maxPotential", rhsMaxPotential), lhsMaxPotential, rhsMaxPotential)) {
                return false;
            }
        }
        {
            String lhsName;
            lhsName = this.getName();
            String rhsName;
            rhsName = that.getName();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "name", lhsName), LocatorUtils.property(thatLocator, "name", rhsName), lhsName, rhsName)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = 1;
        {
            int theCountOfInputs;
            theCountOfInputs = (true?this.getCountOfInputs(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "countOfInputs", theCountOfInputs), currentHashCode, theCountOfInputs);
        }
        {
            double theMaxCurrent;
            theMaxCurrent = (true?this.getMaxCurrent(): 0.0D);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "maxCurrent", theMaxCurrent), currentHashCode, theMaxCurrent);
        }
        {
            double theMaxPotential;
            theMaxPotential = (true?this.getMaxPotential(): 0.0D);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "maxPotential", theMaxPotential), currentHashCode, theMaxPotential);
        }
        {
            String theName;
            theName = this.getName();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "name", theName), currentHashCode, theName);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            int theCountOfInputs;
            theCountOfInputs = (true?this.getCountOfInputs(): 0);
            strategy.appendField(locator, this, "countOfInputs", buffer, theCountOfInputs);
        }
        {
            double theMaxCurrent;
            theMaxCurrent = (true?this.getMaxCurrent(): 0.0D);
            strategy.appendField(locator, this, "maxCurrent", buffer, theMaxCurrent);
        }
        {
            double theMaxPotential;
            theMaxPotential = (true?this.getMaxPotential(): 0.0D);
            strategy.appendField(locator, this, "maxPotential", buffer, theMaxPotential);
        }
        {
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        return buffer;
    }

}

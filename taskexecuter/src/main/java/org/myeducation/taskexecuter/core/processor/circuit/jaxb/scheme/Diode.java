
package org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *     &lt;extension base="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Element">
 *       &lt;sequence>
 *         &lt;element name="maxCurrent" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxPotential" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Diode", propOrder = {
    "maxCurrent",
    "maxPotential"
})
public class Diode
    extends Element
    implements Equals, HashCode, ToString
{

    @XmlElement(defaultValue = "0.0")
    protected double maxCurrent;
    @XmlElement(defaultValue = "0.0")
    protected double maxPotential;

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

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Diode)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final Diode that = ((Diode) object);
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
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
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
        super.appendFields(locator, buffer, strategy);
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
        return buffer;
    }

}

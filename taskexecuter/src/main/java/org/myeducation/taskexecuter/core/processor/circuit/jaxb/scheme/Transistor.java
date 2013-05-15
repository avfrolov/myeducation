
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
 * <p>Java class for Transistor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Transistor">
 *   &lt;complexContent>
 *     &lt;extension base="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Element">
 *       &lt;sequence>
 *         &lt;element name="gain" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transistor", propOrder = {
    "gain"
})
public class Transistor
    extends Element
    implements Equals, HashCode, ToString
{

    @XmlElement(defaultValue = "1")
    protected int gain;

    /**
     * Gets the value of the gain property.
     * 
     */
    public int getGain() {
        return gain;
    }

    /**
     * Sets the value of the gain property.
     * 
     */
    public void setGain(int value) {
        this.gain = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Transistor)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final Transistor that = ((Transistor) object);
        {
            int lhsGain;
            lhsGain = (true?this.getGain(): 0);
            int rhsGain;
            rhsGain = (true?that.getGain(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "gain", lhsGain), LocatorUtils.property(thatLocator, "gain", rhsGain), lhsGain, rhsGain)) {
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
            int theGain;
            theGain = (true?this.getGain(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "gain", theGain), currentHashCode, theGain);
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
            int theGain;
            theGain = (true?this.getGain(): 0);
            strategy.appendField(locator, this, "gain", buffer, theGain);
        }
        return buffer;
    }

}

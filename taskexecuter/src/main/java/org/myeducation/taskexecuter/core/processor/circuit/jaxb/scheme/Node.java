
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
 * <p>Java class for Node complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Node">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="elements" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Elements"/>
 *       &lt;/all>
 *       &lt;attribute name="from" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="to" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Node", propOrder = {

})
public class Node
    implements Equals, HashCode, ToString
{

    @XmlElement(required = true)
    protected Elements elements;
    @XmlAttribute(name = "from", required = true)
    protected int from;
    @XmlAttribute(name = "to", required = true)
    protected int to;

    /**
     * Gets the value of the elements property.
     * 
     * @return
     *     possible object is
     *     {@link Elements }
     *     
     */
    public Elements getElements() {
        return elements;
    }

    /**
     * Sets the value of the elements property.
     * 
     * @param value
     *     allowed object is
     *     {@link Elements }
     *     
     */
    public void setElements(Elements value) {
        this.elements = value;
    }

    /**
     * Gets the value of the from property.
     * 
     */
    public int getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     */
    public void setFrom(int value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     */
    public int getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     */
    public void setTo(int value) {
        this.to = value;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Node)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Node that = ((Node) object);
        {
            Elements lhsElements;
            lhsElements = this.getElements();
            Elements rhsElements;
            rhsElements = that.getElements();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "elements", lhsElements), LocatorUtils.property(thatLocator, "elements", rhsElements), lhsElements, rhsElements)) {
                return false;
            }
        }
        {
            int lhsFrom;
            lhsFrom = (true?this.getFrom(): 0);
            int rhsFrom;
            rhsFrom = (true?that.getFrom(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "from", lhsFrom), LocatorUtils.property(thatLocator, "from", rhsFrom), lhsFrom, rhsFrom)) {
                return false;
            }
        }
        {
            int lhsTo;
            lhsTo = (true?this.getTo(): 0);
            int rhsTo;
            rhsTo = (true?that.getTo(): 0);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "to", lhsTo), LocatorUtils.property(thatLocator, "to", rhsTo), lhsTo, rhsTo)) {
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
            Elements theElements;
            theElements = this.getElements();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "elements", theElements), currentHashCode, theElements);
        }
        {
            int theFrom;
            theFrom = (true?this.getFrom(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "from", theFrom), currentHashCode, theFrom);
        }
        {
            int theTo;
            theTo = (true?this.getTo(): 0);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "to", theTo), currentHashCode, theTo);
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
            Elements theElements;
            theElements = this.getElements();
            strategy.appendField(locator, this, "elements", buffer, theElements);
        }
        {
            int theFrom;
            theFrom = (true?this.getFrom(): 0);
            strategy.appendField(locator, this, "from", buffer, theFrom);
        }
        {
            int theTo;
            theTo = (true?this.getTo(): 0);
            strategy.appendField(locator, this, "to", buffer, theTo);
        }
        return buffer;
    }

}

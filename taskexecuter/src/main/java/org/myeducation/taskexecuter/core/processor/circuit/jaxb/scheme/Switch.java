
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
 * <p>Java class for Switch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Switch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="countOfInputs" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="position" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "Switch", propOrder = {
    "countOfInputs",
    "position"
})
public class Switch
    implements Equals, HashCode, ToString
{

    @XmlElement(defaultValue = "2")
    protected int countOfInputs;
    @XmlElement(defaultValue = "true")
    protected boolean position;
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
     * Gets the value of the position property.
     * 
     */
    public boolean isPosition() {
        return position;
    }

    /**
     * Sets the value of the position property.
     * 
     */
    public void setPosition(boolean value) {
        this.position = value;
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
        if (!(object instanceof Switch)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Switch that = ((Switch) object);
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
            boolean lhsPosition;
            lhsPosition = (true?this.isPosition():false);
            boolean rhsPosition;
            rhsPosition = (true?that.isPosition():false);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "position", lhsPosition), LocatorUtils.property(thatLocator, "position", rhsPosition), lhsPosition, rhsPosition)) {
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
            boolean thePosition;
            thePosition = (true?this.isPosition():false);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "position", thePosition), currentHashCode, thePosition);
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
            boolean thePosition;
            thePosition = (true?this.isPosition():false);
            strategy.appendField(locator, this, "position", buffer, thePosition);
        }
        {
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        return buffer;
    }

}


package org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme;

import java.util.ArrayList;
import java.util.List;
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
 * <p>Java class for Elements complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Elements">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="resistor" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Resistor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="capacitor" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Capacitor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="inductor" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Inductor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="transistor" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Transistor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="diode" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Diode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="switch" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Switch" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Elements", propOrder = {
    "resistor",
    "capacitor",
    "inductor",
    "transistor",
    "diode",
    "_switch"
})
public class Elements
    implements Equals, HashCode, ToString
{

    protected List<Resistor> resistor;
    protected List<Capacitor> capacitor;
    protected List<Inductor> inductor;
    protected List<Transistor> transistor;
    protected List<Diode> diode;
    @XmlElement(name = "switch")
    protected List<Switch> _switch;

    /**
     * Gets the value of the resistor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resistor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResistor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Resistor }
     * 
     * 
     */
    public List<Resistor> getResistor() {
        if (resistor == null) {
            resistor = new ArrayList<Resistor>();
        }
        return this.resistor;
    }

    /**
     * Gets the value of the capacitor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the capacitor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCapacitor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Capacitor }
     * 
     * 
     */
    public List<Capacitor> getCapacitor() {
        if (capacitor == null) {
            capacitor = new ArrayList<Capacitor>();
        }
        return this.capacitor;
    }

    /**
     * Gets the value of the inductor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inductor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInductor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Inductor }
     * 
     * 
     */
    public List<Inductor> getInductor() {
        if (inductor == null) {
            inductor = new ArrayList<Inductor>();
        }
        return this.inductor;
    }

    /**
     * Gets the value of the transistor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transistor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransistor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transistor }
     * 
     * 
     */
    public List<Transistor> getTransistor() {
        if (transistor == null) {
            transistor = new ArrayList<Transistor>();
        }
        return this.transistor;
    }

    /**
     * Gets the value of the diode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the diode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Diode }
     * 
     * 
     */
    public List<Diode> getDiode() {
        if (diode == null) {
            diode = new ArrayList<Diode>();
        }
        return this.diode;
    }

    /**
     * Gets the value of the switch property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the switch property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSwitch().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Switch }
     * 
     * 
     */
    public List<Switch> getSwitch() {
        if (_switch == null) {
            _switch = new ArrayList<Switch>();
        }
        return this._switch;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof Elements)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final Elements that = ((Elements) object);
        {
            List<Resistor> lhsResistor;
            lhsResistor = (((this.resistor!= null)&&(!this.resistor.isEmpty()))?this.getResistor():null);
            List<Resistor> rhsResistor;
            rhsResistor = (((that.resistor!= null)&&(!that.resistor.isEmpty()))?that.getResistor():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resistor", lhsResistor), LocatorUtils.property(thatLocator, "resistor", rhsResistor), lhsResistor, rhsResistor)) {
                return false;
            }
        }
        {
            List<Capacitor> lhsCapacitor;
            lhsCapacitor = (((this.capacitor!= null)&&(!this.capacitor.isEmpty()))?this.getCapacitor():null);
            List<Capacitor> rhsCapacitor;
            rhsCapacitor = (((that.capacitor!= null)&&(!that.capacitor.isEmpty()))?that.getCapacitor():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "capacitor", lhsCapacitor), LocatorUtils.property(thatLocator, "capacitor", rhsCapacitor), lhsCapacitor, rhsCapacitor)) {
                return false;
            }
        }
        {
            List<Inductor> lhsInductor;
            lhsInductor = (((this.inductor!= null)&&(!this.inductor.isEmpty()))?this.getInductor():null);
            List<Inductor> rhsInductor;
            rhsInductor = (((that.inductor!= null)&&(!that.inductor.isEmpty()))?that.getInductor():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "inductor", lhsInductor), LocatorUtils.property(thatLocator, "inductor", rhsInductor), lhsInductor, rhsInductor)) {
                return false;
            }
        }
        {
            List<Transistor> lhsTransistor;
            lhsTransistor = (((this.transistor!= null)&&(!this.transistor.isEmpty()))?this.getTransistor():null);
            List<Transistor> rhsTransistor;
            rhsTransistor = (((that.transistor!= null)&&(!that.transistor.isEmpty()))?that.getTransistor():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transistor", lhsTransistor), LocatorUtils.property(thatLocator, "transistor", rhsTransistor), lhsTransistor, rhsTransistor)) {
                return false;
            }
        }
        {
            List<Diode> lhsDiode;
            lhsDiode = (((this.diode!= null)&&(!this.diode.isEmpty()))?this.getDiode():null);
            List<Diode> rhsDiode;
            rhsDiode = (((that.diode!= null)&&(!that.diode.isEmpty()))?that.getDiode():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "diode", lhsDiode), LocatorUtils.property(thatLocator, "diode", rhsDiode), lhsDiode, rhsDiode)) {
                return false;
            }
        }
        {
            List<Switch> lhsSwitch;
            lhsSwitch = (((this._switch!= null)&&(!this._switch.isEmpty()))?this.getSwitch():null);
            List<Switch> rhsSwitch;
            rhsSwitch = (((that._switch!= null)&&(!that._switch.isEmpty()))?that.getSwitch():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "_switch", lhsSwitch), LocatorUtils.property(thatLocator, "_switch", rhsSwitch), lhsSwitch, rhsSwitch)) {
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
            List<Resistor> theResistor;
            theResistor = (((this.resistor!= null)&&(!this.resistor.isEmpty()))?this.getResistor():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resistor", theResistor), currentHashCode, theResistor);
        }
        {
            List<Capacitor> theCapacitor;
            theCapacitor = (((this.capacitor!= null)&&(!this.capacitor.isEmpty()))?this.getCapacitor():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "capacitor", theCapacitor), currentHashCode, theCapacitor);
        }
        {
            List<Inductor> theInductor;
            theInductor = (((this.inductor!= null)&&(!this.inductor.isEmpty()))?this.getInductor():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inductor", theInductor), currentHashCode, theInductor);
        }
        {
            List<Transistor> theTransistor;
            theTransistor = (((this.transistor!= null)&&(!this.transistor.isEmpty()))?this.getTransistor():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transistor", theTransistor), currentHashCode, theTransistor);
        }
        {
            List<Diode> theDiode;
            theDiode = (((this.diode!= null)&&(!this.diode.isEmpty()))?this.getDiode():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "diode", theDiode), currentHashCode, theDiode);
        }
        {
            List<Switch> theSwitch;
            theSwitch = (((this._switch!= null)&&(!this._switch.isEmpty()))?this.getSwitch():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "_switch", theSwitch), currentHashCode, theSwitch);
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
            List<Resistor> theResistor;
            theResistor = (((this.resistor!= null)&&(!this.resistor.isEmpty()))?this.getResistor():null);
            strategy.appendField(locator, this, "resistor", buffer, theResistor);
        }
        {
            List<Capacitor> theCapacitor;
            theCapacitor = (((this.capacitor!= null)&&(!this.capacitor.isEmpty()))?this.getCapacitor():null);
            strategy.appendField(locator, this, "capacitor", buffer, theCapacitor);
        }
        {
            List<Inductor> theInductor;
            theInductor = (((this.inductor!= null)&&(!this.inductor.isEmpty()))?this.getInductor():null);
            strategy.appendField(locator, this, "inductor", buffer, theInductor);
        }
        {
            List<Transistor> theTransistor;
            theTransistor = (((this.transistor!= null)&&(!this.transistor.isEmpty()))?this.getTransistor():null);
            strategy.appendField(locator, this, "transistor", buffer, theTransistor);
        }
        {
            List<Diode> theDiode;
            theDiode = (((this.diode!= null)&&(!this.diode.isEmpty()))?this.getDiode():null);
            strategy.appendField(locator, this, "diode", buffer, theDiode);
        }
        {
            List<Switch> theSwitch;
            theSwitch = (((this._switch!= null)&&(!this._switch.isEmpty()))?this.getSwitch():null);
            strategy.appendField(locator, this, "_switch", buffer, theSwitch);
        }
        return buffer;
    }

}

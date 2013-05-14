
package org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="resistors" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Resistor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="capacitors" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Capacitor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="inductors" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Inductor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="transistors" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Transistor" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="diodes" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Diode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="switches" type="{http://scheme.jaxb.circuit.processor.core.taskexecuter.myeducation.org/}Switch" maxOccurs="unbounded" minOccurs="0"/>
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
    "resistors",
    "capacitors",
    "inductors",
    "transistors",
    "diodes",
    "switches"
})
public class Elements
    implements Equals, HashCode, ToString
{

    protected List<Resistor> resistors;
    protected List<Capacitor> capacitors;
    protected List<Inductor> inductors;
    protected List<Transistor> transistors;
    protected List<Diode> diodes;
    protected List<Switch> switches;

    /**
     * Gets the value of the resistors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the resistors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResistors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Resistor }
     * 
     * 
     */
    public List<Resistor> getResistors() {
        if (resistors == null) {
            resistors = new ArrayList<Resistor>();
        }
        return this.resistors;
    }

    /**
     * Gets the value of the capacitors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the capacitors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCapacitors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Capacitor }
     * 
     * 
     */
    public List<Capacitor> getCapacitors() {
        if (capacitors == null) {
            capacitors = new ArrayList<Capacitor>();
        }
        return this.capacitors;
    }

    /**
     * Gets the value of the inductors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inductors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInductors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Inductor }
     * 
     * 
     */
    public List<Inductor> getInductors() {
        if (inductors == null) {
            inductors = new ArrayList<Inductor>();
        }
        return this.inductors;
    }

    /**
     * Gets the value of the transistors property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transistors property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransistors().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transistor }
     * 
     * 
     */
    public List<Transistor> getTransistors() {
        if (transistors == null) {
            transistors = new ArrayList<Transistor>();
        }
        return this.transistors;
    }

    /**
     * Gets the value of the diodes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the diodes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiodes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Diode }
     * 
     * 
     */
    public List<Diode> getDiodes() {
        if (diodes == null) {
            diodes = new ArrayList<Diode>();
        }
        return this.diodes;
    }

    /**
     * Gets the value of the switches property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the switches property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSwitches().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Switch }
     * 
     * 
     */
    public List<Switch> getSwitches() {
        if (switches == null) {
            switches = new ArrayList<Switch>();
        }
        return this.switches;
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
            List<Resistor> lhsResistors;
            lhsResistors = (((this.resistors!= null)&&(!this.resistors.isEmpty()))?this.getResistors():null);
            List<Resistor> rhsResistors;
            rhsResistors = (((that.resistors!= null)&&(!that.resistors.isEmpty()))?that.getResistors():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "resistors", lhsResistors), LocatorUtils.property(thatLocator, "resistors", rhsResistors), lhsResistors, rhsResistors)) {
                return false;
            }
        }
        {
            List<Capacitor> lhsCapacitors;
            lhsCapacitors = (((this.capacitors!= null)&&(!this.capacitors.isEmpty()))?this.getCapacitors():null);
            List<Capacitor> rhsCapacitors;
            rhsCapacitors = (((that.capacitors!= null)&&(!that.capacitors.isEmpty()))?that.getCapacitors():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "capacitors", lhsCapacitors), LocatorUtils.property(thatLocator, "capacitors", rhsCapacitors), lhsCapacitors, rhsCapacitors)) {
                return false;
            }
        }
        {
            List<Inductor> lhsInductors;
            lhsInductors = (((this.inductors!= null)&&(!this.inductors.isEmpty()))?this.getInductors():null);
            List<Inductor> rhsInductors;
            rhsInductors = (((that.inductors!= null)&&(!that.inductors.isEmpty()))?that.getInductors():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "inductors", lhsInductors), LocatorUtils.property(thatLocator, "inductors", rhsInductors), lhsInductors, rhsInductors)) {
                return false;
            }
        }
        {
            List<Transistor> lhsTransistors;
            lhsTransistors = (((this.transistors!= null)&&(!this.transistors.isEmpty()))?this.getTransistors():null);
            List<Transistor> rhsTransistors;
            rhsTransistors = (((that.transistors!= null)&&(!that.transistors.isEmpty()))?that.getTransistors():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "transistors", lhsTransistors), LocatorUtils.property(thatLocator, "transistors", rhsTransistors), lhsTransistors, rhsTransistors)) {
                return false;
            }
        }
        {
            List<Diode> lhsDiodes;
            lhsDiodes = (((this.diodes!= null)&&(!this.diodes.isEmpty()))?this.getDiodes():null);
            List<Diode> rhsDiodes;
            rhsDiodes = (((that.diodes!= null)&&(!that.diodes.isEmpty()))?that.getDiodes():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "diodes", lhsDiodes), LocatorUtils.property(thatLocator, "diodes", rhsDiodes), lhsDiodes, rhsDiodes)) {
                return false;
            }
        }
        {
            List<Switch> lhsSwitches;
            lhsSwitches = (((this.switches!= null)&&(!this.switches.isEmpty()))?this.getSwitches():null);
            List<Switch> rhsSwitches;
            rhsSwitches = (((that.switches!= null)&&(!that.switches.isEmpty()))?that.getSwitches():null);
            if (!strategy.equals(LocatorUtils.property(thisLocator, "switches", lhsSwitches), LocatorUtils.property(thatLocator, "switches", rhsSwitches), lhsSwitches, rhsSwitches)) {
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
            List<Resistor> theResistors;
            theResistors = (((this.resistors!= null)&&(!this.resistors.isEmpty()))?this.getResistors():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "resistors", theResistors), currentHashCode, theResistors);
        }
        {
            List<Capacitor> theCapacitors;
            theCapacitors = (((this.capacitors!= null)&&(!this.capacitors.isEmpty()))?this.getCapacitors():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "capacitors", theCapacitors), currentHashCode, theCapacitors);
        }
        {
            List<Inductor> theInductors;
            theInductors = (((this.inductors!= null)&&(!this.inductors.isEmpty()))?this.getInductors():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "inductors", theInductors), currentHashCode, theInductors);
        }
        {
            List<Transistor> theTransistors;
            theTransistors = (((this.transistors!= null)&&(!this.transistors.isEmpty()))?this.getTransistors():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "transistors", theTransistors), currentHashCode, theTransistors);
        }
        {
            List<Diode> theDiodes;
            theDiodes = (((this.diodes!= null)&&(!this.diodes.isEmpty()))?this.getDiodes():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "diodes", theDiodes), currentHashCode, theDiodes);
        }
        {
            List<Switch> theSwitches;
            theSwitches = (((this.switches!= null)&&(!this.switches.isEmpty()))?this.getSwitches():null);
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "switches", theSwitches), currentHashCode, theSwitches);
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
            List<Resistor> theResistors;
            theResistors = (((this.resistors!= null)&&(!this.resistors.isEmpty()))?this.getResistors():null);
            strategy.appendField(locator, this, "resistors", buffer, theResistors);
        }
        {
            List<Capacitor> theCapacitors;
            theCapacitors = (((this.capacitors!= null)&&(!this.capacitors.isEmpty()))?this.getCapacitors():null);
            strategy.appendField(locator, this, "capacitors", buffer, theCapacitors);
        }
        {
            List<Inductor> theInductors;
            theInductors = (((this.inductors!= null)&&(!this.inductors.isEmpty()))?this.getInductors():null);
            strategy.appendField(locator, this, "inductors", buffer, theInductors);
        }
        {
            List<Transistor> theTransistors;
            theTransistors = (((this.transistors!= null)&&(!this.transistors.isEmpty()))?this.getTransistors():null);
            strategy.appendField(locator, this, "transistors", buffer, theTransistors);
        }
        {
            List<Diode> theDiodes;
            theDiodes = (((this.diodes!= null)&&(!this.diodes.isEmpty()))?this.getDiodes():null);
            strategy.appendField(locator, this, "diodes", buffer, theDiodes);
        }
        {
            List<Switch> theSwitches;
            theSwitches = (((this.switches!= null)&&(!this.switches.isEmpty()))?this.getSwitches():null);
            strategy.appendField(locator, this, "switches", buffer, theSwitches);
        }
        return buffer;
    }

}

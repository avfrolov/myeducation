package org.myeducation.taskexecuter.core.processor.circuit.validator.required;

import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Circuit;
import org.myeducation.taskexecuter.core.processor.circuit.jaxb.scheme.Node;
import org.myeducation.taskexecuter.core.processor.circuit.validator.CircuitValidator;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: andrey
 * Date: 12.05.13
 * Time: 20:20
 * To change this template use File | Settings | File Templates.
 */
public class NodeValidator implements CircuitValidator {

    @Override
    public boolean validate(Circuit circuit) {

        if (!validateNoDuplicate(circuit)) {
            return false;
        }

        for (Node n1 : circuit.getNode()) {
            int from = n1.getFrom();
            int to = n1.getTo();
            Node n2 = getByIndexes(circuit.getNode(), to, from);
            if (n2 != null && !n1.getElements().equals(n2.getElements())) {
                return false;
            }
        }
        return true;
    }

    private Node getByIndexes(List<Node> nodes, int from, int to) {
        for (Node node : nodes) {
            if (node.getFrom() == from && node.getTo() == to) {
                return node;
            }
        }
        return null;
    }

    private boolean validateNoDuplicate(Circuit circuit) {
        for (int i = 0; i < circuit.getNode().size() - 1; i++) {
            for (int j = i + 1; j < circuit.getNode().size(); j++) {
                if (circuit.getNode().get(i).getFrom() == circuit.getNode().get(j).getFrom() &&
                        circuit.getNode().get(i).getTo() == circuit.getNode().get(j).getTo()) {
                    return false;
                }
            }
        }

        return true;
    }

}

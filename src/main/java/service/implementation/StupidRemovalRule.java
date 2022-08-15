package service.implementation;

import enumeration.OperationType;
import service.declaration.WriterRule;

import java.util.Arrays;

public class StupidRemovalRule implements WriterRule {

    private static final OperationType operationType = OperationType.DESTUPIFY;
    @Override
    public String fireRule(String target) {
        if (target == null || target.length() == 0) {
            return "";
        }
        if (target.contains("stupid")) {
            target = target.replace("stupid", "s*****");
        }
        return target;
    }

    @Override
    public boolean isSelected(OperationType... operationTypes) {
        return Arrays.asList(operationTypes).contains(operationType);
    }
}

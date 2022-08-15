package service.implementation;

import enumeration.OperationType;
import service.declaration.WriterRule;

import java.util.Arrays;

public class LowerCaseRule implements WriterRule {

    private static final OperationType operationType = OperationType.LOWERCASE;
    @Override
    public String fireRule(String target) {
        if (target == null || target.length() == 0) {
            return "";
        }
        return target.toLowerCase();
    }

    @Override
    public boolean isSelected(OperationType... operationTypes) {
        return Arrays.asList(operationTypes).contains(operationType);
    }
}

package service.implementation;

import enumeration.OperationType;
import service.declaration.WriterRule;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class DuplicateRemovalRule implements WriterRule {

    private static final OperationType operationType = OperationType.DEDUPLICATE;
    @Override
    public String fireRule(String target) {
        if (target == null || target.length() == 0) {
            return "";
        }
        String[] words = target.split(" ");
        LinkedHashSet<String> nonRepeatedWords = new LinkedHashSet<>(Arrays.asList(words));
        StringBuilder result = new StringBuilder();
        for (String word : nonRepeatedWords) {
            result.append(word).append(" ");
        }
        return result.toString().trim();
    }

    @Override
    public boolean isSelected(OperationType... operationTypes) {
        return Arrays.asList(operationTypes).contains(operationType);
    }
}

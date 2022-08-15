package service.declaration;

import enumeration.OperationType;

public interface WriterRule {
    String fireRule(String target);

    boolean isSelected(OperationType... operationTypes);
}

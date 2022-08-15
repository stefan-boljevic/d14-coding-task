package producer;

import enumeration.OperationType;
import service.declaration.WriterRule;
import service.implementation.DuplicateRemovalRule;
import service.implementation.LowerCaseRule;
import service.implementation.StupidRemovalRule;
import service.implementation.UpperCaseRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RulesFactory {
    private static List<WriterRule> allRules = new ArrayList<>();

    static {
        allRules.add(new LowerCaseRule());
        allRules.add(new UpperCaseRule());
        allRules.add(new DuplicateRemovalRule());
        allRules.add(new StupidRemovalRule());
    }

    public static List<WriterRule> getRules(OperationType... types) {
        return allRules.stream().filter(rule -> rule.isSelected(types)).collect(Collectors.toList());
    }
}

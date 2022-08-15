package service.implementation;

import enumeration.OperationType;
import producer.RulesFactory;
import service.declaration.Writer;
import service.declaration.WriterRule;

import java.util.LinkedList;
import java.util.List;

public class StringWriter implements Writer {
    private boolean closed = false;
    private String information = "";

    private List<WriterRule> rules = new LinkedList<>();


    public StringWriter(OperationType... operationTypes) {
        this.rules = RulesFactory.getRules(operationTypes);
    }

    @Override
    public void write(String input) {
        if (closed) {
            return;
        }
        for (WriterRule writerRule : this.rules) {
            input = writerRule.fireRule(input);
        }
        this.information += input;
    }

    @Override
    public String readWrittenInputs() {
        return this.information;
    }

    @Override
    public void close() {
        this.closed = true;
    }
}

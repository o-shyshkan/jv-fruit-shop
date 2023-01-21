package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseLineService;
import java.util.List;
import java.util.stream.Collectors;

public class ParseLineImpl implements ParseLineService {
    public static final byte INDEX_OPERATION = 0;
    public static final byte INDEX_FRUIT = 1;
    public static final byte INDEX_QUANTITY = 2;
    public static final String SEPARATOR_SYMBOL = ",";

    @Override
    public List<FruitTransaction> getFruitTransaction(List<String> listLines) {
        return listLines.stream()
                .map(s -> new FruitTransaction(FruitTransaction.Operation
                        .getOperationByValue(s.split(SEPARATOR_SYMBOL)[INDEX_OPERATION]),
                         s.split(SEPARATOR_SYMBOL)[INDEX_FRUIT],
                        Integer.parseInt(s.split(SEPARATOR_SYMBOL)[INDEX_QUANTITY])))
                .collect(Collectors.toList());
    }
}

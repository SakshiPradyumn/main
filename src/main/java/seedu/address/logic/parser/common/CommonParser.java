package seedu.address.logic.parser.common;

import seedu.address.logic.commands.Command;
import seedu.address.logic.parser.PageParser;
import seedu.address.logic.parser.exceptions.ParseException;

public class CommonParser implements PageParser {
    @Override
    public Command parse(String command, String arguments) throws ParseException {
        throw new ParseException(getClass().getSimpleName() + " parser not implemented yet.");
    }
}

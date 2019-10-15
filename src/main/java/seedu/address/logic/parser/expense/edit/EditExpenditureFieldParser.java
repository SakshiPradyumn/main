package seedu.address.logic.parser.expense.edit;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.expenditure.edit.EditExpenditureFieldCommand;
import seedu.address.logic.parser.*;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.parser.itinerary.ItineraryParserUtil;

import java.util.Optional;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;

/**
 * Placeholder javadoc.
 */
public class EditExpenditureFieldParser implements Parser<EditExpenditureFieldCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditDayFieldCommand
     * and returns an EditDayFieldCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditExpenditureFieldCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args,
                        PREFIX_NAME,
                        PREFIX_BUDGET,
                        PREFIX_INDEX);

        Optional<Index> index;

        try {
            index = Optional.ofNullable(ParserUtil.parseIndex(argMultimap.getPreamble()));
        } catch (ParseException pe) {
            index = Optional.empty();
            //throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
            //        EditTripFieldCommand.MESSAGE_USAGE), pe);
        }

        if (!index.isEmpty()) {
            //edit by field specified by index only
            throw new UnsupportedOperationException("Parsing edit expenditure by index not yet supported.");

        }
        //edit by prefixes
        EditExpenditureFieldCommand.EditExpenditureDescriptor editExpenditureDescriptor =
                new EditExpenditureFieldCommand.EditExpenditureDescriptor();

        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            editExpenditureDescriptor.setName(ItineraryParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get()));
        }
        if (argMultimap.getValue(PREFIX_BUDGET).isPresent()) {
            editExpenditureDescriptor.setBudget(
                    ItineraryParserUtil.parseBudget(argMultimap.getValue(PREFIX_BUDGET).get()));
        }
        if (!editExpenditureDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditExpenditureFieldCommand.MESSAGE_NOT_EDITED);
        }

        return new EditExpenditureFieldCommand(editExpenditureDescriptor);
    }

}

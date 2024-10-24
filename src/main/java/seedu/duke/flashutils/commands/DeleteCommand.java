package seedu.duke.flashutils.commands;

import seedu.duke.flashutils.types.Card;
import seedu.duke.flashutils.types.FlashCardSet;
import seedu.duke.flashutils.utils.Storage;

/**
 * Removes flashcard from flashcard set.
 */
public class DeleteCommand extends Command {
    // Confirmation message to be displayed to user, with placeholder for flashcard details
    public static final String SUCCESS_MESSAGE = "Successfully deleted flashcard: %1$s";
    private Card targetCard;
    private FlashCardSet targetSet;

    public DeleteCommand(FlashCardSet module, int cardIndex) {
        targetSet = module;
        targetCard = targetSet.getCard(cardIndex);
    }

    public FlashCardSet getTargetSet() {
        return targetSet;
    }

    public Card getTargetCard() {
        return targetCard;
    }

    @Override
    public CommandResult execute(Storage storage) {
        targetSet.removeCard(targetCard);
        return new CommandResult(String.format(SUCCESS_MESSAGE, targetCard));
    }
}

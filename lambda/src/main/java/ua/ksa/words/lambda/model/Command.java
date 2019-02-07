package ua.ksa.words.lambda.model;

public interface Command {
    CommandResponse execute(CommandRequest request);
}

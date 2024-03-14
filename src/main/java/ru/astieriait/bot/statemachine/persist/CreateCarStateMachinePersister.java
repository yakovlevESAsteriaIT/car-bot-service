package ru.astieriait.bot.statemachine.persist;

import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import ru.astieriait.bot.statemachine.constant.CreateCarEvent;
import ru.astieriait.bot.statemachine.constant.CreateCarState;

import java.util.HashMap;

public class CreateCarStateMachinePersister implements StateMachinePersist<CreateCarState, CreateCarEvent, String> {

    private final HashMap<String, StateMachineContext<CreateCarState, CreateCarEvent>> contexts = new HashMap<>();

    @Override
    public void write(final StateMachineContext<CreateCarState, CreateCarEvent> context, final String contextObj) {
        contexts.put(contextObj, context);
    }

    @Override
    public StateMachineContext<CreateCarState, CreateCarEvent> read(final String contextObj) {
        return contexts.get(contextObj);
    }
}

package ru.astieriait.bot.statemachine.action;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;
import ru.astieriait.bot.statemachine.constant.CreateCarEvent;
import ru.astieriait.bot.statemachine.constant.CreateCarState;

@Component
public class CarBotFinishAction implements Action<CreateCarState, CreateCarEvent> {
    @Override
    public void execute(StateContext<CreateCarState, CreateCarEvent> stateContext) {

    }
}

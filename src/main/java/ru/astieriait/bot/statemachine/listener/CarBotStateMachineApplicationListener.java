package ru.astieriait.bot.statemachine.listener;

import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;
import ru.astieriait.bot.statemachine.constant.CreateCarEvent;
import ru.astieriait.bot.statemachine.constant.CreateCarState;

public class CarBotStateMachineApplicationListener implements StateMachineListener<CreateCarState, CreateCarEvent> {
    @Override
    public void stateChanged(final State<CreateCarState, CreateCarEvent> from, final State<CreateCarState, CreateCarEvent> to) {
        if (from.getId() != null) {
            System.out.println("Переход из статуса " + from.getId() + " в статус " + to.getId());
        }
    }

    @Override
    public void stateEntered(final State<CreateCarState, CreateCarEvent> state) {

    }

    @Override
    public void stateExited(final State<CreateCarState, CreateCarEvent> state) {

    }

    @Override
    public void eventNotAccepted(final Message<CreateCarEvent> event) {
        System.out.println("Евент не принят " + event);
    }

    @Override
    public void transition(final Transition<CreateCarState, CreateCarEvent> transition) {

    }

    @Override
    public void transitionStarted(final Transition<CreateCarState, CreateCarEvent> transition) {

    }

    @Override
    public void transitionEnded(final Transition<CreateCarState, CreateCarEvent> transition) {

    }

    @Override
    public void stateMachineStarted(final StateMachine<CreateCarState, CreateCarEvent> stateMachine) {
        System.out.println("Machine started");
    }

    @Override
    public void stateMachineStopped(final StateMachine<CreateCarState, CreateCarEvent> stateMachine) {

    }

    @Override
    public void stateMachineError(final StateMachine<CreateCarState, CreateCarEvent> stateMachine, Exception exception) {
    }

    @Override
    public void extendedStateChanged(final Object key, final Object value) {

    }

    @Override
    public void stateContext(final StateContext<CreateCarState, CreateCarEvent> stateContext) {

    }
}

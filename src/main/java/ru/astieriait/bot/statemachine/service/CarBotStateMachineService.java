package ru.astieriait.bot.statemachine.service;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Service;
import ru.astieriait.bot.statemachine.constant.CreateCarEvent;
import ru.astieriait.bot.statemachine.constant.CreateCarState;

@Service
public class CarBotStateMachineService {

    private final StateMachinePersister<CreateCarState, CreateCarEvent, String> persister;

    private final StateMachineFactory<CreateCarState, CreateCarEvent> stateMachineFactory;

    public CarBotStateMachineService(
            StateMachinePersister<CreateCarState, CreateCarEvent, String> persister,
            StateMachineFactory<CreateCarState, CreateCarEvent> stateMachineFactory
    ) {
        this.persister = persister;
        this.stateMachineFactory = stateMachineFactory;
    }


    public boolean inputModel(String userId, String model) {
        final StateMachine<CreateCarState, CreateCarEvent> stateMachine = stateMachineFactory.getStateMachine();
        stateMachine.getExtendedState().getVariables().put("model", model);
        stateMachine.sendEvent(CreateCarEvent.INPUT_MODEL);
        try {
            persister.persist(stateMachine, userId);
        } catch (final Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean start(String userId) {
        final StateMachine<CreateCarState, CreateCarEvent> stateMachine = stateMachineFactory.getStateMachine();
        try {
            persister.persist(stateMachine, userId);
        } catch (final Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

//
//    public boolean cancelReserve(final String userId) {
//        final StateMachine<CreateCarState, CreateCarEvent> stateMachine = stateMachineFactory.getStateMachine();
//        try {
//            persister.restore(stateMachine, userId);
//            stateMachine.sendEvent(RESERVE_DECLINE);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//
//    public boolean buy(final String userId) {
//        final StateMachine<CreateCarState, CreateCarEvent> stateMachine = stateMachineFactory.getStateMachine();
//        try {
//            persister.restore(stateMachine, userId);
//            stateMachine.sendEvent(BUY);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
}

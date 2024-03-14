package ru.astieriait.bot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;
import ru.astieriait.bot.statemachine.action.*;
import ru.astieriait.bot.statemachine.constant.CreateCarEvent;
import ru.astieriait.bot.statemachine.constant.CreateCarState;
import ru.astieriait.bot.statemachine.listener.CarBotStateMachineApplicationListener;
import ru.astieriait.bot.statemachine.persist.CreateCarStateMachinePersister;

import java.util.EnumSet;

@Configuration
@EnableStateMachineFactory
public class CarBotStateMachineConfig extends EnumStateMachineConfigurerAdapter<CreateCarState, CreateCarEvent> {
    @Autowired
    private CarBotInputModelAction carBotInputModelAction;
    @Autowired
    private CarBotInputBrandAction carBotInputBrandAction;
    @Autowired
    private CarBotInputPriceAction carBotInputPriceAction;
    @Autowired
    private CarBotFinishAction carBotFinishAction;
    @Autowired
    private ErrorAction errorAction;

    @Override
    public void configure(final StateMachineConfigurationConfigurer<CreateCarState, CreateCarEvent> config) throws Exception {
        config
                .withConfiguration()
                .autoStartup(true)
                .listener(new CarBotStateMachineApplicationListener());
    }

    @Override
    public void configure(final StateMachineStateConfigurer<CreateCarState, CreateCarEvent> states) throws Exception {
        states
                .withStates()
                .initial(CreateCarState.START)
                .end(CreateCarState.FINISH)
                .states(EnumSet.allOf(CreateCarState.class));

    }

    @Override
    public void configure(final StateMachineTransitionConfigurer<CreateCarState, CreateCarEvent> transitions) throws Exception {
        transitions
                .withExternal()
                .source(CreateCarState.START)
                .target(CreateCarState.INPUT_BRAND)
                .event(CreateCarEvent.INPUT_BRAND)
                .action(carBotInputBrandAction, errorAction)

                .and()
                .withExternal()
                .source(CreateCarState.INPUT_BRAND)
                .target(CreateCarState.INPUT_MODEL)
                .event(CreateCarEvent.INPUT_MODEL)
                .action(carBotInputModelAction, errorAction)

                .and()
                .withExternal()
                .source(CreateCarState.INPUT_MODEL)
                .target(CreateCarState.INPUT_PRICE)
                .event(CreateCarEvent.INPUT_PRICE)
                .action(carBotInputPriceAction, errorAction)

                .and()
                .withExternal()
                .source(CreateCarState.INPUT_PRICE)
                .target(CreateCarState.FINISH)
                .event(CreateCarEvent.FINISH)
                .action(carBotFinishAction, errorAction);
    }

    @Bean
    public StateMachinePersister<CreateCarState, CreateCarEvent, String> persister() {
        return new DefaultStateMachinePersister<>(new CreateCarStateMachinePersister());
    }
}

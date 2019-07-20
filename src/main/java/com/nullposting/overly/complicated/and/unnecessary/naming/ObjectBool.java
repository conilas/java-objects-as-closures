package com.nullposting.overly.complicated.and.unnecessary.naming;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

//okay so what this dumb fuck does is wrap the value in one curried function
// the name of it is new for obvious reasons that I dont have to explain lol
public class ObjectBool {

    private final Function<Optional<Boolean>, Boolean> value;
    final Getter<Boolean> getValue;
    final Setter<Boolean> setValue;

    public ObjectBool(Boolean bool){
        value = _new(false);
        getValue = _get(value);
        setValue = _set(value);
    }

    //sorry to lazy to type all that Optional bullshit
    private <T> Optional<T> opt(T t) {return Optional.of(t);}
    private Optional noopt() {return Optional.empty();}

    private Function<Optional<Boolean>, Boolean> _new(Boolean defaultValue){
        final AtomicBoolean state = new AtomicBoolean(defaultValue);

        //yup this is def a joke lmao
        final Function<Boolean, Boolean> imsorry = (x) -> {
            state.set(x);
            return x;
        };

        return (Optional<Boolean> newValue) -> newValue.map(imsorry).orElse(state.get());
    }

    private Getter<Boolean> _get(Function<Optional<Boolean>, Boolean> object) {
        return () -> object.apply(noopt());
    }

    private Setter<Boolean> _set(Function<Optional<Boolean>, Boolean> object) {
        return (Boolean bool) -> object.apply(opt(bool));
    }

}

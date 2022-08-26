package test;

import org.junit.Before;
import org.junit.Test;
import states.*;

import static org.junit.Assert.*;

public class StateTest {
    State state;

    @Before
    public void setUp(){
        state = new StateNormal();
    }

    @Test
    public void test_state_normal_toString(){
        assertEquals("NORMAL", state.toString());
    }

    @Test
    public void test_state_critical_toString(){
        state = new StateCritical();
        assertEquals("CRITICAL", state.toString());
    }
    @Test
    public void test_state_low_toString(){
        state = new StateLow();
        assertEquals("LOW", state.toString());
    }

    @Test
    public void test_state_high_toString(){
        state = new StateHigh();
        assertEquals("HIGH", state.toString());
    }



}

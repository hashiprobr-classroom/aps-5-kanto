package br.edu.insper.desagil.aps5.insee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AgendaTest {
    Agenda agenda;
    @BeforeEach
    void setUp(){
        agenda=new Agenda();
    }

    @Test
    void constroi(){
        assertTrue(agenda.getEventos().isEmpty());
    }

    @Test
    void adicinaValido(){
        Evento evento = mock(Evento.class);
        when(evento.valido()).thenReturn(true);
        agenda.adiciona(evento);
        assertEquals(1,agenda.getEventos().size());
        assertSame(evento,agenda.getEventos().get(0));
    }

    @Test
    void adicinaInvalido(){
        Evento evento = mock(Evento.class);
        when(evento.valido()).thenReturn(false);
        assertThrows(IllegalArgumentException.class,()-> {
            agenda.adiciona(evento);
        });
    }

}

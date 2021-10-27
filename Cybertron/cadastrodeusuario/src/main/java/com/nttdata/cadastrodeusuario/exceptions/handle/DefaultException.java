package com.vyttor.cadastrocontas.exceptions.handle;

import lombok.Data;

import java.time.LocalTime;

@Data
public class DefaultException {
    private String msg;
    private LocalTime dataHora;
}

package com.urvin.paint;

import com.urvin.paint.command.CreateCanvas;
import com.urvin.paint.command.DrawLine;
import com.urvin.paint.command.IPaintCommand;
import com.urvin.paint.exception.BaseException;
import com.urvin.paint.tool.Canvas;
import com.urvin.paint.tool.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.Mockito;
import org.mockito.exceptions.base.MockitoException;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConsolePaintTest {

    @Test
    void startDrawingSuccess() throws BaseException {
        ConsolePaint consolePaint = Mockito.mock(ConsolePaint.class);
        String strCommand = "C 5 5";
        consolePaint.startDrawing(strCommand);
        verify(consolePaint,times(1)).startDrawing(strCommand);
    }
}
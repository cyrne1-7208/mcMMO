package com.gmail.nossr50.listeners;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Method;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.junit.jupiter.api.Test;

class BlockListenerCancellationTest {

    @Test
    void onBlockPlaceShouldIgnoreCancelledEvents() throws NoSuchMethodException {
        // Given - the onBlockPlace event listener method
        final Method method = BlockListener.class.getMethod("onBlockPlace", BlockPlaceEvent.class);

        // When - reading the EventHandler annotation
        final EventHandler eventHandler = method.getAnnotation(EventHandler.class);

        // Then - ignoreCancelled must be true so cancelled block placements do not mark blocks as unnatural
        assertThat(eventHandler).isNotNull();
        assertThat(eventHandler.ignoreCancelled())
                .as("onBlockPlace must ignore cancelled events to prevent marking cancelled placements as unnatural")
                .isTrue();
    }
}

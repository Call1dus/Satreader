package com.sean.satcounter;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public class SatCounterClient implements ClientModInitializer {
    public static final String MOD_ID = "satcounter";

    @Override
    public void onInitializeClient() {
        HudElementRegistry.attachElementAfter(
                VanillaHudElements.HOTBAR,
                Identifier.of(MOD_ID, "saturation_counter"),
                SatCounterClient::render
        );
    }

    private static void render(GuiGraphics graphics, DeltaTracker deltaTracker) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc == null || mc.player == null || mc.options.hudHidden) return;

        PlayerEntity player = mc.player;

        float saturation = player.getHungerManager().getSaturationLevel();
        if (saturation < 0.0f) saturation = 0.0f;

        int food = player.getHungerManager().getFoodLevel();

        String text = String.format("Food: %d  Sat: %.1f", food, saturation);

        int screenW = mc.getWindow().getScaledWidth();
        int screenH = mc.getWindow().getScaledHeight();

        int pad = 8;
        int x = screenW - mc.textRenderer.getWidth(text) - pad;
        int y = screenH - 58;

        graphics.drawText(mc.textRenderer, text, x, y, 0xFFFFFF, true);
    }
}

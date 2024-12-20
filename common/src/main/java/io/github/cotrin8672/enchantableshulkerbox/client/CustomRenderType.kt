package io.github.cotrin8672.enchantableshulkerbox.client

import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexFormat
import net.minecraft.client.render.VertexFormats
import net.minecraft.client.render.item.ItemRenderer

class CustomRenderType private constructor(
    pName: String,
    pFormat: VertexFormat,
    pMode: VertexFormat.DrawMode,
    pBufferSize: Int,
    pAffectsCrumbling: Boolean,
    pSortOnUpload: Boolean,
    pSetupState: Runnable,
    pClearState: Runnable,
) :
    RenderLayer(pName, pFormat, pMode, pBufferSize, pAffectsCrumbling, pSortOnUpload, pSetupState, pClearState) {
    init {
        throw UnsupportedOperationException()
    }

    companion object {
        private val CUSTOM_POLYGON_OFFSET_LAYERING = Layering(
            "polygon_offset_layering", {
                RenderSystem.polygonOffset(-0.25f, -10.0f)
                RenderSystem.enablePolygonOffset()
            }, {
                RenderSystem.polygonOffset(0.0f, 0.0f)
                RenderSystem.disablePolygonOffset()
            }
        )

        @JvmStatic
        val GLINT: RenderLayer = of(
            "glint",
            VertexFormats.POSITION_TEXTURE,
            VertexFormat.DrawMode.QUADS,
            1536,
            false,
            false,
            MultiPhaseParameters.builder()
                .program(GLINT_PROGRAM)
                .texture(Texture(ItemRenderer.ITEM_ENCHANTMENT_GLINT, true, false))
                .writeMaskState(COLOR_MASK)
                .cull(DISABLE_CULLING)
                .depthTest(LEQUAL_DEPTH_TEST)
                .transparency(GLINT_TRANSPARENCY)
                .texturing(GLINT_TEXTURING)
                .layering(CUSTOM_POLYGON_OFFSET_LAYERING)
                .build(false)
        )
    }
}

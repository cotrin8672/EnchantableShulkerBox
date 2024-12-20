package io.github.cotrin8672.enchantableshulkerbox.client

import com.mojang.blaze3d.systems.RenderSystem
import net.minecraft.client.render.RenderLayer
import net.minecraft.client.render.VertexFormat
import net.minecraft.client.render.VertexFormats
import net.minecraft.client.render.item.ItemRenderer

/*
MIT License

Copyright (c) 2024 Mrbysco

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

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

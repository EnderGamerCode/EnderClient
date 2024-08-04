package de.endergamer.gui

import de.endergamer.EnderClient
import de.endergamer.gui.Variables.Companion.currentCategory
import de.endergamer.utils.font.Fonts
import de.endergamer.utils.font.MinecraftFontRenderer
import gg.essential.elementa.ElementaVersion
import gg.essential.elementa.UIConstraints
import gg.essential.elementa.WindowScreen
import gg.essential.elementa.components.*
import gg.essential.elementa.dsl.*
import gg.essential.elementa.effects.OutlineEffect
import gg.essential.elementa.svg.data.plus
import gg.essential.universal.UMatrixStack
import java.awt.Color
import java.net.URL

class ConfigMain : WindowScreen(ElementaVersion.V1) {

    val outlineThicknessBackground = 1f
    val outlineThicknessButton = 1f

    var mainButton: UIBlock? = null;
    var dungButton: UIBlock? = null;
    var background: UIBlock? = null;

    var mainHovering = false;
    var dungHovering = false;

    init {
        Fonts.bootstrap()
        background = UIBlock(Color(30,30,30)).constrain {
            width = (window.getWidth()/ 1.2).pixel
            height = (window.getHeight() / 1.2).pixel
            x = (window.getWidth()/2).pixels - width/2
            y = (window.getHeight()/2).pixels - height/2

        } effect OutlineEffect(Color(15,15,15),outlineThicknessBackground,true,false) childOf window

        mainButton = UIBlock(Color(30,30,30)).constrain{
            width = 80.pixels
            height = 30.pixels
            x = 120.pixel
            y = 5.pixel
            if(currentCategory == "main") {
                color = Color(65, 65, 65).toConstraint()
            }
        }effect(OutlineEffect(Color(15,15,15),outlineThicknessButton,true,false))  childOf background!!
        mainButton!!.onMouseEnter {
            if (currentCategory != "main") {
                setColor(Color(55, 55, 55))
            }
            mainHovering = true;
        }
        mainButton!!.onMouseLeave {
            if (currentCategory != "main") {
                    setColor(Color(30, 30, 30))
            }
            mainHovering =false
        }
        mainButton!!.onMouseClick {
            if(currentCategory != "main") {
                currentCategory="main"
                setColor(Color(65, 65, 65))
            }
        }

        dungButton = UIBlock(Color(30,30,30)).constrain{
            width = 80.pixels
            height = 30.pixels
            x = 220.pixel
            y = 5.pixel
            if(currentCategory == "dung"){
                color = Color(65,65,65).toConstraint()
            }
        }effect(OutlineEffect(Color(15,15,15),outlineThicknessButton,true,false))  childOf background!!
        dungButton!!.onMouseEnter {
            dungHovering = true;
            if(currentCategory != "dung"){
                setColor(Color(55,55,55))
            }
        }
        dungButton!!.onMouseLeave {
            if(currentCategory != "dung"){
                setColor(Color(30,30,30))
            }
            dungHovering = false;
        }
        dungButton!!.onMouseClick {
            if(currentCategory != "dung"){
                currentCategory="dung"
                setColor(Color(65,65,65))
            }
        }

        val line1 = UIBlock(Color(50,50,50)).constrain {
            width = (background!!.getWidth()-10).pixels
            height = 0.8.pixel
            x = 5.pixel
            y = 40.pixel
        } childOf background!!
        val line2 = UIBlock(Color(50,50,50)).constrain {
            width = 0.8.pixel
            height = (background!!.getHeight()-10).pixels
            x = 100.pixel
            y = 5.pixel
        } childOf background!!

    }

    var mainCons = mainButton!!.constraints
    var dungCons = dungButton!!.constraints

    override fun onDrawScreen(matrixStack: UMatrixStack, mouseX: Int, mouseY: Int, partialTicks: Float) {
        super.onDrawScreen(matrixStack, mouseX, mouseY, partialTicks)
        Fonts.superFont.drawSmoothCenteredStringWithShadow("ENDER",60f,35f,Color.white.rgb)
        Fonts.superFont.drawSmoothCenteredStringWithShadow("CLIENT",70f,50f,Color.white.rgb)
        Fonts.fontBig.drawSmoothString("v"+EnderClient.VERSION.toString(),63f+(Fonts.superFont.getStringWidth("ENDER")).toFloat(), 37f,Color.white.rgb)
        Fonts.dinofans.drawSmoothCenteredString("MAIN", mainCons.getX()+(mainButton!!.getWidth()/2), 1+mainCons.getY()+(mainButton!!.getHeight()/2-Fonts.dinofansSmall.height/2).toFloat(),Color.cyan.rgb)
        Fonts.dinofansSmall.drawSmoothString("DUNGEONS", dungCons.getX()+(dungButton!!.getWidth()/2-Fonts.dinofansSmall.getStringWidth("DUNGEONS")/2).toFloat(), 1+dungCons.getY()+(dungButton!!.getHeight()/2-Fonts.dinofansSmall.height/2).toFloat(),Color.white.rgb)
        if(!dungHovering) dungButton!!.setColor(Color(30,30,30))

    }
}
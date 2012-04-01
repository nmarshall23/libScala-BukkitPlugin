package com.gmail.nmarshall23.demo

import org.bukkit.block.Block
import org.bukkit.block.Sign
import org.bukkit.block.BlockFace
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.EventHandler
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.Material
import org.bukkit.Server
import org.bukkit.ChatColor

class ListenerHandler(plugin:DemoPlugin) extends Listener {

  
  
  
  @EventHandler 
  def getSignPlacement(event:PlayerInteractEvent) : Unit = event match {
  
  	case event if event.isCancelled() => Unit  
  	case event if event.hasBlock() == false => Unit
  	case event if event.getAction() != Action.RIGHT_CLICK_BLOCK => Unit
  	case event if event.getClickedBlock().getType() != Material.WALL_SIGN => Unit
  	case event => signPlacement(event.getClickedBlock())
  	
  }
  
  def signPlacement(b:Block) : Unit = {
    
    plugin.getServer().broadcastMessage("Sign Clicked!")
    var sign =b.getState().asInstanceOf[Sign]
    
    val line = ChatColor.DARK_RED + sign.getLine(0)
    sign.setLine(0,line)
    
    
    
    // I know there is a better way.
    plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, 
        new Runnable() { def run() = { sign.update() } }, 1 )
    
  }
 
  //Found at
  //http://stackoverflow.com/questions/3073677/implicit-conversion-to-runnable
  //Still learning Scala, not sure how to pass a closure
  implicit def runnable(f: () => Unit): Runnable = new Runnable() { def run() = f() }
  

}




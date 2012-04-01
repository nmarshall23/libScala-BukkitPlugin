package com.gmail.nmarshall23.demo

import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin
import java.util.logging.Logger

class DemoPlugin extends JavaPlugin {
  var log: Logger = null
  
  override def onEnable : Unit = {
      log = Logger.getLogger("Minecraft")
	  val pm = this.getServer().getPluginManager()
	  pm.registerEvents(new ListenerHandler(this), this)
	  
	  //log.info("Scala Enabled!")
  }
	
  override def onDisable : Unit = {
	  
  }

}
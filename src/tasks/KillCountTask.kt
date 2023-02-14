package tasks

import configuration.Configuration
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Players

class KillCountTask(
    private val config: Configuration
) : BaseTask() {
    override fun shouldExcecute(): Boolean {
        // should only run when inside gwd, and killcount is less than 40
        return Inventory.stream().count().toInt() != 28 &&
                Inventory.stream().name(config.foodName).isNotEmpty()
    }

    // Your dodgy necklace protects you. it has X charges left

    override fun run() {
        // within this task, we should check location, move to GWD or move to correct location to get KC
        // then kill fastest mob for KC until KC number is reached
        // move to door and end task for boss task to take over

//        when(true) {
//            Constants.insideBankArea.contains(Players.local().tile()) -> leaveBank()
//            Constants.insideHouseContainsPlayer() -> pickPocket()
//            Constants.outsideBankArea.contains(Players.local().tile()) -> enterHouse()
//            Constants.outsideHouseArea.contains(Npcs.stream().name(Constants.bitch).nearest().first()) -> hopWorlds()
//            // bitch outside - hop
//            else -> walkToHouse()
//        }
    }
}
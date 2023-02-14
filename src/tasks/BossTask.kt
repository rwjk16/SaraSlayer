package tasks

import configuration.Configuration
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Players

class BossTask(
    private val config: Configuration
) : BaseTask() {
    // should only run after 40 kc is reached, and is stading outside boss room OR when inside boss room
    override fun shouldExcecute(): Boolean {
        // if has food, and dodgy necklaces if desired
        return Inventory.stream().count().toInt() != 28 &&
                Inventory.stream().name(config.foodName).isNotEmpty()
    }

    override fun run() {
        // this will be root node for boss branch
        // here we will check if we must pot up and enter
        // start fight
        // or continue to fight - ie move to corner or attack, eat etc. EAT TASK IS FOR EMERGENCY, COULD SHARE GTFO TELE
        // also handle minions // looting? - this could be a seperate task aswell

        // during fight we:
        // check if we are in the corner, if yes update the corner to next corner and wait for sara to approach
        // if no, we attack sara, then move towards the corner
        // en route to corner we should at some point try to attack again, either using the tile as a threshold, or
        // trying to count the ticks of our weapon to attack only when capable of doing so

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
package tasks

import configuration.Configuration
import Constants
import org.powbot.api.Condition
import org.powbot.api.rt4.*
import org.powbot.mobile.script.ScriptManager
import java.awt.event.MouseEvent
import java.util.concurrent.ThreadLocalRandom

class BankingTask(
    private val config: Configuration
): BaseTask() {

    override fun shouldExcecute(): Boolean {
        return (Inventory.stream().name(config.foodName).isEmpty() || Inventory.stream().count().toInt() == 28)
    }

    override fun run() {
        // should check if bank is in viewable distance, if yes open bank and get items, else move to bank
//        if (Constants.insideBankArea.contains(Players.local())) {
//            moveToBankTile()
//            if (Bank.open() || Bank.opened()) {
//                withdrawItems()
//            }
//        } else {
//            // walk from the house to the bank
//            moveToBank()
//        }
    }

    private fun moveToBank() {
        // we neet to decide where the default bank location is
//        when(true) {
//            Constants.insideHouseContainsPlayer() -> leaveHouse()
//            Constants.insideBankArea.contains(Players.local()) -> moveToBankTile()
//            else -> goOutSideBank()
//        }
    }

    private fun moveToBankTile() {
//        Movement.step(Constants.westernBankTil)
//        Constants.waitUntilCloseEnough(5)
//        if (!Bank.inViewport()) {
//            Camera.turnTo(Bank.nearest())
//        }
    }

    private fun goOutSideBank() {
//        Camera.turnTo(Objects.stream().name(Constants.mausoleumDoor).first())
//        if (Objects.stream().name(Constants.mausoleumDoor).first().inViewport()) {
//            Objects.stream().name(Constants.mausoleumDoor).first().interact(Constants.enter)
//            Condition.wait { Constants.insideBankArea.contains(Players.local()) }
//        } else {
//            Movement.step(Constants.outsideBankArea.randomTile)
//            Constants.waitUntilCloseEnough(10)
//        }
    }

    private fun withdrawItems() {

        // here we will need to withdraw more pots, or equipment if not equipped

//        if (Constants.insideBankArea.contains(Players.local())) {
//            Bank.depositInventory()
//            if (Bank.withdraw(config.foodName, config.foodCount)) {
//                if (config.useDodgyNecklace && Bank.stream().name(Constants.dodgyNecklace).count() > 0) {
//                    if (Bank.withdraw(Constants.dodgyNecklace, config.dodgyNecklaceCount)) {
//                        if (Equipment.stream().name(Constants.dodgyNecklace).isEmpty()) {
//                            if (Inventory.stream().name(Constants.dodgyNecklace).first().interact(Constants.equip)) {
//                                if (Inventory.stream().name(Constants.dodgyNecklace).count() < config.dodgyNecklaceCount) {
//                                    Bank.withdraw(Constants.dodgyNecklace,
//                                        config.dodgyNecklaceCount - Inventory.stream().name(Constants.dodgyNecklace).count().toInt())
//                                }
//                            }
//                        }
//                    }
//                }
//            } else {
//                ScriptManager.stop()
//            }
//            Bank.close()
//            return
//        }
    }
}
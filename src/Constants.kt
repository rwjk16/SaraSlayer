import org.powbot.api.Condition
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Players

public class Constants {

    companion object {
        const val equip: String = "Wear"
        const val eat: String = "Eat"
        const val drink: String = "Drink"
        const val coinPouch: String = "Coin pouch"
        const val openAll = "Open-all"
        const val open = "Open"
        const val close = "Close"
        const val door = "Door"
        const val climbUp = "Climb-up"
        const val stairs = "Stairs"
        const val enter = "Enter"

        fun waitUntilCloseEnough(distance: Int,
                                 freq: Int = 150,
                                 tries: Int = 10) {
            Condition.wait({ Players.local().tile().distanceTo(Movement.destination()) <= distance}, freq, tries)
        }
    }
}
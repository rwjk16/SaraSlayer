import configuration.Configuration
import org.powbot.api.*
import org.powbot.api.QuickHuller.hull
import org.powbot.api.event.RenderEvent
import org.powbot.api.rt4.*
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.*
import org.powbot.api.script.paint.PaintBuilder
import org.powbot.api.script.paint.TrackInventoryOption
import org.powbot.mobile.script.ScriptManager
import tasks.BankingTask
import tasks.BaseTask
import tasks.BossTask
import tasks.KillCountTask

fun main(args: Array<String>) {
    val task = SaraSlayer()
    task.startScript()
}

@ScriptManifest(
    name = "SaraSlayer",
    description = "Kills dumb bitch for her shit",
    version = "0.0.1",
    category = ScriptCategory.MoneyMaking
)

@ScriptConfiguration.List(
    [
        ScriptConfiguration(
            name = "Food Threshold",
            description = "Pick amount of hp to eat at",
            defaultValue = "50",
            optionType = OptionType.INTEGER
        ),

        ScriptConfiguration(
            name = "Food",
            description = "Pick type of food to eat",
            allowedValues = ["Jug of wine", "Cake", "Monkfish"],
            defaultValue = "Jug of wine"
        ),

        ScriptConfiguration(
            name = "Food Amount",
            description = "Pick amount of food to bring",
            defaultValue = "16",
            optionType = OptionType.INTEGER
        ),

        ScriptConfiguration(
            name = "Sack Amount",
            description = "Pick amount of pouched to open",
            defaultValue = "26",
            optionType = OptionType.INTEGER,
        ),

        ScriptConfiguration(
            name = "Necklace",
            description = "Use Dodgy necklace?",
            defaultValue = "true",
            optionType = OptionType.BOOLEAN,
        ),

        ScriptConfiguration(
            name = "Necklace Amount",
            description = "Pick amount of dodgy necklaces to bring",
            defaultValue = "2",
            optionType = OptionType.INTEGER,
        ),

        ScriptConfiguration(
            name = "Veil",
            description = "use Shadow Veil? (47 magic + Arceuus spellbook)",
            defaultValue = "true",
            optionType = OptionType.BOOLEAN,
        ),
    ]
)

class SaraSlayer : AbstractScript() {
    private val taskList: ArrayList<BaseTask> = ArrayList()
    private var foodName: String = ""
    private var useTabs: Boolean = true

    override fun onStart() {
        super.onStart()

        foodName = getOption("Food Name")
        useTabs = getOption("Use Tabs")

        // here we should add banking task, movement task, eat task, attack task.

//        handlePaint()
        // stop if not within ok areas, ie default bank, or gwd
//        if (IN GOOD AREAS) {
        if (foodName != null && useTabs != null) {
            val config = Configuration(
                useTabs!!,
                foodName!!
            )

            val bankingTask = BankingTask(config)
            val killCountTask = KillCountTask(config)
            val bossTask = BossTask(config)

            taskList.add(bankingTask)
            taskList.add(killCountTask)
            taskList.add(bossTask)
        }
//        } else {
//            ScriptManager.stop()
//        }
    }

    override fun poll() {
        for (task in taskList) {
            if (task.shouldExcecute()) {
                task.run()
                if (ScriptManager.isStopping()) {
                    break
                }
            }
        }
    }

//    @ValueChanged("Necklace") // this method is used to update menu items if another is selected. ie show an option if
//    another is enabled

//    fun necklaceValueUpdated(updatedValue: Boolean) {
//        updateVisibility("Necklace Amount", updatedValue)
//    }
//
//    private fun handlePaint() {
//        val paint = PaintBuilder.newBuilder()
//            .trackSkill(Skill.Thieving)
//            .trackInventoryItems(
//                Constants.bloodRuneID,
//                Constants.bloodShardID,
//                Constants.cutDiamondID,
//                Constants.uncutRubyID,
//                Constants.deathRuneID,
//                Constants.coinsID)
//            .withTotalLoot(true)
//            .withoutDiscordWebhook()
//            .build()
//        addPaint(paint)
//    }
//
//    private fun getPoints(area: Area): ArrayList<Point> {
//        val points = ArrayList<Point>()
//        for (t in area.tiles) {
//            for ((i, x) in t.matrix().bounds().xpoints.withIndex()) {
//                val p = t.matrix().bounds()
//                points.add(Point(x, p.ypoints[i]))
//            }
//        }
//        return points
//    }

//    @com.google.common.eventbus.Subscribe // to draw for debug if necesarry
//    fun onRender(r: RenderEvent) {
//        val g = r.graphics
//        g.setScale(1.0f)
//        g.drawPolygon(hull(getPoints(Constants.insideHouseArea1)))
//        g.drawPolygon(hull(getPoints(Constants.insideHouseArea2)))
//        g.drawPolygon(hull(getPoints(Constants.outsideHouseArea)))
//    }
}